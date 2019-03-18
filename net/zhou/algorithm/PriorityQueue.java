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
	int nums = 100000;
	int[] array = shuttleList(nums);
	//	print(array);
	PriorityQueue q = new PriorityQueue(nums);	
	PriorityQueue qa = new PriorityQueue(nums);
	for (int i : array) {
	    q.put(i);
	    qa.put(i);
		}
	
	for (int i = 0; i < nums; i++) {
	    q.pop1();
	    qa.pop();
	}
	print("q count: " + q.count);
	print("qa count: " + qa.count);
       
	
	
    }
}
