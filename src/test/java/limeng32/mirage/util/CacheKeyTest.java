package limeng32.mirage.util;

import junit.framework.Assert;

import org.junit.Before;
import org.junit.Test;

public class CacheKeyTest {

	AccountForTest a1;

	AccountForTest a2;

	LoginLogForTest l1;

	LoginLogForTest l2;

	LoginLogForTest l3;

	LoginLogForTest l4;

	@Before
	public void prepare() {
		a1 = new AccountForTest();
		a1.setId(1);
		a1.setEmail("a");

		a2 = new AccountForTest();
		a2.setId(1);
		a2.setEmail("a");

		l1 = new LoginLogForTest();
		l1.setId(1);
		l1.setLoginIP("a");

		l2 = new LoginLogForTest();
		l2.setId(1);
		l2.setLoginIP("a");

		l3 = new LoginLogForTest();
		l3.setId(3);
		l3.setLoginIP("c");

		l4 = new LoginLogForTest();
		l4.setId(3);
		l4.setLoginIP("c");
	}

	@Test
	public void testCacheKey() {
		a1.addLoginLogForTest(l1);
		l2.setAccountForTest(a2);
		Assert.assertEquals(l1.getCacheKey(), l2.getCacheKey());
		Assert.assertEquals(a1.getCacheKey(), a2.getCacheKey());
	}

	@Test
	public void testCacheKey2() {
		a1.addLoginLogForTest(l1);
		a1.addLoginLogForTest(l3);
		l2.setAccountForTest(a2);
		l4.setAccountForTest(a2);
		Assert.assertEquals(l1.getCacheKey(), l2.getCacheKey());
		Assert.assertEquals(a1.getCacheKey(), a2.getCacheKey());
	}

	@Test
	public void testCacheKey3() {
		a1.addLoginLogForTest(l3);
		a1.addLoginLogForTest(l1);
		l2.setAccountForTest(a2);
		l4.setAccountForTest(a2);
		Assert.assertFalse(l1.getCacheKey().equals(l2.getCacheKey()));
		Assert.assertFalse(a1.getCacheKey().equals(a2.getCacheKey()));
	}
}
