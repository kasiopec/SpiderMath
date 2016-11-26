import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.Rectangle;
import java.util.Random;

import javax.swing.ImageIcon;


public class Enemy extends Entity {

	public Enemy(int x, int y) {
		super(x, y);
		
	}
	
	public void update() {
		Random rand = new Random();
		y += rand.nextInt(3);
		x += rand.nextInt(3);
		y -=rand.nextInt(3);
		x -=rand.nextInt(3);	
	}

	public void draw(Graphics2D g2d) {	
		g2d.drawImage(getEnemyImg(), x, y, null);	
		
		// Use this if you want to see the rectangles that wrap the objects
		//g2d.draw(getBounds());
		
	}
	
	public Image getEnemyImg() {
		
		ImageIcon jos = new ImageIcon("res/flie03.png");
		return jos.getImage();
	}
	
	public Rectangle getBounds() {
		// this method returns the rectangle that encompasses the enemies.
		return new Rectangle(x, y, getEnemyImg().getWidth(null), 
				getEnemyImg().getHeight(null));
	}

}
