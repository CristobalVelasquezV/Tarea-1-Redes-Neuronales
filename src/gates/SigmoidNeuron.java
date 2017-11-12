package gates;

public class SigmoidNeuron extends GenericNeuron {

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
		
		private double error = 0;
		private double delta = 0;
		private double output = -1;
		private double[] lastinput;
		

		public SigmoidNeuron(double learingRate,double bias,double ...weight){
			int counter;
			c=learingRate;
			b=bias;
			counter=weight.length;
			w=new double[counter];
			counter = 0;
			for (double arg : weight) {		
				w[counter]=arg;
				counter++;
			}
			n=counter;
		}
		public double output(double ...inputs){
			double ret;
			if(inputs.length==n){
				
				double total=0;
				int i=0;
				for (double inp : inputs) {	
					total+=w[i]*inp;
					i++;
				}
				ret=1/(1+Math.pow(Math.E,-(total+b)));
				//su propio output:
				this.changeOutput(ret);
				return ret;
				}
				else{
					System.out.println("Distinto numero de inputs y pesos.");
					System.out.println("Input:" + Integer.toString(inputs.length));
					System.out.println("w:" + Integer.toString(w.length));
					
					return 0;
				}
			
		}
		
		public void learn(double ...values){
			double[] inputs=new double[n];
			int counter = 0;
			for (double val : values) {
				if(counter<n){
				inputs[counter]=val;
				}
				counter++;
			}
			
			if(this.output(inputs)>0.5 && values[counter-1]==0){
				//System.out.println("modificar pesos negativamente");
				for (int i=0;i<n;i++) {	
					w[i]=w[i]-c*(inputs[i]);
					//System.out.println("peso " + Integer.toString(i)+"= " + Double.toString(w[i]));
					
				}
			}
			
			else if(values[counter-1]==1 &&this.output(inputs)<=0.5){
				//System.out.println("modificar pesos positivamente");
				for (int i=0;i<n;i++) {	
					w[i]=w[i]+c*(inputs[i]);
					//System.out.println("peso " + Integer.toString(i)+"= " + Double.toString(w[i]));
				}
			}
		}
		@Override
		void changeError(double e) {
			error=e;
		}
		@Override
		void changeDelta(double d) {
			delta=d;
		}
		@Override
		public void changeOutput(double o) {
			output=o;
		}
		@Override
		double getLastOutput() {
			return output;
		}
		@Override
		double getDelta() {
			return delta;
		}
		@Override
		double returnError(int i) {
			return w[i]*delta;
		}
		@Override
		void changeWeight(int i) {
			w[i]=w[i]+(c*delta*lastinput[i]);
			//System.out.println("delta change w: "+delta);
			//System.out.println("input change w:: "+lastinput[i]);
		}
		@Override
		void changeBias() {
			//System.out.println("delta: changebias " +delta);
			b=b+(c*delta);
			
		}
		@Override
		void changeLastInput(double[] input) {
			lastinput=input;		
		}
		@Override
		void showWeights() {
			
			for(int i=0; i<this.w.length;i++){
			System.out.println("Peso: "+i +" "+this.w[i]+" ");
		
			}
			System.out.println("bias: "+b);
			System.out.println("output: "+output);
			System.out.println("delta: "+delta);
			System.out.println();
			
		}
		@Override
		double getWeight(int i) {
			return w[i];
			
		}
		@Override
		int length() {	
			return w.length;
		}
		@Override
		void changeWeightFor(int i, double j) {
			w[i]=j;		
		}

}
