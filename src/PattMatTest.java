import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class PattMatTest {
	
	public static void main(String[] args){
		String patternStr="(0?[1-9]|1[0-2]):([0-5]\\d)([a|p]/\\\\m)";
		String matherStr="����ʱ����11:15a/\\m�������Ӫҵʱ����ÿ���8:30a\\m��5:30p/m���ḧ����";
		Pattern pa=Pattern.compile(patternStr);
		Matcher ma=pa.matcher(matherStr);
		StringBuffer sb=new StringBuffer();
		int count=0;
		System.out.println(Integer.SIZE);
		while(ma.find()){
			StringBuffer temp=new StringBuffer();
			if(ma.group(3).equals("am")){
				temp.append(ma.group(1));
				temp.append(":");temp.getClass();
				temp.append(ma.group(2));
			}
			else{
				int time=Integer.parseInt(ma.group(1));
				time=time+12;
				temp.append(time+":"+ma.group(2));
			}
			ma.appendReplacement(sb, temp.toString());
			System.out.println(ma.group(0));
		}
		ma.appendTail(sb);
		System.out.println("������ǣ�");
		System.out.println(sb.toString());
	}

}
