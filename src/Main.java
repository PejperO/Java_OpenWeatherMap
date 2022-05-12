/**
 *
 * @author Polecki Mikołaj
 *
 */

import com.google.gson.JsonArray;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;

import java.util.Objects;
import java.util.Scanner;

public class Main {
    public static void main(String[] args){
        JsonParser parser = new JsonParser();
        Service service = new Service();

        String json = service.getWeather();
        JsonObject object = (JsonObject) parser.parse(json);

        if(Objects.equals(service.weather, "daily")) {
            for(int i =0; i < 8; ++i) {
                JsonArray daily = (JsonArray) object.get("daily");
                JsonObject dailyObject = (JsonObject) daily.get(i);
                JsonObject temp = (JsonObject) dailyObject.get("temp");

                int tempMin = (int) Math.round(Double.parseDouble(temp.get("min").toString()) - 273.15);
                int tempMax = (int) Math.round(Double.parseDouble(temp.get("max").toString()) - 273.15);
                int tempAverage = (int) Math.round(Double.parseDouble(temp.get("day").toString()) - 273.15);
                int pop = (int) Math.round(Double.parseDouble(dailyObject.get("pop").toString()) * 100);

                String msg = "Minimum temperature: " + tempMin + "°C\n" +
                             "Maximum temperature: " + tempMax + "°C\n" +
                             "Average temperature: " + tempAverage + "°C\n" +
                             "Probability of precipitation : " + pop + "%\n";

                System.out.println("Day " + i);
                System.out.println(msg);
            }
        }
        else{
            for(int i =0; i < 48; ++i) {
                JsonArray hourly = (JsonArray) object.get("hourly");
                JsonObject hourlyObject = (JsonObject) hourly.get(i);

                String tempMin = "No Data";   // No such data in Hourly forecast weather data API response
                String tempMax = "No Data";   // No such data in Hourly forecast weather data API response
                int tempAverage = (int) Math.round(Double.parseDouble(hourlyObject.get("temp").toString()) - 273.15);
                int pop = (int) Math.round(Double.parseDouble(hourlyObject.get("pop").toString()) * 100);

                String msg = "Minimum temperature: " + tempMin + "°C\n" +
                             "Maximum temperature: " + tempMax + "°C\n" +
                             "Average temperature: " + tempAverage + "°C\n" +
                             "Probability of precipitation : " + pop + "%\n";

                System.out.println("Hour " + i);
                System.out.println(msg);
            }
        }
        end(args);
    }

    private static void end(String[] args){
        Scanner keyboard = new Scanner(System.in);
        System.out.print("Type \"stop\" to end or \"next\" to restart: ");
        String end = keyboard.nextLine();
        switch (end) {
            case "stop" -> System.exit(0);
            case "next" -> main(args);
            default -> {
                System.out.println("No such type");
                end(args);
            }
        }
    }
}
