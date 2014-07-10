package tools;

import java.awt.Graphics;
import java.util.ArrayList;

import runtime.GamePanel;

public abstract class Thing {
	
	public int x,y;
	public double dx,dy;
	protected GamePanel gp;	
	protected ArrayList<Thing> solids;
	public Mask mask;

	public Thing(int x, int y, GamePanel gp){
		
		this.x = x;
		this.y = y;
		this.gp = gp;
		
	}
	
	public Thing(int x, int y){
		this.x = x;
		this.y = y;
	}
	
	public void addPanelRef(GamePanel gp){ this.gp = gp; }
	
	public abstract void Step();
	
	/**
	 * mimics the motion of gravity
	 */
	public void gravity(){
		dy = Calc.DeltaVelocity(dy);
		y = (int) ( Calc.DeltaHeight(dy, y) );
		System.out.println(Calc.DeltaVelocity(dy));
	}
	
	
	/**
	 * resets coordinates of Thing
	 * @param x
	 * @param y
	 */
	public void setCoord(int x,int y){ this.x = x; this.y = y;}
	
	public abstract void render(Graphics g);
	public abstract void destroy();

}
