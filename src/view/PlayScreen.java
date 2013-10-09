
package view;

import java.util.LinkedList;
import java.util.List;

import main.RoboCup;
import model.Player;
import model.Player.Team;

import org.lwjgl.input.Mouse;
import org.newdawn.slick.GameContainer;
import org.newdawn.slick.Graphics;
import org.newdawn.slick.SlickException;
import org.newdawn.slick.state.BasicGameState;
import org.newdawn.slick.state.StateBasedGame;

public class PlayScreen extends BasicGameState {
	
	private final int id;
	private Pitch pitch;
	private int mouseX;
	private int mouseY;
	
	private List<Player> players;
	
	public PlayScreen(int id) {
		this.id = id;
	}

	@Override
	public int getID() {
		return id;
	}

	@Override
	public void init(GameContainer gc, StateBasedGame sbg)
			throws SlickException {
		pitch = new Pitch(RoboCup.WIN_WIDTH, RoboCup.WIN_HEIGHT);
		
		addPlayers();
	}

	private void addPlayers() {
		players = new LinkedList<Player>();
		
		// Green team.
		players.add(new Player(100, 100, 20, Team.TEAM1));
		players.add(new Player(RoboCup.WIN_WIDTH-75, 100, 180, Team.TEAM1));
		players.add(new Player(RoboCup.WIN_WIDTH-50, RoboCup.WIN_HEIGHT-70, 239, Team.TEAM1));
		
		// Blue team.
		players.add(new Player(451, 300, 190, Team.TEAM2));
		players.add(new Player(601, 340, 315, Team.TEAM2));
		
	}
	

	@Override
	public void render(GameContainer container, StateBasedGame game, Graphics g)
			throws SlickException {
		g.setAntiAlias(true);
		pitch.draw(g);
		
		for(Player player : players) {
			player.draw(g);
		}
	}
	
	@Override
	public void update(GameContainer gc, StateBasedGame sbg, int delta)
			throws SlickException {
		mouseX = Mouse.getX();
		mouseY = RoboCup.WIN_HEIGHT-Mouse.getY();
	}

}
