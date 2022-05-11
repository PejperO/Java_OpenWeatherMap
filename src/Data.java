import java.io.*;
import java.util.Objects;
import java.util.Scanner;

public class Data implements Serializable {
    String weather, city, latitude, longitude;

    public void Data(){
        Scanner keyboard = new Scanner(System.in);
        System.out.print("Enter the path to the file with geographical coordinates of cities: ");
        String filePath = keyboard.nextLine();

        File file = new File(filePath); // data/city_coords.dat
        FileReader fileReader = null;
        try {
            fileReader = new FileReader(file);
        } catch (FileNotFoundException e) {
            System.out.println("No such file or directory");
            e.printStackTrace();
        }

        while(true){
            System.out.print("Enter the type of weather forecast (daily / hourly): ");
            weather = keyboard.nextLine();
            if(Objects.equals(weather, "daily") || Objects.equals(weather, "hourly"))
                break;
            else
                System.out.println("No such type");
        }

        System.out.print("Enter a city: ");
        city = keyboard.nextLine();

        String line;
        assert fileReader != null;
        BufferedReader bufferedReader = new BufferedReader(fileReader);
        try {
            while ((line = bufferedReader.readLine()) != null) {
                String[] parts = line.split(", ");
                if (Objects.equals(parts[0], city)) {
                    latitude = parts[1];
                    longitude = parts[2];
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
