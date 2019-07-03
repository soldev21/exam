package model;

import java.util.Map;

/**
 * Created by s.huseynli on 7/3/2019.
 */
public class ExamSession {

    User user;
    Exam exam;
    int correctAnswers;

    private Map<Integer,Boolean> answerHistory;

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public Exam getExam() {
        return exam;
    }

    public void setExam(Exam exam) {
        this.exam = exam;
    }

    public int getCorrectAnswers() {
        return correctAnswers;
    }

    public void setCorrectAnswers(int correctAnswers) {
        this.correctAnswers = correctAnswers;
    }

    public Map<Integer, Boolean> getAnswerHistory() {
        return answerHistory;
    }

    public void setAnswerHistory(Map<Integer, Boolean> answerHistory) {
        this.answerHistory = answerHistory;
    }

    public Float getPercent(){
        return correctAnswers*100f/exam.getQuestions().entrySet().size();
    }

    public Float getTotalPoints(){
        final Float[] sum = {0f};
        answerHistory.forEach((k,v)->{
            int p = exam.getQuestions().get(k).getPoint();
            int c = exam.getQuestions().get(k).getWrongCoefficent();
            if (v)  sum[0]+=p; else sum[0]-=p/c;
        });
        return sum[0];
    }
}
