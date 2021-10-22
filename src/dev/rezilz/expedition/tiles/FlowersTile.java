package dev.rezilz.expedition.tiles;

import dev.rezilz.expedition.gfx.Assets;

public class FlowersTile  extends Tile {// 30/4/63

	public FlowersTile(int id, int format) {
		super(Assets.flowers, id, format);
	}
	
	@Override
	public boolean isSolid(){
		return false;
	}

}
