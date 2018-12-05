package RecruitNotice;
import java.io.File;
import java.io.FileWriter;

public class DispatchedUniv {
	String region, usingLanguage, major, country, KschoolName, EschoolName, 
		recruitNumber, applicationQualification, dispatchPeriod, etc = null;

	public DispatchedUniv(String region, String usingLanguage, String major, String country, 
			String KschoolName, String EschoolName, 
			String recruitNumber, String applicationQualification, String dispatchPeriod, String etc) {
		this.region = region;
		this.usingLanguage = usingLanguage;
		this.major = major;
		this.country = country;
		this.KschoolName = KschoolName;
		this.EschoolName = EschoolName;
		this.recruitNumber = recruitNumber;
		this.applicationQualification = applicationQualification;
		this.dispatchPeriod = dispatchPeriod;
		this.etc = etc;
	}
	
	public DispatchedUniv() {}
	
	public String getRegion() {
		return region;
	}
	public void setRegion(String region) {
		this.region = region;
	}
	public String getUsingLanguage() {
		return usingLanguage;
	}
	public void setUsingLanguage(String usingLanguage) {
		this.usingLanguage = usingLanguage;
	}
	public String getMajor() {
		return major;
	}
	public void setMajor(String major) {
		this.major = major;
	}
	public String getCountry() {
		return country;
	}
	public void setCountry(String country) {
		this.country = country;
	}
	public String getKschoolName() {
		return KschoolName;
	}
	public void setKschoolName(String kschoolName) {
		KschoolName = kschoolName;
	}
	public String getEschoolName() {
		return EschoolName;
	}
	public void setEschoolName(String eschoolName) {
		EschoolName = eschoolName;
	}
	public String getRecruitNumber() {
		return recruitNumber;
	}
	public void setRecruitNumber(String recruitNumber) {
		this.recruitNumber = recruitNumber;
	}
	public String getApplicationQualification() {
		return applicationQualification;
	}
	public void setApplicationQualification(String applicationQualification) {
		this.applicationQualification = applicationQualification;
	}
	public String getDispatchPeriod() {
		return dispatchPeriod;
	}
	public void setDispatchPeriod(String dispatchPeriod) {
		this.dispatchPeriod = dispatchPeriod;
	}
	public String getEtc() {
		return etc;
	}
	public void setEtc(String etc) {
		this.etc = etc;
	}
	
}
