package maxmoling.test;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import controlclasses.AccountController;
import entityclasses.ServiceRecord;
import entityclasses.MemberAccount;
import entityclasses.ProviderAccount;
import entityclasses.Service;

class ServiceRecordTest {

	ServiceRecord sr;
	MemberAccount ma;
	ProviderAccount pa;
	Service s;
	AccountController ac;
	
	@BeforeEach
	void setUp() throws Exception {
		s = new Service("ChocMeeting", "code", 100.00);
		ma = new MemberAccount ("Pierce Moling", "123456789", "1204 Colony Drive", "Kearney", "64060", "MO");
		pa = new ProviderAccount ("Max Moling", "987654321", "101 Reed Street", "Tuscaloosa", "35401", "AL");
		sr = new ServiceRecord("April 23rd, 2019", "April 4th, 2019", ma, pa, s, "Needs more help");
	}
	
	@Test
	void getServiceDateSuccess() {
		assertEquals("April 4th, 2019", sr.getServiceDate());
	}
	
	@Test
	void getServiceDateFail() {
		assertNotEquals("April 5th, 2019", sr.getServiceDate());
	}
	
	@Test
	void getCommentsSuccess() {
		assertEquals("Needs more help", sr.getComments());
	}
	
	@Test
	void getCommentsFail() {
		assertNotEquals("Needs no help", sr.getComments());
	}

}
