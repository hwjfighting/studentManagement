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
	String[] columnNames = {"�γ̱��", "�γ�����", "�ڿ���ʦ", "�γ��������","��ѡ����","�γ̽���"};
	JTable jt=new JTable();
	public CoursemgFrm() {
		initUI();
	}
	public void initUI() {
		JFrame jf=new JFrame("�γ���Ϣ����");
		jf.setSize(800,750);
// 		jf.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		jf.setLocationRelativeTo(null);
		
		ImageIcon icon1=new ImageIcon("images/�γ�.png");
		JLabel lblCourceName=new JLabel("�γ����ƣ�			");
		lblCourceName.setIcon(icon1);
		JTextField txtCourceName=new JTextField();
		txtCourceName.setPreferredSize(new Dimension(150,25));
		
		ImageIcon icon2=new ImageIcon("images/��ʦ.png");
		JLabel lblTeacherName=new JLabel("�ڿ���ʦ��			");
		lblTeacherName.setIcon(icon2);
	 	ArrayList<Teacher> list=TeacherDao.getAll();
		String[] teacherList=new String[list.size()];
		
		for (int i = 0; i < list.size(); i++)
		{
			teacherList[i]=list.get(i).getName();
		}
		
		JComboBox cboClassList=new JComboBox(teacherList);
    
		cboClassList.setPreferredSize(new Dimension(120,25));
	
		JButton btnSearch=new JButton("����",new ImageIcon("images/����.png"));
		
		JPanel p1=new JPanel();
		p1.setPreferredSize(new Dimension(800,60));
		p1.add(lblCourceName);
		p1.add(txtCourceName);
		p1.add(lblTeacherName);
		p1.add(cboClassList);
		p1.add(btnSearch);
		
		ArrayList<Course> courses=CourseDao.getAll();
		updateTableData(courses);
		
		
		//�������
		JScrollPane p2=new JScrollPane(jt);
		p2.setPreferredSize(new Dimension(600,300));
		
		
		ImageIcon icon3=new ImageIcon("images/�γ�.png");
		JLabel lblcourceName=new JLabel("�γ����ƣ�			");
		lblcourceName.setIcon(icon3);
		JTextField txtcourceName=new JTextField();
		txtcourceName.setPreferredSize(new Dimension(150,25));
		
		
		
		ImageIcon icon4=new ImageIcon("images/��ʦ.png");
		JLabel lblclassName=new JLabel("�ڿ���ʦ:			");
		lblclassName.setIcon(icon4);
		JComboBox cboClassList2=new JComboBox(teacherList);
		cboClassList2.setPreferredSize(new Dimension(145,25));
	    

		JPanel p3=new JPanel();
		p3.setPreferredSize(new Dimension(550,50));
		p3.add(lblcourceName);
		p3.add(txtcourceName);
		p3.add(lblclassName);
		p3.add(cboClassList2);
	    
	    ImageIcon icon5=new ImageIcon("images/����.png");
		JLabel lblstudentNum=new JLabel("ѧ��������			");
		lblstudentNum.setIcon(icon5);
		JTextField txtstudentNum=new JTextField();
		txtstudentNum.setPreferredSize(new Dimension(150,25));
		
		ImageIcon icon6=new ImageIcon("images/����.png");
		JLabel lblcourceInf=new JLabel("�γ̽��ܣ�			");
		lblcourceInf.setIcon(icon5);
		JTextArea area=new JTextArea();
		area.setPreferredSize(new Dimension(150,100));
		
		JPanel p4=new JPanel();
		p4.setPreferredSize(new Dimension(550,100));
		p4.add(lblstudentNum);
		
		p4.add(txtstudentNum);
		p4.add(lblcourceInf);
		p4.add(area);
		    
		
		JButton btnYes=new JButton("ȷ���޸�",new ImageIcon("images/ȷ��.png"));
		JButton btnDel=new JButton("ɾ���γ�",new ImageIcon("images/ɾ��.png"));
		JPanel p5=new JPanel();
		p5.setPreferredSize(new Dimension(550,50));
		p5.add(btnYes);
		p5.add(btnDel);
		
		JPanel p6=new JPanel();
		p6.setPreferredSize(new Dimension(600,275));
		p6.setBorder(BorderFactory.createTitledBorder("�༭�γ���Ϣ"));
		
		p6.add(p3);
		p6.add(p4);
		p6.add(p5);
		
		FlowLayout flowLayout = new FlowLayout();
		flowLayout.setVgap(10);//�����ֱ���
		flowLayout.setHgap(10);//ˮƽ���
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
					 JOptionPane.showMessageDialog(null, "�޸ĳɹ�");
					 ArrayList<Course> tempcourse=CourseDao.getAll();
					 updateTableData(tempcourse);
				 }else {
					JOptionPane.showMessageDialog(null, "�޸�ʧ��");
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
						JOptionPane.showMessageDialog(null, "ɾ���ɹ�");
						ArrayList<Course> tempcourses=CourseDao.getAll();
						updateTableData(tempcourses);
					}
					else
					{
						JOptionPane.showMessageDialog(null, "ɾ��ʧ��");
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
