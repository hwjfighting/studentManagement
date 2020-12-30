package dao;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import model.Course;
import model.SelectedCourse;

public class SelectedCourseDao {
	public static ArrayList<SelectedCourse> getAll(){
		ArrayList<SelectedCourse> selectedcourses=new ArrayList<SelectedCourse>();
		try {
			String sql="select p1.id,p2.name as studentName,p3.name as courseName\r\n" + 
					"from s_selected_course as p1,s_student as p2,s_course as p3\r\n" + 
					"where p1.student_id=p2.id and p1.course_id=p3.id \r\n" + 
					"order by p1.id";
							 
			Connection con=DBUtils.getCon();
			Statement st=con.createStatement();
			ResultSet rs=st.executeQuery(sql);
			while(rs.next()) {
				SelectedCourse scs=new SelectedCourse();
				scs.setId(rs.getInt("id"));
				scs.setStudentName(rs.getString("studentName"));
				scs.setCourseName(rs.getString("courseName"));
				selectedcourses.add(scs);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return selectedcourses;
		
	}
	public int insert(SelectedCourse sc)
	{
		
		String sql="insert into s_selected_course(student_id,course_id) values ("+sc.getStudent_id()+","+sc.getCourse_id()+")";
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
	public static int edit(String studentName,String courseName,int id)
	{
		String sql="update s_selected_course set student_id=(select id from s_student where name='"+studentName+"'),\r\n" + 
				"	course_id=(select id from s_course where name='"+courseName+"') where id="+id+"";
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

		String sql="delete from s_selected_course where id="+id+"";
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

}
