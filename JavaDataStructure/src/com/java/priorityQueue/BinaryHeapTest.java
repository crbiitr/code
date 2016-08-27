package com.java.priorityQueue;

/**
 * It is a Max binary heap implementation.
 * @author Chetan
 */

class BinaryHeap {
	public int heap[];
	public int count;
	public int capacity;

	public BinaryHeap() {
		count = capacity = 0;
		heap = null;
	}

	public BinaryHeap(int size) {
		heap = new int[size];
		count = 0;
		capacity = size;
	}

	public int[] getHeap() {
		return heap;
	}

	public void setHeap(int[] heap) {
		this.heap = heap;
	}

	public int getCount() {
		return count;
	}

	public void setCount(int count) {
		this.count = count;
	}

	public int getCapacity() {
		return capacity;
	}

	public void setCapacity(int capacity) {
		this.capacity = capacity;
	}

	public boolean isFull() {
		if(getCount() == getCapacity()) return true;

		return false;
	}

	public boolean isEmpty() {
		if(getCount() == 0) return true;

		return false;
	}

	public int getParentIndex(int i) {
		if(i <= 0 && i > getCount()) return -1;

		return (i-1)/2;
	}

	public int getLeftChildIndex(int rootIndex) {
		int leftChildIndex = 2*rootIndex + 1;
		if(leftChildIndex >= getCount()) return -1;

		return leftChildIndex;
	}

	public int getRightChildIndex(int rootIndex) {
		int rightChildIndex = 2*rootIndex + 2;
		if(rightChildIndex >= getCount()) return -1;

		return rightChildIndex;
	}

	public int getMaximum() {
		if(getCount() == 0) return -1;

		return heap[0];
	}

	//Running top to down for heapify the elements
	public void heapifyFromTopToDown(int rootIndex) {
		int leftChildIndex, rightChildIndex, maxValueIndex;

		leftChildIndex = getLeftChildIndex(rootIndex);
		rightChildIndex = getRightChildIndex(rootIndex);

		if(leftChildIndex != -1 && heap[leftChildIndex] > heap[rootIndex]) {
			maxValueIndex = leftChildIndex;
		} else {
			maxValueIndex = rootIndex;
		} 

		if(rightChildIndex != -1 && heap[rightChildIndex] > heap[maxValueIndex]) {
			maxValueIndex = rightChildIndex;
		}

		if(maxValueIndex != rootIndex) {
			swap(maxValueIndex, rootIndex);
		}

		if(leftChildIndex != -1 && rightChildIndex != -1)
			heapifyFromTopToDown(maxValueIndex);

	}

    public int deleteMaxElementFromHeap() {
        int temp;
        if(isEmpty()) return temp = -1;
        temp = heap[0];
        heap[0] = heap[count - 1];
        count--;
        heapifyFromTopToDown(0);
        return temp;
    }

    public void insertHeapElement(int data) {
        if(isFull()) {
            ResizeHeap();
        } else {
            heap[getCount()] = data;
            setCount(getCount() + 1);
        }
        heapifyFromDownToTop(getCount() -1);
    }

	public void heapifyFromDownToTop(int childIndex) {
		int rootIndex = getParentIndex(childIndex);

		while(childIndex > 1 && heap[childIndex] > heap[rootIndex]) {
			swap(childIndex, rootIndex);
			childIndex = rootIndex;
			rootIndex = getParentIndex(childIndex);
		}
	}

	private void swap(int x, int y) {
		int temp;
		temp = heap[x];
		heap[x] = heap[y];
		heap[y] = temp;
	}

	public void printHeap() {
		if(isEmpty()) {
			System.out.println("Heap is Empty");
		} else {
			for(int i = 0; i < getCount(); i++ ) {
				System.out.print(heap[i] + "  ");
			}
		}
		System.out.println();
	}

	public void ResizeHeap() {
		int arrayOld[] = new int[capacity];
		System.arraycopy(heap, 0, arrayOld, 0, count);
		capacity *=2;
		heap = new int[capacity];

		if(heap == null) {
			System.out.println("Memory Error");
			return;
		}

		for(int i = 0; i < count; i++) {
			heap[i] = arrayOld[i];
		}
		arrayOld = null;
	}

	public void BuildHeap(int[] A, int n) {

		if(capacity < n) {
			ResizeHeap();
		}

		for(int i = 0; i < n; i++) {
			heap[i] = A[i];
		}
		count = n;

		for(int i = (count-1)/2; i >= 0; i--) {
			heapifyFromTopToDown(i);
		}
	}
	public void heapSort(int array[], int n) {
		BuildHeap(array, array.length);

		int tempIndex = count;
		int temp;
		for(int i = n-1; i >= 1; i--) {
			temp = heap[0];
			heap[0] = heap[i];
			heap[i] = temp;
			count--;
			heapifyFromTopToDown(0);
			printHeap();
		}
		count = tempIndex;
	}
	
	public int findMinFromMaxHeap() {
		int i = count-1;
		int minTemp = Integer.MAX_VALUE;
		while(i >= 0 && isLeaf(i)) {
			if(minTemp > heap[i]) minTemp = heap[i];
			i--;
		}
		
		return minTemp;
	}
	
	public boolean isLeaf(int i) {
		boolean leaf = false;
		if(getLeftChildIndex(i) == -1 && getRightChildIndex(i) == -1) leaf = true;
		return leaf;
	}

}

public class BinaryHeapTest {

	public static void main(String[] args) {

		BinaryHeap bh = new BinaryHeap(10);
		bh.insertHeapElement(31);
		bh.insertHeapElement(10);
		bh.insertHeapElement(16);
		bh.insertHeapElement(2);
		bh.insertHeapElement(8);
		bh.insertHeapElement(14);
		bh.insertHeapElement(12);
		bh.insertHeapElement(3);
		bh.insertHeapElement(1);
		bh.insertHeapElement(5);
		bh.insertHeapElement(7);
		bh.insertHeapElement(19);
		bh.printHeap();

		bh.insertHeapElement(32);
		bh.printHeap();

		System.out.println("Deleting Max Element of the Heap");
		int canDelete = bh.deleteMaxElementFromHeap();
		if(canDelete == -1) {
			System.out.println("Can not delete element because Heap is Empty");
		} else {
			System.out.println("Deleted Element is :: " + canDelete);
		}

		System.out.println("Print Heap after Deleting maximum element " );
		bh.printHeap();

		// Build Heap function
		int A[] = {1,2,4,5,7,8,3,9}; 
		BinaryHeap bh1 = new BinaryHeap(10);
		bh1.BuildHeap(A, A.length);
		System.out.println("Printing new Heap bh1");
		bh1.printHeap();
		
		int minTemp = bh1.findMinFromMaxHeap();
		if(minTemp != Integer.MAX_VALUE) {
			System.out.println("Min value in Max heap bh1 is :: " + minTemp);
		}else {
			System.out.println("Somthing is wrong, May be Heap is empty");
		}

		// HeapSort 
		System.out.println("HeapSort Start from Here-------------->");
		int B[] = {4,7,3,6,8,12,34,56,78,22,43,9};
		BinaryHeap bh2 = new BinaryHeap(10);
		bh2.heapSort(B, B.length);
		System.out.println("Array B after HeapSort-------------->");
		bh2.printHeap();
		
	}

}
