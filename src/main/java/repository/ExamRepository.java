package repository;

import model.Exam;
import model.User;

/**
 * Created by s.huseynli on 7/3/2019.
 */
public class ExamRepository extends StandardRepository<Integer, Exam> {


    @Override
    public Exam findByKey(Integer key) {
        return registry.get(key);
    }

    @Override
    public void save(Exam exam) {
        registry.add(exam.getId(),exam);
    }

    @Override
    public void remove(Exam exam) {
        registry.remove(exam.getId());
    }
}
