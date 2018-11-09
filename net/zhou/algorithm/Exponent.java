package net.zhou.algorithm;

public class Exponent {
    static int counts;
    static public long exp(int a, int x) {
	counts++;
	if(x == 1)
	    return a;
	boolean even = (x%2 == 0) ? true : false;
	if(even){
        return exp(a, x/2)*exp(a, x/2); // Ω(n)
	    // long temp = exp(a, x/2);
	    // return temp*temp; // Ωlg n)
	}else{
        return exp(a, (x-1)/2)*exp(a, (x-1)/2)*a;
	    // long temp = exp(a, (x-1)/2);
	    // return temp*temp*a;
	}
    }
    
    static public void main(String[] args) {
	int base = Integer.parseInt(args[0]);
	int exponent = Integer.parseInt(args[1]);
        long result = exp(base, exponent);
        System.out.println(result);
	System.out.println(counts);
	System.out.println(java.lang.Math.log(exponent)/java.lang.Math.log(2.0));
    }
}
