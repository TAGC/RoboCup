package model;

import org.newdawn.slick.Color;
import org.newdawn.slick.Graphics;
import org.newdawn.slick.geom.Circle;
import org.newdawn.slick.geom.Line;
import org.newdawn.slick.geom.Point;

public class Player {
	
	public enum Team {
		TEAM1(Color.green),
		TEAM2(new Color(28, 134, 238));
		
		private final Color colour;
		
		private Team(Color colour) {
			this.colour = colour;
		}
		
		public Color getColour() {
			return colour;
		}
	}

	private static final int PLAYER_SIZE = 30;
	private Point position;
	private int angle;
	private final Team team;

	public Player(int x, int y, Team team) {
		position = new Point(x, y);
		angle = 0;
		this.team = team;
	}
	
	public Player(int x, int y, int angle, Team team) {
		position = new Point(x, y);
		this.angle = angle;
		this.team = team;
	}

	public void draw(Graphics g) {
		Color originalColour = g.getColor();
		
		Circle bigCircle = new Circle(position.getX(), position.getY(),
				PLAYER_SIZE);
		
		Circle smallCircle = new Circle(position.getX(), position.getY(),
				PLAYER_SIZE-3);
		
		Line firstLine = new Line(position.getX(), position.getY(),
				(float)(position.getX() + (PLAYER_SIZE-3)*Math.cos(Math.toRadians(angle-5))),
				(float)(position.getY() + (PLAYER_SIZE-3)*Math.sin(Math.toRadians(angle-5))));
		
		Line secondLine = new Line(position.getX(), position.getY(),
				(float)(position.getX() + (PLAYER_SIZE-3)*Math.cos(Math.toRadians(angle+5))),
				(float)(position.getY() + (PLAYER_SIZE-3)*Math.sin(Math.toRadians(angle+5))));
		
		g.setColor(team.getColour().darker());
		g.fill(bigCircle);
		g.setColor(Color.black);
		g.draw(bigCircle);
		
		g.setColor(team.getColour());
		
		// Fill twice to avoid artifacts.
		g.fill(smallCircle);
		g.fill(smallCircle);
		g.setColor(Color.black);
		g.draw(smallCircle);
		g.draw(firstLine);
		g.draw(secondLine);
		
		g.setColor(originalColour);
	}
}
