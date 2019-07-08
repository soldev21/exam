package core;

import model.User;

/**
 * Created by Sherif on 7/4/2019.
 */
public class UserManagement {

    private User user;

    private static class Commands{
        public static final String SHOW_PAST = "sp";
        public static final String NEXT = "n";
        public static final String PREV = "p";
        public static final String EXIT = "exit";
    }

    public UserManagement(User user){
        this.user = user;
    }

    public void start(){

    }
}
