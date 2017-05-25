package BinGuan;

import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;

public class ZengJiaGL extends JFrame{
	JLabel jlb1,jlb2,jlb3,jlb4;
	static JTextField jtf1;
	static JTextField jtf2;
	static JTextField jtf3;
	static JTextField jtf4;
	JPanel jp1,jp2,jp3,jp4,jp5;	
	JButton jb1,jb2;
	JTable jt1;
	static String a,b,c,d;
	
	public ZengJiaGL() {
	
		jlb1=new JLabel("房间号");
		jlb2=new JLabel("类型");
		jlb3=new JLabel("面积");
		jlb4=new JLabel("价格");
		
		jtf1=new JTextField(10);
		jtf2=new JTextField(10);
		jtf3=new JTextField(10);
		jtf4=new JTextField(10);
		
		jb1=new JButton("确定");
		jb2=new JButton("重置");
		
		jp1=new JPanel();
		jp2=new JPanel();
		jp3=new JPanel();
		jp4=new JPanel();
		jp5=new JPanel();
		
		jp1.add(jlb1);
		jp1.add(jtf1);
		jp2.add(jlb2);
		jp2.add(jtf2);
		jp3.add(jlb3);
		jp3.add(jtf3);
		jp4.add(jlb4);
		jp4.add(jtf4);
		jp5.add(jb1);
		jp5.add(jb2);
		
		this.add(jp1);
		this.add(jp2);
		this.add(jp3);
		this.add(jp4);
		this.add(jp5);
		
	
		this.setLayout(new GridLayout(8, 1));  
		this.setTitle("宾馆管理系统");
	    this.setSize(400,350);
	    this.setLocationRelativeTo(null);
	    this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	    this.setVisible(true);
	    
	    jb1.addActionListener(new ActionListener() {
        	public void actionPerformed(ActionEvent evt) {
        		System.out.println(jtf1.getText());
        		GetSQL.queryZJ();
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
		 jtf1.setText("");  
		 jtf2.setText(""); 
		 jtf3.setText(""); 
		 jtf4.setText(""); 

	}
}
