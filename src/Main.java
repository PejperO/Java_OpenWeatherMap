import com.google.gson.*;

import java.io.*;
import java.net.URL;
import java.nio.charset.StandardCharsets;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;

public class Main {
    public static void main(String[] args) throws IOException{
        String API_KEY = "1efc05f8c068f443b4d82d6678698c08";

        Data data = new Data();
        //data.data();

        URL weatherURL= new URL("https://api.openweathermap.org/data/2.5/onecall?lat="+data.latitude+"&lon="+data.longitude+"&exclude=current,minutely,alerts,"+data.weather+"&appid="+API_KEY);
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(weatherURL.openStream(), StandardCharsets.UTF_8));

        StringBuilder stringBuilder = new StringBuilder();
        String line;

        while((line = bufferedReader.readLine())!=null)
            stringBuilder.append(line);

        Object obj = new JsonParser().parse(String.valueOf(stringBuilder));
        JsonObject jo = (JsonObject) obj;
        JsonElement daily = jo.get("daily");
        Set zero = daily.values();
        System.out.println(zero);

        //line = stringBuilder.toString();
        //System.out.print(line);
    }
}
