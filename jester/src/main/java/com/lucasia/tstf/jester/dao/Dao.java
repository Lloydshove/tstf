package com.lucasia.tstf.jester.dao;

/**
 * User: lucasia
 */
public interface Dao<T, E> {

    E get(T key);

    void save(E entity);

    void delete(E entity);
}
