package tools;

import java.util.ArrayList;

import runtime.GamePanel;
import tools.Block;
import Ref.ID;
import characters.Blob;

public class ObjectController {
	

	public static void IDHandler(int x, int y, boolean visible, int index,ArrayList<Thing> list, ID id) {
		switch(id){
		case BLOCK:
			list.add(index, new Block(x, y, visible, index, null) );
			break;
		case BLOB:
			list.add(index,new Blob(x, y, null) );
			break;
		default:
			System.out.println("Missing ID: " + id.toString() );
			System.out.println("Under: game.tools.ObjectController");
			break;
		
		}
	}
	
}
