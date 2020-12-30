package st02_studentManagerment;

import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

import javax.swing.*;

public class AboutUsFrm {

	public AboutUsFrm() {
		
		initUI(); 
	}
	
	public void initUI() {
		Dimension dim1=new Dimension(300,100);
		Dimension dim2=new Dimension(220,25);
		Dimension dim3=new Dimension(220,100);
		Dimension dim5=new Dimension(45,100);
		Dimension dim6=new Dimension(300,50);
		
		JFrame  abusFrm=new JFrame("��������");
		abusFrm.setSize(350,225);
		abusFrm.setLocationRelativeTo(null);
		
		//���ùر�ʱʲôҲ����
//		abusFrm.setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
		abusFrm.addWindowListener(new WindowAdapter() {
			//new һ��WindowAdapter �� ��дwindowClosing����
			//WindowAdapter�Ǹ��������� ���忴jdk�İ����ĵ�
			public void windowClosing(WindowEvent e) {
				
				JOptionPane.showMessageDialog(null,"�����Ǻ��ģ�������"); 
			}
		});
		
		JPanel bigPanel=new JPanel();
		 
		JPanel topPanel=new JPanel();
 		topPanel.setPreferredSize(dim1);
		JPanel bottomPanel=new JPanel();
		bottomPanel.setPreferredSize(dim6);
		
		JPanel leftPanel=new JPanel();
		JLabel lblpic=new JLabel("",new ImageIcon("images/logo.png"),0);
		leftPanel.setPreferredSize(dim5);
		leftPanel.add(lblpic);
		
		JPanel rightPanel=new JPanel();
		rightPanel.setPreferredSize(dim3);
		
		JPanel p1=new JPanel();
 		p1.setPreferredSize(dim2);
		JLabel lblp1=new JLabel("��ͼ����ó�Ʒ��");
		p1.add(lblp1);
		

		JPanel p2=new JPanel();
 		p2.setPreferredSize(dim2);
		JLabel lblp2=new JLabel("��ַ��http://www.turing.com");
		p2.add(lblp2);
		

		JPanel p3=new JPanel();
		p3.setPreferredSize(dim2);
		JLabel lblp3=new JLabel("ÿ�����һ����Ŀ����������Ƶ�̳̣�");
		p3.add(lblp3);
		
		
		JButton btn1=new JButton("�Ȳ�����ȥ������");
		JButton btn2=new JButton("���鲻���Ժ���˵��");
		
		bottomPanel.add(btn1);
		bottomPanel.add(btn2);
		
		
		rightPanel.add(p1);
		rightPanel.add(p2);
		rightPanel.add(p3);
		
		
		topPanel.add(leftPanel);
		topPanel.add(rightPanel);
		
	
		bigPanel.add(topPanel);
		bigPanel.add(bottomPanel);
		
		abusFrm.add(bigPanel);


		topPanel.setLayout(new FlowLayout());
		abusFrm.setResizable(false);
		abusFrm.setVisible(true);
		
		
		
		
	}

	public static void main(String[] args) {
		 new AboutUsFrm();

	}

}
