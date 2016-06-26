package StructAndAlgorithm;

import java.util.Scanner;

public class Exercise1_2 {
	
	static char[] strlist;
	
	public static void main(String[] args){
		String str;
		Scanner sc=new Scanner(System.in);
		Exercise1_2 ex=new Exercise1_2();
		while(sc.hasNext()){
			str=sc.nextLine();
			strlist=str.toCharArray();
			ex.permute(0,strlist.length-1);
		}
	}
	
	private void permute(int low,int high){
		if(low==high){
			System.out.print(strlist);
			System.out.println();
		}
		else{
			for(int i=low;i<=high;i++){
				swap(low,i);
				permute(low+1,high);
				swap(low,i);
			}
		}
	}
	
	private void swap(int l,int h){
		char temp=strlist[l];
		strlist[l]=strlist[h];
		strlist[h]=temp;
	}

}
