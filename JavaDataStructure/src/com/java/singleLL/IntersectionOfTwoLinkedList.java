package com.java.singleLL;

import com.java.singleLL.*;

public class IntersectionOfTwoLinkedList {

	/**
	 * @param args
	 * @author Chetan Raj Bharti
	 * @category Linked List
	 */
	public static void main(String[] args) {

		SLL<Integer> l1 = new SLL<Integer>();
		SLL<Integer> l2 = new SLL<Integer>();
		SLL<Integer> l3 = new SLL<Integer>();

		l1.insertInLast(3);
		l1.insertInLast(4);
		l1.insertInLast(5);

		l2.insertInLast(1);
		l2.insertInLast(2);
		l2.insertInLast(3);
		l2.insertInLast(4);
		l2.insertInLast(5);

		l3.insertInLast(6);
		l3.insertInLast(7);
		l3.insertInLast(8);
		l3.insertInLast(9);

		l1.setLastNode(l3.getFirst());
		l2.setLastNode(l3.getFirst());

		System.out.println("First Linked List :: ");
		l1.display();

		System.out.println("Second Linked List :: ");
		l2.display();

		System.out.println("Third Linked List :: ");
		l3.display();

		Node<Integer> intersection = getIntersectionNode(l1,l2);

		
		if(intersection == null) {
			System.out.println("No Intersection Node");
		} else {
			System.out.println("Intersection Node of both the linked list is :: " + intersection.getData());
		}

	}
	
	/**
	 * @author user
	 * @param Singly linked list 
	 * @return Intersection node of two linked list
	 */
	static <T> Node<T> getIntersectionNode(SLL<T> l1, SLL<T> l2) {
		int l1Length = l1.length();
		int l2Length = l2.length();
		int diff = 0;
		
		Node<T> l1Head = l1.getFirst();
		Node<T> l2Head = l2.getFirst();
		Node<T> intersection = null;
		
		if(l1Length > l2Length) {
			diff = l1Length - l2Length;
			while(diff > 0) {
				l1Head = l1Head.getNext();
				diff--;
			}
		}else if(l2Length > l1Length) {
			diff = l2Length - l1Length;
			while(diff > 0) {
				l2Head = l2Head.getNext();
				diff--;
			}
		}
		
		while(l1Head != null && l2Head != null) {
			if(l1Head.equals(l2Head)) {
				intersection = l1Head;
				break;
			}
			l1Head = l1Head.getNext();
			l2Head = l2Head.getNext(); 
		}

		return intersection;
	}
	
}
