import java.util.*;
import java.io.*;

public class main {

	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		int loginNumber = 0;
		String ID, PW, IDNumber;
		String savedID = null, savedPW = null, savedIDNumber = null;
		String line = null;
		String line2 = null;
		int num = 0;
		int err = 0;
		int userNum = 0;
		String loginInfo = "loginInfo.txt";
		System.out.println("*************** KNU��ȯ�л� ���� �ý��� ***************");
		System.out.println("	      YES �������� �α��� ���ּ���\n\n");

		File file = new File(loginInfo);
		FileWriter fw = null;

		try {
			fw = new FileWriter(file, true);
		} catch (IOException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}

		while (true) {// login check
			System.out.print("ID:");
			ID = scan.next();
			System.out.print("PW:");
			PW = scan.next();

			BufferedReader br = null;
			try {
				br = new BufferedReader(new FileReader(file));

				while ((line = br.readLine()) != null) {

					int idx = line.indexOf("@");

					int idx2 = line.indexOf("#");
					savedIDNumber = line.substring(0, idx);
					savedID = line.substring(idx + 1, idx2);
					savedPW = line.substring(idx2 + 1);

					if (savedID.equals(ID) && savedPW.equals(PW)) {
						err = 1;
						break;
					}
				}
				if (err == 0) {
					System.out.println("####ID �Ǵ� PW �߸� �Է��ϼ̽��ϴ�.####");
					continue;
				} else {
					System.out.println("�α��� ����");
					userNum = Integer.parseInt(savedIDNumber);
					break;
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

		//////////////////////////////////////////////////////////////
		Clear.clearScreen();
		Student student = new Student();
		
		
		switch (userNum) {
		case 1:
			System.out.println("<���� ȭ��>			!�л�!");
			file = new File("C:\\Users\\qgusd\\Desktop\\����\\�ڹ�\\workspace\\Go\\StudentInfo\\"+savedID+".txt");
			fw = null;

			try {
				fw = new FileWriter(file, true);
			} catch (IOException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}

			BufferedReader br = null;
			try {
				br = new BufferedReader(new FileReader(file));

				while ((line2 = br.readLine()) != null) {

					String[] txtArr = line2.split("#");

					student.ID = savedID;///////////////// student �����ϱ�
					student.PW = savedPW;
					student.name = txtArr[0];
					student.studentNumber = txtArr[1];
					student.grade = txtArr[2];
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
			break;

		case 2:
			System.out.println("<���� ȭ��>			!������!");
			break;
		case 3:
			System.out.println("<���� ȭ��>			!����!");
			break;
		}

		if (userNum == 1) {// �л�
			System.out.println("1.����������ȸ");
			System.out.println("2.���ÿ��� �ۼ�");
			System.out.println("3.��������");

			System.out.print(":");
			num = scan.nextInt();
		} else if (userNum == 2) {// ������
			System.out.println("1.����������ȸ");
			System.out.println("2.�������� �Խ�/����");
			System.out.println("3.�հ��� ����(������ �Է�)");
			System.out.println("4.�İ߽��� �Խ�");
			System.out.println("5.�������� ����");

			System.out.print(":");
			num = scan.nextInt();

		} else if (userNum == 3) {// ����
			System.out.println("1.����������ȸ");
			System.out.println("2.�İ߽��� ��ȸ");

			System.out.print(":");
			num = scan.nextInt();
		}

		RecruitNotice RN = new RecruitNotice();

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

		if (num == 1) {
			RN.checkRecruitNotice();
		}
		else if(num ==2) {
			ApplicationForm AF = new ApplicationForm(student.studentNumber);
			AF.Check();
		}

	}

}