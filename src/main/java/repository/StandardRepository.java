package repository;

import registry.Registry;

import java.util.Set;

/**
 * Created by s.huseynli on 7/3/2019.
 */
public abstract class StandardRepository<K,V> implements Repository<K,V> {

    protected Registry<K,V> registry;

    StandardRepository(){
        registry = new Registry<>();
    }

    public Set<V> findALL(){
        return (Set<V>) registry.getRegistry().values();
    }

}
