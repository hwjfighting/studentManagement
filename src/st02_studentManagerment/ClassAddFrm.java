package st02_studentManagerment;

import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.*;

import dao.TClassDao;

/*****************************************************************************
Copyright: 1988-2019, Huawei Tech. Co., Ltd.
File name: ClassAddFrm
Description: 添加班级
Author: llt
Version: 1.0
Date: 2019-9-7 15:02:14
History: 
2019-9-7 15:02:25  	李四		initUI
2019-9-7 15:02:31  	王五		ClassAddFrm

*****************************************************************************/

public class ClassAddFrm
{

	public ClassAddFrm()
	{
		initUI();
	}
	
	/*************************************************
	Function: 	initUI
	Description: 初始化界面
	Calls: 
	Called By: ClassAddFrm
	Table Accessed: // 被访问的表（此项仅对于牵扯到数据库操作的程序）
	Table Updated: // 被修改的表（此项仅对于牵扯到数据库操作的程序）
	Input: // 输入参数说明，包括每个参数的作// 用、取值说明及参数间关系。
	Output: // 对输出参数的说明。
	Return: // 函数返回值的说明
	Others: // 其它说明
	*************************************************/

	public void initUI()
	{
		Dimension dim=new Dimension(400, 60);		//panel的大小
		Dimension dim1=new Dimension(150, 30);		//textfield大小
		Dimension dim2=new Dimension(150, 100);		//textarea大小
		
		JFrame jf=new JFrame("添加班级");
		jf.setSize(400,300);
		jf.setLocationRelativeTo(null);

		JPanel bigPanel=new JPanel();
		JPanel ptop=new JPanel();
		JPanel pmid=new JPanel();
		JPanel pbottom=new JPanel();
		
		//设置Panel的大小
		ptop.setPreferredSize(dim);
		pmid.setPreferredSize(new Dimension(400, 100));
		pbottom.setPreferredSize(dim);
		
		JLabel lblClassName=new JLabel("班级名称:",new ImageIcon("images/班级名称.png"),0);
		JTextField txtClassNmae=new JTextField();
		txtClassNmae.setPreferredSize(dim1);
		ptop.add(lblClassName);
		ptop.add(txtClassNmae);
		
		
		JLabel lblClassDesc=new JLabel("班级信息:",new ImageIcon("images/班级介绍.png"),0);
		JTextArea areaClassDesc=new JTextArea();
		areaClassDesc.setPreferredSize(new Dimension(150, 100));
		pmid.add(lblClassDesc);
		pmid.add(areaClassDesc);
		
		
		JButton btnSubmit=new JButton("提交",new ImageIcon("images/确认.png"));
		JButton btnReset=new JButton("重置",new ImageIcon("images/重置.png"));
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
					JOptionPane.showMessageDialog(null, "添加成功");
				}
				else
				{
					JOptionPane.showMessageDialog(null, "添加失败");
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

