package controller;

import org.newdawn.slick.SlickException;
import org.newdawn.slick.state.StateBasedGame;

public class StateTransitionButton extends Button {

	private int stateID;
	private StateBasedGame game;
	
	public StateTransitionButton(String path, int x, int y, int stateID,
			StateBasedGame game) throws SlickException {
		super(path, x, y);
		
		this.stateID = stateID;
		this.game = game;
	}

	@Override
	public void onClickAction() {
		game.enterState(stateID);
	}

}
