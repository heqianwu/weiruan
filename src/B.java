import java.util.Scanner;


public class B {
	
	public static void  main(String[] args){
		Scanner s=new Scanner(System.in);
		int k=s.nextInt();
		int[] num=new int[k];
		num[0]=s.nextInt();
		
		for(int i=1;i<k;i++){
			num[i]=num[i-1]+s.nextInt();
		}
		
		int[] result=new int[k];
		int max=num[k-1];
		for(int i=k-1;i>0;i--){
			if(max<num[i])
				max=num[i];
			result[i]=max-num[i-1];
		}
		result[0]=max;
		
		System.out.print(result[0]);
		for(int i=1;i<k;i++){
			System.out.print(" "+result[i]);
		}
	}

}
