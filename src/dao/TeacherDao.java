package dao;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import model.SClass;
import model.Student;
import model.Teacher;

public class TeacherDao {
	public static ArrayList<Teacher> getAll() 
	{
		ArrayList<Teacher> teachers=new ArrayList<Teacher>();
		try 
		{
			String sql="select * from s_teacher";
			Connection con=DBUtils.getCon();
			Statement st=con.createStatement();
			ResultSet rs=st.executeQuery(sql);
			
			while (rs.next())
			{
				Teacher ts=new Teacher();
				ts.setId(rs.getInt("id"));
				ts.setName(rs.getString("name"));
				ts.setSex(rs.getString("sex"));
				ts.setTitle(rs.getString("title"));
				ts.setAge(rs.getInt("age"));
				ts.setPassword(rs.getString("password"));
				teachers.add(ts);
				
			}

		} 
		catch (SQLException e) 
		{
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return teachers;
	}
	public static ArrayList<Teacher> getAllByName(String teacherName) 
	{
		ArrayList<Teacher> teachers=new ArrayList<Teacher>();
		try 
		{
			String sql="select * from s_teacher where name like '%"+teacherName+"%'";
			Connection con=DBUtils.getCon();
			Statement st=con.createStatement();
			ResultSet rs=st.executeQuery(sql);
			
			while (rs.next())
			{
				Teacher ts=new Teacher();
				ts.setId(rs.getInt("id"));
				ts.setName(rs.getString("name"));
				ts.setSex(rs.getString("sex"));
				ts.setTitle(rs.getString("title"));
				ts.setAge(rs.getInt("age"));
				ts.setPassword(rs.getString("password"));
				teachers.add(ts);
				
			}

		} 
		catch (SQLException e) 
		{
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return teachers;
	}
	
	public static int edit(String name,String title,String password,String sex,int age,int id)
	{
		String sql="update s_teacher set name='"+name+"',sex='"+sex+"',title='"+title+"',age='"+age+"',password='"+password+"'where id="+id+"";
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

		String sql="delete from s_teacher where id="+id+"";
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
	public int insert(Teacher t)
	{
		
		String sql="insert into s_teacher(name,sex,title,age,password) "
				+ "values('"+t.getName()+"','"+t.getSex()+"','"+t.getTitle()+"','"+t.getAge()+"','"+t.getPassword()+"')";
		int result=0;
		try
		{
			Connection con=DBUtils.getCon();
			Statement st=con.createStatement();
			result=st.executeUpdate(sql);
		} catch (SQLException e)
		{
			e.printStackTrace();
		}
		return result;
		
	}
	public int login(String name,String password) {
		int result=-1;
		String sql="select * from s_teacher where name='" + name + "' and password='" + password + "'";
		Connection con = DBUtils.getCon();
		Statement st;
		try {
			st = con.createStatement();
			ResultSet rs = st.executeQuery(sql);
			if (rs.next()) {
				result=1;
			}

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return result;
	}

}
