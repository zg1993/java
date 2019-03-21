package net.zhou.algorithm;
import static net.zhou.util.Print.*;


public class StringPattern {
    String text = "abcabaabcabac";
    String pattern;

    StringPattern(String pattern) {
	this.pattern = pattern;
    }
    
    void bruteForce(){
	for (int i = 0; i < text.length(); i++) {
	    int k = i;
	    int j = 0;
	    while (j < pattern.length()) {
		if (text.charAt(k++) == pattern.charAt(j++)) {
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
	print("-----");
	
    }
}
