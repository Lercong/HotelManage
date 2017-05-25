package BinGuan;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;

public class YuDingYH extends JFrame  {
	JLabel jlb1,jlb2,jlb3;
	static JTextField jtf1,jtf2;
	JButton jb1,jb2,jb3,jb4;
    JTable jt1,jt2;
	JScrollPane jsp;
	JPanel jp1,jp2,jp3,jp4, jp5,jp6;
	DefaultTableModel model;

	
	public YuDingYH() {
		
		jlb1=new JLabel("请输入房间号");
		jlb2=new JLabel("我的预定");
		jlb3=new JLabel("入住天数");
		
		jtf1=new JTextField(10);
		jtf2=new JTextField(10);
		
		jb1=new JButton("返回");
		jb2=new JButton("预定");
		jb3=new JButton("重选");
		jb4=new JButton("结算");
		
		//jb2.addActionListener(this);  
        //jb3.addActionListener(this);
		
		 String[] colnames = {"房间号","面积","类型","价格" };  
	     model = new DefaultTableModel(colnames, 3);  
	     jt2 = new JTable(model);  
	     jsp = new JScrollPane(jt2); 
		
		
		jp1=new JPanel();
		jp2=new JPanel();
		jp3=new JPanel();
		jp4=new JPanel();
		jp5=new JPanel();
		jp6=new JPanel();
		
		GetSQL.queryFJH();
		GetSQL.queryFJ();
		this.jt1=GetSQL.jt1;
		
		this.setLayout(new GridLayout(6,1));
		jp1.add(jlb1);
		jp1.add(jtf1);
		jp1.setLayout(new FlowLayout(FlowLayout.LEFT)); 
		jp6.add(jlb3);
		jp6.add(jtf2);
		jp6.setLayout(new FlowLayout(FlowLayout.LEFT));
		jp2.add(jt1);
		jp3.add(jb1);
		jp3.add(jb2);
		jp3.add(jb3);
		jp3.add(jb4);
		jp4.add(jlb2);
		jp4.setLayout(new FlowLayout(FlowLayout.LEFT));
		jp5.add(jsp);
		
		
		this.add(jp1);
		this.add(jp6);
		this.add(jp2);
		add(new JScrollPane(jt1));
		this.add(jp3);
		this.add(jp4);
		this.add(jp5);

		
		
		this.setLayout(new GridLayout(8, 1));  
		this.setTitle("宾馆管理系统");
	     this.setSize(460,550);
	     this.setLocationRelativeTo(null);
	     this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	     this.setVisible(true);
	     
	
	     jb1.addActionListener(new ActionListener(){
	      	public void actionPerformed(ActionEvent evt){
	      	     new ChaXunYH(); 
	      	    }
	      	    });
	    jb2.addActionListener(new ActionListener(){
		      	public void actionPerformed(ActionEvent evt){
		      		GetSQL.queryCZ();
		      		jt2.setValueAt(GetSQL.fjh, 0, 0);
		      		jt2.setValueAt(GetSQL.lx, 0, 1);
		      		jt2.setValueAt(GetSQL.mj, 0, 2);
		      		jt2.setValueAt(GetSQL.jg, 0, 3);
		         	}
		      	    });    
	   
	
	     jb3.addActionListener(new ActionListener(){
		      	public void actionPerformed(ActionEvent evt){
		      	  clear();
		      	}
		        });
	     
	     jb4.addActionListener(new ActionListener(){
		      	public void actionPerformed(ActionEvent evt){
		      		new JieSuanYH();
		      	}
		        });
	     } 
	
	public void clear() {
	    	 jtf1.setText(" ");
	      
	     }
	}
	    