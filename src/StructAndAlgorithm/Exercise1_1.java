package StructAndAlgorithm;

import java.util.Scanner;

public class Exercise1_1 {
	
	public static void main(String[] args){
		Scanner sc=new Scanner(System.in);
		while(sc.hasNext()){
			int k=sc.nextInt();
			System.out.println(countK(k));
		}
	}
	
	public static int countK(int k){
		int num=0;
		while(k>=1){
			if(k%2==1)
				num++;
			k=k/2;
		}
		return num;
	}

}
