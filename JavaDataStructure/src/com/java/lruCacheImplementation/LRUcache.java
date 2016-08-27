package com.java.lruCacheImplementation;

/**
 * Created by user on 8/20/16.
 */
public class LRUcache {
}

class DoublyLinkedList {
    private Node head;
    private Node tail;
    private final int size;
    private int currSize;

    public DoublyLinkedList(int size) {
        this.size = size;
        this.currSize = 0;
        head = null;
        tail = null;
    }

    public Node getHead() {
        return head;
    }

    public void setHead(Node head) {
        this.head = head;
    }

    public Node getTail() {
        return tail;
    }

    public void setTail(Node tail) {
        this.tail = tail;
    }

    public int getSize() {
        return size;
    }

    public int getCurrSize() {
        return currSize;
    }

    public void setCurrSize(int currSize) {
        this.currSize = currSize;
    }

    public void printList() {
        if(head == null) {
            return;
        }
        Node temp = head;
        while (temp != null) {
            System.out.println(temp.getPageNumber());
            temp = temp.getNext();
        }
    }

    void addPageToLL(int pageNumber) {
        Node newPage = new Node(pageNumber);
        if (head == null) {
            head = newPage;
            tail = newPage;
            currSize++;
//            return newPage;
        } else if(currSize >= size) {
            tail = tail.getPrev();
            tail.setNext(null);
        }
        newPage.setNext(head);
        head.setPrev(newPage);

    }

    void movePageToHead() {

    }

    void searchPageInLL() {

    }


}


class Node {
    private int pageNumber;
    private Node prev;
    private Node next;

    Node(int pageNumber) {
        this.pageNumber = pageNumber;
    }
    @Override
    public String toString() {
        return "Node{" +
                "pageNumber=" + pageNumber +
                '}';
    }

    public int getPageNumber() {
        return pageNumber;
    }

    public void setPageNumber(int pageNumber) {
        this.pageNumber = pageNumber;
    }

    public Node getPrev() {
        return prev;
    }

    public void setPrev(Node prev) {
        this.prev = prev;
    }

    public Node getNext() {
        return next;
    }

    public void setNext(Node next) {
        this.next = next;
    }
}
