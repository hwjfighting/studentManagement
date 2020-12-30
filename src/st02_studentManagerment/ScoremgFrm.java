package st02_studentManagerment;

import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

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
import javax.swing.JTextField;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import javax.swing.table.DefaultTableModel;

import dao.AttendanceDao;
import dao.CourseDao;
import dao.ScoreDao;
import dao.SelectedCourseDao;
import dao.StudentDao;
import model.Attendance;
import model.Course;
import model.Score;
import model.SelectedCourse;
import model.Student;

public class ScoremgFrm {
	String[] columnNames = {"成绩ID","学生姓名","课程名称","成绩"};
	JTable jt=new JTable();

	public ScoremgFrm() {
		initUI() ;
	}
	
	public void initUI() {
		
		Dimension dim1=new Dimension(125,25);
		Dimension dim2=new Dimension(600,300); 
		Dimension dim3=new Dimension(800,50);
		Dimension dim4=new Dimension(600,100);
		
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
		p3.setBorder(BorderFactory.createTitledBorder("修改成绩"));
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
	    JButton btn1=new JButton("查询",new ImageIcon("images/确认.png"));
	    btn1.setPreferredSize(dim1);
	    
	    ArrayList<Score> scores=ScoreDao.getAll();
		updateTableData(scores);
		
		JScrollPane p2=new JScrollPane(jt);
		p2.setPreferredSize(dim2);
		
		JLabel lblScore =new JLabel("成绩：",new ImageIcon("images/成绩.png"),0);
		JTextField txtScore=new JTextField();
		txtScore.setPreferredSize(dim1);
		
		JButton btn2=new JButton("确认修改",new ImageIcon("images/确认.png"));
		btn2.setPreferredSize(dim1);
		JButton btn3=new JButton("删除成绩",new ImageIcon("images/删除.png"));
		btn3.setPreferredSize(dim1);
	    
	    p1.add(lblStudentName);
	    p1.add(comboBox);
	    p1.add(lblCourseName);
	    p1.add(comboBox2);
	    p1.add(btn1);
	    
	    p3.add(lblScore);
	    p3.add(txtScore);
	    p3.add(btn2);
	    p3.add(btn3);
	    
	    FlowLayout flowLayout = new FlowLayout();
	    flowLayout.setVgap(10);//组件垂直间距
	    flowLayout.setHgap(20);//水平间距
	    
	    p3.setLayout(flowLayout);
	    
	    bigPanel.add(p1);
	    bigPanel.add(p2);
	    bigPanel.add(p3);
	    
	     
	    scFrm.add(bigPanel);
	    
	    
	    jt.getSelectionModel().addListSelectionListener(new ListSelectionListener() {
 			
 			@Override
 			public void valueChanged(ListSelectionEvent e) {
 				int row=jt.getSelectedRow();
 				if(row>=0)
 				{
 					txtScore.setText(jt.getValueAt(row, 3).toString()); 
 				}
 				
 			}
 		});
	    
	    btn1.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				String studentName=comboBox.getSelectedItem().toString();
				String courseName=comboBox2.getSelectedItem().toString();
				 
				  ArrayList<Score> scores=ScoreDao.getByInfo(studentName,courseName );
				  updateTableData(scores);
				
			}
		});
	    
	    btn2.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				int score=Integer.parseInt(txtScore.getText());
				int row=jt.getSelectedRow();
				int id=Integer.parseInt(jt.getValueAt(row, 0).toString());
				 int result=ScoreDao.edit(score,id);
				 if(result>0) {
					 JOptionPane.showMessageDialog(null, "修改成功");
					 ArrayList<Score> tempscore=ScoreDao.getAll();
					 updateTableData(tempscore);
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
					
					int result=ScoreDao.delete(id);
					if(result>0)
					{
						JOptionPane.showMessageDialog(null, "删除成功");
						ArrayList<Score> tempScore=ScoreDao.getAll();
						updateTableData(tempScore);
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
	
	
	
	public void updateTableData(ArrayList<Score> datas)
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
					tempData[i][j]=datas.get(i).getScore()+"";
				}
				
				
				
			}
		}
		
		DefaultTableModel tempmodel=new DefaultTableModel(tempData,columnNames);
		
		
		jt.setModel(tempmodel);

	}
	
	public static void main(String[] args) {
		new ScoremgFrm();
	}	    

}
