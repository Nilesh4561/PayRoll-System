package payrollSystem;

import java.sql.*;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class Salary extends JFrame implements ActionListener {
	JLabel l1, l2, l3, l4, l5;
	JTextField t1, t2, t3, t4, t5;
	JButton b1, b2;
	Choice c1;
	
	Salary() {
		super("Set Salary");
		setSize(400, 600);
		setLocation(530, 100);
		setLayout(new GridLayout(8, 2, 10, 50));
		
		c1 = new Choice();
		try {
			Conn c = new Conn();
			ResultSet rs = c.s.executeQuery("select * from tblEmployee");
			while (rs.next()) {
				c1.add(rs.getString("id"));
			}
		} 
		catch (Exception e) {
			// TODO: handle exception
		}
		
		add(new JLabel("Select Employee Number: "));
		add(c1);
		
		l1 = new JLabel("HRA (House Rent Allowance) : ");
		t1 = new JTextField(15);
		add(l1);
		add(t1);
		
		l2 = new JLabel("DA (Dearness Allowance) : ");
		t2 = new JTextField(15);
		add(l2);
		add(t2);
		
		l3 = new JLabel("Medical Allowance : ");
		t3 = new JTextField(15);
		add(l3);
		add(t3);
		
		l4 = new JLabel("PF (Provident Fund) : ");
		t4 = new JTextField(15);
		add(l4);
		add(t4);
		
		l5 = new JLabel("Basic Salary : ");
		t5 = new JTextField(15);
		add(l5);
		add(t5);
		
		b1 = new JButton("Submit");
		b1.setBackground(Color.CYAN);
		b1.setForeground(Color.WHITE);
		add(b1);
		b1.addActionListener(this);
		
		b2 = new JButton("Cancel");
		b2.setBackground(Color.CYAN);
		b2.setForeground(Color.white);
		add(b2);
		b2.addActionListener(this);
	}
	
	public void actionPerformed(ActionEvent ae) {
		String id = c1.getSelectedItem();
		String hra = t1.getText();
		String da = t2.getText();
		String med = t3.getText();
		String pf = t4.getText();
		String bs = t5.getText();
		
		String q = "insert into tblSalary values("+id+", "+hra+", "+da+", "+med+", "+pf+", "+bs+")";
		try {
			Conn c = new Conn();
			c.s.executeLargeUpdate(q);
			JOptionPane.showMessageDialog(null, "salary marked");
			this.setVisible(false);
		} 
		catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public static void main(String[] args) {
		new Salary().setVisible(true);

	}

}
