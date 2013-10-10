
package view;

import java.util.LinkedList;
import java.util.List;

import main.RoboCup;
import model.Ball;
import model.Player;
import model.Player.Team;

import org.lwjgl.input.Mouse;
import org.newdawn.slick.Color;
import org.newdawn.slick.GameContainer;
import org.newdawn.slick.Graphics;
import org.newdawn.slick.SlickException;
import org.newdawn.slick.geom.RoundedRectangle;
import org.newdawn.slick.state.BasicGameState;
import org.newdawn.slick.state.StateBasedGame;

public class PlayScreen extends BasicGameState {
	
	private static final int PLAY_BOUND_BUFFER = 30;
	
	private final int id;
	private Pitch pitch;
	private int mouseX;
	private int mouseY;
	
	private List<Player> players;
	private Ball ball;
	private RoundedRectangle playArea;
	
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
		ball = new Ball((int)(RoboCup.WIN_WIDTH/2), (int)(RoboCup.WIN_HEIGHT/2));
		
		addPlayers();
		
		playArea = new RoundedRectangle(PLAY_BOUND_BUFFER, PLAY_BOUND_BUFFER,
				RoboCup.WIN_WIDTH - PLAY_BOUND_BUFFER*2,
				RoboCup.WIN_HEIGHT - PLAY_BOUND_BUFFER*2,
				5);
	}

	private void addPlayers() {
		players = new LinkedList<Player>();
		
		// Green team.
		players.add(new Player(100, 100, 20, Team.TEAM1));
		players.add(new Player(RoboCup.WIN_WIDTH-75, 100, 180, Team.TEAM1));
		players.add(new Player(RoboCup.WIN_WIDTH-100, RoboCup.WIN_HEIGHT-70, 239, Team.TEAM1));
		
		// Blue team.
		players.add(new Player(RoboCup.WIN_WIDTH/2-30, RoboCup.WIN_HEIGHT/2+60, 190, Team.TEAM2));
		players.add(new Player(RoboCup.WIN_WIDTH/2+75, RoboCup.WIN_HEIGHT/2-120, 215, Team.TEAM2));
	}
	

	@Override
	public void render(GameContainer container, StateBasedGame game, Graphics g)
			throws SlickException {
		g.setAntiAlias(true);
		pitch.draw(g);
		
		for(Player player : players) {
			player.draw(g);
		}
		
		ball.draw(g);
		
		// Draw bounded play area.
		float originalLineWidth = g.getLineWidth();
		Color originalColour = g.getColor();
		
		g.setLineWidth(3);
		g.setColor(Color.white);
		g.draw(playArea);
		
		g.setLineWidth(originalLineWidth);
		g.setColor(originalColour);
	}
	
	@Override
	public void update(GameContainer gc, StateBasedGame sbg, int delta)
			throws SlickException {
		mouseX = Mouse.getX();
		mouseY = RoboCup.WIN_HEIGHT-Mouse.getY();
	}

}
