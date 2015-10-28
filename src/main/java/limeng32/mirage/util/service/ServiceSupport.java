package limeng32.mirage.util.service;

import java.lang.reflect.InvocationTargetException;
import java.util.Collection;

import limeng32.mirage.util.ReflectHelper;
import limeng32.mirage.util.mapper.MapperFace;
import limeng32.mirage.util.pojo.PojoSupport;

public abstract class ServiceSupport<T extends PojoSupport<T>> implements
		ServiceFace<T> {

	protected T supportSelect(MapperFace<T> mapper, int id) {
		return mapper.select(id);
	}

	protected Collection<T> supportSelectAll(MapperFace<T> mapper, T t) {
		return mapper.selectAll(t);
	}

	protected void supportInsert(MapperFace<T> mapper, T t) {
		mapper.insert(t);
	}

	protected void supportUpdate(MapperFace<T> mapper, T t) {
		mapper.update(t);
	}

	protected void supportUpdatePersistent(MapperFace<T> mapper, T t) {
		mapper.updatePersistent(t);
	}

	protected void supportRetrieve(MapperFace<T> mapper, T t) {
		try {
			ReflectHelper.copyBean(t, mapper.select(t.getId()));
		} catch (SecurityException | NoSuchFieldException
				| IllegalArgumentException | IllegalAccessException
				| InvocationTargetException e) {
			e.printStackTrace();
		}
	}

	protected void supportRetrieveOnlyNull(MapperFace<T> mapper, T t) {
		try {
			ReflectHelper.copyBeanByNullField(t, mapper.select(t.getId()));
		} catch (SecurityException | NoSuchFieldException
				| IllegalArgumentException | IllegalAccessException
				| InvocationTargetException e) {
			e.printStackTrace();
		}
	}

	protected void supportDelete(MapperFace<T> mapper, T t) {
		mapper.delete(t);
	}

	protected int supportCount(MapperFace<T> mapper, T t) {
		return mapper.count(t);
	}
}
