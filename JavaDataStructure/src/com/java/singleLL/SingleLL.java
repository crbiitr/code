package com.java.singleLL;

class Node<T> {
	private T data;
	private Node<T> next;
	private Node<T> down; // Using in Flattening a single LL

	public Node(T d) {
		data = d;
		next = null;
	}

	public Node(T data, Node<T> next) {
		this.data = data;
		this.next = next;
	}

	public Node(Node<T> next, Node<T> down) {
		this.next = next;
		this.down = down;
	}

	public Node(T data, Node<T> next, Node<T> down) {
		this.data = data;
		this.next = next;
		this.down = down;
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

	public Node<T> getDown() {
		return down;
	}

	public void setDown(Node<T> down) {
		this.down = down;
	}
}

class SLL<T> {

	private Node<T> first;

	public SLL() {
		first = null;
	}

	public Node<T> getFirst() {
		return first;
	}

	public void setFirst(Node<T> first) {
		this.first = first;
	}

	public boolean isEmpty() {
		return first == null;
	}

	public void insertInStart(T data) {
		Node<T> node = new Node<T>(data);

		//node.setData(d);
		node.setNext(first);
		setFirst(node);
	}

	public void insertInLast(T data) {

		if(getFirst() == null) {
			insertInStart(data);
		} else {
			Node<T> node = new Node<T>(data);
			Node <T> temp = getFirst();
			while (temp.getNext() != null) {
				temp = temp.getNext();
			}
			temp.setNext(node);
		}
	}

	public void insertInMiddle(T data, int position) {
		if(position == 1) {
			insertInStart(data);
		}else {
			Node<T> temp = getFirst();
			Node<T> previous = null;
			int count = 0;
			while(temp != null && count < (position - 1)) {
				previous = temp;
				temp = temp.getNext();
				count++;
			}
			if(temp == null) {
				insertInLast(data);
			}else {
				Node<T> node = new Node<T>(data);
				previous.setNext(node);
				node.setNext(temp);
			}
		}
	}

	public void display() {
		Node<T> temp = getFirst();
		while(temp != null) {
			System.out.print("  " + temp.getData());
			temp = temp.getNext();
		}
		System.out.println("\n");
	}

	public void deleteFromStart() {
		if(!isEmpty()) {
			//			first = first.getNext();
			Node<T> temp = getFirst();
			temp = temp.getNext();
			setFirst(temp);
		} else {
			System.out.println("List is Empty. Can't delete elements");
		}
	}

	public void deleteFromLast() {
		if(!isEmpty()) {
			Node<T> temp = getFirst();
			Node<T> previous = null;
			while(temp.getNext() != null) {
				previous = temp;
				temp = temp.getNext();
			}
			previous.setNext(null);
		} else {
			System.out.println("List is Empty. Can't delete elements from Last");
		}
	}

	public void deleteFromMiddle(int position) {
		if(position == 1) {
			deleteFromStart();
		} else {
			Node<T> temp = getFirst();
			Node<T> previous = null;
			int count = 0;
			while(temp != null && count < (position - 1)) {
				previous = temp;
				temp = temp.getNext();
				count++;
			}
			if(temp == null) {
				System.out.println("This position is not present in the linked list");
			} else {
				previous.setNext(temp.getNext());
			}
		}
	}

	public Node<T> nthNodeFromLast(int position) {
		Node<T> temp1 = null;
		Node<T> temp2 = null;
		temp2 = getFirst();
		int count = 0;
		while(temp2 != null) {
			count++;
			if(count - position == 0) {
				temp1 = getFirst();
			} else if(count - position > 0) {
				temp1 = temp1.getNext();
			}
			temp2 = temp2.getNext();

		}

		return temp1;
	}

	public void creatingCycleInLL() {

		Node<T> temp = getFirst();
		Node<T> temp1 = getFirst();
		int count = 0;
		while(temp.getNext() != null) {
			temp = temp.getNext();
			if(count<5) {
				temp1 = temp1.getNext();
				count++;
			}
		}
		temp.setNext(temp1);
	}

	public boolean findCycleInLL() {

		boolean result = false;
		Node<T> slow = getFirst();
		Node<T> fast = getFirst();
		while(slow != null && fast != null && fast.getNext() != null) {
			if(slow != null) {
				slow = slow.getNext();
			}

			if(fast != null) {
				if(fast.getNext() != null) {
					fast = fast.getNext().getNext();
				}
			}

			if(slow == fast) {
				result = true;
				break;
			}
		}
		return result;
	}

	public Node<T> getStartingNodeOfLoopInLL() {
		Node<T> startNodeOfLoop = null;
		Node<T> slow = getFirst();
		Node<T> fast = getFirst();
		boolean result = false;
		while(slow != null && fast != null && fast.getNext() != null) {
			if(slow != null) {
				slow = slow.getNext();
			}

			if(fast != null) {
				if(fast.getNext() != null) {
					fast = fast.getNext().getNext();
				}
			}

			if(slow == fast) {
				result = true;
				slow = getFirst();
				break;
			}
		}
		
		if(result) {
			while(slow != null) {
				if(slow == fast) {
					startNodeOfLoop = slow;
					break;
				}
				
				slow = slow.getNext();
				fast = fast.getNext();
			}
		}
		
		return startNodeOfLoop;
	}
	
	public int findLengthOfLoopInLL() {
		
		int length = 0;
		Node<T> startNodeOfLoop = getStartingNodeOfLoopInLL();
		Node<T> temp = startNodeOfLoop;
		if(startNodeOfLoop != null) {
			do {
				temp = temp.getNext();
				length++;
			}while(temp != startNodeOfLoop);
		}
		return length;
	}

	public Node<T> reverseLL() {
		Node<T> head = getFirst();
		Node<T> nextNode = null;
		Node<T> temp = null;
		
		while(head != null) {
			nextNode = head.getNext();
			head.setNext(temp);
			temp = head;
			head = nextNode;
		}
		return temp;
	}

	public void setLastNode(Node<T> lastNode) {
		this.getLastNode().setNext(lastNode);
	}
	public Node<T> getLastNode() {
		Node<T> head  = null;
		if(this.isEmpty()) {
			return head;
		} else {
			head = this.getFirst();
			while(head.getNext() != null) {
				head = head.getNext();
			}
		}
		return head;
	}
	
	public int length() {
		int length = 0;
		Node<T> head = getFirst();
		while(head != null) {
			head = head.getNext();
			length++;
		}
		return length;
	}
	
	public Node<T> getMiddleNodeOfLL() {
		Node<T> slowNode = getFirst();
		Node<T> fastNode = getFirst();
		/*
		//This is the old logic(Commented code) which i wrote, and it is wrong. Please follow the
		// Uncommented logic. Because this commented logic does not work for EVEN no of elements.
		while(fastNode != null && fastNode.getNext() != null) {
			if(fastNode != null && fastNode.getNext() != null) {
				fastNode= fastNode.getNext().getNext();
			}
			slowNode = slowNode.getNext();
		}
        */

        if (fastNode == null) {
            return fastNode;
        }
        int i = 0;
        while (fastNode.getNext() != null) {
        // Main logic is to check fastNode's next pointer is null, not the fastNode pointer is null
            if (i == 0) {
                fastNode = fastNode.getNext();
                i = 1;
            } else if (i == 1) {
                fastNode = fastNode.getNext();
                slowNode = slowNode.getNext();
                i = 0;
            }
        }
		return slowNode;
	}
	
	void printLLfromLast(Node<T> node) {
		if(node == null) return;
		printLLfromLast(node.getNext());
		System.out.print("  " + node.getData());
	}
	
	void reverseBlockOfKNodesItrative(int k) {
		Node<T> cur = getFirst(), temp=null, next, newHead, curTemp, prev=null;
		Node<T> prev1 = null;
		
		// using k-1 for getting kth node, so that we can
		// set it as head
		if (hasKNodes(cur, k-1)) {
			newHead = getKPlusOnethNode(cur, k-1); 
		} else {
			newHead = cur;
		}
		boolean flag = false;
		while(cur != null && hasKNodes(cur, k)) {
			if (flag && temp != null) {
				prev = getKPlusOnethNode(temp, k-1);
			}
			prev1 = getKPlusOnethNode(cur, k-1);
			temp = getKPlusOnethNode(cur, k);

			int i = 0;
			while(i < k) {
				next = cur.getNext();
				cur.setNext(temp);
				temp = cur;
				cur = next;
				i++;
			}

			if (flag) {
				prev.setNext(prev1);
			}
			flag = true;
		}
		
		this.setFirst(newHead);
	}
	
	public boolean hasKNodes(Node<T> cur, int k) {
		boolean flag = false;
		for (int i = 0;  (cur != null && i <= k) || (cur != null || i == k); i++,cur = cur.getNext()) {
			if (i == k) {
				flag = true;
				return flag; // This is important for corner cases; Return from here only
			}
			
		}
		return flag;
	}
	
	public Node<T> getKPlusOnethNode(Node<T> cur, int k) {
		
		for (int i = 0; (cur != null && i <= k) || (cur != null || i == k); i++,cur = cur.getNext()) {
			if (i == k) {
				return cur;
			} 
		}
		return null;
	}
	
}

public class SingleLL {

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

		System.out.println("Deleting Elements From start");
		ll.deleteFromStart();
		ll.display();
		System.out.println("Deleting Elements From last");
		ll.deleteFromLast();
		ll.display();
		System.out.println("Deleting Elements From 3rd Position");
		ll.deleteFromMiddle(3);
		ll.display();

		System.out.println("5th Node From The Last :: " + ll.nthNodeFromLast(5).getData());

		System.out.println("Linked List after reverse :: ");
		ll.setFirst(ll.reverseLL());
		ll.display(); 

        Node<Integer> node;
        node = ll.getMiddleNodeOfLL();
        if (node != null) {
            System.out.println("Middle Of the Linked List is :: " + ll.getMiddleNodeOfLL().getData());
        } else {
            System.out.println("Linked List is null");
        }

		System.out.println("Display Linked List from last :: ");
		ll.printLLfromLast(ll.getFirst());
		System.out.println();
		
		int k = 2;
//		ll.insertInLast(80);
		System.out.println("After reverse Block of " + k + " Nodes in Linked List :: ");
		ll.reverseBlockOfKNodesItrative(k);
		ll.display();
		
		ll.creatingCycleInLL();
		if(ll.findCycleInLL()) {
			System.out.println("Cycle is present in the Linked List!!");
			System.out.println("Starting Node of the Loop is :: " + ll.getStartingNodeOfLoopInLL().getData());
			System.out.println("Length of the loop is :: " + ll.findLengthOfLoopInLL());
		} else {
			System.out.println("Cycle does not present in the Linked List");
		}

	}
}