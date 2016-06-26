package hiho;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Scanner;
import java.util.Set;

public class hiho1067 {
	private static class Pair{ 
		public Pair(String x, String y) {
			this.x = x;
			this.y = y;
		}
		String x,y;
		String ancestor;
	}
	private static Map<String,List<String>> map = new HashMap<>();
	private static Map<String,List<String>> root = new HashMap<>();
	private static Map<String,String> res = new HashMap<>();
	private static Set<String> visted = new HashSet<>();
	private static void LCA(String u){
		List<String> list = root.get(u);
		if(list!=null){
			for(String s:list){
			LCA(s);
			untion(u,s);
			}
		}
		visted.add(u);
		List<String> list2 = map.get(u);
		if(list2==null) return;
		for(String s:list2){
			if(visted.contains(s)){
				String ancestor = find(s);
				res.put(u+s, ancestor);
			}
		}
	}
	
	private static Map<String ,String> unSet = new HashMap();
	private static String find(String s) {
		if(unSet.get(s)==null){
			unSet.put(s, s); 
			return s;
		}
		if(unSet.get(s)==s) return s;
		String str = find(unSet.get(s));
		unSet.put(s, str);
		return str;
	}

	private static void untion(String u, String s) {
		String fdu = find(u);
		String fds = find(s);
		unSet.put(fds, fdu);
		// TODO Auto-generated method stub
		
	}

	public static void main(String args[]){
/*		Scanner sc = null;
		try {
			sc = new Scanner(new FileInputStream("D:\\desktop\\test.txt"));
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}*/
		Scanner sc = new Scanner(System.in);
		List<Pair> list = new ArrayList<>();
		
		int input = sc.nextInt();
		String fatherOfAll = null;
		boolean getfather = true;
		while(input-->0){
			String a = sc.next();
			String b = sc.next();
			if(getfather){
				fatherOfAll = a;
				getfather = false;
			}
			if(root.get(a)==null) root.put(a, new ArrayList<String>());
			root.get(a).add(b);
		}
		
		
		int output = sc.nextInt();
		while(output-->0){
			list.add(new Pair(sc.next(),sc.next()));
		}
		
		for(int i=0;i<list.size();i++){
			Pair p = list.get(i);
			if(map.get(p.x)==null) map.put(p.x, new ArrayList<String>());
			map.get(p.x).add(p.y);
			if(map.get(p.y)==null) map.put(p.y, new ArrayList<String>());
			map.get(p.y).add(p.x);
		}
		LCA(fatherOfAll);
		for(int i=0;i<list.size();i++){
			Pair p =list.get(i);
			String s1= p.x+p.y;
			String s2 = p.y+p.x;
			String str = res.get(s1)==null?res.get(s2):res.get(s1);
			System.out.println(str);
		}
	}
}