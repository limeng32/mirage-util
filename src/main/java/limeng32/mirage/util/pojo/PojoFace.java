package limeng32.mirage.util.pojo;

public interface PojoFace<T> {

	Integer getId();

	void setId(Integer id);

	/* 获取供缓存使用的key值 */
	String getHash();

	/* 在业务逻辑上相同 */
	boolean equalsExactly(Object obj);
}