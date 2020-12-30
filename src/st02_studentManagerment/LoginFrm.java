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
		JFrame loginFrm=new JFrame("登录界面");
		loginFrm.setSize(WIDTH, HEIGHT);
		
		loginFrm.setLocationRelativeTo(null);
		loginFrm.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		JLabel  lblLogo=new JLabel();
		JLabel  lblTitle=new JLabel();
		ImageIcon icon=new ImageIcon("images/logo.png");
		lblLogo.setIcon(icon);
		lblTitle.setText("学生信息系统登录界面");
		
		JLabel  lblUsername=new JLabel("用户名:",new  ImageIcon("images/用户名.png"),0);
		JTextField txtUsername=new JTextField();
		txtUsername.setPreferredSize(new Dimension(150,25));
		
		
		JLabel lblPassWord=new JLabel("密    码:",new  ImageIcon("images/密码.png"),0 );
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
		
		JLabel lblUseType=new JLabel("用户类型:",new  ImageIcon("images/userType.png"),0 );
		String[] listData = new String[]{"系统管理员","教师","学生"};
		JComboBox<String> comboBox = new JComboBox<String>(listData);
	    comboBox.setPreferredSize(new Dimension(150,25));
	    
	    JPanel p5=new JPanel();
		p5.setPreferredSize(new Dimension(WIDTH,30));
		p5.add(lblUseType);
		p5.add(comboBox);
		
		
		JButton btnLogin=new JButton("登录",new ImageIcon("images/登录.png"));
		JButton btnRest=new JButton("重置",new ImageIcon("images/重置.png"));
		
		
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
				if(userType.equals("系统管理员")) {
					Admin a=new Admin();
					try {
						int r=a.login(username, password);
						if(r==1) {
							MainFrm mf=new MainFrm();
							loginFrm.setVisible(false);
						}else{
							JOptionPane.showMessageDialog(null, "对不起，用户名或密码 不正确");
						}
					} catch (SQLException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
				}else if(userType.equals("教师")) {
					TeacherDao t=new TeacherDao();
					int r=t.login(username, password);
					if(r==1) {
						MainFrm mf=new MainFrm();
						loginFrm.setVisible(false);
					}else{
						JOptionPane.showMessageDialog(null, "对不起，用户名或密码 不正确");
					}
				}else if(userType.equals("学生")) {
					StudentDao st=new StudentDao();
					int r=st.login(username, password);
					if(r==1) {
						MainFrm mf=new MainFrm();
						loginFrm.setVisible(false);
					}else{
						JOptionPane.showMessageDialog(null, "对不起，用户名或密码 不正确");
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
