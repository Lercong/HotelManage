package BinGuan;

import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTable;

public class ZhuYeYH extends JFrame {
	JPanel jp1,jp2,jp3;
	JLabel jlb1;
	JButton jb1,jb2,jb3;
	static JTable jt1;
	

	
	public ZhuYeYH() {
		
		jp1=new JPanel();
		jp2=new JPanel();
		jp3=new JPanel();
		
		jlb1=new JLabel("��ӭʹ�ñ��ݹ���ϵͳ");
		
		jb1=new JButton ("��ѯ");
        jb2=new JButton ("Ԥ��");     
        jb3=new JButton ("����");
      	
        this.setLayout(new GridLayout(3,1));
        
        jp1.add(jlb1);
        jp2.add(jb1);
        jp2.add(jb2);
        jp2.add(jb3);
        
        this.add(jp1);
        this.add(jp2);
        this.add(jp3);
        
        this.setTitle("���ݹ���ϵͳ");
        this.setSize(350,300);
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
        	     new YuDingYH(); 
        	    }
        	    });
       jb3.addActionListener(new ActionListener(){
       	public void actionPerformed(ActionEvent evt){
       	    // new JieSuan(); 
       	    }
       	    });
    
	}
}
