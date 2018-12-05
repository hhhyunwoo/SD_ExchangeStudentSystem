package CreditValidation;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Scanner;

public class CreditValidationManager {

	public static void manageCVList() throws IOException {
		ArrayList<String> CreditValidationList = new ArrayList<String>();
		String[] data;
		int flag;
		Scanner sc = new Scanner(System.in);
		
		while(true)
		{
			BufferedReader R = null;
			File file = new File("CreditValidationInfo.txt");
			
			R = new BufferedReader(new FileReader(file));
			
			CreditValidationList.clear();
			
			System.out.println(" 학 번        파견학기      파견대학     이수학점       과목명     인정여부\n");
			int num = 1;
			while(true)
			{
				String CV = R.readLine();
				
				if(CV == null) {
					R.close();
					break; //if not exist variable 'exist' = 0
				}

				data = CV.split("@");
				
				CreditValidationList.add(data[0]);
				System.out.printf("%d. ", num++);
				for(int i= 0 ; i< data.length; i++ ) {
					System.out.printf("%s", data[i]);
					System.out.printf("   ");
				}
				System.out.println("");
					
			}
			
			System.out.println("선택할 학생의 index 번호를 입력하세요. 0.저장 후 종료");
			flag = sc.nextInt();
			
			if(flag > 0 && flag <= CreditValidationList.size()) {
				R = new BufferedReader(new FileReader(file));

				while(true)
				{
					String CV = R.readLine();
					
					if(CV == null)break; //if not exist variable 'exist' = 0

					data = CV.split("@");
					
					CV = data[0];
					
					if(CV.equals(CreditValidationList.get(flag-1)))
					{
						System.out.println(" 학 번        파견학기      파견대학     이수학점       과목명     인정여부\n");
						for(int i= 0 ; i< data.length; i++ ) {
							System.out.printf("%s", data[i]);
							System.out.printf("   ");
						}
						while(true) {
							System.out.println("\n1.승인 2.거부\n");
							flag = sc.nextInt();					
							
							BufferedReader CVDB = null;
							File file2 = new File("CreditValidationInfo.txt");
							CVDB = new BufferedReader(new FileReader(file2));		
							
							ArrayList<String> CVdatas = new ArrayList();
							String aCVdata[];
							CVdatas.clear();
							int i = 0, change = 0;
							while(true) {
								String ddata = CVDB.readLine(); 
								if(ddata == null)
									break;
								CVdatas.add(ddata);
							}
							
							while(true) {
								aCVdata = CVdatas.get(i).split("@");
								if(aCVdata[0].equals(data[0])) {
									change = i;
									break;
								}
								else if(i >= CVdatas.size()) {
									System.out.println("no match\n");
									break;
								}
								i++;
							}
							
							file2.delete();
							
							if(flag == 1) {
								//file valid
								aCVdata = CVdatas.get(change).split("@");
								CVdatas.remove(change);
								aCVdata[5] = "vaildation permitted";
								CVdatas.add(aCVdata[0] + "@" + aCVdata[1] + "@" + aCVdata[2] + "@" + aCVdata[3]+ "@" + aCVdata[4]+ "@" + aCVdata[5]);
								PrintWriter saver = new PrintWriter(new FileWriter("CreditValidationInfo.txt"));
								for(int j = 0; j < CVdatas.size(); j++) {
									aCVdata = CVdatas.get(j).split("@");

									saver.printf(CVdatas.get(j)+ "\n");
								}
								
								saver.close();
								break;
							}
							else if(flag == 2) {
								//file invalid
								aCVdata = CVdatas.get(change).split("@");
								CVdatas.remove(change);
								aCVdata[5] = "vaildation denied";
								CVdatas.add(aCVdata[0] + "@" + aCVdata[1] + "@" + aCVdata[2] + "@" + aCVdata[3]+ "@" + aCVdata[4]+ "@" + aCVdata[5]);
								PrintWriter saver = new PrintWriter(new FileWriter("CreditValidationInfo.txt"));
								for(int j = 0; j < CVdatas.size(); j++) {
									aCVdata = CVdatas.get(j).split("@");

									saver.printf(CVdatas.get(j)+ "\n");
								}
								
								saver.close();
								break;
							}
							else if(flag > 2 || flag < 1)
								System.out.println("wrong input");
						}
						
					}
					
				}
				
			}
			else if(flag > CreditValidationList.size()){
				System.out.println("wrong input\n");
			}
			else if(flag == 0) {
				break;
			}
		}
		
	}
}