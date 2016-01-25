package limeng32.mirage.util.pojo;

public interface PojoFace<T> {

	Integer getId();

	/* 获取供缓存使用的key值 */
	String getCacheKey();

}