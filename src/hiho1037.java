import java.util.Scanner;



public class hiho1037 {
	
	static int[][] p=new int[1001][1001];
	static int[][] d=new int[1001][1001];
	
	public static void main(String[] args){
		Scanner sc=new Scanner(System.in);
		int k=sc.nextInt();
		for(int i=1;i<=k;i++){
			for(int j=1;j<=i;j++){
				p[i][j]=sc.nextInt();
			}
		}
		d[1][1]=p[1][1];
		for(int i=2;i<=k;i++){
			for(int j=1;j<=i;j++){
				if(j==1)
					d[i][j]=d[i-1][j]+p[i][j];
				else
					d[i][j]=max(d[i-1][j],d[i-1][j-1])+p[i][j];
			}
		}
		int ans=0;;
		for(int i=1;i<=k;i++){
			ans=ans>d[k][i]?ans:d[k][i];
		}
		System.out.println(ans);
	}
	
	static int max(int a,int b){
		if(a>b)
			return a;
		else
			return b;
	}

}
