package database;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class  Sunrise {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    private String lat;
    private String lng;
    private String sunrise;
    private String sunset;
    private String solar_noon;
    private String day_length;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

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
}
