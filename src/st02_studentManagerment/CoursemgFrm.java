package st02_studentManagerment;

import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.BorderFactory;
import javax.swing.ButtonGroup;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import javax.swing.table.DefaultTableModel;

import dao.CourseDao;
import dao.StudentDao;
import dao.TClassDao;
import dao.TeacherDao;
import model.Course;
import model.SClass;
import model.Student;
import model.Teacher;

public class CoursemgFrm {
	String[] columnNames = {"课程编号", "课程名称", "授课老师", "课程最大人数","已选人数","课程介绍"};
	JTable jt=new JTable();
	public CoursemgFrm() {
		initUI();
	}
	public void initUI() {
		JFrame jf=new JFrame("课程信息管理");
		jf.setSize(800,750);
// 		jf.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		jf.setLocationRelativeTo(null);
		
		ImageIcon icon1=new ImageIcon("images/课程.png");
		JLabel lblCourceName=new JLabel("课程名称：			");
		lblCourceName.setIcon(icon1);
		JTextField txtCourceName=new JTextField();
		txtCourceName.setPreferredSize(new Dimension(150,25));
		
		ImageIcon icon2=new ImageIcon("images/老师.png");
		JLabel lblTeacherName=new JLabel("授课老师：			");
		lblTeacherName.setIcon(icon2);
	 	ArrayList<Teacher> list=TeacherDao.getAll();
		String[] teacherList=new String[list.size()];
		
		for (int i = 0; i < list.size(); i++)
		{
			teacherList[i]=list.get(i).getName();
		}
		
		JComboBox cboClassList=new JComboBox(teacherList);
    
		cboClassList.setPreferredSize(new Dimension(120,25));
	
		JButton btnSearch=new JButton("搜索",new ImageIcon("images/搜索.png"));
		
		JPanel p1=new JPanel();
		p1.setPreferredSize(new Dimension(800,60));
		p1.add(lblCourceName);
		p1.add(txtCourceName);
		p1.add(lblTeacherName);
		p1.add(cboClassList);
		p1.add(btnSearch);
		
		ArrayList<Course> courses=CourseDao.getAll();
		updateTableData(courses);
		
		
		//滚动面板
		JScrollPane p2=new JScrollPane(jt);
		p2.setPreferredSize(new Dimension(600,300));
		
		
		ImageIcon icon3=new ImageIcon("images/课程.png");
		JLabel lblcourceName=new JLabel("课程名称：			");
		lblcourceName.setIcon(icon3);
		JTextField txtcourceName=new JTextField();
		txtcourceName.setPreferredSize(new Dimension(150,25));
		
		
		
		ImageIcon icon4=new ImageIcon("images/老师.png");
		JLabel lblclassName=new JLabel("授课老师:			");
		lblclassName.setIcon(icon4);
		JComboBox cboClassList2=new JComboBox(teacherList);
		cboClassList2.setPreferredSize(new Dimension(145,25));
	    

		JPanel p3=new JPanel();
		p3.setPreferredSize(new Dimension(550,50));
		p3.add(lblcourceName);
		p3.add(txtcourceName);
		p3.add(lblclassName);
		p3.add(cboClassList2);
	    
	    ImageIcon icon5=new ImageIcon("images/人数.png");
		JLabel lblstudentNum=new JLabel("学生人数：			");
		lblstudentNum.setIcon(icon5);
		JTextField txtstudentNum=new JTextField();
		txtstudentNum.setPreferredSize(new Dimension(150,25));
		
		ImageIcon icon6=new ImageIcon("images/介绍.png");
		JLabel lblcourceInf=new JLabel("课程介绍：			");
		lblcourceInf.setIcon(icon5);
		JTextArea area=new JTextArea();
		area.setPreferredSize(new Dimension(150,100));
		
		JPanel p4=new JPanel();
		p4.setPreferredSize(new Dimension(550,100));
		p4.add(lblstudentNum);
		
		p4.add(txtstudentNum);
		p4.add(lblcourceInf);
		p4.add(area);
		    
		
		JButton btnYes=new JButton("确认修改",new ImageIcon("images/确认.png"));
		JButton btnDel=new JButton("删除课程",new ImageIcon("images/删除.png"));
		JPanel p5=new JPanel();
		p5.setPreferredSize(new Dimension(550,50));
		p5.add(btnYes);
		p5.add(btnDel);
		
		JPanel p6=new JPanel();
		p6.setPreferredSize(new Dimension(600,275));
		p6.setBorder(BorderFactory.createTitledBorder("编辑课程信息"));
		
		p6.add(p3);
		p6.add(p4);
		p6.add(p5);
		
		FlowLayout flowLayout = new FlowLayout();
		flowLayout.setVgap(10);//组件垂直间距
		flowLayout.setHgap(10);//水平间距
		p3.setLayout(flowLayout);
		p4.setLayout(flowLayout);
		p5.setLayout(flowLayout); 
		p6.setLayout(flowLayout); 
		
		jf.add(p1);
		jf.add(p2);
		jf.add(p6);
//		jf.add(p4);
// 		jf.add(p5);
		jf.setLayout(flowLayout);
		
		jt.getSelectionModel().addListSelectionListener(new ListSelectionListener() {
 			
 			@Override
 			public void valueChanged(ListSelectionEvent e) {
 				int row=jt.getSelectedRow();
 				if(row>=0)
 				{
 					txtcourceName.setText(jt.getValueAt(row, 1).toString());
 					cboClassList2.removeAllItems();
 					cboClassList2.addItem(jt.getValueAt(row, 2).toString());
 					ArrayList<Teacher> list=TeacherDao.getAll();
 					for (int i = 0; i < list.size(); i++)
 					{
 						cboClassList2.addItem(list.get(i).getName());
 					}
 					
 					     
 					txtstudentNum.setText(jt.getValueAt(row,4).toString());
 					area.setText(jt.getValueAt(row,5).toString());
 					 
 				}
 				
 			}
 		});
		
		btnSearch.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				String courseName=txtCourceName.getText();
				ArrayList<Course> tempcourses=CourseDao.getAllByName(courseName);
				updateTableData(tempcourses);
				String teacherName=cboClassList.getSelectedItem().toString();
				ArrayList<Course> tempstudents2=CourseDao.getAllByTeacher(teacherName);
				updateTableData(tempstudents2);
				
			}
		});
		
		btnYes.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				int row=jt.getSelectedRow();

				 int id=Integer.parseInt(jt.getValueAt(row, 0).toString());
				 String name=txtcourceName.getText();
				 String teacherName=cboClassList2.getSelectedItem().toString();
				 int  selected_num=Integer.parseInt(txtstudentNum.getText().toString());
				 String info=area.getText();

				 
				 int result=CourseDao.edit(name, teacherName,info,selected_num,id);
				 if(result>0) {
					 JOptionPane.showMessageDialog(null, "修改成功");
					 ArrayList<Course> tempcourse=CourseDao.getAll();
					 updateTableData(tempcourse);
				 }else {
					JOptionPane.showMessageDialog(null, "修改失败");
				 }
				
			}
		});
		
		btnDel.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				int row=jt.getSelectedRow();
				if(row>0)
				{
					int  id=Integer.parseInt(jt.getValueAt(row, 0).toString());
					
					int result=CourseDao.delete(id);
					if(result>0)
					{
						JOptionPane.showMessageDialog(null, "删除成功");
						ArrayList<Course> tempcourses=CourseDao.getAll();
						updateTableData(tempcourses);
					}
					else
					{
						JOptionPane.showMessageDialog(null, "删除失败");
					}
				}
				
			}
		});
		jf.setResizable(false);
		jf.setVisible(true);
		
	}
	
	public void updateTableData(ArrayList<Course> datas)
	{
		String[][] tempData=new String[datas.size()][6];
		
		for(int i=0;i<datas.size();i++)
		{
			for(int j=0;j<6;j++)
			{
				if(j==0)
					tempData[i][j]=datas.get(i).getId()+"";
				if(j==1)
					tempData[i][j]=datas.get(i).getName();
				if(j==2)
					tempData[i][j]=datas.get(i).getTeacher_name();
				if(j==3)
					tempData[i][j]=datas.get(i).getMax_student_num()+"";
				if(j==4)
					tempData[i][j]=datas.get(i).getSelected_num()+"";
				if(j==5)
					tempData[i][j]=datas.get(i).getInfo()+"";
			}
		}
		
		DefaultTableModel tempmodel=new DefaultTableModel(tempData,columnNames);
		
		
		jt.setModel(tempmodel);

	}
	public static void main(String[] args) {
		new CoursemgFrm();
	}

}
