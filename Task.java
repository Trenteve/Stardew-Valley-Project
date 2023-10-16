/**
 * @author Trent Everard
 * Description: Task implements the TaskInterface and the Comparable interface
 * to create a comparable task object.
 */
public class Task implements TaskInterface, Comparable<Task> {
    private int priority;
    private TaskType taskType;
    private int waitingTime;
    private int hourCreated;
    private String description;
    
    public Task(int priority, TaskType taskType, int waitingTime, int hourCreated, String description) {
        this.priority = priority;
        this.taskType = taskType;
        this.waitingTime = waitingTime;
        this.hourCreated = hourCreated;
        this.description = description;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public int getPriority() {
        return priority;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public void setPriority(int setPriority) {
        this.priority = setPriority;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Task.TaskType getTaskType() {
        return taskType;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public String getTaskDescription() {
        return description;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public void incrementWaitingTime() {
        waitingTime++;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public void resetWaitingTime() {
        waitingTime = 0;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public int getWaitingTime() {
        return waitingTime;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public int compareTo(Task other) {
        if(this.priority > other.priority) {
            return 1;
        } else if(this.priority < other.priority) {
            return -1;
        } else {
            if(this.hourCreated > other.hourCreated) {
                return -1;
            } else if(this.hourCreated < other.hourCreated) {
                return 1;
            } else {
                return 0;
            }
        }
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public String toString(){
        return taskType + " " + description + " at Hour: " + hourCreated + ":00 ";
    }

}