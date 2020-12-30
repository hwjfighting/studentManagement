package st02_studentManagerment;

import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.ButtonGroup;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JRadioButton;
import javax.swing.JTextField;
import javax.swing.SwingConstants;

import dao.StudentDao;
import dao.TClassDao;
import model.SClass;
import model.Student;

/**
 * 学生添加界面
 * @author Administrator
 *
 */
public class StudentAddFrm
{

	public StudentAddFrm()
	{
		initUI();
	}
	
	public void initUI()			//user interface 人机界面
	{
		Dimension dim=new Dimension(400,60);
		Dimension dim1=new Dimension(150,30);
		
		JFrame jf=new JFrame("添加学生信息");
		jf.setSize(400,360);
		jf.setLocationRelativeTo(null);
		
		JPanel bigPanel=new JPanel();
		JPanel p01=new JPanel();
		JPanel p02=new JPanel();
		JPanel p03=new JPanel();
		JPanel p04=new JPanel();
		JPanel p05=new JPanel();
		
		//设置Panel的大小
		p01.setPreferredSize(dim);
		p02.setPreferredSize(dim);
		p03.setPreferredSize(dim);
		p04.setPreferredSize(dim);
		p05.setPreferredSize(dim);
		
		JLabel lblStuName=new JLabel("姓名",new ImageIcon("images/学生管理.png"),SwingConstants.LEFT);
		JLabel lblClassId=new JLabel("班级",new ImageIcon("images/班级名称.png"),SwingConstants.LEFT);
		JLabel lblStuPwd=new JLabel("密码",new ImageIcon("images/密码.png"),SwingConstants.LEFT);
		JLabel lblStuSexy=new JLabel("性别",new ImageIcon("images/性别.png"),SwingConstants.LEFT);
		
		JTextField txtStuName=new JTextField();
		//new String[]{"","",""}
//		JComboBox cboClassList=new JComboBox(new String[]{"软件一班","网络一班","计算机科学与技术一班"});

		ArrayList<SClass> list=TClassDao.getAll();
		String[] classList=new String[list.size()];
		
		for (int i = 0; i < list.size(); i++)
		{
			classList[i]=list.get(i).getName();
		}
		
		JComboBox cboClassList=new JComboBox(classList);
		JPasswordField pwd=new JPasswordField();
		JRadioButton rdoBtnBoy=new JRadioButton("男");
		rdoBtnBoy.setSelected(true);
		JRadioButton rdoBtnGirl=new JRadioButton("女");
		JRadioButton rdoBtnSecret=new JRadioButton("保密");
		JButton btnConfirm=new JButton("确认",new ImageIcon("images/确认.png"));
		JButton btnReSet=new JButton("重置",new ImageIcon("images/重置.png"));
		
		//创建按钮组，把三个单选按钮添加到该组
		ButtonGroup btnGroup = new ButtonGroup();
		btnGroup.add(rdoBtnBoy);
		btnGroup.add(rdoBtnGirl);
		btnGroup.add(rdoBtnSecret);
		
		
		//设置空间的大小
		txtStuName.setPreferredSize(dim1);
		pwd.setPreferredSize(dim1);
		cboClassList.setPreferredSize(dim1);
		
		p01.add(lblStuName);
		p01.add(txtStuName);
		
		p02.add(lblClassId);
		p02.add(cboClassList);
		
		p03.add(lblStuPwd);
		p03.add(pwd);
		
		p04.add(lblStuSexy);
		p04.add(rdoBtnBoy);
		p04.add(rdoBtnGirl);
		p04.add(rdoBtnSecret);
		
		p05.add(btnConfirm);
		p05.add(btnReSet);
		
		bigPanel.add(p01);
		bigPanel.add(p02);
		bigPanel.add(p03);
		bigPanel.add(p04);
		bigPanel.add(p05);
		
		jf.add(bigPanel);
		
		btnConfirm.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				String stuName=txtStuName.getText();
				String className=cboClassList.getSelectedItem().toString();
				int classId=0;
				
				ArrayList<SClass> list=TClassDao.getAll();
				for (int i = 0; i < list.size(); i++)
				{
					
					if(list.get(i).getName().equals(className))
					{
						classId=list.get(i).getId();
						break;
					}
					
				}
				
				
				String password=pwd.getText();
				String sex="";
				
				if(rdoBtnBoy.isSelected())
				{
					sex="男";
				}
				else if(rdoBtnGirl.isSelected())
				{
					sex="女";
				}
				else if(rdoBtnSecret.isSelected())
				{
					sex="保密";
				}
				
				StudentDao studentDao=new StudentDao();
				
				Student student =new Student();
				student.setName(stuName);
				student.setClassId(classId);
				student.setPassword(password);
				student.setSex(sex);
				//
				int result=studentDao.insert(student);
				
				if(result>0)
				{
					JOptionPane.showMessageDialog(null, "成功添加学生");
				}
				else
				{
					JOptionPane.showMessageDialog(null, "添加学生失败");
				}
				
			}
		});
		
		btnReSet.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				txtStuName.setText(null);
				pwd.setText(null);
			}
		});
		
		jf.setResizable(false);
		jf.setVisible(true);
	}

	public static void main(String[] args)
	{
		StudentAddFrm saf=new StudentAddFrm();
	}
}
