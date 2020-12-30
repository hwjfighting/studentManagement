package st02_studentManagerment;

import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.*;

import dao.CourseDao;
import dao.ScoreDao;
import dao.StudentDao;
import dao.TeacherDao;
import model.Course;
import model.Score;
import model.Student;
import model.Teacher;

public class AddScore {
	public AddScore() {
		initUI();
	}
	public static void initUI() {
		Dimension dim1=new Dimension(200,35);
		Dimension dim2=new Dimension(600,80); 
		 
		
		JFrame jf=new JFrame("成绩录入界面");
		jf.setSize(600,400);
		jf.setLocationRelativeTo(null);
//		jf.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		
		JPanel bigPanel=new JPanel();
		JPanel p1=new JPanel();
		p1.setPreferredSize(dim2);
 		JPanel p2=new JPanel();
 		p2.setPreferredSize(dim2);
		JPanel p3=new JPanel();
		p3.setPreferredSize(dim2);
		JPanel p4=new JPanel();
		p4.setPreferredSize(dim2);
		
		JLabel lblStudentName =new JLabel("学生姓名：",new ImageIcon("images/学生管理.png"),0);
		ArrayList<Student> list=StudentDao.getAll();
		String[] studentList=new String[list.size()];
		
		for (int i = 0; i < list.size(); i++)
		{
			studentList[i]=list.get(i).getName();
		}
		
		JComboBox comboBox=new JComboBox(studentList);
	    comboBox.setPreferredSize(dim1);
	    p1.add(lblStudentName);
	    p1.add(comboBox);
	   
	    JLabel lblCourseName =new JLabel("课程信息：",new ImageIcon("images/课程.png"),0);
	   
	    ArrayList<Course> list2=CourseDao.getAll();
		String[] courseList=new String[list2.size()];
		for (int i = 0; i < list2.size(); i++)
		{
			courseList[i]=list2.get(i).getName();
		}
		
		JComboBox comboBox2=new JComboBox(courseList);
	    comboBox2.setPreferredSize(dim1);
	    p2.add(lblCourseName);
	    p2.add(comboBox2);
	    
	    JLabel lblScore =new JLabel("所得成绩：",new ImageIcon("images/成绩.png"),0);
	    JTextField txtScore=new JTextField();
	    txtScore.setPreferredSize(dim1);
	    p3.add(lblScore);
	    p3.add(txtScore);
	    
	    JButton btn=new JButton("录入成绩",new ImageIcon("images/确认.png"));
	    p4.add(btn);
		
	    bigPanel.add(p1);
 	    bigPanel.add(p2);
	    bigPanel.add(p3);
	    bigPanel.add(p4);
		jf.add(bigPanel);
		
		btn.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				 String studentName=comboBox.getSelectedItem().toString();
				 String courseName=comboBox2.getSelectedItem().toString();
				 int score=Integer.parseInt(txtScore.getText().toString());
				 ArrayList<Student> list=StudentDao.getAll();
				 int student_id=0;
				 int course_id=0;
					for (int i = 0; i < list.size(); i++)
					{
						
						if(list.get(i).getName().equals(studentName))
						{
							student_id=list.get(i).getId();
							break;
						}
						
					}
				ArrayList<Course> list2=CourseDao.getAll();
				for (int i = 0; i < list2.size(); i++)
				{
					
					if(list2.get(i).getName().equals(courseName))
					{
						course_id=list2.get(i).getId();
						break;
					}
					
				}
				
				ScoreDao scoreDao=new ScoreDao();
				Score scores =new Score();
				scores.setStudent_id(student_id);
				scores.setCourse_id(course_id);
				scores.setScore(score);
				 
				 
				int result=scoreDao.insert(scores);
				
				if(result>0)
				{
					JOptionPane.showMessageDialog(null, "成功添加课程");
				}
				else
				{
					JOptionPane.showMessageDialog(null, "添加课程失败");
				}
				
				
			}
		});
		jf.setResizable(false);
		jf.setVisible(true);
	}
	public static void main(String[] args) {
		new AddScore();
	}
	


}
