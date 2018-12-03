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

public class ApplicationForm {
	Student student;
	
	public ApplicationForm(Student student){
		this.student = student;
	}
	
	void Check() {
		int flag=0;
		try {
			flag = checkexist(Integer.parseInt(student.studentNumber));
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
				ViewAPP(flag);
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
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

	/*public static void main(String args[]) throws IOException {
		int flag = 2015111111;
				
		flag = checkexist(flag);
		
		if(flag == 1){
			System.out.print("exist");
			ViewAPP(flag);
		}
		else {
			System.out.println("Doesn't exist");
			WriteAPP();
		}
	}*/
	
	public static int checkexist(int SN) throws IOException//check existence of user's registeration form
	{
		int exist = 0;
		String StudentNumber;
		
		BufferedReader APPDB = null;
		File file = new File("RApplicationInfo.txt");
		
		APPDB = new BufferedReader(new FileReader(file));
		
		StudentNumber = String.valueOf(SN);
		
		while(true)
		{
			String data = APPDB.readLine();
			
			if(data == null)break; //if not exist variable 'exist' = 0

			data = data.substring(0, 10);//파일상 첫 10개 정수가 학번
			
			if(data.equals(StudentNumber))
			{
				exist = 1;
				APPDB.close();
				
				break;
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
			System.out.println("희망 파견권역을 선택하세요\n1.Europe\n2.English\n3.China\n4.Japan\n5.ETC\n희망지역 : ");
			
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
					wanteduniv[i] = sc.nextInt() - 1;
					
					/*중복확인 
					for(int j = 0; j < i; j++)
					{
						if(wanteduniv[j] == unum-1)
						{
							i--;
							System.out.println("이미 신청한 대학입니다.\n");
							break;
						}
						else
						{
							System.out.printf("%d", unum);
							wanteduniv[i] = unum-1;
							break;
						}
					}*/
				}
				
				for(int i = 0; i <3; i++)
				{
					System.out.printf("%d지망대학 : %s\n",i+1, univList.get(wanteduniv[i]));
				}
				
				System.out.println("\n저장하시겠습니까? 1.Yes 2.No\n");
				unum = sc.nextInt();
				
				if(unum == 1) {
					PrintWriter saver = new PrintWriter(new FileWriter("RApplicationInfo.txt", true));
					saver.printf("%d@%s@%s@%s@%s@%s@%s@%d@none\n", 1015999999 , "특별한", "컴퓨터학부", Region, univList.get(wanteduniv[0]),univList.get(wanteduniv[1]) ,univList.get(wanteduniv[2]) , 0 );
					
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
	public static void ViewAPP(int SN) throws IOException {
		
		String[] data;
		String appinfo, StudentNumber, StudentNumbers;
		
		BufferedReader R = null;
		File file = new File("RApplicationInfo.txt");
		R = new BufferedReader(new FileReader(file));
		
		StudentNumber = String.valueOf(SN);

		while(true)
		{
			appinfo = R.readLine();
			
			if(appinfo == null) {
				System.out.println("\nno more data");
				break; //if not exist variable 'exist' = 0
			}

			 StudentNumbers= appinfo.substring(0, 10);//파일상 첫 10개 정수가 학번
			
			if(StudentNumbers.equals(StudentNumber))
			{
				data = appinfo.split(" ");
				
				System.out.printf("지원한 권역 : %s\n\n1지망 대학 : %s\n2지망 대학 : %s\n3지망 대학 : %s\n", data[3], data[4], data[5], data[6]);
					
				break;
			}
		}
		
	}
}
