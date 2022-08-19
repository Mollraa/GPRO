package com.gpro.app;

public class test {
	String a = "abccccccccc";
	int b = 234567890;
	
	
public static void main(String[] args) {
 	
	a();	
	String a = "a";
	
	b(a); 
	System.out.println(b(a)+"aa");
	System.out.println(b("백진희")+"aa");
	// "b"
}


public static void a () {
	String a = "aaaa";
	System.out.println(a);
	String c = "abvcd";
	System.out.println(c);
}


public static String b (String a) {
	String b = "b";
	b=b+a;
	
	return b;
}


}
