package pong;

import java.awt.Color;
import java.awt.Graphics;

public class AIPaddle implements Paddle{
	
	
	double y,yVel;
	boolean upAcel,downAcel;
	int xlong=20,ylong=80;
	int h;
	Ball b1;
	
	int player,x;
	public AIPaddle(int player,int HEIGHT,Ball b){
		b1=b;
		upAcel=false;downAcel=false;
		y=210;yVel=0;
		if(player==1){
			x=20;
		}
		else{
			x=660;
		}
		h=HEIGHT;
	}
	
	@Override
	public void draw(Graphics g) {
		g.setColor(Color.WHITE);
		g.fillRect(x,(int) y,xlong, ylong);
		
	}
	public void setUpAcel(boolean input){
		upAcel=input;
	}
	
	public void setDownAcel(boolean input){
		downAcel=input;
	}

	
	@Override
	public void move() {
		y=b1.getY()-40;
		
		if(y<0){
			y=0;
		}
		
		if(y>h-ylong){
			y=h-ylong;
		}
	}
	
	public void move2(double yVel){
		y+=yVel;
		
		if(y<0){
			y=0;
		}
		
		if(y>h-ylong){
			y=h-ylong;
		}
	}

	@Override
	public int GetY() {
		return (int)y;
}
	}
