import static net.zhou.util.Print.*;
import static net.zhou.util.RandomArray.*;


public class Practice {

    static int partition(int[] array, int start, int end) {
	int base = array[start];
	int i=start+1;
	while (i <= end) {
	    if (array[i++] < base){
		array[start++] = array[i-1];
		array[i-1] = array[start];
	    }
	}
	array[start] = base;
	return start;
	
    }
    
    static void quickSort(int[] array, int start, int end) {
	if (start < end){
	    int p = partition(array, start, end);
	    quickSort(array, start, p);
	    quickSort(array, p+1, end);
	}
    }

    static class PriorityQueue {
	int[] heap;
	int size;
	//	int place = -1;

	PriorityQueue(int n) {
	    size = n;
	    heap = new int[n];
	}

	PriorityQueue(int[] array) {
	    size = array.length;
	    heap = buildHeap(array);
	    //  place = size - 1; // last element index
	}

	int pop() {
	    if (size == 0) {
		print("heap empty");
		return -1;
	    }
	    int mix = heap[0];
	    int i = 0, child;

	    while (2 * i + 1 < size) {
		child = 2 * i + 1;
		if (child + 1 <= size - 1 && heap[child + 1] < heap[child]) {
		    child++;
		}
		heap[i] = heap[child];
		i = child;
	    }
	    heap[i] = heap[--size];
	    
	    return mix;
	}
	
	void precolateDown(int[] array, int i) {
	    int key = array[i], child;
	    while (2 * i + 1 < array.length) {
		child = 2 * i + 1;
		if (child + 1 <= array.length -1
		    && array[child + 1] < array[child])
		    child++;
		if (array[child] < key) {
		    array[i] = array[child];
		    i = child;
		}
		else
		    break;
	    }
	    array[i] = key;
	}
	
	int[] buildHeap(int[] array) {
	    for (int i = array.length / 2 - 1; i >= 0; i--) {
		precolateDown(array, i);
	    }
	    return array;
	}
    }
    
    static public void main(String[] args) {
	int[] a = shuttleArray(10, 100, 10000);
	print(a);

	// heap
	PriorityQueue heap = new PriorityQueue(a);
	//print(heap.heap);
	print(heap.capacity);
	//print(heap.size);
	/*print(a);
	PriorityQueue pq = new PriorityQueue(a);
	print(pq.heap);
	for (int i = 0; i < a.length; i++)
	printnb(pq.pop());
	print((3/2));
	print(new Float(3));
	/*	int[] a = {1, 3, 2, 5, 0, 10, -100};
	quickSort(a, 0, a.length-1);
	print(a);*/
	int[] a1 = {0,0,1,1,1,2,2,3,3,4};
	int length = ReDuplication.reDuplicateSorted(a1);
	for (int i = 0; i < length; i++) {
	    printnb(a1[i]);
	}
    }
}

class PriorityQueue {
    int capacity;
    int size;
    int[] heap;

    void percolateDown(int i) {
	int element = heap[i], child;
	while (2 * i + 1 < size - 1) {
	    child = 2 * i + 1;
	    if (child + 1 != size - 1 && heap[child + 1] < heap[child])
		child++;
	    if (element < heap[child])
		break;
	    heap[i] = heap[child];
	    i = child;
	}
	heap[i] = element;
    }
    
    int[] buildHeap(int[] array) {
	for (int i = array.length >> 1; i > 0; i--)
	    percolateDown(i - 1);
	return array;
    }
    
    PriorityQueue(int[] array) {
	capacity = size = array.length;
	heap = buildHeap(array);
    }

    void fun() {
	print("sdadf");
    }
    
    int[] s() {
	return shuttleArray(10, 100, 101010);

    }
    
    int pop() {
	if (size > 0) {
	    print("error");
	    return -1;
	}
	int result = heap[0];
	int i = 0, child;
	size--;
	while (2 * i + 1 < size) {
	    child = 2 * i + 1;
	    if (child + 1 != size - 1 && heap[child + 1] < heap[child])
		child++;
	    heap[i] = heap[child];
	    i = child;
	}
	heap[i] = heap[size];
	return result;
    }
}


class ReDuplication {

    public static int reDuplicateSorted(int[] array) {
	if (array.length == 0)
	    return -1;
	int i, j, last = array[0];
	for (i = 1, j = 1; i < array.length; i++) {
	    if (last != array[i]) {
		last = array[i];
		if (i > j)
		    array[j++] = array[i];
	    }
	}
	return j;
    }
}
