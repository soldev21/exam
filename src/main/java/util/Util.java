package util;

import dao.UserDao;
import model.User;

/**
 * Created by s.huseynli on 7/3/2019.
 */
public class Util {
    public static boolean checkString(String s){
        return s!=null && !s.isEmpty();
    }

    public static boolean changePassword(User user){
        print("Please enter new password: ");
        String s  = read();
        if (!s.isEmpty()) user.setPassword(getHashed(s)); else {
            print("Password successfully changed");
            return false;
        };
        UserDao.userRepository.save(user);
        print("Password successfully changed");
        return true;
    }

    public static String read(){
        return "";
    }

    public static void print(String s){

    }

    public static String getHashed(String s){
        return s;
    }
}
