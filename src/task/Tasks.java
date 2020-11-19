package task;

public class Tasks  implements Runnable {
	
	@Override
	public void run() {
		
	}
	
	public void cancel(Task toCancel) {
		if(getCurrentTask() == toCancel) {
			return;//Task is already running
		}
		//remove
	}

	
	private Task currentTask;

	public Task getCurrentTask() {
		return currentTask;
	}

	public void setCurrentTask(Task currentTask) {
		this.currentTask = currentTask;
	}
	
	

}
