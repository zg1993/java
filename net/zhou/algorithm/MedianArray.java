import static net.zhou.util.Print.*;
import static net.zhou.util.RandomArray.*;
import static net.zhou.util.Range.*;
import static net.zhou.algorithm.Sorted.quickSorted;

public class MedianArray {
    int count;
    
    int max(int a, int b) {
	return (a > b) ? a : b;
    }

    int min(int a, int b) {
	return (a < b) ? a : b;
    }
    
    float median(int[] A, int[] B) {
	int m = A.length, n = B.length;
	float result;
	if (n < m) {
	    int[] temp = A;
	    A = B;
	    B = temp;
	}
	if (0 == n)
	    print("error");
	int start = 0, end = m, i=0, j=0;
	
	while (i < m) {
	    count++;
	    print ("count: " + count + "s:" + start + " end: " + end);
	    i = (start + end) >> 1;
	    j = ((m + n + 1) >> 1) - i;
	    print ("i:" + i + " j:" + j);
	    if (i >= m)
		break;
	    if (A[i] >= B[j-1] && A[i-1] <= B[j])
		break;
	    else if (A[i] < B[j-1])
		start = i + 1;
	    else if (A[i-1] > B[j]) 
		end = i - 1;
	}
	print("i: " + i + "j: " + j);
	int maxLeft, minRight;
	if (0 == i)
	    maxLeft = B[j - 1];
	else if (0 == j)
	    maxLeft = A[i - 1];
	else
	    maxLeft = max(A[i - 1], B[j - 1]);
	if ((m + n) % 2 == 1)
	    return new Float(maxLeft);
	if (m == i)
	    minRight = B[j];
	else if (n == j)
	    minRight = A[i];
	else
	    minRight = min(A[i], B[j]);
	return (maxLeft + minRight) / 2f;
		
    }

    public static void main(String[] args) {
	int nums = Integer.parseInt(args[0]);
	int[] a = shuttleArray(nums, 120, 100);
	int[] b = shuttleArray(nums, 230, 1000);
	quickSorted(a, 0, nums-1);
	quickSorted(b, 0, nums-1);
	print(a);
	print(b);
	MedianArray ma = new MedianArray();
	//	print(ma.median(a, b));
	print(range(0, 10));
	print(range(10, 20));
	    
	print(ma.median(range(0, 3), range(10, 20)));
    }
}
