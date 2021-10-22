package dev.rezilz.expedition.tiles;


import java.awt.Graphics;
import java.awt.image.BufferedImage;

public class Tile {
	
	//STATIC STUFF
	
	public static Tile[] tiles = new Tile[256];
	public static Tile grassTile = new GrassTile(0,4);
	public static Tile dirtTile = new DirtTile(1,0);
	public static Tile rockTile = new RockTile(02,0);
	public static Tile levelTile = new LevelTile(3,0);
	public static Tile grassbetaTile = new GrassTile(5,1);
	public static Tile grass2betaTile = new GrassTile(6,2);
	//BORDERGRASSTILE
	public static Tile bg1 = new BorderGrassTile(10,0);
	public static Tile bg2 = new BorderGrassTile(11,1);
	public static Tile bg3 = new BorderGrassTile(12,2);
	public static Tile bg4 = new BorderGrassTile(13,3);
	public static Tile bg5 = new BorderGrassTile(14,4);
	public static Tile bg6 = new BorderGrassTile(15,5);
	public static Tile bg7 = new BorderGrassTile(16,6);
	public static Tile bg8 = new BorderGrassTile(17,7);
	public static Tile bg9 = new BorderGrassTile(18,8);
	public static Tile bg10 = new BorderGrassTile(19,9);
	public static Tile bg11 = new BorderGrassTile(20,10);
	public static Tile bg12 = new BorderGrassTile(21,11);
	
	public static Tile bg13 = new WallTile(22,0);
	public static Tile bg14 = new WallTile(23,1);
	public static Tile bg15 = new WallTile(24,2);
	public static Tile bg16 = new WallTile(25,3);
	public static Tile bg17 = new WallTile(26,4);
	public static Tile bg18 = new WallTile(27,5);
	public static Tile bg19 = new WallTile(28,6);
	public static Tile bg20 = new WallTile(29,7);
	public static Tile bg21 = new WallTile(30,8);
	public static Tile bg22 = new WallTile(31,9);
	public static Tile bg23 = new WallTile(32,10);
	public static Tile bg24 = new WallTile(33,11);
	public static Tile bg25 = new WallTile(34,12);
	public static Tile bg26 = new WallCanWalk(35,13);
	public static Tile bg27 = new WallCanWalk(36,14);
	public static Tile bg28 = new WallCanWalk(37,15);
	public static Tile bg29 = new WallCanWalk(38,16);
	
	public static Tile bg30 = new BorderGrass3Tile(39,0);
	public static Tile bg31 = new BorderGrass3Tile(40,1);
	public static Tile bg32 = new BorderGrass3Tile(41,2);
	public static Tile bg33 = new BorderGrass3Tile(42,3);
	public static Tile bg34 = new BorderGrass3Tile(43,4);
	public static Tile bg35 = new BorderGrass3Tile(44,5);
	public static Tile bg36 = new BorderGrass3Tile(45,6);
	public static Tile bg37 = new BorderGrass3Tile(46,7);
	public static Tile bg38 = new BorderGrass3Tile(47,8);
	
	public static Tile bg39 = new FlowersTile(48,0);
	public static Tile bg40 = new FlowersTile(49,1);
	public static Tile bg41 = new FlowersTile(50,2);
	public static Tile bg42 = new FlowersTile(51,3);
	public static Tile bg43 = new FlowersTile(52,4);
	public static Tile bg44 = new FlowersTile(53,5);
	
	public static Tile bg45 = new CornerBorderGrassTile(54,0);
	public static Tile bg48 = new CornerBorderGrassTile(55,1);
	public static Tile bg46 = new CornerBorderGrassTile(56,2);
	public static Tile bg47 = new CornerBorderGrassTile(57,3);
	//public static Tile bg49 = new BorderGrassTile(58,4);//grass can walk
	
	public static Tile bg50 = new Level1Tile(59,0);
	public static Tile bg51 = new Level2Tile(60,1);
	public static Tile bg52 = new Level3Tile(61,2);
	public static Tile bg53 = new Level4Tile(62,3);
	public static Tile bg54 = new Level5Tile(63,4);
	
	public static Tile bg55 = new BorderGrass4Tile(64,0);
	public static Tile bg56 = new BorderGrass4Tile(65,1);
	public static Tile bg57 = new BorderGrass4Tile(66,2);
	public static Tile bg58 = new BorderGrass4Tile(67,3);
	public static Tile bg59 = new BorderGrass4Tile(68,4);
	public static Tile bg60 = new BorderGrass4Tile(69,5);
	
	public static Tile bg61 = new BrickTile(70,0);
	public static Tile bg62 = new BrickTile(71,1);
	public static Tile bg63 = new BrickTile(72,2);
	public static Tile bg64 = new BrickTile(73,3);
	public static Tile bg65 = new BrickTile(74,4);
	public static Tile bg66 = new BrickTile(75,5);
	
	
	//public static Tile goal = new N(4);
	
	//public static Tile grassTile2 = new GrassTile(0);
	
	//CLASS
	
	public static final int TILEWIDTH = 64, TILEHEIGHT = 64;
	
	protected BufferedImage[] texture;
	protected final int id;
	protected final int format;
	
	public Tile(BufferedImage[] texture, int id, int format){
		this.texture = texture;
		this.id = id;
		this.format = format;
		
		tiles[id] = this;
	}
	
	
	
	public void tick(){
		
	}
	
	public void render(Graphics g, int x, int y){
		g.drawImage(texture[format], x, y, TILEWIDTH, TILEHEIGHT, null);
	}
	
	public boolean isSolid(){
		return false;
	}
	
	public boolean nextState2(){ 
		return false;
	}
	public boolean nextState3(){ 
		return false;
	}
	public boolean nextState4(){ 
		return false;
	}
	public boolean nextState5(){ 
		return false;
	}
	public boolean nextState(){ 
		return false;
	}
	public int getId(){
		return id;
	}
	
}