package StructAndAlgorithm;

import java.util.Scanner;

public class MaxSupSum {
	
	public static void main(String[] args){
		Scanner sc=new Scanner(System.in);
		System.out.println("ÇëÊäÈëÊı×é£º");
		while(sc.hasNext()){
			String str=sc.nextLine();
			String[] strlist=str.split(" ");
			int len=strlist.length;
			int[] a=new int[len];
			int[] maxSum=new int[len];//
			for(int i=0;i<len;i++){
				a[i]=Integer.parseInt(strlist[i]);
			}
			maxSum[0]=a[0];
			int ans=maxSum[0]>0?maxSum[0]:0;
			for(int i=1;i<len;i++){
				maxSum[i]=maxSum[i-1]<0?a[i]:(a[i]+maxSum[i-1]);
				if(ans<maxSum[i])
					ans=maxSum[i];
			}
			System.out.println(ans);
		}
	}

}
