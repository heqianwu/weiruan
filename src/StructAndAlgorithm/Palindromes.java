package StructAndAlgorithm;

import java.util.Scanner;

public class Palindromes {
	
	public static void main(String[] args){
		String str;
		char[] strlist;
		Scanner sc=new Scanner(System.in);
		while(sc.hasNext()){
			str=sc.nextLine();
			str=str.replaceAll(" ", "");
			str=str.toLowerCase();
			strlist=str.toCharArray();
			if(IsPalindromes(strlist,0,strlist.length-1))
				System.out.println("It's a palindrome.");
			else
				System.out.println("It is not a palindrome.");
		}
	}
	
	public static boolean IsPalindromes(char[] str,int low,int high){
		boolean isPa=true;
		if(low>=high)
			return true;
		if(!Character.isLetterOrDigit(str[low]))
				return IsPalindromes(str,low+1,high);
		if(!Character.isLetterOrDigit(str[high]))
			return IsPalindromes(str,low,high-1);
		if(str[low]!=str[high])
			return false;
		else return IsPalindromes(str,low+1,high-1);
	}

}
