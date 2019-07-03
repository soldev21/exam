package repository;

/**
 * Created by s.huseynli on 7/3/2019.
 */
public interface Repository<K,V> {
    V findByKey(K key);
    void save(V v);
    void remove(V v);
}
