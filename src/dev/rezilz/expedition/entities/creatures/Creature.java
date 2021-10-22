package dev.rezilz.expedition.entities.creatures;

import dev.rezilz.expedition.Handler;
import dev.rezilz.expedition.entities.Entity;
import dev.rezilz.expedition.states.CompleteState;
import dev.rezilz.expedition.states.State;
import dev.rezilz.expedition.states.levels.Level1;
import dev.rezilz.expedition.states.levels.Level2;
import dev.rezilz.expedition.states.levels.Level3;
import dev.rezilz.expedition.states.levels.Level4;
import dev.rezilz.expedition.tiles.Tile;

public abstract class Creature extends Entity {
 
 public static final int DEFAULT_HEALTH = 10;
 public static final float DEFAULT_SPEED = 5.0f;
 public static final int DEFAULT_CREATURE_WIDTH = 90,
       DEFAULT_CREATURE_HEIGHT = 90;
 
 protected int health;
 protected float speed;
 protected float xMove, yMove;

 public Creature(Handler handler, float x, float y,int width, int height) {
  super(handler, x, y, width, height);
  health = DEFAULT_HEALTH;
  speed = DEFAULT_SPEED;
  xMove = 0;
  yMove = 0;
 }
 
 public void move(){
  if(!checkEntityCollisions(xMove, 0f))
   moveX();
  if(!checkEntityCollisions(0f, yMove))
   moveY();
 }
 
 public void moveX(){
  
  if(xMove > 0){//Moving right
   
   int tx = (int) (x + xMove + bounds.x + bounds.width) / Tile.TILEWIDTH;
   
   if(!toNextStateLevel1Tile(tx, (int) (y + bounds.y) / Tile.TILEHEIGHT) &&
   !toNextStateLevel1Tile(tx, (int) (y + bounds.y + bounds.height) / Tile.TILEHEIGHT)){}
   else{
    State.setState(new Level1(handler)); 
   }
   if(!toNextStateLevel2Tile(tx, (int) (y + bounds.y) / Tile.TILEHEIGHT) &&
   !toNextStateLevel2Tile(tx, (int) (y + bounds.y + bounds.height) / Tile.TILEHEIGHT)){}
   else{
    State.setState(new Level2(handler)); 
   }
   if(!toNextStateLevel3Tile(tx, (int) (y + bounds.y) / Tile.TILEHEIGHT) &&
   !toNextStateLevel3Tile(tx, (int) (y + bounds.y + bounds.height) / Tile.TILEHEIGHT)){}
   else{
    State.setState(new Level3(handler)); 
   }
   if(!toNextStateLevel4Tile(tx, (int) (y + bounds.y) / Tile.TILEHEIGHT) &&
   !toNextStateLevel4Tile(tx, (int) (y + bounds.y + bounds.height) / Tile.TILEHEIGHT)){}
   else{
    State.setState(new Level4(handler)); 
   }
   if(!toNextStateLevel5Tile(tx, (int) (y + bounds.y) / Tile.TILEHEIGHT) &&
   !toNextStateLevel5Tile(tx, (int) (y + bounds.y + bounds.height) / Tile.TILEHEIGHT)){}
   else{
    State.setState(new CompleteState(handler)); 
   }
   
   
   
   if(!collisionWithTile(tx, (int) (y + bounds.y) / Tile.TILEHEIGHT) &&
   !collisionWithTile(tx, (int) (y + bounds.y + bounds.height) / Tile.TILEHEIGHT)){
    x += xMove;
   }else{
    x = tx * Tile.TILEWIDTH - bounds.x - bounds.width - 1;
   }
  }
  
  else if(xMove < 0){//Moving left
   
   int tx = (int) (x + xMove + bounds.x) / Tile.TILEWIDTH;
  
   // 30/4/63
   if(!toNextStateLevel1Tile(tx, (int) (y + bounds.y) / Tile.TILEHEIGHT) &&
   !toNextStateLevel1Tile(tx, (int) (y + bounds.y + bounds.height) / Tile.TILEHEIGHT)){}
   else{
    State.setState(new Level1(handler));
   }
   if(!toNextStateLevel2Tile(tx, (int) (y + bounds.y) / Tile.TILEHEIGHT) &&
   !toNextStateLevel2Tile(tx, (int) (y + bounds.y + bounds.height) / Tile.TILEHEIGHT)){}
   else{
    State.setState(new Level2(handler));
   }
   if(!toNextStateLevel3Tile(tx, (int) (y + bounds.y) / Tile.TILEHEIGHT) &&
   !toNextStateLevel3Tile(tx, (int) (y + bounds.y + bounds.height) / Tile.TILEHEIGHT)){}
   else{
    State.setState(new Level3(handler));
   }
   if(!toNextStateLevel4Tile(tx, (int) (y + bounds.y) / Tile.TILEHEIGHT) &&
   !toNextStateLevel4Tile(tx, (int) (y + bounds.y + bounds.height) / Tile.TILEHEIGHT)){}
   else{
    State.setState(new Level4(handler));
   }
   if(!toNextStateLevel5Tile(tx, (int) (y + bounds.y) / Tile.TILEHEIGHT) &&
   !toNextStateLevel5Tile(tx, (int) (y + bounds.y + bounds.height) / Tile.TILEHEIGHT)){}
   else{
    State.setState(new CompleteState(handler));
   }
   
   
   if(!collisionWithTile(tx, (int) (y + bounds.y) / Tile.TILEHEIGHT) &&
   !collisionWithTile(tx, (int) (y + bounds.y + bounds.height) / Tile.TILEHEIGHT)){
    x += xMove;
   }else{
    x = tx * Tile.TILEWIDTH + Tile.TILEWIDTH - bounds.x;
   }
  }
 }
 
 public void moveY(){

  if(yMove < 0){//Up
   
   int ty = (int) (y + yMove + bounds.y) / Tile.TILEHEIGHT;
   
   if(!toNextStateLevel1Tile((int) (x + bounds.x) / Tile.TILEWIDTH, ty) &&
   !toNextStateLevel1Tile((int) (x + bounds.x + bounds.width) / Tile.TILEWIDTH, ty)){}
   else{
    State.setState(new Level1(handler));
   }
   if(!toNextStateLevel2Tile((int) (x + bounds.x) / Tile.TILEWIDTH, ty) &&
   !toNextStateLevel2Tile((int) (x + bounds.x + bounds.width) / Tile.TILEWIDTH, ty)){}
   else{
    State.setState(new Level2(handler));
   }
   if(!toNextStateLevel3Tile((int) (x + bounds.x) / Tile.TILEWIDTH, ty) &&
   !toNextStateLevel3Tile((int) (x + bounds.x + bounds.width) / Tile.TILEWIDTH, ty)){}
   else{
    State.setState(new Level3(handler));
   }
   if(!toNextStateLevel4Tile((int) (x + bounds.x) / Tile.TILEWIDTH, ty) &&
   !toNextStateLevel4Tile((int) (x + bounds.x + bounds.width) / Tile.TILEWIDTH, ty)){}
   else{
    State.setState(new Level4(handler));
   }
   if(!toNextStateLevel5Tile((int) (x + bounds.x) / Tile.TILEWIDTH, ty) &&
   !toNextStateLevel5Tile((int) (x + bounds.x + bounds.width) / Tile.TILEWIDTH, ty)){}
   else{
    State.setState(new CompleteState(handler));
   }
   
   
   if(!collisionWithTile((int) (x + bounds.x) / Tile.TILEWIDTH, ty) &&
   !collisionWithTile((int) (x + bounds.x + bounds.width) / Tile.TILEWIDTH, ty)){
    y += yMove;
   }else{
    y = ty * Tile.TILEHEIGHT + Tile.TILEHEIGHT - bounds.y;
   } 
  }
  
  else if(yMove > 0){//Down
   
   int ty = (int) (y + yMove + bounds.y + bounds.height) / Tile.TILEHEIGHT;
   
   if(!toNextStateLevel1Tile((int) (x + bounds.x) / Tile.TILEWIDTH, ty) &&
   !toNextStateLevel1Tile((int) (x + bounds.x + bounds.width) / Tile.TILEWIDTH, ty)){}
   else{
    State.setState(new Level1(handler));
   }  
   if(!toNextStateLevel2Tile((int) (x + bounds.x) / Tile.TILEWIDTH, ty) &&
   !toNextStateLevel2Tile((int) (x + bounds.x + bounds.width) / Tile.TILEWIDTH, ty)){}
   else{
    State.setState(new Level2(handler));
   } 
   if(!toNextStateLevel3Tile((int) (x + bounds.x) / Tile.TILEWIDTH, ty) &&
   !toNextStateLevel3Tile((int) (x + bounds.x + bounds.width) / Tile.TILEWIDTH, ty)){}
   else{
    State.setState(new Level3(handler));
   }
   if(!toNextStateLevel4Tile((int) (x + bounds.x) / Tile.TILEWIDTH, ty) &&
   !toNextStateLevel4Tile((int) (x + bounds.x + bounds.width) / Tile.TILEWIDTH, ty)){}
   else{
    State.setState(new Level4(handler));
   }
   if(!toNextStateLevel5Tile((int) (x + bounds.x) / Tile.TILEWIDTH, ty) &&
   !toNextStateLevel5Tile((int) (x + bounds.x + bounds.width) / Tile.TILEWIDTH, ty)){}
   else{
    State.setState(new CompleteState(handler));
   }
   
   
   
   if(!collisionWithTile((int) (x + bounds.x) / Tile.TILEWIDTH, ty) &&
   !collisionWithTile((int) (x + bounds.x + bounds.width) / Tile.TILEWIDTH, ty)){
    y += yMove;
   }else{
    y = ty * Tile.TILEHEIGHT - bounds.y - bounds.height - 1;
   }
   
  }
 }
 
 protected boolean collisionWithTile(int x, int y){
  return handler.getWorld().getTile(x, y).isSolid();
 }
 
 protected boolean toNextStateLevel1Tile(int x, int y){
  return handler.getWorld().getTile(x, y).nextState(); 
 }
 protected boolean toNextStateLevel2Tile(int x, int y){
  return handler.getWorld().getTile(x, y).nextState2(); 
 }
 protected boolean toNextStateLevel3Tile(int x, int y){
  return handler.getWorld().getTile(x, y).nextState3(); 
 }
 protected boolean toNextStateLevel4Tile(int x, int y){
  return handler.getWorld().getTile(x, y).nextState4(); 
 }
 protected boolean toNextStateLevel5Tile(int x, int y){
  return handler.getWorld().getTile(x, y).nextState5(); 
 }
 
 
//GETTERS SETTERS
 public float getxMove() {
  return xMove;
 }


	public void setxMove(float xMove) {
		this.xMove = xMove;
	}

	public float getyMove() {
		return yMove;
	}

	public void setyMove(float yMove) {
		this.yMove = yMove;
	}

	public int getHealth() {
		return health;
	}

	public void setHealth(int health) {
		this.health = health;
	}

	public float getSpeed() {
		return speed;
	}

	public void setSpeed(float speed) {
		this.speed = speed;
	}
	
}