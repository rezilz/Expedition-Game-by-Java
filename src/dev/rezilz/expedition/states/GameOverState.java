package dev.rezilz.expedition.states;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.Toolkit;

import dev.rezilz.expedition.Game;
import dev.rezilz.expedition.Handler;
import dev.rezilz.expedition.audio.MusicPlayer;
import dev.rezilz.expedition.entities.creatures.Player;
import dev.rezilz.expedition.entities.statics.Tree;
import dev.rezilz.expedition.gfx.Assets;
import dev.rezilz.expedition.states.levels.Level1;
import dev.rezilz.expedition.tiles.Tile;
import dev.rezilz.expedition.ui.ClickListener;
import dev.rezilz.expedition.ui.UIImageButton;
import dev.rezilz.expedition.ui.UIManager;
import dev.rezilz.expedition.utils.Fonts;
import dev.rezilz.expedition.worlds.World;


public class GameOverState extends State {
	
	private long startGameTime;
	private UIManager uiManager;
	private MusicPlayer over;

	public GameOverState(Handler handler){
		super(handler);
		over = new MusicPlayer(Assets.LOSE_SOUND,false);
		startGameTime = System.currentTimeMillis();;	
		uiManager = new UIManager(handler);
		handler.getMouseManager().setUIManager(uiManager);

		uiManager.addObject(new UIImageButton(358, 550, 128, 64, Assets.btn_start2, new ClickListener() {
			@Override
			public void onClick() {
				handler.getMouseManager().setUIManager(null);
				//State.setState(handler.getGame().gameState);
				State.setState(new Level1(handler));
			}
		}));

		uiManager.addObject(new UIImageButton(714, 550, 128, 64, Assets.btn_return, new ClickListener() {
			@Override
			public void onClick() {
				handler.getMouseManager().setUIManager(null);
				//State.setState(handler.getGame().helpState);
				State.setState(new MenuState(handler));
			}
		}));
	       }
	
	@Override
	public void tick() {
		uiManager.tick();
		over.play();
		if(System.currentTimeMillis() - startGameTime >= 6000) {
	      	 over.stop();
	}
	}
	
	@Override
	public void render(Graphics g) {
		Toolkit toolkit = Toolkit.getDefaultToolkit();
		Image menu = toolkit.getImage(Assets.WALLPAPER);
		g.drawImage(menu,0,0, null);
		
      Image menu2 = toolkit.getImage("res/screens/over2.gif");
      g.drawImage(menu2,430,60, null);
      Image menu3 = toolkit.getImage("res/screens/over4.gif");
      g.drawImage(menu3,430,250, null);

      
      Fonts.drawString(g, new Font("Comic Sans MS", Font.BOLD, 20), Color.WHITE,"As previously mentioned... You're lost, then starting the first level!! " +"("+(10-(System.currentTimeMillis()-startGameTime)/1000)+")",330);
      uiManager.render(g);
      if(System.currentTimeMillis() - startGameTime >= 10000) {
      	//Fonts.drawString(g, new Font("Comic Sans MS", Font.PLAIN, 20), Color.WHITE,">> Click anywhere to continue.. <<",610);
      	   State.setState(new MenuState(handler)); 
         }    	   
       }

	}
