package payrollSystem;

import java.sql.*;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class UpdateSalary extends JFrame implements ActionListener, ItemListener {
	JLabel l1, l2, l3, l4, l5, l6;
	JTextField t1, t2, t3, t4, t5, t6;
	JButton b1, b2;
	Choice c1;
	
	UpdateSalary(){
		super("Update Employee's Salary");
		setLayout(null);
		c1 = new Choice();
		try {
			Conn c = new Conn();
			ResultSet rs = c.s.executeQuery("select * from tblSalary");
			while (rs.next()) {
				c1.add(rs.getString("id"));
			}
		} 
		catch (Exception e) {
			// TODO: handle exception
		}
		
		JLabel emp = new JLabel("Select EmpNo.");
        emp.setBounds(20,20,100,20);
        add(emp);
        
        c1.setBounds(120,20,200,20);
        add(c1);
        
        l1 = new JLabel("HRA : ");
        t1 = new JTextField(15);
        
        l1.setBounds(20,60,100,20);
        t1.setBounds(120,60,200,20);
        add(l1);
        add(t1);
       
        l2 = new JLabel("DA : ");
        t2 = new JTextField(15);
        
        l2.setBounds(20,100,100,20);
        t2.setBounds(120,100,200,20);
        add(l2);
        add(t2);
       
        l3 = new JLabel("MED. : ");
        t3 = new JTextField(15);
        
        l3.setBounds(20,140,100,20);
        t3.setBounds(120,140,200,20);
        add(l3);
        add(t3);
       
        l4 = new JLabel("PF : ");
        t4 = new JTextField(15);
        
        l4.setBounds(20,180,100,20);
        t4.setBounds(120,180,200,20);
        add(l4);
        add(t4); 
       
        l5 = new JLabel("Basic_Salary : ");
        t5 = new JTextField(15);
        
        l5.setBounds(20,220,100,20);
        t5.setBounds(120,220,200,20);
        add(l5);
        add(t5);
       
        b1 =new JButton("Update");
        b1.setBackground(Color.CYAN);
        b1.setForeground(Color.WHITE);
        
        b2 = new JButton("Delete");
        b2.setBackground(Color.cyan);
        b2.setForeground(Color.WHITE);
        
        b1.setBounds(40,280,100,20);
        b2.setBounds(200,280,100,20);
        add(b1);
        add(b2);
       
        b1.addActionListener(this);
        b2.addActionListener(this);
        c1.addItemListener(this);
        
        getContentPane().setBackground(Color.WHITE);
       
        setVisible(true);
        setSize(400,450);
        setLocation(500,200);
	}
	
		public void actionPerformed(ActionEvent ae) {
			if(ae.getSource()==b1){
				String hra = t1.getText();
				String id = c1.getSelectedItem();
				String da = t2.getText();
				String med = t3.getText();
				String pf = t4.getText();
				String basic = t5.getText();
      
				String qry = "update tblSalary set hra="+hra+", da="+da+", med="+med+", pf="+pf+", basic_salary="+basic+"  where id="+c1.getSelectedItem();
       
				try{
					Conn c1 = new Conn();
					c1.s.executeUpdate(qry);
					JOptionPane.showMessageDialog(null,"Salary Updated");
					this.setVisible(false);
				}catch(Exception ee){
					ee.printStackTrace();
				}
			}
        
			if(ae.getSource()==b2){
            
				try{
					Conn c = new Conn();
					c.s.executeUpdate("delete from tblSalary where id="+c1.getSelectedItem());
					JOptionPane.showMessageDialog(null,"Salary Deleted");
					this.setVisible(false);
				}catch(Exception ee){
					ee.printStackTrace();
				}
			}
		}
	
		public void itemStateChanged(ItemEvent ie) {
			try{
				Conn c = new Conn();
	            ResultSet rs = c.s.executeQuery("select * from tblSalary where id="+c1.getSelectedItem());
	            if(rs.next()){
	                t1.setText(rs.getString("hra"));
	                t2.setText(rs.getString("da"));
	                t3.setText(rs.getString("med"));
	                t4.setText(rs.getString("pf"));
	                t5.setText(rs.getString("basic_salary"));
	         
	            }
	       }catch(Exception ee){
	           ee.printStackTrace();
	       }
		}
	
	public static void main(String[] args) {
		new UpdateSalary().setVisible(true);
	}

}
