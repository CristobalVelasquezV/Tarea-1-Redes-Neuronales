package pong;

import java.awt.Color;
import java.awt.Graphics;

public class Ball {
	int collitions;
	double xVel,yVel,x,y;
	int WIDTH,HEIGHT;
	final int ballw=10;
	public Ball(int w,int h){
		collitions=0;
		xVel=-2;
		yVel=1;
		x=350;
		y=250;
		WIDTH=w;
		HEIGHT=h;
	}
	
	public void checkPaddleCollision(Paddle p1, Paddle p2){
		if(x<=50){
			if(y>=p1.GetY() && y<=p1.GetY()+80){
				xVel=-xVel;
			}
			
		}
		else if(x>=650){
			if(y>=p2.GetY() && y<=p2.GetY()+80){
				xVel=-xVel;
				collitions++;
			}
		}
	}
	public int numberCollitions(){
		return collitions;
	}
	
	public void draw(Graphics g){
		g.setColor(Color.WHITE);
		g.fillOval(getX()-ballw, getY()-ballw, 20, 20);
	}
	public void move(){
		x+=xVel;
		y+=yVel;
		
		if(y<10){
			yVel=-yVel;		
		}
		else if(y> HEIGHT-ballw ){
			yVel=-yVel;
		}
	}
	public int getX(){
		return (int)x;
	}
	public int getY(){
		return (int)y;
	}
}
