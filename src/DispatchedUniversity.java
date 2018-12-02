import java.io.File;
import java.io.FileWriter;

public class DispatchedUniversity {
	String region, usingLanguage, major, country, KschoolName, EschoolName, 
		recruitNumber, applicationQualification, dispatchPeriod, etc = null;

	public DispatchedUniversity(String region, String usingLanguage, String major, String country, 
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
	public DispatchedUniversity() {}
}
