package st02_studentManagerment;

import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.Iterator;

import javax.swing.*;

import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartPanel;
import org.jfree.chart.JFreeChart;
import org.jfree.data.category.DefaultCategoryDataset;
import org.jfree.data.general.DefaultPieDataset;

import dao.CourseDao;
import dao.ScoreDao;
import model.Course;
import model.Score;

public class ScoreStatisticsFrm {
	public ScoreStatisticsFrm() {
		initUI();
	}
	
	public void initUI() {
		Dimension dim1=new Dimension(600,70);
		Dimension dim2=new Dimension(150,30);
		Dimension dim3=new Dimension(600,360);
		Dimension dim4=new Dimension(200,30);
		Dimension dim5=new Dimension(500,70);
		Dimension dim6=new Dimension(500,325);
		
		JFrame jf=new JFrame("�ɼ�ͳ�ƽ���");
		jf.setSize(800,650);
		jf.setLocationRelativeTo(null);
//		jf.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		JPanel bigPanel=new JPanel();
		JPanel p1=new JPanel();
		p1.setPreferredSize(dim1);
		JPanel p2=new JPanel();
		p2.setPreferredSize(dim3);
		p2.setBorder(BorderFactory.createTitledBorder("�ɼ�ͳ����Ϣ"));
		JPanel p2_=new JPanel();
		p2_.setPreferredSize(dim6);
		JPanel p2_1=new JPanel();
		p2_1.setPreferredSize(dim5);
		JPanel p2_2=new JPanel();
		p2_2.setPreferredSize(dim5);
		JPanel p2_3=new JPanel();
		p2_3.setPreferredSize(dim5);
		JPanel p2_4=new JPanel();
		p2_4.setPreferredSize(dim5);
		JPanel p3=new JPanel();
		p3.setPreferredSize(dim1);
		p3.setBorder(BorderFactory.createTitledBorder("�л���ʾ��ʽ"));
		JPanel p4=new JPanel();
		p4.setPreferredSize(dim6);
		JPanel p5=new JPanel();
		p5.setPreferredSize(dim6);
	
	
		JLabel lblCourseName =new JLabel("�γ����ƣ�",new ImageIcon("images/�γ�.png"),0);
	    ArrayList<Course> list2=CourseDao.getAll();
		String[] courseList=new String[list2.size()];
		for (int i = 0; i < list2.size(); i++)
		{
			courseList[i]=list2.get(i).getName();
		}
		
		JComboBox comboBox=new JComboBox(courseList);
	    comboBox.setPreferredSize(dim2);
	    
	    JButton btnResearch=new JButton("��ѯ",new ImageIcon("images/����.png")); 
	    
	    p1.add(lblCourseName);
	    p1.add(comboBox);
	    p1.add(btnResearch);
	    
	    FlowLayout flowLayout = new FlowLayout();
	    flowLayout.setHgap(10);//ˮƽ���
		flowLayout.setVgap(20);//�����ֱ���
		p1.setLayout(flowLayout);
		
		JLabel lblHighestScore=new JLabel("��߷�:",new ImageIcon("images/��߷�.png"),0);
		JTextField txtHighestScore=new JTextField();
		txtHighestScore.setPreferredSize(dim4);
		JLabel lblLowestScore=new JLabel("��ͷ�:",new ImageIcon("images/��ͷ�.png"),0);
		JTextField txtLowestScore=new JTextField();
		txtLowestScore.setPreferredSize(dim4);
		JLabel lblAverageScore=new JLabel("ƽ����:",new ImageIcon("images/ƽ��.png"),0);
		JTextField txtAverageScore=new JTextField();
		txtAverageScore.setPreferredSize(dim4);
		JLabel lblWholeNum=new JLabel("������:",new ImageIcon("images/����ͳ��.png"),0);
		JTextField txtWholeNum=new JTextField();
		txtWholeNum.setPreferredSize(dim4);
		
		p2_1.add(lblHighestScore);
		p2_1.add(txtHighestScore);
		p2_2.add(lblLowestScore);
		p2_2.add(txtLowestScore);
		p2_3.add(lblAverageScore);
		p2_3.add(txtAverageScore);
		p2_4.add(lblWholeNum);
		p2_4.add(txtWholeNum);
		
		p2_.add(p2_1);
		p2_.add(p2_2);
		p2_.add(p2_3);
		p2_.add(p2_4);
		p2.add(p2_);
		
		
		JButton btn1=new JButton("Ĭ����ʾ",new ImageIcon("images/Ĭ��.png"));
		JButton btn2=new JButton("��״ͼ��ʾ",new ImageIcon("images/��״ͼ.png"));
		JButton btn3=new JButton("��״ͼ��ʾ",new ImageIcon("images/��״ͼ.png"));
		
		FlowLayout flowLayout2 = new FlowLayout();
		flowLayout2.setVgap(10);//�����ֱ���
	    flowLayout2.setHgap(30);//ˮƽ���
		p3.setLayout(flowLayout2);
		
		p3.add(btn1);
		p3.add(btn2);
		p3.add(btn3);
		
		
		
		
		bigPanel.add(p1);
		bigPanel.add(p2);
		bigPanel.add(p3);
// 		bigPanel.add(p4);
 		bigPanel.setLayout(flowLayout);
		jf.add(bigPanel);
		
		btnResearch.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				String courseName=comboBox.getSelectedItem().toString();
				int course_id=0;
				
				ArrayList<Course> list2=CourseDao.getAll();
				for (int i = 0; i < list2.size(); i++)
				{
					
					if(list2.get(i).getName().equals(courseName))
					{
						course_id=list2.get(i).getId();
						break;
					}
					
				}
				
 				ArrayList<Score> arr=ScoreDao.getInfo(course_id);
 				txtHighestScore.setText(String.valueOf(arr.get(0).getHighestScore()));
 				txtLowestScore.setText(String.valueOf(arr.get(0).getLowestScore())); 
 				txtAverageScore.setText(String.valueOf(arr.get(0).getAvgScore()));
 				txtWholeNum.setText(String.valueOf(arr.get(0).getNum()));
				
 				DefaultPieDataset pieDataset=new DefaultPieDataset();
 				pieDataset.setValue("MAX", Integer.parseInt(txtHighestScore.getText()));
 				pieDataset.setValue("MIN", Integer.parseInt(txtLowestScore.getText()));
 				pieDataset.setValue("AVG", Double.parseDouble(txtAverageScore.getText()));
 				 JFreeChart chart = ChartFactory.createPieChart(      
 				        "",  // chart title 
 				         pieDataset,        // data    
 				         true,           // include legend   
 				         true, 
 				         false);
 				
 				 ChartPanel	cp=new ChartPanel(chart); 
 				 cp.setPreferredSize(dim6);
 				 p4.add(cp);
 				 p2.add(p4);
 				 p4.setVisible(false);
 				 
 				DefaultCategoryDataset categoryDataset=new DefaultCategoryDataset();
 				categoryDataset.addValue(Integer.parseInt(txtHighestScore.getText()) , "", "MAX");
 				categoryDataset.addValue(Integer.parseInt(txtLowestScore.getText()), "", "MIN");
 				categoryDataset.addValue(Double.parseDouble(txtAverageScore.getText()), "", "AVG");
 				 JFreeChart chart01 = ChartFactory.createBarChart("",
 						 "Score_type", "Score", categoryDataset);
 				 ChartPanel	cp1=new ChartPanel(chart01); 
 				 cp1.setPreferredSize(dim6);
 				 p5.add(cp1);
 				 p2.add(p5);
 				 p5.setVisible(false);
 				btn1.addActionListener(new ActionListener() {
					
					@Override
					public void actionPerformed(ActionEvent e) {
						p2_.setVisible(true);
 						p4.setVisible(false); 
 						p5.setVisible(false);
						
					}
				});
 				btn3.addActionListener(new ActionListener() {
 					
 					@Override
 					public void actionPerformed(ActionEvent e) {
 						p2_.setVisible(false);
 						p4.setVisible(true); 
 						p5.setVisible(false);
 					}
 				});
 				btn2.addActionListener(new ActionListener() {
 					
 					@Override
 					public void actionPerformed(ActionEvent e) {
 						p2_.setVisible(false);
 						p4.setVisible(false); 
 						p5.setVisible(true);
 					}
 				});
 				
			
				
			}
		});
		
		jf.setResizable(false);
		jf.setVisible(true);
		
	}
	
	public static void main(String[] args) {
		new ScoreStatisticsFrm();
	}

}
