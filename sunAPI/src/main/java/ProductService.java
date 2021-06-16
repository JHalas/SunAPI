import com.google.gson.*;
import dto.SunDto;

import java.lang.reflect.Type;


public class ProductService {


    public SunDto parse(String json, String lng, String lat) {


        // String json =  "{\n" +
        //            " \"results\":\n" +
        //    "{\n" +
        //        "\"sunrise\":\"7:27:02 AM\",\n" +
        //      "\"sunset\":\"5:05:55 PM\",\n" +
        //      "\"solar_noon\":\"12:16:28 PM\",\n" +
        //      "\"day_length\":\"9:38:53\",\n" +
        //      "\"civil_twilight_begin\":\"6:58:14 AM\",\n" +
        //       "\"civil_twilight_end\":\"5:34:43 PM\",\n" +
        //     "\"nautical_twilight_begin\":\"6:25:47 AM\",\n" +
        //       "\"nautical_twilight_end\":\"6:07:10 PM\",\n" +
        //       "\"astronomical_twilight_begin\":\"5:54:14 AM\",\n" +
        //      "\"astronomical_twilight_end\":\"6:38:43 PM\"\n" +
        //       "},\n" +
        //    "\"status\":\"OK\"\n" +
        // "}" ;
        GsonBuilder gsonBuilder = new GsonBuilder()
                .registerTypeAdapter(SunDto.class, new SunDeserializer());

        SunDto sunDto = gsonBuilder.create().fromJson(json, SunDto.class);
        sunDto.setLng(lng);
        sunDto.setLat(lat);
        return sunDto;


    }

    public static class SunDeserializer implements JsonDeserializer<SunDto> {


        public SunDto deserialize(JsonElement jsonElement, Type type, JsonDeserializationContext context) throws JsonParseException {

            JsonObject jsonObject = jsonElement.getAsJsonObject();
            JsonObject results = jsonObject.getAsJsonObject("results");
            String sunrise = results.get("sunrise").getAsString();
            String sunset = results.get("sunset").getAsString();
            String solar_noon = results.get("solar_noon").getAsString();
            String day_length = results.get("day_length").getAsString();

            return new SunDto(
                    sunrise,
                    sunset,
                    solar_noon,
                    day_length);
        }

    }


}

