package me.ryandelap.implementations.datastructures;

import org.junit.Test;
import static org.junit.Assert.*;


public class LinkedListTest {

    @Test
    public void testSingleLinkedList(){
        SinglyLinkedList<String> list = new SinglyLinkedList<>();

        assertEquals(0, list.length());
        assertEquals(true, list.isEmpty());

        list.append("foobar");

        assertEquals(1, list.length());
        assertEquals(false, list.isEmpty());

    }
}
