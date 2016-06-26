import java.util.ArrayList;
import java.util.Scanner;

class Zuobiao{
	double x,y;
	public Zuobiao(double a,double b){
		x=a;
		y=b;
	}
}

public class Main7{
	
	static int k;
	static ArrayList<Zuobiao> list;
	static double zuizuo;
	static double zuiyou;
	static double zuixiao;
	static double jieguo;
	public static void main(String[] args){
		Scanner s=new Scanner(System.in);
		int T=s.nextInt();
		for(int i=1;i<=T;i++){
			k=s.nextInt();
			list=new ArrayList<Zuobiao>();
			zuizuo=1000000001;
			zuiyou=-1000000001;
			for(int j=0;j<k;j++){
				double a,b;
				a=s.nextDouble();
				b=s.nextDouble();
				Zuobiao zuo=new Zuobiao(a,b);
				if(a<zuizuo)
					zuizuo=a;
				if(a>zuiyou)
					zuiyou=a;
				list.add(zuo);
			}
			double jiange=(zuiyou-zuizuo)/100;
			zuixiao=changdu(zuizuo);
			jieguo=zuizuo;
			double z=zuizuo,y=zuiyou;
			for(;zuiyou-zuizuo>0.000001;){
			  for(int p=0;p<=100;p++){
				 if(changdu(zuizuo+jiange*p)<=zuixiao){
					jieguo=zuizuo+jiange*(p);
					zuixiao=changdu(zuizuo+jiange*p);
					if(p!=0) z=jieguo-jiange;
					else z=jieguo;
					if(p!=100) y=jieguo+jiange;
					else y=jieguo;
				 }
			   }
				zuizuo=z;
				zuiyou=y;
				jiange=(zuiyou-zuizuo)/100;
			}
			Double dou = jieguo;
			dou = (double)Math.round(dou*1000000)/1000000;
			System.out.println("Case "+i+": "+dou);
		}
	}
	
	static double changdu(double mid){
		double changdu=0;
		for(int i=0;i<list.size();i++){
			changdu+=Math.sqrt(Math.pow(list.get(i).x-mid,2)+Math.pow(list.get(i).y, 2));
		}

		return changdu;
		
	}
	
}