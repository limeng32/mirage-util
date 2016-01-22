package limeng32.mirage.util.pojo;

import java.util.Collection;

import org.apache.commons.codec.digest.DigestUtils;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.annotation.JSONField;

public abstract class PojoSupport<T extends PojoSupport<T>> implements
		PojoFace<T> {

	@Override
	abstract public Integer getId();

	@Override
	@JSONField(serialize = false)
	public String getCacheKey() {
		return DigestUtils.md5Hex(JSON.toJSONString(this));
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

	@Override
	public T extract(Collection<T> c) {
		for (T i : c) {
			if (this.hashCode() == i.hashCode()) {
				return i;
			}
		}
		return null;
	}
}
