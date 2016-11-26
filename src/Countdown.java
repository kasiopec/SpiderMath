
public class Countdown {
	
	static int time;
	
	public static void setTime() {
		time = 40;
	}
	
	public static int getTime() {
		return time;
	}
	
	public static void actualCounter() {
		int timer = getTime();
		
		while (timer != 0) {
			try {
				Thread.sleep(1000);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			timer = timer - 1;
		}
		
	}
}
