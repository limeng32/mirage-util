package limeng32.mirage.util.pojo;

import java.util.Collection;

public interface PojoFace<T> {

	Integer getId();

	/* 获取供缓存使用的key值 */
	String getCacheKey();

	/** 从集合c中找到与自身hashCode相同的对象并返回,如没有找到则返回null */
	T extract(Collection<T> c);

}