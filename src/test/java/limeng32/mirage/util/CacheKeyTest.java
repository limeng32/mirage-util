package limeng32.mirage.util;

import junit.framework.Assert;

import org.junit.Before;
import org.junit.Test;

public class CacheKeyTest {

	Account a1;

	Account a2;

	LoginLog l1;

	LoginLog l2;

	LoginLog l3;

	LoginLog l4;

	@Before
	public void prepare() {
		a1 = new Account();
		a1.setId(1);
		a1.setEmail("a");

		a2 = new Account();
		a2.setId(1);
		a2.setEmail("a");

		l1 = new LoginLog();
		l1.setId(1);
		l1.setLoginIP("a");

		l2 = new LoginLog();
		l2.setId(1);
		l2.setLoginIP("a");

		l3 = new LoginLog();
		l3.setId(3);
		l3.setLoginIP("c");

		l4 = new LoginLog();
		l4.setId(3);
		l4.setLoginIP("c");
	}

	@Test
	public void testCacheKey() {
		a1.addLoginLog(l1);
		l2.setAccount(a2);
		Assert.assertEquals(l1.getCacheKey(), l2.getCacheKey());
		Assert.assertEquals(a1.getCacheKey(), a2.getCacheKey());
	}

	@Test
	public void testCacheKey2() {
		a1.addLoginLog(l1);
		a1.addLoginLog(l3);
		l2.setAccount(a2);
		l4.setAccount(a2);
		Assert.assertEquals(l1.getCacheKey(), l2.getCacheKey());
		Assert.assertEquals(a1.getCacheKey(), a2.getCacheKey());
	}

	@Test
	public void testCacheKey3() {
		a1.addLoginLog(l3);
		a1.addLoginLog(l1);
		l2.setAccount(a2);
		l4.setAccount(a2);
		Assert.assertFalse(l1.getCacheKey().equals(l2.getCacheKey()));
		Assert.assertFalse(a1.getCacheKey().equals(a2.getCacheKey()));
	}
}
