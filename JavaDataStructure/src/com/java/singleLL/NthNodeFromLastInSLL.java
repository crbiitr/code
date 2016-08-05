package com.java.singleLL;

import com.java.singleLL.SLL;

public class NthNodeFromLastInSLL {

	public static void main(String [] args) {
		SLL<Integer> ll = new SLL<Integer>();
		ll.insertInStart(1);
		ll.insertInStart(2);
		ll.insertInStart(3);
		ll.insertInStart(4);
		ll.insertInStart(5);
		
		ll.insertInLast(6);
		ll.insertInLast(7);
		ll.insertInLast(8);
		
		ll.insertInMiddle(9, 3);
		ll.insertInMiddle(10, 1);
		ll.insertInMiddle(11, 13);
		ll.insertInMiddle(12, 3);
		ll.display();
		
		System.out.println("Deleting Elements From start :: " + nthNodeFromLastPosition(ll.getFirst(), 4).getData());
		
		
	}
	
	static Node<Integer> nthNodeFromLastPosition(Node<Integer> first, int position) {
		
		Node<Integer> temp1 = null;
		Node<Integer> temp2 = null;
		temp2 = first;
		int count = 0;
		while(temp2 != null) {
			count++;
			if(count - position == 0) {
				temp1 = first;
			} else if(count - position > 0) {
				temp1 = temp1.getNext();
			}
			temp2 = temp2.getNext();
			
		}
		
		return temp1;
	}
}
