import java.util.Random;

/**
 * @author Trent Everard
 * Description: TaskGenerator implements TaskGeneratorInterface to create a new Task
 * based on current energy levels, daily luck, and probability.
 */
public class TaskGenerator implements TaskGeneratorInterface {
    private int currentEnergyStorage;
    private double probability;
    private Random rand;

    public TaskGenerator(double probability) {
        this.probability = probability;
        rand = new Random();
        currentEnergyStorage = DEFAULT_ENERGY;
    }

    public TaskGenerator(double probability, long seed) {
        this.probability = probability;
        rand = new Random(seed);
        currentEnergyStorage = DEFAULT_ENERGY;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Task getNewTask(int hourCreated, Task.TaskType taskType, String taskDescription) {
        Task newTask = new Task(0, taskType, 0, hourCreated, taskDescription);
        return newTask;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public void decrementEnergyStorage(Task.TaskType taskType) {
        currentEnergyStorage -= taskType.getEnergyPerHour();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public void resetCurrentEnergyStorage() {
        currentEnergyStorage = DEFAULT_ENERGY;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public int getCurrentEnergyStorage() {
        return currentEnergyStorage;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public void setCurrentEnergyStorage(int newEnergyNum) {
        currentEnergyStorage = newEnergyNum;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public boolean generateTask() {
        double random = rand.nextDouble();
        if(random < probability) {
            return true;
        }
        return false;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public int getUnlucky(Task task, double unluckyProbability) {
        Task.TaskType taskType = task.getTaskType();
        
        if(unluckyProbability <= taskType.getPassingOutProbability()) {
            if(unluckyProbability <= taskType.getDyingProbability() && taskType == Task.TaskType.MINING) {
                currentEnergyStorage -= (3 * currentEnergyStorage) / 4;
                task.setPriority(0);
                return DEATH;
            } else {
                currentEnergyStorage /= 2;
                return PASSED_OUT;
            }
        } else {
            return SURVIVED;
        }
    }

    /**
     * Create a String containing the Task's information.
     *
     * @param task - the Task
     * @param taskType - the Task's type
     */
    @Override
    public String toString(Task task, Task.TaskType taskType) {
        if(taskType == Task.TaskType.MINING) {
            return "     Mining " + task.getTaskDescription() + " at " + currentEnergyStorage + " energy points (Priority:" + task.getPriority() +")";
        }
        if(taskType == Task.TaskType.FISHING) {
            return "     Fishing " + task.getTaskDescription() + " at " + currentEnergyStorage + " energy points (Priority:" + task.getPriority() +")" ;
        }
        if(taskType == Task.TaskType.FARM_MAINTENANCE) {
            return "     Farm Maintenance " + task.getTaskDescription() + " at " + currentEnergyStorage + " energy points (Priority:" + task.getPriority() +")";
        }
        if(taskType == Task.TaskType.FORAGING) {
            return "     Foraging " + task.getTaskDescription() + " at " + currentEnergyStorage + " energy points (Priority:" + task.getPriority() +")" ;
        }
        if(taskType == Task.TaskType.FEEDING) {
            return "     Feeding " + task.getTaskDescription() + " at " + currentEnergyStorage + " energy points (Priority:" + task.getPriority() +")";
        }
        if(taskType == Task.TaskType.SOCIALIZING) {
            return "     Socializing " + task.getTaskDescription() + " at " + currentEnergyStorage + " energy points (Priority:" + task.getPriority() +")";
        }
        else { return "nothing to see here..."; }
    }
    
}
