package payrollSystem;

import java.sql.*;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class NewEmployee extends JFrame implements ActionListener {
	JLabel l1, l2, l3, l4, l5, l6, l7;
	JTextField t1, t2, t3, t4, t5, t6;
	JButton b1, b2;
	Choice c1;
	
	NewEmployee(){
		super("Create New Employees");
		setSize(450, 600);
		setLocation(530, 100);
		getContentPane().setBackground(Color.white);
		
		JPanel p1 = new JPanel();
		p1.setBackground(Color.white);
		p1.setLayout(new GridLayout(8, 2, 1, 50));
		
		l1 = new JLabel("Name : ");
		t1 = new JTextField(30);
		p1.add(l1);
		p1.add(t1);
		
		c1 = new Choice();
		c1.add("Male");
		c1.add("Female");
		l2 = new JLabel("Gender : ");
		p1.add(l2);
		p1.add(c1);
		
		l3 = new JLabel("Email Id : ");
		t2 = new JTextField(20);
		p1.add(l3);
		p1.add(t2);
		
		l4 = new JLabel("Mobile No. : ");
		t3 = new JTextField(10);
		p1.add(l4);
		p1.add(t3);
		
		l5 = new JLabel("Address : ");
		t4 = new JTextField(50);
		p1.add(l5);
		p1.add(t4);
		
		l6 = new JLabel("City : ");
		t5 = new JTextField(20);
		p1.add(l6);
		p1.add(t5);
		
		l7 = new JLabel("State : ");
		t6 = new JTextField(20);
		p1.add(l7);
		p1.add(t6);
		
		b1 = new JButton("Submit");
		b1.setBackground(Color.CYAN);
		b1.setForeground(Color.black);
		b1.addActionListener(this);
		p1.add(b1);
		
		b2 = new JButton("Cancel");
		b2.setBackground(Color.CYAN);
		b2.setForeground(Color.black);
		b2.addActionListener(this);
		p1.add(b2);
		
		setLayout(new BorderLayout());
		add(new JLabel(new ImageIcon(ClassLoader.getSystemResource("icons/new_employee.png"))), "West");
		add(p1, "Center");
		
	}
	
	public void actionPerformed(ActionEvent ae) {
		if(ae.getSource() == b1) {
			String a = t1.getText();
			String b = c1.getSelectedItem();
			String c = t2.getText();
			String d = t3.getText();
			String e = t4.getText();
			String f = t5.getText();
			String g = t6.getText();
		
			String q = "insert into tblEmployee values('"+a+"', '"+b+"', '"+c+"', '"+d+"', '"+e+"', '"+f+"', '"+g+"')";
		
			try {
				Conn c1 = new Conn();
				c1.s.executeUpdate(q);
				JOptionPane.showMessageDialog(null, "Employee created");
				this.setVisible(false);
			} 
			catch (Exception e2) {
				e2.printStackTrace();
			}
		}
		if (ae.getSource() == b2) {
			this.setVisible(false);
		}
	}

	public static void main(String[] args) {
		new NewEmployee().setVisible(true);

	}

}
