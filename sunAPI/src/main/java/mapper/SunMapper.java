package mapper;

import database.Sunrise;
import dto.SunDto;

import java.util.ArrayList;
import java.util.List;

public class SunMapper {

    public static List<Sunrise> mapSunDtoToEntity(SunDto sunDto, String lat, String lng) {


        List<Sunrise> result = new ArrayList<>();

        Sunrise sunrise = new Sunrise();
        sunrise.setLng(lng);
        sunrise.setLat(lat);
        sunrise.setSunrise(sunDto.getSunrise());
        sunrise.setSunset(sunDto.getSunset());
        sunrise.setSolar_noon(sunDto.getSolar_noon());
        sunrise.setDay_length(sunDto.getDay_length());

        result.add(sunrise);

        return result;
    }

    public static SunDto mapSunriseToSunDto(Sunrise sunrise, String lat, String lng) {

        SunDto result = new SunDto();
        result.setLat(lat);
        result.setLng(lng);
        result.setSunrise(sunrise.getSunrise());
        result.setSunset(sunrise.getSunset());
        result.setSolar_noon(sunrise.getSolar_noon());
        result.setDay_length(sunrise.getDay_length());

        return result;
    }
}
