package net.zhou.algorithm;
import static net.zhou.util.Print.*;


public class StringPattern {
    String text = "abcabaabaacabaac";
    String pattern;

    StringPattern(String pattern) {
	this.pattern = pattern;
    }
    
    void bruteForce(){
	for (int i = 0; i < text.length()-pattern.length(); i++) {
	    int k = i;
	    int j = 0;
	    while (j < pattern.length()) {

       		if (text.charAt(k) == pattern.charAt(j)) {
		    j++;
		    k++;
		}
		else
		    break;
	    }
	    int p = k - j;
	    if (j == pattern.length())
		print(i + "--" + p);
	}
	
    }

    int[] getNext(String s) {
	int[] next = new int[s.length()];
        next[0] = -1;
	int i=0, j=-1;
	while (i < s.length()-1) {

	    if (j == -1 || s.charAt(i) == s.charAt(j)) {
		j++;
		i++;
		print("i: " + i + "j:" + j);
		next[i] = j;
	    }
	    else
		j = next[j];
	}
	return next;
    }

    void kmp() {
	int[] next = {-1, 0, 0, 1, 1, 2};
	print(next);
	int[] next1 = getNext(pattern);
	print(next1);
	int i=0, j=0;
	while (i < text.length()) {
	    if (j == -1 || text.charAt(i) == pattern.charAt(j)) {
		j++;
		i++;
     	    }
	    else {
		j = next[j];
	    }
	    if (j == pattern.length()) {
		print("place: " + (i-j));
		i = i-next[j-1]-1;
		j = -1;
		
	    }   
	}
	
    }
    
    static public void main(String[] args) {
	String pattern;
	if (args.length == 0)
	    pattern = "abaa";
	else
	    pattern = args[0];
	StringPattern sp = new StringPattern(pattern);
	print(sp.text);
	print(sp.pattern);
	print("brute force");
	sp.bruteForce();
	print("kpm ------------");
	sp.kmp();
	print("-----");
	
    }
}
