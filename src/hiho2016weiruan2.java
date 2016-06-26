import java.util.Scanner;


public class hiho2016weiruan2 {

	static int[] numList;
	
	public static void main(String[] args){
		int T,N,M;
		int[][] yingshe;
		int[] intial;
		Scanner sc=new Scanner(System.in);
		T=sc.nextInt();
		for(int i=0;i<T;i++){
			N=sc.nextInt();
			M=sc.nextInt();
			intial=new int[M];
			numList=new int[N];
			yingshe=new int[N][5];
			for(int j=0;j<M;j++){
				intial[j]=sc.nextInt();
			}
			for(int j=0;j<N;j++){
				yingshe[j][0]=sc.nextInt();
				yingshe[j][1]=sc.nextInt();
				for(int k=0;k<yingshe[j][1];k++){
					yingshe[j][2+k]=sc.nextInt();
				}
			}
			for(int j=0;j<M;j++){
				ansNum(intial[j],yingshe,N);
			}
			for(int j=0;j<N-1;j++){
				System.out.print(numList[j]+" ");
			}
			System.out.println(numList[N-1]);
		}
	}
	
	public static int ansNum(int signal,int[][] yingshe,int num ){
		for(int k=0;k<num;k++){
			if(yingshe[k][0]==signal){
				numList[k]++;
				for(int h=0;h<yingshe[k][1];h++){
					ansNum(yingshe[k][2+h],yingshe,num);
				}
			}
		}
		return 0;
	}
	
}
