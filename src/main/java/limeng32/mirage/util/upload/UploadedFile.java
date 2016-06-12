package limeng32.mirage.util.upload;

import java.io.Serializable;

import com.alibaba.fastjson.annotation.JSONField;

public class UploadedFile implements Serializable {

	private static final long serialVersionUID = 1L;

	private Integer status;

	private String type;

	private String name;

	private String url;

	@JSONField(serialize = false)
	private String message;

	public Integer getStatus() {
		return status;
	}

	public void setStatus(Integer status) {
		this.status = status;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getUrl() {
		return url;
	}

	public void setUrl(String url) {
		this.url = url;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

}
