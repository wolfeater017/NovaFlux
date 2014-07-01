package tools;



import java.awt.event.KeyEvent;
import java.util.ArrayList;

import runtime.GamePanel;

public abstract class Character extends Thing{
	
	protected boolean CameraFollow = false;

	public Character(int x, int y,boolean CameraFollow, GamePanel gp) {
		super(x, y, gp);
		mask = new Mask(this, 0, 0, 50, 50);
		this.CameraFollow = CameraFollow;
	}
	
	public boolean doesCameraFollow(){ return CameraFollow; }
	
	@Override
	public void Step() {
		x+=dx;
		y+=dy;
	}
	
	public static ArrayList<Character> findCharacters(GamePanel panel){
		
		ArrayList<Character> characters = new ArrayList<Character>();
		for(int bbb = 0; bbb<panel.stuff.size(); bbb++){
			Thing thing = panel.stuff.get(bbb);
			if( thing instanceof Character)
				characters.add((Character)thing);
		}
		if(characters.size()<1)
			System.out.println("No Character could be found in ArrayList stuff\n" +" on GamePanel " + panel.toString() );
		return characters;
	}
	
	public abstract void keyPressed(KeyEvent e);
	
	public  abstract void keyReleased(KeyEvent e);

}
