package core;

import dao.UserDao;
import model.User;
import registry.Authentication;

import static util.Util.print;
import static util.Util.read;

/**
 * Created by s.huseynli on 7/3/2019.
 */
public class CoreManagement {

    public void start(){
        User user = AuthManagement.register();
        boolean isContinue = true;
        boolean isContinue2;

        while (isContinue) {
            isContinue2 = true;
            if (user.isAdmin()) {
                AdminManagement adminManagement = new AdminManagement(user);
                adminManagement.start();
            } else {
                UserManagement userManagement = new UserManagement(user);
                userManagement.start();
            }

            while (isContinue2) {
                if (!isContinue()) {
                    isContinue = false;
                    break;
                }
                user = AuthManagement.login();
                if (user != null) isContinue2 = false;
            }
        }
    }

    private boolean isContinue(){
        print("Continue(c) or exit(e) ? ");
        String s;
        while (!(s=read()).equals("c") && !s.equals("e")){}
        return (s.equals("c")) ? true : false;
    }

}
