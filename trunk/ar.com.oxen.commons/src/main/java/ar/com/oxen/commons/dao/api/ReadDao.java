package ar.com.oxen.commons.dao.api;

import java.util.List;

public interface ReadDao<T> {
	List<T> findAll();
}
