package dev.rezilz.expedition.entities.statics;

import dev.rezilz.expedition.Handler;
import dev.rezilz.expedition.entities.Entity;

public abstract class StaticEntity extends Entity {
	
	public StaticEntity(Handler handler, float x, float y, int width, int height){
		super(handler, x, y, width, height);
	}

}