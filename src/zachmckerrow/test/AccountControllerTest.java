package zachmckerrow.test;
import controlclasses.*;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class AccountControllerTest {

	AccountController ac;
	
	@BeforeEach
	void setUp() throws Exception {
		ac = new AccountController();
		ac.addMember("Zach McKerrow", "123456789", "1496 Bern Dr", "Spring Hill", "37174", "TN");
	}
	
	@Test
	void addMemberSuccess() {
		assertEquals("Zach McKerrow", ac.findMember("123456789").getName());
		ac.deleteMember("123456789");
	}
	
	@Test
	void addMemberFail() {
		int count = ac.getMembers().size();
		ac.addMember("Zach McKerrow", "123456789", "1496 Bern Dr", "Spring Hill", "37174", "TN");
		assertEquals(count, ac.getMembers().size());
		ac.deleteMember("123456789");
	}
	
	@Test
	void addManagerSuccess() {
		ac.addManager("234567890");
		assertEquals("234567890",ac.findManager("234567890"));
		ac.deleteManager("234567890");
	}
	
	@Test
	void addManagerFail() {
		int count = ac.getManagers().size();
		ac.addManager("234567890");
		ac.addManager("234567890");
		assertEquals(count+1, ac.getManagers().size());
		ac.deleteManager("234567890");
	}
	
	@Test
	void deleteMemberSuccess() {
		ac.deleteMember("123456789");
		assertNull(ac.findMember("123456789"));
	}
	
	@Test
	void deleteManagerSuccessAndSanity() {
		ac.addManager("234567890");
		ac.deleteManager("234567890");
		assertNull(ac.findManager("234567890"));
	}
	
	@Test
	void memberSanity() {
		ac.addMember("blah", "123456780", "blah", "blah", "blah", "blah");
		ac.deleteMember("123456780");
		assertNull(ac.findMember("123456780"));
	}
	
	@Test
	void updateMemberSuccess() {
		ac.updateMember("123456789", "name", "Zach");
		assertEquals("Zach", ac.findMember("123456789").getName());
		ac.deleteMember("123456789");
	}
	
	@Test
	void updateMemberFailure() {
		ac.updateMember("123456789", "n", "Zach");
		assertNotEquals("Zach", ac.findMember("123456789").getName());
		ac.deleteMember("123456789");
	}
}