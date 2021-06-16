import database.Sunrise;
import database.SunriseDao;
import dto.SunDto;
import http.HttpClient;
import mapper.SunMapper;

import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.List;


public class SunriseService {

    private final HttpClient httpClient;
    private final SunriseDao sunriseDao;

    public SunriseService(HttpClient httpClient) {
        this.httpClient = httpClient;
        sunriseDao = new SunriseDao();
    }


    public SunDto forGivenLocation(String lat, String lng) {


        SunDto sunDto;
        Sunrise sunrise = sunriseDao.getByLocation(lat, lng);

        if (sunrise != null) {
            sunDto = SunMapper.mapSunriseToSunDto(sunrise, lat, lng);
        } else {

            String uri = "https://api.sunrise-sunset.org/json?lat=" + lat + "&lng=" + lng;
            String json = httpClient.get(uri);

            ProductService productService = new ProductService();

            sunDto = productService.parse(json, lng, lat);

            List<Sunrise> entities = SunMapper.mapSunDtoToEntity(sunDto, lat, lng);
            for (Sunrise entity : entities) {
                sunriseDao.create(entity);
            }
        }
        return sunDto;
    }

    public void exportDataFromDatabaseToTextFile() {

        List<Sunrise> sunrises = sunriseDao.getAll();

        try {
            PrintWriter writer = new PrintWriter("sunrise.txt");
            for (Sunrise sunrise : sunrises) {
                writer.printf("id = %d | lat = %s | lng = %s | sunrise = %s | sunset = %s | solar_noon = %s | day_lenght = %s\n",
                        sunrise.getId(),
                        sunrise.getLat(),
                        sunrise.getLng(),
                        sunrise.getSunrise(),
                        sunrise.getSunset(),
                        sunrise.getSolar_noon(),
                        sunrise.getDay_length());

            }

            writer.close();

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }

    public void exportDataToCsvFile() {

        List<Sunrise> sunrises = sunriseDao.getAll();
        try {
            PrintWriter writer = new PrintWriter("sunrisess.csv");
            writer.println("id;lat;lng;sunrise;sunset;solar_noon;day_length");
            for (Sunrise sunrise : sunrises) {
                writer.printf("%d;%s;%s;%s;%s;%s;%s\n",
                        sunrise.getId(),
                        sunrise.getLat(),
                        sunrise.getLng(),
                        sunrise.getSunrise(),
                        sunrise.getSunset(),
                        sunrise.getSolar_noon(),
                        sunrise.getDay_length());

            }

            writer.close();

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }
}



