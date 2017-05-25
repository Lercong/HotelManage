package BinGuan;

import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class ShouYe extends JFrame {
       JPanel jp1,jp2;
       JLabel jl1;
       JButton jb1,jb2;
       
       static Connection ct ;
       static Statement stmt;
       
       public ShouYe() {
    	   jp1=new JPanel();
    	   jp2=new JPanel();
    	   
    	   jl1=new JLabel("欢迎使用宾馆管理系统");
    	   
    	   jb1=new JButton("用户");
    	   jb2=new JButton("管理");
    	   
    	   jp1.add(jl1);
    	   jp2.add(jb1);
    	   jp2.add(jb2);
    	   
    	   this.setLayout(new GridLayout(2,1));
    	
    	   this.add(jp1);
    	   this.add(jp2);
    	   

	       jb1.addActionListener(new ActionListener() {
	        	public void actionPerformed(ActionEvent evt) {
	        		new DengLuYH();
	        		
	        	}
	        });
	       jb2.addActionListener(new ActionListener() {
	        	public void actionPerformed(ActionEvent evt) {
	        		new DengLuGL();
	        		
	        	}
	        });
    	   
       }
       public static void main(String[] arge) {

   		
   		ShouYe shouye=new ShouYe();
   		shouye.setTitle("宾馆管理系统");
   		shouye.setSize(350,300);
   		shouye.setLocationRelativeTo(null);
   		shouye.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
   		shouye.setVisible(true);
       }
   	
}

