package net.zhou.algorithm;

import static net.zhou.util.Print.*;
import static net.zhou.algorithm.Sorted.*;


public class PriorityQueue {
    int capacity;
    int size;
    int[] heap;
    int count = 0;

    PriorityQueue(int i) {
	capacity = i;
	heap = new int[i+1];
	heap[0] = -1;
	//heap[0] = Double.NEGATIVE_INFINITY;
    }

    PriorityQueue(int[] array) {
	capacity = array.length - 1;
	size = capacity;
	heap = array;
	for (int i = size >> 1; i > 0; i--)
	    percolate(i);
    }

    void percolate(int i) {
	int temp = heap[i];
	while (2 * i <= size) {
	    count++;
	    int child = 2 * i;
	    if (child != size && heap[child] > heap[child+1])
		child++;
	    if (heap[i] > heap[child]) {
		heap[i] = heap[child];
		heap[child] = temp;
		i = child;
	    }
	    else
		break;
	}
	heap[i] = temp;
	print(heap);
    }

    public void delete(int i) {
	while (i * 2 < size) {
	    int child = i * 2;
	    if (child != size && heap[child] > heap[child+1])
		child++;
	    heap[i] = heap[child];
	    i = child;
	}
	heap[i] = heap[size--];
    }

    public void increaseKey(int i, int add_key) {
	heap[i] += add_key;
	percolate(i);
    }
    
    public void put(int element) {
	assert (size < capacity);
	int i;
	for (i = ++size; element < heap[i>>1]; i >>= 1 ) {
	    heap[i] = heap[i>>1];
	}
	heap[i] = element; 
    }

    public int pop1() {
	if (size == 0)
	    return -1;
	int value = heap[1];
	int i = 1;
	while (i*2 < size) {
	    count++;
	    int child;
	    if (i*2 != size && heap[i*2] > heap[i*2+1])
		child = i*2 + 1;
	    else
		child = i*2;
	    heap[i] = heap[child];
	    i = child;
	}
	heap[i] = heap[size--];
	return value;
    }
    // advanced size the bigger the more obvious
    public int pop() {
	if (size == 0)
	    return -1;
	int i, child, minValue, lastElement;
	minValue = heap[1];
	lastElement = heap[size];
	for (i = 1; 2 * i < size; i = child) {
	    count++;
	    child = 2 * i;
	    if (child != size && heap[child+1] < heap[child])
		child++;
	    if (lastElement > heap[child])
		heap[i] = heap[child];
	    else
		break;
	}
	heap[i] = lastElement;
	size--;
	return minValue;
    }
    
    public static void main(String[] args) {
	int nums = 10;
	int[] array = shuttleList(nums);
	int[] build_array = new int[nums+1];
	int start = 0;
	build_array[start++] = -1;
	for (int i: array)
	    build_array[start++] = i;
	print(build_array);
	PriorityQueue build_heap = new PriorityQueue(build_array);
	//	print(array);
	PriorityQueue q = new PriorityQueue(nums);	
	PriorityQueue qa = new PriorityQueue(nums);
	for (int i : array) {
	    q.put(i);
	    qa.put(i);
		}
	print(q.heap);
	print(qa.heap);
	print(build_heap.heap);
	print(build_heap.count);
	build_heap.delete(5);
	print(build_heap.heap);
	build_heap.increaseKey(4, 50);
	print(build_heap.heap);
	for (int i = 0; i < nums-1; i++) {
	    printnb(build_heap.pop());
	}
	   
	//	for (int i = 0; i < nums; i++) {
	//  q.pop1();
	//  qa.pop();
	//	}
	//	print("q count: " + q.count);
	///	print("qa count: " + qa.count);
       
	
	
    }
}
