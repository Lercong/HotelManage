package BinGuan;

import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JRadioButton;
import javax.swing.JTextField;

public class DengLuGL extends JFrame implements ActionListener {
	JPanel jp1,jp2,jp3,jp4;//面板
	JLabel jlb1,jlb2,jlb3;//标签
	JButton jb1,jb2,jb3;//按钮
	JTextField jtf1;//文本
	JPasswordField jpf1;//密码
	
    
    static String userword;
	static String pwd;
	static Statement stmt;
	
	public DengLuGL() {
		
		GetSQL.ConnectionSQL();
		GetSQL.queryGL();
		
		jp1=new JPanel();
		jp2=new JPanel();
		jp3=new JPanel();
		jp4=new JPanel();
		
		jlb1=new JLabel("用户名");
		jlb2=new JLabel("密码");	
		
		jb1=new JButton("重置");
		jb2=new JButton("登陆");
		jb3=new JButton("退出");
		jb1.addActionListener( this);
		jb2.addActionListener( this);
		
		jtf1=new JTextField(10);
		jpf1=new JPasswordField(10);
		
		this.setLayout(new GridLayout(4,1));
		
		jp1.add(jlb1);
		jp1.add(jtf1);
		
		jp2.add(jlb2);
		jp2.add(jpf1);
		
		jp4.add(jb1);
		jp4.add(jb2);
		jp4.add(jb3);
		
		
		this.add(jp1);
		this.add(jp2);
		this.add(jp4);
	
		    this.setTitle("宾馆管理系统");
	        this.setSize(350,300);
	        this.setLocationRelativeTo(null);
	        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	        this.setVisible(true);
	        	  
	
	
	
	//System.out.println(GetSQL.userword1+" "+GetSQL.pwd1);
}
    public void actionPerformed(ActionEvent e) {
	    		if(e.getActionCommand()=="登陆") {
	    				//GetSQL.ConnectionSQL();
	    				//GetSQL.queryGL();
	    			panding();
	    			
	    			}
	    		if(e.getActionCommand()=="重置") {
	    			clear() ;
	    			}
	    		if(e.getActionCommand()=="退出") {
	    			dispose();
	    			System.exit(0);//退出程序
	    			}
	        }
	
	
	public void panding() {
		 if(GetSQL.userword2.equals(jtf1.getText())&&GetSQL.pwd2.equals(jpf1.getText())) {
			 JOptionPane.showMessageDialog(null,"登录成功！","提示消息",JOptionPane.WARNING_MESSAGE);
			 clear();
			 XinXiGL xinxigl=new  XinXiGL();
		}
		else if(jtf1.getText().isEmpty()&&jpf1.getText().isEmpty()) {
			JOptionPane.showMessageDialog(null,"请输入用户名和密码！","提示消息",JOptionPane.WARNING_MESSAGE);  
		}
		else if(jpf1.getText().isEmpty()) {
			JOptionPane.showMessageDialog(null,"请输入密码！","提示消息",JOptionPane.WARNING_MESSAGE);  
			clear(); 
		}
		else if(jtf1.getText().isEmpty()) {
			JOptionPane.showMessageDialog(null,"请输入用户名！","提示消息",JOptionPane.WARNING_MESSAGE);  
			clear(); 
		}
		else {
			JOptionPane.showMessageDialog(null,"用户名或密码错误！","提示消息",JOptionPane.WARNING_MESSAGE);  
			clear(); 
		}
	}
	
	public void clear() {
		 jtf1.setText("");  
	        jpf1.setText("");  
	}
	
}
