package view;

import main.RoboCup;

import org.newdawn.slick.GameContainer;
import org.newdawn.slick.Graphics;
import org.newdawn.slick.Input;
import org.newdawn.slick.SlickException;
import org.newdawn.slick.state.BasicGameState;
import org.newdawn.slick.state.StateBasedGame;

import controller.ExitGameButton;
import controller.StateTransitionButton;

public class MenuScreen extends BasicGameState {
	
	private final int id;
	private StateTransitionButton playButton;
	private ExitGameButton exitButton;
	
	private int winWidth;
	
	public MenuScreen(int id) {
		this.id = id;
	}

	@Override
	public int getID() {
		return id;
	}

	@Override
	public void init(GameContainer container, StateBasedGame game)
			throws SlickException {
		winWidth = game.getContainer().getWidth();
		
		playButton = new StateTransitionButton("res/playButton.png", winWidth/2, 200,
				RoboCup.PLAY_SCREEN_ID, game);
		exitButton = new ExitGameButton(winWidth/2, 400, game.getContainer());
	}

	@Override
	public void render(GameContainer container, StateBasedGame game, Graphics g)
			throws SlickException {
		playButton.draw(g);
		exitButton.draw(g);
	}
	
	@Override
	public void mouseClicked(int button, int x, int y, int clickCount) {
		if(button == Input.MOUSE_LEFT_BUTTON) {
			playButton.handleInput(x, y);
			exitButton.handleInput(x, y);
		}
	}

	@Override
	public void update(GameContainer container, StateBasedGame game, int delta)
			throws SlickException {

	}

}
