package com.java.practice.heap;

/**
 * Created by user on 8/23/16.
 * It's a maxBinaryHeap.
 */

class BinaryHeap {
    private int [] array;
    private int count;
    private int capacity;
    private int heap_type;

    public int getHeap_type() {
        return heap_type;
    }

    public void setHeap_type(int heap_type) {
        this.heap_type = heap_type;
    }

    public BinaryHeap() {
        count = 0;
        array = null;
    }
    public BinaryHeap(int capacity) {
        count = 0;
        this.capacity = capacity;
        array = new int[capacity];
    }

    public int[] getArray() {
        return array;
    }

    public void setArray(int[] array) {
        this.array = array;
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

    public boolean isEmpty() {
        if (getCount() == 0) {
            return true;
        }
        return false;
    }

    public boolean isFull() {
        if (getCount() == getCapacity()) {
            return true;
        }
        return false;
    }

    public int getLeftChildIndex(int parentIndex) {
        int leftChieldIndex = 2*parentIndex + 1;

        if (leftChieldIndex < getCount()) {
            return leftChieldIndex;
        }
        return -1;
    }

    public int getRightChildIndex(int parentIndex) {
        int rightChieldIndex = 2*parentIndex + 1;

        if (rightChieldIndex < getCount()) {
            return rightChieldIndex;
        }
        return -1;
    }

    public int getParentIndex(int childIndex) {
        if(childIndex <= 0 && childIndex >= getCount()) {
            return -1;
        }
        return (childIndex-1)/2;
    }

    public int getMaxValue() {
        if (getCount()==0) {
            return -1;
        }
        return array[0];
    }

    public void swapElements(int i, int j) {
        int temp = array[i];
        array[i] = array[j];
        array[j] = temp;
    }

    public void heapifyFromTopToDown(int parentIndex) {
        int lChild, rChild, max,temp;
        lChild = getLeftChildIndex(parentIndex);
        rChild = getRightChildIndex(parentIndex);

        if (lChild != -1 && array[parentIndex] < array[lChild]) {
            max = lChild;
        } else {
            max = parentIndex;
        }

        if (rChild != -1 && array[max] < array[rChild]) {
            max = rChild;
        }

        if (max != parentIndex) {
            swapElements(parentIndex,max);
        }

        if(lChild != -1 && rChild != -1) {
            heapifyFromTopToDown(max);
        }
    }

    public int deleteMaxElementFromHeap() {
        if (isEmpty()) {
            System.out.println("Heap is already empty");
            return -1;
        }
        int temp = array[0];
        array[0] = array[getCount()-1];
        setCount(getCount()-1);
        heapifyFromTopToDown(0);
        return temp;
    }

    public void heapifyFromDownToTop(int i) {
        while (i > 0 && i < getCount()) {
            int parentIndex = getParentIndex(i);
            if (array[i] > array[parentIndex]) {
                swapElements(i, parentIndex);
                i = parentIndex;
            }
        }
    }

    public void resizeHeap() {
        int []oldArray = new int[getCapacity()];
        System.arraycopy(array,0,oldArray,0,getCount());
        array = new int[getCapacity()*2];
        System.arraycopy(oldArray,0,array,0,getCount());
        setCapacity(getCapacity()*2);
        oldArray = null;
    }

    public void insertHeapElement(int data) {
        if (isFull()) {
            resizeHeap();
        }
        if (array == null) {
            System.out.println("Memory Error");
            return;
        }

        array[getCount()+1] = data;
        setCount(getCount()+1);
        heapifyFromTopToDown(getCount()-1);
    }

    public void printHeap() {
        if(isEmpty()) {
            System.out.println("Heap is Empty");
        } else {
            for(int i = 0; i < getCount(); i++ ) {
                System.out.print(array[i] + "  ");
            }
        }
        System.out.println();
    }

    public void BuildHeap(int a[], int n) {
        while (getCapacity() < n) {
            resizeHeap();
        }

        for (int i = 0; i < n; i++) {
            array[i] = a[i];
        }

        setCount(n);
        for (int i = ((count-1)-1)/2; i >= 0 ; i--) {
            heapifyFromTopToDown(i);
        }
    }

    public void heapSort(int a[], int n) {
        int oldCount,i,temp;
        BuildHeap(a, n);
        oldCount = getCount();
        for (int j = n-1; j >= 0 ; j--) {
            temp = a[0];
            a[0] = a[getCount()-1];
            a[getCount()-1] = temp;
            count--;
            heapifyFromTopToDown(0);
            printHeap();
        }
        setCount(oldCount);
    }
    public int findMinFromMaxHeap() {
        int i = count-1;
        int minTemp = Integer.MAX_VALUE;
        while(i >= 0 && isLeaf(i)) {
            if(minTemp > array[i]) minTemp = array[i];
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
public class HeapTest {
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
            System.out.println("Something is wrong, May be Heap is empty");
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
