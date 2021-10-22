package dev.rezilz.expedition.tiles;

import dev.rezilz.expedition.gfx.Assets;

public class BorderGrass3Tile extends Tile {// 30/4/63
	
	public BorderGrass3Tile(int id, int format) {
		super(Assets.bordergrass3, id, format);
	}
	
	@Override
	public boolean isSolid(){
		return true;
	}

}
