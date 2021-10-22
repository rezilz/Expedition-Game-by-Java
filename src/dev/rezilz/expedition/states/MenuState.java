package dev.rezilz.expedition.states;

import java.awt.Color; 

import java.awt.Font;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.Toolkit;
import java.awt.image.ImageObserver;

import dev.rezilz.expedition.Handler;
import dev.rezilz.expedition.audio.MusicPlayer;
import dev.rezilz.expedition.gfx.Assets;
import dev.rezilz.expedition.ui.ClickListener;
import dev.rezilz.expedition.ui.UIImageButton;
import dev.rezilz.expedition.ui.UIManager;
import dev.rezilz.expedition.utils.Fonts;

public class MenuState extends State {
	
	private UIManager uiManager;
	private MusicPlayer menu;

	public MenuState(Handler handler){
		
		super(handler);
		uiManager = new UIManager(handler);
		menu = new MusicPlayer(Assets.MENU_SOUND,false);
	
		handler.getMouseManager().setUIManager(uiManager);
		uiManager.addObject(new UIImageButton(358, 550, 128, 64, Assets.btn_members, new ClickListener() {
			@Override
			public void onClick() {
				handler.getMouseManager().setUIManager(null);
				//State.setState(handler.getGame().helpState);
				State.setState(new MemberState(handler));
				menu.stop();
			}
		}));
		
		uiManager.addObject(new UIImageButton(536 , 550, 128, 64, Assets.btn_start2, new ClickListener() {
			@Override
			public void onClick() {
				handler.getMouseManager().setUIManager(null);
				//State.setState(handler.getGame().gameState);
				State.setState(new GameState(handler));
				menu.stop();
			}
		}));

		
		uiManager.addObject(new UIImageButton(714, 550, 128, 64, Assets.btn_help, new ClickListener() {
			@Override
			public void onClick() {
				handler.getMouseManager().setUIManager(null);
				//State.setState(handler.getGame().helpState);
				State.setState(new HelpState(handler));
				menu.stop();
			}
		}));
			
	}

	@Override
	public void tick() {
		uiManager.tick();
		System.out.println(handler.getMouseManager().getMouseX() + "   " +handler.getMouseManager().getMouseY());
		menu.play();
		/* if(handler.getMouseManager().isLeftPressed() && handler.getMouseManager().isRightPressed())
			State.setState(handler.getGame().gameState);  */
	}

	@Override
	public void render(Graphics g) {
		Toolkit toolkit = Toolkit.getDefaultToolkit();
		
        Image menu = toolkit.getImage(Assets.WALLPAPER2);
        g.drawImage(menu,0,0, null);
        
       //Fonts.drawString(g, new Font("Comic Sans MS", Font.BOLD, 72), Color.WHITE,"Expedition In The Jungle", 110);
        
        Image menu2 = toolkit.getImage(Assets.LOGO_MENU);
        g.drawImage(menu2,0,20, null);
               
        
        uiManager.render(g);
        
        Image menu3 = toolkit.getImage(Assets.CURSOR);
        g.drawImage(menu3,handler.getMouseManager().getMouseX(), handler.getMouseManager().getMouseY(),null); 
		//g.setColor(Color.YELLOW);
		//g.fillRect(handler.getMouseManager().getMouseX(), handler.getMouseManager().getMouseY(), 10, 10); 
	}
	
}