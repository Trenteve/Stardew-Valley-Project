/**
 * @author Trent Everard
 * Description: MyPriorityQueue extends MaxHeap and implements the PriorityQueueInterface
 * to provide a priority queue for the heap data structure.
 */
public class MyPriorityQueue extends MaxHeap implements PriorityQueueInterface {

    public MyPriorityQueue() {
        super();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public void enqueue(Object task) {
        insert((Task) task);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Task dequeue() {
        return extractMax();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public boolean isEmpty() {
        if(super.isEmpty()) {
            return true;
        }
        return false;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public void update(int timeToIncrementPriority, int maxPriority) {
        for(int i = 0; i < heapSize; i++) {
            Task task = heap[i];
            task.incrementWaitingTime();
            if(task.getWaitingTime() >= timeToIncrementPriority) {
                task.resetWaitingTime();
                if(task.getPriority() < maxPriority) {
                    int priority = task.getPriority();
                    task.setPriority(priority + 1);
                    increaseKey(i, task);
                }
            }
        }
    }
}
