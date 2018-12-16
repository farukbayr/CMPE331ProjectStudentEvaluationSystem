import java.awt.BorderLayout;
import java.awt.Button;
import java.awt.EventQueue;
import java.awt.Frame;
import java.awt.HeadlessException;
import java.util.ArrayList;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JScrollBar;
import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileOutputStream;
import java.io.FileWriter;
import java.io.OutputStreamWriter;
import java.awt.event.ActionEvent;

public class TeacherFrame extends JFrame implements ActionListener{
	ArrayList stdList = new ArrayList<Student>();
	private JPanel contentPane;
	private JTextField textField;
	private JTextField textField_1;
	//FileWriter fw;
	File file = new File("List.txt"); 
	private JTextField textField_2;
	private JTextField textField_3;
	private JTextField textField_4;
	

	/**
	 * Launch the application.
	 */
	/*public static void main(String[] args) { //komple
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					ArrayList basket = new ArrayList<Student>();
					Student s1 = new Student("Anil Kilic", "", "", 0, 0, 0);
					Student s2 = new Student("Faruk Bayraktar ", "", "", 0, 0, 0);
					Student s3 = new Student("Canberk Kocabiyik", "", "", 0, 0, 0);
					Student s4 = new Student("Yagiz Ugurlu", "", "", 0, 0, 0);
					Student s5 = new Student("Yigit Isik","", "", 0, 0, 0);
					basket.add(s1);
					basket.add(s2);
					basket.add(s3);
					basket.add(s4);
					basket.add(s5);
					TeacherFrame frame = new TeacherFrame(basket);
					frame.setTitle("Teacher System");
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}*s/

	/**
	 * Create the frame.
	 */
	public TeacherFrame(ArrayList basketList) {
		stdList = basketList;
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		
		JComboBox comboBox = new JComboBox();
		comboBox.setModel(new DefaultComboBoxModel(new String[] {"Student1", "Student2", "Student3", "Student4", "Student5"}));
		comboBox.setBounds(82, 40, 220, 51);
		contentPane.add(comboBox);
		
		JLabel lblGrades = new JLabel("Grades");
		lblGrades.setBounds(10, 117, 62, 21);
		contentPane.add(lblGrades);
		textField = new JTextField();
		textField.setBounds(116, 117, 41, 20);
		contentPane.add(textField);
		textField.setColumns(10);
		
		JLabel lblRecommendation = new JLabel("Recommendation");
		lblRecommendation.setBounds(10, 167, 86, 14);
		contentPane.add(lblRecommendation);
		textField_1 = new JTextField();
		textField_1.setBounds(116, 155, 118, 38);
		contentPane.add(textField_1);
		textField_1.setColumns(10);
		
		
		
		JButton btnSave = new JButton("Save");
		btnSave.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(e.getActionCommand() == btnSave.getActionCommand()){ 
					((Student)stdList.get(comboBox.getSelectedIndex())).setValue1(Integer.parseInt(textField.getText()));
					((Student)stdList.get(comboBox.getSelectedIndex())).setValue2(Integer.parseInt(textField_3.getText()));
					((Student)stdList.get(comboBox.getSelectedIndex())).setValue3(Integer.parseInt(textField_4.getText()));
					((Student)stdList.get(comboBox.getSelectedIndex())).setRecommendations(textField_1.getText());
					
					
					try{
						
					    File fout = (fmethod(comboBox.getSelectedIndex()));
					    FileOutputStream fos = new FileOutputStream(fout);
					    BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(fos));
					        bw.write(((Student)stdList.get(comboBox.getSelectedIndex())).getFullName());
					        bw.newLine();
					        bw.write(((Student)stdList.get(comboBox.getSelectedIndex())).getStatus());
					        bw.newLine();
					        bw.write(((Student)stdList.get(comboBox.getSelectedIndex())).getRecommendations());
					        bw.newLine();
					        bw.write(((Student)stdList.get(comboBox.getSelectedIndex())).getValue1() + "");
					        bw.newLine();
					        bw.write(((Student)stdList.get(comboBox.getSelectedIndex())).getValue2() + "");
					        bw.newLine();
					        bw.write(((Student)stdList.get(comboBox.getSelectedIndex())).getValue3() + "");
					        JOptionPane.showMessageDialog(null, "Success");
					    bw.close();
					}catch(Exception ex){
						JOptionPane.showMessageDialog(null, ex.getMessage());
					}
				}
			}
		});
		btnSave.setBounds(335, 216, 89, 23);
		contentPane.add(btnSave);
		
		
		JLabel lblStatus = new JLabel("Status");
		lblStatus.setBounds(10, 218, 74, 19);
		contentPane.add(lblStatus);
		
		textField_2 = new JTextField();
		textField_2.setEditable(false);
		textField_2.setBounds(116, 215, 86, 20);
		contentPane.add(textField_2);
		textField_2.setColumns(10);
		
		textField_3 = new JTextField();
		textField_3.setColumns(10);
		textField_3.setBounds(167, 117, 41, 20);
		contentPane.add(textField_3);
		
		textField_4 = new JTextField();
		textField_4.setColumns(10);
		textField_4.setBounds(218, 117, 41, 20);
		contentPane.add(textField_4);
		
		
		

		comboBox.addActionListener(new ActionListener() {
			
		public void actionPerformed(ActionEvent e) { //geçici s1 combobaxtan seçtiðin studenta.textleri güncelliyor
		Student s1 = new Student(null,null, null, 0, 0, 0);
		s1 = (Student)stdList.get(comboBox.getSelectedIndex());
		textField.setText(s1.getValue1() + "");
		textField_3.setText(s1.getValue2() + "");
		textField_4.setText(s1.getValue3() + "");
		textField_1.setText(s1.getRecommendations() + "");
		textField_2.setText(s1.getStatus() + "");	
		}
		});
		
		textField.setText(((Student)basketList.get(0)).getValue1() + "");
		textField_3.setText(((Student)basketList.get(0)).getValue2() + "");
		textField_4.setText(((Student)basketList.get(0)).getValue3() + "");
		textField_1.setText(((Student)basketList.get(0)).getRecommendations() + "");
		textField_2.setText(((Student)basketList.get(0)).getStatus() + "");	
		
		JButton btnBack = new JButton("Back");
		btnBack.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				dispose();
				StudentEvaluation window = new StudentEvaluation();
				window.readdata();
				window.frame.setTitle("Student Management System");
				window.frame.setVisible(true);
			}
		});
		btnBack.setBounds(237, 216, 89, 23);
		contentPane.add(btnBack);
		
}

	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		
	}
	public File fmethod(int a){
		File basket = new File("");
		if(a == 0){		
			basket = new File("std1.txt");
			}
		if(a == 1){
			basket = new File("std2.txt");
		}
		if(a==2){
			basket = new File("std3.txt");
		}
		if(a==3){
			basket = new File("std4.txt");
		}
		if(a==4){
			basket = new File("std5.txt");
		}
		return basket;
	}
	}
		
