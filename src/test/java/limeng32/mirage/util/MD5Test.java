package limeng32.mirage.util;

import static junit.framework.Assert.assertNotNull;

import org.junit.Test;

public class MD5Test {

	@Test
	public void MD5PurityTest() {
		String origin = "中文";
		String dist = MD5.MD5Purity(origin);
		assertNotNull(dist);
	}

}
