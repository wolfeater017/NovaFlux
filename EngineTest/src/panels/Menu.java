package panels;



import tools.*;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Rectangle;
import java.awt.event.MouseEvent;

import audio.AudioPlayer;
import runtime.*;



public class Menu extends GamePanel{
	
	
	private static final long serialVersionUID = -6613511469101516158L;
	Font counters = new Font("Times New Roman", Font.BOLD, 14);
	ProgressBar progressBar = new ProgressBar(50, Driver.HEIGHT-100, Driver.WIDTH - 100, 25, Color.GREEN, Color.GRAY);
	
	Button start,exit;
	
	public Menu(Driver game) {
		super(game);
		
		new LM(progressBar);
		AudioPlayer.getMusic(LM.MUSIC_CASTLEMANIA).loop();
		start = new Start();
		exit = new Exit();
		
		
	}
	
	@Override
	public void Step() {
		super.Step();
		
		if( LM.getProgressBar().isFinished() ){
			start.Enable(true);
			
		}
	}
	
	
	@Override
	public void paint(Graphics g) {
		super.paint(g);
		
		g.setColor(Color.black);
		g.fillRect(0, 0, Driver.WIDTH, Driver.HEIGHT);
		
		g.setColor(Color.WHITE);
		g.drawString("SPS: ", 25, 15);
		g.drawString("FPS: ", 25, 25);
		
		g.setColor(Color.ORANGE);
		g.drawString(Integer.toString( SPS ),55,15);
		g.drawString(Integer.toString( FPS ),55,25);
		
		g.drawImage(LM.BBBTITLE, 150, 30, null);
		
		LM.getProgressBar().render(g);
		start.render(g);
		exit.render(g);
		
	}
	
	@Override
	public void mouseClicked(MouseEvent e) {
		super.mouseClicked(e);
		
		start.MouseClicked(e);
		exit.MouseClicked(e);
	}
	
	@Override
	public void mouseMoved(MouseEvent e) {
		super.mouseMoved(e);
		
		start.MouseMoved(e);
		exit.MouseMoved(e);
	}
	
	private class Start extends Button{

		public Start() {
			super( "Start", new Rectangle(Driver.WIDTH/2 - 43, Driver.HEIGHT/2, 85, 40), 17);
			Enabled = false;
			yOffset = 5;
			
		}
		
		@Override
		public void Enable(boolean Enabled) {
			super.Enable(Enabled);
			if(Enabled){
				
			}
				
		}
		
		@Override
		public void Clicked(){
			super.Clicked();
			AudioPlayer.getSound(LM.SOUND_SUCCESS).play();
			
			game.startPanel(1);
		}
		
	}
	
	private class Exit extends Button{

		public Exit() {
			super( "Exit", new Rectangle(Driver.WIDTH/2 - 43, Driver.HEIGHT/2 + 60, 85, 40), 15);
			Enabled = true;
			yOffset = 5;
		}
		
		@Override
		public void Clicked() {
			super.Clicked();
			game.destroy();
		}
		
	}

}
