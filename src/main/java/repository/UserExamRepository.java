package repository;

import model.ExamSession;

import java.util.HashSet;
import java.util.Set;

/**
 * Created by s.huseynli on 7/3/2019.
 */
public class UserExamRepository extends StandardRepository<String, Set<ExamSession>> {

    @Override
    public Set<ExamSession> findByKey(String key) {
        return registry.get(key);
    }

    public void save(ExamSession examSession) {
        String key = examSession.getUser().getUsername();
        Set<ExamSession> sessions = registry.get(key);
        if (sessions==null){
            sessions = new HashSet<>();
            sessions.add(examSession);
            registry.add(key,sessions);
        }else {
            sessions.add(examSession);
        }
    }

    public void remove(String username) {
        registry.remove(username);
    }

    public void remove(ExamSession examSession) {
        registry.get(examSession.getUser().getUsername()).remove(examSession);
    }

    @Override
    public void save(Set<ExamSession> examSessions) {
    }

    @Override
    public void remove(Set<ExamSession> examSessions) {

    }
}
