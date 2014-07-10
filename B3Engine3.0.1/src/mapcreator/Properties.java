package mapcreator;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Rectangle;
import java.awt.event.KeyEvent;
import java.awt.event.MouseEvent;

import tools.Button;

public class Properties extends section{
	
	private final int x = CreatorApp.width*4/5, y = CreatorApp.height/2 -35,width = CreatorApp.width/5,height = CreatorApp.height/2 -35;
	private Panel p;
	
	private String header;
	private Font headerFont = new Font("Arial", Font.PLAIN, 13);
	
	private String visible;
	private String position;
	private String path;
	private String rectangle;
	
	private Button change,addPath;
	
	public Properties(Panel p){
		this.p = p;
		header = "Properties: ";
		path = "Path: false";
		change = new ChangeVisibility();
		addPath = new addPath();
	}
	
	@Override
	public void Step() {
		if(p.Selected!=null){
			header = "Properties: " + p.Selected.id;
			
			visible = "Visible: ";
			if(p.Selected.visibility)
				visible+="true";
			else
				visible+=false;
			position = "Position: " +"("+ p.Selected.x + "," +  p.Selected.y + ")";
			
			
			if(p.Selected.pathExists())
				path = "Path: true";
			else
				path = "Path: false";
			
			change.Enable(true);
			addPath.Enable(true);
			
		}
		else{
			header = "Properties: ";
			change.Enable(false);
			addPath.Enable(false);
		}
		
	}

	@Override
	public void render(Graphics g) {
		g.setColor(Color.RED);
		g.fillRect(x, y, width, height);
		
		g.setColor(Color.black);
		g.setFont(headerFont);
		g.drawString(header, x + 10, y+10);
		
		if(p.Selected!=null && position!=null){
			g.drawString(position, x+ 10, y+50);
			g.drawString(visible,x +10,y+65);
			g.drawString(path,x+10,y+80);
			change.render(g);
			addPath.render(g);
		}
		
		
	}
	
	@Override
	public void mousePressed(MouseEvent e) {
		
		
	}
	
	@Override
	public void mouseReleased(MouseEvent e) {
		
		
	}
	
	
	
	private class ChangeVisibility extends Button{

		public ChangeVisibility() {
			super("Change", new Rectangle(x + 90, y + 55, 50, 10), 2);
			font = new Font("Times New Roman", Font.PLAIN, 12);
			yOffset = -10;
			Enabled = false;
		}
		
		@Override
		public void Clicked() {
			super.Clicked();
			if(p.Selected.visibility)
				p.Selected.visibility = false;
			else
				p.Selected.visibility= true;
		}
		
	}
	
	private class addPath extends Button{

		public addPath() {
			super("Add Path", new Rectangle(x + 90, y+70, 80, 10), 2);
			font = new Font("Times New Roman", Font.PLAIN, 12);
			yOffset = -10;
			Enabled = false;
		}
		
		@Override
		public void Clicked() {
			super.Clicked();
			if(p.AddingPath){
				p.AddingPath =false;
				super.text = "Add Path";
			}
			else{
				p.AddingPath = true;
				text = "Stop";
			}
		}
		
	}
	
	

	@Override
	public void mouseClicked(MouseEvent e) {
		e.translatePoint(0, -6);
		change.MouseClicked(e);
		addPath.MouseClicked(e);
		
		
	}

	@Override
	public void mouseEntered(MouseEvent e) {
		
		
	}

	@Override
	public void mouseExited(MouseEvent e) {
		
		
	}

	

	

	@Override
	public void mouseDragged(MouseEvent e) {
		
		
	}

	@Override
	public void mouseMoved(MouseEvent e) {
		e.translatePoint(0, -6);
		change.MouseMoved(e);
		addPath.MouseMoved(e);
		
	}

	@Override
	public void keyPressed(KeyEvent e) {
		
		
	}

	@Override
	public void keyReleased(KeyEvent e) {
		
		
	}

	@Override
	public void keyTyped(KeyEvent e) {
		
		
	}

}
