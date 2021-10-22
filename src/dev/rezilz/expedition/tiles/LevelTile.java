package dev.rezilz.expedition.tiles;

import dev.rezilz.expedition.gfx.Assets;

public class LevelTile extends Tile {

	public LevelTile(int id, int format) {
		super(Assets.grassbeta, id,format);
	}
	
	@Override
	public boolean isSolid(){
		return false;
	}
	
	public boolean nextState() {
		return true;
	}

}