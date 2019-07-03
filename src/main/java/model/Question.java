package model;

import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/**
 * Created by s.huseynli on 7/3/2019.
 */
public class Question {

    private static int key = 65;

    private int id;
    private int maxAnswerCount;
    private String description;
    private Map<String,String> possibleAnswers;
    private String correctAnswer;

    public Question(int id, int maxAnswerCount){
        this.id = id;
        this.maxAnswerCount = maxAnswerCount;
        possibleAnswers = new HashMap<>();
    }

    public int getWrongCoefficent() {
        return wrongCoefficent;
    }

    public void setWrongCoefficent(int wrongCoefficent) {
        this.wrongCoefficent = wrongCoefficent;
    }

    int wrongCoefficent;

    private Integer point;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getMaxAnswerCount() {
        return maxAnswerCount;
    }

    public void setMaxAnswerCount(int maxAnswerCount) {
        this.maxAnswerCount = maxAnswerCount;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Map<String, String> getPossibleAnswers() {
        return possibleAnswers;
    }

    public void setPossibleAnswers(Map<String, String> possibleAnswers) {
        this.possibleAnswers = possibleAnswers;
    }

    public String getCorrectAnswer() {
        return correctAnswer;
    }

    public boolean setCorrectAnswer(String correctAnswer) {
        if (possibleAnswers.containsKey(correctAnswer))
        this.correctAnswer = correctAnswer; else return false;
        return true;
    }

    public Integer getPoint() {
        return point;
    }

    public void setPoint(Integer point) {
        this.point = point;
    }

    public String toString(){
        StringBuilder s = new StringBuilder();
        s.append(String.format("Question %d:\n%s\n",id,description));
        possibleAnswers.forEach((k, v)->{
            s.append(String.format("%s) %s\n",k,v));
        });
        return s.toString();
    }

    public String addAnswer(String answer){
        String a;
        if (possibleAnswers.size() == maxAnswerCount) return null;
        a = String.valueOf((char)key++);
        possibleAnswers.put(a,answer);
        return a;
    }

    public void removeAnswer(String key){
        possibleAnswers.remove(key);
        if (correctAnswer.equals(key)) correctAnswer = null;
    }


}
