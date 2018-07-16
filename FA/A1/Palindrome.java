/*
 * Code by __E18/1025_
 * check if string is a Palindrome or Not using Stack
 */

import java.util.*;
import java.util.Stack;

public class Palindrome {
	
	/*
	 * @param   String 
	 * @return  true if string is Palindrome otherwise false
	 */
	public boolean isPalindrome(String string) {
		
		Stack<Character> charStack = new Stack<Character>();
		
		int strlen = string.length();
		int mid = strlen/2;
		
		for(int i=0; i<mid; i++)
			charStack.push(string.charAt(i));
		
		int start = (strlen % 2 == 0) ? mid : mid+1;
		
		for(int i=start; i<strlen; i++) {
			if (charStack.pop() != string.charAt(i))
				return false;
		}
		
		return true;
	}
	
	public static void main(String args[]) {
		
		Scanner sc = new Scanner(System.in);
		String string = sc.next();
		
		Palindrome p = new Palindrome();
		
		if(p.isPalindrome(string))
			System.out.println("String is Palindrome !");
		else 
			System.out.println("String is NOT Palindrome !");
	}
}
