package core;

import model.AuthResponse;
import model.User;
import registry.Authentication;

import static util.Util.print;
import static util.Util.println;
import static util.Util.read;

/**
 * Created by s.huseynli on 7/4/2019.
 */
public class AuthManagement {

    private static boolean initial =true;
    private static Authentication authentication = new Authentication();


    public static User register(){

        User user;
        boolean b = false;
        if (initial){
            println("It is first login. Please set Admin details");
            user = register1();
            user.setAdmin(true);
            b= authentication.add(user);
            initial=false;
        }else {
            println("Please enter User details");
            user = register1();
            authentication.add(user);
        }
        return (b) ? user : null;
    }

    private static User register1(){

        String s;
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

    public static User login(){
        println("Please login");
        String username;
        String password;
        print("Username: ");
        username = read();
        print("Password: ");
        password = read();
        AuthResponse authResponse = authentication.authenticate(username,password);
        if (authResponse.getCode()==0){
            print(authResponse.getDesc());
            return authResponse.getUser();
        }else {
            print(authResponse.getDesc());
            return null;
        }
    }
}
