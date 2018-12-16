import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JButton;
import java.awt.BorderLayout;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.Scanner;
import java.awt.event.ActionEvent;
import java.awt.GridLayout;
import java.awt.FlowLayout;
import java.awt.Frame;
import java.awt.GridBagLayout;
import javax.swing.JLabel;
import javax.swing.JTextPane;

public class StudentEvaluation{

	public JFrame frame;
	ArrayList stdList = new ArrayList<Student>();
	static boolean a = false;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					
					StudentEvaluation window = new StudentEvaluation();
					window.readdata();
					window.frame.setTitle("Student Management System");
					window.frame.setVisible(true);
					if(a){
						window.frame.dispose();
						a = false;
						StudentEvaluation window1 = new StudentEvaluation();
						window1.readdata();
						window1.frame.setTitle("Student Management System");
						window1.frame.setVisible(true);
					}
					
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public StudentEvaluation() {
		
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		
		frame.setBounds(100, 100, 450, 300);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JButton btnTeacher = new JButton("Teacher");
		btnTeacher.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				frame.dispose();
				new TeacherFrame(stdList).setVisible(true);
			}
		
		});
		btnTeacher.setBounds(162, 30, 101, 41);
		frame.getContentPane().add(btnTeacher);
		
		JButton btnStudent = new JButton("Student");
		btnStudent.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				frame.dispose();
				new StudentFrame(stdList).setVisible(true);
			}
		});
		btnStudent.setBounds(162, 110, 101, 41);
		frame.getContentPane().add(btnStudent);
		
		JButton btnParent = new JButton("Parent");
		btnParent.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				frame.dispose();
				new ParentFrame(stdList).setVisible(true);
			}
		});
		btnParent.setBounds(162, 190, 101, 41);
		frame.getContentPane().add(btnParent);
	}
	public void readdata(){
		ArrayList basket=new ArrayList<Student>();
		
		Scanner scan;
		try {
			File file=new File("std1.txt");
			
		
		for(int i=1;i<6;i++){
			switch (i) {
			case 2:
				file=new File("std2.txt");
				break;
			case 3:
				file=new File("std3.txt");
				break;
			case 4:
				file=new File("std4.txt");
				break;
			case 5:
				file=new File("std5.txt");
				break;	
			default:
				break;
			}
			scan = new Scanner(file);
			String fullname=scan.nextLine();
			String status=scan.nextLine();
			String recomandation=scan.nextLine();
			int grade1=Integer.parseInt(scan.nextLine());
			int grade2=Integer.parseInt(scan.nextLine());
			int grade3=Integer.parseInt(scan.nextLine());
			
			basket.add(new Student(fullname,status,recomandation,grade1,grade2,grade3));
		}
		stdList=basket;
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			ArrayList basket1 = new ArrayList<Student>();
            Student s1 = new Student("Anil Kilic", "Status", "Comment", 0, 0, 0);
            Student s2 = new Student("Faruk Bayraktar ","Status", "Comment", 0, 0, 0);
            Student s3 = new Student("Canberk Kocabiyik", "Status", "Comment", 0, 0, 0);
            Student s4 = new Student("Yagiz Ugurlu", "Status", "Comment", 0, 0, 0);
            Student s5 = new Student("Yigit Isik","Status", "Comment", 0, 0, 0);
            basket1.add(s1);
            basket1.add(s2);
            basket1.add(s3);
            basket1.add(s4);
            basket1.add(s5);
            File file=new File("std1.txt");
            for(int i=0;i<5;i++){
    			switch (i) {
    			case 1:
    				file=new File("std2.txt");
    				break;
    			case 2:
    				file=new File("std3.txt");
    				break;
    			case 3:
    				file=new File("std4.txt");
    				break;
    			case 4:
    				file=new File("std5.txt");
    				break;	
    			default:
    				break;
    			}
    			try {
					
				
            File fout = (file);
            FileOutputStream fos = new FileOutputStream(fout);

            BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(fos));
                bw.write((((Student) basket1.get(i)).getFullName()));
                bw.newLine();
                bw.write(((Student) basket1.get(i)).getStatus());
                bw.newLine();
                bw.write(((Student)basket1.get(i)).getRecommendations());
                bw.newLine();
                bw.write(((Student)basket1.get(i)).getValue1() + "");
                bw.newLine();
                bw.write(((Student)basket1.get(i)).getValue2() + "");
                bw.newLine();
                bw.write(((Student)basket1.get(i)).getValue3() + "");
            bw.close();
            
    			} catch (Exception e2) {
					// TODO: handle exception
				}
    			JOptionPane.showMessageDialog(null, file+"   Created");
		}
         a = true;   
        
	}
		
	}
}
