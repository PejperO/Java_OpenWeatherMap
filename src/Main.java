import com.google.gson.JsonArray;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;

import java.util.Objects;

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
            System.out.println("Work in progress");
        }
    }
}
