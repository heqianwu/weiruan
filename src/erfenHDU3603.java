import java.util.Scanner;


public class erfenHDU3603 {
	
	static int[] a;
	
	public static void main(String[] args){
		Scanner s=new Scanner(System.in);
		int k;
		int l;
		int n,m;
		int re;
		while(s.hasNextInt()){
			k=s.nextInt();
			a=new int[k];
			for(int i=0;i<k;i++){
				a[i]=s.nextInt();
			}
			l=s.nextInt();
			for(int i=0;i<l;i++){
				n=s.nextInt();
				m=s.nextInt();
				re=1;
				if(n==m){
					System.out.println(1);
					continue;
				}
				for(int e=n-1;e<m-1;e++)
					for(int r=e+1;r<m;r++){
						boolean has=false;
						for(int p=e;p<r;p++){
							for(int g=p+1;g<=r;g++)
								if(a[p]==a[g]){
									has=true;
									break;
								}
							if(has==true)
								break;
						}
						if(has==false){
						  re=Math.max(re, r-e+1);
						}
					}
				System.out.println(re);
			}
		}
	}

}



//C++Ëã·¨
//
//#include <iostream>  
//#include<cstdio>  
//#include<cstring>  
//#include<algorithm>  
//#include<string>  
//#define N 1000005  
//using namespace std;  
//int n,vis[N],d[N][30],pre[N],len[N];  
//int search(int l,int r){  
//    int m,t=l;  
//    do{  
//        m=(l+r)/2;  
//        if(pre[m]>=t)  
//        r=m;  
//        else  
//        l=m+1;  
//    }while(l<r);  
//    return l;  
//}  
//void RMQ_init(){  
//    int i,j;  
//    for(i=1;i<=n;i++)  
//    d[i][0]=len[i];  
//    for(j=1;(1<<j)<=n;j++)  
//        for(i=1;i+(1<<j)-1<=n;i++)  
//        d[i][j]=max(d[i][j-1],d[i+(1<<(j-1))][j-1]);  
//}  
//int RMQ(int L,int R){  
//    int k=0;  
//    while((1<<(k+1))<=R-L+1)  
//    k++;  
//    return max(d[L][k],d[R-(1<<k)+1][k]);  
//}  
//int main()  
//{  
//    int m,t,i,n,x,y;  
//    while(~scanf("%d",&n)){  
//        memset(vis,0,sizeof(vis));  
//        memset(pre,-1,sizeof(pre));  
//        for(i=1;i<=n;i++){  
//            scanf("%d",&x);  
//            if(!vis[x])  
//            pre[i]=0;  
//            else  
//            pre[i]=vis[x];  
//            pre[i]=max(pre[i],pre[i-1]);  
//            vis[x]=i;  
//            len[i]=i-pre[i];  
//        }  
//        RMQ_init();  
//        scanf("%d",&m);  
//        while(m--){  
//            scanf("%d%d",&x,&y);  
//            if(x>y)  
//            swap(x,y);  
//            t=search(x,y+1);  
//            printf("%d\n",max(t-x,RMQ(t,y)));  
//        }  
//    }  
//    return 0;  
//} 