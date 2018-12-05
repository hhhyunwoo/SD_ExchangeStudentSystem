package RecruitNotice;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

import Foundation.Clear;
import Foundation.main;

public class RecruitNoticeManager {
	int reSearchNum=0;
	String line = null;
	String recruitPeriod = null;
	String regStr = "All";
	String usingLang = "All";
	String major = "All";
	int i = 0;
	String DUInfo = "DUInfo.txt";
	DispatchedUniv[] DU = new DispatchedUniv[1000];
	File file = new File(DUInfo);
	FileWriter fw = null;
	Scanner input = new Scanner(System.in);

	int j = 0;

	public RecruitNoticeManager() {
		i=0;j=0;
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

				//if(i==9)
				DU[i] = new DispatchedUniv(txtArr[j++], txtArr[j++], txtArr[j++], txtArr[j++], txtArr[j++],
						txtArr[j++], txtArr[j++], txtArr[j++], txtArr[j++], txtArr[j++]);
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
					fw.close();
				} catch (IOException e) {
				}
		}
	}

	public void addRecuritNotice() {// 모집공고 게시/수정
		
		
		Clear.clearScreen();
		System.out.println("1.게시	2.수정");
		int num = input.nextInt();
		if(num == 2) {//수정
			printRecruit();
			fw = null;
			try {
				fw = new FileWriter(file, true);
			} catch (IOException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
			System.out.println("삭제할 행 수를 입력해주세요.");
			int delnum = input.nextInt();
			int cnt = 1;
			BufferedReader br1 = null;

			try {
				br1 = new BufferedReader(new FileReader(file));

				while ((line = br1.readLine()) != null) {
					if(cnt == delnum)
						
					cnt ++;
				}

			} catch (FileNotFoundException e) {
				e.printStackTrace();
			} catch (IOException e) {
				e.printStackTrace();
			} finally {
				if (br1 != null)
					try {
						br1.close();
					} catch (IOException e) {
					}
			}
		}
		// 모집공고 게시/수정
		else if (num == 1) {//게시
			System.out.println("게시할 모집공고 내용을 입력해주세요.");
			input.nextLine();
			System.out.print("권역 : ");
			String region = input.nextLine();
			System.out.print("사용언어 : ");
			String using = input.nextLine();
			System.out.print("학과 : ");
			String major = input.nextLine();
			System.out.print("나라 : ");
			String country = input.nextLine();
			System.out.print("대학명(국) : ");
			String kuniv = input.nextLine();
			System.out.print("대학명(영) : ");
			String uuniv = input.nextLine();
			System.out.print("모집인원 : ");
			String renum = input.nextLine();
			System.out.print("자격 : ");
			String qulification = input.nextLine();

			System.out.print("기간 : ");
			String during = input.nextLine();

			System.out.print("기타(없으면 nothing) : ");
			String etc = input.nextLine();

			BufferedWriter bufferedWriter;
			try {
				bufferedWriter = new BufferedWriter(new FileWriter("DUInfo.txt", true));
				bufferedWriter.write("\n" + region + "@" + using + "@" + major + "@" + country + "@" + kuniv + "@"
						+ uuniv + "@"+renum+"@"+ qulification + "@" + during + "@" + etc);

				bufferedWriter.close();
			} catch (IOException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
		}
	}

	public void checkRecruitNotice() {// 모집공고 조회
		
		Clear.clearScreen();
		System.out.println("1. 지역을 입력하세요");
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
		
		printRecruit();
	}
	
	void printRecruit() { //모집공고 출력
		String all = "All";
		Clear.clearScreen();
		System.out.printf("\n \t %4s %7s %16s %20s %10s %15s %10s %10s %20s %10s", "지역", "사용언어", "학과", "나라이름",
				"대학명(국문)", "대학명(영문)", "모집인원", "지원조건", "파견기간", "기타");
		int i = 0;
		int j = 1;

		while (DU[i] != null) {

			if (regStr.equals(all) || usingLang.equals(all) || major.equals(all)) {

				if (regStr.equals(all)) {
					if (usingLang.equals(all)) {
						if (major.equals(all)) {
							// 3개 all
							System.out.printf("\n %2d. %7s %7s %16s %7s %10s %15s %7s %10s %10s %10s", j, DU[i].region,
									DU[i].usingLanguage, DU[i].major, DU[i].country, DU[i].KschoolName,
									DU[i].EschoolName, DU[i].recruitNumber, DU[i].applicationQualification,
									DU[i].dispatchPeriod, DU[i].etc);
							
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

	
	int reSearch() { //재검색 여부 확인
		System.out.println("\n\n재검색 하시겠습니까? \n");
		if(main.userNum == 1)
			System.out.println("1. Yes		2.No\n:");
		else 
			System.out.println("1. Yes		2.No		3.모집공고 게시/수정으로 가기\n:");
		reSearchNum = input.nextInt();
		if (reSearchNum == 1)
			checkRecruitNotice();
		else if(reSearchNum == 3)
			addRecuritNotice();
		else
			return 0;
		return 0;
	}

}
