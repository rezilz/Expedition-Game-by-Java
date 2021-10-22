package dev.rezilz.expedition.tiles;

import dev.rezilz.expedition.gfx.Assets;

public class RockTile extends Tile {

	public RockTile(int id, int format) {
		super(Assets.stone, id, format);
	}
	
	@Override
	public boolean isSolid(){
		return true;
	}

}