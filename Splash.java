package payrollSystem;

import java.awt.*;
import javax.swing.*;

public class Splash {

	public static void main(String[] args) {
		String s = "Payroll System";
		sFrame f1 = new sFrame(s);
		f1.setVisible(true);
		int i;
		int x = 1;
		for (i = 2; i <= 600; i+=4,x+=1) {
			f1.setLocation((800 - ((i+x)/2))+49, (500 - (i/2))-101);
			f1.setSize(i+x, i);
			try {
				Thread.sleep(10);
			}
			catch (Exception e) {
				System.out.println(e);
			}
		}

	
	}
	// to implement multithreading in java there is 2 ways: 1- extend thread, 2- implements runnable
	static class sFrame extends JFrame implements Runnable{
		Thread t1;
		sFrame(String s) {
			super(s);
			setLayout(new FlowLayout());
			ImageIcon c1 = new ImageIcon(ClassLoader.getSystemResource("icon/payroll_system.jpg"));
			Image i1 = c1.getImage().getScaledInstance(730, 555, Image.SCALE_DEFAULT);
			ImageIcon i2 = new ImageIcon(i1);
			
			JLabel m1 = new JLabel(i2);
			add(m1);
			t1 = new Thread(this);
			t1.start();
			
		}
		public void run() {
			try {
				Thread.sleep(7000);
				this.setVisible(false);
				Login ln = new Login();
			} 
			catch (Exception e) {
				e.printStackTrace();
			}
		}
	}

}
