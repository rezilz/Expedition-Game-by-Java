package dev.rezilz.expedition.tiles;

import dev.rezilz.expedition.gfx.Assets;

public class Level1Tile extends Tile {

	public Level1Tile(int id, int format) {
		super(Assets.goal, id,format);
	}
	
	@Override
	public boolean isSolid(){
		return true;
	}
	
	public boolean nextState() {
		return true;
	}

}