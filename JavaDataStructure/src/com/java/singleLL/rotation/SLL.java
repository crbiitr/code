package com.java.singleLL.rotation;

/**
 * @author Chetan Raj
 * @implNote
 * @since : 12/02/19
 */
public class SLL<T> {
	private Node<T> head;

	public SLL() {
		head = null;
	}

	public Node<T> getHead() {
		return head;
	}

	public void setHead(Node<T> head) {
		this.head = head;
	}

	public boolean isEmpty() {
		return head == null;
	}

	public void insertInStart(T data) {
		Node<T> node = new Node<T>(data);
		node.setNext(head);
		setHead(node);
	}

	public void insertInLast(T data) {
		if (getHead() == null) {
			insertInStart(data);
		} else {
			Node<T> node = new Node<T>(data);
			Node<T> temp = getHead();
			while (temp.getNext() != null) {
				temp = temp.getNext();
			}
			temp.setNext(node);
		}
	}

	public void display() {
		Node<T> temp = getHead();
		while (temp != null) {
			System.out.print("  " + temp.getData());
			temp = temp.getNext();
		}
		System.out.println("\n");
	}
}
