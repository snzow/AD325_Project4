import graphpackage.UndirectedGraph;

import java.util.HashMap;
import java.util.Scanner;

public class ProfileManager {
    UndirectedGraph<UserID> userGraph;
    HashMap<String, UserID> userDB;

    Profile currentUser;

    public ProfileManager(){
        userGraph = new UndirectedGraph<UserID>();
        userDB = new HashMap<String,UserID>();
    }

    public void createProfile(){
        Scanner kb = new Scanner(System.in);
        System.out.println("Enter Username: ");
        String username = kb.nextLine();
        System.out.println("Enter Password");
        String password = kb.nextLine();
        String passwordConfirm = null;
        boolean firstTime = true;
        while((password == null) || !password.equals(passwordConfirm)){
            if(firstTime == false){
                System.out.println("Incorrect, please try again");
            }
            System.out.println("Confirm Password: ");
            passwordConfirm = kb.nextLine();
            if(firstTime == true){
                firstTime = false;
            }

        }
        Profile newUser = new Profile(username,password);
        userDB.put(username,newUser.getID());
        userGraph.addVertex(newUser.getID());
        System.out.println("Profile Created, Welcome " + username);

    }

    public void createProfile(String username, String password){
        Profile newUser = new Profile(username,password);

    }

    public UndirectedGraph<UserID> getUserGraph() {
        return userGraph;
    }

    public HashMap<String, UserID> getUserDB() {
        return userDB;
    }
}
