package com.lucasia.tstf.jester.dao;

/**
 * User: lucasia
 */
public interface Dao<K, E> {

    E get(K key);

    void save(E entity);

    void delete(E entity);
}
