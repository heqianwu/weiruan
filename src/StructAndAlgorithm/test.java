package StructAndAlgorithm;

public class test {
	
	public static void main(String[] a){
	System.out.println(kp());
	System.out.println(count(0));
	System.out.println(count(3));
	System.out.println(count(4));
	System.out.println(count(2));
	System.out.println(count(5));
	System.out.println(count(6));
	System.out.println(count(7));
	char[] str={'s','d','w','r'};
	int k=Math.max(3,7);
	str=str.clone();
	for(char c:str){
		char d='1';
		boolean is=(d<92);
	}
	String stt="asASD  390)( df*";
	String ko=stt.toLowerCase();
	char[] str1=stt.toCharArray();
	str1[1]='k';
	System.out.println(stt+"\n"+ko);
	}
	
	static int kp(){
		int k=3;
		return ++k;
	}
	
	static char[] oukk(String s){
		return s.toCharArray();
	}
	
	static int count(int n){
		if(n%2==1){
			if(n==1)
				return 1;
			else return 1+count(n/2);
		}
		else return count(n+1)-1;
	}
	
	int sumary(){
		return 3;
	}

}
