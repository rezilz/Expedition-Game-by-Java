package dev.rezilz.expedition.tiles;

import dev.rezilz.expedition.gfx.Assets;

public class Level2Tile extends Tile {

	public Level2Tile(int id, int format) {
		super(Assets.goal, id,format);
	}
	
	@Override
	public boolean isSolid(){
		return true;
	}
	
	public boolean nextState2() {
		return true;
	}

}
