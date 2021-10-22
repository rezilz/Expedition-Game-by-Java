package dev.rezilz.expedition.gfx;

import java.awt.image.BufferedImage;

public class Assets {
	
	private static final int width = 32, height = 32;
	
	public static BufferedImage tree;
	public static BufferedImage[] dirt, grass, stone, stick, rock, grassbeta;
	public static BufferedImage[] player_down, player_up, player_left, player_right;
	public static BufferedImage[] bordergrass,bordergrass2;
	public static BufferedImage[] btn_start, btn_start2, btn_help, btn_members, btn_return;
	public static BufferedImage[] bordergrass3,flowers,wall,cornerbordergrass,goal,bordergrass4,brickwall;
	//SPRITESHEETS
	public static final String SPRITESHEET1 = "res/textures/sheet1.png";
	public static final String SPRITESHEET2 = "res/tiles/grass copy.png";
	public static final String GRASSSPRITE = "res/tiles/block.png";
	public static final String BORDERGRASSSPRITE = "res/tiles/bordergrass.png";
	public static final String BUTTONSPRITE = "res/textures/startbutton.png";
	public static final String BORDERGRASSSPRITE3 = "res/tiles/bordergrass3.png";
	public static final String WALL = "res/tiles/wall.png";
	public static final String FLOWERS = "res/tiles/flowers.png";
	public static final String CORNERBORDERGRASS = "res/tiles/cornerbordergrass.png";
	public static final String GOAL = "res/tiles/goal.png";
	public static final String BORDERGRASSSPRITE4 = "res/tiles/bordergrass4.png";
	public static final String BRICKWALL = "res/tile/brick.png";
	
	//CREATURES
	public static final String PLAYER = "res/entity/linkformatted.png";
	
	//STATES BACKGROUND
	public static final String WALLPAPER = "res/screens/source.gif";
	public static final String WALLPAPER1 = "res/screens/source1.gif";
	public static final String WALLPAPER2 = "res/screens/source2.gif";
	
	public static final String SPLASH_INFO = "res/screens/storyboard.png";

	public static final String LOGO_MENU = "res/logos/game.png";
	public static final String LOGO_MEMBER = "res/logos/members.png";
	public static final String LOGO_HELP = "res/logos/howtoplay.png";
	
	public static final String KEYBOARD = "res/logos/keyboards.png";
	public static final String MEMBER = "res/logos/membersdetail.png";
	public static final String CLOCK = "res/textures/c5.gif";
	public static final String CLOCKLAYER = "res/textures/t.png";
	
	//AUDIO TRACKS
	public static final String WIN_SOUND = "res/audio/congrats.wav";
	public static final String LOSE_SOUND = "res/audio/over.wav";
	public static final String HELP_SOUND = "res/audio/help.wav";
	public static final String MEMBER_SOUND = "res/audio/member.wav";
	public static final String MENU_SOUND = "res/audio/bubblegum.wav";
	public static final String SPLASH_SOUND ="res/audio/splash.wav";
	
	//OTHERS
	public static final String CURSOR = "res/textures/cursor.png";

	public static void init(){
		SpriteSheet sheet = new SpriteSheet(ImageLoader.loadImage(SPRITESHEET1));
		SpriteSheet sheet2 = new SpriteSheet(ImageLoader.loadImage(SPRITESHEET2));
		SpriteSheet sheet3 = new SpriteSheet(ImageLoader.loadImage(GRASSSPRITE));
		SpriteSheet sheet4 = new SpriteSheet(ImageLoader.loadImage(BUTTONSPRITE));
		SpriteSheet sheet5 = new SpriteSheet(ImageLoader.loadImage(BORDERGRASSSPRITE));
		SpriteSheet sheet6 = new SpriteSheet(ImageLoader.loadImage(BORDERGRASSSPRITE3));// 30/4/63
		SpriteSheet sheet7 = new SpriteSheet(ImageLoader.loadImage(WALL));// 30/4/63
		SpriteSheet sheet8 = new SpriteSheet(ImageLoader.loadImage(FLOWERS));// 30/4/63
		SpriteSheet sheet9 = new SpriteSheet(ImageLoader.loadImage(CORNERBORDERGRASS));// 30/4/63
		SpriteSheet sheet10 = new SpriteSheet(ImageLoader.loadImage(GOAL));// 30/4/63
		SpriteSheet sheet11 = new SpriteSheet(ImageLoader.loadImage(BORDERGRASSSPRITE4));// 30/4/63
		SpriteSheet sheet12 = new SpriteSheet(ImageLoader.loadImage(BRICKWALL));// 30/4/63
		
		SpriteSheet playersheet = new SpriteSheet(ImageLoader.loadImage(PLAYER));
		
		grass = new BufferedImage[1];
		dirt = new BufferedImage[1];
		grassbeta = new BufferedImage[1];
		stone = new BufferedImage[1];
		rock = new BufferedImage[1];
		
		player_right = new BufferedImage[8]; //frame of each animation
		player_left = new BufferedImage[8];
		player_down = new BufferedImage[8];
		player_up = new BufferedImage[8];
		
		for(int i=0, j=0;i<=7;i++) {
			player_right[i] = playersheet.crop(width*i,height*j, width, height);
			player_left[i] = playersheet.crop(width*i, height*(j+1), width, height);
			player_down[i] =  playersheet.crop(width*i, height*(j+2), width, height);
			player_up[i] = playersheet.crop(width*i, height*(j+3), width, height);

		} 
		
		
		dirt[0] = sheet.crop(width, 0, width, height);
		grass[0] = sheet.crop(width * 2, 0, width, height);
		grassbeta[0] = sheet2.crop(0, 0, width, height);
		stone[0] = sheet.crop(width * 3, 0, width, height);
		tree = sheet.crop(0, 0, width, height*2);
		rock[0] = sheet.crop(0, height * 2, width, height);
		//stick = sheet.crop(width, height, width, height);
		//stick = ImageLoader.loadImage(MENU_STATE);
		
		
		btn_start = new BufferedImage[2];
		btn_start[0] = sheet.crop(width * 6, height * 4, width * 2, height);
		btn_start[1] = sheet.crop(width * 6, height * 5, width * 2, height);
		
		btn_start2 = new BufferedImage[2];
		btn_start2[1] = sheet4.crop(0,0, width * 2, height);
		btn_start2[0] = sheet4.crop(0, height, width * 2, height);

		btn_help = new BufferedImage[2];
		btn_help[1] = sheet4.crop(0, height * 2, width * 2, height);
		btn_help[0] = sheet4.crop(0, height * 3, width * 2, height);

		btn_members = new BufferedImage[2];
		btn_members[1] = sheet4.crop(0, height * 4, width * 2, height);
		btn_members[0] = sheet4.crop(0, height * 5, width * 2, height);
		
		btn_return = new BufferedImage[2];
		btn_return[1] = sheet4.crop(0, height * 6, width * 2, height);
		btn_return[0] = sheet4.crop(0, height * 7, width * 2, height);
		
		bordergrass = new BufferedImage[9];
		bordergrass [0] = sheet3.crop(0, 0, width, height);
		bordergrass [1] = sheet3.crop(width, 0, width, height);
		bordergrass [2] = sheet3.crop(width*2, 0, width, height);
		bordergrass [3] = sheet3.crop(0, height, width, height);
		bordergrass [4] = sheet3.crop(width, height, width, height);
		bordergrass [5] = sheet3.crop(width*2, height, width, height);
		bordergrass [6] = sheet3.crop(0, height*2, width, height);
		bordergrass [7] = sheet3.crop(width, height*2, width, height);
		bordergrass [8] = sheet3.crop(width*2, height*2, width, height);
		
		bordergrass2 = new BufferedImage[12];
		bordergrass2 [0] = sheet5.crop(0, 0, width, height);
		bordergrass2 [1] = sheet5.crop(width, 0, width, height);
		bordergrass2 [2] = sheet5.crop(width*2, 0, width, height);
		bordergrass2 [3] = sheet5.crop(0, height, width, height);
		bordergrass2 [4] = sheet5.crop(width, height, width, height);
		bordergrass2 [5] = sheet5.crop(width*2, height, width, height);
		bordergrass2 [6] = sheet5.crop(0, height*2, width, height);
		bordergrass2 [7] = sheet5.crop(width, height*2, width, height);
		bordergrass2 [8] = sheet5.crop(width*2, height*2, width, height);
		bordergrass2 [9] = sheet5.crop(0, height*3, width, height);
		bordergrass2 [10] = sheet5.crop(width, height*3, width, height);
		bordergrass2 [11] = sheet5.crop(width*2, height*3, width, height);
		
		// 30/4/63
		bordergrass3 = new BufferedImage[9];
		bordergrass3 [0] = sheet6.crop(0, 0, width, height);
		bordergrass3 [1] = sheet6.crop(width, 0, width, height);
		bordergrass3 [2] = sheet6.crop(width*2, 0, width, height);
		bordergrass3 [3] = sheet6.crop(0, height, width, height);
		bordergrass3 [4] = sheet6.crop(width, height, width, height);
		bordergrass3 [5] = sheet6.crop(width*2, height, width, height);
		bordergrass3 [6] = sheet6.crop(0, height*2, width, height);
		bordergrass3 [7] = sheet6.crop(width, height*2, width, height);
		bordergrass3 [8] = sheet6.crop(width*2, height*2, width, height);
		
		// 30/4/63
		wall = new BufferedImage[17];
		wall [0] = sheet7.crop(0,		0, width, height);
		wall [1] = sheet7.crop(width,	0, width, height);
		wall [2] = sheet7.crop(width*2, 0, width, height);
		wall [3] = sheet7.crop(width*3,	0, width, height);
		wall [4] = sheet7.crop(0, 		height, width, height);
		wall [5] = sheet7.crop(width,	height, width, height);
		wall [6] = sheet7.crop(width*2,	height, width, height);
		wall [7] = sheet7.crop(width*3, height, width, height);
		wall [8] = sheet7.crop(0, 		height*2, width, height);
		wall [9] = sheet7.crop(width, 	height*2, width, height);
		wall [10] = sheet7.crop(width*2,height*2, width, height);
		wall [11] = sheet7.crop(width*3,height*2, width, height);
		wall [12] = sheet7.crop(0, 		height*3, width, height);
		wall [13] = sheet7.crop(width,	height*3, width, height);
		wall [14] = sheet7.crop(width*1,height*3, width, height);
		wall [15] = sheet7.crop(width*2,height*3, width, height);
		wall [16] = sheet7.crop(0, 		height*4, width, height);
		// 30/4/63
		flowers = new BufferedImage[9];
		flowers [0] = sheet8.crop(0,	0, width, height);
		flowers [1] = sheet8.crop(width,0, width, height);
		flowers [2] = sheet8.crop(0, 	height, width, height);
		flowers [3] = sheet8.crop(width,height, width, height);
		flowers [4] = sheet8.crop(0, 	height*2, width, height);
		flowers [5] = sheet8.crop(width,height*2, width, height);
		
		cornerbordergrass = new BufferedImage[5];
		cornerbordergrass [0] = sheet9.crop(0,		0, width, height);
		cornerbordergrass [1] = sheet9.crop(width,	0, width, height);
		cornerbordergrass [2] = sheet9.crop(0, 		height, width, height);
		cornerbordergrass [3] = sheet9.crop(width,	height, width, height);
		
		
		goal = new BufferedImage[5];
		goal [0] = sheet10.crop(0,	0, width, height);
		goal [1] = sheet10.crop(0,	0, width, height);
		goal [2] = sheet10.crop(0,	0, width, height);
		goal [3] = sheet10.crop(0,	0, width, height);
		goal [4] = sheet10.crop(0,	0, width, height);
		
		bordergrass4 = new BufferedImage[6];
		bordergrass4 [0] = sheet11.crop(0,		0, width, height);
		bordergrass4 [1] = sheet11.crop(width,	0, width, height);
		bordergrass4 [2] = sheet11.crop(0,		height, width, height);
		bordergrass4 [3] = sheet11.crop(width,	height, width, height);
		bordergrass4 [4] = sheet11.crop(0,		height*2, width, height);
		bordergrass4 [5] = sheet11.crop(width,	height*2, width, height);
	
		brickwall = new BufferedImage[6];
		brickwall [0] = sheet12.crop(width*18,height*14, width, height);
		brickwall [1] = sheet12.crop(width*19,height*14, width, height);
		brickwall [2] = sheet12.crop(width*20,height*14, width, height);
		brickwall [3] = sheet12.crop(width*18,height*15, width, height);
		brickwall [4] = sheet12.crop(width*19,height*15, width, height);
		brickwall [5] = sheet12.crop(width*20,height*15, width, height);
		
	}}
	
