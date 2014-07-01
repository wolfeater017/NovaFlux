package tools;

import Ref.ID;

import java.awt.image.BufferedImage;

import Graphic.ColorDecryptor;
import runtime.GamePanel;

public class MapProcessor extends ColorDecryptor{

	public MapProcessor( BufferedImage ImgMap) {
		super(ImgMap);
		
	}

	@Override
	public void ColorCodeChecker(int red, int green, int blue, int x, int y) {
		
		
		if(red == 0 && green ==0  && blue==0){}//black
		
		else if(red == 255 && green == 255 && blue==255)//white
			ObjectController.IDHandler(x, y, true,Index++, this.stuff, ID.BLOCK);
		
		else if(red!=255 || red == 0){ //shades of blue  --- characters/enemies
			if(red==10)
				ObjectController.IDHandler(x, y, true, Index++, this.stuff, ID.BLOB);
		}
		
		else if(green!=255 || green == 0){ //shades of green -- blocks/textures
			
		}
		
		else if(blue!=255 || blue == 0){ //shades of blue -- others
			
		}
		
		else{//Color undefined
			System.out.println("Color: r = " + red + " g = " + green + " b = " + blue);
			System.out.println("is undefined at x = " + x + " y = " + y);
		}
		
	}

}
