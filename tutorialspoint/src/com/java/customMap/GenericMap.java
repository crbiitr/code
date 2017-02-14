package com.java.customMap;

/**
 * Created by user on 12/2/16.
 */
public interface GenericMap<K, V> {
    void put(K key, V value);

    V get(K key);

    boolean delete(K key);

    boolean exist(K key);

    void showAllKeyValueInMap();

}