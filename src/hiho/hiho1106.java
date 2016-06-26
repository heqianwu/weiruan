package hiho;

import java.util.Scanner;

public class hiho1106 {
	
	public static void main(String[] args){
		Scanner sc=new Scanner(System.in);
		int T=sc.nextInt();
		for(int h=0;h<T;h++){
			int k,n;
			k=sc.nextInt();
			n=sc.nextInt();
			while(true){
				if(k==1||k==4){
					System.out.println(0);
					break;
				}
				if(k%4==2||k%4==3){
					System.out.println(n);
					break;
				}
				else{
					k=(k+3)/4;
					n--;
				}
			}
		}
	}

}
