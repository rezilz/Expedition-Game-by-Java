package dev.rezilz.expedition.tiles;

import dev.rezilz.expedition.gfx.Assets;

public class Level3Tile extends Tile {

	public Level3Tile(int id, int format) {
		super(Assets.goal, id,format);
	}
	
	@Override
	public boolean isSolid(){
		return true;
	}
	
	public boolean nextState3() {
		return true;
	}

}