import java.util.*;
import java.io.*;

public class main {

	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		int loginNumber = 0;
		String ID, PW, IDNumber;
		String savedID, savedPW, savedIDNumber = null;
		String line = null;
		int num = 0;
		int err = 0;
		int userNum = 0;
		String loginInfo = "loginInfo.txt";
		System.out.println("*************** KNU��ȯ�л� ���� �ý��� ***************");
		System.out.println("YES �������� �α��� ���ּ���");

		File file = new File(loginInfo);
		FileWriter fw = null;

		try {
			fw = new FileWriter(file, true);
		} catch (IOException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}

		/*
		 * if (loginNumber == 1) { System.out.print("IDNumber:"); IDNumber =
		 * scan.next(); System.out.print("ID:"); ID = scan.next();
		 * System.out.print("PW:"); PW = scan.next();
		 * 
		 * try {
		 * 
		 * // ���� ��ü ����
		 * 
		 * // ���Ͼȿ� ���ڿ� ���� fw.write("\n" + ID + "@" + PW + "#" + IDNumber); fw.flush();
		 * 
		 * // ��ü �ݱ� fw.close();
		 * 
		 * } catch (Exception e) { e.printStackTrace(); }
		 */

		while (true) {//login check
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
				}
				else {
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
		switch(userNum) {
		case 1:
			System.out.println("<���� ȭ��>			!�л�!");
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

	}

}