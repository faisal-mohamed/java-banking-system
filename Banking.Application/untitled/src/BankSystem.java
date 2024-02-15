import java.util.ArrayList;
import java.util.UUID;

public class BankSystem {
    ArrayList<User> users;
    public BankSystem(){
        users = new ArrayList<>();
    }
    public int getSize() {
        return users.size();
    }
    public boolean RegUser(String username,  String password) {
        for(User user : users) {
            if (user.getUsername().equals(username)) {
                return false;
            }
        }
        users.add(new User(username, password));
        return true;
    }

    public boolean RegUser(String username) {
        for(User  user : users) {
            if (user.getUsername().equals(username)) {
                return false;
            }
        }
        return true;
    }
    public User LoginUser(String username, String password) {
        for(User user : users) {
            if(user.getUsername().equals(username) && user.getPassword().equals(password)) {
                return user;
            }
        }
        return null;
    }

    public User FindUser(String username) {
        for(User user : users) {
            if(user.getUsername().equals(username)) {
                return user;
            }
        }
        return null;
    }
}
