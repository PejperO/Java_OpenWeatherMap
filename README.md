## Java_OpenWeatherMap
Console application integrated with the [OpenWeatherMap](https://openweathermap.org/api/one-call-api) platform. It uses API and JSON to correctly process data about temperature and precipitation. All required information is stored in a .dat file or entered manually in the console. 

The program has the option of asking for two forms of weather forecast:
* daily - weather forecast for the next 7 days
* hourly - weather forecast for the next 48 hours

## Examples

### welcone
    Enter the path to the file with geographical coordinates of cities (leave empty to get default): 
    Enter the type of weather forecast (daily / hourly): daily
    Enter a city: Los Angeles
    
### hourly weather forecast
    Hour 26
    Minimum temperature: No Data°C
    Maximum temperature: No Data°C
    Average temperature: 17°C
    Probability of precipitation : 36%
    
###  daily weather forecast
    Day 7
    Minimum temperature: 12°C
    Maximum temperature: 15°C
    Average temperature: 14°C
    Probability of precipitation : 76%
    
## What I Learned
* How to connect to an API
* JSON (parse/object/data interchange)
* Advanced data processing