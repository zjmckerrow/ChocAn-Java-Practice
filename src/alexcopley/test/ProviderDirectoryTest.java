package alexcopley.test;
import entityclasses.*;
import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class ProviderDirectoryTest {
	
	ProviderDirectory pd;
	Service s, t;
	
	@BeforeEach
	void setUp() throws Exception {
		pd = new ProviderDirectory();
	}

	@Test
	void findServiceSuccess() {
		pd.addService("123490", "Fun", 100.00);
		t = pd.findService("123490");
		assertEquals(t.getName(), "Fun");
	}
	
	@Test
	void findServiceFailure() {
		t = pd.findService("1");
		assertNull(t);
	}
	
	@Test
	void addServiceSuccess () {
		pd.addService("123478", "Rejuvinative Fiddling", 999.99);
		t = pd.findService("123478");
		assertEquals(t.getCode(), "123478");
	}
	
	@Test
	void addServices() {
		pd.addService("123456", "Doctor Visit", 100.00);
		pd.addService("123457", "Yoga", 25.00);
		pd.addService("123458", "Dietician Visit", 50.00);
	}
}
