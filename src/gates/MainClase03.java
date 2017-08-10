package gates;

import java.util.Random;

public class MainClase03 {

	public static void main(String[] args) {
		/*Sigmoid learning points in a plane.*/
		SigmoidNeuron sigmoid=new SigmoidNeuron(0.01,1,1,1);
		Random ran= new Random();
		int min= -50;
		int max=50;
		int m=2;
		int b=3;
		for(int i =0 ;i<100;i++){

			int x=ran.nextInt(max - min + 1)+ min;
			int y=ran.nextInt(max - min + 1)+ min;
		

			
			if(x*m+b>=y){
				sigmoid.learnSigmoid(x,y,1);
			
			}
			else{
				sigmoid.learnSigmoid(x,y,0);
			}
			
			
		}
		

		int achunto=0;
		int points=1000;
		for(int i =0 ;i<points;i++){
			
			int x=ran.nextInt(max - min + 1)+ min;
			int y=ran.nextInt(max - min + 1)+ min;
			if(x*m+b>=y && sigmoid.outputSigmoid(x,y)>0.5){
				achunto++;
			}
			else if(x*m+b<y && sigmoid.outputSigmoid(x,y)<=0.5){
				achunto++;
			}

			
			
		}
		System.out.println("Achunto: " + Integer.toString(achunto) +" de " +Integer.toString(points));
		
		
		/*Sigmoid behavior like gates AND,OR*/
		
		
	}

}
