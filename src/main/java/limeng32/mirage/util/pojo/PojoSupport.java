package limeng32.mirage.util.pojo;

import limeng32.mirage.util.MD5;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.annotation.JSONField;

public abstract class PojoSupport<T extends PojoSupport<T>> implements
		PojoFace<T> {

	@Override
	abstract public Integer getId();

	@Override
	abstract public void setId(Integer id);

	@JSONField(serialize = false)
	public String getHash() {
		return MD5.MD5Purity(JSON.toJSONString(this));
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((getId() == null) ? 0 : getId().hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		PojoSupport<?> other = (PojoSupport<?>) obj;
		if (getId() == null) {
			if (other.getId() != null)
				return false;
		} else if (!getId().equals(other.getId()))
			return false;
		return true;
	}
}
