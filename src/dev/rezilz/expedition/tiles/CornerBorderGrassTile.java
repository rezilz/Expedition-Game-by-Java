package dev.rezilz.expedition.tiles;

import dev.rezilz.expedition.gfx.Assets;

public class CornerBorderGrassTile extends Tile {

	public CornerBorderGrassTile(int id, int format) {
		super(Assets.cornerbordergrass, id, format);
	}
	@Override
	public boolean isSolid(){
		return true;
	}  

}
