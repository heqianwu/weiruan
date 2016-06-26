//111070024 何倩武

import java.io.IOException;
import java.math.BigInteger;


public class ALU {


	public enum Type {
		INTEGER, 
		FLOAT, 
		DECIMAL
	};
	
	public enum Operation {
		ADDITION, 
		SUBTRACTION, 
		MULTIPLICATION, 
		DIVISION,
		ADDITIONF,
		SUBTRACTIONF,
		MULTIPLICATIONF,
		DIVISIONF,
		ADDITIOND,
		SUBTRACTIOND
	};
	

	public static int ten(int a){
		int int1=0;
		int int2=1;
		for(;int1<a;int1++){int2=int2*10;}
		return int2;
	}
	

	public int power(int a){
		int int1=0;
		int int2=1;
		for(;int1<a;int1++){int2=int2*2;}
		return int2;
	}
	
	public String re(BigInteger a){
		BigInteger bigInt=new BigInteger ("2");
		return a.remainder(bigInt).toString();
	}

	
	public String Left(String a,int b){
		for(;b>0;b--){
			a=a+"0";
		}
		
		return a;
	}
	
	
	public String Mul(String a,String b){
		 int p=0;
		 String res="0";
		 String re="0";
		 for(p=a.length()-1;p>=0;p--){
			 if(a.substring(p,p+1).equals("1")){
				 res=Addition("0"+re,"0"+Left(b,a.length()-p-1),'0',a.length()+b.length());
				 re=res.substring(0,res.length()-1);
					 }			
		 }
		 
		 for(;;){
			 if(re.substring(0, 1).equals("0")){
				 re=re.substring(1, re.length());
				 }
			 else{break;}
		 }
		 
		 return re; 
			 
	 }
	
	
	public String Com(String number){
		char[] num1=number.toCharArray();
		char[] num2=new char[150];
		double a=Double.parseDouble(number);
		double nu=a/ten(num1.length);
		double n=nu;

		for(int i=0;i<num2.length;i++){
			n=n*2;
			if(n<1){num2[i]='0';}
			if(n==1){num2[i]='1';break;}
				if(n>1){n=n-1;
				num2[i]='1';
			}
		}
		
		StringBuffer sb2 = new StringBuffer();
		for(int s = 0; s<num2.length; s++){
			if(num2[s]>='0'){
		 sb2. append(num2[s]);}
		}
		
		String str = sb2.toString();
		
		return str;
	}
	
	public String Negation_Demical(String a) throws NumberFormatException, IOException{
		String result=Subtraction("01010",a.substring(a.length()-4,a.length()),5).substring(1,5);
		for(int s=a.length()-8;s>=0;s=s-4){result=Subtraction("01001",a.substring(s,s+4),5).substring(1,5)+result;}
		return result;
	}

	/**
	 * @param number： 十进制整数，如果是负数，最左边是“-”
	 * @param length： 补码表示的长度
	 * @return number的补码表示，长度为length
	 */
	public String Complement (String number, int length) throws IOException{
		String[] numList=new String[length];
		String strCom=null;
		BigInteger n=new BigInteger(number);
		BigInteger two=new BigInteger("2");
		BigInteger one=new BigInteger("1");
		int i=length-1;
		int f=0;
		
		if(n.equals(one)){
			numList[length-1]="1";
			for(int on=0;on<length-1;on++){numList[on]="0";}
			StringBuffer ob = new StringBuffer();
			for(int s = 0; s < numList.length; s++){
			 ob. append(numList[s]);}
			strCom = ob.toString();
			return strCom;
		}
		
		if(number.equals("-1")){
			for(int on=0;on<length;on++){numList[on]="1";}
			StringBuffer ob = new StringBuffer();
			for(int s = 0; s < numList.length; s++){
			 ob. append(numList[s]);}
			strCom = ob.toString();
			return strCom;
		}
	
		if(number.equals(n.add(n).toString())){
			char [] zero =new char[length];
			for(int z=0;z<length;z++){zero[z]='0';}
			
			StringBuffer zb = new StringBuffer();
			for(int s = 0; s < zero.length; s++){
			 zb. append(zero[s]);
			}
			strCom = zb.toString();
			return strCom;}
		
		if(number.substring(0,1).equals("-")){
			n= new BigInteger(number.substring(1));
		}
		
	for(;;){
		numList[i]=n.remainder(two)+"";
		n=n.divide(two);
		i--;
		if(n.equals(one)){break;}
	}
	
	numList[i]="1";
	i--;
	for(;i>=0;i--){numList[i]="0";}

	if(number.substring(0,1).equals("-")){
		for(f=0;f<length;f++){
			if(numList[f].equals("1")){numList[f]="0";}
			else{numList[f]="1";}
		}
	
		for(f=length-1;;f--){
			if (numList[f].equals("0")){
				
				numList[f]="1";
						break;
				}
		}
		if(!(f==length-1)){
		for(f=f+1;f<length;f++){numList[f]="0";}
		}
		}
		
		StringBuffer sb = new StringBuffer();
		for(int s = 0; s < numList.length; s++){
		 sb. append(numList[s]);
		}
		strCom = sb.toString();
			return strCom;	
	}
	
	
	/*
	 * @param number: 十进制浮点数，其中包含小数点，如果是负数，最左边为“-”
	 * @param slength: 尾数的长度，取值大于等于4
	 * @param elength：指数的长度，取值大于4
	 * @return number的二进制表示，长度为1+slength+elength
	 */
	public String FloatRepresentation(String number, int sLength, int eLength) throws IOException{
		int p=0;
		int ab=0;
		int expInt=0;
		String signStr="0";
		
		if(number.equals("+∞")){
			String result="0";
			for(int a=0;a<eLength;a++){result=result+"1";}
			for(int a=0;a<sLength;a++){result=result+"0";}
			return result;
		}
		
		if(number.equals("-∞")){
			String result="1";
			for(int a=0;a<eLength;a++){result=result+"1";}
			for(int a=0;a<sLength;a++){result=result+"0";}
			return result;
		}
		
		if((Double.parseDouble(number))==0.0){
			
			if(number.substring(0,1).equals("-")){
			String result="1";
			for(int a=0;a<eLength;a++){result=result+"0";}
			for(int a=0;a<sLength;a++){result=result+"0";}
			return result;}
			
			else{
				String result="0";
				for(int a=0;a<eLength;a++){result=result+"0";}
				for(int a=0;a<sLength;a++){result=result+"0";}
				return result;
							}
		}
		
		if(number.substring(0, 1).equals("-")){
			signStr="1";
			number=number.substring(1,number.length());
		}
		
		char[]num=number.toCharArray();
		for(p=0;;p++){
			if(num[p]=='.'){break;}
		}
		
		StringBuffer sb = new StringBuffer();
		for(int s = 0; s < p; s++){
		 sb. append(num[s]);
		}
		String in = sb.toString();	
		
		StringBuffer sb2 = new StringBuffer();
		for(int s = p+1; s < num.length; s++){
		 sb2. append(num[s]);
		}
		String de = sb2.toString();
		
		String inte=Complement(in,power(eLength));
		
		for(ab=0;ab<inte.length();ab++){
			if(inte.substring(ab,ab+1).equals("1")){
				break;
			}
				}
		
		String demi=Com(de);
		inte=inte.substring(ab, inte.length());
		
		if(inte.length()==0){
			
			for(ab=0;ab<demi.length();ab++){
				if(demi.substring(ab,ab+1).equals("1")){
					expInt=power(eLength-1)-2-ab;
					break;
					}
				}
			demi=demi.substring(ab+1,demi.length() );
						}
			
		else{
			expInt=inte.length()+power(eLength-1)-2;
			demi=(inte+demi).substring(1,inte.length()+demi.length());
		}
	
		String exp=Complement(expInt+"",eLength);
		String M=null;

		if(demi.length()==0){
			M="0";
			for(int ps=1;ps<sLength;ps++)
			{M=M+"0";
			}
			}
		
		else{
			M=demi;
			for(int sp=0;sp<sLength-demi.length();sp++)
		{M=M+"0";}
					}
		
		M=M.substring(0,sLength);
		String res=signStr+exp+M;
		
		return res;
		}
	

	/*
	 * @param number: 十进制浮点数，其中包含小数点，如果是负数，最左边为“-”
	 * @param length: 二进制表示的长度，为32或64
	 * @return number的二进制表示，长度为length
	 */
	public String IEEE754(String number, int length) throws IOException{
		if(length==32){
			String res=FloatRepresentation(number,23,8);
			return res;}
		if(length==64){String res=FloatRepresentation(number,52,11);
		return res;}
		
		return null;
	}
	

	public String NBCD(String number) throws IOException{
		String sign="1100";
		String num=number;
		if(number.substring(0,1).equals("-")){sign="1101";
		num=number.substring(1,number.length());}
		for(int a=0;a<num.length();a++){
			sign=sign+Complement(num.substring(a,a+1),4);
		}
		return sign;
		
	}
	
	/*
	 * @param operand: 操作数，type为INTEGER时，用补码形式的二进制表示，为FLOAT时，用原码形式的二进制表示
	 * @param type: 操作数类型
	 * @param length：type为INTEGER时，忽略该参数，为FLOAT时，包含2个元素，一次为尾数的长度和指数的长度
	 * @return 操作数的真值
	 */
	public String TrueValue (String operand,Type type,int[] length){
		char [] num = operand.toCharArray();
		
		if(type.equals(Type.INTEGER)){
		
		BigInteger tv=new BigInteger("0");
		BigInteger tw=new BigInteger("2");
		
		if(num[0]=='1'){ tv=tv.subtract(tw.pow(num.length-1));}
		for(int i=1;i<num.length;i++){
			if (num[i]=='1')
			{tv=tv.add(tw.pow(num.length-1-i));}
		}
		
		String truevalue=tv+"";
		return truevalue;
		}
		
		if(type.equals(Type.FLOAT)){
			double m=1.0;
			
		String a="0";
		String b="1";
		String c="0";
		String d="1";
		
		for(int ps=1;ps<length[0];ps++)
		{a=a+"0";
		b=b+"1";}
		for(int ps=1;ps<length[1];ps++)
		{c=c+"0";
		d=d+"1";}
			
		String exponent=operand.substring(1,1+length[1]);
		String mm=operand.substring(1+length[1],1+length[0]+length[1]);
	
		if((exponent.equals(c))&(mm.equals(a))){
				if(operand.substring(0,1).equals("1")){return "-0";}
			else{return "0";}
		}
		if(exponent.equals(d)){
			
			if(mm.equals(a))
			{
			if(operand.substring(0,1).equals("1")){return "-∞";}
			else{return "+∞";}
			}
			else{return "NaN";}
				}
	
		
		if(exponent.equals(c)){
int exp=Integer.parseInt(TrueValue("0"+operand.substring(1, 1+length[1]),Type.INTEGER,length))-power(length[1]-1)+1;
			
			for(int p=0;p<length[0];p++){
				if   ( operand.substring(p+1+length[1],p+2+length[1] ).equals("1")){
								m=m+1.0/power(p+1);
				}
			}
			
			if(operand.substring(0,1).equals("1")){return -m*Math.pow(2, exp)+"";}
					return (m-1.0)*Math.pow(2, exp)+"";
		}
			
			int exp=Integer.parseInt(TrueValue("0"+operand.substring(1, 1+length[1]),Type.INTEGER,length))-power(length[1]-1)+1;
			
			for(int p=0;p<length[0];p++){
				if   ( operand.substring(p+1+length[1],p+2+length[1] ).equals("1")){
								m=m+1.0/power(p+1);
				}
			}
			
			if(operand.substring(0,1).equals("1")){return -m*Math.pow(2, exp)+"";}
			return m*Math.pow(2, exp)+"";			
		}
		
		
		if(type.equals(Type.DECIMAL)){
			String result="-";
			for(int a=4;a<operand.length();a=a+4){
				result=result+TrueValue("0"+operand.substring(a, a+4),Type.INTEGER,length);
					}
			
			if(operand.substring(0,4).equals("1100")){result=result.substring(1, result.length());}
			result=Integer.parseInt(result)+"";
			return result;
		}
		
		return null;
		}
	

	/*
	 * 模拟取反操作
	 */
	public String Negation (String operand){
		String neg = null;
		char [] num = operand.toCharArray();
		for(int i=0;i<num.length;i++){
			if(num[i]=='1')
			{num[i]='0';}
			else{num[i]='1';}

		StringBuffer sb = new StringBuffer();
		for(int s = 0; s < num.length; s++){
		 sb. append(num[s]);
		}
		neg = sb.toString();	
	}
		return neg;
	}

	/*
	 * 模拟左移操作，通过对字符串操作实现
	 */
	public String LeftShift(String operand, int n){
		String ls = null;
		int i=0;
		char []  char1= operand.toCharArray();
		char []  char2= new char[operand.length()];
		for(i=0;i<operand.length()-n;i++){
			char2[i]=char1[i+n];
			}
		for(;i<operand.length();i++){
			char2[i]='0';
		}
		
		StringBuffer sb = new StringBuffer();
		for(int s = 0; s < char2.length; s++){
		 sb. append(char2[s]);
		}
		ls = sb.toString();
	
		return ls;
	}


	/*
	 * 模拟右移操作，通过对字符串操作实现
	 */
	public String RightShift(String operand, int n){
		String rs = null;
		int i=0;
		char []  char1= operand.toCharArray();
		char []  char2= new char[operand.length()];
		for(;i<n;i++){char2[i]=char1[0];}
		for(;i<operand.length();i++){char2[i]=char1[i-n];}
		StringBuffer sb = new StringBuffer();
		for(int s = 0; s < char2.length; s++){
		 sb. append(char2[s]);
		}
		rs = sb.toString();
	
		return rs;
	}
	

	/*
	 * 模拟全加器，对两位及进位进行加法运算
	 */
	public String FullAdder (char x, char y, char c){
		
		int x1=x-48;
		int y1=y-48;
		int c0=c-48;
		char[] num = new char[2];
		num[0]='0';
		num[1]='0';
		int s1=x1^y1^c0;
		int c1=(x1*y1)+(x1*c0)+(y1*c0);
		if(c1>1){c1=1;}
		num[0]=(char)(s1+48);
		num[1]=(char)(c1+48);
		String fa=String.valueOf(num);
		return fa;
		
	}
	
	
	public String CLAAdder (String operand1, String operand2, char c, int length){
		
		int i=0;
		String ca=null;
		char[] sn=new char[length+1];
		char [] num1 = operand1.toCharArray();
		char [] num2 = operand2.toCharArray();
		char [] op1=new char[length];
		char [] op2=new char[length];
		for(i=0;i<length-operand1.length();i++){op1[i]=num1[0];}
		for(;i<length;i++){op1[i]=num1[i-length+operand1.length()];}
		for(i=0;i<length-operand2.length();i++){op2[i]=num2[0];}
		for(;i<length;i++){op2[i]=num2[i-length+operand2.length()];}
		int c0=c-48;
		int []cn=new int[length+1];
		int []p=new int[length];
		int []g=new int[length];
		for(i=0;i<length;i++){
			p[i]=(op1[i]-48)+(op2[i]-48);
			if(p[i]>1){p[i]=1;}
			g[i]=(op1[i]-48)*(op2[i]-48);
				}
	
		for(i=length;i>=0;i--){
			if(i==length){cn[i]=c0;}
			if(i==length-1){cn[i]=g[i]+(p[i]*c0);}
			if(i==length-2){cn[i]=g[i]+(p[i]*g[i+1])+(p[i]*p[i+1]*c0);}
			if(i==length-3){cn[i]=g[i]+(p[i]*g[i+1])+(p[i]*p[i+1]*g[i+2])+(p[i]*p[i+1]*p[i+2]*c0);}
			if(i==length-4){cn[i]=g[i]+(p[i]*g[i+1])+(p[i]*p[i+1]*g[i+2])+(p[i]*p[i+1]*p[i+2]*g[i+3])+(p[i]*p[i+1]*p[i+2]*p[i+3]*c0);}
			if(i==length-5){cn[i]=g[i]+(p[i]*g[i+1])+(p[i]*p[i+1]*g[i+2])+(p[i]*p[i+1]*p[i+2]*g[i+3])+(p[i]*p[i+1]*p[i+2]*p[i+3]*g[i+4])+(p[i]*p[i+1]*p[i+2]*p[i+3]*p[i+4]*c0);}
			if(i==length-6){cn[i]=g[i]+(p[i]*g[i+1])+(p[i]*p[i+1]*g[i+2])+(p[i]*p[i+1]*p[i+2]*g[i+3])+(p[i]*p[i+1]*p[i+2]*p[i+3]*g[i+4])+(p[i]*p[i+1]*p[i+2]*p[i+3]*p[i+4]*g[i+5])+(p[i]*p[i+1]*p[i+2]*p[i+3]*p[i+4]*p[i+5]*c0);}
			if(i==length-7){cn[i]=g[i]+(p[i]*g[i+1])+(p[i]*p[i+1]*g[i+2])+(p[i]*p[i+1]*p[i+2]*g[i+3])+(p[i]*p[i+1]*p[i+2]*p[i+3]*g[i+4])+(p[i]*p[i+1]*p[i+2]*p[i+3]*p[i+4]*g[i+5])+(p[i]*p[i+1]*p[i+2]*p[i+3]*p[i+4]*p[i+5]*g[i+6])+(p[i]*p[i+1]*p[i+2]*p[i+3]*p[i+4]*p[i+5]*p[i+6]*c0);}
			if(i==length-8){cn[i]=g[i]+(p[i]*g[i+1])+(p[i]*p[i+1]*g[i+2])+(p[i]*p[i+1]*p[i+2]*g[i+3])+(p[i]*p[i+1]*p[i+2]*p[i+3]*g[i+4])+(p[i]*p[i+1]*p[i+2]*p[i+3]*p[i+4]*g[i+5])+(p[i]*p[i+1]*p[i+2]*p[i+3]*p[i+4]*p[i+5]*g[i+6])+(p[i]*p[i+1]*p[i+2]*p[i+3]*p[i+4]*p[i+5]*p[i+6]*g[i+7])+(p[i]*p[i+1]*p[i+2]*p[i+3]*p[i+4]*p[i+5]*g[i+6])+(p[i]*p[i+1]*p[i+2]*p[i+3]*p[i+4]*p[i+5]*p[i+6]*p[i+7]*c0);}
			if(cn[i]>1){cn[i]=1;}}
		
		sn[length]=(char)(cn[0]+48);
		for(i=0;i<length;i++){sn[i]=(char)  (((op1[i]-48)^(op2[i]-48)^cn[i+1])+48);}
		
		StringBuffer sb = new StringBuffer();
		for(int s = 0; s < sn.length; s++){
		 sb. append(sn[s]);
		}
		 ca= sb.toString();
	
		return ca;
		
	}
		
	
	public String Addition (String operand1, String operand2, char c, int length){
		
		int bit=operand1.length();
		if(operand2.length()>operand1.length()){bit=operand2.length();}
		if(length>bit){bit=length;}
		int ti=bit/8+1;
		int i=0;
		if(8*ti==bit+8){ti=ti-1;}
		int bits=8*ti;
		
		String ope1;
		String ope2;
		
		char [] num1 = operand1.toCharArray();
		char [] num2 = operand2.toCharArray();
		char [] op1=new char[bits];
		char [] op2=new char[bits];
		for(i=0;i<bits-operand1.length();i++){op1[i]=num1[0];}
		for(;i<bits;i++){op1[i]=num1[i-bits+operand1.length()];}
		for(i=0;i<bits-operand2.length();i++){op2[i]=num2[0];}
		for(;i<bits;i++){op2[i]=num2[i-bits+operand2.length()];}

		StringBuffer sb = new StringBuffer();
		for(i = 0; i < op1.length; i++){
		 sb. append(op1[i]);
		}
		 ope1= sb.toString();
	
			StringBuffer sa = new StringBuffer();
			for(i = 0; i < op2.length; i++){
			 sa. append(op2[i]);
			}
			 ope2= sa.toString();

		String add = null;
		char []cn=new char[ti+1];
		String []sn=new String[ti+1];
		cn[0]=c;
		for(i=0;i<ti;i++){
			String s=CLAAdder(ope1.substring(   ( bits-(8*i+8)),   ( bits-(8*i))  ) ,   ope2.substring(   ( bits-(8*i+8)),   ( bits-(8*i))  )   , cn[i],8    );
		cn[i+1]=(char)(Integer.parseInt(s.substring(8, 9))+48);
		sn[i]=s.substring(0, 8);
		
		}
		
		add=sn[ti-1];
	
		for(int p=ti-2;p>=0;p--)
		{
			add=add+sn[p];}
		
		
		int Sn=Integer.parseInt(add.substring(bits-length,bits-length+1));
		int Xn=op1[bits-length]-48;
		int Yn=op2[bits-length]-48;
		int of=(Xn*Yn*(1-Sn))+((1-Xn)*(1-Yn)*Sn);
		if(of>1){of=1;}
			
		add=add.substring(bits-length, bits);
		add=add+of;
		
		return add;
		
	}
	
	
	public String AdditionF(String operand1,String operand2,int sLength,int eLength,int gLength) throws NumberFormatException, IOException{
		
		int p=0;
		int expInt=0;
		String signStr="0";
		int[] a=new int[2];
		a[0]=sLength;
		a[1]=eLength;
		String s1=operand1.substring(0,1);
		String s2=operand2.substring(0,1);
		String xe=operand1.substring(1,1+eLength);
		String ye=operand2.substring(1,1+eLength);
		String xs=operand1.substring(1+eLength,1+eLength+sLength);
		String ys=operand2.substring(1+eLength,1+eLength+sLength);
		String x1=null;
		String y1=null;
		String sr=null;
		String exp=(Subtraction("0"+xe,"0"+ye,eLength+1)).substring(0,eLength+1);

		if(operand1.equals(operand2)){
			String as=(Addition("0"+xe,"0",'1',xe.length()+1)).substring(0,xe.length()+1);
			
			return s1+as.substring(1, as.length())+xs+as.substring(0, 1);
	}		
		
		if(exp.substring(0, 1).equals("0")){
		return AdditionF(operand2,operand1,sLength,eLength,gLength);}		
		
		if((s1.equals("0"))&(s2.equals("1"))){
			return "1"+(AdditionF("1"+operand1.substring(1, operand1.length()),"0"+operand2.substring(1, operand2.length()),sLength,eLength,gLength)).substring(1, sLength+eLength+1);
		}
			
		int s=-Integer.parseInt(TrueValue(exp,Type.INTEGER,a));
	
		String b="0";
		for(int m=0;m<s-1;m++){b=b+"0";}
		y1="1"+ys+b;
		
		if(s2.equals("1")){
			y1=Complement("-"+TrueValue(y1,Type.INTEGER,a),y1.length()+1);
		}
		
		else{y1="0"+y1;}
		
		x1="1"+xs;
		if(s1.equals("1")){
			x1=b+x1;
			x1="1"+(Addition(Negation(x1),"0",'1',x1.length())).substring(0,x1.length()-s)+b;
				}
		
		else{x1="0"+x1;}
		
		String S=(Addition(x1,y1,'0',y1.length()+1));
			
		if(S.substring(0, 1).equals("1")){
				signStr="1";
				}
		
		 S=(Addition(x1,y1,'0',y1.length()+1)).substring(1,y1.length()+1);
				
		for(p=0;p<S.length();p++){
			if(S.substring(p,p+1).equals("1")){break;}
			}
		
		expInt=S.length()-(p+1)-sLength-s;
		sr=S.substring(p+1,p+1+sLength);
		expInt=Integer.parseInt(TrueValue("0"+ye,Type.INTEGER,a))+expInt;
		String yc="0";
		if(expInt>power(eLength)){yc="1";}
			String expIntnent=Complement(expInt+"",eLength);
			return signStr+expIntnent+sr+yc;
		
	}
	

	public String AdditionD(String operand1,String operand2) throws NumberFormatException, IOException{
		if(!(operand1.substring(0,4).equals(operand2.substring(0,4)))){
			String op1=operand1.substring(4,operand1.length());
			String op2=operand2.substring(4,operand2.length());
		if(operand1.substring(0,4).equals("1101")){op1=Negation_Demical(op1);}
		if(operand2.substring(0,4).equals("1101")){op2=Negation_Demical(op2);}
		
		String a="0";
		String addresult=null;
		String result="0";
		char cn='0';
		if(operand1.length()>operand2.length()){
			for(int b=0;b<operand1.length()-operand2.length()-1;b++)
			{a=a+"0";}
			op2=a+operand2.substring(4,operand2.length());
			}
	
		if(operand1.length()<operand2.length()){
			for(int b=0;b<operand2.length()-operand1.length()-1;b++)
			{a=a+"0";}
				op1=a+operand1.substring(4,operand1.length());
			}
		
		for(int m=op1.length()-4;m>=0;m=m-4){
			addresult=Addition("00"+op1.substring(m,m+4),"00"+op2.substring(m,m+4),cn,6).substring(0,6);
			
				if((Subtraction(addresult,"01010",6).substring(0,1)).equals("0"))
			{
				cn='1';
				addresult=Addition(addresult,"0110",'0',6).substring(2,6);}
			else{
			addresult=addresult.substring(2,6);
			cn='0';
			}
		result=addresult+result;
		}
		
		result=result.substring(0, result.length()-1);
		int ul[]={1,2};
		if(cn=='0'){return NBCD(TrueValue("1101"+Negation_Demical(result),Type.DECIMAL,ul));}
		
		return NBCD(TrueValue("1100"+result,Type.DECIMAL,ul));
			}
		if(operand1.substring(0,4).equals(operand2.substring(0,4))){
		String sign=operand1.substring(0,4);
		String op1=operand1.substring(4,operand1.length());
		String op2=operand2.substring(4,operand2.length());
		String a="0";
		String addresult=null;
		String result="0";
		char cn='0';
		if(operand1.length()>operand2.length()){
			for(int b=0;b<operand1.length()-operand2.length()-1;b++)
			{a=a+"0";}
				op2=a+operand2.substring(4,operand2.length());
		}
		
		if(operand1.length()<operand2.length()){
			for(int b=0;b<operand2.length()-operand1.length()-1;b++)
			{a=a+"0";}
			op1=a+operand1.substring(4,operand1.length());
		}
		
		for(int m=op1.length()-4;m>=0;m=m-4){
			addresult=Addition("00"+op1.substring(m,m+4),"00"+op2.substring(m,m+4),cn,6).substring(0,6);
				if((Subtraction(addresult,"01010",6).substring(0,1)).equals("0"))
			{
				cn='1';
	addresult=Addition(addresult,"0110",'0',6).substring(2,6);}
			else{
			addresult=addresult.substring(2,6);
			cn='0';
			}
		result=addresult+result;
		}
		
		result=result.substring(0, result.length()-1);
				return sign+result;
			}	
		
		return null;
		}
	
	
	public String Subtraction (String operand1, String operand2, int length) throws NumberFormatException, IOException{
		int []s=new int[1];
		String a=Complement(-Integer.parseInt(TrueValue(operand2,Type.INTEGER,s))+"",operand2.length()+1);
		String sub=Addition(operand1,a,'0',length);
		return sub;
	}

	
	public String SubtractionF(String operand1, String operand2, int sLength, int
			eLength, int gLength) throws NumberFormatException, IOException{
		String fb="1"+operand2.substring(1, operand2.length());
		if(operand2.substring(0,1).equals("1")){
			fb="0"+operand2.substring(1, operand2.length());
		}
		return AdditionF(operand1,fb,sLength,eLength,gLength);
			
	}
	

	public String SubtractionD(String operand1,String operand2) throws NumberFormatException, IOException{
		String sign="1101";
		if(operand2.substring(0,4).equals("1101")){sign="1100";}
		return AdditionD(operand1,sign+operand2.substring(4,operand2.length()));
		}
	
	public String Multiplication (String operand1, String operand2, int length) throws NumberFormatException, IOException{
		char [] num2 = operand2.toCharArray();
		int i=0;
		char [] num1 = operand1.toCharArray();
		char [] op3=new char[length*2];
		char [] op2=new char[length];
		char [] op1=new char[length];
	
		for(i=0;i<length-operand1.length();i++){op1[i]=num1[0];}
		for(;i<length;i++){op1[i]=num1[i-length+operand1.length()];}

		for(i=0;i<length-operand2.length();i++){op2[i]=num2[0];}
		for(;i<length;i++){op2[i]=num2[i-length+operand2.length()];}
		 
		for(i=0;i<length;i++){op3[i]='0';}
		for(;i<length*2;i++){op3[i]=op2[i-length];}
	
		StringBuffer sb = new StringBuffer();
		for(int s = 0; s < op3.length; s++){
		 sb. append(op3[s]);
		}
		 String y= sb.toString();
		 y=y+"0";
 
	String mp = null;
	
	StringBuffer sb2 = new StringBuffer();
	for(int s = 0; s < op1.length; s++){
	 sb2. append(op2[s]);
	}
	 String ope2= sb2.toString()+"0";
	 char [] oper2 = ope2.toCharArray();
	 
		 for(i=length;i>0;i--){
			
			 if(oper2[i]-oper2[i-1]==1){
				mp=(Addition (operand1,y.substring(0,length),'0',length)).substring(0, length); 
				y=mp+y.substring(length,2*length+1);}
				
			 if(oper2[i]-oper2[i-1]==-1){
					mp=(Subtraction (y.substring(0,length),operand1,length)).substring(0,length); 
					y=mp+y.substring(length,2*length+1);
					}
					
			 y=RightShift(y,1);
		 }
		 y=y.substring(0,2*length);
		 return y;
	}
	
	
	public String MultiplicationF(String operand1, String operand2, int sLength, int
			eLength) throws NumberFormatException, IOException{
		String res="1";
		String in=null;
		String de=null;
		char ex='0';
		if(((operand1.substring(0, 1).equals("0"))&(operand2.substring(0, 1).equals("0")))|((operand1.substring(0, 1).equals("1"))&(operand2.substring(0, 1).equals("1"))))
		{
			res="0";}
		
		String a="1"+operand1.substring(1+eLength,1+eLength+sLength);
		String b="1"+operand2.substring(1+eLength,1+eLength+sLength);
		String c=Mul(a,b);
		in=c.substring(0, c.length()-2*sLength);
		
		de=c.substring( c.length()-2*sLength,c.length()-sLength);
		if(c.substring(c.length()-sLength,c.length()-sLength+1).equals("1")){
			de=(Addition("0"+de,"0",'1',sLength+1).substring(1,1+sLength+1));
				}
		if(in.length()==2){
			in=c.substring(0, c.length()-2*sLength-1);
			de=c.substring( c.length()-2*sLength-1,c.length()-sLength-1);
		ex='1';
		}

		String op1=Subtraction("0"+operand1.substring(1,1+eLength),"0"+Complement(power(eLength-1)-1+"",eLength),eLength+1).substring(0, eLength+1);
		String op2="0"+operand2.substring(1,1+eLength);
		String exp=Addition(op1,op2,ex,eLength+1).substring(0,1);
		if(exp.equals("1")){return "overflow";}
		String expInt=Addition(op1,op2,ex,eLength+1).substring(1,eLength+1);

		String result=res+expInt+de;

		return result;
	}
	
	
	public String Division (String operand1, String operand2, int length) throws NumberFormatException, IOException{
		int i=0;
		char [] num1 = operand1.toCharArray();
		String quo=null;
		char [] op1=new char[2*length];
	
		for(i=0;i<2*length-operand1.length();i++){op1[i]=num1[0];}
		for(;i<2*length;i++){op1[i]=num1[i-2*length+operand1.length()];}
		
		StringBuffer sb = new StringBuffer();
		for(int s = 0; s < op1.length; s++){
		 sb. append(op1[s]);
		}
		 String ope1= sb.toString();

	String mp = null;
	 for(i=length;i>0;i--){
			
			 if(ope1.substring(0,1).equals(operand2.substring(0, 1))){
				mp=(Subtraction (ope1.substring(0,length),operand2,length)).substring(0,length); 
				ope1=mp+ope1.substring(length,2*length);
				}
				
			 else {
					mp=(Addition (ope1.substring(0,length),operand2,'0',length)).substring(0,length); 
					ope1=mp+ope1.substring(length,2*length);
					}
					
			 if(ope1.substring(0,1).equals(operand2.substring(0, 1))){ope1=ope1+"1";}
			 else{ope1=ope1+"0";}
			 
		 ope1=ope1.substring(1,2*length+1);
		 }
	 
		 if(ope1.substring(0,1).equals(operand2.substring(0, 1))){
				mp=(Subtraction (ope1.substring(0,length),operand2,length)).substring(0,length); 
				ope1=mp+ope1.substring(length,2*length);
				}
				
			 else {
					mp=(Addition (ope1.substring(0,length),operand2,'0',length)).substring(0,length); 
					ope1=mp+ope1.substring(length,2*length);
					}
					
			 if(ope1.substring(0,1).equals(operand2.substring(0, 1))){ope1=ope1+"1";}
			 else{ope1=ope1+"0";}
		 
		 if(!ope1.substring(0,1).equals(operand1.substring(0, 1)))
		 {
			 if(ope1.substring(0,1).equals(operand2.substring(0, 1))){
					mp=(Subtraction (ope1.substring(0,length),operand2,length)).substring(0,length); 
					ope1=mp+ope1.substring(length,2*length+1);
					}
					
				 else {
						mp=(Addition (ope1.substring(0,length),operand2,'0',length)).substring(0,length); 
						ope1=mp+ope1.substring(length,2*length+1);
						}
	 }
 
		 if(operand1.substring(0,1).equals(operand2.substring(0, 1))){
				 quo=ope1.substring(length+1,2*length+1);}
		 else{
				 quo=Addition(ope1.substring(length+1,2*length+1),"0001",'0',length).substring(0,length);
			 }
	 
		return quo+ope1.substring(0,length);	
	}
	
	
	public String DivisionF(String operand1,String operand2,int sLength,int eLength) throws IOException{
		int[] a = new int[2];
		a[0]=sLength;
		a[1]=eLength;
		char s1=operand1.charAt(0);
		char s2=operand2.charAt(0);
		String signStr=null;
		String xe=operand1.substring(1,eLength+1);
		String ye=operand2.substring(1,eLength+1);
		
		String m1="1"+operand1.substring((eLength)+1,eLength+sLength+1);
		String m2="1"+operand2.substring((eLength)+1,eLength+sLength+1);
		String expIntnent=null;
		String rem=m1;
		String divisor=m2;
		String quo="";
		
		if((s1=='1'&&s2=='0')||(s1=='0'&&s2=='1'))
			{signStr="1";}
		else {signStr="0";}
		
		if(TrueValue(operand1,Type.FLOAT,a).equals("0"))
			{return "0";}
		
	 if(TrueValue(operand2,Type.FLOAT,a).equals("0"))
			{return "error";}
	
		
			int exp=Integer.parseInt(TrueValue("0"+xe,Type.INTEGER,a))-Integer.parseInt(TrueValue("0"+ye,Type.INTEGER,a))+(int)(Math.pow(2, eLength-1)-1);
			if(exp>Math.pow(2,eLength)-1)
				{return "Overflow";}
			
			 if(exp<0)
				 
				{return "Underflow";}
			 
			else{
			expIntnent=Complement((String.valueOf(exp)),eLength+1);
			expIntnent=expIntnent.substring(1);
			
			
			
			for(int i=0;i<sLength+1;i++)
				quo+="0";
			String res=rem+quo;
			
			for(int i=0;i<sLength+1;i++){
				rem=res.substring(0,sLength+1);
				quo=res.substring(sLength+1);
	
				if(rem.compareTo(divisor)>=0){
					rem=Subtraction(rem, divisor, sLength+1).substring(0,sLength+1);
					quo+="1";
				}
				
				else {quo+="0";}
				
				
				res=LeftShift(rem+quo,1).substring(0,2*sLength+2);
				
			}
			
			quo=res.substring(sLength+1);
		
			
			quo=quo.substring(quo.indexOf('1')+1);
			
			for(int k=0;k<quo.indexOf('1');k++)
				quo+="0";
			
			return signStr+expIntnent+quo;
			
			}
			
		
			
	}
	
	
	public String Calculation (String number1, String number2,Type type, Operation operation, int length[]) throws IOException {
		int[] s=new int[2];
		s[0]=length[0];
		s[1]=length[1];
			
		switch(type){
			case INTEGER:
				
				switch(operation){
					case ADDITION:
					return TrueValue(  Addition(Complement(number1,length[0]),Complement(number2,length[0]),'0',length[0]).substring(0,length[0]) ,Type.INTEGER,s )+"";

					case SUBTRACTION: 
						return TrueValue(  Subtraction(Complement(number1,length[0]),Complement(number2,length[0]),length[0]).substring(0,length[0]) ,Type.INTEGER,s )+"";
					
					case MULTIPLICATION:
						return TrueValue(  Multiplication(Complement(number1,length[0]),Complement(number2,length[0]),length[0]) ,Type.INTEGER,s )+"";
				
					case DIVISION:
						return TrueValue(  Division(Complement(number1,length[0]),Complement(number2,length[0]),length[0]).substring(0,length[0]) ,Type.INTEGER,s )+"";
				default:
					break;
				}
				break;
			
			case FLOAT:
				
				switch(operation){
				case ADDITIONF:
					return TrueValue(   AdditionF(FloatRepresentation(number1,length[0],length[1]),FloatRepresentation(number2,length[0],length[1]),length[0],length[1],length[2]).substring(0,length[0]+length[1]+1) ,Type.FLOAT, s );			
				
				case SUBTRACTIONF:
					return TrueValue(   SubtractionF(FloatRepresentation(number1,length[0],length[1]),FloatRepresentation(number2,length[0],length[1]),length[0],length[1],length[2]).substring(0,length[0]+length[1]+1) ,Type.FLOAT, s );			
					
				case MULTIPLICATIONF:
					return TrueValue(   MultiplicationF(FloatRepresentation(number1,length[0],length[1]),FloatRepresentation(number2,length[0],length[1]),length[0],length[1]).substring(0,length[0]+length[1]+1) ,Type.FLOAT, s );			
					
				case DIVISIONF:
					return TrueValue(   DivisionF(FloatRepresentation(number1,length[0],length[1]),FloatRepresentation(number2,length[0],length[1]),length[0],length[1]).substring(0,length[0]+length[1]+1) ,Type.FLOAT, s );
				default:
					break;			
					
				}
				
			case DECIMAL:
				
				switch(operation){
				case ADDITIOND:
					return TrueValue(AdditionD(NBCD(number1),NBCD(number2)),Type.DECIMAL,length);
				
				case SUBTRACTION:
					return TrueValue(SubtractionD(NBCD(number1),NBCD(number2)),Type.DECIMAL,length);
				default:
					break;
				
				}
		}
		return null;
	}


	
}	