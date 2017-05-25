package BinGuan;


import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class ShanChuGL extends JFrame {
	JLabel jlb;
	static JTextField jtf;
	JButton jb1,jb2;
	JPanel jp1,jp2;
	
	public ShanChuGL() {
		jlb=new JLabel("房间号");
		
		jtf=new JTextField(10);
		
		jb1=new JButton("删除");
		jb2=new JButton("重置");
		
		jp1=new JPanel();
		jp2=new JPanel();
		
		jp1.add(jlb);
		jp1.add(jtf);
		jp2.add(jb1);
		jp2.add(jb2);
		
		this.add(jp1);
		this.add(jp2);
		
		this.setLayout(new GridLayout(8, 1));  
		this.setTitle("宾馆管理系统");
	    this.setSize(400,350);
	    this.setLocationRelativeTo(null);
	    this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	    this.setVisible(true);
	    
	
	    	    
	    	    jb1.addActionListener(new ActionListener() {
	            	public void actionPerformed(ActionEvent evt) {
	            		System.out.println(jtf.getText());
	            		GetSQL.querySC();
	            		new XinXiGL();
	            		
	            	}
	            });
	    	    jb2.addActionListener(new ActionListener() {
	            	public void actionPerformed(ActionEvent evt) {
	            		clear();
	            		
	            	}
	            });
	    	}
	public void clear() {
		 jtf.setText("");  
	}

	}

	

