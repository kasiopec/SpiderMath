import java.util.Random;


public class QuestionsAndAnswers {
	
	static Random rand = new Random();	
	static int x = 0;	
	static int y = 0;
	static int a = 0;
	static int b = 0;
	static int c = 0;
	
	public static void setNumb1() {
		x = rand.nextInt(10);		
		//Random number
	}	
	
	public static int getNumb1() {		
		return x;		
	}
	
	public static void setNumb2() {
		y = rand.nextInt(10);		
		//Second random number;
	}	
	
	public static int getNumb2() {
		
		return y;		
	}
	
	public static void setCorrect() {
		a = getNumb1() + getNumb2();		
		//Calculates the correct answer;
	}
	
	public static int getCorrect() {
		return a;
	}
	
	public static void setWro1() {
		b = a + rand.nextInt(10) + 1;		
		//Calculates one wrong answer
	}
	
	public static int getWro1() {
		return b;
	}
	
	public static void setWro2() {
		c = a + rand.nextInt(10);
		if (c == a)
			c = a + rand.nextInt(10) + rand.nextInt(4);		
		//Calculates the second wrong answer
	}
	
	public static int getWro2() {
		return c;
	}

}
