package DispatchedResult;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

import Foundation.Clear;

public class DispatchedResult {
	DispatchedResultData[] DR = new DispatchedResultData[100];
	Scanner input = new Scanner(System.in);
	public DispatchedResult() {

		File file;
		FileWriter fw = null;
		int i = 0, j = 0;
		String line = null;
		file = new File("DispatchResult.txt");
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
				DR[i] = new DispatchedResultData(txtArr[j++], txtArr[j++], txtArr[j++], txtArr[j++], txtArr[j++],
						txtArr[j++]);
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

	public void printResult() {// 파견실적 출력
		Clear.clearScreen();
		int i = 0;

		System.out.printf("\n %3s %10s %9s %9s %9s %9s\n", "년도", "영어권대학(명)", "유럽대학(명)", "일본대학(명)", "중국대학(명)",
				"기타대학(명)");

		while ((DR[i] != null)) {
			System.out.printf("%4s %10s %10s %10s %10s %10s\n", DR[i].getYear(), DR[i].getEnglish(), DR[i].getEurope(),
					DR[i].getChina(), DR[i].getJapan(), DR[i].getEtc());
			i++;
		}
	}

	public void writeResult() {
		Clear.clearScreen();

		// 게시
		System.out.println("게시할 모집공고 내용을 입력해주세요.");
		System.out.print("년도 : ");
		String year = input.nextLine();

		System.out.print("영어권대학 : ");
		String english = input.nextLine();

		System.out.print("유럽대학 : ");
		String europe = input.nextLine();

		System.out.print("중국대학 : ");
		String china = input.nextLine();

		System.out.print("일본대학 : ");
		String japan = input.nextLine();

		System.out.print("기타대학 : ");
		String etc = input.nextLine();

		BufferedWriter bufferedWriter;
		try {
			bufferedWriter = new BufferedWriter(new FileWriter("DispatchResult.txt", true));
			bufferedWriter.write("\n" + year + "@" + english + "@" + europe + "@" + china + "@" + japan + "@" + etc);
			bufferedWriter.close();
		} catch (IOException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
	}

}
