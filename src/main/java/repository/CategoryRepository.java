package repository;

import model.Category;

/**
 * Created by s.huseynli on 7/3/2019.
 */
public class CategoryRepository extends StandardRepository<String, Category> {

    @Override
    public Category findByKey(String key) {
        return registry.get(key);
    }

    @Override
    public void save(Category category) {
        registry.add(category.getShortName(),category);
    }

    @Override
    public void remove(Category category) {
        registry.remove(category.getShortName());
    }
}
