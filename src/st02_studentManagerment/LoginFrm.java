package st02_studentManagerment;

import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;

import javax.swing.*;

import dao.Admin;
import dao.StudentDao;
import dao.TeacherDao;
import model.Teacher;

public class LoginFrm {
	public static final int WIDTH=600;
	public static final int HEIGHT=400;
	
	public void look(){
		JFrame loginFrm=new JFrame("��¼����");
		loginFrm.setSize(WIDTH, HEIGHT);
		
		loginFrm.setLocationRelativeTo(null);
		loginFrm.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		JLabel  lblLogo=new JLabel();
		JLabel  lblTitle=new JLabel();
		ImageIcon icon=new ImageIcon("images/logo.png");
		lblLogo.setIcon(icon);
		lblTitle.setText("ѧ����Ϣϵͳ��¼����");
		
		JLabel  lblUsername=new JLabel("�û���:",new  ImageIcon("images/�û���.png"),0);
		JTextField txtUsername=new JTextField();
		txtUsername.setPreferredSize(new Dimension(150,25));
		
		
		JLabel lblPassWord=new JLabel("��    ��:",new  ImageIcon("images/����.png"),0 );
		JPasswordField pass=new JPasswordField();
		pass.setPreferredSize(new Dimension(150,25));
		
		
		JPanel p1=new JPanel();
		JPanel p2=new JPanel();
		JPanel p3=new JPanel();
		
		p1.add(lblLogo);
		p1.add(lblTitle);
		p1.setPreferredSize(new Dimension(WIDTH,100));
		p2.add(lblUsername);
		p2.add(txtUsername);
		p3.setPreferredSize(new Dimension(WIDTH,30));
		p3.add(lblPassWord);
		p3.add(pass);
		
		JLabel lblUseType=new JLabel("�û�����:",new  ImageIcon("images/userType.png"),0 );
		String[] listData = new String[]{"ϵͳ����Ա","��ʦ","ѧ��"};
		JComboBox<String> comboBox = new JComboBox<String>(listData);
	    comboBox.setPreferredSize(new Dimension(150,25));
	    
	    JPanel p5=new JPanel();
		p5.setPreferredSize(new Dimension(WIDTH,30));
		p5.add(lblUseType);
		p5.add(comboBox);
		
		
		JButton btnLogin=new JButton("��¼",new ImageIcon("images/��¼.png"));
		JButton btnRest=new JButton("����",new ImageIcon("images/����.png"));
		
		
		JPanel p4=new JPanel();
		p4.setPreferredSize(new Dimension(WIDTH,30));
		p4.add(btnLogin);
		p4.add(btnRest);
		
		btnLogin.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				String username=txtUsername.getText();
				String password=pass.getText();
				String userType=comboBox.getSelectedItem().toString();
				if(userType.equals("ϵͳ����Ա")) {
					Admin a=new Admin();
					try {
						int r=a.login(username, password);
						if(r==1) {
							MainFrm mf=new MainFrm();
							loginFrm.setVisible(false);
						}else{
							JOptionPane.showMessageDialog(null, "�Բ����û��������� ����ȷ");
						}
					} catch (SQLException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
				}else if(userType.equals("��ʦ")) {
					TeacherDao t=new TeacherDao();
					int r=t.login(username, password);
					if(r==1) {
						MainFrm mf=new MainFrm();
						loginFrm.setVisible(false);
					}else{
						JOptionPane.showMessageDialog(null, "�Բ����û��������� ����ȷ");
					}
				}else if(userType.equals("ѧ��")) {
					StudentDao st=new StudentDao();
					int r=st.login(username, password);
					if(r==1) {
						MainFrm mf=new MainFrm();
						loginFrm.setVisible(false);
					}else{
						JOptionPane.showMessageDialog(null, "�Բ����û��������� ����ȷ");
					}
				}
				
				
				
			}
		});
		btnRest.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				txtUsername.setText(null);
				pass.setText(null);
			}
		});
		
		

		
		loginFrm.setLayout(new FlowLayout());
		loginFrm.add(p1);
		loginFrm.add(p2);
		loginFrm.add(p3);
		loginFrm.add(p5);
		loginFrm.add(p4);
		
		loginFrm.setResizable(false);
		loginFrm.setVisible(true);
	}
	
	public LoginFrm() {
		look();
		
	}

	public static void main(String[] args) {
		new LoginFrm();

	}

}
