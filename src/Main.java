import com.google.gson.JsonArray;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;

public class Main {
    public static void main(String[] args){
        Service service = new Service();
        JsonParser parser = new JsonParser();

        String json = service.getWeather();

        JsonObject object = (JsonObject) parser.parse(json);
        JsonArray daily = (JsonArray) object.get("daily");
        JsonObject dailyObject = (JsonObject) daily.get(0);
        JsonObject temp = (JsonObject) dailyObject.get("temp");

        int tempMin = (int) Math.round(Double.parseDouble(temp.get("min").toString()) - 273.15);
        int tempMax = (int) Math.round(Double.parseDouble(temp.get("max").toString()) - 273.15);
        int tempAverage  = (int) Math.round(Double.parseDouble(temp.get("max").toString()) - 273.15);

        String msg =    "Min: " + tempMin + "°C\n" +
                        "Max: " + tempMax + "°C\n" +
                        "Average: " + tempAverage + "°C\n";

        System.out.println(msg);
    }
}
