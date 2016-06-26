import java.util.Scanner;
public class MaxPlalindrome{
	
	static String str;
	static String str1;
	static int nlen;
	static int[] p=new int[1000001];//p[i]Ϊ�Ե�i+1���ַ�Ϊ���ĵ���������
	
	public static void main(String[] args){
		Scanner s=new Scanner(System.in);
		while(s.hasNext()){
			str=s.next();
			nlen=Proc(str);
			Manacher(str1,nlen);
			int ans=1;
			for(int i=0;i<nlen;i++){
				ans=Math.max(ans, p[i]);
			}
			System.out.println(ans-1);
		}
	}
	
	public static int Proc(String str){
		StringBuilder sk=new StringBuilder("$");
		int len=str.length();
		for(int i=0;i<len;i++){
			sk.append('#');sk.append(str.charAt(i));
		}
		sk.append('#');str1=sk.toString();
		return len*2+1;
	}
	
	public static void Manacher(String st,int len){
		int mx=0,id=0;
		for(int i=0;i<len;i++){
			p[i]=0;
		}
		//һ�����������ҶԳƵģ���ô�ڼ����ұ߷�Χ�ڵ�ĳ���ַ���
		//��������ַ�Ϊ���ĵĻ��ĳ��ȵ�ʱ�򣬾Ϳ����������ԳƵ���ߵ��ַ��Ļ��ĳ���
		for(int i=0;i<len;i++){
			p[i]=mx>i?Math.min(p[2*id-i], mx-i):1;
			while(i+p[i]<=len&&i-p[i]>=0&&st.charAt(i+p[i])==st.charAt(i-p[i]))
				p[i]++;
			if(i+p[i]>mx){
				mx=i+p[i];
				id=i;
			}
		}
	}
}