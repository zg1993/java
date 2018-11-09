package net.zhou.algorithm;

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
        // int[] a = insertSorted(array);
        // mergeSorted(array, 0, array.length-1);
        quickSorted(array, 0, array.length-1);
        for (int i : array)
            printnb(i);
        print("counts: " + counts);
        print("nlogN: " + nlogN(nums));
    }
}