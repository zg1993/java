import static net.zhou.util.Print.*;


public class DynamicProgram {
    int len;

    public void printLcs(int[][] c, char[] a, int m, int n) {
	int i = 0;
	while (i < len) {
	    if (c[m][n] == c[m-1][n]) {
		m--;
	    }
	    else if (c[m][n] == c[m][n-1]) {
		n--;
	    }
	    else {
		print(a[m-1]);
		m--;
		n--;
		i++;
	    }
	}
    }

    public void printAll(int[][] c, char[] a, int m, int n, String s) {
	StringBuilder sb = new StringBuilder(s);
	while (m > 0 && n > 0) {
	    if (c[m-1][n] == c[m][n-1] && c[m-1][n] == c[m][n]) {
		printAll(c, a, m-1, n, sb.toString());
		printAll(c, a, m, n-1, sb.toString());
	    }
	    if (c[m][n] == c[m][n-1]) {
		n--;
	    }
	    else if (c[m][n] == c[m-1][n]) {
		m--;
	    }
	    else {
		sb.insert(0, a[m-1]);
		m--;
		n--;
	    }
	}
	print(sb);
    }
    
    public void lcs(char[] a, char[] b) {
	int m = a.length, n = b.length, i, j;
	int[][] c = new int[m+1][n+1];
	for (i = 0; i <= m; i++)
	    c[i][0] = 0;
	for (j = 0; j <= n; j++)
	    c[0][j] = 0;
	for (i = 1; i <= m; i++) {
	    for (j = 1; j <= n; j++) {
		if (a[i-1] == b[j-1])
		    c[i][j] = c[i-1][j-1] + 1;
		else if (c[i-1][j] >= c[i][j-1])
		    c[i][j] = c[i-1][j];
		else
		    c[i][j] = c[i][j-1];
	    }
	}
	len = c[m][n];
	printLcs(c, a, m, n);
	printAll(c, a, m, n, "");
    }

    
    
    static public void main(String[] args) {
	/*	String a = "ABCBDAB";
	String b = "BDCABA";
	print(a);
	print(b);
	print(a.length());
	DynamicProgram dp = new DynamicProgram();
	dp.lcs(a.toCharArray(), b.toCharArray());*/
	//	print(Double.NEGATIVE_INFINITY);
	if (args.length < 1) {
	    print("please input length");
	    return;
	}
	int length = Integer.parseInt(args[0]);
	Cutting cut = new Cutting();
	print("length: " + length);
	//	print("price: " + cut.topUpCut(length));
	//	print("bottom price" + cut.bottomDownCut(length));
	print(cut.extendedCut(length));
	print(cut.count);
	print(cut.array);
	
    }

}


class Cutting {
    int segment;
    int count;
    int[] array;
    int[] price = {-1, 1, 5, 8, 9, 10, 17, 17, 20, 24, 30};
    int[] cut;
    {
	array = new int[price.length];
	cut = new int[price.length];
	array[0] = 0;
	for(int i = 1; i < array.length; i++)
	    array[i] = -1;
    }
        
    int max(int x, int y) {
	return x > y ? x : y;
    }

    void cutMethod(int length) {
	if (length == 0)
	    return;
	printnb(cut[length]);
	//print(length-cut[length]);
	cutMethod(length - cut[length]);
    }
    
    int extendedCut(int length) {
	int income = 0;
	for (int i = 1; i <= length; i++) {
	    for (int j = 1; j <= i; j++) {
		if (income < price[j] + array[i-j]) {
		    cut[i] = j;
		    income = price[j] + array[i-j];
		}
	    }
	    array[i] = income;
	}
	print(cut);
	cutMethod(length);
	print("--");
	return array[length];
    }
    
    int bottomDownCut(int length) {
	int income = 0;
	for (int i = 1; i <= length; i++) {
	    for (int j = 1; j <= i; j++) {
		count++;
		income = max(income, price[j] + array[i-j]);
	    }
	    array[i] = income;
	}
	return array[length];
    }
    
    int topUpCut(int length) {
	int income = 0;
	if (array[length] != -1)
	    return array[length];
	for (int i = 1; i <= length; i++) {
	    count++;
	    income = max(price[i] + topUpCut(length-i), income);
	}
	array[length] = income;
	return income;
    }
    
}
