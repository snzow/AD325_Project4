import graphpackage.Vertex;
import graphpackage.VertexInterface;

public class Profile {

    private UserID id;

    private VertexInterface node;
    private int age;
    private String username;
    private String password;

    private String name;

    private String status;

    public Profile(String username, String password){
        id = new UserID(password);
        this.username = username;
        this.password = password;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }



    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public UserID getID(){
        return id;
    }

    public void profileMenu(){

    }
}
