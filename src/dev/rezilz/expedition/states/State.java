package dev.rezilz.expedition.states;

import java.awt.Graphics;

import dev.rezilz.expedition.Game;
import dev.rezilz.expedition.Handler;


public abstract class State { //tell what each state should have 

	private static State currentState = null;
	
	public static void setState(State state){
		currentState = state;
	}
	
	public static State getState(){
		return currentState;
	}
	
	
	
	//CLASS
	
	protected Handler handler;
	
	public  State(Handler handler) {
		this.handler = handler;
	}
	public abstract void tick();
	
	public abstract void render(Graphics g);
	
}