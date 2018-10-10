package me.ryandelap.implementations.datastructures;

import java.util.NoSuchElementException;

/**
 * An implementation of the queue data structure.
 * First in, first out. (FIFO)
 * @param <T> The type of object we want to store in this queue.
 */
public class Queue<T> {

    private Node head;
    private Node tail;

    public boolean isEmpty() {
        return (head == null) ? true : false;
    }

    public int length(){
        int length = 0;
        Node current = head;

        while(current != null) {
            length++;
            current = current.next;
        }
        return length;
    }

    public void enqueue(T data){
        if (head == null) {
            head = new Node(data);
            tail = head; //Tail is also the head
        } else {
            Node entry = new Node(data);
            tail.next = entry; //Set the current reference of tail to the new entry.
            tail = entry; //Update the tail to be the new entry.
        }
    }

    public void dequeue() {
        if(head == null) {
            throw new NoSuchElementException("No elements in Queue.");
        }

        head = head.next; //Will either be null or the next node.
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
