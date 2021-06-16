import dto.SunDto;
import http.HttpClient;

import java.util.Scanner;

public class Menu {


    public static void start() {

        HttpClient httpClient = new HttpClient();
        SunriseService sunriseService = new SunriseService(httpClient);

        System.out.println("Chcesz sprawdzić długość dnia ?? godzine wschodu i zachodu słońca ? Dobrze trafiłeś : ");
        System.out.println("Wybierz  opcje ");
        System.out.println("1) Informacje dla podanych współrzednych");
        System.out.println("2) Export z bazydanych do pliku ");

        Scanner scan = new Scanner(System.in);
        int option = scan.nextInt();
        scan.nextLine();
        String result;

        switch (option) {
            case 1:
                System.out.println("Podaj długość geograficzna");
                String lat = scan.nextLine();

                System.out.println("podaj szerokosc geograficzna");
                String lng = scan.nextLine();

                SunDto sunDto = sunriseService.forGivenLocation(lat, lng);
                result = sunDto.toString();
                break;
            case 2:
                sunriseService.exportDataFromDatabaseToTextFile();
                sunriseService.exportDataToCsvFile();

                result = "eksport zakończony";
                break;

            default:
                result = null;
        }

        System.out.println(result);

    }
}
