package net.zhou.util;


public class Print {
    public static void print(Object obj) {
        System.out.println(obj);
    }

    public static void printnb(Object obj){
        System.out.print(obj);
        System.out.print(' ');
    }

    static public void main(String[] args) {
        print(1);
    }
}