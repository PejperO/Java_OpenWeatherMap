import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.MalformedURLException;
import java.net.URL;
import java.nio.charset.StandardCharsets;

public class Main {
    public static void main(String[] args) throws IOException {
        String API_KEY = "1efc05f8c068f443b4d82d6678698c08";
        String latitude = "52.237049", longitude = "21.017532"; //Warsaw - test data
        URL weatherURL = new URL("https://api.openweathermap.org/data/2.5/onecall?lat="+latitude+"&lon="+longitude+"&exclude={part}&appid="+API_KEY);

        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(weatherURL.openStream(), StandardCharsets.UTF_8));

        String line;
        StringBuilder stringBuilder = new StringBuilder();
        while((line = bufferedReader.readLine())!=null)
            stringBuilder.append(line);
        line = stringBuilder.toString();

        System.out.println(line);
    }
}

