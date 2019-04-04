
import static net.zhou.util.Print.*;


public class DynamicPro {
    int len;

    public void printLCS(int[][] c, char[] a, int m, int n, String str) {
	int i, j;
	int length = len - str.length();
	String str1 = str;
	for (i = 0, i < length; ) {
	    if (c[m][n] == c[m-1][n-1]) {
		String c = String.valueOf(a[m-1]);
		i++;
		str1.insert(0, c);
		m--;
		n--;
	    }
	    else {
		if (c[m-1][n] == c[m][n-1]) {
		    printLCS(c, a, m-1, n, str1);
		    printLCS(c, a, m, n-1, str1);
		    
		}
		else if (c[m-1][n] > c[m][n-1])
		    m--;
		else
		    n--;
	    }
	}

	print(str1);
    }
    
    public void printLCS(int[][] c, char[] a, int m, int n, char[] s1) {
	int i, j;
	char[] s = new char[len];
	s = s1;
	print("s.length: " + s.length);
	for (i = s.length - 1; i >= 0; ) {
	    if (c[m][n] == c[m-1][n-1]) {
		//		s1.insert(0, )
		s[i--] = a[m-1];
		m--;
		n--;
	    }
	    else {
		if (c[m-1][n] == c[m][n-1]) {
		    printLCS(c, a, m-1, n, s);
		    printLCS(c, a, m, n-1, s);
		}
		else if (c[m-1][n] > c[m][n-1]) {
		    m--;
		}
		else
		    n--;
	    }

	}
	String ss = new String(s);
	if (len == maxLen)
	    print(ss);
	
    }
    
    public void lcs(char[] a, char[] b) {
	int m = a.length, n = b.length, i, j;
	int[][] c = new int[m+1][n+1];
	for (i = 0; i <= m; i++)
	    c[i][0] = 0;
	for (i = 0; i <= n; i++)
	    c[0][i] = 0;
	for (i = 1; i <= m; i++) {
	    for (j = 1; j <= n; j++) {
		if (a[i-1] == b[j-1]) {
		    c[i][j] = c[i-1][j-1] + 1;
		}
		else if (c[i][j-1] >= c[i-1][j]) 
		    c[i][j] = c[i][j-1];
		else
		    c[i][j] = c[i-1][j];
	    }
	}
	len = c[m][n];
	print(c);
	print("maxLen: " + c[m][n]);
	char[] str = new char[len];
	printLCS(c, a, m, n, ""1);
	//	printLCS(c, a, m-1, n);
	//	printLCS(c, a, m, n-1);
    }
    
    static public void main(String[] args) {
	DynamicPro dp = new DynamicPro();
      	String a = "abcbdab";
	String b = "bdcaba";
	print(a);
	print(b);
	dp.lcs(a.toCharArray(), b.toCharArray());
	
    }
    
}
