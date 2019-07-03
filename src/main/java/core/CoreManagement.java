package core;

import dao.UserDao;
import model.User;
import registry.Authentication;

/**
 * Created by s.huseynli on 7/3/2019.
 */
public class CoreManagement {



    private static boolean initial =true;
    private static Authentication authentication = new Authentication();

    public User register(){

        User user;
        boolean b = false;
        if (initial){
            print("It is first login. Please set Admin details");
            user = register1();
            user.setAdmin(true);
            b= authentication.add(user);
            initial=false;
        }else {
            print("Please enter User details");
            user = register1();
            authentication.add(user);
        }
        return (b) ? user : null;
    }

    private User register1(){

        String s = null;
        User user = new User();
        print("Username: ");
        s = read();
        user.setUsername(s);
        print("Password: ");
        s = read();
        user.setPassword(s);
        print("Name: ");
        s = read();
        user.setName(s);
        print("Address: ");
        s = read();
        user.setAddress(s);
        print("Phone: ");
        s = read();
        user.setPhone(s);
        return user;
    }

    public User login(){
        return null;
    }


    private String read(){
        return "";
    }

    private void print(String s){

    }

}
