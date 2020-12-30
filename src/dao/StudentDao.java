package dao;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import model.SClass;
import model.Student;

public class StudentDao
{
	public static ArrayList<Student> getAll(){
		ArrayList<Student> students=new ArrayList<Student>();
		
		try {
			String sql="select s_student.id,s_student.`name`,s_class.`name` as className,s_student.`password`,	s_student.sex from s_student INNER JOIN s_class on s_student.classId=s_class.id"; 
							 
			Connection con=DBUtils.getCon();
			Statement st=con.createStatement();
			ResultSet rs=st.executeQuery(sql);
			while(rs.next()) {
				Student sts=new Student();
				sts.setId(rs.getInt("id"));
				sts.setName(rs.getString("name"));
				sts.setClassName(rs.getString("className"));
				sts.setPassword(rs.getString("password"));
				sts.setSex(rs.getString("sex"));
				
				students.add(sts);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return students;
		
	}
	
	public static ArrayList<Student> getAllByName(String name) 
	{
		ArrayList<Student> students=new ArrayList<Student>();
		try 
		{
			String sql="select s_student.id,s_student.`name`,s_class.`name` as className,s_student.`password`,	s_student.sex from s_student INNER JOIN s_class on s_student.classId=s_class.id where s_student.`name` like '%"+name+"%'";
			Connection con=DBUtils.getCon();
			Statement st=con.createStatement();
			ResultSet rs=st.executeQuery(sql);
			
			while (rs.next())
			{
				Student sts=new Student();
				 
				sts.setId(rs.getInt("id"));
				sts.setName(rs.getString("name"));
				sts.setClassName(rs.getString("className"));
				sts.setPassword(rs.getString("password"));
				sts.setSex(rs.getString("sex"));
				
				students.add(sts);
				
			}
 		 
		} 
		catch (SQLException e) 
		{
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return students;
	}
	public static ArrayList<Student> getAllByClass(String className) 
	{
		ArrayList<Student> students=new ArrayList<Student>();
		try 
		{
			String sql="select p1.id,p1.`name`,p2.`name` as className,p1.`password`,	p1.sex from s_student as p1 INNER JOIN s_class  as p2 on p1.classId=p2.id where p2.`name` like '%"+className+"%'";
			Connection con=DBUtils.getCon();
			Statement st=con.createStatement();
			ResultSet rs=st.executeQuery(sql);
			
			while (rs.next())
			{
				Student sts=new Student();
				 
				sts.setId(rs.getInt("id"));
				sts.setName(rs.getString("name"));
				sts.setClassName(rs.getString("className"));
				sts.setPassword(rs.getString("password"));
				sts.setSex(rs.getString("sex"));
				
				students.add(sts);
				
			}
 		 
		} 
		catch (SQLException e) 
		{
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return students;
	}
	public static int edit(String stuName,String className,String password,String sex,int id)
	{
		String sql="update s_student set name='"+stuName+"' ,classId=(select id from s_class where name='"+className+"'),`password`='"+password+"',sex='"+sex+"' where id="+id+"";
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

		String sql="delete from s_student where id="+id+"";
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
	public int insert(Student s)
	{
		
		String sql="insert into s_student(name,classId,password,sex) "
				+ "values('"+s.getName()+"','"+s.getClassId()+"','"+s.getPassword()+"','"+s.getSex()+"')";
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
		String sql="select * from s_student where name='" + name + "' and password='" + password + "'";
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
