package dao;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import model.Course;
import model.Student;

public class CourseDao {
	public static ArrayList<Course> getAll(){
		ArrayList<Course> courses=new ArrayList<Course>();
		
		try {
			String sql="select p1.id,p1.name,p2.name as teacher_name,p1.max_student_num,p1.info,p1.selected_num from s_course as p1 INNER JOIN s_teacher as p2 on p1.teacher_id=p2.id";
							 
			Connection con=DBUtils.getCon();
			Statement st=con.createStatement();
			ResultSet rs=st.executeQuery(sql);
			while(rs.next()) {
				Course cs=new Course();
				cs.setId(rs.getInt("id"));
				cs.setName(rs.getString("name"));
				cs.setTeacher_name(rs.getString("teacher_name"));
				cs.setMax_student_num(rs.getInt("max_student_num"));
				cs.setInfo(rs.getString("info"));
				cs.setSelected_num(rs.getInt("selected_num"));
				
				courses.add(cs);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return courses;
		
	}
	public static ArrayList<Course> getAllByName(String courseName){
		ArrayList<Course> courses=new ArrayList<Course>();
		try 
		{
			String sql="select p1.id,p1.name,p2.name as teacher_name,p1.max_student_num,p1.info,p1.selected_num from s_course as p1 INNER JOIN s_teacher as p2 on p1.teacher_id=p2.id where p1.name like '%"+courseName+"%'";
			Connection con=DBUtils.getCon();
			Statement st=con.createStatement();
			ResultSet rs=st.executeQuery(sql);
			
			while (rs.next())
			{
				Course cs=new Course();
				cs.setId(rs.getInt("id"));
				cs.setName(rs.getString("name"));
				cs.setTeacher_name(rs.getString("teacher_name"));
				cs.setMax_student_num(rs.getInt("max_student_num"));
				cs.setInfo(rs.getString("info"));
				cs.setSelected_num(rs.getInt("selected_num"));
				
				courses.add(cs);
				
			}
 		 
		} 
		catch (SQLException e) 
		{
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return courses;
	}
	public static ArrayList<Course> getAllByTeacher(String teacherName) 
	{
		ArrayList<Course> courses=new ArrayList<Course>();
		try 
		{
			String sql="select p1.id,p1.name,p2.name as teacher_name,p1.max_student_num,p1.info,p1.selected_num from s_course as p1 INNER JOIN s_teacher as p2 on p1.teacher_id=p2.id where p2.name like '%"+teacherName+"%'";
			Connection con=DBUtils.getCon();
			Statement st=con.createStatement();
			ResultSet rs=st.executeQuery(sql);
			
			while (rs.next())
			{
				Course cs=new Course();
				cs.setId(rs.getInt("id"));
				cs.setName(rs.getString("name"));
				cs.setTeacher_name(rs.getString("teacher_name"));
				cs.setMax_student_num(rs.getInt("max_student_num"));
				cs.setInfo(rs.getString("info"));
				cs.setSelected_num(rs.getInt("selected_num"));
				
				courses.add(cs);
				
				
			}
 		 
		} 
		catch (SQLException e) 
		{
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return courses;
	}
	public static int edit(String courseName,String teacherName,String info,int selected_num,int id)
	{
		String sql="update s_course set name='"+courseName+"',teacher_id=(select id from s_teacher where name='"+teacherName+"'),info='"+info+"',selected_num="+selected_num+" where id="+id+"";
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

		String sql="delete from s_course where id="+id+"";
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
	public int insert(Course c)
	{
		
		String sql="insert into  s_course(name,teacher_id,max_student_num,info) values('"+c.getName()+"',"+c.getTeacher_id()+","+c.getMax_student_num()+",'"+c.getInfo()+"') ";
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
}
