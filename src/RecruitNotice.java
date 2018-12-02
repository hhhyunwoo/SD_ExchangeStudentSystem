import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

public class RecruitNotice {
	String line = null;
	String recruitPeriod = null;
	int i = 0;
	String DUInfo = "DUInfo.txt";
	DispatchedUniversity[] DU = new DispatchedUniversity[1000];
	File file = new File(DUInfo);
	FileWriter fw = null;
	Scanner input = new Scanner(System.in);

	int j = 0;

	public RecruitNotice() {
		try {
			fw = new FileWriter(file, true);
		} catch (IOException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}

		BufferedReader br = null;

		try {
			br = new BufferedReader(new FileReader(file));

			while ((line = br.readLine()) != null) {

				String[] txtArr = line.split("@");

				DU[i] = new DispatchedUniversity(txtArr[j++], txtArr[j++], txtArr[j++], txtArr[j++], txtArr[j++],
						txtArr[j++], txtArr[j++], txtArr[j++], txtArr[j++], txtArr[j]);
				i++;
				j = 0;
			}

		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
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

		switch (region) {
		case 1:
			regStr = "English";
			break;
		case 2:
			regStr = "Europe";
			break;
		case 3:
			regStr = "Japanese";
			break;
		case 4:
			regStr = "Chinese";
			break;
		case 5:
			regStr = "Etc";
			break;
		case 6:
			regStr = "All";
			break;
		}

		System.out.println("2. 사용언어를 입력하세요");
		String usingLang = null;
		System.out.println("1)영어	2)중국어		3)일본어		4)전체\n:");
		int Lang = input.nextInt();

		switch (Lang) {
		case 1:
			usingLang = "English";
			break;
		case 2:
			usingLang = "Chinese";
			break;
		case 3:
			usingLang = "Japanes";
			break;
		case 4:
			usingLang = "All";
			break;
		}

		System.out.println("3. 원하는 학과를 입력하세요");
		String major = null;
		System.out.println("1)컴퓨터학부	2)IT대학		3)경상대		4)전체\n:");
		int mj = input.nextInt();

		switch (mj) {
		case 1:
			major = "Computer Science";
			break;
		case 2:
			major = "IT";
			break;
		case 3:
			major = "Economical";
			break;
		case 4:
			major = "All";
			break;
		}


		String all = "All";
		Clear.clearScreen();
		System.out.printf("\n \t %4s %7s %16s %20s %10s %15s %10s %10s %20s %10s",
				"지역","사용언어","학과","나라이름","대학명(국문)","대학명(영문)","모집인원","지원조건","파견기간",	"기타");
		int i = 0;
		int j = 1;
		
		while (DU[i] != null) {

			if (regStr.equals(all) || usingLang.equals(all) || major.equals(all)) {

				if (regStr.equals(all)) {
					if (usingLang.equals(all)) {
						if (major.equals(all)) {
							// 3개 all
							System.out.printf("\n %2d. %7s %7s %16s %7s %10s %15s %7s %10s %10s %10s"
									,j, DU[i].region,DU[i].usingLanguage,DU[i].major,
									DU[i].country,DU[i].KschoolName,DU[i].EschoolName,DU[i].recruitNumber,
									DU[i].applicationQualification, DU[i].dispatchPeriod,DU[i].etc);
							/*System.out.println("\n" + j + ". " + DU[i].region + "  " + DU[i].usingLanguage + "  "
									+ DU[i].major + "  " + DU[i].country + "  " + DU[i].KschoolName + "  "
									+ DU[i].EschoolName + "  " + DU[i].recruitNumber + "  "
									+ DU[i].applicationQualification + "  " + DU[i].dispatchPeriod + "  " + DU[i].etc);*/
						} else {
							// reg , using all
							if (DU[i].major.equals(major)) {
								System.out.println("\n" + j + ". " + DU[i].region + "  " + DU[i].usingLanguage + "  "
										+ DU[i].major + "  " + DU[i].country + "  " + DU[i].KschoolName + "  "
										+ DU[i].EschoolName + "  " + DU[i].recruitNumber + "  "
										+ DU[i].applicationQualification + "  " + DU[i].dispatchPeriod + "  "
										+ DU[i].etc);
							}
						}
					}

					else if (major.equals(all)) {
						// reg, major all
						if (DU[i].usingLanguage.equals(usingLang)) {
							System.out.println("\n" + j + ". " + DU[i].region + "  " + DU[i].usingLanguage + "  "
									+ DU[i].major + "  " + DU[i].country + "  " + DU[i].KschoolName + "  "
									+ DU[i].EschoolName + "  " + DU[i].recruitNumber + "  "
									+ DU[i].applicationQualification + "  " + DU[i].dispatchPeriod + "  " + DU[i].etc);
						}
					} else {
						// reg
						if (DU[i].usingLanguage.equals(usingLang) && DU[i].major.equals(major)) {
							System.out.println("\n" + j + ". " + DU[i].region + "  " + DU[i].usingLanguage + "  "
									+ DU[i].major + "  " + DU[i].country + "  " + DU[i].KschoolName + "  "
									+ DU[i].EschoolName + "  " + DU[i].recruitNumber + "  "
									+ DU[i].applicationQualification + "  " + DU[i].dispatchPeriod + "  " + DU[i].etc);
						}
					}
				}

				else if (usingLang.equals(all)) {
					if (major.equals(all)) {
						// using, major all
						if (DU[i].region.equals(regStr)) {
							System.out.println("\n" + j + ". " + DU[i].region + "  " + DU[i].usingLanguage + "  "
									+ DU[i].major + "  " + DU[i].country + "  " + DU[i].KschoolName + "  "
									+ DU[i].EschoolName + "  " + DU[i].recruitNumber + "  "
									+ DU[i].applicationQualification + "  " + DU[i].dispatchPeriod + "  " + DU[i].etc);
						}
					} else {
						// using all
						if (DU[i].region.equals(regStr) && DU[i].major.equals(major)) {
							System.out.println("\n" + j + ". " + DU[i].region + "  " + DU[i].usingLanguage + "  "
									+ DU[i].major + "  " + DU[i].country + "  " + DU[i].KschoolName + "  "
									+ DU[i].EschoolName + "  " + DU[i].recruitNumber + "  "
									+ DU[i].applicationQualification + "  " + DU[i].dispatchPeriod + "  " + DU[i].etc);
						}
					}
				}

				else if (major.equals(all)) {
					// major all
					if (DU[i].region.equals(regStr) && DU[i].usingLanguage.equals(usingLang)) {
						System.out.println("\n" + j + ". " + DU[i].region + "  " + DU[i].usingLanguage + "  "
								+ DU[i].major + "  " + DU[i].country + "  " + DU[i].KschoolName + "  "
								+ DU[i].EschoolName + "  " + DU[i].recruitNumber + "  " + DU[i].applicationQualification
								+ "  " + DU[i].dispatchPeriod + "  " + DU[i].etc);
					}
				}
			}

			else if (DU[i].region.equals(regStr) && DU[i].usingLanguage.equals(usingLang)
					&& DU[i].major.equals(major)) {
				System.out.println("\n" + j + ". " + DU[i].region + "  " + DU[i].usingLanguage + "  " + DU[i].major
						+ "  " + DU[i].country + "  " + DU[i].KschoolName + "  " + DU[i].EschoolName + "  "
						+ DU[i].recruitNumber + "  " + DU[i].applicationQualification + "  " + DU[i].dispatchPeriod
						+ "  " + DU[i].etc);
			}
			i++;
			j++;
			/*
			 * System.out.println(RN.DU[0].region);
			 * System.out.println(RN.DU[0].usingLanguage);
			 * System.out.println(RN.DU[0].major); System.out.println(RN.DU[0].country);
			 * System.out.println(RN.DU[0].KschoolName);
			 * System.out.println(RN.DU[0].EschoolName);
			 * System.out.println(RN.DU[0].recruitNumber);
			 * System.out.println(RN.DU[0].applicationQualification);
			 * System.out.println(RN.DU[0].dispatchPeriod);
			 * System.out.println(RN.DU[0].etc);
			 */
		}
		
		reSearch();
		
	}
	
	int reSearch() {
		System.out.println("\n\n재검색 하시겠습니까? \n");
		System.out.println("1. Yes		2.No\n:");

		int ans = input.nextInt();
		if(ans == 1)
			checkRecruitNotice();
		else
			return 0;
		return 0;
	}
	
}
