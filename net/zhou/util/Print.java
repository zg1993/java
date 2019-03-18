package net.zhou.util;


public class Print {
    
    public static void print(Object obj) {
        System.out.println(obj);
    }
    

    public static void print(int[] array) {
	for (int i : array) {
	    System.out.print(i);
	    System.out.print(' ');
	}
	System.out.println();
    }

    public static void printnb(Object obj){
        System.out.print(obj);
        System.out.print(' ');
    }

    static public void main(String[] args) {
	int[] a = {1, 2, 3};
        print(a);
    }
}
