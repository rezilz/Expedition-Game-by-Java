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
import dev.rezilz.expedition.utils.Fonts;
import dev.rezilz.expedition.worlds.World;

public class GameState extends State {

	private World world;
	private long startGameTime;
	private MusicPlayer pop;
	
	public GameState(Handler handler){
		super(handler);
		pop = new MusicPlayer("res/audio/pop.wav",false);
		startGameTime = System.currentTimeMillis();;
		world = new World(handler, "res/worlds/gamestate.txt");
		handler.setWorld(world);
		
			}
	
	@Override
	public void tick() {
		world.tick();
		if((System.currentTimeMillis()-startGameTime)/1000<1){
			pop.play();
			}
		else {
			pop.stop();
		}
		
	}
	

	@Override
	public void render(Graphics g) {
		world.render(g);
		if((System.currentTimeMillis()-startGameTime)/1000<5){
			g.setColor(new Color(206, 156, 111));
			g.fillRect(300,50,600,85);
			 Fonts.drawString(g, new Font("Comic Sans MS", Font.PLAIN, 20),Color.WHITE ,"Greetings...This is a Tutorial.",80);
			 Fonts.drawString(g, new Font("Comic Sans MS", Font.PLAIN, 20),Color.WHITE ,"You can press W S A D to move around now.",110);
			}
		if((System.currentTimeMillis()-startGameTime)/1000>5 && (System.currentTimeMillis()-startGameTime)/1000<10){
			g.setColor(new Color(206, 156, 111));
			g.fillRect(300,50,600,85);
			 Fonts.drawString(g, new Font("Comic Sans MS", Font.PLAIN, 20),Color.WHITE ,"The game has a clock in the right corner as well...",80);
			 Fonts.drawString(g, new Font("Comic Sans MS", Font.PLAIN, 20),Color.WHITE ,"Don't forget to watch it!",110);
			}
		if((System.currentTimeMillis()-startGameTime)/1000>10 && (System.currentTimeMillis()-startGameTime)/1000<15){
			g.setColor(new Color(206, 156, 111));
			g.fillRect(300,50,600,85);
			 Fonts.drawString(g, new Font("Comic Sans MS", Font.PLAIN, 20),Color.WHITE ,"Oh..The chess lookin tile is a goal for you.",80);
			 Fonts.drawString(g, new Font("Comic Sans MS", Font.PLAIN, 20),Color.WHITE ,"It's able to let you change the level!",110);
			}
		if((System.currentTimeMillis()-startGameTime)/1000>15 && (System.currentTimeMillis()-startGameTime)/1000<20){
			g.setColor(new Color(206, 156, 111));
			g.fillRect(300,50,600,85);
			 Fonts.drawString(g, new Font("Comic Sans MS", Font.PLAIN, 20),Color.WHITE ,"If you're ready..I'm also ready.",80);
			 Fonts.drawString(g, new Font("Comic Sans MS", Font.PLAIN, 20),Color.WHITE ,"Let's play!",110);
			}
		
		Toolkit toolkit = Toolkit.getDefaultToolkit();
		//Image menu2 = toolkit.getImage(Assets.LOGO_MENU);
        //g.drawImage(menu2,0,20, null);
        
        Image menu3 = toolkit.getImage(Assets.CLOCKLAYER);
        g.drawImage(menu3,0,0, null);
        Image menu4 = toolkit.getImage(Assets.CLOCK);
        g.drawImage(menu4,960,24, null);
        
        Fonts.drawString(g, new Font("Comic Sans MS", Font.BOLD, 20),Color.WHITE ,"Timer: ∞ ",1020,61);
 
		//Tile.tiles[2].render(g, 0, 0);
	}

}
