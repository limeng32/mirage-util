package limeng32.mirage.util.mapper;

import java.util.Collection;

public interface MapperFace<T> {

	public T select(int id);

	public Collection<T> selectAll(T t);

	public void insert(T t);

	public void update(T t);

	public void updatePersistent(T t);

	public void retrieve(T t);

	public void retrieveOnlyNull(T t);

	public void delete(T t);

	public int count(T t);
}
