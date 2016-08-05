package com.java.singleLL;

public class CreateSLLByTwoSortedSLL {

	/**
	 * @param args
	 */
	public static void main(String[] args) {

		SLL<Integer> l1 = new SLL<Integer>();
		SLL<Integer> l2 = new SLL<Integer>();
		SLL<Integer> l3 = new SLL<Integer>();
		
		l1.insertInLast(1);
		l1.insertInLast(2);
		l1.insertInLast(3);
		l1.insertInLast(8);
		l1.insertInLast(10);
		l1.insertInLast(15);
		
		l2.insertInLast(0);
		l2.insertInLast(2);
		l2.insertInLast(4);
		l2.insertInLast(5);
		l2.insertInLast(8);
		l2.insertInLast(10);
		l2.insertInLast(12);

		System.out.println("First Linked List :: ");
		l1.display();

		System.out.println("Second Linked List :: ");
		l2.display();
		
/*		createSLLUsingTwoSortedSLL(l3, l1.getFirst(), l2.getFirst());
		System.out.println("Third Linked List :: ");
		l3.display();
*/
		l3.setFirst(createSLLUsingTwoSortedSLLByRecursion(l1.getFirst(), l2.getFirst()));
		System.out.println("Third Linked List :: ");
		l3.display();
	}
	
	public static <T extends Integer> void createSLLUsingTwoSortedSLL(SLL<T> l3, Node<T>l1Head, Node<T>l2Head) {
		
		Node<T> temp = null;
		while(l1Head != null && l2Head != null) {
			if(l1Head.getData() >= l2Head.getData()) {
				temp = l2Head;
				l2Head = l2Head.getNext();
			} else {
				temp = l1Head;
				l1Head = l1Head.getNext();
			}
			l3.insertInLast(temp.getData());
		}
		
		if(l1Head != null) {
			while (l1Head != null) {
				l3.insertInLast(l1Head.getData());
				l1Head = l1Head.getNext();
			}
		}
		
		if(l2Head != null) {
			while (l2Head != null) {
				l3.insertInLast(l2Head.getData());
				l2Head = l2Head.getNext();
			}
		}
	}
	
	static <T extends Integer> Node<T> createSLLUsingTwoSortedSLLByRecursion(Node<T> l1, Node<T> l2) {
		
		Node<T> result = null;
		if(l1 == null) return l2;
		if(l2 == null) return l1;
		
		if(l1.getData() >= l2.getData()) {
			result.setData(l1.getData());
			result.setNext(createSLLUsingTwoSortedSLLByRecursion(l1, l2.getNext()));
		} else {
			result.setData(l2.getData());
			result.setNext(createSLLUsingTwoSortedSLLByRecursion(l1.getNext(), l2));
		}
		return result;
	}

}
