package BinGuan;


import java.awt.*;

import javax.swing.*;

public class JieSuanYH extends JFrame {
	JPanel jp1,jp2,jp3,jp4;
	JLabel jlb1,jlb2,jlb3,jlb4,jlb5,jlb6,jlb7,jlb8,jlb9;
	JTextField jtf11,jtf22, jtf1,jtf2,jtf3;
	String[][] data2;
	String jg;

	public JieSuanYH() {
		
		this.jtf11=YuDingYH.jtf1;
		this.jtf22=YuDingYH.jtf2;
		this.jg=GetSQL.jg;

		jlb1=new JLabel("结算报表:");
		jlb2=new JLabel("房间号:");
		jlb3=new JLabel("价格:");
		jlb4=new JLabel("时间:");
		jlb5=new JLabel("总价:");
		jlb6=new JLabel(jtf11.getText());
		jlb7=new JLabel(jg);		
		jlb8=new JLabel(jtf22.getText());

		String s=jtf22.getText();
		int a=Integer.parseInt(s);
		String s2=jg;
		int a2=Integer.parseInt(s2);
		int zh=a2*a;
		String zh2=Integer.toString(zh);
		jlb9=new JLabel(zh2);

		
		jp1=new JPanel();
		jp2=new JPanel();
		jp3=new JPanel();
		jp4=new JPanel();
		
		this.setLayout(new GridLayout(4,1));
		jp1.add(jlb1);
		jp2.add(jlb2);
		jp2.add(jlb6);
		jp2.add(jlb3);
		
		jp2.add(jlb7);
		jp3.add(jlb4);
		jp3.add(jlb8);
		jp4.add(jlb5);
		jp4.add(jlb9);
		
		this.add(jp1);
		this.add(jp2);
		this.add(jp3);
		this.add(jp4);
		
		
		
		 this.setTitle("宾馆管理系统");
	     this.setSize(400,350);
	     this.setLocationRelativeTo(null);
	     this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	     this.setVisible(true);
		 }


}