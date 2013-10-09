package main;

import org.newdawn.slick.AppGameContainer;
import org.newdawn.slick.GameContainer;
import org.newdawn.slick.SlickException;
import org.newdawn.slick.state.StateBasedGame;

import view.MenuScreen;
import view.PlayScreen;

public class RoboCup extends StateBasedGame {
	
	public static final int WIN_WIDTH = 1000;
	public static final int WIN_HEIGHT = 600;
	
	private static final String TITLE = "RoboCup";
	
	public static final int MENU_SCREEN_ID = 0;
	public static final int PLAY_SCREEN_ID = 1;
	
	public static void main(String[] args) {
		System.out.println(System.getProperty("java.library.path"));
		RoboCup game = new RoboCup();
		AppGameContainer container;
		try {
			container = new AppGameContainer(game);
			container.setDisplayMode(WIN_WIDTH, WIN_HEIGHT, false);
			container.start();
		} catch (SlickException e) {
			e.printStackTrace();
		}	
	}

	public RoboCup() {
		super(TITLE);
		addState(new MenuScreen(MENU_SCREEN_ID));
		addState(new PlayScreen(PLAY_SCREEN_ID));
	}

	@Override
	public void initStatesList(GameContainer container) throws SlickException {
		getState(MENU_SCREEN_ID).init(container, this);
		getState(PLAY_SCREEN_ID).init(container, this);
		enterState(MENU_SCREEN_ID);
	}

}
