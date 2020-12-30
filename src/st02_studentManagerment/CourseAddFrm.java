 package st02_studentManagerment;

import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.*;

import dao.CourseDao;
import dao.StudentDao;
import dao.TClassDao;
import dao.TeacherDao;
import model.Course;
import model.SClass;
import model.Student;
import model.Teacher;

public class CourseAddFrm {

	public CourseAddFrm() {
		initUI();
	}
	
	public void initUI() {
		Dimension dim1=new Dimension(500,40);
		Dimension dim2=new Dimension(150,25);
		Dimension dim3=new Dimension(150,150);
		
		
		JFrame cadfrm=new JFrame("添加课程：");
		cadfrm.setSize(500,400);
		cadfrm.setLocationRelativeTo(null);
//		cadfrm.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		
		JPanel bigPanel=new JPanel();
		
		JPanel p1=new JPanel();
		p1.setPreferredSize(dim1);
		JPanel p2=new JPanel();
		p2.setPreferredSize(dim1);
		JPanel p3=new JPanel();
		p3.setPreferredSize(dim1);
		JPanel p4=new JPanel();
		p4.setPreferredSize(new Dimension(500,150));
		JPanel p5=new JPanel();
		p5.setPreferredSize(dim1);
		
		JLabel lblcourseName=new JLabel("课程名称:",new ImageIcon("images/课程.png"),0);
		JTextField txtcourseName=new JTextField();
		txtcourseName.setPreferredSize(dim2);
		p1.add(lblcourseName);
		p1.add(txtcourseName);
		
		JLabel lblteacherName=new JLabel("授课老师:",new ImageIcon("images/老师.png"),0);
		ArrayList<Teacher> list=TeacherDao.getAll();
		String[] teacherList=new String[list.size()];
		
		for (int i = 0; i < list.size(); i++)
		{
			teacherList[i]=list.get(i).getName();
		}
		
		JComboBox cboClassList=new JComboBox(teacherList);
		cboClassList.setPreferredSize(dim2);
	    p2.add(lblteacherName);
	    p2.add(cboClassList);
		
		JLabel lblstudentNum=new JLabel("学生人数:",new ImageIcon("images/人数.png"),0);
		JTextField txtstudentNum=new JTextField();
		txtstudentNum.setPreferredSize(dim2);
		p3.add(lblstudentNum);
	    p3.add(txtstudentNum);
		
		JLabel lblcourseInfo=new JLabel("课程介绍:",new ImageIcon("images/人数.png"),0);
		JTextArea area=new JTextArea();
		area.setPreferredSize(dim3);
		p4.add(lblcourseInfo);
	    p4.add(area);
		
		JButton btnConfirm=new JButton("确认添加",new ImageIcon("images/确认.png"));
		JButton btnReSet=new JButton("重置信息",new ImageIcon("images/重置.png"));
		p5.add(btnConfirm);
		p5.add(btnReSet);
		
		bigPanel.add(p1);
		bigPanel.add(p2);
		bigPanel.add(p3);
		bigPanel.add(p4);
		bigPanel.add(p5);
		
		
		cadfrm.add(bigPanel);
		
		btnConfirm.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				String courseName=txtcourseName.getText();
				String teacherName=cboClassList.getSelectedItem().toString();
				int max_student_num=Integer.parseInt(txtstudentNum.getText().toString());
				String area_=area.getText();
				int teacher_id=0;
				
				ArrayList<Teacher> list=TeacherDao.getAll();
				for (int i = 0; i < list.size(); i++)
				{
					
					if(list.get(i).getName().equals(teacherName))
					{
						teacher_id=list.get(i).getId();
						break;
					}
					
				}
			
				CourseDao courseDao=new CourseDao();
				Course course =new Course();
				course.setName(courseName);
				course.setTeacher_id(teacher_id);
				course.setMax_student_num(max_student_num);
				course.setInfo(area_);
				//
				int result=courseDao.insert(course);
				
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
		btnReSet.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				txtcourseName.setText(null);
				txtstudentNum.setText(null);
				area.setText(null);
				
				
			}
		});
		cadfrm.setResizable(false);
		cadfrm.setVisible(true);
	}

	public static void main(String[] args) {
		 
		new CourseAddFrm();
	}

}
