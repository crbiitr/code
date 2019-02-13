package com.java.singleLL.rotation;

/**
 * @author Chetan Raj
 * @implNote
 * @since : 12/02/19
 */
public class Node<T> {
	private T data;
	private Node<T> next;

	public Node(T d) {
		data = d;
		next = null;
	}

	public Node(){}
	public T getData() {
		return data;
	}

	public void setData(T data) {
		this.data = data;
	}

	public Node<T> getNext() {
		return next;
	}

	public void setNext(Node<T> next) {
		this.next = next;
	}

}
