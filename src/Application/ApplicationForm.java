package Application;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Scanner;

import User.Student;

public class ApplicationForm {
	static Student student;
	
	public ApplicationForm(Student student){
		this.student = student;
	}
	
	public void Check() {
		int flag=0;
		try {
			flag = checkexist(student.studentNumber);
		} catch (NumberFormatException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		if(flag == 1){
			System.out.print("exist");
			try {
				ViewAPP(student.studentNumber);				
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			while(true) {
				System.out.println("want to cancel the application? 1.yes 2.no\n");
				Scanner sc = new Scanner(System.in);
				int d = sc.nextInt();
				if(d == 1) {
					DeleteAPP(student.studentNumber);
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
				WriteAPP();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}

	public static int checkexist(String SN) throws IOException//check existence of user's registeration form
	{
		int exist = 0;

		BufferedReader APPDB = null;
		File folder = new File("./ApplicationForm");
		File[] listoffile = folder.listFiles();		
		
		int i = 0;
		for(File file : listoffile)
		{
			if(file.isFile())
			{
				APPDB = new BufferedReader(new FileReader(file));

				String data = APPDB.readLine();

				if(data == null)break; //if not exist variable 'exist' = 0

				data = data.substring(0, 10);//파일상 첫 10개 정수가 학번
				
				if(data.equals(SN))
				{
					exist = 1;
					APPDB.close();
					
					break;
				}
				
			}
			
		}
		APPDB.close();
		return exist;
	}
	
	public static void WriteAPP() throws IOException {//write new application
		String[] data;
		int rnum;
		String Region = null;
		
		Scanner sc = new Scanner(System.in);

		
		while(true) {
			System.out.println("희망 파견권역을 선택하세요.\n1.Europe\n2.English\n3.China\n4.Japan\n5.ETC\n희망지역 : ");
			
			rnum = sc.nextInt();
			
			if(rnum <= 5)
				break;
			
			System.out.println("잘못된 입력 값 입니다.\n");
		}
		
		
		//console needs clear here
		
		switch(rnum)
		{
		case 1:
			Region = "Europe";
			break;
		case 2:
			Region = "English";
			break;
		case 3:
			Region = "China";
			break;
		case 4:
			Region = "Japan";
			break;
		case 5:
			Region = "ETC";
			break;
		}
		
		ArrayList<String> univList = new ArrayList<String>();
		
		while(true)
		{
			
			BufferedReader R = null;
			File file = new File("DUInfo.txt");
			
			R = new BufferedReader(new FileReader(file));
			
			univList.clear();
			
			while(true)
			{
				String univ = R.readLine();
				
				if(univ == null)break; //if not exist variable 'exist' = 0

				data = univ.split("@");
				
				univ = data[0];
				
				if(univ.equals(Region))
				{
					univList.add(data[5]);
				}
			}
			
			if(univList.size() > 0){
				System.out.println("지망 대학을 선택하세요.\n");

				
				for(int i = 0; i < univList.size() ; i++)
				{
					System.out.printf("%d. %s\n",i+1, univList.get(i));
				}
				
				int[] wanteduniv = new int[3];
				
				int unum;
				
				for(int i = 0; i < 3; i++)
				{
					System.out.printf("%d지망대학 : ", i+1 );
					int chosenuniv = sc.nextInt();
					if(chosenuniv > univList.size() || chosenuniv < 1)
					{
						System.out.println("invalid input\n");
						i--;
					}
					else {
						wanteduniv[i] = chosenuniv - 1;
					}
				}
				
				for(int i = 0; i <3; i++)
				{
					System.out.printf("%d지망대학 : %s\n",i+1, univList.get(wanteduniv[i]));
				}
				
				System.out.println("\n저장하시겠습니까? 1.Yes 2.No\n");
				unum = sc.nextInt();
				
				if(unum == 1) {
					PrintWriter saver = new PrintWriter(new FileWriter("./ApplicationForm/" + student.studentNumber + ".txt", true));
					saver.printf("%s@%s@%s@%s@%s@%s@%s@%d@not sorted yet\n", student.studentNumber , student.name, student.major, Region, univList.get(wanteduniv[0]),univList.get(wanteduniv[1]) ,univList.get(wanteduniv[2]) , 0 );
					
					saver.close();
					break;
				}
				
			}
			else {
					System.out.println("해당 지역은 현재 모집을 하고 있지 않습니다.\n"); //권역 선택으로 돌아가야함  
			}
			
		}
	
		
	}
	
	@SuppressWarnings("resource")
	public static void ViewAPP(String SN) throws IOException {
		
		String[] data;
		String appinfo, StudentNumber;
		
		BufferedReader R = null;
		File file = new File("./ApplicationForm/" + student.studentNumber + ".txt");
		R = new BufferedReader(new FileReader(file));
		

		while(true)
		{
			appinfo = R.readLine();
			
			if(appinfo == null) {
				break; //if not exist variable 'exist' = 0
			}

			 StudentNumber= appinfo.substring(0, 10);
			
			if(StudentNumber.equals(SN))
			{
				data = appinfo.split("@");
				
				System.out.printf("지원한 권역 : %s\n\n1지망 대학 : %s\n2지망 대학 : %s\n3지망 대학 : %s\n\n결과 : %s\n", data[3], data[4], data[5], data[6], data[8]);
					
				break;
			}
		}
		
	}

	public static void DeleteAPP(String SN) {
		File file = new File("./ApplicationForm/" + student.studentNumber + ".txt");
		file.delete();
			
		System.out.println("application deleted successfully\n");
		
	}

}