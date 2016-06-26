import java.awt.Color;
import java.awt.Container;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JProgressBar;
import javax.swing.JWindow;
import javax.swing.Timer;
@SuppressWarnings("serial")
public class My_dialog extends JWindow implements ActionListener {
	 
	 private static int my_time = 20;
	 private JLabel back = null;
	 private JLabel txtTime = new JLabel();
	 private JProgressBar progressBar = new JProgressBar(1, my_time);
	 private Timer timer;
	 private JPanel p2 = new JPanel();
	 private int n = my_time;
	 public My_dialog(String str) {
		  Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
		  int screenWidth = screenSize.width;
		  int screenHeight = screenSize.height;
		  Dimension frameSize = this.getSize();
		  int x = (screenWidth - frameSize.width) / 2;
		  int y = (screenHeight - frameSize.height) / 2;
		  back = new JLabel(str);
		  progressBar.setString("will exit...");
		  progressBar.setStringPainted(true);
		  Container contentPane = getContentPane();
		  contentPane.setLayout(null);
		  contentPane.setSize(getMaximumSize());
		  contentPane.setBackground(Color.cyan);
		  setSize((250 + (str.length() * 4)), 100);
		  setLocation(x - ((250 + (str.length() * 4)) / 2), (y - 130 / 2));
		  toFront();
		  back.setBounds(50, 10, (300 + (str.length() * 4)) - 10, 80);
		  back.setFont(new Font("����",Font.BOLD,20));
		  p2.setBounds(10, 60, (250 + (str.length() * 4)) - 10, 80);
		  setVisible(true);
		  p2.add(txtTime);
		  p2.add(progressBar);
		  contentPane.add(back);
		  contentPane.add(p2);
		  timer = new javax.swing.Timer(100, this);
		  timer.start();
		  // System.out.println(str.length());
		  // System.out.println(getSize());
		  // System.out.println(contentPane.getSize());
		  // System.out.println(p2.getSize());
	 }
	 public void actionPerformed(ActionEvent e) {
		  if (--n > 0) {
		   progressBar.setValue(my_time - n);
		   txtTime.setText(Integer.toString(n));
		   timer.restart();
		  } else {
		   timer.stop();
		   this.dispose();
		  }
	}
	 
	 public static void main(String[] args){
		 My_dialog my=new My_dialog("okdela");
	 }
}