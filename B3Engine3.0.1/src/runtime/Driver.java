package runtime;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.util.ArrayList;

import javax.swing.JFrame;

import audio.AudioPlayer;

public class Driver extends JFrame implements KeyListener,MouseMotionListener,MouseListener{
	
	/**
	 * @author Ben Bemis
	 */
	public static final String versionID = "3.0.4";
	private static final long serialVersionUID = -3575253367892642046L;
	protected static String title = "";
	public static int WIDTH = 640, HEIGHT;
	
	protected static ArrayList<GamePanel> panels = new ArrayList<GamePanel>();
	protected static int CurrentPanel = 0;
	

	public static Driver game;
	
	public Driver(){
		super(title);
		
		//adds available interfaces
		addKeyListener(this);
		addMouseMotionListener(this);
		addMouseListener(this);
		
		set4_3Ratio(WIDTH);
		
		setSize(WIDTH,HEIGHT);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		addWindowListener(new WindowAdapter(){
			@Override
			public void windowClosing(WindowEvent e) {
				destroy();
				
			}
		});
		setFocusable(true);
		
	}
	
	public void initDriver(){};
	
	/**
	 * Sets a 4:3 ratio for the JFrame based on the inputed width
	 * @param width
	 */
	public void set4_3Ratio(int width){ Driver.WIDTH = width;   Driver.HEIGHT = WIDTH/4*3; }
	
	
	/**
	 * Initializes and Starts the indicated GamePanel
	 * @param nextPanel - index of indicated GamePanel
	 */
	public void startPanel(int nextPanel){
		
		(  panels.get(CurrentPanel)  ).stopPanel();
		
		(  panels.get(CurrentPanel)  ).setVisible(false);
		game.remove(   panels.get(CurrentPanel)  );
		
		CurrentPanel = nextPanel;
		initPanel(nextPanel);
		add(   panels.get(CurrentPanel)  );
		(  panels.get(CurrentPanel)  ).setVisible(true);
		game.setVisible(true);
		
		(  panels.get(CurrentPanel)  ).startPanel();
	}
	
	/**
	 * closes the JFrame safely, should always be the last code called
	 * Make sure all other parts are closed safely first
	 */
	public void destroy(){
		if(Loader.getProgressBar().getProgress()<1)
			Loader.End();
		AudioPlayer.destroy();
		System.exit(1);
	}
	
	/**
	 * initializes the next panel BEFORE you try to access it
	 * @param NextPanel - index of panel you want to initialize
	 */
	public void initPanel(int NextPanel){}
	
	
	
	
	@Override
	public void mouseClicked(MouseEvent e) { (  panels.get(CurrentPanel)  ).mouseClicked(e); }
	@Override
	public void mouseEntered(MouseEvent e)  { (  panels.get(CurrentPanel)  ).mouseEntered(e); }
	@Override
	public void mouseExited(MouseEvent e)  { (  panels.get(CurrentPanel)  ).mouseExited(e); }
	@Override
	public void mousePressed(MouseEvent e)  { (  panels.get(CurrentPanel)  ).mousePressed(e); }
	@Override
	public void mouseReleased(MouseEvent e)  { (  panels.get(CurrentPanel)  ).mouseReleased(e); }
	@Override
	public void mouseDragged(MouseEvent e)  { (  panels.get(CurrentPanel)  ).mouseDragged(e); }
	@Override
	public void mouseMoved(MouseEvent e)  { (  panels.get(CurrentPanel)  ).mouseMoved(e); }
	@Override
	public void keyPressed(KeyEvent e)  { (  panels.get(CurrentPanel)  ).keyPressed(e); }
	@Override
	public void keyReleased(KeyEvent e) { (  panels.get(CurrentPanel)  ).keyReleased(e); }
	@Override
	public void keyTyped(KeyEvent e) { (  panels.get(CurrentPanel)  ).keyTyped(e); }

}
