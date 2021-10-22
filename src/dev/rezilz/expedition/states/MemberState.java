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

public class MemberState extends State {
	
	private UIManager uiManager;
	private MusicPlayer member;
	
	public MemberState(Handler handler){
		super(handler);
		member = new MusicPlayer(Assets.MEMBER_SOUND,false);
		uiManager = new UIManager(handler);
		handler.getMouseManager().setUIManager(uiManager);

		uiManager.addObject(new UIImageButton(536 , 550, 128, 64, Assets.btn_return, new ClickListener() {
			@Override
			public void onClick() {
				handler.getMouseManager().setUIManager(null);
				//State.setState(handler.getGame().gameState);
				State.setState(new MenuState(handler));
				member.stop();
			}
		}));
		
	}

	@Override
	public void tick() {
		uiManager.tick();
		member.play();
		System.out.println(handler.getMouseManager().getMouseX() + "   " +handler.getMouseManager().getMouseY());
		/* if(handler.getMouseManager().isLeftPressed() && handler.getMouseManager().isRightPressed())
			State.setState(handler.getGame().gameState);  */
	}

	@Override
	public void render(Graphics g) {
		Toolkit toolkit = Toolkit.getDefaultToolkit();
        Image member = toolkit.getImage(Assets.WALLPAPER1);
        g.drawImage(member,0,0, null);
        
        Image member2 = toolkit.getImage(Assets.LOGO_MEMBER);
        g.drawImage(member2,0,20, null);
        
        Image member3 = toolkit.getImage(Assets.MEMBER);
        g.drawImage(member3,100,175, null);

      // Fonts.drawString(g, new Font("Comic Sans MS", Font.BOLD, 72), Color.WHITE,"Members", 110);
       //Fonts.drawString(g, new Font("Comic Sans MS", Font.PLAIN, 40), Color.WHITE,"Kanchana Prathumwan 62010058",250);
       //Fonts.drawString(g, new Font("Comic Sans MS", Font.PLAIN, 40), Color.WHITE,"Khetsophon Sukpaiboonwat 62010085",350);
       //Fonts.drawString(g, new Font("Comic Sans MS", Font.PLAIN, 40), Color.WHITE,"Tatchai Hiranchaisakul 62010324",450);
       
        uiManager.render(g);
		//g.setColor(Color.YELLOW);
		//g.fillRect(handler.getMouseManager().getMouseX(), handler.getMouseManager().getMouseY(), 10, 10); 
        Image menu3 = toolkit.getImage(Assets.CURSOR);
        g.drawImage(menu3,handler.getMouseManager().getMouseX(), handler.getMouseManager().getMouseY(),null);
	}
	
}