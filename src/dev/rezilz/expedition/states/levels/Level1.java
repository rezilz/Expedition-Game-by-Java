package dev.rezilz.expedition.states.levels;

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
import dev.rezilz.expedition.states.GameOverState;
import dev.rezilz.expedition.states.MenuState;
import dev.rezilz.expedition.states.State;
import dev.rezilz.expedition.tiles.Tile;
import dev.rezilz.expedition.utils.Fonts;
import dev.rezilz.expedition.worlds.World;

public class Level1 extends State {
	
	private World world;
	private long startGameTime,lastGameTime,screenTime;
	
	public Level1(Handler handler){
		super(handler);
		world = new World(handler, "res/worlds/level1.txt");
		handler.setWorld(world);
		startGameTime = System.currentTimeMillis();;
		screenTime = 3;
		lastGameTime = 20+screenTime;
		//game2.setGain(volume);
	}
				
	
	@Override
	public void tick() {
		world.tick();
		
	}

	@Override
	public void render(Graphics g) {
		Toolkit toolkit = Toolkit.getDefaultToolkit();
		if((System.currentTimeMillis()-startGameTime)/1000<screenTime){
		g.setColor(Color.black);
		g.fillRect(0, 0, 1200,675);
		Fonts.drawString(g, new Font("Candara", Font.PLAIN, 78), Color.WHITE,"LEVEL 1",340); 
				//Fonts.drawString(g, new Font("Comic Sans MS", Font.PLAIN, 25), Color.WHITE,"Time Duration: 10 sec",360); 
		}
		if((System.currentTimeMillis()-startGameTime)/1000>=screenTime){
			world.render(g); 
			Image menu3 = toolkit.getImage(Assets.CLOCKLAYER);
	        g.drawImage(menu3,0,0, null);
	        Image menu4 = toolkit.getImage(Assets.CLOCK);
	        g.drawImage(menu4,960,24, null);
	        if((lastGameTime-(System.currentTimeMillis()-startGameTime)/1000)>5) {
	        Fonts.drawString(g, new Font("Comic Sans MS", Font.BOLD, 20),Color.WHITE ,"Timer:" + " " +(lastGameTime-(System.currentTimeMillis()-startGameTime)/1000),1020,61);
	        }
	        else {
	        	Fonts.drawString(g, new Font("Comic Sans MS", Font.BOLD, 20),new Color(255, 105, 97) ,"Timer:" + " " +(lastGameTime-(System.currentTimeMillis()-startGameTime)/1000),1020,61);	
	        }
		}
				if((lastGameTime-(System.currentTimeMillis()-startGameTime)/1000)==0) {
					
			State.setState(new GameOverState(handler));
		}

		
	}

}
