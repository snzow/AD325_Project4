import graphpackage.UndirectedGraph;

public class Network {

    public UndirectedGraph<Profile> users;
    public ProfileManager currentUser;

    public Network() {
        users = new UndirectedGraph<>();
    }

    public void addUser(Profile user){
        users.addVertex(user);
    }
}
