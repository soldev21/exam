package registry;


import model.AuthResponse;
import model.User;
import static dao.UserDao.userRepository;
import static util.Util.checkString;
import static util.Util.getHashed;

/**
 * Created by s.huseynli on 7/3/2019.
 */
public class Authentication {

    public AuthResponse authenticate(String username, String password){
        User user = userRepository.findByKey(username);
        AuthResponse response = new AuthResponse();
        response.setUser(user);
        if (user==null) {
            response.setCode(1);
            response.setDesc(String.format("There is no such user: %s\n",username));
        }else if (!user.getPassword().equals(getHashed(password))){
            response.setCode(2);
            response.setDesc(String.format("Wrong password for user: %s\n",username));
        }else {
            response.setCode(0);
            response.setDesc("Successful login\n");
        }
        return response;
    }

    public boolean add(User user){
        if (user.getPassword()==null || user.getPassword().isEmpty()) return false;
        if (userRepository.findByKey(user.getUsername())!=null) return false;
        if (checkUser(user)){
            user.setPassword(getHashed(user.getPassword()));
            userRepository.save(user);
            return true;
        }else return false;
    }



    private boolean checkUser(User user){
        return checkString(user.getAddress()) && checkString(user.getName()) && checkString(user.getPhone());
    }




}
