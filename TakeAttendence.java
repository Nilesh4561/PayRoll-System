package payrollSystem;

import java.sql.*;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class TakeAttendence extends JFrame implements ActionListener {
	JLabel l1, l2;
	JButton b1, b2;
	Choice c1, fh, sh;
	
	TakeAttendence(){
		super("Take Employee's Attendence");
		setLayout(new GridLayout(4, 2, 10, 50));
		c1 = new Choice();
        try{
            Conn c = new Conn();
            ResultSet rs = c.s.executeQuery("select * from tblEmployee");
            while(rs.next()){
                c1.add(rs.getString("id"));    
            }
      
      
       }catch(Exception e){ }
       
        add(new JLabel("Select EmpNo. : "));
        add(c1);
      
        l1 = new JLabel("First Half : ");
        fh = new Choice();
        fh.add("Present");
        fh.add("Absent");
        fh.add("Leave");
       
        add(l1);
        add(fh);
        
        l2 = new JLabel("Second Half : ");
        sh = new Choice();
        sh.add("Present");
        sh.add("Absent");
        sh.add("Leave");
       
        add(l2);
        add(sh);
       
        b1 = new JButton("Submit");
        b1.setBackground(Color.cyan);
        b1.setForeground(Color.WHITE);
        
        b2 = new JButton("Cancel");
        b2.setBackground(Color.cyan);
        b2.setForeground(Color.WHITE);
        
        add(b1);
        add(b2);
        
        b1.addActionListener(this);
        b2.addActionListener(this);
        
        getContentPane().setBackground(Color.WHITE);
        
        setVisible(true);
        setSize(300,300);
        setLocation(500,200);
	}
	
	public void actionPerformed(ActionEvent ae) {
		 	String f = fh.getSelectedItem();
	        String s = sh.getSelectedItem();
	        String dt = new java.util.Date().toString();
	        String id = c1.getSelectedItem();
	        String qry = "insert into tblAttendence values("+id+", '"+dt+"', '"+f+"', '"+s+"')";
	       
	        try{
	            Conn c1 = new Conn();
	            c1.s.executeUpdate(qry);
	            JOptionPane.showMessageDialog(null,"Attendence confirmed");
	            this.setVisible(false);
	        }catch(Exception ee){
	            ee.printStackTrace();
	        }
	}

	public static void main(String[] args) {
		new TakeAttendence().setVisible(true);

	}

}
