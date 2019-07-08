package repository;

import java.util.Set;

/**
 * Created by s.huseynli on 7/3/2019.
 */
public interface Repository<K,V> {
    V findByKey(K key);
    Set<V> findALL();
    void save(V v);
    void remove(V v);

}
