package BinGuan;

import java.awt.BorderLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;

public class ChaXunYH extends JFrame{
	JLabel jlb1;
	JButton jb1,jb2;
	static JTable jt1;
	JScrollPane jsp1;
	JPanel jp1,jp2,jp3,jp4;
	DefaultTableModel tm;
	 
public ChaXunYH() {
	jlb1=new JLabel("客房信息");
	
	jb1=new JButton("返回");
	jb2=new JButton("预定");

	jt1=new JTable(tm);

	jp1=new JPanel();
	jp2=new JPanel();
	jp3=new JPanel();
	
	GetSQL.queryFJH();
	GetSQL.queryFJ();
	
	this.jt1=GetSQL.jt1;

	this.setLayout(new GridLayout(4,1));
	jp1.add(jt1) ;
	jp2.add(jt1);
	jp3.add(jb1);
	jp3.add(jb2);

	this.add(jp1);
	this.add(jp2);
	add(new JScrollPane(jt1));
	this.add(jp3);

	 this.setTitle("宾馆管理系统");
     this.setSize(350,300);
     this.setLocationRelativeTo(null);
     this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
     this.setVisible(true);
     
     jb1.addActionListener(new ActionListener(){
     	public void actionPerformed(ActionEvent evt){
     	     new ZhuYeYH(); 
     	    }
     	    });
     jb2.addActionListener(new ActionListener(){
     	public void actionPerformed(ActionEvent evt){
     	     new YuDingYH(); 
     	    }
     	    });
}


}
