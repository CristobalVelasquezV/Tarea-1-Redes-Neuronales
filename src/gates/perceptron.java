package gates;


/**
 * @author cristobal
 * Clase perceptron, recibe cantidad de ints que representan los pesos.
 * atributos 
 * b: bias o threshold del perceptron
 * n: numero de inputs del perceptron
 * w: lista de pesos del perceptron
 */ 

public class perceptron {
	private int b;
	private int n;
	private int[] w;
	
	public perceptron(int bias,int ...weight){
		int counter;
		b=bias;
		counter=weight.length;
		w=new int[counter];
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
	
}
