package tools;



import java.awt.Graphics;

import Graphic.Sprite;
import runtime.GamePanel;

public class Block extends Thing {
	
	protected Mask mask;
	protected boolean Visible;
	protected Sprite sprite;
	protected int index;

	public Block(int x, int y,boolean Visible,int index, GamePanel gp) {
		super(x, y, gp);
		
		this.Visible = Visible;
		
		append(32,32,null);
	}
	
	
	
	public void append(int width, int height, Sprite sprite) {
		mask = new Mask(this, 0, 0, width, height);
		this.sprite = sprite;	
	}

	@Override
	public void Step() {
		
		for(int bbb = 0; bbb<gp.stuff.size(); bbb++){
			Thing thing = gp.stuff.get(bbb);
			if( thing instanceof Character)
				if( this.mask.collidesWith(thing.mask) )
					Collision(thing);
				
		}
				
		

	}
	
	public void Collision(Thing thing){
		
		boolean[] side = this.mask.collisionSide(thing.mask);
		if(side[Mask.left] ){
			thing.dx = 0;
			thing.setCoord(this.mask.getRect().x + this.mask.getRect().width, thing.y);
		}
		else if(side[Mask.top]){
			thing.dy = 0;
			thing.setCoord(thing.x, this.y + this.mask.getRect().height );
		}
		else if(side[Mask.right]){
			thing.dx = 0;
			thing.setCoord(this.x - thing.mask.getRect().width, thing.y);
		}
		else if(side[Mask.bottom]){
			thing.dy = 0;
			thing.setCoord(thing.x, this.y - thing.mask.getRect().height);
		}
	}

	@Override
	public void solidCollisions() {}

	@Override
	public void render(Graphics g) {
		if(Visible){
			if(sprite!=null)
				sprite.render(g, x, y);
			else{
				g.fillRect(mask.getRect().x, mask.getRect().y, mask.getRect().width, mask.getRect().height);
			}
				
		}

	}

	@Override
	public void destroy() {
		gp.solids.remove(index);

	}

	

}