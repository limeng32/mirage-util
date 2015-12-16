package limeng32.mirage.util;

import java.util.LinkedHashSet;

import junit.framework.Assert;

import org.junit.Before;
import org.junit.Test;

public class PojoRelationTest {

	AccountForTest a1;

	LoginLogForTest l1;

	LoginLogForTest l2;

	LoginLogForTest l3;

	@Before
	public void prepare() {
		a1 = new AccountForTest();
		a1.setId(1);
		a1.setEmail("a");

		l1 = new LoginLogForTest();
		l1.setId(1);
		l1.setLoginIP("a");

		l2 = new LoginLogForTest();
		l2.setId(1);
		l2.setLoginIP("b");

		l3 = new LoginLogForTest();
		l3.setId(3);
		l3.setLoginIP("a");
	}

	@Test
	public void testPojoRemove() {
		a1.addLoginLogForTest(l1);
		a1.removeLoginLogForTest(l2);
		Assert.assertEquals(0, a1.getLoginLogForTest().size());
	}

	@Test
	public void testPojoRemove2() {
		a1.addLoginLogForTest(l1);
		a1.removeLoginLogForTest(l3);
		Assert.assertEquals(1, a1.getLoginLogForTest().size());
	}

	@Test
	public void testPojoRemove3() {
		a1.addLoginLogForTest(l1);
		Assert.assertNotNull(l1.getAccountForTest());
		Assert.assertEquals(1, a1.getLoginLogForTest().size());
		l1.setAccountForTest(null);
		Assert.assertNull(l1.getAccountForTest());
		Assert.assertEquals(0, a1.getLoginLogForTest().size());
	}

	@Test
	public void testPojoRemove4() {
		l1.setAccountForTest(a1);
		Assert.assertNotNull(l1.getAccountForTest());
		Assert.assertEquals(1, a1.getLoginLogForTest().size());
		a1.removeLoginLogForTest(l1);
		Assert.assertNull(l1.getAccountForTest());
		Assert.assertEquals(0, a1.getLoginLogForTest().size());
	}

	@Test
	public void testPojoAdd() {
		a1.addLoginLogForTest(l1);
		a1.addLoginLogForTest(l3);
		int origin = a1.getLoginLogForTest().size();
		a1.addLoginLogForTest(l2);
		int andThen = a1.getLoginLogForTest().size();
		Assert.assertEquals(0, andThen - origin);
		LoginLogForTest l4 = new LoginLogForTest();
		l4.setId(2014);
		a1.addLoginLogForTest(l4);
		int thenAndThen = a1.getLoginLogForTest().size();
		Assert.assertEquals(1, thenAndThen - origin);
	}

	@Test
	public void testMutableObjectsInHsahSet() {
		a1.addLoginLogForTest(l1);
		a1.addLoginLogForTest(l3);
		LinkedHashSet<LoginLogForTest> lhsl = new LinkedHashSet<>(a1.getLoginLogForTest());
		int origin = lhsl.size();
		l3.setId(1);
		int andThen = lhsl.size();
		Assert.assertEquals(0, origin - andThen);
		LinkedHashSet<LoginLogForTest> lhsl2 = new LinkedHashSet<>(lhsl);
		int thenAndThen = lhsl2.size();
		Assert.assertEquals(1, origin - thenAndThen);
	}

}
