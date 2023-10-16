import java.util.Random;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.BeforeEach;
import static org.junit.jupiter.api.Assertions.*;

/**
 * @author Trent Everard
 * Description: Testing class for MaxHeap.
 */
class MaxHeapTest {

    private MaxHeap heap;

    public static boolean checkIfMaxHeap(Task[] array) {
        for(int i = 0; i < array.length; i++) {
            if(array[(i - 1) / 2].compareTo(array[i]) == -1) {
                return false;
            }
        }
        return true;
    }

    public static boolean checkIfSorted(Task[] array) {
        int length = array.length;
        for(int i = 0; i < length - 1; i++) {
            if(array[i].compareTo(array[i + 1]) == -1) {
                return false;
            }
        }
        return true;
    }

    @BeforeEach
    public void createHeap() {
        heap = new MaxHeap();
    }

    @Test
    public void isEmptyTest1() {
        assertTrue(heap.isEmpty());
    }

    @Test
    public void isEmptyTest2() {
        Task task = new Task(1, TaskInterface.TaskType.MINING, 1, 1, "Mining test");
        heap.insert(task);
        assertFalse(heap.isEmpty());
    }

    @Test
    public void insertTest() {
        Task task = new Task(1, TaskInterface.TaskType.MINING, 1, 1, "Mining test");
        Task task2 = new Task(2, TaskInterface.TaskType.FISHING, 2, 2, "Fishing test");
        heap.insert(task);
        heap.insert(task2);
        assertEquals(heap.max(), task2);   
    }

    @Test
    public void extractMaxTest1() {
        Task task = new Task(1, TaskInterface.TaskType.MINING, 1, 1, "Mining test");
        Task task2 = new Task(2, TaskInterface.TaskType.FISHING, 2, 2, "Fishing test");
        heap.insert(task);
        heap.insert(task2);
        for(int i = 0; i == 2; i++) {
            heap.extractMax();
        }
        assertEquals(heap.max(), task2);
    }

    @Test
    public void extractMaxTest2() {
        Task task = new Task(1, TaskInterface.TaskType.MINING, 1, 1, "Mining test");
        Task task2 = new Task(2, TaskInterface.TaskType.FISHING, 2, 2, "Fishing test");
        Task task3 = new Task(3, TaskInterface.TaskType.FEEDING, 3, 3, "Feeding test");
        heap.insert(task);
        heap.insert(task2);
        heap.insert(task3);
        for(int i = 0; i == 3; i++) {
            heap.extractMax();
        }
        assertEquals(heap.max(), task3);
    }

    @Test
    public void increaseKeyTest1() {
        Task task = new Task(1, TaskInterface.TaskType.MINING, 1, 1, "Mining test");
        Task task2 = new Task(2, TaskInterface.TaskType.FISHING, 2, 2, "Fishing test");
        heap.insert(task);
        heap.insert(task2);
        heap.increaseKey(1, task);
        assertEquals(heap.max(), task2);
    }

    @Test
    public void increaseKeyTest2() {
        Task task = new Task(1, TaskInterface.TaskType.MINING, 1, 1, "Mining test");
        Task task2 = new Task(2, TaskInterface.TaskType.FISHING, 2, 2, "Fishing test");
        Task task3 = new Task(3, TaskInterface.TaskType.FEEDING, 3, 3, "Feeding test");
        heap.insert(task);
        heap.insert(task2);
        heap.insert(task3);
        heap.increaseKey(2, task3);
        assertEquals(heap.max(), task3);
    }

    @Test
    public void insertAscendingTest() {
        Task task = new Task(1, TaskInterface.TaskType.MINING, 1, 1, "Mining test");
        Task task2 = new Task(2, TaskInterface.TaskType.FISHING, 2, 2, "Fishing test");
        Task task3 = new Task(3, TaskInterface.TaskType.FEEDING, 3, 3, "Feeding test");
        heap.insert(task);
        heap.insert(task2);
        heap.insert(task3);
        Task[] array = new Task[3];

        assertTrue(checkIfMaxHeap(heap.getMaxHeap()));
        for(int i = 0; i <= array.length - 1; i++) {
            array[i] = heap.extractMax();
        }
        boolean isSorted = checkIfSorted(array);
        assertTrue(isSorted);
    }

    @Test
    public void insertDescendingTest() {
        Task task3 = new Task(3, TaskInterface.TaskType.FEEDING, 3, 3, "Feeding test");
        Task task2 = new Task(2, TaskInterface.TaskType.FISHING, 2, 2, "Fishing test");
        Task task = new Task(1, TaskInterface.TaskType.MINING, 1, 1, "Mining test");
        heap.insert(task3);
        heap.insert(task2);
        heap.insert(task);
        Task[] array = new Task[3];
        
        assertTrue(checkIfMaxHeap(heap.getMaxHeap()));
        for(int i = 0; i <= array.length - 1; i++) {
            array[i] = heap.extractMax();
        }
        boolean isSorted = checkIfSorted(array);
        assertTrue(isSorted);
    }

    @Test
    public void insertRandomTest() {
        Random rand = new Random();
        Task task3 = new Task(rand.nextInt(50), TaskInterface.TaskType.FEEDING, 0, 0, "Feeding test");
        Task task2 = new Task(rand.nextInt(50), TaskInterface.TaskType.FISHING, 0, 0, "Fishing test");
        Task task = new Task(rand.nextInt(50), TaskInterface.TaskType.MINING, 0, 0, "Mining test");
        Task task4 = new Task(rand.nextInt(50), TaskInterface.TaskType.FEEDING, 0, 0, "Feeding test");
        Task task5 = new Task(rand.nextInt(50), TaskInterface.TaskType.FISHING, 0, 0, "Fishing test");
        Task task6 = new Task(rand.nextInt(50), TaskInterface.TaskType.MINING, 0, 0, "Mining test");
        heap.insert(task);
        heap.insert(task2);
        heap.insert(task3);
        heap.insert(task4);
        heap.insert(task5);
        heap.insert(task6);
        Task[] array = new Task[6];
        
        assertTrue(checkIfMaxHeap(heap.getMaxHeap()));
        for(int i = 0; i < array.length; i++) {
            array[i] = (heap.extractMax());
        }
        boolean isSorted = checkIfSorted(array);
        assertTrue(isSorted);
    }
}
