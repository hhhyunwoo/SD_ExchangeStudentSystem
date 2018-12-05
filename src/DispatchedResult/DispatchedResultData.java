package DispatchedResult;

public class DispatchedResultData {
	String year,english,europe, china, japan, etc;

	public DispatchedResultData(String year, String number1,String number2,String number3,String number4,String number5) {
		this.year = year;
		this.english = number1;
		this.europe = number2;
		this.china = number3;
		this.japan = number4;
		this.etc = number5;
	}
	
	public String getYear() {
		return year;
	}

	public void setYear(String year) {
		this.year = year;
	}

	public String getEnglish() {
		return english;
	}

	public void setEnglish(String english) {
		this.english = english;
	}

	public String getEurope() {
		return europe;
	}

	public void setEurope(String europe) {
		this.europe = europe;
	}

	public String getChina() {
		return china;
	}

	public void setChina(String china) {
		this.china = china;
	}

	public String getJapan() {
		return japan;
	}

	public void setJapan(String japan) {
		this.japan = japan;
	}

	public String getEtc() {
		return etc;
	}

	public void setEtc(String etc) {
		this.etc = etc;
	}

	
	
}
