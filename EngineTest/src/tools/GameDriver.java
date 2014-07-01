package tools;

import panels.Menu;
import panels.SampleLevel;
import runtime.*;

@SuppressWarnings("serial")
public class GameDriver extends Driver{

	public GameDriver(){
		super();
	
		initPanel(CurrentPanel = 0);
		
	}

	@Override
	public void initPanel(int NextPanel) {
		
		switch(NextPanel){
		case 0:
			panels.add(0, new Menu(this) );
			break;
		case 1:
			panels.add(1, new SampleLevel(this) );
			break;
		}
	}
	
	public static void main(String args[] ){
		
		game = new GameDriver();
		
		game.add( panels.get(CurrentPanel) );
		(  panels.get(CurrentPanel)  ).setVisible(true);
		game.setVisible(true);
		
		(  panels.get(CurrentPanel)  ).startPanel();
		
	}

}
