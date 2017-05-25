package BinGuan;

import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

public class XinXiGL extends JFrame {
	JPanel jp1,jp2,jp3;
	JLabel jlb1;
	JButton jb1,jb2,jb3;
	JTable jt1;
	
	static Connection ct ;
    static Statement stmt;
    static DefaultTableModel tm;
	
	public XinXiGL() {
		jlb1=new JLabel("客房信息");
		
		jb1=new JButton("增加");
		jb2=new JButton("删除");
		jb3=new JButton("返回");
		

		
		jp1=new JPanel();
		jp2=new JPanel();
		jp3=new JPanel();
		
/*	     String[] columnNames= {"房间号","面积","类型","价格"};	
		 this.stmt=ShouYe.stmt;
	        String query="select * from fangjian";
	        String hang="select count(*) as count from fangjian";
	        ResultSet result = null;
			try {
				result = stmt.executeQuery(query);
			} catch (SQLException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
		//	String hang="select count(1) from fangjian";
		//	System.out.println(hang);
		//	ResultSet rset=null;
			int rowCount = 0;
			try {
			
				result = stmt.executeQuery(hang);
				//int rowCount = 0;
				if(result .next()) {
					rowCount=result  .getInt("count");
			}}catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			System.out.println(rowCount);
			try {
				int i=0;
				Object[][] biao=new Object[5][4];
				while(result.next()) {				
					biao[i][0]=result.getInt("房间号");
					biao[i][1]=result.getString("类型");
					biao[i][2]=result.getInt("面积");
					biao[i][3]=result.getInt("价格");
					i++;
				}
					tm=new DefaultTableModel(biao,columnNames);
					jt1=new JTable(tm);				
			}catch (SQLException e1) {
				     e1.printStackTrace();
			    }     
			           */
		GetSQL.queryFJH();
		GetSQL.queryFJ();
		
		//jt1=new JTable(tm);
		this.jt1=GetSQL.jt1;
		this.setLayout(new GridLayout(4,1));
		
		jp1.add(jlb1);
		jp2.add(jt1);
		jp3.add(jb1);
		jp3.add(jb2);
		jp3.add(jb3);
		
		this.add(jp1);
		this.add(jp2);
		add(new JScrollPane(jt1));
		this.add(jp3);       
		
		
	    this.setTitle("宾馆管理系统");
	    this.setSize(400,350);
	    this.setLocationRelativeTo(null);
	    this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	    this.setVisible(true);
	    
	    jb1.addActionListener(new ActionListener() {
        	public void actionPerformed(ActionEvent evt) {
        		new ZengJiaGL();
        		
        	}
        });
	    jb2.addActionListener(new ActionListener() {
        	public void actionPerformed(ActionEvent evt) {
        		new ShanChuGL();
        		
        	}
        });
	    jb3.addActionListener(new ActionListener() {
        	public void actionPerformed(ActionEvent evt) {
        		new DengLuGL();
        		
        	}
        });
	    
	}

}
