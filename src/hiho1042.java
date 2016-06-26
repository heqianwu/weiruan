import java.util.Scanner;


public class hiho1042 {
	
	public static void main(String[] args){
		int n,m,L;
		int L4;
		int l,r,t,b;
		int lc,rc,tc,bc;
		int ans=0;
		int tempans=0;
		Scanner sc=new Scanner(System.in);
		n=sc.nextInt();
		m=sc.nextInt();
		L=sc.nextInt();
		L4=L/4;
		l=sc.nextInt();
		r=sc.nextInt();
		if(l<r){
			l=r+l;
			r=l-r;
			l=l-r;
		}
		lc=l;
		rc=m-r;
		t=sc.nextInt();
		b=sc.nextInt();
		if(t<b){
			t=b+t;
			b=t-b;
			t=t-b;
		}
		tc=t;
		bc=n-b;
		int ls,rs,ts,bs;
		int ll,rl,tl,bl;
		ls=lc*n;rs=rc*n;ts=tc*m;bs=bc*m;
		ll=n*2+lc*2;
		rl=n*2+rc*2;
		tl=m*2+tc*2;
		bl=m*2+bc*2;
		{
		}
		{
			
		}
	}

}
