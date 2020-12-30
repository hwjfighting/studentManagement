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
		jf.setTitle("ѧ����Ϣϵͳ��¼����");
		jf.setSize(1200, 800);
		jf.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		jf.setLocationRelativeTo(null);
		
		//�˵�
		JMenu systemSetting=new JMenu("ϵͳ����");
		JMenu studentmg=new JMenu("ѧ������");
		JMenu classmg=new JMenu("�༶����");
		JMenu teachermg=new JMenu("��ʦ����");
		JMenu coursemg=new JMenu("�γ̹���");
		JMenu selectmg=new JMenu("ѡ�ι���");
		JMenu siging=new JMenu("ǩ������");
		JMenu grademg=new JMenu("�ɼ�����");
		JMenu help=new JMenu("����");
		
		
		//�˵��ϵ�ͼ��
		systemSetting.setIcon(new ImageIcon("images/ϵͳ����.png"));
		studentmg.setIcon(new ImageIcon("images/ѧ������.png"));
		classmg.setIcon(new ImageIcon("images/�༶����.png"));
		teachermg.setIcon(new ImageIcon("images/��ʦ.png"));
		coursemg.setIcon(new ImageIcon("images/�γ�.png"));
		selectmg.setIcon(new ImageIcon("images/ѡ��.png"));
		siging.setIcon(new ImageIcon("images/ǩ��.png"));
		grademg.setIcon(new ImageIcon("images/�ɼ�.png"));
		help.setIcon(new ImageIcon("images/����.png"));
		
		//�˵���
		JMenuItem systemSetting01=new JMenuItem("�޸�����",new ImageIcon("images/�޸�����.png"));
		JMenuItem systemSetting02=new JMenuItem("�˳�ϵͳ",new ImageIcon("images/�˳�.png"));
		systemSetting.add(systemSetting01);
		systemSetting.add(systemSetting02);
		
		JMenuItem stuitem01=new JMenuItem("���ѧ��",new ImageIcon("images/���.png"));
		JMenuItem stuitem02=new JMenuItem("ѧ���б�",new ImageIcon("images/�б�.png"));
		studentmg.add(stuitem01);
		studentmg.add(stuitem02);
		
		JMenuItem classitem01=new JMenuItem("�༶���",new ImageIcon("images/���.png"));
		JMenuItem classitem02=new JMenuItem("�༶����",new ImageIcon("images/�༶����.png"));
		classmg.add(classitem01);
		classmg.add(classitem02);
		
		JMenuItem teacheritem01=new JMenuItem("��ӽ�ʦ",new ImageIcon("images/���.png"));
		JMenuItem teacheritem02=new JMenuItem("��ʦ�б�",new ImageIcon("images/�б�.png"));
		teachermg.add(teacheritem01);
		teachermg.add(teacheritem02);
		
		JMenuItem courseitem01=new JMenuItem("��ӿγ�",new ImageIcon("images/���.png"));
		JMenuItem courseitem02=new JMenuItem("�γ��б�",new ImageIcon("images/�б�.png"));
		coursemg.add(courseitem01);
		coursemg.add(courseitem02);
		
		JMenuItem selectitem01=new JMenuItem("ѡ�ι���",new ImageIcon("images/ѡ��.png"));
		selectmg.add(selectitem01);
		
		JMenuItem siging01=new JMenuItem("ѧ��ǩ��",new ImageIcon("images/ǩ��.png"));
		JMenuItem siging02=new JMenuItem("ǩ������",new ImageIcon("images/ǩ���б�.png"));
		JMenuItem siging03=new JMenuItem("ǩ��ͳ��",new ImageIcon("images/ͳ��.png"));
		siging.add(siging01);
		siging.add(siging02);
		siging.add(siging03);
		
		
		JMenuItem gradeitem01=new JMenuItem("¼��ɼ�",new ImageIcon("images/���.png"));
		JMenuItem gradeitem02=new JMenuItem("�ɼ��鿴",new ImageIcon("images/�鿴.png"));
		JMenuItem gradeitem03=new JMenuItem("�ɼ�����",new ImageIcon("images/�ɼ�.png"));
		JMenuItem gradeitem04=new JMenuItem("�ɼ�ͳ��",new ImageIcon("images/ͳ��.png"));
		grademg.add(gradeitem01);
		grademg.add(gradeitem02);
		grademg.add(gradeitem03);
		grademg.add(gradeitem04);
		
		
		JMenuItem helpitem01=new JMenuItem("��������",new ImageIcon("images/��������.png"));
		
		help.add(helpitem01);
		
		
		
		
		//�˵���
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
				if(JOptionPane.showConfirmDialog(null, "ȷ���˳�ô��") == JOptionPane.OK_OPTION){
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
