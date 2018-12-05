package CreditValidation;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStream;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Scanner;

import User.Student;

public class CreditValidationForm {
	static String dispatchUniv;

	public static String getDispatchUniv() {
		return dispatchUniv;
	}
	public static void setDispatchUniv(String dispatchUniv) {
		CreditValidationForm.dispatchUniv = dispatchUniv;
	}
	public static String getDispatchSemester() {
		return dispatchSemester;
	}
	public static void setDispatchSemester(String dispatchSemester) {
		CreditValidationForm.dispatchSemester = dispatchSemester;
	}
	public static String getCompleteCredit() {
		return completeCredit;
	}
	public static void setCompleteCredit(String completeCredit) {
		CreditValidationForm.completeCredit = completeCredit;
	}
	public static String getSubjects() {
		return subjects;
	}
	public static void setSubjects(String subjects) {
		CreditValidationForm.subjects = subjects;
	}
	public static String getPermission() {
		return permission;
	}
	public static void setPermission(String permission) {
		CreditValidationForm.permission = permission;
	}
	public static Student getStudent() {
		return student;
	}
	public static void setStudent(Student student) {
		CreditValidationForm.student = student;
	}



	static String dispatchSemester;
 
	static String completeCredit;

	static String subjects;

	static String permission;

	static Student student;
	
	public CreditValidationForm(Student student) {
		this.student = student;
	}
	public void playCV() throws IOException {
		int flag = 0;
		try {
			flag = checkexist(student);
		} catch (IOException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		
		if(flag == 1){
			System.out.print("exist\n");
			ViewCV(student);
			while(true) {
				System.out.println("want to cancel the validation? 1.yes 2.no\n");
				Scanner sc = new Scanner(System.in);
				int d = sc.nextInt();
				if(d == 1) {
					DeleteCV(student);
					break;
				}
				else if(d > 2 || d < 1)
					System.out.println("invalid input\n");
				else if(d == 2)
					break;
			}	
			
		}
		else {
			System.out.println("Doesn't exist");
			try {
				WriteCV(student);
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}
	
	public static int checkexist(Student student) throws IOException//check existence of user's registeration form
	{
		int exist = 0;
		String StudentNumber;
		
		BufferedReader CVDB = null;
		File file = new File("CreditValidationInfo.txt");
		
		CVDB = new BufferedReader(new FileReader(file));
		
		StudentNumber = student.studentNumber;
		
		while(true)
		{
			String data = CVDB.readLine();
			
			if(data == null)break; //if not exist variable 'exist' = 0

			data = data.substring(0, 10);
			
			if(data.equals(StudentNumber))
			{
				exist = 1;
				CVDB.close();
				
				break;
			}
		}
		CVDB.close();
		return exist;
	}
	
	
	
	public static void WriteCV(Student student) throws IOException {
		int flag;
		Scanner sc = new Scanner(System.in);

		while(true) {
			
			System.out.println("�İߴ����� �Է��Ͻʽÿ�.");
			dispatchUniv = sc.nextLine();
			
			System.out.println("�İ��б⸦ �Է��Ͻʽÿ�.");
			dispatchSemester = sc.nextLine();
			
			System.out.println("�̼������� �Է��Ͻʽÿ�.");
			completeCredit = sc.nextLine();
			
			System.out.println("�̼������� �Է��Ͻʽÿ�.");
			subjects = sc.nextLine();
			
			System.out.printf("�İ� ���и� : %s\n�İ��б� : %s\n�̼����� : %s��\n����� : %s\n\n�� ������ ��û�Ͻðڽ��ϱ�? 1.Yes 2.No", dispatchUniv, dispatchSemester, completeCredit, subjects);

			flag = sc.nextInt();
			permission = "result not decided";
			if(flag == 1)
				break;
			else
				sc.nextLine();
			}
		PrintWriter saver = new PrintWriter(new FileWriter("CreditValidationInfo.txt", true));
		saver.printf("%s@%s@%s@%s@%s@%s", student.studentNumber , dispatchSemester, dispatchUniv, completeCredit, subjects, permission);

		System.out.println("successfully saved\n");
		saver.close();
		}
	
	public static void ViewCV(Student student) throws IOException {
		BufferedReader CVDB = null;
		File file = new File("CreditValidationInfo.txt");
		String aCVdata[];
		CVDB = new BufferedReader(new FileReader(file));
				
		while(true)
		{
			String data = CVDB.readLine();
			
			if(data == null)break; //if not exist variable 'exist' = 0

			aCVdata = data.split("@");//

			if(aCVdata[0].equals(student.studentNumber))
			{
				System.out.printf("\nstudent number : %s\ndispatch semester : %s\ndispatch univ : %s\ncompleteCredit : %s\nsubjects : %s\npermission : %s\n", aCVdata[0] , aCVdata[1], aCVdata[2], aCVdata[3], aCVdata[4], aCVdata[5]);
				CVDB.close();
				
				break;
			}
		}
	}
	
	@SuppressWarnings("resource")
	public static void DeleteCV(Student student) throws IOException {
		BufferedReader CVDB = null;
		File file2 = new File("CreditValidationInfo.txt");
		CVDB = new BufferedReader(new FileReader(file2));		
		
		ArrayList<String> CVdatas = new ArrayList<String>();
		String aCVdata[];
		CVdatas.clear();
		int i = 0, change = 0;
		while(true) {
			String ddata = CVDB.readLine(); 
			if(ddata == null)
				break;
			CVdatas.add(ddata);
		}

		i = 0;
		while(true) {
			aCVdata = CVdatas.get(i).split("@");
			
			if(aCVdata[0].equals(student.studentNumber)) {
				change = i;
				break;
			}
			i++;
		}
		
		file2.delete();
		CVdatas.remove(change);
		PrintWriter saver = new PrintWriter(new FileWriter("CreditValidationInfo.txt"));
		for(int j = 0; j < CVdatas.size(); j++) {
			aCVdata = CVdatas.get(j).split("@");

			saver.printf("%s@%s@%s@%s@%s@%s\n", aCVdata[0] , aCVdata[1], aCVdata[2], aCVdata[3], aCVdata[4], aCVdata[5]);
		}
		saver.close();
	}
	
}