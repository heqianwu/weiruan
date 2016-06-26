import java.util.Scanner;


public class hiho1038 {
	
	public static void main(String[] args){
		int k,totalCost;
		int[][] prize=new int[501][2];
		Scanner sc=new Scanner(System.in);
		k=sc.nextInt();
		totalCost=sc.nextInt();
		int[] costMax=new int[totalCost+1];
		for(int i=1;i<=k;i++){
			prize[i][0]=sc.nextInt();
			prize[i][1]=sc.nextInt();
		}
		for(int i=1;i<=k;i++){
			for(int j=totalCost;j>=0;j--)
				if(j>=prize[i][0])
					costMax[j]=max(costMax[j],costMax[j-prize[i][0]]+prize[i][1]);
		}
		System.out.println(costMax[totalCost]);
	}
	
	static int max(int a,int b){
		return a>b?a:b;
	}

}
