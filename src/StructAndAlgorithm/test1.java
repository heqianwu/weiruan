package StructAndAlgorithm;

public class test1 {
	
	public static void main(String[] ss){
		new test1().permute("abc");
	}
	
	public void permute(String str){
		char[] c=str.toCharArray();
		permute(c,0,c.length);
	}
	
	private void permute(char[] str,int low,int high){
		if(low==high){
			return;
		}
		else{
			for(int i=0;i<high;i++){
				if(i!=low){
					str[i]^=str[low];
					str[low]^=str[i];
					str[i]^=str[low];
					System.out.println(String.copyValueOf(str));
					str[i]^=str[low];
					str[low]^=str[i];
					str[i]^=str[low];
				}
			}
		}
		permute(str,low+1,high);
	}

}
