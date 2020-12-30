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

import dao.TClassDao;
import dao.TeacherDao;
import model.SClass;
import model.Teacher;

public class TeachermgFrm {
	String[] columnNames = {"教师id","教师姓名","教师性别","教师职称","教师年龄","登录密码"};
	JTable jt=new JTable();
	public TeachermgFrm() {
		initUI();
	}
	public void initUI() {
		JFrame jf=new JFrame("教师信息管理");
		jf.setSize(700,550);
//		jf.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		jf.setLocationRelativeTo(null);
		
		JLabel lblClassName=new JLabel("教师姓名：				");
		ImageIcon icon=new ImageIcon("images/老师.png");
		lblClassName.setIcon(icon);
		JTextField txtTeacherName=new JTextField();
		txtTeacherName.setPreferredSize(new Dimension(150,25));
		JButton btnSearch=new JButton("搜索",new ImageIcon("images/搜索.png"));
		
		JPanel p1=new JPanel();
		p1.setPreferredSize(new Dimension(600,80));
		p1.add(lblClassName);
		p1.add(txtTeacherName);
		p1.add(btnSearch);
		
		
      
		 ArrayList<Teacher> teachers=TeacherDao.getAll();
	     
		updateTableData(teachers);
		JScrollPane p2=new JScrollPane(jt);
		p2.setPreferredSize(new Dimension(600,200));
		
		
		JLabel lblteacherNam=new JLabel("教师姓名:		");
		lblteacherNam.setIcon(icon);
		JTextField txtteacherNam=new JTextField();
		txtteacherNam.setPreferredSize(new Dimension(150,25));

		JLabel lblteacherRank=new JLabel("教师职称:		");
		ImageIcon icon2=new ImageIcon("images/职称评定.png");
		lblteacherRank.setIcon(icon2);
		JTextField txtteacherRank=new JTextField();
		txtteacherRank.setPreferredSize(new Dimension(150,25));

		JLabel lblpass=new JLabel("登录密码:		");
		ImageIcon icon3=new ImageIcon("images/密码.png");
		lblpass.setIcon(icon3);
		JTextField txtpass=new JTextField();
		txtpass.setPreferredSize(new Dimension(150,25));
		
		JLabel lblteachertSex=new JLabel("教师性别:			");
		ImageIcon icon4=new ImageIcon("images/性别.png");
		lblteachertSex.setIcon(icon4);
		
		JRadioButton radioBtn01 = new JRadioButton("男");
		radioBtn01.setSelected(true);
        JRadioButton radioBtn02 = new JRadioButton("女");
        
        // 创建一个按钮组
        ButtonGroup btnGroup = new ButtonGroup();

        // 添加单选按钮到按钮组
        btnGroup.add(radioBtn01);
        btnGroup.add(radioBtn02);
      
        JLabel lblteacherAge=new JLabel("教师年龄:		");
		ImageIcon icon5=new ImageIcon("images/年龄.png");
		lblteacherAge.setIcon(icon5);
		JTextField txtteacherAge=new JTextField();
		txtteacherAge.setPreferredSize(new Dimension(100,25));
        
		
		JButton btnYes=new JButton("确认修改",new ImageIcon("images/确认.png"));
		JButton btnDel=new JButton("删除",new ImageIcon("images/删除.png"));
		
		
		JPanel p3=new JPanel();
		p3.setPreferredSize(new Dimension(250,150));
		p3.add(lblteacherNam);
		p3.add(txtteacherNam);
		p3.add(lblteacherRank);
		p3.add(txtteacherRank);
		p3.add(lblpass);
		p3.add(txtpass);
		
		
		JPanel p4=new JPanel();
		p4.setPreferredSize(new Dimension(250,150));
		p4.add(lblteachertSex);
		p4.add(radioBtn01);
		p4.add(radioBtn02);
		p4.add(lblteacherAge);
		p4.add(txtteacherAge);
		
		p4.add(btnYes);
		p4.add(btnDel);


		JPanel p5=new JPanel();
		p5.setBorder(BorderFactory.createTitledBorder("教师信息修改"));
		p5.setPreferredSize(new Dimension(600,200));
		p5.add(p3);
		p5.add(p4);
		
			
		
		jf.setLayout(new FlowLayout());
		jf.add(p1);
		jf.add(p2);
		jf.add(p5);
// 		jf.add(p4);
		
		FlowLayout flowLayout = new FlowLayout();
	    flowLayout.setVgap(10);//组件垂直间距
	    flowLayout.setHgap(10);//水平间距
	    
	    p3.setLayout(flowLayout);
	    p4.setLayout(flowLayout);
	    p5.setLayout(flowLayout);
	    
	    jt.getSelectionModel().addListSelectionListener(new ListSelectionListener() 
		{
			
			@Override
			public void valueChanged(ListSelectionEvent arg0) 
			{
				
				int row=jt.getSelectedRow();

				if(row>=0)
				{
					txtteacherNam.setText(jt.getValueAt(row, 1).toString());
					txtteacherRank.setText(jt.getValueAt(row, 3).toString());
					txtpass.setText(jt.getValueAt(row, 5).toString());
					txtteacherAge.setText(jt.getValueAt(row, 4).toString());
					String sex=jt.getValueAt(row, 2).toString();
 					if(sex.equals("男")) {
 						radioBtn01.setSelected(true);
 					}else if(sex.equals("女")) {
 						radioBtn02.setSelected(true);
 					} 
					
				}
			}
		});
	    
	    btnSearch.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				String teacherName=txtTeacherName.getText();
				ArrayList<Teacher> tempteachers=TeacherDao.getAllByName(teacherName);
				updateTableData(tempteachers);
				
			}
		});
	    
	    btnYes.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				 int row=jt.getSelectedRow();

				 int teacherId=Integer.parseInt(jt.getValueAt(row, 0).toString());
				 String name=txtteacherNam.getText();
				 String title=txtteacherRank.getText();
				 String password=txtpass.getText();
				 int age=Integer.parseInt(txtteacherAge.getText().toString());
				 String sex="";

					if(radioBtn01.isSelected())
					{
						sex="男";
					}
					else if(radioBtn02.isSelected())
					{
						sex="女";
					}
				 int result=TeacherDao.edit(name, title, password,sex,age,teacherId);
				 if(result>0) {
					 JOptionPane.showMessageDialog(null, "修改成功");
					 ArrayList<Teacher> tempteachers=TeacherDao.getAll();
					 updateTableData(tempteachers);
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
					int teacherId=Integer.parseInt(jt.getValueAt(row, 0).toString());
					
					int result=TeacherDao.delete(teacherId);
					if(result>0)
					{
						JOptionPane.showMessageDialog(null, "删除成功");
						ArrayList<Teacher> tempteachers=TeacherDao.getAll();
						updateTableData(tempteachers);
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
	public void updateTableData(ArrayList<Teacher> datas)
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
					tempData[i][j]=datas.get(i).getSex();
				if(j==3)
					tempData[i][j]=datas.get(i).getTitle();
				if(j==4)
					tempData[i][j]=datas.get(i).getAge()+"";
				if(j==5)
					tempData[i][j]=datas.get(i).getPassword();
			}
		}
		
		DefaultTableModel tempmodel=new DefaultTableModel(tempData,columnNames);
		jt.setModel(tempmodel);

	}
	public static void main(String[] args) {
		new TeachermgFrm();
	}
}
