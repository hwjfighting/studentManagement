package dao;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import model.Attendance;
import model.SelectedCourse;

public class AttendanceDao {
	public static ArrayList<Attendance> getAll(){
		ArrayList<Attendance> attendance=new ArrayList<Attendance>();
		try {
			String sql="select p1.id,p2.name as student_name,p3.name as course_name ,p1.attendance_date from \r\n" + 
					"	s_attendance as p1, s_student as p2,s_course as p3 where \r\n" + 
					"	p1.student_id=p2.id and p1.course_id=p3.id";
							 
			Connection con=DBUtils.getCon();
			Statement st=con.createStatement();
			ResultSet rs=st.executeQuery(sql);
			while(rs.next()) {
				Attendance atdc=new Attendance();
				atdc.setId(rs.getInt("id"));
				atdc.setStudent_name(rs.getString("student_name"));
				atdc.setCourse_name(rs.getString("course_name"));
				atdc.setAttendance_date(rs.getString("attendance_date"));
				attendance.add(atdc);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return attendance;
		
	}
	public static int delete(int id)
	{

		String sql="delete from s_attendance where id="+id+"";
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
	public int insert(Attendance at)
	{
		
		String sql="insert into s_attendance(student_id,course_id,attendance_date) values ("+at.getStudent_id()+","+at.getCourse_id()+",'"+at.getAttendance_date()+"')";
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
