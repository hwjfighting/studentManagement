package st02_studentManagerment;

import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

 

import dao.AttendanceDao;
import dao.CourseDao;
import dao.SelectedCourseDao;
import dao.StudentDao;
import model.Attendance;
import model.Course;
import model.SelectedCourse;
import model.Student;

public class AttendancemgFrm {
	String[] columnNames = {"ǩ��ID","ѧ������","�γ�����","ǩ��ʱ��"};
	JTable jt=new JTable();
	public AttendancemgFrm() {
		initUI();
	}
	
	
	
	public void initUI() {
		Dimension dim1=new Dimension(125,25);
		Dimension dim2=new Dimension(600,500); 
		Dimension dim3=new Dimension(600,30);
		Dimension dim4=new Dimension(650,565);
		
		JFrame scFrm=new JFrame("ǩ�����ڹ���");
		scFrm.setSize(800,800);
		scFrm.setLocationRelativeTo(null);
// 		scFrm.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		JPanel bigPanel=new JPanel();
		JPanel p1=new JPanel();
		p1.setPreferredSize(dim3);
//		JPanel p2=new JPanel();
		JPanel p3=new JPanel();
		p3.setPreferredSize(dim4);
		// ����߿���
		p3.setBorder(BorderFactory.createTitledBorder("��ǩ���б�"));
		JPanel p4=new JPanel();
		JPanel p5=new JPanel();
		
		JLabel lblStudentName =new JLabel("ѧ����",new ImageIcon("images/ѧ������.png"),0);
		ArrayList<Student> list=StudentDao.getAll();
		String[] studentList=new String[list.size()];
		
		for (int i = 0; i < list.size(); i++)
		{
			studentList[i]=list.get(i).getName();
		}
		
		JComboBox comboBox=new JComboBox(studentList);
	    comboBox.setPreferredSize(dim1);
	    JLabel lblCourseName =new JLabel("�γ̣�",new ImageIcon("images/�γ�.png"),0);
	   
	    ArrayList<Course> list2=CourseDao.getAll();
		String[] courseList=new String[list2.size()];
//		System.out.println(list2.size());
		
		for (int i = 0; i < list2.size(); i++)
		{
			courseList[i]=list2.get(i).getName();
		}
		
		JComboBox comboBox2=new JComboBox(courseList);
	    comboBox2.setPreferredSize(dim1);
	    JButton btn1=new JButton("ȷ��ǩ��",new ImageIcon("images/ȷ��.png"));
	    btn1.setPreferredSize(dim1);
	    
	    p1.add(lblStudentName);
	    p1.add(comboBox);
	    p1.add(lblCourseName);
	    p1.add(comboBox2);
	    p1.add(btn1);
	    
	    ArrayList<Attendance> attendance=AttendanceDao.getAll();
		updateTableData(attendance);	
	    
	    JScrollPane p2=new JScrollPane(jt);
		p2.setPreferredSize(dim2);
		
		JButton btn=new JButton("���ȱϯ",new ImageIcon("images/ɾ��.png"));
		btn.setPreferredSize(dim3);
		
		p3.add(p2);
		p3.add(btn);
	    
	    bigPanel.add(p1);
//	    bigPanel.add(p2);
	    bigPanel.add(p3);
	    
	    scFrm.add(bigPanel);
	    
	    btn.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				int row=jt.getSelectedRow();
				if(row == -1){
					JOptionPane.showMessageDialog(null, "����ѡ��һ�����ݣ�");
					return;
				}
				if(row>0)
				{
					int  id=Integer.parseInt(jt.getValueAt(row, 0).toString());
					if(JOptionPane.showConfirmDialog(null, "ȷ��ɾ��ǩ����Ϣô��") != JOptionPane.OK_OPTION)return; 						
					int result=AttendanceDao.delete(id);
					
					if(result>0)
					{
 						JOptionPane.showMessageDialog(null, "ɾ���ɹ�");
								 
 						ArrayList<Attendance> tempcourses=AttendanceDao.getAll();
						updateTableData(tempcourses);
					}
					else
					{
						JOptionPane.showMessageDialog(null, "ɾ��ʧ��");
					}
					
					
					
				}
			}
		});
	    
	    btn1.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				 String studentName=comboBox.getSelectedItem().toString();
				 String courseName=comboBox2.getSelectedItem().toString();
				 Date d = new Date(); //��ǰ���� Date����
				 SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
				 String date=sdf.format(d);
				 
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
				 AttendanceDao attendanceDao=new AttendanceDao();
				 Attendance  attendance =new  Attendance();
				 attendance.setStudent_id(student_id);
				 attendance.setCourse_id(course_id);
				 attendance.setAttendance_date(date);
					 
				 int result=attendanceDao.insert(attendance);
						
				 if(result>0)
					{
						JOptionPane.showMessageDialog(null, "ǩ���ɹ�");
					}
					else
					{
						JOptionPane.showMessageDialog(null, "ǩ��ʧ��");
					}
				ArrayList<Attendance> attendances=AttendanceDao.getAll();
				updateTableData(attendances);	
				
			}
		});
	    scFrm.setResizable(false);
	    scFrm.setVisible(true);
	    
	}
	
	public void updateTableData(ArrayList<Attendance> datas)
	{
		String[][] tempData=new String[datas.size()][4];
		
		for(int i=0;i<datas.size();i++)
		{
			for(int j=0;j<4;j++)
			{
				if(j==0)
					tempData[i][j]=datas.get(i).getId()+"";
				if(j==1)
					tempData[i][j]=datas.get(i).getStudent_name();
				if(j==2)
					tempData[i][j]=datas.get(i).getCourse_name();
				if(j==3) {
					tempData[i][j]=datas.get(i).getAttendance_date();
				}
				
				
				
			}
		}
		
		DefaultTableModel tempmodel=new DefaultTableModel(tempData,columnNames);
		
	
		jt.setModel(tempmodel);

	}
	 
	 public static void main(String[] args) {
		new AttendancemgFrm();
	}
}
