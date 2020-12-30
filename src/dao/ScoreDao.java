package dao;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import model.Course;
import model.Score;


public class ScoreDao {
	public static ArrayList<Score> getAll(){
		ArrayList<Score> score=new ArrayList<Score>();
		try {
			String sql="select p1.id,p2.name as student_name,p3.name as course_name ,p1.score from \r\n" + 
					"	s_score as p1, s_student as p2,s_course as p3 where \r\n" + 
					"	p1.student_id=p2.id and p1.course_id=p3.id";
							 
			Connection con=DBUtils.getCon();
			Statement st=con.createStatement();
			ResultSet rs=st.executeQuery(sql);
			while(rs.next()) {
				Score sc=new Score();
				sc.setId(rs.getInt("id"));
				sc.setStudent_name(rs.getString("student_name"));
				sc.setCourse_name(rs.getString("course_name"));
				sc.setScore(rs.getInt("score"));
				score.add(sc);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return score;
		
	}
	public static ArrayList<Score> getByInfo(String student_name ,String course_name){
		ArrayList<Score> score=new ArrayList<Score>();
		try 
		{
			String sql="select p1.id,p2.name as student_name,p3.name as course_name,p1.score from s_score as p1, s_student as p2, s_course as p3\r\n" + 
					" where p1.student_id=p2.id and p1.course_id=p3.id and p2.`name`='"+student_name+"' and p3.`name`='"+course_name+"'";
			Connection con=DBUtils.getCon();
			Statement st=con.createStatement();
			ResultSet rs=st.executeQuery(sql);
			
			while (rs.next())
			{
				Score sc=new Score();
				sc.setId(rs.getInt("id"));
				sc.setStudent_name(rs.getString("student_name"));
				sc.setCourse_name(rs.getString("course_name"));
				sc.setScore(rs.getInt("score"));
				 
				
				score.add(sc);
			}
 		 
		} 
		catch (SQLException e) 
		{
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return score;
	}
	public static int edit(int score,int id)
	{
		String sql="update s_score set score="+score+" where id="+id+"";
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

		String sql="delete from s_score where id="+id+"";
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
	
	public static  int insert(Score c)
	{
		
		String sql="insert into  s_score(student_id,course_id,score) values("+c.getStudent_id()+","+c.getCourse_id()+","+c.getScore()+")";
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
		 
	public static ArrayList<Score> getInfo(int id){
		ArrayList<Score> arr=new ArrayList<Score>() ;
		 
		try {
			String sql="select MAX(score)as highestScore,MIN(score)as lowestScore,AVG(score)as avgScore,COUNT(course_id="+id+")as num from s_score where course_id="+id+"";
							 
			Connection con=DBUtils.getCon();
			Statement st=con.createStatement();
			ResultSet rs=st.executeQuery(sql);
			while(rs.next()) {
				Score ss=new Score();
				ss.setHighestScore(rs.getInt("highestScore"));
				ss.setLowestScore(rs.getInt("lowestScore"));
				ss.setAvgScore(rs.getDouble("avgScore"));
				ss.setNum(rs.getInt("num"));
				arr.add(ss);
				 
			}
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return arr;
		
		
	}	
	
}
