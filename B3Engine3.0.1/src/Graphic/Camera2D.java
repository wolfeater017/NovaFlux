package Graphic;


import java.awt.Graphics;
import java.awt.Graphics2D;

import runtime.Driver;
import runtime.GamePanel;
import tools.Character;

public class Camera2D {
	
	public static final int Tweening = 0, NormalScroll = 1, SideScroll = 2, TweeningSideScroll = 3;
	
	private double x,y;
	private Character player;
	private int ScrollType;

	private int xOffset = 0,yOffset = 0;

	public  Camera2D(GamePanel gp,Character player,double x, double y,int ScrollType){
		this.x = x;
		this.y = y; 

		this.player = player; 
		this.ScrollType = ScrollType;
	}
	
	public void Step(){
		switch(ScrollType){
		case Tweening:
			TweaningScroll();
			break;
		case NormalScroll:
			Normal2DScroll();
			break;
		case SideScroll:
			sideScroll();
			break;
		case TweeningSideScroll:
			TweaningSideScroll();
			break;
		}
		
	}
	
	public void setOffset(int xOffset, int yOffset){
		this.xOffset = xOffset;
		this.yOffset = yOffset;
	}
	
	public void Scroll(Graphics g){
		Graphics2D g2d = (Graphics2D)g;
		g2d.translate(x, y);
	}
	
	public void deScroll(Graphics g){
		Graphics2D g2d = (Graphics2D)g;
		g2d.translate(-x, -y);
	}
	
	private void TweaningScroll(){
		x += ((-player.x + Driver.WIDTH /2 + xOffset) - x) * .0275f;
		y += ((-player.y + Driver.WIDTH /2 + yOffset) - y) * .0275f;
	}
	
	private void TweaningSideScroll(){
		x += ((-player.x + Driver.WIDTH /2 + xOffset) - x) * .0275f;
	}
	
	private void Normal2DScroll(){
		this.x = -player.x + Driver.WIDTH /2 + xOffset;
		this.y = -player.y + Driver.HEIGHT /2 + yOffset;
	}
	
	private void sideScroll(){
		this.x = -player.x + Driver.WIDTH /2 + xOffset;
	}
	
	public double getX(){ return x; }
	public double getY(){ return y; }
	
	
	
	
	

}
