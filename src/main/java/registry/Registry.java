package registry;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by s.huseynli on 7/3/2019.
 */
public class Registry<K,V> {

    private Map<K,V> registry;

    public Map<K, V> getRegistry() {
        return registry;
    }

    public void setRegistry(Map<K, V> registry) {
        this.registry = registry;
    }

    public Registry(){
        registry = new HashMap<>();
    }

    public V add(K key,V value){
        return registry.put(key,value);
    }

    public V remove(K key){
        return registry.remove(key);
    }

    public V get(K key){
        return registry.get(key);
    }
}
