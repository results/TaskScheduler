package task;

import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;

public class TaskScheduler {
	
	private static ScheduledExecutorService scheduler = Executors.newSingleThreadScheduledExecutor();//sets timer for threads
	
	public TaskScheduler(int delay) {
		
	}
	
	public TaskScheduler() {
		
	}
	
	

}
