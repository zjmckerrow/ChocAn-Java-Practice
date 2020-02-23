package willdrennan.test;
import controlclasses.*;

import static org.junit.jupiter.api.Assertions.*;

import java.io.File;
import java.time.format.*;
import java.time.LocalDate;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class ReportControllerTest{
	AccountController ac;
	ReportController rep;
	@BeforeEach
	void setUp() throws Exception {
		ac = new AccountController();
		ac.addMember("Will Drennan", "112233445", "add", "Test", "37174", "TN");
	}
	
	
	@Test
	void MemberReportFailure() {
		rep = new ReportController();
		Assertions.assertThrows(NullPointerException.class, () -> {
			  rep.generateMemberReport("111111111");
		  });	//Intention is to show that wrong member number won't generate report
		ac.deleteMember("112233445");
	}
	
	@Test
	void memberReportSuccess() {
		rep = new ReportController();
		rep.generateMemberReport("112233445");
		LocalDate date = LocalDate.now();
		DateTimeFormatter formatter = DateTimeFormatter.ofPattern("MM-dd-yyyy");
		File file = new File("release/reports/member/Will Drennan"+ date.format(formatter) +".txt");
		assertTrue(file.exists());
		ac.deleteMember("112233445");
	}
	
	@Test
	void ProviderReportFailure() {
		rep = new ReportController();
		Assertions.assertThrows(NullPointerException.class, () -> {
			  rep.generateProviderReport("111111111");
		  });	//Intention is to show that wrong member number won't generate report
	}
	
	@Test 
	void providerReportSuccess() {
		ac.addProvider("Test", "122333444", "tes", "t", "555555", "NE");
		rep = new ReportController();
		rep.generateProviderReport("122333444");
		LocalDate date = LocalDate.now();
		DateTimeFormatter formatter = DateTimeFormatter.ofPattern("MM-dd-yyyy");
		File file = new File("release/reports/provider/Test"+ date.format(formatter) +".txt");
		assertTrue(file.exists());
		ac.deleteProvider("122333444");
	}
	
	@Test
	void managerSummaryReportSuccess(){
		ac.addManager("000000000");
		rep = new ReportController();
		rep.generateManagerSummaryReport();
		LocalDate date = LocalDate.now();
		DateTimeFormatter formatter = DateTimeFormatter.ofPattern("MM-dd-yyyy");
		File file = new File("release/reports/manager/"+ date.format(formatter) +".txt");
		assertTrue(file.exists());
		ac.deleteManager("000000000");
	}
	@Test
	void eftReportSuccess() {
		rep = new ReportController();
		rep.generateEFTReport();
		LocalDate date = LocalDate.now();
		DateTimeFormatter formatter = DateTimeFormatter.ofPattern("MM-dd-yyyy");
		File file = new File("release/reports/EFT/"+ date.format(formatter) +".txt");
		assertTrue(file.exists());
	}
}