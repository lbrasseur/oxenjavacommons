package ar.com.oxen.commons.dao.api;

public interface CrudDao<T> extends CreateDao<T>, ReadDao<T>, UpdateDao<T>,
		DeleteDao<T> {
}
