package model;

import org.newdawn.slick.Color;
import org.newdawn.slick.Graphics;
import org.newdawn.slick.geom.Circle;
import org.newdawn.slick.geom.Point;

public class Ball implements Drawable {
	
	private static final int BALL_SIZE = 30;
	private Point position;
	
	public Ball() {
		this.position = new Point(0, 0);
	}
	
	public Ball(int x, int y) {
		this.position = new Point(x, y);
	}

	@Override
	public void draw(Graphics g) {
		Color originalColour = g.getColor();
		
		Circle outerCircle = new Circle(position.getX(), position.getY(),
				BALL_SIZE);
		
		Circle innerCircle = new Circle(position.getX(), position.getY(),
				BALL_SIZE-20);
		
		g.setColor(Color.white);
		g.draw(outerCircle);
		g.fill(innerCircle);
		g.setColor(Color.black);
		g.draw(innerCircle);
		g.setColor(originalColour);
	}
}
