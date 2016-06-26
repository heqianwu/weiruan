import java.util.Scanner;


public class dongtaiguihua {
	
	static int MAXX=10005;
	static int inf=1000000001;
	static int[] dp;
	static int[] a,b;
	public static void main(String[] args){
		Scanner s=new Scanner(System.in);
		int t=s.nextInt();
		int n,m,k,i,j,limit;
		while((t--)!=0){
			limit=0;
			n=s.nextInt();
			m=s.nextInt();
			k=s.nextInt();
			dp=new int[MAXX];
			a=new int[101];
			b=new int[101];
			for(i=0;i<n;i++){
				a[i]=s.nextInt();
				b[i]=s.nextInt();
				a[i]++;
				limit+=b[i];
			}
			for(i=0;i<=limit;i++){
				dp[i]=inf;
			}
			dp[0]=0;
			for(i=0;i<n;i++){
				for(j=limit-b[i];j>=0;j--){
					if(a[i]<=k&&dp[j]!=inf){
						dp[j+b[i]]=min(dp[j+b[i]],cal(dp[j],a[i],k));
					}
				}
			}
			for(i=limit;i>=0;i--){
				if(dp[i]<=m*k){
					break;
				}
			}
			System.out.println(i);
		}
	}
	
	static int min(int a,int b){
		return a<b?a:b;
	}
	
	static int cal(int a,int b,int k){
		if(a%k==0)
			return a+b;
		int temp=a+b;
		if(temp%k==0) return temp;
		if((a/k)<(temp/k))
			return (a/k+1)*k+b;
		return temp;
	}

}
