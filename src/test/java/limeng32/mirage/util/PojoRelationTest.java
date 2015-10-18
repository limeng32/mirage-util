package limeng32.mirage.util;

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
	public void testPojoAdd() {
		a1.addLoginLog(l1);
		a1.addLoginLog(l2);
		Assert.assertEquals(1, a1.getLoginLog().size());
	}

	@Test
	public void testPojoAdd2() {
		a1.addLoginLog(l1);
		a1.addLoginLog(l3);
		Assert.assertEquals(2, a1.getLoginLog().size());
	}
}
