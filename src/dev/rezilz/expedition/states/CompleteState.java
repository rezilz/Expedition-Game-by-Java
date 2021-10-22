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


public class CompleteState extends State {
	
	private long startGameTime;
	private UIManager uiManager;
	private MusicPlayer con;

	public CompleteState(Handler handler){
		super(handler);
		con = new MusicPlayer(Assets.WIN_SOUND,false);
		startGameTime = System.currentTimeMillis();;	
		uiManager = new UIManager(handler);
		handler.getMouseManager().setUIManager(uiManager);

		uiManager.addObject(new UIImageButton(358, 550, 128, 64, Assets.btn_start2, new ClickListener() {
			@Override
			public void onClick() {
				handler.getMouseManager().setUIManager(null);
				State.setState(new Level1(handler));
			}
		}));

		uiManager.addObject(new UIImageButton(714, 550, 128, 64, Assets.btn_return, new ClickListener() {
			@Override
			public void onClick() {
				handler.getMouseManager().setUIManager(null);
				State.setState(new MenuState(handler));
			}
		}));
	       }
	
	@Override
	public void tick() {
		uiManager.tick();
		con.play();
		if(System.currentTimeMillis() - startGameTime >= 4000) {
	      	 con.stop();
	}
	}
	
	@Override
	public void render(Graphics g) {
		g.setColor(new Color(244, 142, 116));
		g.fillRect(0,0,1200,675);
		
		Toolkit toolkit = Toolkit.getDefaultToolkit();
      Image menu2 = toolkit.getImage("res/screens/congrats.png");
      g.drawImage(menu2,397,60, null);
      Image menu3 = toolkit.getImage("res/screens/pizza.gif");
      g.drawImage(menu3,472,160, null);

      
      Fonts.drawString(g, new Font("Comic Sans MS", Font.BOLD, 20), Color.WHITE,"A piece of pizza! " +"("+(10-(System.currentTimeMillis()-startGameTime)/1000)+")",500);
      uiManager.render(g);
      if(System.currentTimeMillis() - startGameTime >= 10000) {
      	   State.setState(new MenuState(handler)); 
         }    	   
       }

	}