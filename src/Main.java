import java.util.ArrayList;

public class Main {

    public static void main(String[] args) {

        Club members = new Club();

        ArrayList<String> winnersList = members.readData();

        members.writeData(winnersList);
    }
}
