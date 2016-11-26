import java.awt.Font;
import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.Rectangle;
import javax.swing.ImageIcon;


		public class Answers extends Entity {			
			
			public Answers(int x, int y) {
				super(x, y);				
			}
			
			public void update() {		
			}
	
			public void draw(Graphics2D g2d) {	
								
				int aa = QuestionsAndAnswers.getCorrect();
				int ab = QuestionsAndAnswers.getWro1();
				int ac = QuestionsAndAnswers.getWro2();
				String aas = Integer.toString(aa);
				String abs = Integer.toString(ab);
				String acs = Integer.toString(ac);
				
				g2d.drawImage(getAnswerImg(), x, y, null);
				
				Font font = new Font("Tahoma", Font.BOLD, 20);
				g2d.setFont(font);
								
				//VERSION 2
				if ( GameFrame.getAnswersList().size() == 3) {
					g2d.drawString(acs, GameFrame.getAnswersList().get(2).x+25, GameFrame.getAnswersList().get(2).y+50);
					g2d.drawString(abs, GameFrame.getAnswersList().get(1).x+25, GameFrame.getAnswersList().get(1).y+50);
					g2d.drawString(aas, GameFrame.getAnswersList().get(0).x+25, GameFrame.getAnswersList().get(0).y+50);
				} else if ( GameFrame.getAnswersList().size() == 2 ) {
					g2d.drawString(abs, GameFrame.getAnswersList().get(1).x+25, GameFrame.getAnswersList().get(1).y+50);
					g2d.drawString(aas, GameFrame.getAnswersList().get(0).x+25, GameFrame.getAnswersList().get(0).y+50);
				} else g2d.drawString(aas, GameFrame.getAnswersList().get(0).x+25, GameFrame.getAnswersList().get(0).y+50);
								
				g2d.drawString(QuestionsAndAnswers.getNumb1() + " + " + QuestionsAndAnswers.getNumb2() + " =? " + QuestionsAndAnswers.getCorrect() +"/" + QuestionsAndAnswers.getWro1() + "/" + QuestionsAndAnswers.getWro2(), 400, 650);		
												
			}
			
			public Image getAnswerImg() {		
				
				ImageIcon answ = new ImageIcon("res/answer_object.png");
				return answ.getImage();
			}
			
			public Rectangle getBounds() {
				// this method returns the rectangle that encompasses the enemies.
				return new Rectangle(x, y, getAnswerImg().getWidth(null), 
						getAnswerImg().getHeight(null));
			}

}
