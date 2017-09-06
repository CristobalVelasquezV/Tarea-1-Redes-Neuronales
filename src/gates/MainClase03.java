package gates;

import java.util.Random;

import org.jfree.ui.RefineryUtilities;

public class MainClase03 {

	public static void main(String[] args) {
		/*Sigmoid learning points in a plane.*/
		int points = 200;
		int bluecolor = 0;
		int redcolor = 0;
		Random ran = new Random();
		double[] xvalues = new double[points];
		double[] yvalues = new double[points];
		double[] dataxblue = new double[points];
		double[] datayblue = new double[points];
		double[] dataxred = new double[points];
		double[] datayred = new double[points];
		int min =-50;
		int max = 50;
		int m = 2;
		int b = 3;
		SigmoidNeuron sigmoid1=new SigmoidNeuron(0.01,1,1,1);
		System.out.println(sigmoid1.output(0,0));
		
		for(int k = 0 ;k < 200;k++){
			SigmoidNeuron sigmoid=new SigmoidNeuron(0.01,1,1,1);
			for(int i =0 ;i<k;i++){		
				int x=ran.nextInt(max - min + 1)+ min;
				int y=ran.nextInt(max - min + 1)+ min;		
				if(x*m+b>=y){
					sigmoid.learn(x,y,1);	
				}
				else{
					sigmoid.learn(x,y,0);
				}
			}
			
		/*Evaluamos rendimiento del SigmoidNeuron*/	
		int achunto=0;
		for(int i =0 ;i<points;i++){
			
			int x2=ran.nextInt(max - min + 1)+ min;
			int y2=ran.nextInt(max - min + 1)+ min;
			/*Datos para el grafico de puntos*/
			if(sigmoid.output(x2,y2)>0.5){
				dataxblue[bluecolor]=x2;
				datayblue[bluecolor]=y2;
				bluecolor++;
			}
			else{
				dataxred[redcolor]=x2;
				datayred[redcolor]=y2;
				redcolor++;
			}
			
			if(x2*m+b>=y2 && sigmoid.output(x2,y2)>0.5){
				achunto++;
				
				
			}
			else if(x2*m+b<y2 && sigmoid.output(x2,y2)<=0.5){
				achunto++;
			}

			
			
		}
		bluecolor=0;
		redcolor=0;
		/*Datos Grafico de aprendizaje.*/
		xvalues[k]=k;
		yvalues[k]=achunto;
		//System.out.println("Achunto: " + Integer.toString(achunto) +" de " +Integer.toString(points));
		}
		
		  Plot demo;
		  Plot demo2;
		try {
			demo = new Plot("Sigmoid Neuron Learning Curve",xvalues,yvalues,0);
		    demo.pack();
		    RefineryUtilities.centerFrameOnScreen(demo);
		    demo.setVisible(true);
		    
		    demo2=new Plot("Points",dataxblue,datayblue,dataxred,datayred);
		    demo2.pack();
		    RefineryUtilities.centerFrameOnScreen(demo2);
		    demo2.setVisible(true);
		} catch (Exception e) {

			e.printStackTrace();
		}

		
		/*Sigmoid behavior like gates AND,OR*/
		
		
	}

}
