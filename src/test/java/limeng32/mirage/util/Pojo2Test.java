package limeng32.mirage.util;

import junit.framework.Assert;

import org.junit.Before;
import org.junit.Test;

public class Pojo2Test {

	AccountForTest a1;

	@Before
	public void prepare() {
		a1 = new AccountForTest();
		a1.setId(1);
		a1.setEmail("a");
	}

	@Test
	public void testEquals() {
		LoginLogForTest l1 = new LoginLogForTest(), l2 = new LoginLogForTest();
		a1.addLoginLogForTest(l1);
		a1.addLoginLogForTest(l2);
		Assert.assertEquals(2, a1.getLoginLogForTest().size());
	}
}
