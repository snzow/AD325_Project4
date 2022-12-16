import adtpackage.LinkedQueue;
import graphpackage.UndirectedGraph;
import graphpackage.Vertex;
import graphpackage.VertexInterface;

import java.lang.reflect.Array;
import java.util.*;

public class ProfileManager {

    public UndirectedGraph<Profile> userGraph;
    public HashMap<String, Profile> userMap;

    public ArrayList<String> usernames;
    public Profile currentUser;

    public ProfileManager() {
        userGraph = new UndirectedGraph<>();
        userMap = new HashMap<>();
        usernames = new ArrayList<>();
    }

    public Profile getCurrentUser(){
        return currentUser;
    }

    public void setCurrentUser(Profile user){
        currentUser = user;
    }

    public void addUser(String username){
        if(usernames.contains(username)){
            System.out.println("Username Taken");
            return;
        }
        Profile user = new Profile(username);
        usernames.add(username);
        userGraph.addVertex(user);
        userMap.put(username,user);
        user.setNode(userGraph.getVertex(user));
    }

    public String profileCreator(Scanner kb){
        System.out.println("Please Enter A Username");
        String username = kb.next();
        System.out.println("Please Enter Your Age");
        int age = kb.nextInt();
        System.out.println("Please set your first one word status");
        String status = kb.next();
        addUser(username,age,status);
        return username;
    }

    public void deleteProfile(){
        userMap.remove(currentUser.getName());
        usernames.remove(currentUser.getName());
        VertexInterface<Profile> toDelete = userGraph.getVertex(getCurrentUser());
        if(toDelete.hasNeighbor()){
            Iterator<VertexInterface<Profile>> vertexIterator = toDelete.getNeighborIterator();
            while(vertexIterator.hasNext()){
                vertexIterator.next().deleteEdge(toDelete);
            }
        }
        currentUser = null;
    }
    public void addUser(String username,int age, String status){
        if(usernames.contains(username)){
            System.out.println("Username Taken");
            return;
        }
        Profile user = new Profile(username,age,status);
        usernames.add(username);
        userGraph.addVertex(user);
        userMap.put(username,user);
        user.setNode(userGraph.getVertex(user));
    }

    public void printAllProfiles(){
        for(String s : usernames){
            System.out.println(s);
        }
    }

    public void printProfileWeb(Scanner kb){
        LinkedQueue<VertexInterface> vertexQueue = new LinkedQueue<>();
        VertexInterface<Profile> currentVertex = currentUser.getNode();
        currentVertex.visit();
        currentVertex.getLabel().printProfile(kb);
        vertexQueue.enqueue(currentVertex);
        while(!vertexQueue.isEmpty()){
            currentVertex = vertexQueue.dequeue();
            while(currentVertex.hasNeighbor()){
                VertexInterface<Profile> nextNeighbor = currentVertex.getUnvisitedNeighbor();
                if(nextNeighbor != null){
                    nextNeighbor.visit();
                    vertexQueue.enqueue(nextNeighbor);
                    nextNeighbor.getLabel().printProfile(kb);
                }
            }
        }
    }

    public UndirectedGraph<Profile> getUserGraph(){
        return userGraph;
    }

    public HashMap<String,Profile> getUserMap() {
        return userMap;
    }
}
