package payrollSystem;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.sql.*;

public class Login extends JFrame implements ActionListener {
	JLabel l1, l2;
	JTextField t1;
	JPasswordField pf1;
	JButton b1, b2;
	
	Login(){
		super("Login Page");
		setLayout(new BorderLayout());
		
		t1 = new JTextField(10);
		pf1 = new JPasswordField(10);
		
		JLabel l = new JLabel(new ImageIcon(ClassLoader.getSystemResource("icon/defaultpic.png")));
		
		b1 = new JButton("Submit", new ImageIcon(ClassLoader.getSystemResource("icon/login.png")));
		b1.addActionListener(this);
		
		b2 = new JButton("Cancel", new ImageIcon(ClassLoader.getSystemResource("icon/cancel.png")));
		b2.addActionListener(this);
		
		JPanel p1, p2, p3, p4, p5;
		p1 = new JPanel();
		p2 = new JPanel();
		p3 = new JPanel();
		p4 = new JPanel();
		p5 = new JPanel();
		
		ImageIcon c1 = new ImageIcon("login.png");
		JLabel m1 = new JLabel(c1);
		
		p1.add(m1);
		add(l, BorderLayout.WEST);
		
		p2.add(new JLabel("User Name : "));
		p2.add(t1);
		p2.add(new JLabel("  Password : "));
		p2.add(pf1);
		add(p2, BorderLayout.CENTER);
		
		p4.add(b1);
		p4.add(b2);
		add(p4, BorderLayout.SOUTH);
		
		p5.add(new JLabel("Admin Login"));
		add(p5, BorderLayout.NORTH);
		
		setSize(400, 250);
		setLocation(550, 200);
		setVisible(true);
	}
	
	public void actionPerformed(ActionEvent ae) {
		try {
			Conn c1 = new Conn();
			String text = t1.getText();
			String pass = pf1.getText();
			
			String q = "select * from tblLogin where username = '"+text+"' and password = '"+pass+"'";
			ResultSet rs = c1.s.executeQuery(q);
			if(rs.next()) {
				new Project().setVisible(true);
				setVisible(false);
			}else {
				JOptionPane.showMessageDialog(null, "Invalid username and password");
				setVisible(false);
			}
		} 
		catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public static void main(String[] args) {
		new Login().setVisible(true);;
	}
}
