
public class TestClassEqualClass {
	
	public static void main(String[] args){
		Testc a,b;
		b=new Testc();
		a=new Testc();
		System.out.println(a.a+"  "+b.a);
		a=b;
		b.a=11;
		System.out.println(a.a+"  "+b.a);
		String c,d;
		c="asd";d="ghk";
		c=d;
		d="qertrty";
		System.out.println(c+"  "+d);
		int[] k=new int[10];
		System.out.println(k[7]);
	}

}

class Testc{
	public Testc(){
	}
	public int a=7;
}
