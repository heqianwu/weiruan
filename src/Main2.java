import java.math.BigInteger;
import java.util.ArrayList;
import java.util.Scanner;


public class Main2 {
	
	static int a,b;
	static ArrayList<Integer> list1;
	static ArrayList<Integer> list2;
	static int num;
	public static void main(String[] args){
		Scanner s=new Scanner(System.in);
		int T;
		T=s.nextInt();
		for(int kase=1;kase<=T;kase++){
			a=s.nextInt();
			b=s.nextInt();
			num=0;
			for(int h=0;h<(1<<a);h++){
				num+=check(h);
			}
			System.out.println("Case "+kase+": "+num%b);
		}
	}
	
	static int check(int h){
		int re=0;
		ArrayList<Integer> d=new ArrayList<Integer>();
		list1=new ArrayList<Integer>();
		list2=new ArrayList<Integer>();
		for(int c=0;c<a;c++){
    		if((h & (1<<c))!=0) list1.add(c+1);
    		else d.add(c+1);
    	}
		int p=d.size();
		for(int j=0;j<(1<<p);j++){
			list2=new ArrayList<Integer>();
			for(int m=0;m<p;m++){
				if((j & (1<<m))!=0) ;
				else list2.add(d.get(m));
			}
			 boolean axiao=true;
			 axiao=cha(list1,list2);
			 if(axiao)
				re++;
		}
		return re;
	}
	
	static boolean cha(ArrayList<Integer> f,ArrayList<Integer> s){
		BigInteger big1;
		BigInteger big2;
		System.out.println(f.size()+" "+s.size());
		if(f.size()!=0){
			big1=new BigInteger(""+f.get(0));
			for(int j=1;j<f.size();j++){
			   big1=big1.xor(new BigInteger(""+f.get(j)));
		    }
		}
		else
			big1=new BigInteger("0");
		if(s.size()!=0){
			big2=new BigInteger(""+s.get(0));
			for(int j=1;j<s.size();j++){
			  big2=big2.xor(new BigInteger(""+s.get(j)));
		   }
		}
		else 
			big2=new BigInteger("0");
		if(big1.compareTo(big2)!=1)
			return true;
		else return false;
	}

}
