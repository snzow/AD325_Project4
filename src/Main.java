import java.util.Scanner;

public class Main {

    public static ProfileManager network;
    public static void main(String[] args) {
        network = new ProfileManager();
        System.out.println("--------------");
        System.out.println("Welcome");
        Scanner kb = new Scanner(System.in);
        while(true){
            if(network.getCurrentUser() == null){
                System.out.println("Please Create A Profile");
                network.setCurrentUser(network.getUserMap().get(network.profileCreator(kb)));

            }
            System.out.println("--------------");
            System.out.println("Menu");
            System.out.println("1. Create New Profile");
            System.out.println("2. Open User Menu");
            System.out.println("3. Change Active User");
            System.out.println("4. Print All Users");
            System.out.println("5. Display Friend Web ");
            System.out.println("6. Log Out");
            System.out.println("--------------");

            int next = kb.nextInt();
            if(next == 1){
                System.out.println("Enter new username:");
                String newUser = kb.next();
                network.addUser(newUser);
            }
            else if(next == 2){
                network.getCurrentUser().profileMenu(kb);
            }
            else if(next == 3){
                System.out.println("Enter New Active User");
                String newUser = kb.next();
                Profile ac = network.getUserMap().get(newUser);
                if (ac == null){
                    System.out.println("User Not Found");
                }
                else{
                    network.setCurrentUser(ac);
                }
            }
            else if(next == 4){
                network.printAllProfiles();
            }
            else if(next == 5){
                network.printProfileWeb(kb);
            }
            else{
                kb.close();
                break;
            }
        }
        System.out.println("--------------");
    }

    /**
     * returns a random value between bounds min and max both inclusive
     * @param min the minimum value that can be selected
     * @param max the maximum value that can be selected
     * @return a random number within the bounds
     */
    public static int getRandomNumber(int min, int max){
        int num = (int)Math.floor(Math.random()*(max-min+1)+min);
        return num;
    }
}