package StructAndAlgorithm;

import java.util.Scanner;

public class Chapter1_1 {
	
	private static int a[]=new int[100];
	private static int n,r;
	
	public static void main(String[] args){
		Scanner sc=new Scanner(System.in);
		System.out.println("请输入n和r的大小:");
		while(sc.hasNext()){
			n=sc.nextInt();
			r=sc.nextInt();
			if (r< 0 || r> n)
				System.out.println("输入有误！");
			else
				combination(n,r);
		}
	}
	
	public static void combination(int m,int k){
		for(int i=m;i>=k;i--){
			a[k]=i;
			if(k>1)
				combination(i-1,k-1);
			else{
				for(int j=r;j>1;j--)
					System.out.print(a[j]+" ");
				System.out.println(a[1]);
			}
		}
	}

}
