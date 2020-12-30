package st02_studentManagerment;

import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.*;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import javax.swing.table.DefaultTableModel;

import dao.CourseDao;
import dao.SelectedCourseDao;
import dao.StudentDao;
import dao.TeacherDao;
import model.Course;
import model.SelectedCourse;
import model.Student;
import model.Teacher;

public class SelectCourseFrm {
	String[] columnNames = {"课程编号","学生姓名","课程名称"};
	JTable jt=new JTable();

	public SelectCourseFrm() {
		initUI() ;
	}
	
	public void initUI() {
		
		Dimension dim1=new Dimension(125,25);
		Dimension dim2=new Dimension(600,300); 
		Dimension dim3=new Dimension(800,50);
		Dimension dim4=new Dimension(600,150);
		
		JFrame scFrm=new JFrame("选课管理");
		scFrm.setSize(800,600);
		scFrm.setLocationRelativeTo(null);
//		scFrm.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		JPanel bigPanel=new JPanel();
		JPanel p1=new JPanel();
		p1.setPreferredSize(dim3);
//		JPanel p2=new JPanel();
		JPanel p3=new JPanel();
		p3.setPreferredSize(dim4);
		// 标题边框左
		p3.setBorder(BorderFactory.createTitledBorder("修改选课"));
		JPanel p4=new JPanel();
		JPanel p5=new JPanel();
		
		JLabel lblStudentName =new JLabel("学生：",new ImageIcon("images/学生管理.png"),0);
		ArrayList<Student> list=StudentDao.getAll();
		String[] studentList=new String[list.size()];
		
		for (int i = 0; i < list.size(); i++)
		{
			studentList[i]=list.get(i).getName();
		}
		
		JComboBox comboBox=new JComboBox(studentList);
	    comboBox.setPreferredSize(dim1);
	    JLabel lblCourseName =new JLabel("课程：",new ImageIcon("images/课程.png"),0);
	   
	    ArrayList<Course> list2=CourseDao.getAll();
		String[] courseList=new String[list2.size()];
//		System.out.println(list2.size());
		
		for (int i = 0; i < list2.size(); i++)
		{
			courseList[i]=list2.get(i).getName();
		}
		
		JComboBox comboBox2=new JComboBox(courseList);
	    comboBox2.setPreferredSize(dim1);
	    JButton btn1=new JButton("确认选课",new ImageIcon("images/确认.png"));
	    btn1.setPreferredSize(dim1);
	    
	    p1.add(lblStudentName);
	    p1.add(comboBox);
	    p1.add(lblCourseName);
	    p1.add(comboBox2);
	    p1.add(btn1);
	    
	 
	    ArrayList<SelectedCourse> selectedcourses=SelectedCourseDao.getAll();
		updateTableData(selectedcourses);	
        
		
		
		//滚动面板
		JScrollPane p2=new JScrollPane(jt);
		p2.setPreferredSize(dim2);
		
		
		
		JLabel lblStudentName2 =new JLabel("学生：",new ImageIcon("images/学生管理.png"),0);
		 
	    JComboBox comboBox3 = new JComboBox(studentList);
	    comboBox3.setPreferredSize(dim1);
	    JLabel lblCourseName2 =new JLabel("课程：",new ImageIcon("images/课程.png"),0);
		 
	    JComboBox comboBox4 = new JComboBox(courseList);
	    comboBox4.setPreferredSize(dim1);
	    JButton btn2=new JButton("确认修改",new ImageIcon("images/确认.png"));
	    btn2.setPreferredSize(dim1);
		JButton btn3=new JButton("退选课程",new ImageIcon("images/删除.png"));
		btn3.setPreferredSize(dim1);
	    
		
		p3.add(lblStudentName2);
	    p3.add(comboBox3);
	    p3.add(lblCourseName2);
	    p3.add(comboBox4);
	    p3.add(btn2);
	    p3.add(btn3);
	    
	    
	    
	    
	    bigPanel.add(p1);
	    bigPanel.add(p2);
	    bigPanel.add(p3);
	    
	    FlowLayout flowLayout = new FlowLayout();
	    flowLayout.setVgap(10);//组件垂直间距
	    flowLayout.setHgap(20);//水平间距
	    
	    p3.setLayout(flowLayout);
	    scFrm.add(bigPanel);
	    
	    jt.getSelectionModel().addListSelectionListener(new ListSelectionListener() {
 			
 			@Override
 			public void valueChanged(ListSelectionEvent e) {
 				int row=jt.getSelectedRow();
 				if(row>=0)
 				{
 					comboBox3.removeAllItems();
 					comboBox3.addItem(jt.getValueAt(row, 1).toString());
 					ArrayList<Student> list=StudentDao.getAll();
 					for (int i = 0; i < list.size(); i++)
 					{
 						comboBox3.addItem(list.get(i).getName());
 					}
 					comboBox4.removeAllItems();
 					comboBox4.addItem(jt.getValueAt(row, 2).toString());
 					ArrayList<Course> list2=CourseDao.getAll();
 					for (int i = 0; i < list2.size(); i++)
 					{
 						comboBox4.addItem(list2.get(i).getName());
 					}
 				}
 				
 			}
 		});
	    btn1.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				 String studentName=comboBox.getSelectedItem().toString();
				 String courseName=comboBox2.getSelectedItem().toString();
				 int student_id=0;
				 int course_id=0;
				 ArrayList<Student> list=StudentDao.getAll();
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
				 SelectedCourseDao selectedcourseDao=new SelectedCourseDao();
				 SelectedCourse selectedcourse =new SelectedCourse();
				 selectedcourse.setStudent_id(student_id);
				 selectedcourse.setCourse_id(course_id);
					 
				 int result=selectedcourseDao.insert(selectedcourse);
						
				 if(result>0)
					{
						JOptionPane.showMessageDialog(null, "选课成功");
					}
					else
					{
						JOptionPane.showMessageDialog(null, "选课失败");
					}
				ArrayList<SelectedCourse> selectedcourses=SelectedCourseDao.getAll();
				updateTableData(selectedcourses);	
				
			}
		});
	    btn2.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				int row=jt.getSelectedRow();

				 int id=Integer.parseInt(jt.getValueAt(row, 0).toString());
				 String teacherName=comboBox3.getSelectedItem().toString();
				 String courseName=comboBox4.getSelectedItem().toString();
				 int result=SelectedCourseDao.edit(teacherName, courseName,id);
				 if(result>0) {
					 JOptionPane.showMessageDialog(null, "修改成功");
					 ArrayList<SelectedCourse> tempcourse=SelectedCourseDao.getAll();
					 updateTableData(tempcourse);
				 }else {
					JOptionPane.showMessageDialog(null, "修改失败");
				 }
				
				
			}
		});
	    btn3.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				int row=jt.getSelectedRow();
				if(row>0)
				{
					int  id=Integer.parseInt(jt.getValueAt(row, 0).toString());
					
					int result=SelectedCourseDao.delete(id);
					if(result>0)
					{
						JOptionPane.showMessageDialog(null, "删除成功");
						ArrayList<SelectedCourse> tempcourses=SelectedCourseDao.getAll();
						updateTableData(tempcourses);
					}
					else
					{
						JOptionPane.showMessageDialog(null, "删除失败");
					}
				}
			}
		});
	    scFrm.setResizable(false);
	    scFrm.setVisible(true);
		
		
	}

	public void updateTableData(ArrayList<SelectedCourse> datas)
	{
		String[][] tempData=new String[datas.size()][3];
		
		for(int i=0;i<datas.size();i++)
		{
			for(int j=0;j<3;j++)
			{
				if(j==0)
					tempData[i][j]=datas.get(i).getId()+"";
				if(j==1)
					tempData[i][j]=datas.get(i).getStudentName();
				if(j==2)
					tempData[i][j]=datas.get(i).getCourseName();
				
			}
		}
		
		DefaultTableModel tempmodel=new DefaultTableModel(tempData,columnNames);
		
		
		jt.setModel(tempmodel);

	}

	public static void main(String[] args) {
		new SelectCourseFrm();

	}

}
