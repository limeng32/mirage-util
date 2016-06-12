package limeng32.mirage.util.upload;

import java.util.Date;
import java.util.UUID;

import org.apache.commons.lang.time.FastDateFormat;

public class UploadNamingPolicy {

	public static final FastDateFormat ISO_DATE_FORMAT = FastDateFormat
			.getInstance("yyyy-MM-dd");

	public static String uuidName(String fileOriginalName) {
		int n = fileOriginalName.lastIndexOf(".");
		if (n != -1) {
			return UUID.randomUUID()
					+ fileOriginalName.substring(n, fileOriginalName.length());
		} else {
			return UUID.randomUUID() + "";
		}
	}

	public static String dateWithUUIDName(String fileOriginalName) {
		String dateString = ISO_DATE_FORMAT.format(new Date());
		int n = fileOriginalName.lastIndexOf(".");
		if (n != -1) {
			return dateString + "/" + UUID.randomUUID()
					+ fileOriginalName.substring(n, fileOriginalName.length());
		} else {
			return dateString + "/" + UUID.randomUUID();
		}
	}

}
