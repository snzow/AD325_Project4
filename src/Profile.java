import graphpackage.Vertex;
import graphpackage.VertexInterface;

import java.util.Iterator;
import java.util.Scanner;

public class Profile {

    private VertexInterface node;
    private int age;
    private String username;
    private String name;

    private String status;

    public Profile(String username){
        this.username = username;
        this.name = username;
    }

    public Profile(String username, int age, String status){
        this.username = username;
        this.name = username;
        this.age = age;
        this.status = status;
    }

    public int getAge() {
        return age;
    }
    public void setAge(int age) {
        this.age = age;
    }

    public void setNode(VertexInterface vertexInterface){
        node = vertexInterface;
    }

    public VertexInterface getNode(){
        return node;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
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


    public void profileMenu(Scanner kb){
        if(this.getName() != null){
            System.out.println("Welcome " + name + "!");
        }
        while(true){
            System.out.println("------------");
            System.out.println("Profile Menu");
            System.out.println("1. Name Menu");
            System.out.println("2. Status Menu");
            System.out.println("3. Age Menu");
            System.out.println("4. Add Friends");
            System.out.println("5. Show Profile");
            System.out.println("6. Quit");
            System.out.println("7. Delete Profile");
            System.out.println("------------");
            int userInput = kb.nextInt();
            if(userInput == 1){
                this.nameMenu(kb);
            }
            else if(userInput == 2){
                this.statusMenu(kb);
            }
            else if(userInput == 3){
                this.ageMenu(kb);
            }
            else if(userInput == 4){
                this.addFriends(kb);
            }
            else if(userInput == 5){
                this.printProfile(kb);
            }
            else if(userInput == 7){
                Main.network.deleteProfile();
                return;
            }
            else{
                return;
            }
        }
    }

    public void printProfile(Scanner kb) {
        System.out.println("------------");
        System.out.println("Name: " +this.getName());
        System.out.println("Age: " +this.getAge());
        System.out.println("Status: " +this.getStatus());
        System.out.println("---Friend List---");
        Iterator iterator = this.node.getNeighborIterator();
        while(iterator.hasNext()){
            VertexInterface friendVertex = (VertexInterface) iterator.next();
            Profile friend = (Profile)friendVertex.getLabel();
            System.out.println(friend.getName());
        }
        System.out.println("------------");
    }

    private void addFriends(Scanner kb) {
        System.out.println("------------");
        System.out.println("Enter Friend To Add:");
        String newFriend = kb.next();
        Profile friend = Main.network.getUserMap().get(newFriend);
        if(friend == null){
            System.out.println("User not found");
        }
        else{
            this.node.connect(friend.getNode());
            System.out.println("Friend Added!");
        }
        System.out.println("------------");
    }

    private void statusMenu(Scanner kb) {
        while(true) {
            System.out.println("------------");
            System.out.println("Name Menu");
            System.out.println("1. Get Status");
            System.out.println("2. Change Status");
            System.out.println("3. Back");
            System.out.println("------------");
            int userInput = kb.nextInt();
            if (userInput == 1) {
                System.out.println("Status: " + getStatus());
            }
            else if (userInput == 2) {
                System.out.println("Enter New Status: ");
                String newName = kb.next();
                setStatus(newName);
                System.out.println("Status set");
            }
            else{
                return;
            }
        }
    }

    private void ageMenu(Scanner kb) {
        while(true) {
            System.out.println("------------");
            System.out.println("Age Menu");
            System.out.println("1. Get Age");
            System.out.println("2. Change Age");
            System.out.println("3. Back");
            System.out.println("------------");
            int userInput = kb.nextInt();
            if (userInput == 1) {
                System.out.println("Age: " + getAge());
            }
            else if (userInput == 2) {
                System.out.println("Enter New Age: ");
                String newName = kb.next();
                kb.nextLine();
                setStatus(newName);
                System.out.println("Age set");
            }
            else{
                return;
            }
        }
    }

    public void nameMenu(Scanner kb){
        while(true) {
            System.out.println("------------");
            System.out.println("Name Menu");
            System.out.println("1. Get Name");
            System.out.println("2. Change Name");
            System.out.println("3. Back");
            System.out.println("------------");
            int userInput = kb.nextInt();
            if (userInput == 1) {
                System.out.println("Profile Name: " + getName());
            }
            else if (userInput == 2) {
                System.out.println("Enter New Name: ");
                String newName = kb.next();
                kb.nextLine();
                setName(newName);
                System.out.println("Name set");
            }
            else{
                return;
            }
        }
    }
}
