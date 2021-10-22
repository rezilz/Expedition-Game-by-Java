package dev.rezilz.expedition.tiles;

import dev.rezilz.expedition.gfx.Assets;

public class Level5Tile extends Tile {

	public Level5Tile(int id, int format) {
		super(Assets.goal, id,format);
	}
	
	@Override
	public boolean isSolid(){
		return true;
	}
	
	public boolean nextState5() {
		return true;
	}

}