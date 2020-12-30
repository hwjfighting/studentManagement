package st02_studentManagerment;

import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.*;



//import org.junit.jupiter.api.Test;

public class ChangePassFrm {
	public ChangePassFrm() {
		initUI();
	}
	
	public void initUI() {
		Dimension dim1=new Dimension(400,60);
		Dimension dim2=new Dimension(150,30);
		
		
		JFrame cpfm=new JFrame("�޸�����");
		cpfm.setSize(400,400);
		cpfm.setLocationRelativeTo(null);
		
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
		
		
		JLabel lblCurrentUser=new JLabel("��ǰ�û�����ϵͳ����Ա��admin",new ImageIcon("images/�û���.png"),0);
		p1.add(lblCurrentUser);
		
		JLabel lblused=new JLabel("ԭ���룺",new ImageIcon("images/password.png"),0);
		JTextField txtused=new JTextField();
		txtused.setPreferredSize(dim2);
		p2.add(lblused);
		p2.add(txtused);
		
		JLabel lblnew=new JLabel("�����룺",new ImageIcon("images/�޸�����.png"),0);
		JTextField txtnew=new JTextField();
		txtnew.setPreferredSize(dim2);
		p3.add(lblnew);
		p3.add(txtnew);
		
		
		JLabel lblyes=new JLabel("ȷ�����룺",new ImageIcon("images/�޸�����.png"),0);
		JTextField txtyes=new JTextField();
		txtyes.setPreferredSize(dim2);
		p4.add(lblyes);
		p4.add(txtyes);
		
		JButton btn1=new JButton("ȷ��",new ImageIcon("images/ȷ��.png"));
		JButton btn2=new JButton("����",new ImageIcon("images/����.png"));
		p5.add(btn1);
		p5.add(btn2);
		
		bigPanel.add(p1);
		bigPanel.add(p2);
		bigPanel.add(p3);
		bigPanel.add(p4);
		bigPanel.add(p5);
		cpfm.add(bigPanel);
		cpfm.setResizable(false);
		
		btn1.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
			 String oldPassword=txtused.getText();
			 String newPassword=txtnew.getText();
			 String conformPassword=txtyes.getText();
			 if(ChangePassFrm.isEmpty(oldPassword)) {
				JOptionPane.showMessageDialog(null, "����д�����룡");
				return;
			 }
			 if(ChangePassFrm.isEmpty(newPassword)){
				JOptionPane.showMessageDialog(null, "����д�����룡");
				return;
			}
			if(ChangePassFrm.isEmpty(conformPassword)){
				JOptionPane.showMessageDialog(null, "��ȷ�������룡");
				return;
			}
			if(!newPassword.equals(conformPassword)){
				JOptionPane.showMessageDialog(null, "�����������벻һ�£�");
				return;
			}
				
			}
		});
		
		cpfm.setVisible(true);
	}
	public static boolean isEmpty(String str){
		if("".equals(str)|| str == null){
			return true;
		}
		return false;
	}
	public static void main(String[] args) {
		new ChangePassFrm();
	}

}
