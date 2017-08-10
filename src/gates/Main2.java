package gates;

import java.util.Random;

public class Main2 {

	public static void main(String[] args) {
		LearningPerceptron learningperceptron= new LearningPerceptron(1,1,1);
		Random ran= new Random();
		int min= -50;
		int max=50;
		for(int i =0 ;i<1000;i++){

			int x=ran.nextInt(max - min + 1)+ min;
			int y=ran.nextInt(max - min + 1)+ min;
	
			if(x*2+3>=y){
				//System.out.println("x ,y pertenece a la recta");
				learningperceptron.learn(x,y,1);
			
			}
			else{
				//System.out.println("x ,y no  pertenece a la recta");
				learningperceptron.learn(x,y,0);
			}
			
			
		}
		
		learningperceptron.show();
		int achunto=0;
		int fallo=0;
		for(int i =0 ;i<1000;i++){
			//double value=i*2 +3;
			
			int x=ran.nextInt(max - min + 1)+ min;
			int y=ran.nextInt(max - min + 1)+ min;
			if(x*2+3>=y && learningperceptron.output(x,y)==1){
				//System.out.println("Achunto");
				achunto++;
			}
			else if(x*2+3<y && learningperceptron.output(x,y)==0){
				//System.out.println("Achunto");
				achunto++;
			}
			else{
				//System.out.println("Fallo");
				fallo++;
			}
			
			
		}
		System.out.println("Achunto: " + Integer.toString(achunto));
		
		
	}
		

}
