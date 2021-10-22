package dev.rezilz.expedition.tiles;

import dev.rezilz.expedition.gfx.Assets;

public class Level4Tile extends Tile {

	public Level4Tile(int id, int format) {
		super(Assets.goal, id,format);
	}
	
	@Override
	public boolean isSolid(){
		return true;
	}
	
	public boolean nextState4() {
		return true;
	}

}