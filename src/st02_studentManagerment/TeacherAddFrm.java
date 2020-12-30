package st02_studentManagerment;

import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.*;

import dao.StudentDao;
import dao.TClassDao;
import dao.TeacherDao;
import model.SClass;
import model.Student;
import model.Teacher;

public class TeacherAddFrm {

	public TeacherAddFrm() {
		initUI();
	}
	
	public void initUI() {
		Dimension dim1=new Dimension(500,40);
		Dimension dim2=new Dimension(150,25);
		
		JFrame stadfrm=new JFrame("添加教师");
		stadfrm.setSize(500,400);
		stadfrm.setLocationRelativeTo(null);
//		stadfrm.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		JPanel bigPanel=new JPanel();
		
		JPanel p1=new JPanel();
		p1.setPreferredSize(dim1);
		JPanel p2=new JPanel();
		p2.setPreferredSize(dim1);
		JPanel p3=new JPanel();
		p3.setPreferredSize(dim1);
		JPanel p4=new JPanel();
		p4.setPreferredSize(dim1);
		JPanel p5=new JPanel();
		p5.setPreferredSize(dim1);
		JPanel p6=new JPanel();
		p6.setPreferredSize(dim1);
		
		JLabel lblteacherName=new JLabel("教师姓名:",new ImageIcon("images/老师.png"),0);
		JTextField txtteacherName=new JTextField();
		txtteacherName.setPreferredSize(dim2);
		
		p1.add(lblteacherName);
		p1.add(txtteacherName);
		
		JLabel lblteacherSex=new JLabel("教师\t\t\t性别:",new ImageIcon("images/性别.png"),0);
		JRadioButton boy=new JRadioButton("男");
		boy.setSelected(true);
		JRadioButton girl=new JRadioButton("女");
		
		ButtonGroup btnGroup = new ButtonGroup();
		btnGroup.add(boy);
		btnGroup.add(girl);
		
		p2.add(lblteacherSex);
		
		p2.add(boy);
		p2.add(girl);
		
		JLabel lblteacherTitle=new JLabel("教师职称:",new ImageIcon("images/职称评定.png"),0);
		JTextField txtteacherTitle=new JTextField();
		txtteacherTitle.setPreferredSize(dim2);
		
		p3.add(lblteacherTitle);
		p3.add(txtteacherTitle);
		
		JLabel lblteacherAge=new JLabel("教师年龄:",new ImageIcon("images/年龄.png"),0);
		JTextField txtteacherAge=new JTextField();
		txtteacherAge.setPreferredSize(dim2);
		
		p4.add(lblteacherAge);
		p4.add(txtteacherAge);
		
		JLabel lblPass=new JLabel("教师密码:",new ImageIcon("images/密码.png"),0);
		JTextField txtPass=new JTextField();
		txtPass.setPreferredSize(dim2);
		
		p5.add(lblPass);
		p5.add(txtPass);
		
		JButton btn1=new JButton("确认添加");
		JButton btn2=new JButton("重置表单");
		

		p6.add(btn1);
		p6.add(btn2);
	
		
		bigPanel.add(p1);
		bigPanel.add(p2);
		bigPanel.add(p3);
		bigPanel.add(p4);
		bigPanel.add(p5);
		bigPanel.add(p6);
		
		
		stadfrm.add(bigPanel);
		
		btn1.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				String name=txtteacherName.getText();
				String title=txtteacherTitle.getText();
				int age=Integer.parseInt(txtteacherAge.getText());
				String password=txtPass.getText();
				 
				
				 
				String sex="";
				
				if(boy.isSelected())
				{
					sex="男";
				}
				else if(girl.isSelected())
				{
					sex="女";
				}
				 
				
				TeacherDao td=new TeacherDao();
				
				Teacher teachers =new Teacher();
				teachers.setName(name);
				teachers.setSex(sex);
				teachers.setTitle(title);
				teachers.setAge(age);
				teachers.setPassword(password);
				
				//
				int result=td.insert(teachers);
				
				if(result>0)
				{
					JOptionPane.showMessageDialog(null, "成功添加老师");
				}
				else
				{
					JOptionPane.showMessageDialog(null, "添加老师失败");
				}
				
				
			}
		});
		
		btn2.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				txtteacherName.setText(null);
				txtteacherTitle.setText(null);
				txtteacherAge.setText(null);
				txtPass.setText(null);
			}
		});
		
		stadfrm.setResizable(false);
		stadfrm.setVisible(true);
	}

	public static void main(String[] args) {
		new  TeacherAddFrm();

	}

}
