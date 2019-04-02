package net.zhou.util;

import java.util.Random;
import static net.zhou.util.Print.*;


public class RandomArray {
    public static int[] shuttleArray(int nums, int range) {
	int[] array = new int[nums];
	Random rand = new Random(System.currentTimeMillis() % range + 1);
	for (int i = 0; i < nums; i++)
	    array[i] = rand.nextInt(range);
	return array;
    }

    public static class TestRandomArray {
	public static void main(String[] args) {
	    print(shuttleArray(10, 1000));
	}
    }
}
