import java.io.*;
import java.net.URL;
import java.nio.charset.StandardCharsets;

public class Main {
    public static void main(String[] args) throws IOException{
        String API_KEY = "1efc05f8c068f443b4d82d6678698c08";

        Data data = new Data();
        data.Data();

        URL weatherURL= new URL("https://api.openweathermap.org/data/2.5/onecall?lat="+data.latitude+"&lon="+data.longitude+"&exclude="+data.weather+"&appid="+API_KEY);;
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(weatherURL.openStream(), StandardCharsets.UTF_8));;

        StringBuilder stringBuilder = new StringBuilder();
        String line;

        while((line = bufferedReader.readLine())!=null)
            stringBuilder.append(line);

        line = stringBuilder.toString();
        System.out.print(line);
    }
}
