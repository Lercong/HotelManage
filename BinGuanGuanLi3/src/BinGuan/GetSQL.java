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

     
     //连接数据库
	public static void ConnectionSQL() {
		try {
 		      Class.forName("com.mysql.jdbc.Driver");     //加载MYSQL JDBC驱动程序   
 		      //Class.forName("org.gjt.mm.mysql.Driver");
 		     System.out.println("Success loading Mysql Driver!");
 		    }
 		    catch (Exception e) {
 		      System.out.print("Error loading Mysql Driver!");
 		      e.printStackTrace();
 		    }
 	 try {
	     ct = DriverManager.getConnection( "jdbc:mysql://localhost:3306/binguan","root","root");
	           //连接URL为   jdbc:mysql//服务器地址/数据库名  ，后面的2个参数分别是登陆用户名和密码

	      System.out.println("Success connect Mysql server!");
	       stmt = ct.createStatement();
	}
	    catch (Exception e) {
	        System.out.print("get data error!");
	        e.printStackTrace();
	      }
	}
	
	//用户密码查询
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
					userword1=result.getString("用户名");
					pwd1=result.getString("密码");
					System.out.println(userword1+" "+pwd1);
					
				}
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
	}
	
	//管理密码查询
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
				userword2=result.getString("用户名");
				pwd2=result.getString("密码");
				System.out.println(userword2+" "+pwd2);
				
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}  
	 
    //房间信息行数
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
        //房间信息
        public static void queryFJ() {
        	String[] columnNames= {"房间号","面积","类型","价格"};	
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
        			biao[i][0]=result.getString("房间号");
					biao[i][1]=result.getString("类型");
					biao[i][2]=result.getString("面积");
					biao[i][3]=result.getString("价格");
					i++;
				}
        		tm=new DefaultTableModel(biao,columnNames);
        		jt1=new JTable(tm);
        		}catch(SQLException e1) {
				     e1.printStackTrace();
			    }
        	}
        
        //房间信息增加
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
        	    ct.commit();  //事务    	提交 
        	    System.out.println("添加成功");  
        	  } catch (Exception e) {  
        	  System.out.println(e);  
        	  }  
        	  }  
        
        //房间信息删除
        public static void querySC() {
        	jtf5=ShanChuGL.jtf;
        	 java.sql.PreparedStatement pst = null;         	  
       	  try {  
       	  ct.setAutoCommit(false);// Disables auto-commit.          	  
       	   String sql="delete from fangjian where 房间号=('" + jtf5.getText() + "')";
       	    pst = ct.prepareStatement(sql,Statement.RETURN_GENERATED_KEYS);  
       	    ct.setAutoCommit(false);//
       	    pst.executeUpdate();  
       	    ct.commit();  //事务    	提交 
       	    System.out.println("删除成功");  
       	  } catch (Exception e) {  
       	  System.out.println(e);  
       	  }  
        }
		//用户查找房间
        public static void queryCZ() {
        	 jtf6=YuDingYH.jtf1;
        	 java.sql.PreparedStatement pst = null;   
        	 ResultSet result=null;	
        	try {  
        		ct.setAutoCommit(false);
                String sql="select * from fangjian where 房间号 =('" + jtf6.getText() + "') ";  
                pst = ct.prepareStatement (sql);
                ct.setAutoCommit(false);//
           	    result=pst.executeQuery();
           	    ct.commit();  //事务    	提交   
                if(result.next())     
                {  
                	fjh=result.getString("房间号");
					lx=result.getString("类型");
					mj=result.getString("面积");
					jg=result.getString("价格"); 
					System.out.println("查找成功"+fjh);

                }else  
                {  
                    JOptionPane.showMessageDialog(null, "沒有此房间，请重新输入", "提示消息", JOptionPane.WARNING_MESSAGE);  
                    System.out.println("查找失败");
                }        
           	   
            } catch (Exception e) {  
            	System.out.println(e); 
              //  e.printStackTrace();  
            }  
        }

        	
        
	
}
