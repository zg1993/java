package net.zhou.algorithm;


public class Fibonacii {
    static int counts;
    static public long fib(int n) {
	counts++;
        if(n == 0)
	    return 0;
	else if(n == 1)
	    return 1;
	else
	    return fib(n-1)+fib(n-2);
    }

    static public long fib1(int n) {
	int i = 2;
	long a = 0;
	long b = 1;
	long temp;
	if(n == 0)
	    return 0;
	else if (n == 1)
	    return 1;
	while(i <= n){
	    temp = a;
	    a = b;
	    b += temp;
	    i++;
	}
	return b;
    }
    
    static public void main(String[] args) {
	int base = Integer.parseInt(args[0]);
	long result = fib1(base);
	System.out.println(result);
	System.out.println(counts);
    }
}
