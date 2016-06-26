import java.util.Scanner;

class dian{
	double x,y;
	dian(){
		x=0;y=0;
	}
}

public class Main1 {
//	
//	static dian[] xy;
//	static double[] juli1;
//	static double[] juli2;
//	
//	public static void main(String[] args){
//		Scanner s=new Scanner(System.in);
//		int num=s.nextInt();
//		double max=1000000000;
//		double zhouchang=1000000000;
//		double a,b,c;
//		double a1,b1,c1;
//		
//		xy=new dian[num];
//		for(int i=0;i<num;i++){
//			xy[i]=new dian();
//			xy[i].x=s.nextDouble();
//			xy[i].y=s.nextDouble();
//		}
//		
//		if(num==3){
//
//			double ch;
//			double g;
//			double mian;
//				a=xy[0].y-xy[1].y;
//				b=xy[1].x-xy[0].x;
//				c=xy[0].x*xy[1].y-xy[0].y*xy[1].x;
//				ch=Math.sqrt((xy[0].x-xy[1].x)*(xy[0].x-xy[1].x)+(xy[0].y-xy[1].y)*(xy[0].y-xy[1].y));
//				g=Math.abs(a*xy[2].x+b*xy[2].y+c)/Math.sqrt(a*a+b*b);
//				mian=ch*g;
//				if(max>mian)
//					max=mian;
//				double zhou;
//				zhou=(ch+g)*2;
//				if(zhouchang>zhou)
//						zhouchang=zhou;
//			a=xy[1].y-xy[2].y;
//			b=xy[2].x-xy[1].x;
//			c=xy[1].x*xy[2].y-xy[1].y*xy[2].x;
//			ch=Math.sqrt((xy[1].x-xy[2].x)*(xy[1].x-xy[2].x)+(xy[1].y-xy[2].y)*(xy[1].y-xy[2].y));
//			g=Math.abs(a*xy[0].x+b*xy[0].y+c)/Math.sqrt(a*a+b*b);
//			mian=ch*g;
//			if(max>mian)
//				max=mian;
//			zhou=(ch+g)*2;
//			if(zhouchang>zhou)
//					zhouchang=zhou;
//			a=xy[0].y-xy[2].y;
//			b=xy[2].x-xy[0].x;
//			c=xy[0].x*xy[2].y-xy[0].y*xy[2].x;
//			ch=Math.sqrt((xy[0].x-xy[2].x)*(xy[0].x-xy[2].x)+(xy[0].y-xy[2].y)*(xy[0].y-xy[2].y));
//			g=Math.abs(a*xy[1].x+b*xy[1].y+c)/Math.sqrt(a*a+b*b);
//			mian=ch*g;
//			if(max>mian)
//				max=mian;
//			zhou=(ch+g)*2;
//			if(zhouchang>zhou)
//					zhouchang=zhou;
//		}
//		
//		
//		else for(int i=0;i<num-1;i++){
//			for(int j=i+1;j<num;j++){
//				a=xy[i].y-xy[j].y;
//				b=xy[j].x-xy[i].x;
//				c=xy[i].x*xy[j].y-xy[i].y*xy[j].x;
//				a1=xy[i].x-xy[j].x;
//				b1=xy[j].y-xy[i].y;
//				c1=xy[i].x*xy[i].x+xy[i].y*xy[i].y-xy[i].y*xy[j].y;
//				juli1=new double[num-2];
//				juli2=new double[num-2];
//				int z=0,f=0,o=0;
//
//
//				double gao=0;
//				double da=-1000000000,xiao=1000000000;
//				for(int k=i+1;k<num;k++){
//					if(k!=j){
//						int p=0;
//						juli1[p]=a*xy[k].x+b*xy[k].y+c;
//						if(juli1[p]>0){
//							z++;
//							if(juli1[p]>gao)
//							gao=juli1[p];
//						}
//						else if(juli1[p]<0){
//							f++;
//
//							if((-juli1[p])>gao)
//							gao=-juli1[p];
//						}
//						else
//							o++;
//						juli2[p]=a1*xy[k].x+b1*xy[k].y+c1;
//						if(juli2[p]>da)
//							da=juli2[p];
//						if(juli2[p]<xiao)
//							xiao=juli2[p];
//					}
//				}
//				if((z+o)==num-2||(f+o==num-2)){
//					double mianji=((da-xiao)/Math.sqrt(a1*a1+b1*b1))*gao/Math.sqrt(a*a+b*b);
//					double zhou=(((da-xiao)/Math.sqrt(a1*a1+b1*b1))*2+gao/Math.sqrt(a*a+b*b)*2);
//					if(max>mianji)
//						max=mianji;
//					if(zhouchang>zhou)
//							zhouchang=zhou;
//				}
//			}
//		}
//		System.out.println(zhouchang+"  "+max);
//	}

}
