package Foundation;
import java.util.*;

import Application.ApplicationForm;
import Application.selectionManager;
import CreditValidation.CreditValidationForm;
import CreditValidation.CreditValidationManager;
import DispatchedResult.DispatchedResult;
import RecruitNotice.RecruitNoticeManager;
import User.Student;

import java.io.*;

public class main {
	public static int userNum = 0;

	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		int loginNumber = 0;
		String ID, PW, IDNumber;
		String savedID = null, savedPW = null, savedIDNumber = null;
		String line = null;
		String line2 = null;
		int num = 0;
		int err = 0;

		String loginInfo = "loginInfo.txt";
		System.out.println("*************** KNU교환학생 지원 시스템 ***************");
		System.out.println("	      YES 계정으로 로그인 해주세요\n\n");

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
					System.out.println("####ID 또는 PW 잘못 입력하셨습니다.####");
					continue;
				} else {
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
		Student student = new Student();

		switch (userNum) {
		case 1:
			System.out.println("<메인 화면>			!학생!");
			file = new File("./StudentInfo/" + savedID + ".txt");
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

					student.ID = savedID;///////////////// student 생성하기
					student.PW = savedPW;
					student.name = txtArr[0];
					student.studentNumber = txtArr[1];
					student.grade = txtArr[2];
					student.major = txtArr[3];

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
			System.out.println("<메인 화면>			!관리자!");
			break;
		case 3:
			System.out.println("<메인 화면>			!교수!");
			break;
		}
		

		if (userNum == 1) {// 학생
			while (true) {
				System.out.println("1.모집공고조회");
				System.out.println("2.응시원서 작성");
				System.out.println("3.학점인정");
				System.out.println("4.나가기");

				System.out.print(":");
				num = scan.nextInt();
				RecruitNoticeManager RN1 = new RecruitNoticeManager();
				CreditValidationForm CV = new CreditValidationForm(student);

				if (num == 1) {// 모집공고조회
					
					RN1.checkRecruitNotice();
				} else if (num == 2) {//응시원서 작성
					ApplicationForm AF;
					AF = new ApplicationForm(student);
					AF.Check();
				} else if (num == 3) {//학점인정
					try {
						CV.playCV();
					} catch (IOException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
				}else if (num == 4) {
					break;
				}
			}

		} else if (userNum == 2) {// 관리자
			while (true) {
				System.out.println("1.모집공고조회");
				System.out.println("2.모집공고 게시/수정");
				System.out.println("3.합격자 선발");
				System.out.println("4.합격자 수정");
				System.out.println("5.파견실적 게시");
				System.out.println("6.학점인정 승인");
				System.out.println("7.나가기");

				System.out.print(":");
				num = scan.nextInt();
				RecruitNoticeManager RN2 = new RecruitNoticeManager();
				DispatchedResult DR = new DispatchedResult();
				//RecruitNoticeManager RN = new RecruitNoticeManager();
				//RecruitNoticeManager RN2 = new RecruitNoticeManager();
				CreditValidationManager CM = new CreditValidationManager();
				selectionManager SM = new selectionManager();
				if (num == 1) {// 모집공고조회
					RN2.checkRecruitNotice();
				} else if (num == 2) {// 모집공고 게시/수정
					RN2.addRecuritNotice();
				} else if (num == 3) {//합격자 선발
					selectionManager.selectCandidate();
				} else if (num == 4) {// 합격자 수정
					try {
						selectionManager.Adjust();
					} catch (IOException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
				} else if (num == 5) {// 파견실적 게시
					DR.writeResult();
				} else if (num == 6) {//학점인정 승인
					try {
						CM.manageCVList();
					} catch (IOException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
				} else if (num == 7) {
					break;
				}
			}

		} else if (userNum == 3)

		{// 교수
			while (true) {
				System.out.println("1.모집공고조회");
				System.out.println("2.파견실적 조회");
				System.out.println("3.나가기");

				System.out.print(":");
				num = scan.nextInt();
				RecruitNoticeManager RN3 = new RecruitNoticeManager();

				DispatchedResult DR2 = new DispatchedResult();
				if (num == 1) {// 모집공고조회
					RN3.checkRecruitNotice();
				} else if (num == 2) {// 파견실적조회
					DR2.printResult();
				}else if (num == 3) {
					break;
				}
			}
		}

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

}