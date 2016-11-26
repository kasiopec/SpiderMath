import javax.swing.JFrame;

public class Main  {
	
	public static void chemareaLaLupta() {
		
		// This method is used to call the numbers and answers		
		QuestionsAndAnswers.setNumb1();
		QuestionsAndAnswers.setNumb2();
		QuestionsAndAnswers.setCorrect();
		QuestionsAndAnswers.setWro1();
		QuestionsAndAnswers.setWro2();				
	}

	public static void main(String[] args) {
		
		JFrame frame = new JFrame("SpiderGame");
		frame.setSize(1000, 700);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setVisible(true);
		frame.setResizable(true);
		frame.add(new GameFrame());
		chemareaLaLupta();		
	 }
		
}
