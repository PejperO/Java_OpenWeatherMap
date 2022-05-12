/**
 *
 * @author Polecki Mikołaj
 *
 */

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.URL;
import java.nio.charset.StandardCharsets;

public class Service {
    String API_KEY = "1efc05f8c068f443b4d82d6678698c08";
    Data data = new Data();
    String weather;

    public String getWeather(){
        StringBuilder json = new StringBuilder();
        data.data();
        weather = data.weather;
        try {
            URL weatherURL= new URL("https://api.openweathermap.org/data/2.5/onecall?lat="+data.latitude+"&lon="+data.longitude+"&exclude=current,minutely,alerts,"+data.weatherNegation+"&appid="+API_KEY);
            BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(weatherURL.openStream(), StandardCharsets.UTF_8));
            String line;

            while((line = bufferedReader.readLine())!=null)
                json.append(line);

        } catch (IOException e) {
            e.printStackTrace();
        }

        return json.toString();
    }
}
