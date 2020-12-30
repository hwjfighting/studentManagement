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

import dao.StudentDao;
import dao.TClassDao;
import model.SClass;
import model.Student;


public class StudentmgFrm {
	String[] columnNames = {"学生编号","学生姓名","所属班级","登录密码","学生性别"};
	JTable jt=new JTable();
	public StudentmgFrm() {
		initUI();
	}
	public void initUI() {
		JFrame jf=new JFrame("学生信息管理");
		jf.setSize(800,500);
//		jf.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		jf.setLocationRelativeTo(null);
		
		ImageIcon icon1=new ImageIcon("images/学生管理.png");
		JLabel lblStudentName=new JLabel("学生姓名：");
		lblStudentName.setIcon(icon1);
		JTextField txtStudentName=new JTextField();
		txtStudentName.setPreferredSize(new Dimension(150,25));
		
		ImageIcon icon2=new ImageIcon("images/班级名称.png");
		JLabel lblClassName=new JLabel("所属班级：");
		lblClassName.setIcon(icon2);
    
	    ArrayList<SClass> list=TClassDao.getAll();
		String[] classList=new String[list.size()];
		
		for (int i = 0; i < list.size(); i++)
		{
			classList[i]=list.get(i).getName();
		}
		
		JComboBox cboClassList=new JComboBox(classList);
	
		JButton btnSearch=new JButton("搜索",new ImageIcon("images/搜索.png"));
		
		JPanel p1=new JPanel();
		p1.setPreferredSize(new Dimension(800,60));
		p1.add(lblStudentName);
		p1.add(txtStudentName);
		p1.add(lblClassName);
		p1.add(cboClassList);
		p1.add(btnSearch);
		
		/*
		 * 表格中的学生信息
		 */
		ArrayList<Student> students=StudentDao.getAll();
		updateTableData(students);
		
		JScrollPane p2=new JScrollPane(jt);
		p2.setPreferredSize(new Dimension(600,250));
		
		 
		JLabel lblstudentNam=new JLabel("学生姓名:");
		ImageIcon icon3=new ImageIcon("images/学生管理.png");
		lblstudentNam.setIcon(icon3);
		JTextField txtstudentNam=new JTextField();
		txtstudentNam.setPreferredSize(new Dimension(150,25));
		
		
		
		ImageIcon icon4=new ImageIcon("images/班级名称.png");
		JLabel lblclassName=new JLabel("所属班级:");
		lblclassName.setIcon(icon2);

			
		JComboBox comboBox2=new JComboBox(classList);
	    comboBox2.setPreferredSize(new Dimension(145,25));
	    
	    JLabel lblstudentSex=new JLabel("学生性别:");
		ImageIcon icon5=new ImageIcon("images/性别.png");
		lblstudentSex.setIcon(icon5);
		
		JRadioButton radioBtn01 = new JRadioButton("男");
		radioBtn01.setSelected(true);
        JRadioButton radioBtn02 = new JRadioButton("女");
        JRadioButton radioBtn03 = new JRadioButton("保密");
        // 创建一个按钮组
        ButtonGroup btnGroup = new ButtonGroup();

        // 添加单选按钮到按钮组
        btnGroup.add(radioBtn01);
        btnGroup.add(radioBtn02);
        btnGroup.add(radioBtn03);
        
        JLabel lblpass=new JLabel("登录密码:");
		ImageIcon icon6=new ImageIcon("images/password.png");
		lblpass.setIcon(icon6);
		JTextField txtpass=new JTextField();
		txtpass.setPreferredSize(new Dimension(150,25));
	    
		
		JButton btnYes=new JButton("确认修改",new ImageIcon("images/确认.png"));
		JButton btnDel=new JButton("删除学生",new ImageIcon("images/删除.png"));
		
		
		JPanel p3=new JPanel();
		p3.setPreferredSize(new Dimension(300,80));
		p3.add(lblstudentNam);
		p3.add(txtstudentNam);
		p3.add(lblclassName);
		p3.add(comboBox2);
		
		JPanel p4=new JPanel();
		p4.setPreferredSize(new Dimension(250,80));
		p4.add(lblstudentSex);
		
		p4.add(radioBtn01);
		p4.add(radioBtn02);
		p4.add(radioBtn03);
		p4.add(lblpass);
		p4.add(txtpass);
		

		JPanel p5=new JPanel();
		p5.setPreferredSize(new Dimension(125,80));
		p5.add(btnYes);
		p5.add(btnDel);
		
			
		
		jf.setLayout(new FlowLayout());
		jf.add(p1);
		jf.add(p2);
		jf.add(p3);
		jf.add(p4);
		jf.add(p5);
		
		
 		jt.getSelectionModel().addListSelectionListener(new ListSelectionListener() {
 			
 			@Override
 			public void valueChanged(ListSelectionEvent e) {
 				int row=jt.getSelectedRow();
 				if(row>=0)
 				{
 					txtstudentNam.setText(jt.getValueAt(row, 1).toString());
 					comboBox2.removeAllItems();
 					comboBox2.addItem(jt.getValueAt(row, 2).toString());
 					ArrayList<SClass> list=TClassDao.getAll();
 					for (int i = 0; i < list.size(); i++)
 					{
 						comboBox2.addItem(list.get(i).getName());
 					}
 					
 					 
 					txtpass.setText(jt.getValueAt(row,3).toString());
 					String sex=jt.getValueAt(row, 4).toString();
 					if(sex.equals("男")) {
 						radioBtn01.setSelected(true);
 					}else if(sex.equals("女")) {
 						radioBtn02.setSelected(true);
 					}else if(sex.equals("保密")) {
 						radioBtn03.setSelected(true);
 					}
 				}
 				
 			}
 		});
 		btnSearch.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				String studentName=txtStudentName.getText();
				ArrayList<Student> tempstudents=StudentDao.getAllByName(studentName);
				updateTableData(tempstudents);
				String calssName=cboClassList.getSelectedItem().toString();
				ArrayList<Student> tempstudents2=StudentDao.getAllByClass(calssName);
				updateTableData(tempstudents2);
			}
		});
 		
 		btnYes.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				int row=jt.getSelectedRow();

				 int id=Integer.parseInt(jt.getValueAt(row, 0).toString());
				 String name=txtstudentNam.getText();
				 String calssName=comboBox2.getSelectedItem().toString();
				 String password=txtpass.getText();
				 String sex="";

				if(radioBtn01.isSelected())
				{
					sex="男";
				}
				else if(radioBtn02.isSelected())
				{
					sex="女";
				}
				else if(radioBtn03.isSelected())
				{
					sex="保密";
				}
				 int result=StudentDao.edit(name, calssName, password,sex,id);
				 if(result>0) {
					 JOptionPane.showMessageDialog(null, "修改成功");
					 ArrayList<Student> tempstudent=StudentDao.getAll();
					 updateTableData(tempstudent);
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
					
					int result=StudentDao.delete(id);
					if(result>0)
					{
						JOptionPane.showMessageDialog(null, "删除成功");
						ArrayList<Student> tempstudents=StudentDao.getAll();
						updateTableData(tempstudents);
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
	
	public void updateTableData(ArrayList<Student> datas)
	{
		String[][] tempData=new String[datas.size()][5];
		
		for(int i=0;i<datas.size();i++)
		{
			for(int j=0;j<5;j++)
			{
				if(j==0)
					tempData[i][j]=datas.get(i).getId()+"";
				if(j==1)
					tempData[i][j]=datas.get(i).getName();
				if(j==2)
					tempData[i][j]=datas.get(i).getClassName()+"";
				if(j==3)
					tempData[i][j]=datas.get(i).getPassword();
				if(j==4)
					tempData[i][j]=datas.get(i).getSex();
			}
		}
		
		DefaultTableModel tempmodel=new DefaultTableModel(tempData,columnNames);
		jt.setModel(tempmodel);

	}
	public static void main(String[] args) {
		new StudentmgFrm();
	}

}
