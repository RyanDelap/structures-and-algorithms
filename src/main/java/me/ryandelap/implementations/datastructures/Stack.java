package me.ryandelap.implementations.datastructures;

import java.util.NoSuchElementException;

/**
 * An implementation of the stack data structure.
 * Last in First out (LIFO)
 * @param <T> The type of object we want to store in this Stack.
 */
public class Stack<T> {

    private Node head;

    public boolean isEmpty() {
        return (head == null) ? true : false;
    }

    public int length(){
        int length = 0;
        Node current = head;

        while(current != null) {
            System.out.println(current.data);

            length++;
            current = current.next;
        }
        return length;
    }

    public void add(T data){
        if (head == null) {
            head = new Node(data);
        } else {
            Node entry = new Node(data);
            entry.next = head;
            head = entry;
        }
    }

    public void pop() {
        if(head == null) {
            throw new NoSuchElementException("No elements in Stack.");
        }

        head = head.next; //Remove first element of stack.

    }

    public T peek() {
        return (T) head.data;
    }

    private class Node<E> {
        private E data;
        private Node next;

        private Node(E data){
            this.data = data;
            this.next = null;
        }
    }

}
