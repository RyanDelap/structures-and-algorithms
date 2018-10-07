package me.ryandelap.implementations.datastructures;

import java.util.Iterator;

/**
 *
 * An implementation of a linked list in one direction. This implementation is fully iterable and can be used with
 * any type of object.
 *
 * @see <a href="https://en.wikipedia.org/wiki/Linked_list">https://en.wikipedia.org/wiki/Linked_list</a>
 * @param <E> The type of elements in this list.
 */
public class SinglyLinkedList<E> implements Iterable<E> {
    private Node head;

    /**
     *
     * @return if the linked list is empty or not.
     */
    public boolean isEmpty() {
        return length() == 0;
    }

    /**
     *
     * @return The length of the linked list.
     */
    public int length(){
        int length = 0;
        Node current = head;

        while(current != null) {
            length++;
            current = current.next;
        }
        return length;
    }

    /**
     *
     * @param data to append to the linked list.
     */
    public void append(E data) {
        if(head == null) {
            head = new Node(data);
        } else {

            getTail().next = new Node(data);
        }
    }

    private Node getTail() {
        Node current = head;

        while(current.next != null) { //Keep moving the tail till we find the last object of the linkedlist.
            current = current.next;
        }

        return current;
    }

    @Override
    public Iterator<E> iterator() {
        Iterator<E> it = new Iterator<E>() {

            private Node current = head;

            @Override
            public boolean hasNext() {
                return current != null;
            }

            @Override
            public E next() {
                E data = (E) current.data;

                if(current.next != null) {
                    current = current.next;
                } else {
                    current = null;
                }

                return data;
            }

            @Override
            public void remove() {
                throw new UnsupportedOperationException();
            }
        };
        return it;
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
