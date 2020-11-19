package task;

public class oop {

	public static void main(String[] args) {
		new TaskHandler();
		TaskHandler.submitDelayed(new eep(), 3);
		int i = 0;
		while(true) {
			try {
				Thread.sleep(1000);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			if(i++ == 5) {
				System.out.println("added");
				TaskHandler.submit(new eep());
				i = 0;
			}
			System.out.println("loop");
		}
	}

}
