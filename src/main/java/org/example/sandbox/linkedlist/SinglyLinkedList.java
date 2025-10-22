package org.example.sandbox.linkedlist;

import java.util.StringJoiner;

public class SinglyLinkedList<E> implements LinkedList<E> {

    private Node head;
    private Node tail;
    private int size;

    public SinglyLinkedList() {
        head = null;
        tail = null;
        size = 0;
    }

    @Override
    public void addFirst(E element) {
        Node node = new Node(element, head);

        if (head==null) {
            head = node;
            tail = node;
        }
    }
    @Override
    public void addLast(E e) {
    }

    @Override
    public E pollFirst() {
        return null;
    }
    @Override
    public E pollLast() {
        return null;
    }
    @Override
    public E peekFirst() {
        return null;
    }
    @Override
    public E peekLast() {
        return null;
    }

    @Override
    public void clear() {

    }

    @Override
    public boolean isEmpty() {
        return false;
    }
    @Override
    public int size() {
        return 0;
    }

    @Override
    public String toString() {
        StringBuilder builder = new StringBuilder("[");
        StringJoiner joiner = new StringJoiner(", ");

        Node current = head;
        if (current!=null) {
            while (current!=null) {
                joiner.add(current.toString());
                current = current.next;
            }
        }

        builder.append(joiner.toString());
        builder.append("]");
        return builder.toString();

    }


    private class Node {
        E element;
        Node next;

        public Node(E element, Node next) {
            this.element = element;
            this.next = next;
        }
    }
}
