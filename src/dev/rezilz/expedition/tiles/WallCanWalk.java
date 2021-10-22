package dev.rezilz.expedition.tiles;

import dev.rezilz.expedition.gfx.Assets;

	public class WallCanWalk extends Tile {// 30/4/63

		public WallCanWalk(int id, int format) {
			super(Assets.wall, id, format);
		}
		
		@Override
		public boolean isSolid(){
			return false;
		}

	}
