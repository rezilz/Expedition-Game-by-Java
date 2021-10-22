package dev.rezilz.expedition.tiles;

import dev.rezilz.expedition.gfx.Assets;

public class BorderGrass4Tile extends Tile {// 30/4/63
	
	public BorderGrass4Tile(int id, int format) {
		super(Assets.bordergrass4, id, format);
	}
	
	@Override
	public boolean isSolid(){
		return true;
	}

}
