package st02_studentManagerment;

import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.*;

import dao.TClassDao;

/*****************************************************************************
Copyright: 1988-2019, Huawei Tech. Co., Ltd.
File name: ClassAddFrm
Description: ��Ӱ༶
Author: llt
Version: 1.0
Date: 2019-9-7 15:02:14
History: 
2019-9-7 15:02:25  	����		initUI
2019-9-7 15:02:31  	����		ClassAddFrm

*****************************************************************************/

public class ClassAddFrm
{

	public ClassAddFrm()
	{
		initUI();
	}
	
	/*************************************************
	Function: 	initUI
	Description: ��ʼ������
	Calls: 
	Called By: ClassAddFrm
	Table Accessed: // �����ʵı����������ǣ�������ݿ�����ĳ���
	Table Updated: // ���޸ĵı����������ǣ�������ݿ�����ĳ���
	Input: // �������˵��������ÿ����������// �á�ȡֵ˵�����������ϵ��
	Output: // �����������˵����
	Return: // ��������ֵ��˵��
	Others: // ����˵��
	*************************************************/

	public void initUI()
	{
		Dimension dim=new Dimension(400, 60);		//panel�Ĵ�С
		Dimension dim1=new Dimension(150, 30);		//textfield��С
		Dimension dim2=new Dimension(150, 100);		//textarea��С
		
		JFrame jf=new JFrame("��Ӱ༶");
		jf.setSize(400,300);
		jf.setLocationRelativeTo(null);

		JPanel bigPanel=new JPanel();
		JPanel ptop=new JPanel();
		JPanel pmid=new JPanel();
		JPanel pbottom=new JPanel();
		
		//����Panel�Ĵ�С
		ptop.setPreferredSize(dim);
		pmid.setPreferredSize(new Dimension(400, 100));
		pbottom.setPreferredSize(dim);
		
		JLabel lblClassName=new JLabel("�༶����:",new ImageIcon("images/�༶����.png"),0);
		JTextField txtClassNmae=new JTextField();
		txtClassNmae.setPreferredSize(dim1);
		ptop.add(lblClassName);
		ptop.add(txtClassNmae);
		
		
		JLabel lblClassDesc=new JLabel("�༶��Ϣ:",new ImageIcon("images/�༶����.png"),0);
		JTextArea areaClassDesc=new JTextArea();
		areaClassDesc.setPreferredSize(new Dimension(150, 100));
		pmid.add(lblClassDesc);
		pmid.add(areaClassDesc);
		
		
		JButton btnSubmit=new JButton("�ύ",new ImageIcon("images/ȷ��.png"));
		JButton btnReset=new JButton("����",new ImageIcon("images/����.png"));
		pbottom.add(btnSubmit);
		pbottom.add(btnReset);
		
		bigPanel.add(ptop);
		bigPanel.add(pmid);
		bigPanel.add(pbottom);
		
		jf.add(bigPanel);
		
		btnSubmit.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				String name=txtClassNmae.getText();
				String info=areaClassDesc.getText();
				
				int result=TClassDao.insert(name, info);
				if(result>0)
				{
					JOptionPane.showMessageDialog(null, "��ӳɹ�");
				}
				else
				{
					JOptionPane.showMessageDialog(null, "���ʧ��");
				}
				
			}
		});
		btnReset.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				txtClassNmae.setText(null);
				areaClassDesc.setText(null);
				
			}
		});
		jf.setResizable(false);
		jf.setVisible(true);
	}
	
	public static void main(String[] args)
	{
		ClassAddFrm cf=new ClassAddFrm();
	}

}

