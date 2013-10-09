package controller;

import org.newdawn.slick.Graphics;
import org.newdawn.slick.Image;
import org.newdawn.slick.Input;
import org.newdawn.slick.SlickException;
import org.newdawn.slick.geom.Point;

public abstract class Button extends Image {
	
	protected int x, y;
		
	public Button(String path, int x, int y) throws SlickException {
		super(path);
		this.x = x;
		this.y = y;
	}
	
	public void handleInput(Input in) {
		int mouseX = in.getMouseX();
		int mouseY = in.getMouseY();
		
		handleInput(mouseX, mouseY);
	}
	
	public void handleInput(int mouseX, int mouseY) {
		boolean withinXBounds = x-width/2 <= mouseX && mouseX <= x+width/2;
		boolean withinYBounds = y-height/2 <= mouseY && mouseY <= y+height/2;
		
		if(withinXBounds && withinYBounds) {
			onClickAction();
		}
	}
	
	public abstract void onClickAction();
	
	public void setPosition(int x, int y) {
		this.x = x;
		this.y = y;
	}
	
	public Point getPosition() {
		return new Point(x, y);
	}
	
	public void draw(Graphics g) {
		g.drawImage(this, x-width/2, y-height/2);
	}
}
