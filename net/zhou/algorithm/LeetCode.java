import static net.zhou.util.Print.*;
import static net.zhou.util.Range.*;
import java.util.*;


public class LeetCode {
    public static void main(String[] args) {
	int[] array1 = {2, 2, 1};
	int[] array2 = {4, 1, 2, 1, 2};
	print(array1);
	/*	print(SingleNumber.single1(array1));
	print(array2);
	print(SingleNumber.single1(array2));
	print(SingleNumber.single1Optimized(array1));
	print(SingleNumber.single1Optimized(array2));*/
    }

}


class SingleNumber {
    public static int single1(int[] array) {
	Set<Integer> set = new HashSet<Integer>(array.length);
	for (int i : array) {
	    if (set.contains(i))
		set.remove(i);
	    else
		set.add(i);
	}
	int result = 0;
	for (Integer x : set)
	    result = x;
	return result;
    }

    // law of commutation of bitwise operation
    public static int single1Optimized(int[] array) {
	int result = 0;
	for (int i : array)
	    result ^= i;
	return result;
    }
}
