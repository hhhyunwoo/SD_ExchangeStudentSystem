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

	public void addRecuritNotice() {// �������� �Խ�/����
		
		
		Clear.clearScreen();
		System.out.println("1.�Խ�	2.����");
		int num = input.nextInt();
		if(num == 2) {//����
			printRecruit();
			fw = null;
			try {
				fw = new FileWriter(file, true);
			} catch (IOException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
			System.out.println("������ �� ���� �Է����ּ���.");
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
		// �������� �Խ�/����
		else if (num == 1) {//�Խ�
			System.out.println("�Խ��� �������� ������ �Է����ּ���.");
			input.nextLine();
			System.out.print("�ǿ� : ");
			String region = input.nextLine();
			System.out.print("����� : ");
			String using = input.nextLine();
			System.out.print("�а� : ");
			String major = input.nextLine();
			System.out.print("���� : ");
			String country = input.nextLine();
			System.out.print("���и�(��) : ");
			String kuniv = input.nextLine();
			System.out.print("���и�(��) : ");
			String uuniv = input.nextLine();
			System.out.print("�����ο� : ");
			String renum = input.nextLine();
			System.out.print("�ڰ� : ");
			String qulification = input.nextLine();

			System.out.print("�Ⱓ : ");
			String during = input.nextLine();

			System.out.print("��Ÿ(������ nothing) : ");
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

	public void checkRecruitNotice() {// �������� ��ȸ
		
		Clear.clearScreen();
		System.out.println("1. ������ �Է��ϼ���");
		System.out.println("1)����Ǵ���	2)�����Ǵ���	3)�Ϻ�����		4)�߱�����		5)��Ÿ���� 		6)��ü\n:");

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

		System.out.println("2. ���� �Է��ϼ���");


		System.out.println("1)����	2)�߱���		3)�Ϻ���		4)��ü\n:");
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

		System.out.println("3. ���ϴ� �а��� �Է��ϼ���");
		System.out.println("1)��ǻ���к�	2)IT����		3)����		4)��ü\n:");
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
	
	void printRecruit() { //�������� ���
		String all = "All";
		Clear.clearScreen();
		System.out.printf("\n \t %4s %7s %16s %20s %10s %15s %10s %10s %20s %10s", "����", "�����", "�а�", "�����̸�",
				"���и�(����)", "���и�(����)", "�����ο�", "��������", "�İ߱Ⱓ", "��Ÿ");
		int i = 0;
		int j = 1;

		while (DU[i] != null) {

			if (regStr.equals(all) || usingLang.equals(all) || major.equals(all)) {

				if (regStr.equals(all)) {
					if (usingLang.equals(all)) {
						if (major.equals(all)) {
							// 3�� all
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

	
	int reSearch() { //��˻� ���� Ȯ��
		System.out.println("\n\n��˻� �Ͻðڽ��ϱ�? \n");
		if(main.userNum == 1)
			System.out.println("1. Yes		2.No\n:");
		else 
			System.out.println("1. Yes		2.No		3.�������� �Խ�/�������� ����\n:");
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
