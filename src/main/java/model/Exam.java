package model;

import java.util.Map;

/**
 * Created by s.huseynli on 7/3/2019.
 */
public class Exam {

    private int maxQuestions;
    private int questionCount;
    private Category category;
    private Map<Integer,Question> questions;

    public Category getCategory() {
        return category;
    }

    public void setCategory(Category category) {
        this.category = category;
    }

    public Map<Integer, Question> getQuestions() {
        return questions;
    }

    public void setQuestions(Map<Integer, Question> questions) {
        this.questions = questions;
    }

    public boolean addQuestion(Question question){
        if (maxQuestions == questions.size()) return false;
        questions.put(questionCount++,question);
        return true;
    }


}
