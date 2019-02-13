package com.java.singleLL.rotation;

/**
 * @author Chetan Raj
 * @implNote https://www.geeksforgeeks.org/rotate-linked-list-block-wise/
 * @since : 12/02/19
 */
public class RotateLLGroupWise {
	public static void main(String[] args) {
		SLL<Integer> ll = new SLL<>();
		ll.insertInStart(1);
		ll.insertInLast(2);
		ll.insertInLast(3);
		ll.insertInLast(4);
		ll.insertInLast(5);
		ll.insertInLast(6);
		ll.insertInLast(7);
		ll.insertInLast(8);
		ll.insertInLast(9);

		ll.display();
		RotateLLGroupWise rotateLLGroupWise = new RotateLLGroupWise();
		rotateLLGroupWise.rotateLinkedListGroupWise(ll.getHead(), 3, 1);
		ll.display();

	}

	public void rotateLinkedListGroupWise(Node head, int groupLength, int rotationCount) {
		Node curr = head, pre = null;
		boolean isHeadSet = false;
		Node preLast = null;
		while (curr != null) {
			Node currHead = curr;
			int currentGroupLength = groupLength;
			while (currentGroupLength >= 1) {
				pre = curr;
				curr = curr.getNext();
				currentGroupLength--;
			}
			if (currentGroupLength == 0) {
				preLast = pre;
				pre.setNext(null);
				Node headOfRotatedLinkedList = rotateLinkedListRotationCountWise(currHead, pre, rotationCount);

				if (!isHeadSet) {
					head = headOfRotatedLinkedList;
					isHeadSet = true;
				} else {
					preLast.setNext(headOfRotatedLinkedList);
				}
				while (headOfRotatedLinkedList.getNext() != null) {

					headOfRotatedLinkedList = headOfRotatedLinkedList.getNext();
				}
				headOfRotatedLinkedList.setNext(curr);
			}
		}

	}

	public Node rotateLinkedListRotationCountWise(Node head, Node last, int rotationCount) {
		while (rotationCount >= 1) {
			Node pre = head;
			head = head.getNext();
			pre.setNext(null);
			last.setNext(pre);
			rotationCount--;
		}
		return head;
	}
}
