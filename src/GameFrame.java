import java.awt.Font;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.ArrayList;
import java.util.Random;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.Timer;

@SuppressWarnings("serial")
public class GameFrame extends JPanel implements ActionListener {
	
	Timer mainTimer; // used for refreshing the frame
	
	Player player; 	
	
	static ArrayList<Enemy> enemies = new ArrayList<Enemy>();
	static ArrayList<Answers> answers = new ArrayList<Answers>();
	
	Random rand = new Random(); // used for randomize
	int enemyCount = 5; // number of enemies on the screen
	int answerCount = 3;
	int level = 1; //variable for the level
	
	public int LocationX (int x) {
			return x = rand.nextInt(800); //X-Axis random location
		}
	public  int LocationY (int y) {
			return y = rand.nextInt(500); //Y-Axis random location
	}
	
	public GameFrame()
	{
		setFocusable(true); // need to research about this thing, I don't know what it does yet.		
		
		player = new Player(300, 250); // where the player spawns
		
		
		addKeyListener(new KeyAdapt(player)); // action
		
		addKeyListener(new KeyListener() {						
			
			public void keyTyped(KeyEvent e) {
			}						
			
			public void keyReleased(KeyEvent e) {				
			}						
			
			public void keyPressed(KeyEvent e) {
				int key = e.getKeyCode();
				if ( key == KeyEvent.VK_R) {
					JOptionPane.showMessageDialog(null,"The game will just restart man..");
					level = 1;
					enemies.clear();
					answers.clear();
					startGame();				
				}
			}
		});		
		
		mainTimer = new Timer(10, this); // number of milliseconds between frame updates
		mainTimer.start();		
		startGame();		
	}
	
	
	public void paint(Graphics g) {
	
	super.paint(g);	
	Graphics2D g2d = (Graphics2D) g; // constructor	
	
	player.draw(g2d); // it should draw the player to the screen at the size specified above 	
	
	Font gameFont = new Font("Tahoma", Font.BOLD, 20);	
	g2d.setFont(gameFont);
	
	for (int i=0; i<enemies.size(); i++) {
		Enemy tempEnemy = enemies.get(i);
		tempEnemy.draw(g2d);
	}
	
	for (int j=0;j<answers.size();j++) {
		Answers tempAnswer = answers.get(j);
		tempAnswer.draw(g2d);
		}		
}
	
	@Override
	public void actionPerformed(ActionEvent arg0) {
	player.update();
	for (int i=0; i<enemies.size(); i++){
		Enemy tempEnemy = enemies.get(i);
		tempEnemy.update();
	}
	
	checkEnd();	
	repaint();
	}

	public void addEnemy(Enemy e) {
		enemies.add(e);
	}
	
	public void addAnswer(Answers a) {
		answers.add(a);
	}
	
	public static void removeAnswers(Answers a) {
		answers.remove(a);
	}
	
	public static void removeEnemy(Enemy e) {
		enemies.remove(e);
	}
	
	// a new method that gives us the enemies arrayList
	public static ArrayList<Enemy> getEnemyList() {
		return enemies;
	}
	
	public static ArrayList<Answers> getAnswersList() {
		return answers;
	}
	
	public void startGame() {
  
		enemyCount = level + 2;
		
		for (int i = 0;i < enemyCount; i++) {
			addEnemy(new Enemy(rand.nextInt(900), rand.nextInt(600))); //randomly placing enemies on the screen
		}
		
		
		for (int i = 0; i < answerCount; i++) {
			
			int x = 0;
			int y = 0;
			addAnswer(new Answers(LocationX(x), LocationY(y)));		
		}				
		Main.chemareaLaLupta(); // this is how we generate Q&A basically		
	}

	
	public void checkCollisions() {
		
		ArrayList<Answers> answers = GameFrame.getAnswersList();
		
		for( int i = 0; i < answers.size(); i++) {
			Answers tempAnswer = answers.get(i);
			Answers tempAnswerPrev = answers.get(i-1);
			
			if (getBounds().intersects(tempAnswer.getBounds())) {
				//GameFrame.removeAnswers(tempAnswer);
			}
			if (tempAnswer.getBounds().intersects(tempAnswerPrev.getBounds())) {
				GameFrame.removeAnswers(tempAnswer);
				addAnswer(new Answers(rand.nextInt(800), rand.nextInt(500)));
				}}
			}
	
	public void checkEnd() {		
		 
		if (player.returnLives() == 0) {
			JOptionPane.showMessageDialog(null, "Sorry, but you have no lives left. Please try again!");
			enemies.clear();
			answers.clear();
			System.exit(0);
		}
		
		if (answers.size() == 0) {
			
			level++;
			enemies.clear();
			answers.clear();
			
			JOptionPane.showMessageDialog(null, "Good work, you have completed "+ (level-1) +". Let's move one to the next one..");
			startGame();
		}
	}
}
