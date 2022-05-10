import java.io.*;
import java.net.URL;
import java.nio.charset.StandardCharsets;
import java.util.Objects;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws IOException{
        String API_KEY = "1efc05f8c068f443b4d82d6678698c08";
        String city, latitude = null, longitude= null;

        /*
        FileInputStream fileO = new FileInputStream("data/city_coords.dat");
        BufferedInputStream buffO = new BufferedInputStream(fileO);
        ObjectInputStream ObjO = new ObjectInputStream(buffO);

        Data data = (Data)ObjO.readObject();
        city = data.city;
        latitude = data.latitude;
        longitude = data.longitude;
        ObjO.close();
        System.out.println(city + latitude + longitude);
        */
        /*
        Scanner scanner = new Scanner("data/city_coords.dat");
        String linia1 = scanner.nextLine();
        System.out.println(linia1);
        */
        File file = new File("data/city_coords.dat");
        FileReader fr = new FileReader(file);
        BufferedReader br = new BufferedReader(fr);
        String line1;

        Scanner keyboard = new Scanner(System.in);
        System.out.println("enter a city");
        city = keyboard.nextLine();
        while ((line1 = br.readLine()) != null) {
            String[] parts = line1.split(", ");
            if(Objects.equals(parts[0], city)){
                latitude = parts[1];
                longitude = parts[2];
            }
        }

        URL weatherURL= new URL("https://api.openweathermap.org/data/2.5/onecall?lat="+latitude+"&lon="+longitude+"&exclude=hourly,daily&appid="+API_KEY);;
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(weatherURL.openStream(), StandardCharsets.UTF_8));;

        String line;
        StringBuilder stringBuilder = new StringBuilder();

        while((line = bufferedReader.readLine())!=null)
            stringBuilder.append(line);
        line = stringBuilder.toString();

        System.out.println(line);
    }
}
