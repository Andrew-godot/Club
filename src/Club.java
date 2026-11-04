
import java.io.*;
import java.util.ArrayList;
import java.util.Scanner;

public class Club {

    private double maxMiles = 0;

    public ArrayList<String> readData() {

        String furthestFName = "";
        String furthestSName = "";

        ArrayList<String> winnersList = new ArrayList<>();

        try (Scanner reader1 = new Scanner(new File("clubread.txt"))) {

            while (reader1.hasNextLine()) {

                String line = reader1.nextLine();
                String[] parts = line.split(",");

                String fName = parts[0];
                String sName = parts[1];

                double totalMiles = Double.parseDouble(parts[2]);

                if (totalMiles > maxMiles) {
                    maxMiles = totalMiles;

                    furthestFName = fName;
                    furthestSName = sName;
                }
            }

            System.out.printf(
                    "The furthest distance walked is %.2f miles achieved by %s %s%n",
                    maxMiles, furthestFName, furthestSName
            );

            double percent = (maxMiles / 100) * 70;

            try (Scanner reader2 = new Scanner(new File("clubread.txt"))) {

                while (reader2.hasNextLine()) {

                    String line = reader2.nextLine();
                    String[] parts = line.split(",");

                    String fName = parts[0];
                    String sName = parts[1];

                    double totalMiles = Double.parseDouble(parts[2]);

                    if (totalMiles > percent) {

                        winnersList.add(fName + " " + sName);
                    }
                }
            }

        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        }

        return winnersList;
    }

    public void writeData(ArrayList<String> winnersList) {

        try (PrintWriter writer = new PrintWriter("PrizeWinners.txt")) {

            for (int i = 0; i < winnersList.size(); i++) {
                writer.println(winnersList.get(i));
            }

            System.out.println("Text successfully written to file");

        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        }
    }
}
