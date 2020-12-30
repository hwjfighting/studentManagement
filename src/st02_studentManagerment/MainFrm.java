package st02_studentManagerment;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.*;



public class MainFrm {

	public MainFrm() {
		initUI();
	}
	
	public void initUI(){
		JFrame jf=new JFrame();
		jf.setTitle("学生信息系统登录界面");
		jf.setSize(1200, 800);
		jf.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		jf.setLocationRelativeTo(null);
		
		//菜单
		JMenu systemSetting=new JMenu("系统设置");
		JMenu studentmg=new JMenu("学生管理");
		JMenu classmg=new JMenu("班级管理");
		JMenu teachermg=new JMenu("教师管理");
		JMenu coursemg=new JMenu("课程管理");
		JMenu selectmg=new JMenu("选课管理");
		JMenu siging=new JMenu("签到考勤");
		JMenu grademg=new JMenu("成绩管理");
		JMenu help=new JMenu("帮助");
		
		
		//菜单上的图标
		systemSetting.setIcon(new ImageIcon("images/系统设置.png"));
		studentmg.setIcon(new ImageIcon("images/学生管理.png"));
		classmg.setIcon(new ImageIcon("images/班级管理.png"));
		teachermg.setIcon(new ImageIcon("images/老师.png"));
		coursemg.setIcon(new ImageIcon("images/课程.png"));
		selectmg.setIcon(new ImageIcon("images/选择.png"));
		siging.setIcon(new ImageIcon("images/签到.png"));
		grademg.setIcon(new ImageIcon("images/成绩.png"));
		help.setIcon(new ImageIcon("images/帮助.png"));
		
		//菜单项
		JMenuItem systemSetting01=new JMenuItem("修改密码",new ImageIcon("images/修改密码.png"));
		JMenuItem systemSetting02=new JMenuItem("退出系统",new ImageIcon("images/退出.png"));
		systemSetting.add(systemSetting01);
		systemSetting.add(systemSetting02);
		
		JMenuItem stuitem01=new JMenuItem("添加学生",new ImageIcon("images/添加.png"));
		JMenuItem stuitem02=new JMenuItem("学生列表",new ImageIcon("images/列表.png"));
		studentmg.add(stuitem01);
		studentmg.add(stuitem02);
		
		JMenuItem classitem01=new JMenuItem("班级添加",new ImageIcon("images/添加.png"));
		JMenuItem classitem02=new JMenuItem("班级管理",new ImageIcon("images/班级管理.png"));
		classmg.add(classitem01);
		classmg.add(classitem02);
		
		JMenuItem teacheritem01=new JMenuItem("添加教师",new ImageIcon("images/添加.png"));
		JMenuItem teacheritem02=new JMenuItem("教师列表",new ImageIcon("images/列表.png"));
		teachermg.add(teacheritem01);
		teachermg.add(teacheritem02);
		
		JMenuItem courseitem01=new JMenuItem("添加课程",new ImageIcon("images/添加.png"));
		JMenuItem courseitem02=new JMenuItem("课程列表",new ImageIcon("images/列表.png"));
		coursemg.add(courseitem01);
		coursemg.add(courseitem02);
		
		JMenuItem selectitem01=new JMenuItem("选课管理",new ImageIcon("images/选择.png"));
		selectmg.add(selectitem01);
		
		JMenuItem siging01=new JMenuItem("学生签到",new ImageIcon("images/签到.png"));
		JMenuItem siging02=new JMenuItem("签到管理",new ImageIcon("images/签到列表.png"));
		JMenuItem siging03=new JMenuItem("签到统计",new ImageIcon("images/统计.png"));
		siging.add(siging01);
		siging.add(siging02);
		siging.add(siging03);
		
		
		JMenuItem gradeitem01=new JMenuItem("录入成绩",new ImageIcon("images/添加.png"));
		JMenuItem gradeitem02=new JMenuItem("成绩查看",new ImageIcon("images/查看.png"));
		JMenuItem gradeitem03=new JMenuItem("成绩管理",new ImageIcon("images/成绩.png"));
		JMenuItem gradeitem04=new JMenuItem("成绩统计",new ImageIcon("images/统计.png"));
		grademg.add(gradeitem01);
		grademg.add(gradeitem02);
		grademg.add(gradeitem03);
		grademg.add(gradeitem04);
		
		
		JMenuItem helpitem01=new JMenuItem("关于我们",new ImageIcon("images/关于我们.png"));
		
		help.add(helpitem01);
		
		
		
		
		//菜单栏
		JMenuBar mb=new JMenuBar();
		mb.add(systemSetting);
		mb.add(studentmg);
		mb.add(classmg);
		mb.add(teachermg);
		mb.add(coursemg);
		mb.add(selectmg);
		mb.add(siging);
		mb.add(grademg);
		mb.add(help);
		
		Color c=new Color(0,128,128);
		JPanel mainPanel=new JPanel();
		mainPanel.setBackground(c);
		
		jf.add(mainPanel);
		
		
		classitem01.addActionListener(new ActionListener()
		{
			
			@Override
			public void actionPerformed(ActionEvent e)
			{
				ClassAddFrm caf=new ClassAddFrm();
				
			}
		});
		classitem02.addActionListener(new ActionListener()
		{
			
			@Override
			public void actionPerformed(ActionEvent e)
			{
				ClassmgFrm  cmf=new ClassmgFrm();
				
			}
		});
		stuitem01.addActionListener(new ActionListener()
		{
			
			@Override
			public void actionPerformed(ActionEvent e)
			{
				StudentAddFrm  smf=new StudentAddFrm();
				
			}
		});
		stuitem02.addActionListener(new ActionListener()
		{
			
			@Override
			public void actionPerformed(ActionEvent e)
			{
				StudentmgFrm  smf=new StudentmgFrm();
				
			}
		});
		systemSetting01.addActionListener(new ActionListener()
		{
			
			@Override
			public void actionPerformed(ActionEvent e)
			{
				ChangePassFrm smf=new ChangePassFrm();
				
			}
		});
		systemSetting02.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				if(JOptionPane.showConfirmDialog(null, "确定退出么？") == JOptionPane.OK_OPTION){
					System.exit(0);
				}
			}
		});
		teacheritem01.addActionListener(new ActionListener()
		{
			
			@Override
			public void actionPerformed(ActionEvent e)
			{
				TeacherAddFrm  smf=new TeacherAddFrm();
				
			}
		});
		teacheritem02.addActionListener(new ActionListener()
		{
			
			@Override
			public void actionPerformed(ActionEvent e)
			{
				TeachermgFrm  smf=new TeachermgFrm();
				
			}
		});
		
		courseitem01.addActionListener(new ActionListener()
		{
			
			@Override
			public void actionPerformed(ActionEvent e)
			{
				CourseAddFrm  smf=new CourseAddFrm();
				
			}
		});
		courseitem02.addActionListener(new ActionListener()
		{
			
			@Override
			public void actionPerformed(ActionEvent e)
			{
				CoursemgFrm  smf=new CoursemgFrm();
				
			}
		});
		
		selectitem01.addActionListener(new ActionListener()
		{
			
			@Override
			public void actionPerformed(ActionEvent e)
			{
				SelectCourseFrm  smf=new SelectCourseFrm();
				 
			}
		});
		//
		helpitem01.addActionListener(new ActionListener()
		{
			
			@Override
			public void actionPerformed(ActionEvent e)
			{
				AboutUsFrm  smf=new AboutUsFrm();
				
			}
		});
		siging02.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				 AttendancemgFrm stmg=new AttendancemgFrm();
				
			}
		});
		
		gradeitem01.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				 AddScore as=new AddScore();
				
			}
		});
		gradeitem03.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				 ScoremgFrm smf=new ScoremgFrm();
				
			}
		});
		gradeitem04.addActionListener(new ActionListener() {
	
			@Override
			public void actionPerformed(ActionEvent e) {
				 ScoreStatisticsFrm ss=new ScoreStatisticsFrm(); 
		
			}
});
		
		
		jf.setJMenuBar(mb);
		jf.setResizable(false);
		jf.setVisible(true);
	}

	public static void main(String[] args) {
		new MainFrm();
	}

}
