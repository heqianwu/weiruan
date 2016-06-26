package StructAndAlgorithm;

import java.util.Scanner;

public class TowersOfHanoi {
	
	
	
	public static void main(String[ ] args){
		System.out.println("Enter the number of disk:");
		Scanner sc=new Scanner(System.in);
		int n=sc.nextInt();
		System.out.println("The move are:");
		moveDISKs(n,'A','B','C');
	}
	
	public static void moveDISKs(int n,char a,char b,char c){
		if(n==1)
			System.out.println("move disk "+n+" from "+a+" to "+b);
		else{
			moveDISKs(n-1,a,c,b);
			System.out.println("move disk "+n+" from "+a+" to "+b);
			moveDISKs(n-1,c,b,a);
		}
	}
}
