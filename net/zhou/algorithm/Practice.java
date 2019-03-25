import static net.zhou.util.Print.*;


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
    
    static public void main(String[] args) {
	int[] a = {1, 3, 2, 5, 0, 10, -100};
	quickSort(a, 0, a.length-1);
	print(a);
    }
}
