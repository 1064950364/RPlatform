package com.RPlatform;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;




public class SQLHelp{
	
	private static String url = "jdbc:mysql://localhost:3306/rplatform";	// ���ݿ������ַ���
	private static String username = "root";	// ���ݿ��û���
	private static String password = "";	// ���ݿ�����    
	
	
	public SQLHelp() throws ClassNotFoundException
	{
		
	}
	private static void release(Connection conn,Statement st,ResultSet rs){
	       if(rs!=null)
	       {
	             try{
	                 //�رմ洢��ѯ�����ResultSet����
	                 rs.close();
	             }catch (Exception e) {
	                 e.printStackTrace();
	             }
	             rs = null;
	         }
	         if(st!=null){
	             try{
	                 //�رո���ִ��SQL�����Statement����
	                 st.close();
	             }catch (Exception e) {
	                 e.printStackTrace();
	             }
	         }
	         
	         if(conn!=null){
	             try{
	                 //�ر�Connection���ݿ����Ӷ���
	                 conn.close();
	             }catch (Exception e) {
	                 e.printStackTrace();
	             }
	         }
	     }
		 
	private static Connection getConnection() throws SQLException, ClassNotFoundException{
    	Class.forName("com.mysql.jdbc.Driver");	// �������ݿ�������ע�ᵽ����������
    	return DriverManager.getConnection(url, username,password);
    	   }
    
    public static int update(String sql)
	{//����ɾ���ģ����ظ��µ�����������0��ʧ��
    	int i=0;
    	Connection conn=null;
    	Statement st=null;
    	ResultSet rs=null;
		try {
			st=getConnection().createStatement();
			i=st.executeUpdate(sql);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		finally{
		  release(conn,st,rs);
		}
		return i;
	}
    public static ResultSet query(String sql)
   	{//��ѯ�����ؽ��ResultSet
       	Statement st=null;
       	ResultSet rs=null;
   		try {
   			st=getConnection().createStatement();
   			rs=st.executeQuery(sql);
   		} catch (SQLException e) {
   			// TODO Auto-generated catch block
   			e.printStackTrace();
   		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
   		
   		return rs;
   	}
           
}

