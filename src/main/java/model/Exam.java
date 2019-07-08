package model;

import java.util.Map;

/**
 * Created by s.huseynli on 7/3/2019.
 */
public class Exam {

    private int id;
    private String desc;
    private int maxQuestions;
    private int questionCount;
    private Category category;
    private Map<Integer,Question> questions;

    public int getMaxQuestions() {
        return maxQuestions;
    }

    public void setMaxQuestions(int maxQuestions) {
        this.maxQuestions = maxQuestions;
    }

    public int getQuestionCount() {
        return questionCount;
    }

    public void setQuestionCount(int questionCount) {
        this.questionCount = questionCount;
    }

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


    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getDesc() {
        return desc;
    }

    public void setDesc(String desc) {
        this.desc = desc;
    }
}
