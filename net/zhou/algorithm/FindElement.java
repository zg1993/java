import static net.zhou.util.Print.*;
import static net.zhou.util.Range.*;


public class FindElement {
    int count;
    
    int find(int[] array, int start, int end, int x) {
	count++;
	if (end < start) {
	    return -1;
	}
	int mid = (start + end) >> 1;
	if (array[mid] == x) {
	    print("return mid: " + mid);
	    return mid;
	}
	if (array[start] < array[end]) {
	    if (array[mid] < x) {
		find(array, start, mid-1, x);
	    }
	    else {
		find(array, mid+1, end, x);
	    }
	}
	else {
	    find(array, start, mid-1, x);
	    find(array, mid+1, end, x);
	}
	return -1;
    }
    
    public static void main(String[] args) {
	int length = Integer.parseInt(args[0]);
	int cut = Integer.parseInt(args[1]);
	int search = Integer.parseInt(args[2]);
	int[] a = range(length);
	int[] array = new int[length];
	int j = 0;
	for (int i = cut - 1; i < length; i++) {
	    array[j++] = a[i];
	}
	for (int i = 0; i < cut - 1; i++) {
	    array[j++] = a[i];
	}
	print(array);
	print(0>>2);
	FindElement fe = new FindElement();
	print("find result: " + fe.find(array, 0, array.length - 1, search));
	print("count: " + fe.count);
    }
}
