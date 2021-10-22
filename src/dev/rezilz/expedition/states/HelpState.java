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

public class HelpState extends State {
	
	private UIManager uiManager;
	private MusicPlayer helpp;

	public HelpState(Handler handler){
		super(handler);
		
		helpp = new MusicPlayer(Assets.HELP_SOUND,false);
		uiManager = new UIManager(handler);
		handler.getMouseManager().setUIManager(uiManager);

		uiManager.addObject(new UIImageButton(536 , 550, 128, 64, Assets.btn_return, new ClickListener() {
			@Override
			public void onClick() {
				handler.getMouseManager().setUIManager(null);
				//State.setState(handler.getGame().gameState);
				State.setState(new MenuState(handler));
				helpp.stop();
			}
		}));		
	}

	@Override
	public void tick() {
		uiManager.tick();
		helpp.play();
		System.out.println(handler.getMouseManager().getMouseX() + "   " +handler.getMouseManager().getMouseY());
		/* if(handler.getMouseManager().isLeftPressed() && handler.getMouseManager().isRightPressed())
			State.setState(handler.getGame().gameState);  */
	}

	@Override
	public void render(Graphics g) {
		Toolkit toolkit = Toolkit.getDefaultToolkit();
        Image help = toolkit.getImage(Assets.WALLPAPER1);
        g.drawImage(help,0,0, null);
        
        Image help2 = toolkit.getImage(Assets.LOGO_HELP);
        g.drawImage(help2,0,20, null);
        
      // Fonts.drawString(g, new Font("Comic Sans MS", Font.BOLD, 72), Color.WHITE,"How to play", 110);
       
        Image help3 = toolkit.getImage(Assets.KEYBOARD);
        g.drawImage(help3,100,175, null);
       
        uiManager.render(g);
		//g.setColor(Color.YELLOW);
		//g.fillRect(handler.getMouseManager().getMouseX(), handler.getMouseManager().getMouseY(), 10, 10); 
        Image menu3 = toolkit.getImage(Assets.CURSOR);
        g.drawImage(menu3,handler.getMouseManager().getMouseX(), handler.getMouseManager().getMouseY(),null);
	}
	
}