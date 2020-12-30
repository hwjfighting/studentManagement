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

import dao.TClassDao;
import model.SClass;

public class ClassmgFrm {
	String[] columsName={"�༶���","�༶����","�༶����"};
	JTable jt=new JTable();
	public ClassmgFrm() {
		initUI();
	}
	public void initUI() {

		JFrame jf=new JFrame("�༶��Ϣ����");
		jf.setSize(700,400);
//		jf.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		jf.setLocationRelativeTo(null);
		
		JLabel lblClassName=new JLabel("�༶���� ��");
		ImageIcon icon=new ImageIcon("images/�༶����.png");
		lblClassName.setIcon(icon);
		JTextField txtClassName=new JTextField();
		txtClassName.setPreferredSize(new Dimension(150,25));
		JButton btnSearch=new JButton("����",new ImageIcon("images/����.png"));
		
		JPanel p1=new JPanel();
		p1.setPreferredSize(new Dimension(600,60));
		p1.add(lblClassName);
		p1.add(txtClassName);
		p1.add(btnSearch);
		
		
//         columnNames = {"id","name","info"};

        // �������������
//        String[][] rowData = {
//        		{"soft1","���һ��","�������һ�ࡣ"},
//        		{"soft2","�������","����������ࡣ"},
//        		{"net3","��������","�����������ࡣ"},
//        		{"net4","�����İ�","���������İࡣ"}
//        };
        
        ArrayList<SClass> classes=TClassDao.getAll();
     
		updateTableData(classes);
//        String[][] rowData=new String[classes.size()][3];
//        for(int i=0;i<classes.size();i++)
//        {
//        	for(int j=0;j<3;j++)
//        	{
//        		if(j==0)
//        			rowData[i][j]=classes.get(i).getId()+"";
//        		if(j==1)
//        			rowData[i][j]=classes.get(i).getName();
//        		if(j==2)
//        			rowData[i][j]=classes.get(i).getInfo();
//        			
//        	}
//        }
        
        
        
//        DefaultTableModel model=new DefaultTableModel(rowData,columsName);
        
//		JTable jt=new JTable();
//		jt.setModel(model);
		//�������
		JScrollPane p2=new JScrollPane(jt);
		p2.setPreferredSize(new Dimension(600,150));
		
		
		JLabel lblclassNam=new JLabel("�༶����:");
		JTextField txtclassNam=new JTextField();
		txtclassNam.setPreferredSize(new Dimension(150,25));
		JLabel lblclassIntro=new JLabel("�༶����:");
		JTextArea txtAclassIntro=new JTextArea();
		txtAclassIntro.setPreferredSize(new Dimension(180,100));
		
		JButton btnYes=new JButton("ȷ���޸�",new ImageIcon("images/ȷ��.png"));
		JButton btnDel=new JButton("ɾ��",new ImageIcon("images/ɾ��.png"));
		
		
		JPanel p3=new JPanel();
		p3.add(lblclassNam);
		p3.add(txtclassNam);
		p3.add(lblclassIntro);
		p3.add(txtAclassIntro);
		p3.add(btnYes);
		p3.add(btnDel);
		
			
		
		jf.setLayout(new FlowLayout());
		jf.add(p1);
		jf.add(p2);
		jf.add(p3);
		
		jt.getSelectionModel().addListSelectionListener(new ListSelectionListener() 
		{
			
			@Override
			public void valueChanged(ListSelectionEvent arg0) 
			{
				// TODO Auto-generated method stub
				int row=jt.getSelectedRow();
//				txtclassNam.setText(rowData[row][1]);
//				txtAclassIntro.setText(rowData[row][2]);
				if(row>=0)
				{
					txtclassNam.setText(jt.getValueAt(row, 1).toString());
					txtAclassIntro.setText(jt.getValueAt(row, 2).toString());
				}
			}
		});
		btnSearch.addActionListener(new ActionListener() 
		{
			
			@Override
			public void actionPerformed(ActionEvent e)
			{
				// TODO Auto-generated method stub
				String className=txtClassName.getText();
				ArrayList<SClass> tempclasses=TClassDao.getAllByName(className);
				updateTableData(tempclasses);
//				for(SClass a:tempclasses)
//				{
//					System.out.println(a.getName());
//				}
//				 String[][] rowData1=new String[tempclasses.size()][3];
//			        for(int i=0;i<tempclasses.size();i++)
//			        {
//			        	for(int j=0;j<3;j++)
//			        	{
//			        		if(j==0)
//			        			rowData1[i][j]=tempclasses.get(i).getId()+"";
//			        		if(j==1)
//			        			rowData1[i][j]=tempclasses.get(i).getName();
//			        		if(j==2)
//			        				
//			        	}
//			        }
//			        DefaultTableModel model1=new DefaultTableModel(rowData1,columsName);
//			        jt.setModel(model1);
//			        jt.updateUI();
			}
		});
		btnDel.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				int row=jt.getSelectedRow();
				if(row>0)
				{
					int classId=Integer.parseInt(jt.getValueAt(row, 0).toString());
					
					int result=TClassDao.delete(classId);
					if(result>0)
					{
						JOptionPane.showMessageDialog(null, "ɾ���ɹ�");
						ArrayList<SClass> tempclasses=TClassDao.getAll();
						updateTableData(tempclasses);
					}
					else
					{
						JOptionPane.showMessageDialog(null, "ɾ��ʧ��");
					}
				}

				
				
			}
		});
		
		btnYes.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				 int row=jt.getSelectedRow();
//				 System.out.println(row);
				 int classId=Integer.parseInt(jt.getValueAt(row, 0).toString());
				 String name=txtclassNam.getText();
				 String info=txtAclassIntro.getText();
				 int result=TClassDao.edit(classId, name, info);
				 if(result>0) {
					 JOptionPane.showMessageDialog(null, "�޸ĳɹ�");
					 ArrayList<SClass> tempclasses=TClassDao.getAll();
					 updateTableData(tempclasses);
				 }else {
					JOptionPane.showMessageDialog(null, "�޸�ʧ��");
				 }
				
			}
		});
		
		
		jf.setResizable(false);
		jf.setVisible(true);
		
	}
	public void updateTableData(ArrayList<SClass> datas)
	{
		String[][] tempData=new String[datas.size()][3];
		
		for(int i=0;i<datas.size();i++)
		{
			for(int j=0;j<3;j++)
			{
				if(j==0)
					tempData[i][j]=datas.get(i).getId()+"";
				if(j==1)
					tempData[i][j]=datas.get(i).getName();
				if(j==2)
					tempData[i][j]=datas.get(i).getInfo();
			}
		}
		
		DefaultTableModel tempmodel=new DefaultTableModel(tempData,columsName);
		jt.setModel(tempmodel);
//		jt.updateUI();
	}
	public static void main(String[] args) {
		new ClassmgFrm();
	}
}
