package dev.rezilz.expedition.entities.creatures;

import java.awt.Graphics;
import java.awt.image.BufferedImage;
import dev.rezilz.expedition.Handler;
import dev.rezilz.expedition.gfx.Animation;
import dev.rezilz.expedition.gfx.Assets;

public class Player extends Creature {
	
	//Animations
	private Animation animDown, animUp, animLeft, animRight;
	
	private BufferedImage curPosition = Assets.player_down[0];

	public Player(Handler handler, float x, float y) {
		super(handler, x, y,Creature.DEFAULT_CREATURE_WIDTH,Creature.DEFAULT_CREATURE_HEIGHT);
		
		bounds.x = 32;
		bounds.y = 32;
		bounds.width = 32;
		bounds.height = 36; //pls fit this to player of you?
		
		//Animatons
		animDown = new Animation(135, Assets.player_down);
		animUp = new Animation(135, Assets.player_up);
		animLeft = new Animation(135, Assets.player_left);
		animRight = new Animation(135, Assets.player_right);
	}

	@Override
	public void tick() {
		//Animations
			animDown.tick();
			animUp.tick();
			animRight.tick();
			animLeft.tick();
		//Movement
			getInput();
			move();
			handler.getGameCamera().centerOnEntity(this);
	}
	
	private void getInput() {
		xMove = 0;
		yMove = 0;
		
		if(handler.getKeyManager().up)
			yMove = -speed;
		if(handler.getKeyManager().down)
			yMove = speed;
		if(handler.getKeyManager().left)
			xMove = -speed;
		if(handler.getKeyManager().right)
			xMove = speed;

	}

	@Override
	public void render(Graphics g) {
		g.drawImage(getCurrentAnimationFrame(), (int) (x - handler.getGameCamera().getxOffset()), (int) (y - handler.getGameCamera().getyOffset()), width, height, null);
	}
	
	/*private BufferedImage getCurrentAnimationFrame(){ //to make nong move actively
		if(xMove < 0){
			return animLeft.getCurrentFrame();
		}else if(xMove > 0){
			return animRight.getCurrentFrame();
		}else if(yMove < 0){
			return animUp.getCurrentFrame();
		}else{
			return animDown.getCurrentFrame();
		}
	} */
	
	private BufferedImage getCurrentAnimationFrame(){ //to make nong mai active raew cry a lot
		  if(xMove < 0){
		   curPosition = Assets.player_left[0];
		   return animLeft.getCurrentFrame();
		  }else if (xMove > 0){
		   curPosition = Assets.player_right[0];
		   return animRight.getCurrentFrame();
		  }else if (yMove < 0){
		   curPosition = Assets.player_up[0];
		   return animUp.getCurrentFrame();
		  }else if (yMove > 0){
		   curPosition = Assets.player_down[0];
		   return animDown.getCurrentFrame();
		  }
		  return curPosition;
		 }

}