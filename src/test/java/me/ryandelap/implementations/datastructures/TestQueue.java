package me.ryandelap.implementations.datastructures;

import org.junit.Test;
import static org.junit.Assert.*;

public class TestQueue {
    @Test
    public void testQueue() {
        Queue<String> queue = new Queue<>();

        assertEquals(true, queue.isEmpty());
        assertEquals(0, queue.length());

        queue.enqueue("Foobar1");
        assertEquals(1, queue.length());
        assertEquals("Foobar1", queue.peek());

        queue.dequeue();
        assertEquals(0, queue.length());

        queue.enqueue("Foobar2");
        queue.enqueue("Foobar3");
        queue.enqueue("Foobar4");
        assertEquals(3, queue.length());

        queue.dequeue();
        assertEquals("Foobar3", queue.peek());

    }
}
