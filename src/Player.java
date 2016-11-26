import java.awt.Font;
import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.Rectangle;
import java.awt.event.KeyEvent;
import java.util.ArrayList;
import javax.swing.ImageIcon;
import javax.swing.JOptionPane;



public class Player extends Entity {	
	
	int velX = 0 , velY = 0; //velocity
	
	//Setting the speed of the game or the movement of the spider	
	int speed = 5;		
	int direction = 1;	
	public int counter = 0;
	public int lives = 3;		
		
	public int returnLives () {
		return lives;
	}
	
	public Player(int x, int y) {
		super(x, y);
		update();			
	}	
	
	public void update() {
		y += velY;
		x += velX;
		checkCollisions();
		checkOffScreen();
	}
	
	
	
	public void draw(Graphics2D g2d) {	
		
		//Countdown.numarato();
		
		g2d.drawImage(getBackgroundImg(), 0, 0, null); //will draw the backgrounds
		if (direction == 1) {
			g2d.drawImage(getPlayerImg(), x, y, null); // will draw the image
		} else if (direction == 2) {
			g2d.drawImage(getBackSpidey(), x, y, null);
		} else if (direction == 3) {
			g2d.drawImage(getLeftSpidey(), x, y, null);
		} else if (direction == 4) {
			g2d.drawImage(getRightSpidey(), x ,y, null);
		}
		
		g2d.drawImage(getBoxesImg(), 0, 0, null);
		
		Font font = new Font("Tahoma", Font.BOLD, 20);
		g2d.setFont(font);
	    g2d.drawString(" " + counter, 940 , 70);
	    g2d.drawString(" " + lives, 70, 60);		    
	   
	}
	
	public Image getPlayerImg() {
		
		ImageIcon jos = new ImageIcon("res/spidey.png");		
		return jos.getImage();
	}
	
	public Image getBackSpidey() {
		ImageIcon top = new ImageIcon("res/spidey_up.png");
		return top.getImage();
	}
	
	public Image getLeftSpidey() {
		ImageIcon left = new ImageIcon("res/spidey_left.png");
		return left.getImage();
	}
	
	public Image getRightSpidey() {
		ImageIcon right = new ImageIcon("res/spidey_right.png");
		return right.getImage();
	}
	
	public Image getBackgroundImg() {
		ImageIcon back = new ImageIcon("res/game_bg.png");
		return back.getImage();
	}
	
	public Image getBoxesImg() {
		ImageIcon boxes = new ImageIcon("res/game__boxes.png");
		return boxes.getImage();
	}
	
	public void keyPressed(KeyEvent e) {
		int key = e.getKeyCode();
		
		if (key == KeyEvent.VK_UP) {
			velY = -speed;
			direction = 2;
		}
		else if ( key == KeyEvent.VK_DOWN) {
			velY = speed;
			direction = 1;
		}
		else if ( key == KeyEvent.VK_LEFT) {
			velX = -speed;
			direction = 3;
		}
		else if ( key == KeyEvent.VK_RIGHT) {
			velX = speed;
			direction = 4;
		}
		else if ( key == KeyEvent.VK_ESCAPE) {
			JOptionPane.showMessageDialog(null,"The game will now exit!");
			System.exit(0);
		}
	
	}


	public void keyReleased(KeyEvent e) {
		
		int key = e.getKeyCode();
		
		if (key == KeyEvent.VK_UP) {
			velY = 0;
		}
		else if ( key == KeyEvent.VK_DOWN) {
			velY = 0;
		}
		else if ( key == KeyEvent.VK_LEFT) {
			velX = 0;
		}
		else if ( key == KeyEvent.VK_RIGHT) {
			velX = 0;
		}
		
	}
	
	public void checkCollisions() {
		ArrayList<Enemy> enemies = GameFrame.getEnemyList();
		ArrayList<Answers> answers = GameFrame.getAnswersList();
		
		//GameFrame gameFr = new GameFrame();
		
		for( int i = 0; i < answers.size(); i++) {
			Answers tempAnswer = answers.get(i);
			//Answers tempAnswerPrev = answers.get(i-1);
			
			if (getBounds().intersects(tempAnswer.getBounds())) {
				GameFrame.removeAnswers(tempAnswer);
				//answers.get(i) = null;
			}			
		}
		
		for( int i = 0; i < enemies.size(); i++) {
			Enemy tempEnemy = enemies.get(i);
			if (getBounds().intersects(tempEnemy.getBounds())) {
				GameFrame.removeEnemy(tempEnemy);
				counter++;				
			}
		if (enemies.size()==0) {
			lives--;
			JOptionPane.showMessageDialog(null, "Sorry, but you lost a life!");
			
			enemies.clear();			
			//gameFr.startGame();
			}
		}
		
	}
	
	public void checkOffScreen() {
		
		// This is the method that respawns the spider on the other side of the XoY axis.
		
		if(y >= 810) {
			y = 0;
		}
		
		if(y < -100) {
			y = 810;
		}
		
		if(x >= 1200) {
			x = 0;
		}
		
		if(x < -100) {
			x = 1200;
		}
	}
	
	
	
	public Rectangle getBounds() {
		// this method returns the rectangle that encompasses the player.
		return new Rectangle(x, y, getPlayerImg().getWidth(null), 
				getPlayerImg().getHeight(null));
	}
	
 

}
