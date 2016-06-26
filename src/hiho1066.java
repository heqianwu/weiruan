import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;


public class hiho1066 {
	

	static Map<String,String> map=new HashMap<String,String>();
	public static void main(String[] args){
		Scanner sc=new Scanner(System.in);
		int num=sc.nextInt();
		String a,b;
		for(int i=0;i<num;i++){
			int k=sc.nextInt();
			a=sc.next();b=sc.next();
			if(k==0){
				if(map.get(a)==null){
					map.put(a, a);
				}
				if(map.get(b)==null){
					map.put(b, b);
				}
				String ap=find_represent(a);
				String bp=find_represent(b);
				if(!ap.equals(bp))
					map.put(ap, bp);
			}
			if(k==1){
				if(find_represent(a).equals(find_represent(b))){
					System.out.println("yes");
				}
				else
					System.out.println("no");
			}
		}
	}
	
	static String find_represent(String st){
		String sk=map.get(st);
		if(st.equals(sk)){
			return st;
		}
		else{
			map.remove(st);
			map.put(st,find_represent(sk));
			return map.get(st);
		}
	}

}
