package pong;

import java.awt.Color;
import java.awt.Graphics;

public class HumanPaddle implements Paddle{
	private final double GRAVITY = 0.94;
	double y,yVel;
	boolean upAcel,downAcel;
	int xlong=20,ylong=80;
	int h;
	
	int player,x;
	public HumanPaddle(int player,int HEIGHT){
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
		if(upAcel){
			yVel-=2;
		}
		else if(downAcel){
			yVel+=2;
		}
		else if(!upAcel&&!downAcel){
			yVel*=GRAVITY;
		}
		if(yVel>5){
			yVel=5;
		}
		else if(yVel<-5){
			yVel=-5;
		}
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
	
	public int GetyVel(){
		return (int) yVel;
	}

}
