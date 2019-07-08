package util;

import dao.CategoryDao;
import dao.ExamDao;
import dao.UserDao;
import model.Category;
import model.Exam;
import model.User;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Scanner;

/**
 * Created by s.huseynli on 7/3/2019.
 */
public class Util {

    private  static  BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

    public static boolean checkString(String s){
        return s!=null && !s.isEmpty();
    }

    public static boolean changePassword(User user){
        print("Please enter new password: ");
        String s  = read();
        if (!s.isEmpty()) user.setPassword(getHashed(s)); else {
            println("Password unsuccessfully changed");
            return false;
        };
        UserDao.userRepository.save(user);
        println("Password successfully changed");
        return true;
    }

    public static boolean createCategory(){
        Category category = new Category();
        print("Enter category name: ");
        category.setDescription(read());
        print("Enter category name: ");
        category.setShortName(read());
        print("Enter sub category name: ");
        category.setSubCategory(read());
        CategoryDao.categoryRepository.save(category);
        return true;
    }

    public static String read(){
        try {
            return reader.readLine();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }

    public static void createExam(){
        Exam exam = new Exam();
        print("Enter max question: ");
        exam.setMaxQuestions(Integer.valueOf(read()));
        println("Choose category");
        CategoryDao.categoryRepository.findALL().forEach(c->{
            print(c.getShortName());
        });
        exam.setCategory(CategoryDao.categoryRepository.findByKey(read()));
        ExamDao.examRepository.save(exam);
    }

    public static void editUser(){

    }

    public static void print(String s){
        System.out.print(s);
    }

    public static void println(String s){
        System.out.println(s);
    }

    public static String getHashed(String s){
        return s;
    }
}
