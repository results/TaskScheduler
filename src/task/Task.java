package task;

import java.util.concurrent.Callable;


public abstract class Task implements Callable<Object> {
	
	private TaskHandler caller;
	
	private int tickDelay = 0;
	
	private boolean reoccuringTask = false;
		
	@Override
	public abstract Object call();
		
	public void setCaller(TaskHandler taskHandler) {
		this.caller = taskHandler;
	}
	
	public TaskHandler getCaller() {
		return caller;
	}

	public boolean isReoccuringTask() {
		return reoccuringTask;
	}

	public void setReoccuringTask(boolean reoccuringTask) {
		this.reoccuringTask = reoccuringTask;
	}

	public int getTickDelay() {
		return tickDelay;
	}

	public void setTickDelay(int tickDelay) {
		this.tickDelay = tickDelay;
	}
	

}
