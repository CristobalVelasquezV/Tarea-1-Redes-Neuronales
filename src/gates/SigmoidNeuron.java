package gates;

public class SigmoidNeuron {

	/**
	 * @author cristobal
	 * Clase SigmoidNeuron, recibe cantidad de ints que representan los pesos.
	 * atributos 
	 * b: bias o threshold del SigmoidNeuron
	 * n: numero de inputs del SigmoidNeuron
	 * w: lista de pesos del SigmoidNeuron
	 */ 


		private final double c ;
		private double b;
		private int n;
		private double[] w;
		
		public SigmoidNeuron(double learingRate,int bias,int ...weight){
			int counter;
			c=learingRate;
			b=bias;
			counter=weight.length;
			w=new double[counter];
			counter = 0;
			for (int arg : weight) {		
				w[counter]=arg;
				counter++;
			}
			n=counter;
		}
		public double outputSigmoid(int ...inputs){
			double ret;
			if(inputs.length==n){
				
				double total=0;
				int i=0;
				for (int inp : inputs) {	
					total+=w[i]*inp;
					i++;
				}
				ret=1/(1+Math.pow(Math.E,-(total+b)));
				return ret;
				}
				else{
					System.out.println("Distinto numero de inputs y pesos.");
					return 0;
				}
		}
		
		public void learnSigmoid(int ...values){
			int[] inputs=new int[n];
			int counter = 0;
			for (int val : values) {
				if(counter<n){
				inputs[counter]=val;
				}
				counter++;
			}
			
			if(this.outputSigmoid(inputs)>0.5 && values[counter-1]==0){
				//System.out.println("modificar pesos negativamente");
				for (int i=0;i<n;i++) {	
					w[i]=w[i]-c*(inputs[i]);
					//System.out.println("peso " + Integer.toString(i)+"= " + Double.toString(w[i]));
					
				}
			}
			
			else if(values[counter-1]==1 &&this.outputSigmoid(inputs)<=0.5){
				//System.out.println("modificar pesos positivamente");
				for (int i=0;i<n;i++) {	
					w[i]=w[i]+c*(inputs[i]);
					//System.out.println("peso " + Integer.toString(i)+"= " + Double.toString(w[i]));
				}
			}
		}
}
