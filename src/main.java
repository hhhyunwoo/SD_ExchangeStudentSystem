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
		System.out.println("*************** KNU교환학생 지원 시스템 ***************");
		System.out.println("YES 계정으로 로그인 해주세요");

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
		 * // 파일 객체 생성
		 * 
		 * // 파일안에 문자열 쓰기 fw.write("\n" + ID + "@" + PW + "#" + IDNumber); fw.flush();
		 * 
		 * // 객체 닫기 fw.close();
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
					System.out.println("####ID 또는 PW 잘못 입력하셨습니다.####");
					continue;
				}
				else {
					System.out.println("로그인 성공");
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
			System.out.println("<메인 화면>			!학생!");
			break;
		case 2:
			System.out.println("<메인 화면>			!관리자!");
			break;
		case 3:
			System.out.println("<메인 화면>			!교수!");
			break;
		}


		if (userNum == 1) {// 학생
			System.out.println("1.모집공고조회");
			System.out.println("2.응시원서 작성");
			System.out.println("3.학점인정");

			System.out.print(":");
			num = scan.nextInt();
		} else if (userNum == 2) {// 관리자
			System.out.println("1.모집공고조회");
			System.out.println("2.모집공고 게시/수정");
			System.out.println("3.합격자 선발(평가점수 입력)");
			System.out.println("4.파견실적 게시");
			System.out.println("5.학점인정 승인");

			System.out.print(":");
			num = scan.nextInt();

		} else if (userNum == 3) {// 교수
			System.out.println("1.모집공고조회");
			System.out.println("2.파견실적 조회");

			System.out.print(":");
			num = scan.nextInt();
		}

	}

}