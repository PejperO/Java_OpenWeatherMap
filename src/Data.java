import java.io.*;
import java.util.Objects;
import java.util.Scanner;

public class Data implements Serializable {
    //String weather = "hourly", city= "warsaw", latitude= "52.237049", longitude= "21.017532";    // test data - so that I do not have to enter them every time I test the program
    String weather, city, latitude, longitude;

    Scanner keyboard = new Scanner(System.in);
    FileReader fileReader = null;

    public void data(){
        setFileReader();
        setWeather();
        try {
            setLatLon();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private void setFileReader(){
        System.out.print("Enter the path to the file with geographical coordinates of cities (leave empty to get default): ");
        String filePath = keyboard.nextLine();

        if(Objects.equals(filePath, ""))
            filePath = "data/city_coords.dat";

        File file = new File(filePath);
        try {
            fileReader = new FileReader(file);
        } catch (FileNotFoundException e) {
            System.out.println("No such file or directory");
            setFileReader();
        }
    }

    private void setWeather(){
        System.out.print("Enter the type of weather forecast (daily / hourly): ");
        weather = keyboard.nextLine();

        switch (weather) {
            case "daily" -> weather = "hourly";
            case "hourly" -> weather = "daily";
            default -> {
                System.out.println("No such type");
                setWeather();
            }
        }
    }

    private void setLatLon() throws IOException {
        System.out.print("Enter a city: ");
        city = keyboard.nextLine();

        String line;
        BufferedReader bufferedReader = new BufferedReader(fileReader);

        //boolean get = false;
        while ((line = bufferedReader.readLine()) != null) {
            String[] parts = line.split(", ");
            if (Objects.equals(parts[0], city)) {
                latitude = parts[1];
                longitude = parts[2];
                //get = true;
            }
        }
        /*
        if(!get){
            System.out.println("No such city in the file or directory");
            setLatLon();
        }
        */
    }
}
