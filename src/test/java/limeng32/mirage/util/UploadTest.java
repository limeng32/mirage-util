package limeng32.mirage.util;

import junit.framework.Assert;
import limeng32.mirage.util.upload.UploadNamingPolicy;

import org.junit.Test;

public class UploadTest {

	/* 测试UploadNamingPolicy对无后缀的文件能否正常命名 */
	@Test
	public void testNamingPolicy() {
		String uuidName1 = UploadNamingPolicy.uuidName("as.d");
		String uuidName2 = UploadNamingPolicy.uuidName("asd");
		Assert.assertEquals(38, uuidName1.length());
		Assert.assertEquals(36, uuidName2.length());
		String dateWithUUIDName1 = UploadNamingPolicy.dateWithUUIDName("as.d");
		String dateWithUUIDName2 = UploadNamingPolicy.dateWithUUIDName("asd");
		Assert.assertEquals(49, dateWithUUIDName1.length());
		Assert.assertEquals(47, dateWithUUIDName2.length());
	}
}
