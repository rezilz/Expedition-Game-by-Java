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
import dev.rezilz.expedition.tiles.Tile;
import dev.rezilz.expedition.ui.ClickListener;
import dev.rezilz.expedition.ui.UIImageButton;
import dev.rezilz.expedition.ui.UIManager;
import dev.rezilz.expedition.utils.Fonts;
import dev.rezilz.expedition.worlds.World;

import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;

public class SplashState extends State {
	
	private long startGameTime;
	private MusicPlayer splash;
	
	public SplashState(Handler handler){
		super(handler);
		splash = new MusicPlayer(Assets.SPLASH_SOUND,false);
		startGameTime = System.currentTimeMillis();;	
			
	       }
	
	@Override
	public void tick() {
		splash.play();
	}
	
	@Override
	public void render(Graphics g) {
		
		Toolkit toolkit = Toolkit.getDefaultToolkit();
		Image menu = toolkit.getImage(Assets.WALLPAPER);
		g.drawImage(menu,0,0, null);
      
		Image menu2 = toolkit.getImage(Assets.SPLASH_INFO);
		g.drawImage(menu2,0,0, null);
		
		if((25-(System.currentTimeMillis()-startGameTime)/1000)>5) {
     Fonts.drawString(g, new Font("Comic Sans MS", Font.PLAIN, 20), Color.WHITE,"" +(25-(System.currentTimeMillis()-startGameTime)/1000),640); }
		else {
	Fonts.drawString(g, new Font("Comic Sans MS", Font.PLAIN, 20), Color.ORANGE,"" +(25-(System.currentTimeMillis()-startGameTime)/1000),640);	
		}
          
       if(System.currentTimeMillis() - startGameTime >= 25000) {
    	   State.setState(new MenuState(handler)); 
    	   splash.stop();
       }

	}

}
