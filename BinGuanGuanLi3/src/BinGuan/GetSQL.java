package BinGuan;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;

import com.mysql.jdbc.PreparedStatement;

public class GetSQL {

	static JTable jt1;
	
	static String userword1;
	static String userword2;
	static String pwd1;
	static String pwd2;
	
	 static Connection ct ;
     static Statement stmt;
     static DefaultTableModel tm;
     
     static int rowCount;
     
    static JTextField jtf1;
 	static JTextField jtf2;
 	static JTextField jtf3;
 	static JTextField jtf4;
 	static JTextField jtf5;
 	static JTextField jtf6;
 	
 	static String fjh;
 	static String lx;
 	static String mj;
 	static String jg;

     
     //�������ݿ�
	public static void ConnectionSQL() {
		try {
 		      Class.forName("com.mysql.jdbc.Driver");     //����MYSQL JDBC��������   
 		      //Class.forName("org.gjt.mm.mysql.Driver");
 		     System.out.println("Success loading Mysql Driver!");
 		    }
 		    catch (Exception e) {
 		      System.out.print("Error loading Mysql Driver!");
 		      e.printStackTrace();
 		    }
 	 try {
	     ct = DriverManager.getConnection( "jdbc:mysql://localhost:3306/binguan","root","root");
	           //����URLΪ   jdbc:mysql//��������ַ/���ݿ���  �������2�������ֱ��ǵ�½�û���������

	      System.out.println("Success connect Mysql server!");
	       stmt = ct.createStatement();
	}
	    catch (Exception e) {
	        System.out.print("get data error!");
	        e.printStackTrace();
	      }
	}
	
	//�û������ѯ
	public static void queryYH() {
		  String query="select * from yonghu";
	        ResultSet result = null;
			try {
				result = stmt.executeQuery(query);
			} catch (SQLException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
	        try {
				while(result.next())
				{
					userword1=result.getString("�û���");
					pwd1=result.getString("����");
					System.out.println(userword1+" "+pwd1);
					
				}
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
	}
	
	//���������ѯ
	public static void queryGL() {
	    String query="select * from guanli";
        ResultSet result = null;
		try {
			result = stmt.executeQuery(query);
		} catch (SQLException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
        try {
			while(result.next())
			{
				userword2=result.getString("�û���");
				pwd2=result.getString("����");
				System.out.println(userword2+" "+pwd2);
				
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}  
	 
    //������Ϣ����
    public static void queryFJH() {
    	String query="select count(*) from fangjian";
    	ResultSet result=null;
    	try {
    		result=stmt.executeQuery(query);
    		 if(result.next())
    		    {
    			 rowCount=result.getInt(1);

    		    }
    	}catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		System.out.println(rowCount);
    	
    }
        //������Ϣ
        public static void queryFJ() {
        	String[] columnNames= {"�����","���","����","�۸�"};	
        	String query="select * from fangjian";
        	ResultSet result=null;
        	try {
        		result=stmt.executeQuery(query);
        	}catch(SQLException e1) {
        		e1.printStackTrace();
        	}
        	try {
        		int i=0;
        		Object[][] biao=new Object[rowCount][4];
        		while(result.next()) {
        			biao[i][0]=result.getString("�����");
					biao[i][1]=result.getString("����");
					biao[i][2]=result.getString("���");
					biao[i][3]=result.getString("�۸�");
					i++;
				}
        		tm=new DefaultTableModel(biao,columnNames);
        		jt1=new JTable(tm);
        		}catch(SQLException e1) {
				     e1.printStackTrace();
			    }
        	}
        
        //������Ϣ����
        public static void queryZJ() {
        	
        	jtf1=ZengJiaGL.jtf1;
        	jtf2=ZengJiaGL.jtf2;
        	jtf3=ZengJiaGL.jtf3;
        	jtf4=ZengJiaGL.jtf4;

        	  java.sql.PreparedStatement pst = null;         	  
        	  try {  
        	  ct.setAutoCommit(false);// Disables auto-commit.          	  
        	   String sql="insert into fangjian values('" + jtf1.getText() + "','" + jtf2.getText() + "','" + jtf3.getText() + "','" + jtf4.getText() + "')";
        	   //String sql="insert into fangjian values('2','cdd','2','2')";
        	    pst = ct.prepareStatement(sql,Statement.RETURN_GENERATED_KEYS);  
        	    ct.setAutoCommit(false);//
        	    pst.executeUpdate();  
        	    ct.commit();  //����    	�ύ 
        	    System.out.println("��ӳɹ�");  
        	  } catch (Exception e) {  
        	  System.out.println(e);  
        	  }  
        	  }  
        
        //������Ϣɾ��
        public static void querySC() {
        	jtf5=ShanChuGL.jtf;
        	 java.sql.PreparedStatement pst = null;         	  
       	  try {  
       	  ct.setAutoCommit(false);// Disables auto-commit.          	  
       	   String sql="delete from fangjian where �����=('" + jtf5.getText() + "')";
       	    pst = ct.prepareStatement(sql,Statement.RETURN_GENERATED_KEYS);  
       	    ct.setAutoCommit(false);//
       	    pst.executeUpdate();  
       	    ct.commit();  //����    	�ύ 
       	    System.out.println("ɾ���ɹ�");  
       	  } catch (Exception e) {  
       	  System.out.println(e);  
       	  }  
        }
		//�û����ҷ���
        public static void queryCZ() {
        	 jtf6=YuDingYH.jtf1;
        	 java.sql.PreparedStatement pst = null;   
        	 ResultSet result=null;	
        	try {  
        		ct.setAutoCommit(false);
                String sql="select * from fangjian where ����� =('" + jtf6.getText() + "') ";  
                pst = ct.prepareStatement (sql);
                ct.setAutoCommit(false);//
           	    result=pst.executeQuery();
           	    ct.commit();  //����    	�ύ   
                if(result.next())     
                {  
                	fjh=result.getString("�����");
					lx=result.getString("����");
					mj=result.getString("���");
					jg=result.getString("�۸�"); 
					System.out.println("���ҳɹ�"+fjh);

                }else  
                {  
                    JOptionPane.showMessageDialog(null, "�]�д˷��䣬����������", "��ʾ��Ϣ", JOptionPane.WARNING_MESSAGE);  
                    System.out.println("����ʧ��");
                }        
           	   
            } catch (Exception e) {  
            	System.out.println(e); 
              //  e.printStackTrace();  
            }  
        }

        	
        
	
}
