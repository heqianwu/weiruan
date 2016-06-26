import java.util.Scanner;


public class Main3 {
	
	public static void main(String[] args){
		Scanner s=new Scanner(System.in);
		int T=s.nextInt();
		for(int kase=1;kase<=T;kase++){
			int a=s.nextInt();
			System.out.println("Case "+kase+": "+ch(a));
		}
	}
	
	static String ch(int a){
		if(a==1)
			return "no sulution";
		if(a==2)
			return "no sulution";
		if(a==3)
			return "4 2 1";
		if(a==4)
			return "6 3 1";
		if(a%2!=0)
			return (a+1)+" 2 1";
		else{
			
			a=a/2;
			int e=1;
			for(;(a%2)==0;){
				e++;
				a=a/2;
				
			}
			System.out.println(e);
			if(a!=1)
				return (a+1)*Math.pow(2, e)+" "+2*Math.pow(2, e)+1*Math.pow(2, e);
			else {
				return 6*Math.pow(2,e-2)+" "+3*Math.pow(2,e-2)+" "+Math.pow(2,e-2);
			}
		}
	}

}
