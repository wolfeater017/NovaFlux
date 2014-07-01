package panels;



import java.awt.event.KeyEvent;

import characters.Blob;
import tools.*;
import Graphic.Camera2D;
import runtime.*;



public class SampleLevel extends GamePanel {

	/**
	 *
	 */
	private static final long serialVersionUID = 1887190883618977194L;
	
	private Blob blob;
	

	public SampleLevel(Driver game) {
		super(game);
		

		
		LM.MAZE_MAP.BuildMapOnPanel(this);
		
		blob = Blob.findBlob(this);
		
		this.camera = new Camera2D(this,blob, 0, 0,Camera2D.Tweening);
		this.camera.setOffset(-60, -115);
	}
	
	
	
	@Override
	public void keyPressed(KeyEvent e) {
		blob.keyPressed(e);
	}
	
	@Override
	public void keyReleased(KeyEvent e) {
		blob.keyReleased(e);
	}

}
