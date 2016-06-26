import java.util.Scanner;


public class Main {
	
	private TrieNode root=null;
	public void Build(String s){
		TrieNode p=root;
		int temp;
		for(int i=0;i<s.length();i++){
			temp=s.charAt(i)-'a';
			if(p.child[temp]==null){
				p.child[temp]=new TrieNode();
			}
			p=p.child[temp];
			p.num++;
		}
	}
	
	public int Check(String s){
		TrieNode p=root;
		int temp;
		for(int i=0;i<s.length();i++){
			temp=s.charAt(i)-'a';
			if(p.child[temp]==null)
				return 0;
			p=p.child[temp];
		}
		return p.num;
	}
	
	public static void main(String[] args){
		int n,m;
		Scanner scan=new Scanner(System.in);
		n=scan.nextInt();
		Main ks=new Main();
		ks.root=new TrieNode();
		String str;
		while(n--!=0){
			str=scan.next();
			ks.Build(str);
		}
		
		m=scan.nextInt();
		while(m--!=0){
			str=scan.next();
			System.out.println(ks.Check(str));
		}
	}

}

class TrieNode{
	TrieNode child[]=new TrieNode[26];
	int num;
	TrieNode(){
		num=0;
		for(int i=0;i<26;i++){
			child[i]=null;
		}
	}
}
