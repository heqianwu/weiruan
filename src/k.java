import java.util.ArrayList;


public class k extends fa{
	
	public static int p=100;
	static {
		System.out.println("sub static");
	}
	{
		System.out.println("sub nonstatic");
		y=1113;
	}

	public void kase(){

		System.out.println("kase2");
		ArrayList<String> k=new ArrayList<String>();
		ArrayList<String> kp=new ArrayList<String>();
		kp.add("sdsd");
		k.addAll(kp);
	}
	
	public k(int lk){
		y=1111;
		System.out.println("kas");
	}
	
	public static void main(String[] args){
		new k(1000);
	}

}

class fa{
	public int y=100;
	static {
		System.out.println("fa static");
	}
	{

		System.out.println("fa nonstatic");
		System.out.println(y);
	}
	
	public void kase(){

		System.out.println("kase1");
	}
	
	public fa(){
		kase();
		System.out.println(y);
		System.out.println("de");
	}
	
	public void test2(){
		kase();
	}
	
}
