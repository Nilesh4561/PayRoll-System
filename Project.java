package payrollSystem;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class Project extends JFrame implements ActionListener {
	
	Project(){
		setSize(700, 600);
		setLocation(400, 100);
		getContentPane().setBackground(Color.WHITE);
		
		ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("icon/payroll.jpg"));
		Image i2 = i1.getImage().getScaledInstance(500, 400, Image.SCALE_DEFAULT);
		ImageIcon i3 = new ImageIcon(i2);
		JLabel l = new JLabel(i3);
		add(l);
		
		JMenuBar mb = new JMenuBar();
		setJMenuBar(mb);
		
		JMenu m1 = new JMenu("Master");
		m1.setForeground(Color.blue);
		
		JMenuItem mi1 = new JMenuItem("New Employee");
		mi1.setForeground(Color.blue);
		mi1.setFont(new Font("monospaced", Font.PLAIN, 12));
		mi1.setMnemonic('N');
		mi1.setIcon(new ImageIcon(ClassLoader.getSystemResource("icons/New.png")));
		mi1.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_N, ActionEvent.CTRL_MASK));
		
		JMenuItem mi2 = new JMenuItem("Salary");
		mi2.setForeground(Color.blue);
		mi2.setFont(new Font("monospaced", Font.PLAIN, 12));
		mi2.setMnemonic('S');
		mi2.setIcon(new ImageIcon(ClassLoader.getSystemResource("icon/schedreport.png")));
		mi2.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_S, ActionEvent.CTRL_MASK));
		
		JMenuItem mi3 = new JMenuItem("List Employees");
		mi3.setForeground(Color.blue);
		mi3.setFont(new Font("monospaced", Font.PLAIN, 12));
		mi3.setMnemonic('L');
		mi3.setIcon(new ImageIcon(ClassLoader.getSystemResource("icon/newinvoice.png")));
		mi3.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_L, ActionEvent.CTRL_MASK));
		
		m1.add(mi1);
		m1.add(mi2);
		m1.add(mi3);
		mb.add(m1);
		
		mi1.addActionListener(this);
		mi2.addActionListener(this);
		mi3.addActionListener(this);
		
		JMenu edit = new JMenu("Update");
		edit.setForeground(Color.RED);
		
		JMenuItem s1 = new JMenuItem("Update Salary");
		s1.setForeground(Color.blue);
		s1.setFont(new Font("monospaced", Font.PLAIN, 12));
		s1.setMnemonic('U');
		s1.setIcon(new ImageIcon(ClassLoader.getSystemResource("icons/EditOpen.png")));
		s1.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_U, ActionEvent.CTRL_MASK));
		
		JMenuItem s2 = new JMenuItem("Update Employee");
		s2.setForeground(Color.blue);
		s2.setFont(new Font("monospaced", Font.PLAIN, 12));
		s2.setMnemonic('P');
		s2.setIcon(new ImageIcon(ClassLoader.getSystemResource("icon/empreport.png")));
		s2.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_P, ActionEvent.CTRL_MASK));
		
		JMenuItem s3 = new JMenuItem("Take Attendence");
		s3.setForeground(Color.blue);
		s3.setFont(new Font("monospaced", Font.PLAIN, 12));
		s3.setMnemonic('T');
		s3.setIcon(new ImageIcon(ClassLoader.getSystemResource("icon/EXPENSE.PNG")));
		s3.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_T, ActionEvent.CTRL_MASK));
		
		edit.add(s1);
		edit.add(s2);
		edit.add(s3);
		mb.add(edit);
		
		s1.addActionListener(this);
		s2.addActionListener(this);
		s3.addActionListener(this);
		
		JMenu report = new JMenu("Reports");
		report.setForeground(Color.GREEN);
		
		JMenuItem r1 = new JMenuItem("Generate Payslip");
		r1.setForeground(Color.blue);
		r1.setFont(new Font("monospaced", Font.PLAIN, 12));
		r1.setMnemonic('G');
		r1.setIcon(new ImageIcon(ClassLoader.getSystemResource("icon/payments.png")));
		r1.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_G, ActionEvent.CTRL_MASK));
		
		JMenuItem r2 = new JMenuItem("List Attendence");
		r2.setForeground(Color.blue);
		r2.setFont(new Font("monospaced", Font.PLAIN, 12));
		r2.setMnemonic('A');
		r2.setIcon(new ImageIcon(ClassLoader.getSystemResource("icon/empreport.png")));
		r2.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_A, ActionEvent.CTRL_MASK));
		
		report.add(r1);
		report.add(r2);
		mb.add(report);
		
		r1.addActionListener(this);
		r2.addActionListener(this);
		
		JMenu util = new JMenu("Utilities");
		util.setForeground(Color.MAGENTA);
		
		JMenuItem u1 = new JMenuItem("Notepad");
		u1.setForeground(Color.blue);
		u1.setFont(new Font("monospaced", Font.PLAIN, 12));
		u1.setMnemonic('O');
		u1.setIcon(new ImageIcon(ClassLoader.getSystemResource("icons/New.png")));
		u1.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_O, ActionEvent.CTRL_MASK));
		
		JMenuItem u2 = new JMenuItem("Calculator");
		u2.setForeground(Color.blue);
		u2.setFont(new Font("monospaced", Font.PLAIN, 12));
		u2.setMnemonic('C');
		u2.setIcon(new ImageIcon(ClassLoader.getSystemResource("icon/calc.png")));
		u2.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_C, ActionEvent.CTRL_MASK));
		
		JMenuItem u3 = new JMenuItem("Web Browser");
		u3.setForeground(Color.blue);
		u3.setFont(new Font("monospaced", Font.PLAIN, 12));
		u3.setMnemonic('B');
		u3.setIcon(new ImageIcon(ClassLoader.getSystemResource("icon/explorer.jpg")));
		u3.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_B, ActionEvent.CTRL_MASK));
		
		util.add(u1);
		util.add(u2);
		util.add(u3);
		mb.add(util);
		
		u1.addActionListener(this);
		u2.addActionListener(this);
		u3.addActionListener(this);
		
		JMenu exit = new JMenu("Exit");
		exit.setForeground(Color.BLACK);
		
		JMenuItem e1 = new JMenuItem("Exit");
		e1.setForeground(Color.blue);
		e1.setFont(new Font("monospaced", Font.PLAIN, 12));
		e1.setMnemonic('E');
		e1.setIcon(new ImageIcon(ClassLoader.getSystemResource("icon/exit.PNG")));
		e1.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_E, ActionEvent.CTRL_MASK));
		
		exit.add(e1);
		mb.add(exit);
	}
	
	public void actionPerformed(ActionEvent ae) {
		String msg = ae.getActionCommand();
		
		if(msg.equals("New Employee")) {
			new NewEmployee().setVisible(true);
		}
		else if(msg.equals("Salary")) {
			new Salary().setVisible(true);
		}
		else if(msg.equals("List Employees")) {
			new ListEmployee().setVisible(true);
		}
		else if(msg.equals("Update Salary")) {
			new UpdateSalary().setVisible(true);
		}
		else if(msg.equals("Update Employee")) {
			new UpdateEmployee().setVisible(true);
		}
		else if(msg.equals("Take Attendence")) {
			new TakeAttendence().setVisible(true);
		}
		else if(msg.equals("Generate Payslip")) {
			new GeneratePayslip().setVisible(true);
		}
		else if(msg.equals("List Attendence")) {
			new ListAttendence().setVisible(true);
		}
		else if(msg.equals("Notepad")) {
			try {
				Runtime.getRuntime().exec("notepad.exe");
			} 
			catch (Exception e) {
				
			}
		}
		else if(msg.equals("Calculator")) {
			try {
				Runtime.getRuntime().exec("calc.exe");
			} 
			catch (Exception e) {
				
			}
		}
		else if(msg.equals("Web Browser")) {
			try {
				Runtime.getRuntime().exec("C:\\Program Files (x86)\\Google\\Chrome\\Application\\chrome.exe");
			} 
			catch (Exception e) {
				
			}
		}
		else if(msg.equals("Exit")) {
			System.exit(0);
		}
	}
	
	public static void main(String[] args) {
		new Project().setVisible(true);

	}

}
