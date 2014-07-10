package Graphic;

import java.awt.Rectangle;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;
import java.util.regex.Pattern;

import runtime.GamePanel;
import runtime.Loader;
import tools.Path;
import tools.Thing;

public abstract class TextMap {
	
	protected ArrayList<Thing> things = new ArrayList<Thing>();
	protected static int GRIDCONSTANT = 32;
	
	public TextMap(String path){
		
		
			
			
			
				Scanner read = Loader.getFileScanner(path);
				
				while(read.hasNextLine()){
					String line = read.nextLine();
					if(!line.isEmpty()){
						String[] tokens = line.split(Pattern.quote(" ") );
						int x=0,y=0;
						String id="";
						boolean visible = false;
						ArrayList<String> obj = new ArrayList<String>();
						for(int i = 0; i<tokens.length; i++){
							switch(i){
							case 0:
								id = tokens[i];
								break;
							case 1:
								x = Integer.parseInt(tokens[i]);
								break;
							case 2:
								y = Integer.parseInt(tokens[i]);
								break;
							case 3:
								if(tokens[i].equalsIgnoreCase("true") )
									visible = true;
								else
									visible = false;
								break;
							default:
								obj.add(tokens[i]);
								break;
							}
						}
					
						String[] packets = new String[obj.size()];
						for(int bbb = 0; bbb<packets.length; bbb++)
							packets[bbb] = obj.get(bbb);

						things.add( IDAssignor(id, x*GRIDCONSTANT, y*GRIDCONSTANT, visible, packets) );
					}
				}
				
				read.close();
		
		
		
		
		
		
	}
	
	public void BuildMapOnPanel(GamePanel gp){
		for( int MapIndex = 0, PanelIndex = gp.stuff.size();MapIndex < this.things.size(); MapIndex++ ){
			gp.stuff.add(PanelIndex + MapIndex, this.things.get(MapIndex) );
		}
		
		for(int bbb = 0; bbb<gp.stuff.size(); bbb++)
			(gp.stuff.get(bbb) ).addPanelRef(gp);
	}
	
	protected abstract Thing IDAssignor(String ID,int x, int y,boolean visibility, Object[] objs);
	
	public static Object AdditionalObjectHandler(String token){
		
		if(token.startsWith(Reference.ID.PATH.toString() ) )
			return (Object)new Path(token);
		else if(token.startsWith(Reference.ID.RECTANGLE.toString() ) ){
			String[] data = token.split(Pattern.quote("/") );
			int x = Integer.parseInt(data[1]);
			int y = Integer.parseInt(data[2]);
			int width = Integer.parseInt(data[3]);
			int height = Integer.parseInt(data[4]);
			return (Object)new Rectangle(x, y,width,height);
		}
		else
			return (Object)null;
	}
}
