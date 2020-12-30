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
	String[] columnNames = {"��ʦid","��ʦ����","��ʦ�Ա�","��ʦְ��","��ʦ����","��¼����"};
	JTable jt=new JTable();
	public TeachermgFrm() {
		initUI();
	}
	public void initUI() {
		JFrame jf=new JFrame("��ʦ��Ϣ����");
		jf.setSize(700,550);
//		jf.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		jf.setLocationRelativeTo(null);
		
		JLabel lblClassName=new JLabel("��ʦ������				");
		ImageIcon icon=new ImageIcon("images/��ʦ.png");
		lblClassName.setIcon(icon);
		JTextField txtTeacherName=new JTextField();
		txtTeacherName.setPreferredSize(new Dimension(150,25));
		JButton btnSearch=new JButton("����",new ImageIcon("images/����.png"));
		
		JPanel p1=new JPanel();
		p1.setPreferredSize(new Dimension(600,80));
		p1.add(lblClassName);
		p1.add(txtTeacherName);
		p1.add(btnSearch);
		
		
      
		 ArrayList<Teacher> teachers=TeacherDao.getAll();
	     
		updateTableData(teachers);
		JScrollPane p2=new JScrollPane(jt);
		p2.setPreferredSize(new Dimension(600,200));
		
		
		JLabel lblteacherNam=new JLabel("��ʦ����:		");
		lblteacherNam.setIcon(icon);
		JTextField txtteacherNam=new JTextField();
		txtteacherNam.setPreferredSize(new Dimension(150,25));

		JLabel lblteacherRank=new JLabel("��ʦְ��:		");
		ImageIcon icon2=new ImageIcon("images/ְ������.png");
		lblteacherRank.setIcon(icon2);
		JTextField txtteacherRank=new JTextField();
		txtteacherRank.setPreferredSize(new Dimension(150,25));

		JLabel lblpass=new JLabel("��¼����:		");
		ImageIcon icon3=new ImageIcon("images/����.png");
		lblpass.setIcon(icon3);
		JTextField txtpass=new JTextField();
		txtpass.setPreferredSize(new Dimension(150,25));
		
		JLabel lblteachertSex=new JLabel("��ʦ�Ա�:			");
		ImageIcon icon4=new ImageIcon("images/�Ա�.png");
		lblteachertSex.setIcon(icon4);
		
		JRadioButton radioBtn01 = new JRadioButton("��");
		radioBtn01.setSelected(true);
        JRadioButton radioBtn02 = new JRadioButton("Ů");
        
        // ����һ����ť��
        ButtonGroup btnGroup = new ButtonGroup();

        // ��ӵ�ѡ��ť����ť��
        btnGroup.add(radioBtn01);
        btnGroup.add(radioBtn02);
      
        JLabel lblteacherAge=new JLabel("��ʦ����:		");
		ImageIcon icon5=new ImageIcon("images/����.png");
		lblteacherAge.setIcon(icon5);
		JTextField txtteacherAge=new JTextField();
		txtteacherAge.setPreferredSize(new Dimension(100,25));
        
		
		JButton btnYes=new JButton("ȷ���޸�",new ImageIcon("images/ȷ��.png"));
		JButton btnDel=new JButton("ɾ��",new ImageIcon("images/ɾ��.png"));
		
		
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
		p5.setBorder(BorderFactory.createTitledBorder("��ʦ��Ϣ�޸�"));
		p5.setPreferredSize(new Dimension(600,200));
		p5.add(p3);
		p5.add(p4);
		
			
		
		jf.setLayout(new FlowLayout());
		jf.add(p1);
		jf.add(p2);
		jf.add(p5);
// 		jf.add(p4);
		
		FlowLayout flowLayout = new FlowLayout();
	    flowLayout.setVgap(10);//�����ֱ���
	    flowLayout.setHgap(10);//ˮƽ���
	    
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
 					if(sex.equals("��")) {
 						radioBtn01.setSelected(true);
 					}else if(sex.equals("Ů")) {
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
						sex="��";
					}
					else if(radioBtn02.isSelected())
					{
						sex="Ů";
					}
				 int result=TeacherDao.edit(name, title, password,sex,age,teacherId);
				 if(result>0) {
					 JOptionPane.showMessageDialog(null, "�޸ĳɹ�");
					 ArrayList<Teacher> tempteachers=TeacherDao.getAll();
					 updateTableData(tempteachers);
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
					int teacherId=Integer.parseInt(jt.getValueAt(row, 0).toString());
					
					int result=TeacherDao.delete(teacherId);
					if(result>0)
					{
						JOptionPane.showMessageDialog(null, "ɾ���ɹ�");
						ArrayList<Teacher> tempteachers=TeacherDao.getAll();
						updateTableData(tempteachers);
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
