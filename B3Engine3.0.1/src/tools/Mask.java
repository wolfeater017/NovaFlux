package tools;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Rectangle;

public class Mask {
	
	public static int left=2,top=3,right=0,bottom=1;
	private int Xoffset,Yoffset;
	private double height,width;
	private Thing thisThing;
	
	public Mask(Thing thing,int Xoffset,int Yoffset,double width,double height){
		
		this.thisThing = thing;
		this.Xoffset = Xoffset;
		this.Yoffset = Yoffset;
		this.width = width;
		this.height = height;
	}
	
	public Mask(int Xoffset,int Yoffset,double width,double height){
		
		
		this.Xoffset = Xoffset;
		this.Yoffset = Yoffset;
		this.width = width;
		this.height = height;
	}
	
	public void setThing(Thing thing){
		thisThing = thing;
	}
	/**
	 * 
	 * @return-Rectangle- representing collision Mask
	 */
	public Rectangle getRect(){ return new Rectangle(thisThing.x+Xoffset,thisThing.y+Yoffset,(int)width,(int)height); }
	
	public int getXoffset() { return Xoffset; }
	public int getYoffset() { return Yoffset; }
	/**
	 * The offset is the distance from the Thing's origin to the origin of the Mask
	 * @param xoffset
	 * @param yoffset
	 */
	public void setOffset(int xoffset,int yoffset) { this.Xoffset = xoffset; this.Yoffset = yoffset; }
	public void setDimensions(double width,double height){ this.width = width; this.height = height; }
	
	/**
	 * 
	 * @param m
	 * @return-boolean- true- if this mask is touching m
	 * false- if this mask is not touching m
	 */
	public boolean collidesWith(Mask m){
		if(m!=null && this.getRect().intersects( m.getRect() ) )
			return true;
		return false;
	}
	
	/**
	 * This method is used to determine the sides that are in contact during a collision
	 * boolean[0] = left
	 * boolean[1] = Top
	 * boolean[2] = right
	 * boolean[3] = bottom
	 * @param thing
	 * @return true - this side is in contact
	 * @return false - this side is not in contact
	 */
	public boolean[] collisionSide(Mask m){
		
		boolean[] leftUp = new boolean[4];
		
		Rectangle[] boxes = new Rectangle[4];
		boxes[0] = new Rectangle(this.getRect().x-1, this.getRect().y, 1, this.getRect().height);
		boxes[1] = new Rectangle(this.getRect().x, this.getRect().y-1, this.getRect().width, 1);
		boxes[2] = new Rectangle(this.getRect().x + this.getRect().width, this.getRect().y, 1, this.getRect().height);
		boxes[3] = new Rectangle(this.getRect().x, this.getRect().y+this.getRect().height, this.getRect().width, 1);
		
		double greatestArea = 0;
		int greatest = 0;

		for( int bbb = 0; bbb<4; bbb++){
			if( Calc.getArea( boxes[bbb].createIntersection(m.getRect() ) ) > greatestArea){
				greatestArea = Calc.getArea( boxes[bbb].createIntersection(m.getRect() ) );
				greatest = bbb;
			}
		}
		
		for(int b=0; b<4; b++)
			leftUp[b] = false;
		
		leftUp[greatest] = true;

		return leftUp;
	}
	
	/**
	 * Displays a WHITE rectangle representing mask
	 * Helpful for debugging
	 * @param g
	 */
	public void showMask(Graphics g){
		g.setColor(Color.WHITE);
		g.drawRect((int)(getRect().x), (int)(getRect().y), (int)(getRect().width), (int)(getRect().height) );
	}
	

	
	

}