package carsonkeenan.test;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import entityclasses.MemberAccount;

class AccountTest {
	MemberAccount ma;
	
	@BeforeEach
	void setup() throws Exception {
		ma = new MemberAccount("Carson Keenan", "123456789", "1500 Springwood Ln", "Uniontown", "44685", "OH");
	}
	
	@Test
	void getNumberSuccess() {
		assertEquals("123456789", ma.getNumber());
	}
	
	@Test
	void getNumberFail() {
		assertNotEquals("987654321", ma.getNumber());
	}
	
	@Test 
	void setAddressSuccess() {
		ma.setAddress("130 N Scranton St");
		assertEquals("130 N Scranton St", ma.getAddress());
	}
	
	@Test
	void setAddressFail() {
		ma.setAddress("130 N Scranton St");
		assertNotEquals("1500 Springwood Ln", ma.getAddress());
	}
}