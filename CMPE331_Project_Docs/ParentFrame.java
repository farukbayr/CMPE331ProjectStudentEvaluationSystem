import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.Frame;
import java.awt.TextArea;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.awt.event.ActionEvent;
import javax.swing.JTextArea;
import javax.swing.JPasswordField;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class ParentFrame extends JFrame {
	ArrayList stdList = new ArrayList<Student>();
	private JPanel contentPane;
	private JTextField txtUsername;
	private JPasswordField txtPassword;

	public ParentFrame(ArrayList std) {
		stdList = std;
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setTitle("Parent Management System");
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblUsername = new JLabel("Username");
		lblUsername.setBounds(64, 67, 88, 38);
		contentPane.add(lblUsername);
		
		JLabel lblPassword = new JLabel("Password");
		lblPassword.setBounds(69, 147, 83, 38);
		contentPane.add(lblPassword);
		
		txtUsername = new JTextField();
		txtUsername.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				txtUsername.setText("");
			}
		});
		txtUsername.setText("Username");
		txtUsername.setBounds(162, 76, 114, 29);
		contentPane.add(txtUsername);
		txtUsername.setColumns(10);
		
		JTextArea textArea = new JTextArea();
		textArea.setEditable(false);
		textArea.setVisible(false);
		
		JButton btnOk = new JButton("Login");
		btnOk.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				String userName = txtUsername.getText();
				String password = txtPassword.getText();
				Student s = new Student(null, null, null, 0, 0, 0);
				boolean t = false;
				if(userName.equals("std1")&& password.equals("1111")){ 
					t = true;
					s = (Student)stdList.get(0);
					
				}else if(userName.equals("std2")&& password.equals("2222")){
					t = true;
					s = (Student)stdList.get(1);
					
				}else if(userName.equals("std3")&& password.equals("3333")){
					t = true;
					s = (Student)stdList.get(2);
				}else if(userName.equals("std4")&& password.equals("4444")){
					t = true;
					s = (Student)stdList.get(3);
				}else if(userName.equals("std5")&& password.equals("5555")){
					t = true;
					s = (Student)stdList.get(4);
				}else
					JOptionPane.showMessageDialog(null, "Wrong username or password");
				
			if(t){
				String basket = "Full Name: " + s.getFullName() + "\nStatus: " + s.getStatus() + "\nRecommendation: " + s.getRecommendations() +  "\nGrade1: " + s.getValue1() + "\nGrade2: " + s.getValue2() + "\nGrade3: " + s.getValue3(); 
				txtUsername.setVisible(false);
				txtPassword.setVisible(false);
				btnOk.setVisible(false);
				lblPassword.setVisible(false);
				lblUsername.setVisible(false);
				textArea.setText(basket);
				textArea.setVisible(true);
				}
			}
		});
		btnOk.setBounds(297, 209, 89, 23);
		contentPane.add(btnOk);
		
		JButton btnBack = new JButton("Back");
		btnBack.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
				StudentEvaluation window = new StudentEvaluation();
				window.readdata();
				window.frame.setTitle("Student Management System");
				window.frame.setVisible(true);
			}
		});
		btnBack.setBounds(200, 209, 89, 23);
		contentPane.add(btnBack);
		textArea.setBounds(0, 0, 434, 261);
		contentPane.add(textArea);
		
		txtPassword = new JPasswordField();
		txtPassword.setBounds(162, 156, 114, 20);
		contentPane.add(txtPassword);
		
		
	}
}
