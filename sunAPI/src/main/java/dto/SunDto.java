package dto;

public class SunDto {

    private String lat;
    private String lng;
    private String sunrise;
    private String sunset;
    private String solar_noon;
    private String day_length;

    public String getLat() {
        return lat;
    }

    public void setLat(String lat) {
        this.lat = lat;
    }

    public String getLng() {
        return lng;
    }

    public void setLng(String lng) {
        this.lng = lng;
    }

    public SunDto(String lat, String lng, String sunrise, String sunset, String solar_noon, String day_length) {
        this.lat = lat;
        this.lng = lng;
        this.sunrise = sunrise;
        this.sunset = sunset;
        this.solar_noon = solar_noon;
        this.day_length = day_length;
    }

    public SunDto(String sunrise, String sunset, String solar_noon, String day_length) {
        this.sunrise = sunrise;
        this.sunset = sunset;
        this.solar_noon = solar_noon;
        this.day_length = day_length;
    }

    public SunDto() {

    }

    public String getSunrise() {
        return sunrise;
    }

    public void setSunrise(String sunrise) {
        this.sunrise = sunrise;
    }

    public String getSunset() {
        return sunset;
    }

    public void setSunset(String sunset) {
        this.sunset = sunset;
    }

    public String getSolar_noon() {
        return solar_noon;
    }

    public void setSolar_noon(String solar_noon) {
        this.solar_noon = solar_noon;
    }

    public String getDay_length() {
        return day_length;
    }

    public void setDay_length(String day_length) {
        this.day_length = day_length;
    }

    @Override
    public String toString() {
        return "SunDto{" +
                "lat='" + lat + '\'' +
                ", lng='" + lng + '\'' +
                ", sunrise='" + sunrise + '\'' +
                ", sunset='" + sunset + '\'' +
                ", solar_noon='" + solar_noon + '\'' +
                ", day_length='" + day_length + '\'' +
                '}';
    }
}

