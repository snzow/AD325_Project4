public class UserID {

    int ID;
    String password;

    public UserID(String password){
        ID = Main.getRandomNumber(0,100000);
        while (Main.SESSION.getUserDB().get(ID) != null){
            ID = Main.getRandomNumber(0,100000);
        }
        this.password = password;
    }




}
