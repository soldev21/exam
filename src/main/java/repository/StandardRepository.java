package repository;

import registry.Registry;

/**
 * Created by s.huseynli on 7/3/2019.
 */
public abstract class StandardRepository<K,V> implements Repository<K,V> {

    protected Registry<K,V> registry;

    StandardRepository(){
        registry = new Registry<>();
    }

}
