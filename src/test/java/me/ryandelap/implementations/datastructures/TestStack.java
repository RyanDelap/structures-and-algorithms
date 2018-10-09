package me.ryandelap.implementations.datastructures;

import org.junit.Test;
import static org.junit.Assert.*;

public class TestStack {
    @Test
    public void testStack() {
        Stack<String> stack = new Stack<>();

        assertEquals(true, stack.isEmpty());
        assertEquals(0, stack.length());

        stack.add("foobar1");

        assertEquals(false, stack.isEmpty());
        assertEquals(1, stack.length());

        stack.pop();

        assertEquals(true, stack.isEmpty());
        assertEquals(0, stack.length());

        stack.add("foobar1");
        stack.add("foobar2");

        assertEquals("foobar2", stack.peek());

        stack.pop();

        assertEquals("foobar1", stack.peek());

    }
}
