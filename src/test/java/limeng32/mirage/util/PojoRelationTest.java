package limeng32.mirage.util;

import java.util.LinkedHashSet;

import junit.framework.Assert;

import org.junit.Before;
import org.junit.Test;

public class PojoRelationTest {

	Account a1;

	LoginLog l1;

	LoginLog l2;

	LoginLog l3;

	@Before
	public void prepare() {
		a1 = new Account();
		a1.setId(1);
		a1.setEmail("a");

		l1 = new LoginLog();
		l1.setId(1);
		l1.setLoginIP("a");

		l2 = new LoginLog();
		l2.setId(1);
		l2.setLoginIP("b");

		l3 = new LoginLog();
		l3.setId(3);
		l3.setLoginIP("a");
	}

	@Test
	public void testPojoRemove() {
		a1.addLoginLog(l1);
		a1.removeLoginLog(l2);
		Assert.assertEquals(0, a1.getLoginLog().size());
	}

	@Test
	public void testPojoRemove2() {
		a1.addLoginLog(l1);
		a1.removeLoginLog(l3);
		Assert.assertEquals(1, a1.getLoginLog().size());
	}

	@Test
	public void testPojoRemove3() {
		a1.addLoginLog(l1);
		Assert.assertNotNull(l1.getAccount());
		Assert.assertEquals(1, a1.getLoginLog().size());
		l1.setAccount(null);
		Assert.assertNull(l1.getAccount());
		Assert.assertEquals(0, a1.getLoginLog().size());
	}

	@Test
	public void testPojoRemove4() {
		l1.setAccount(a1);
		Assert.assertNotNull(l1.getAccount());
		Assert.assertEquals(1, a1.getLoginLog().size());
		a1.removeLoginLog(l1);
		Assert.assertNull(l1.getAccount());
		Assert.assertEquals(0, a1.getLoginLog().size());
	}

	@Test
	public void testPojoAdd() {
		a1.addLoginLog(l1);
		a1.addLoginLog(l3);
		int origin = a1.getLoginLog().size();
		a1.addLoginLog(l2);
		int andThen = a1.getLoginLog().size();
		Assert.assertEquals(0, andThen - origin);
		LoginLog l4 = new LoginLog();
		l4.setId(2014);
		a1.addLoginLog(l4);
		int thenAndThen = a1.getLoginLog().size();
		Assert.assertEquals(1, thenAndThen - origin);
	}

	@Test
	public void testMutableObjectsInHsahSet() {
		a1.addLoginLog(l1);
		a1.addLoginLog(l3);
		LinkedHashSet<LoginLog> lhsl = new LinkedHashSet<>(a1.getLoginLog());
		int origin = lhsl.size();
		l3.setId(1);
		int andThen = lhsl.size();
		Assert.assertEquals(0, origin - andThen);
		LinkedHashSet<LoginLog> lhsl2 = new LinkedHashSet<>(lhsl);
		int thenAndThen = lhsl2.size();
		Assert.assertEquals(1, origin - thenAndThen);
	}

}
