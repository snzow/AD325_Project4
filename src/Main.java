import java.util.Random;

public class Main {

    static ProfileManager SESSION;
    public static void main(String[] args) {
        SESSION = new ProfileManager();
        SESSION.createProfile();
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