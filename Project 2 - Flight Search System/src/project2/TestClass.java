package project2;

import java.text.ParseException;
import java.util.Map;
import java.util.Scanner;
import java.util.TreeMap;

/**
 *
 * @author barisgirismen
 */

public class TestClass {
    static int flightID = 1;
    static int flightDay;
    static int flightMonth;
    static int flightYear;
    static int flightHour;
    static int flightMinute;
    static String flightFrom;
    static String flightTo;
    static String flightCarrier;
    static double flightPrice;
        
    public static void main (String[] args) throws ParseException {
        
        Map <Integer,Flight> allFlights = new TreeMap<>();
        Flight initialFlight1 = new Flight(flightID, 17, 10, 2021, 10, 24, "Istanbul", "Trabzon", "Turkish Airlines", 520);
        allFlights.put(flightID++, initialFlight1);
        
        Flight initialFlight2 = new Flight(flightID, 14, 11, 2021, 23, 30, "Ankara", "Istanbul", "Pegasus", 400);
        allFlights.put(flightID++, initialFlight2);
        
        Flight initialFlight3 = new Flight(flightID, 21, 8, 2012, 15, 45, "Dust2", "Militia", "Valve Air", 24);
        allFlights.put(flightID++, initialFlight3);
                        
        System.out.println("Dear passenger, welcome to Işık Airlines! 🛪\n");
        Scanner input = new Scanner(System.in);
        
        while (true) {
            System.out.print("The following options are available for you:\n"+
            "1) Display all flights\n"+
            "2) Insert/remove flight information\n"+
            "3) Search for flights by date\n"+ //however if the given date does not exist in the table show the closest before and after dates which have flight
            "4) Search for flights by from city\n"+
            "5) Search for flights with both from city and date\n"+
            "6) Search for flights between two dates\n"+
            "7) Search for flights less than a given price in a given date\n"+
            "8) Save changes to \"Flights.txt\" file\n"+
            "9) Exit the program\n\n"+
            "Choose an option: ");
            int options = input.nextInt();
            System.out.println("");
            
            switch (options) {
                case 1:
                    Search.displayAllFlights(allFlights);
                    seperator();
                    break;
                case 2:
                    System.out.print("Type 1 to insert a flight, 2 to remove a flight or any key to return to the menu.\nYour answer: ");
                    String case2options = input.next();
                    System.out.println("");
                    
                    if (case2options.contains("1")){
                        Search.insertFlight(allFlights);
                        seperator();
                    } else if (case2options.contains("2")){
                        Search.removeFlight(allFlights);
                        seperator();
                    } else {
                        System.out.print("Returned to the menu. ");
                    }
                    break;
                case 3:
                    /*GregorianCalendar newDate = Search.calendar();
                    Search.searchByDate(allFlights, newDate);
                    
                    System.out.println("To search a flight by date, enter the following information:")
                    Devamına geçemeden hata aldım, calendar() metodumu silmek zorunda kaldım;*/
                    seperator();
                    break;
                case 4:
                    if (allFlights.isEmpty()) {
                        System.out.println("There's no flight available.");
                    } else {
                        System.out.print("Enter the city you'd like to search (⚠ be careful with upper/lower case letters): ");
                        String flightFrom = input.next();
                        System.out.println("");
                        Search.searchFromCity(allFlights,flightFrom);
                    }
                    seperator();
                    break;
                case 5:
                    Search.searchFromCityAndDate(allFlights);
                    seperator();
                    break;
                case 6:
                    Search.searchBetweenTwoDates(allFlights);
                    seperator();
                    break;
                case 7:
                    Search.searchLessThanGivenPrice(allFlights, flightPrice);
                    if (!allFlights.isEmpty()) {
                        System.out.println("Please enter a price in integer format: ");
                        double flightPrice = input.nextInt();
                        Search.searchLessThanGivenPrice(allFlights,flightPrice);
                    } else {
                        System.out.println("There's no flight matching your search.");
                    }
                    seperator();
                    break;
                case 8:
                    Search.save(allFlights);
                    seperator();
                    break;
                case 9:
                    Search.exit();
                default: System.out.print("\nWrong option entered. ");
            }
        }
    }
    public static void seperator(){
        System.out.println("⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯\n");
    }
}