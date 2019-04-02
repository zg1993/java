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

    public static class TestRange {
	public static void main(String[] args) {
	    int[] array = range(10);
	    print(array);
	}
    }
}

    
