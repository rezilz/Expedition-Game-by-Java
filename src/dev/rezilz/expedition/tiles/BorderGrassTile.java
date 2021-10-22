package dev.rezilz.expedition.tiles;

import dev.rezilz.expedition.gfx.Assets;

public class BorderGrassTile extends Tile {

	public BorderGrassTile(int id, int format) {
		super(Assets.bordergrass2, id, format);
	}
	
	@Override
	public boolean isSolid(){
		return true;
	}

}