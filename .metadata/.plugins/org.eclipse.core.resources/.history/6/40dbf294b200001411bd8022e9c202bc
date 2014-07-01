package characters;

import tools.*;
import tools.Character;

import java.awt.Graphics;
import java.awt.event.KeyEvent;
import java.util.ArrayList;

import Graphic.Sprite;
import runtime.GamePanel;


public class Blob extends Character{
	
	private boolean Alive = true;
	private Sprite walk,Death;
	

	
	private final int MaxDx = 3,MaxDy = 3;

	public Blob(int x, int y, GamePanel gp) {
		super(x, y,true, gp);
		
		walk = new Sprite(gp, .8, .8, Sprite.right, LM.BLOB_A,LM.BLOB_B,LM.BLOB_C,LM.BLOB_D,LM.BLOB_E);
		walk.setFrameDuration(.15);
		walk.freezeFrame = 0;
		Death = new Sprite(gp,.8,.8,Sprite.right,LM.BLOB_A2,LM.BLOB_B2,LM.BLOB_C2,LM.BLOB_D2);
		Death.setFrameDuration(.2);
		Death.freezeFrame  = 3;
		
		mask = new Mask(this, 0, 0, walk.getWidth()*walk.xscale, walk.getHeight()*walk.yscale);
		
	}

	@Override
	public void Step() {
		super.Step();
		
		
		
		if(Alive){
			walk.Step();
			
			if(dx>0){
				walk.orientation = Sprite.right;
				walk.freeze = false;
			}
			else if(dx<0){
				walk.orientation = Sprite.left;
				walk.freeze = false;
			}
			else if(dy!=0){
				walk.freeze = false;
			}
			else
				walk.freeze = true;
		}
		else
			Death.Step();
		
	}

	

	@Override
	public void render(Graphics g) {
		if(Alive)
			walk.render(g, x, y);
		else
			Death.render(g, x, y);
	}
	
	public void Jump(){
		dy = -MaxDy;
	}
	
	@Override
	public void solidCollisions() {}

	@Override
	public void destroy() {}
	
	@Override
	public void keyPressed(KeyEvent e){
		switch(e.getKeyCode()){
		case KeyEvent.VK_RIGHT:
			dx=MaxDx;
			break;
		case KeyEvent.VK_DOWN:
			dy = MaxDy;
			break;
		case KeyEvent.VK_LEFT:
			dx= -MaxDx;
			break;
		case KeyEvent.VK_UP:
			dy = -MaxDy;
			break;
		}
	}
	@Override
	public void keyReleased(KeyEvent e){
		switch(e.getKeyCode()){
		case KeyEvent.VK_RIGHT:
			dx=0;
			break;
		case KeyEvent.VK_DOWN:
			dy = 0;
			break;
		case KeyEvent.VK_LEFT:
			dx= 0;
			break;
		case KeyEvent.VK_UP:
			dy = 0;
			break;
		}
	}
	
	
	public static Blob findBlob(GamePanel panel){
		ArrayList<Character> characters = Character.findCharacters(panel);
		for( int bbb = 0; bbb<characters.size(); bbb++){
			Character character = characters.get(bbb);
			if(  character instanceof Blob)
				return (Blob)character;
		}
		System.out.println("No Blob could be found in ArrayList stuff\n" +" on GamePanel " + panel.toString() );
		return null;
	}

}
