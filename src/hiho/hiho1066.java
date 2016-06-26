package hiho;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class hiho1066 {
	
	static Map<String,String> map;
	public static void main(String[] args){
		Scanner sc=new Scanner(System.in);
		int k=sc.nextInt();
		int h;
		String a,b;
		String str1,str2;
		map=new HashMap<String,String>();
		for(int i=0;i<k;i++){
			h=sc.nextInt();
			a=sc.next();
			b=sc.next();
			if(!map.containsKey(a)){
				map.put(a, a);
			}
			if(!map.containsKey(b)){
				map.put(b, b);
			}
			if(h==0){
				str1=get(a);
				str2=get(b);
				map.put(str1, str2);
			}
			else{
				str1=get(a);
				str2=get(b);
				if(str1.equals(str2)){
					System.out.println("yes");
				}
				else
					System.out.println("no");
			}
		}
	}
	
	public static String get(String str){
		for(;str!=map.get(str);){
			str=map.get(str);
		}
		return str;
	}

}
