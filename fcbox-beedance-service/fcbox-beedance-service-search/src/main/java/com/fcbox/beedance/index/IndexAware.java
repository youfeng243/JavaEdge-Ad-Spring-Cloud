package com.fcbox.beedance.index;

/**
 * @author youfeng(002934)
 * @date 2019-02-15
 */
public interface IndexAware<K, V> {

    /**
     * @param key
     * @return
     */
    V get(K key);

    /**
     * @param key
     * @param value
     */
    void add(K key, V value);


    /**
     * @param key
     * @param value
     */
    void update(K key, V value);

    /**
     * @param key
     * @param value
     */
    void delete(K key, V value);
}
