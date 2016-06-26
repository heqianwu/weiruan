package hiho;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;


public class hiho1066Improve {
	
	static Map<String,Integer> map;
	static int[] rep;
	public static void main(String[] args){
		Scanner sc=new Scanner(System.in);
		int k=sc.nextInt();
		int h;
		int g;
		String a,b;
		int i1,i2;
		map=new HashMap<String,Integer>();
		rep=new int[10005];
		for(int i=0;i<k;i++){
			h=sc.nextInt();
			a=sc.next();
			b=sc.next();
			if(!map.containsKey(a)){
				g=map.size();
				map.put(a, g);
				rep[g]=g;
			}
			if(!map.containsKey(b)){
				g=map.size();
				map.put(b, g);
				rep[g]=g;
			}
			int e,r;
			e=map.get(a);
			r=map.get(b);
			i1=find(e);
			i2=find(r);
			if(h==0){
				if(i1!=i2)
					rep[i1]=i2;
			}
			else{
				if(i1==i2){
					System.out.println("yes");
				}
				else
					System.out.println("no");
			}
		}
	}
	
	public static int find(int k){
		if(k==rep[k]){
			return k;
		}
		else{
			rep[k]=find(rep[k]);
			return rep[k];
		}
	}

}
