package hiho;

import java.util.Scanner;

public class Change {
	
	public static void main(String[] args){

		Scanner in=new Scanner(System.in);
		String lines[]=new String[180];
		int line=0;
		while(in.hasNext()){
			line++;
			lines[line]=in.nextLine();
		}
		for(int i=1;i<=line;i++){
			System.out.println(chan(lines[i]));
		}
		
	}
	
	static char[] chan(String st){
		int k=0;
		boolean hasNum=false;
		for(int i=0;i<st.length();i++){
			if(st.charAt(i)==' '||st.charAt(i)=='	'){
				k++;
				if(hasNum)
					break;
			}
			else if(('0'<=st.charAt(i)&&st.charAt(i)<='9')){
				k++;
				hasNum=true;
			}
			else
				break;
		}
		char[] str=new char[st.length()-k];
		st.getChars(k, st.length(), str, 0);
		return str;
	}

}
