package database;

import javax.annotation.processing.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value = "org.hibernate.jpamodelgen.JPAMetaModelEntityProcessor")
@StaticMetamodel(Sunrise.class)
public abstract class Sunrise_ {

	public static volatile SingularAttribute<Sunrise, String> sunrise;
	public static volatile SingularAttribute<Sunrise, String> solar_noon;
	public static volatile SingularAttribute<Sunrise, String> day_length;
	public static volatile SingularAttribute<Sunrise, String> lng;
	public static volatile SingularAttribute<Sunrise, String> sunset;
	public static volatile SingularAttribute<Sunrise, Long> id;
	public static volatile SingularAttribute<Sunrise, String> lat;

	public static final String SUNRISE = "sunrise";
	public static final String SOLAR_NOON = "solar_noon";
	public static final String DAY_LENGTH = "day_length";
	public static final String LNG = "lng";
	public static final String SUNSET = "sunset";
	public static final String ID = "id";
	public static final String LAT = "lat";

}

