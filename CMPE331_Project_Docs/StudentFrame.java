import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.util.ArrayList;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JTextArea;
import javax.swing.JButton;

public class StudentFrame extends JFrame {
	ArrayList stdList = new ArrayList<Student>();
	private JPanel contentPane;
	
	public StudentFrame(ArrayList basketList) {
		stdList = basketList;
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		
		JTextArea textArea = new JTextArea();
		textArea.setBounds(36, 97, 388, 153);
		contentPane.add(textArea);
		
		
		JComboBox comboBox = new JComboBox();
		comboBox.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Student s = new Student(null, null, null, 0, 0, 0);
				s = (Student)stdList.get(comboBox.getSelectedIndex());
				String basket = "Full Name: " + s.getFullName() + "\nStatus: " + s.getStatus() + "\nGrade1: " + s.getValue1() + "\nGrade2: " + s.getValue2() + "\nGrade3: " + s.getValue3(); 
				textArea.setText(basket);
			}
		});
		comboBox.setModel(new DefaultComboBoxModel(new String[] {"Student1", "Student2", "Student3", "Student4", "Student5"}));
		comboBox.setBounds(10, 26, 119, 51);
		contentPane.add(comboBox);
		
		JButton btnNewButton = new JButton("Back");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				dispose();
				StudentEvaluation window = new StudentEvaluation();
				window.readdata();
				window.frame.setTitle("Student Management System");
				window.frame.setVisible(true);
			}
		});
		btnNewButton.setBounds(269, 48, 100, 29);
		contentPane.add(btnNewButton);
	
	}
}
