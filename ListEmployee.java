package payrollSystem;

import java.sql.*;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class ListEmployee extends JFrame implements ActionListener {
	JTable j1;
	JButton b1;
	String h[] = {"Emp Id", "Name", "Gender", "Email Id", "Phone No", "Address", "City", "State"};
	String d[][] = new String[20][20];
	int i = 0, j = 0;
	
	ListEmployee(){
		super("View Employees");
		setSize(1000, 400);
		setLocation(230, 200);
		
		try {
			String q = "select * from tblEmployee";
			Conn c = new Conn();
			ResultSet rs = c.s.executeQuery(q);
			while (rs.next()) {
				d[i][j++] = rs.getString("id");
				d[i][j++] = rs.getString("name");
				d[i][j++] = rs.getString("gender");
				d[i][j++] = rs.getString("email");
				d[i][j++] = rs.getString("phone");
				d[i][j++] = rs.getString("address");
				d[i][j++] = rs.getString("city");
				d[i][j++] = rs.getString("state");
				i++;
				j=0;
			}
			j1 = new JTable(d, h);
		} 
		catch (Exception e) {
			// TODO: handle exception
		}
		
		b1 = new JButton("Print");
		add(b1, "South");
		JScrollPane s1 = new JScrollPane(j1);
		add(s1);
		
		b1.addActionListener(this);
	}

	public void actionPerformed(ActionEvent ae) {
		try {
			j1.print();
		} 
		catch (Exception e) {
			// TODO: handle exception
		}
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
