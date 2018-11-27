import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

public class RecruitNotice {
	int j = 0;
	String line = null;
	String recruitPeriod = null;
	int i = 0;
	String DUInfo = "DUInfo.txt";
	DispatchedUniversity[] DU = new DispatchedUniversity[100];
	File file = new File(DUInfo);
	FileWriter fw = null;
	Scanner input = new Scanner(System.in);

	
	public RecruitNotice() {
		DU[i]= new DispatchedUniversity();
		try
		{
			fw = new FileWriter(file, true);
		}catch(IOException e1)
		{
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		
		

		BufferedReader br = null;
		try
		{
			br = new BufferedReader(new FileReader(file));

			while ((line = br.readLine()) != null) {

				String[] txtArr = line.split("@");

				DU[i].region = txtArr[j++];
				DU[i].usingLanguage = txtArr[j++];
				DU[i].major = txtArr[j++];
				DU[i].country = txtArr[j++];
				DU[i].KschoolName = txtArr[j++];
				DU[i].EschoolName = txtArr[j++];
				DU[i].recruitNumber = txtArr[j++];
				DU[i].applicationQualification = txtArr[j++];
				DU[i].dispatchPeriod = txtArr[j++];
				DU[i].etc = txtArr[j++];
			
				i++;
			}


		}catch(FileNotFoundException e)
		{
			e.printStackTrace();
		}catch(IOException e)
		{
			e.printStackTrace();
		}finally{
			if (br != null)
				try {
					br.close();
				} catch (IOException e) {
				}
		}
	}
	
	
	void checkRecruitNotice() {
		System.out.println("1. 지역을 입력하세요");
		String regStr = null;
		System.out.println("1)영어권대학	2)유럽권대학	3)일본대학		4)중국대학		5)기타대학 		6)전체\n:");
	
		int region = input.nextInt();
		
		switch(region){
			case 1:
				regStr = "English";
				break;
			case 2:
				regStr = "Europe";
				break;
			case 3:
				regStr = "Japan";
				break;
			case 4:
				regStr = "China";
				break;
			case 5:
				regStr = "ETC";
				break;
			default :
				break;	
		}
		
		System.out.println("2. 사용언어를 입력하세요\n(영어로 입력해주세요,all 가능)");
		String lang = null;
		lang = input.next();
		
		

	}
}
