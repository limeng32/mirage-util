package limeng32.mirage.util;

import junit.framework.Assert;

import org.junit.Before;
import org.junit.Test;

public class PojoTest {

	AccountForTest a1;

	AccountForTest a2;

	@Before
	public void prepare() {
		a1 = new AccountForTest();
		a1.setId(1);
		a1.setEmail("a");
		a2 = new AccountForTest();
		a2.setId(1);
		a2.setEmail("b");
	}

	@Test
	public void testPojo() {
		Assert.assertEquals(a1.hashCode(), a2.hashCode());
		Assert.assertTrue(a1.equals(a2));
		Assert.assertFalse(a1.equalsExactly(a2));
	}

}
