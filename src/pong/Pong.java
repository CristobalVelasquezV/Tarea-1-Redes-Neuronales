package pong;

import java.applet.Applet;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.RenderingHints.Key;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.ArrayList;
import java.util.Random;

import gates.GenericNeuron;
import gates.NeuronLayer;
import gates.NeuronalNetwork;
import gates.SigmoidNeuron;

public class Pong extends Applet implements Runnable ,KeyListener{
	final int WIDTH=700,HEIGHT=500;
	//AIPaddle p1;
	HumanPaddle p1;
	AIPaddle p2;
	Ball b1;
	Thread thread;
	Image img;
	Graphics gfx;
	
	/**
	 * Neural network variables
	 */
	NeuronalNetwork network=new NeuronalNetwork();
	double inputXpaddle;
	double inputYball;
	double inputXball;
	double inputVYball;
	double inputVXball;
	double outputV;
	private static final long serialVersionUID = 1L;

	public void init(){

		b1=new Ball(WIDTH,HEIGHT);
		p1=new HumanPaddle(1,HEIGHT);
		//p1=new AIPaddle(1,HEIGHT,b1);
		p2=new AIPaddle(2,HEIGHT,b1);
		this.resize(WIDTH, HEIGHT);
		thread=new Thread(this);
		thread.start();
		this.addKeyListener(this);
		img=createImage(WIDTH,HEIGHT);
		gfx=img.getGraphics();
		/*Inicializamos red neuronal*/


		
	}
	
	public void paint(Graphics g){
		gfx.setColor(Color.BLACK);
		gfx.fillRect(0, 0, WIDTH, HEIGHT);
		if(b1.getX()<-10 || b1.getX()>WIDTH+10 ){
			//gfx.setColor(Color.red);
			//gfx.drawString("GAME OVER", WIDTH/2, HEIGHT/2);
			
			b1=new Ball(WIDTH,HEIGHT);
			//p1=new AIPaddle(1,HEIGHT,b1);
			p1=new HumanPaddle(1,HEIGHT);
			p2=new AIPaddle(2,HEIGHT,b1);
		}
		else{
			p1.draw(gfx);
			p2.draw(gfx);
			b1.draw(gfx);
			
		}
		g.drawImage(img, 0, 0, this);
	}
	
	public void update(Graphics g){
		paint(g);
	}

	@Override
	public void run() {
		double out;
		for(;;){
			p1.move();
			b1.move();
			inputXpaddle=normalizationOneZero(p1.y,420,0);
			inputYball=normalizationOneZero(b1.y,490,10);
			inputXball=normalizationOneZero(b1.x,710,-10);
			inputVYball=normalizationOneZero(b1.yVel,1,-1);
			inputVXball=normalizationOneZero(b1.xVel,2,-2);
			outputV=normalizationOneZero(p1.yVel,5,-5);
			double[] input={inputXpaddle,inputYball,inputXball,inputVYball,inputVXball};
			if(p1.yVel>0.01||p1.yVel<-0.01){	
			double[] output={outputV};
			network.networkLearn(input,output);
			double[] vy=network.networkOutput(input);
			out=denormalization(vy[0],5,-5);
			
			//System.out.println(p1.y);
			//System.out.println(inputXpaddle);
			
			//System.out.println(b1.xVel);
		    System.out.println(vy[0]);
			//System.out.println(outputV);
			//System.out.println("V Ai: "+out);
			//System.out.println("V p1: "+p1.yVel);
			}
			else{
				double[] vy=network.networkOutput(input);
				out=denormalization(vy[0],5,-5);
			}
			p2.move2(out);
			
			b1.checkPaddleCollision(p1, p2);
			repaint();
			try {
				Thread.sleep(10);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
		
	}

	@Override
	public void keyTyped(KeyEvent e) {

	}

	@Override
	public void keyPressed(KeyEvent e) {
		
		if(e.getKeyCode()==KeyEvent.VK_UP){
			p1.setUpAcel(true);
		}
		else if(e.getKeyCode()==KeyEvent.VK_DOWN){
			p1.setDownAcel(true);
		}
		else if(e.getKeyCode()==KeyEvent.VK_1){
			p1=new HumanPaddle(2,HEIGHT);
			p2=new AIPaddle(1,HEIGHT,b1);
		}
		

	}

	@Override
	public void keyReleased(KeyEvent e) {
		//System.out.println("velocidad raqueta: "+p1.GetyVel());
		//System.out.println("posicion raqueta"+p1.GetY());

		//System.out.println("posicion pelota X"+(int)b1.x);
		//System.out.println("posicion pelota Y"+(int)b1.y);
		//System.out.println("Velocidad pelota X"+(int)b1.xVel);
		//System.out.println("Velocidad pelota X"+(int)b1.yVel);
		
		if(e.getKeyCode()==KeyEvent.VK_UP){
			p1.setUpAcel(false);
		}
		else if(e.getKeyCode()==KeyEvent.VK_DOWN){
			p1.setDownAcel(false);
		}
		
		
	}
	
	static double normalizationOneZero(double v,double max, double min){
		return ((v-min)/(max-min)); 
	}
	static double denormalization(double v,double max, double min){
		return ((min-max)*v -min)*-1;
	}
}
