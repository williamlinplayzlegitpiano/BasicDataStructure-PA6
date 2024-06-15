import org.junit.Test;

import static org.junit.Assert.*;

public class CustomTester {
    
    private static final double EPSILON = 0.0001d;
    /**
     * Helper method to initialize all instance variables of MyDeque
     * @param deque The deque to initialize
     * @param data The data array
     * @param size The value for size
     * @param front The value for front
     * @param rear The value for rear
     */
    static void initDeque(MyDeque<Integer> deque, Object[] data, int size,
                          int front, int rear) {
        deque.data = data;
        deque.size = size;
        deque.front = front;
        deque.rear = rear;
    }

    @Test (expected = IllegalArgumentException.class)
    public void testDequeConstructor() {
        MyDeque<Integer> dequeNegative = new MyDeque<>(-1);

        MyDeque<Integer> dequeTest = new MyDeque<>(5);
        assertEquals(10,dequeTest.data.length);
        assertEquals(0, dequeTest.size);
        assertEquals(0, dequeTest.front);
        assertEquals(0, dequeTest.rear);

    }

    @Test
    public void testExpandCapacity() {

        MyDeque<Integer> deque = new MyDeque<>(5);
        Integer[] orig = {5, 6, 1, null, null};
        Integer[] finalOrdering = {5, 6, 1, null, null, null, null, null,
                null, null};
        initDeque(deque, orig, 3, 0, 2);

        deque.expandCapacity();

        assertEquals(10, deque.data.length);
        assertEquals(3, deque.size);
        assertEquals(0, deque.front);
        assertEquals(2, deque.rear);
        for (int i = 0; i < 10; i++) {
            assertEquals(finalOrdering[i], deque.data[i]);
        }

        MyDeque<Integer> deque2 = new MyDeque<>(0);
        Integer[] orig2 = {};
        Integer[] finalOrdering2 = {null, null, null, null, null,
                null, null, null, null, null};
        initDeque(deque2, orig2, 0, 0, 0);

        deque2.expandCapacity();

        assertEquals(10, deque2.data.length);
        assertEquals(0, deque2.size);
        assertEquals(0, deque2.front);
        assertEquals(0, deque2.rear);
        for (int i = 0; i < 10; i++) {
            assertEquals(finalOrdering2[i], deque2.data[i]);
        }

    }

    @Test (expected = NullPointerException.class)
    public void testAddFirst() {

        MyDeque<Integer> deque = new MyDeque<>(10);
        deque.addFirst(null);

    }

    @Test (expected = NullPointerException.class)
    public void testAddLast() {

        MyDeque<Integer> deque = new MyDeque<>(10);
        deque.addLast(null);

    }

    @Test
    public void testRemoveFirst() {
        MyDeque<Integer> deque = new MyDeque<>(5);
        assertEquals(null, deque.removeFirst());
    }

    @Test
    public void testRemoveLast() {
        MyDeque<Integer> deque = new MyDeque<>(5);
        assertEquals(null, deque.removeLast());
    }

    @Test (expected = NullPointerException.class)
    public void testNullPush() {
        MyStack<Integer> stack = new MyStack<>(10);
        stack.push(null);
    }

    @Test (expected = NullPointerException.class)
    public void testNullEnqueue() {
        MyQueue<Integer> queue = new MyQueue<>(10);
        queue.enqueue(null);
    }

    @Test 
    public void testAlgorithm() {
        int[] arr = new int[]{1, 2, 3};
        assertEquals((double) 2/2, MyAlgorithm.avgDiffMonotonicIncreasing(arr), EPSILON);

        int[] arr2 = new int[]{6, 2, 3};
        assertEquals(0, MyAlgorithm.avgDiffMonotonicIncreasing(arr2), EPSILON);

        int[] arr3 = new int[]{6, 2, 3, 7, 8};
        assertEquals((double) 2/2, MyAlgorithm.avgDiffMonotonicIncreasing(arr3), EPSILON);

        int[] arr4 = new int[]{};
        assertEquals(0,MyAlgorithm.avgDiffMonotonicIncreasing(arr4), EPSILON);

        int[] arr5 = new int[]{1};
        assertEquals(0,MyAlgorithm.avgDiffMonotonicIncreasing(arr5), EPSILON);
        
    }

}
