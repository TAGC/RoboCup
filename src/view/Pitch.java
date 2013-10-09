package view;

import org.newdawn.slick.Graphics;
import org.newdawn.slick.Image;
import org.newdawn.slick.SlickException;


public class Pitch {
	
	private Image pitchBlock;
	private final int blockWidth, blockHeight, width, height;
	
	public Pitch(int width, int height) {
		try {
			pitchBlock = new Image("res/pitch.jpg");
		} catch (SlickException e) {
			e.printStackTrace();
		}
		
		blockWidth = pitchBlock.getWidth();
		blockHeight = pitchBlock.getHeight();
		this.width = width;
		this.height = height;
	}
	
	public void draw(Graphics g) {
		int xBlocks = width / blockWidth + (width % blockWidth > 0 ? 1 : 0);
		int yBlocks = height / blockHeight + (height % blockHeight > 0 ? 1 : 0);
		
		Image currBlock;
		
		for(int i=0; i < xBlocks; i++) {
			for(int j=0; j < yBlocks; j++) {
				currBlock = (i % 2 == 1) ? pitchBlock : pitchBlock.getFlippedCopy(true, false);
				currBlock = (j % 2 == 0) ? currBlock : currBlock.getFlippedCopy(false, true);
				
				g.drawImage(currBlock, i*blockWidth, j*blockHeight);
			}
		}
	}
}
