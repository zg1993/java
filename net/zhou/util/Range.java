package net.zhou.util;

import static net.zhou.util.Print.*;


public class Range {
    public static int[] range(int n) {
	int[] array = new int[n];
	for (int i = 0; i < n; i++) {
	    array[i] = i;
	}
	return array;
    }

    public static int[] range(int start, int end, int step) {
	int[] array = new int[end - start];
	for (int i = start, j = 0; i < end; i += step)
	    array[j++] = i;
	return array;
    }

    public static int[] range(int start, int end) {
	int[] array = new int[end - start];
	for (int i = start; i < end; i++)
	    array[i-start] = i;
	return array;
    }

    
    
    public static class TestRange {
	public static void main(String[] args) {
	    int[] array = range(10);
	    print(array);
	}
    }
}

    
