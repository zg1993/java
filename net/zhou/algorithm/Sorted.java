//package net.zhou.algorithm;

import static net.zhou.util.Print.*;
// import java.lang.Math.random;
import java.util.*;
import java.lang.Math;


public class Sorted {
    static int counts;

    public static int[] insertSorted(int[] array) {
        int j, key;
        int i = 1;
        while(i < array.length) {
            j = i;
            key = array[j];
            while(j > 0 && key < array[j-1]) {
                array[j] = array[j-1];
                j -= 1;
            }
            array[j] = key;
            i += 1;
        }
        return array;
    }

    public static double nlogN(int n) {
        return Math.log(n)/Math.log(2)*n;
    }

    public static void merge(int[] array, int start, int end, int mid) {
        int[] temp = new int[end-start+1];
        int i = 0;
        int flag = mid;
        int start_flag = start;
        mid++;
        while(start <= flag && mid <= end) {
            if (array[start] < array[mid]) 
                temp[i++] = array[start++];
            else
                temp[i++] = array[mid++];
        }
        while(start <= flag)
            temp[i++] = array[start++];
        while(mid <= end)
            temp[i++] = array[mid++];
        for(int j : temp)
            array[start_flag++] = j;
    }

    public static void mergeSorted(int[] array, int start, int end) {
        int len = end - start + 1;
        counts++;
        if(len > 1){
            int mid = (start+end)/2;
            mergeSorted(array, start, mid);
            mergeSorted(array, mid+1, end);
            merge(array, start, end, mid);
        }
    }

    public static void quickSorted(int[] array, int start, int end) {
        counts++;
        if (end > start) {
            int k = start;
            int key = array[k];
            int i = start;
            int temp;
            for(int j=i+1; j <= end; j++){
                if(array[j] < key){
                    temp = array[j];
                    array[j] = array[i+1];
                    array[i+1] = temp;
                    i++;
                }
            }
            array[k] = array[i];
            array[i] = key;
            quickSorted(array, start, i-1);
            quickSorted(array, i+1, end);
        }
    }

    public static int[] shuttleList(int n) {
        int[] array = new int[n];
        Random rand = new Random(System.currentTimeMillis()%99 + 1);
        while(n-- > 0)
            array[n] = rand.nextInt(100);
        return array;
    }

    public static void main(String[] args) {
        int nums = Integer.parseInt(args[0]);
        int[] array = shuttleList(nums);
	Sorted2 s = new Sorted2();
	print(array);
	s.insertSorted(Arrays.copyOf(array, array.length));
	s.selectSorted(Arrays.copyOf(array, array.length));
	s.bubbleSorted(Arrays.copyOf(array, array.length));
	int[] result = new int[array.length];
	s.mergeSorted(result, Arrays.copyOf(array, array.length), 0, array.length - 1);
	print("result:");
	print(result);
	int[] a = Arrays.copyOf(array, array.length);
	s.quickSorted(a, 0, array.length - 1);
	print("quick sorted: ");
	print(a);
        // int[] a = insertSorted(array);
        // mergeSorted(array, 0, array.length-1);
	
        // quickSorted(array, 0, array.length-1);
        //print("counts: " + counts);
        //print("nlogN: " + nlogN(nums));
    }
}


class Sorted2 {
    void insertSorted(int[] array) {
	for (int i = 1; i < array.length; i++) {
	    int temp = array[i], j;
	    for (j = i; j > 0 && temp < array[j - 1]; j--)
		array[j] = array[j - 1];
	    array[j] = temp;
	}
	print(array);
    }
    
    void selectSorted(int[] array) {
	for (int i = 0; i < array.length; i++) {
	    int minValue = i;
	    for (int j = i + 1; j < array.length; j++) {
		if (array[minValue] > array[j])
		    minValue = j;
	    }
	    int temp = array[i];
	    array[i] = array[minValue];
	    array[minValue] = temp;
	}
	print(array);
    }

    void bubbleSorted(int[] array) {
	for (int i = 0; i < array.length; i++) {
	    for (int j = i; j < array.length - 1; j++) {
		if (array[j] > array[j + 1]) {
		    int temp = array[j];
		    array[j] = array[j + 1];
		    array[j + 1] = temp;
		} 
	    }
	}
    }

    void merge(int[] result, int[] array, int leftpos, int mid, int end) {
	int start = leftpos, left = leftpos, right = mid + 1;
	while (left <= mid && right <= end) {
	    if (array[left] < array[right])
		result[start++] = array[left++];
	    else
		result[start++] = array[right++];
	}
	//	System.out.printf("start: %d left: %d mid: %d\n", start, left, mid);
	while (left <= mid)
	    result[start++] = array[left++];
	while (right <= end)
	    result[start++] = array[right++];
	for (int j = leftpos; j <= end; j++)
	    array[j] = result[j];
    }
    
    void mergeSorted(int[] result, int[] array, int start, int end) {
	if (start < end) {
	    int mid = (start + end) >> 1;
	    mergeSorted(result, array, start, mid);
	    mergeSorted(result, array, mid + 1, end);
	    merge(result, array, start, mid, end);
	}
    }

    int partition(int[] array, int start, int end) {
	int base = array[start], i = start;
	for (int j = start; j <= end; j++) {
	    if (base > array[j]) {
		array[i++] = array[j];
		array[j] = array[i];
	    }
	}
	array[i] = base;
	return i;
    }
    
    void quickSorted(int[] array, int start, int end) {
	if (start < end) {
	    int location = partition(array, start, end);
	    quickSorted(array, start, location - 1);
	    quickSorted(array, location + 1, end);
	}
    }
}
