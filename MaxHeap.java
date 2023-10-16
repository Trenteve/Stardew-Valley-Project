import java.util.Arrays;

/**
 * @author Trent Everard
 * Description: MaxHeap creates a max heap using an array.
 */
public class MaxHeap {
    private final int DEFAULT_SIZE = 10;
    protected Task[] heap;
    protected int heapSize;

    /**
     * Default constructor for creating an empty maxHeap object.
     */
    public MaxHeap() {
        heap = new Task[DEFAULT_SIZE];
        heapSize = 0;
    }
 
    /**
     * An overloaded constructor that takes in an array as a parameter to create a heap.
     * @param array
     */
    public MaxHeap(Task[] array) {
        heap = new Task[array.length];
        heapSize = array.length;
        for(int i = 0; i < array.length; i ++) {
            heap[i] = array[i];
        }
        buildMaxHeap();
    }
    
    /**
     * This method maintains the heap's max property.
     * @param index
     */
    private void heapify(int index) {
        int left = (2 * (index)) + 1;
        int right = (2 * (index)) + 2;
        int largest = 0;

        if((left < heapSize) && (heap[left].compareTo(heap[index]) > 0)) {
            largest = left;
        } else {
            largest = index;
        }

        if((right < heapSize) && (heap[right].compareTo(heap[largest]) > 0)) {
            largest = right;
        }
        if(largest != index) {
            swap(index, largest);
            heapify(largest);
        }
    }

    /**
     * This method converts an array into a heap.
     */
    private void buildMaxHeap() {
        int n = heapSize;
        for(int i = (n/2 - 1); i >= 0; i--) {
            heapify(i);
        }
    }

    /**
     * This method returns the max value of the heap, heap[0].
     * @return heap[0]
     */
    public Task max() {
        if(heapSize < 1) {
            System.out.println("heap underflow");
        }
        return heap[0];
    }

    /**
     * This removes and returns the max property of the heap, and creates a new max value.
     * @return max property of the heap,
     */
    public Task extractMax() {
        Task max = max();
        heap[0] = heap[heapSize - 1];
        heapSize--;
        heapify(0);
        return max;
    }

    /**
     * This method takes in a task and swaps its position with it's parent task.
     * @param position
     * @param task
     */
    public void increaseKey(int position, Task task) {
        if(heap[position].compareTo(task) > 0) {
            System.out.println("new key must be larger than current key");
        }
        heap[position] = task;
        while((position > 0) && (heap[Parent(position)].compareTo(heap[position]) < 0)) {
            swap(Parent(position), position);
            position = Parent(position);
        }
    }
    
    /**
     * This method takes in a task and inserts that task into its correct spot in the heap.
     * @param task
     */
    public void insert(Task task) {
        if(heap.length == heapSize) {
            heap = Arrays.copyOf(heap, heap.length * 2);
        }
        heapSize++;
        heap[heapSize - 1] = task;
        increaseKey(heapSize - 1, task);
    }

    /**
     * Returns true if the size of the heap is empty.
     * @return true or false depending on heap size.
     */
    public boolean isEmpty() {
        if (heapSize == 0) {
            return true;
        } else {
            return false;
        }
    }

    /**
     * Returns a copy of the heap array.
     * @return heap2
     */
    public Task[] getMaxHeap() {
        Task[] heap2 = Arrays.copyOf(heap, heapSize);
        return heap2;
    }

    public int Parent(int i){
        return ((i - 1) / 2);
    }

    public void swap(int index, int other){
        Task tempTask = heap[index];
        heap[index] = heap[other];
        heap[other] = tempTask;
    }

}
