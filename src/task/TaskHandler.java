package task;

import java.util.ArrayList;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;


public class TaskHandler implements Runnable {
	
	private static final int INITAL_DELAY = 600;
	private static final int RATE = 600;

    private static ArrayList<Task> tasks = new ArrayList<Task>();
	private static ScheduledExecutorService scheduler = Executors.newSingleThreadScheduledExecutor();//sets timer for threads
	private static ExecutorService pool = Executors.newCachedThreadPool();// the threadpool
        
    public TaskHandler() {
    	scheduler.scheduleAtFixedRate(this, INITAL_DELAY, RATE, TimeUnit.MILLISECONDS);
    }
    
    public static void submitConstant(Task t) {
    	if(t != null) {
    		if(TaskHandler.getTasks() != null) {
		    	if(!TaskHandler.getTasks().contains(t)) {
		    		t.setReoccuringTask(true);
		    		TaskHandler.getTasks().add(t);
		    	}
    		}
    	}
    }
    
    public static void submit(Task t) {
    	if(t != null) {
    		if(TaskHandler.getTasks() != null) {
		    	if(!TaskHandler.getTasks().contains(t)) {
		    		TaskHandler.getTasks().add(t);
		    	}
    		}
    	}
    }
    
    public static void submitDelayed(Task t, int ticks) {
    	if(t != null) {
    		if(TaskHandler.getTasks() != null) {
		    	if(!TaskHandler.getTasks().contains(t)) {
		    		t.setTickDelay(ticks);
		    		TaskHandler.getTasks().add(t);
		    	}
    		}
    	}
    }
    
    public static void removeTask(Task t) {
    	if(t != null) {
    		if(TaskHandler.getTasks() != null) {
		    	if(TaskHandler.getTasks().contains(t)) {
		    		TaskHandler.getTasks().remove(t);
		    	}
    		}
    	}
    }

	public static ArrayList<Task> getTasks() {
		return tasks;
	}

	@Override
	public void run() {
        for(Task task : TaskHandler.getTasks()) {
        	if(task != null) {
        		if(task.getTickDelay() > 0) {
        			task.setTickDelay(task.getTickDelay() - 1);
        			continue;//breaks out for this one iteration
        		}
        		task.setCaller(this);
        		TaskHandler.pool.submit(task);
        		if(!task.isReoccuringTask()) {
        			TaskHandler.removeTask(task);
        			task = null;
        		}
        	}
        }
	}

}
