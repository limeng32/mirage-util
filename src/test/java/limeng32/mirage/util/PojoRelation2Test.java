package limeng32.mirage.util;

import junit.framework.Assert;

import org.junit.Before;
import org.junit.Test;

import com.alibaba.fastjson.JSON;

public class PojoRelation2Test {

	AccountForTest a1, a1o, a2;

	LoginLogForTest l1, l1o, l2, l3;

	@Before
	public void prepare() {
		a1 = new AccountForTest();
		a1.setId(1);
		a1.setEmail("a1");

		a1o = new AccountForTest();
		a1o.setId(1);
		a1o.setEmail("a1");

		a2 = new AccountForTest();
		a2.setId(2);
		a2.setEmail("a2");

		l1 = new LoginLogForTest();
		l1.setId(1);
		l1.setLoginIP("l1");

		l1o = new LoginLogForTest();
		l1o.setId(1);
		l1o.setLoginIP("l1");

		l2 = new LoginLogForTest();
		l2.setId(2);
		l2.setLoginIP("l2");

		l3 = new LoginLogForTest();
		l3.setId(3);
		l3.setLoginIP("l3");
	}

	@Test
	public void testDistributedPojoRemove() {
		a1.addLoginLogForTest(l1);
		a1o.addLoginLogForTest(l1o);
		String a1Json1 = JSON.toJSONString(a1);
		String l1Json1 = JSON.toJSONString(l1);
		String a1oJson1 = JSON.toJSONString(a1o);
		String l1oJson1 = JSON.toJSONString(l1o);
		a1.removeLoginLogForTest(l1o);
		String a1Json2 = JSON.toJSONString(a1);
		String l1Json2 = JSON.toJSONString(l1);
		String a1oJson2 = JSON.toJSONString(a1o);
		String l1oJson2 = JSON.toJSONString(l1o);
		Assert.assertEquals(a1Json1, a1oJson1);
		Assert.assertEquals(l1Json1, l1oJson1);
		Assert.assertEquals(a1Json2, a1oJson2);
		Assert.assertEquals(l1Json2, l1oJson2);
	}

	@Test
	public void testDistributedPojoExchange() {
		a1.addLoginLogForTest(l1);
		a2.addLoginLogForTest(l2);
		String a1Json1 = JSON.toJSONString(a1);
		String l1Json1 = JSON.toJSONString(l1);
		String a2Json1 = JSON.toJSONString(a2);
		String l2Json1 = JSON.toJSONString(l2);
		a1.addLoginLogForTest(l2);
		a2.addLoginLogForTest(l1);
		String a1Json2 = JSON.toJSONString(a1);
		String l1Json2 = JSON.toJSONString(l1);
		String a2Json2 = JSON.toJSONString(a2);
		String l2Json2 = JSON.toJSONString(l2);
		Assert.assertEquals(a1Json1.length(), l1Json1.length());
		Assert.assertEquals(a2Json1.length(), l2Json1.length());
		Assert.assertEquals(a1Json2.length(), l1Json2.length());
		Assert.assertEquals(a2Json2.length(), l2Json2.length());
	}
}
