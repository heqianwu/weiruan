import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;


public class hiho1062 {
	
	public static void main(String[] args){
//		ArrayList<String> ahStr=new ArrayList<String>();
//		ahStr.add("asdfeq");
//		ahStr.add("feq");
//		String str=ahStr.get(1);
//		System.out.println(str);
//		str="wq";
//		ahStr.set(1, str);
//		System.out.println(ahStr.get(1));
		Map<String,String> map=new HashMap<String,String>();
		String a,b;
		ArrayList<String> aStr,bStr;
		Scanner sc=new Scanner(System.in);
		int num=sc.nextInt();
		for(int i=0;i<num;i++){
			a=sc.next();
			b=sc.next();
			map.put(b, a);
		}
		int n=sc.nextInt();
		for(int i=0;i<n;i++){
			boolean hasRelation=false;
			aStr=new ArrayList<String>();
			bStr=new ArrayList<String>();
			a=sc.next();aStr.add(a);
			b=sc.next();bStr.add(b);
			for(;map.containsKey(a);){
				a=map.get(a);
				aStr.add(a);
			}
			for(;map.containsKey(b);){
				b=map.get(b);
				bStr.add(b);
			}
			for(int j=0;j<aStr.size();j++){
				a=aStr.get(j);
				if(bStr.contains(a)){
					System.out.println(a);
					hasRelation=true;
					break;
				}
			}
			if(!hasRelation)
				System.out.println("-1");
		}
	}

}
