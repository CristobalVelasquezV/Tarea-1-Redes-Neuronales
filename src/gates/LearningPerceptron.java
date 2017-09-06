package gates;

public class LearningPerceptron {


	
	/**
	 * @author cristobal
	 * Clase perceptron, recibe cantidad de ints que representan los pesos.
	 * atributos 
	 * b: bias o threshold del perceptron
	 * n: numero de inputs del perceptron
	 * w: lista de pesos del perceptron
	 */ 


		private final double c =0.01;
		private int b;
		private int n;
		private double[] w;
		
		public LearningPerceptron(int bias,int ...weight){
			int counter;
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
		public int output(int ...inputs){
			if(inputs.length==n){
			int ret;
			int total=0;
			int i=0;
			for (int inp : inputs) {	
				total+=w[i]*inp;
				i++;
			}
			if(total+b>0){
				ret=1;
			}
			else{
				ret=0;
			}
			return ret;
			}
			else{
				System.out.println("Distinto numero de inputs y pesos.");
				return 0;
			}
			
			
		}
		
		public void learn(int ...values){
			int[] inputs=new int[n];
			int counter = 0;
			for (int val : values) {
				if(counter<n){
				inputs[counter]=val;
				}
				counter++;
			}
			
			if(this.output(inputs)==1 && values[counter-1]==0){
				//System.out.println("modificar pesos negativamente");
				for (int i=0;i<n;i++) {	
					w[i]=w[i]-c*(inputs[i]);
					System.out.println("peso " + Integer.toString(i)+"= " + Double.toString(w[i]));
					
				}
			}
			
			else if(values[counter-1]==1 &&this.output(inputs)==0){
				//System.out.println("modificar pesos positivamente");
				for (int i=0;i<n;i++) {	
					w[i]=w[i]+c*(inputs[i]);
					System.out.println("peso " + Integer.toString(i)+"= " + Double.toString(w[i]));
				}
			}
		}
		
		public void show(){
			for (double val : w) {
				System.out.println(val);
			}
		}
				
		
		
	

}
