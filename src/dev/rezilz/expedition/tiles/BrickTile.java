package dev.rezilz.expedition.tiles;

import dev.rezilz.expedition.gfx.Assets;

public class BrickTile extends Tile {

	public BrickTile(int id, int format) {
		super(Assets.brickwall, id, format);
	}
	
	@Override
	public boolean isSolid(){
		return true;
	}

}
