package core;

import model.User;

import java.util.HashMap;
import java.util.Map;

import static core.AdminManagement.Commands.*;
import static util.Util.changePassword;
import static util.Util.read;

/**
 * Created by Sherif on 7/4/2019.
 */
public class AdminManagement {
    private static final Map<String,String> commands = new HashMap<>();
    private User user;

    protected static final class Commands{
       public static  final String C_P ="-cp";
       public static  final String  CR_U =        "-cru";
       public static  final String  ED_U =        "-edu";
       public static  final String  CR_CAT =        "-crcat";
       public static  final String  CR_EX =        "-crexam";
       public static  final String  EXIT =        "-exit";
    }

    public AdminManagement(User user){
        this.user = user;
    }

    public void start(){
        String s;
        while (!(s=read()).equals("-exit")){

        }
    }

    static {
        commands.put(C_P,"\"change password\"");
        commands.put(CR_U,"\"create user\"");
        commands.put(ED_U,"\"edit uer\"");
        commands.put(CR_CAT,"\"create category\"");
        commands.put(CR_EX,"\"create exam\"");
        commands.put(EXIT,"\"exit\"");
    }

    public static void printCommands(){
        commands.forEach((k,v)-> System.out.println(k+" "+v));
    }

    private void handleCommand(String command){
        switch (command) {
            case C_P : {
                while (!changePassword(user)){}
                break;
            }
        }
    }
}
