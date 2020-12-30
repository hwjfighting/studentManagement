package dao;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import model.SClass;

public class TClassDao 
{
	public static ArrayList<SClass> getAll() 
	{
		ArrayList<SClass> classes=new ArrayList<SClass>();
		try 
		{
			String sql="select * from s_class";
			Connection con=DBUtils.getCon();
			Statement st=con.createStatement();
			ResultSet rs=st.executeQuery(sql);
			
			while (rs.next())
			{
				SClass cla=new SClass();
				cla.setId(rs.getInt("id"));
				cla.setName(rs.getString("name"));
				cla.setInfo(rs.getString("info"));
				classes.add(cla);
				
			}
//			 for(SClass s:classes)
//			 {
//				 System.out.println(s.getId());
//				 System.out.println(s.getName());
//				 System.out.println(s.getInfo());
//			 }
		} 
		catch (SQLException e) 
		{
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return classes;
	}
	public static ArrayList<SClass> getAllByName(String className) 
	{
		ArrayList<SClass> classes=new ArrayList<SClass>();
		try 
		{
			String sql="select * from s_class where name like '%"+className+"%'";
			Connection con=DBUtils.getCon();
			Statement st=con.createStatement();
			ResultSet rs=st.executeQuery(sql);
			
			while (rs.next())
			{
				SClass cla=new SClass();
				cla.setId(rs.getInt("id"));
				cla.setName(rs.getString("name"));
				cla.setInfo(rs.getString("info"));
				classes.add(cla);
				
			}
//			 for(SClass s:classes)
//			 {
//				 System.out.println(s.getId());
//				 System.out.println(s.getName());
//				 System.out.println(s.getInfo());
//			 }
		} 
		catch (SQLException e) 
		{
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return classes;
	}
	public static int edit(int id,String name,String info)
	{
		String sql="update s_class set name='"+name+"',info='"+info+"'where id="+id+"";
		int result=0;
		
		try {                           
			Connection con=DBUtils.getCon();
			Statement st=con.createStatement();
			result=st.executeUpdate(sql);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return result;
	}
	public static int delete(int id)
	{

		String sql="delete from s_class where id="+id+"";
		int result=0;
		
		try {
			Connection con=DBUtils.getCon();
			Statement st=con.createStatement();
			result=st.executeUpdate(sql);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return result;
	}
	
	public static int insert(String className,String info) {
		String sql="insert into s_class(name,info) values('"+className+"','"+info+"')";
		int result=0;
		try {
			Connection con=DBUtils.getCon();
			Statement st=con.createStatement();
			result=st.executeUpdate(sql);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return result;
		
	}
	 
//	public static void main(String[] args) 
//	{
//		    getAll();
//		    
//		    
//		    
//	}
}
