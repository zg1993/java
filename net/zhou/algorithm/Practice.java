import static net.zhou.util.Print.*;
import static net.zhou.util.RandomArray.*;


public class Practice {

    static int partition(int[] array, int start, int end) {
	int base = array[start];
	int i=start+1;
	while (i <= end) {
	    print(i);
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
	int[] a = shuttleArray(10, 100);
	print(a);
	PriorityQueue pq = new PriorityQueue(a);
	print(pq.heap);
	for (int i = 0; i < a.length; i++)
	    printnb(pq.pop());
	/*	int[] a = {1, 3, 2, 5, 0, 10, -100};
	quickSort(a, 0, a.length-1);
	print(a);*/
    }
}
