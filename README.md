# Getting Started

## How to start:

* First run mvn spring-boot:build-image command to build an image of the application
* Then move to weather/docker folder
* Start the application with docker-compose up command

## How to use:

* Use [swagger-ui](http://localhost:8080/simple-weather/api/v/0.1/swagger-ui/index.html#/Weather%20Forecast/getForecast)
  to play around or,
* Send a get request to http://localhost:8080/simple-weather/api/v/0.1/two-days/{cityName} replacing {cityName} with an
  actual city name
    * For instance:
        * [Istanbul](http://localhost:8080/simple-weather/api/v/0.1/two-days/istanbul)
        * [Rome](http://localhost:8080/simple-weather/api/v/0.1/two-days/rome)
        * [Canberra](http://localhost:8080/simple-weather/api/v/0.1/two-days/canberra)
        * [Batman(Yes it is an actual city!)](http://localhost:8080/simple-weather/api/v/0.1/two-days/batman)
    
* You will get a basic weather forecast for the next 48 hours which includes
    * maximumTemperatureForNextTwoDays: Maximum temperature in the city for the next 48 hours
    * dateTime: Date and Time of the response in ISO format
    * cityName: Name of the city
        * Forecast: Basic forecast info for 3 hours
            * max: Max temperature in the city for the given time period
            * feelsLike: What temperature it feels like
            * humidity: Humidity
            * time: Starting time of the 3 hours interval in ISO format
* PS: All results are metric
### Reference Documentation

For further reference, please consider the following sections:

* [Official Apache Maven documentation](https://maven.apache.org/guides/index.html)
* [Spring Boot Maven Plugin Reference Guide](https://docs.spring.io/spring-boot/docs/3.2.3/maven-plugin/reference/html/)

