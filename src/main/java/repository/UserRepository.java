package repository;

import model.User;

/**
 * Created by s.huseynli on 7/3/2019.
 */
public class UserRepository extends StandardRepository<String, User> {

    @Override
    public User findByKey(String key) {
        return registry.get(key);
    }

    @Override
    public void save(User user) {
        registry.add(user.getUsername(), user);
    }

    @Override
    public void remove(User user) {
        registry.remove(user.getUsername());
    }
}
