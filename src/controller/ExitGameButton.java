package controller;

import org.newdawn.slick.GameContainer;
import org.newdawn.slick.SlickException;

public class ExitGameButton extends Button {

	private GameContainer container;

	public ExitGameButton(int x, int y,
			GameContainer container) throws SlickException {
		super("res/exitButton.png", x, y);
		this.container = container;
	}

	@Override
	public void onClickAction() {
		container.exit();
	}
}