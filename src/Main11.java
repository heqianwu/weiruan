import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

public class Main11{

private static void convertWeekByDate(Date time) {  
    
          SimpleDateFormat sdf=new SimpleDateFormat("yyyy-MM-dd"); //����ʱ���ʽ  
          Calendar cal = Calendar.getInstance();  
          cal.setTime(time);  
         //�ж�Ҫ����������Ƿ������գ���������һ����������ģ����������⣬���㵽��һ��ȥ��  
         int dayWeek = cal.get(Calendar.DAY_OF_WEEK);//��õ�ǰ������һ�����ڵĵڼ���  
         if(1 == dayWeek) {  
             cal.add(Calendar.DAY_OF_MONTH, -1);  
         }  
         System.out.println("Ҫ��������Ϊ:"+sdf.format(cal.getTime())); //���Ҫ��������  
         cal.setFirstDayOfWeek(Calendar.MONDAY);//����һ�����ڵĵ�һ�죬���й���ϰ��һ�����ڵĵ�һ��������һ  
         int day = cal.get(Calendar.DAY_OF_WEEK);//��õ�ǰ������һ�����ڵĵڼ���
         System.out.println(day);
         System.out.println(cal.getFirstDayOfWeek());
         cal.add(Calendar.DATE, cal.getFirstDayOfWeek()-day);//���������Ĺ��򣬸���ǰ���ڼ�ȥ���ڼ���һ�����ڵ�һ��Ĳ�ֵ   
         String imptimeBegin = sdf.format(cal.getTime());  
         System.out.println("����������һ�����ڣ�"+imptimeBegin);  
         cal.add(Calendar.DATE, 6);  
         String imptimeEnd = sdf.format(cal.getTime());  
         System.out.println("�����������յ����ڣ�"+imptimeEnd);  
           
    }  

   public static void main(String[] args){
	   System.out.println(System.getProperty("user.dir"));
	   convertWeekByDate(new Date("2014/05/9"));
   }

}