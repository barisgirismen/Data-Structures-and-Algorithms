package project2;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.GregorianCalendar;
import java.util.Map;
import java.util.Scanner;
import java.util.TreeMap;
import static project2.TestClass.flightID;

/**
 *
 * @author barisgirismen
 */

public class Search {
    
    //Note: In order to have a user-friendly workflow, I added 4 more methods which are displayAllFlights(), save(), exit() and seperator().
    //Note: I tried to code all methods but in the end, 3, 5, 6 and 7 didn't work because I couldn't manage to compare the dates of flights.
    //Note: Hope you like it!
            
    //1) Display all flights
    public static void displayAllFlights(Map <Integer,Flight> allFlights){
        System.out.print("All flights and their IDs are listed below:\n\n");
                
        for (Integer key : allFlights.keySet()){
            System.out.println(allFlights.get(key));
        }
    }
    
    //2) Insert and remove flight information
    public static void insertFlight(Map <Integer,Flight> allFlights){
        Scanner input = new Scanner(System.in);
        System.out.println("To insert a new flight, enter the following information:");
           
        ////DATE OF FLIGHT\\\\ (day, month and year)
        //Day
        int flightDay = 0;
        boolean validDay = false;
        while(!validDay){
            System.out.print("Enter day of flight: ");
            flightDay = input.nextInt();
            
            if (flightDay > 0 && flightDay < 32){
                 validDay = true;
            } else if (flightDay < 1 || flightDay > 31){
                System.out.println("\nDay cannot be lower than 1 or greater than 31.");
            }
         }
        
        //Month
        int flightMonth = 0;
        boolean validMonth = false;
        while(!validMonth){
            System.out.print("Enter month of flight: ");
            flightMonth = input.nextInt();
            
            if (flightMonth < 1 || flightMonth > 12){
                System.out.println("\nMonth cannot be lower than 1 or greater than 12.");
            } else {
                //February cannot have 30 or 31 days
                if (flightMonth == 2 && (flightDay == 30 || flightDay == 31)){   
                    System.out.println("\nFebruary cannot have 30 or 31 days.");
                //Months 4, 6, 9 and 11 can have 30 days at max
                } else if (flightDay == 30 && (flightMonth == 4 || flightMonth == 6 || flightMonth == 9 || flightMonth == 11)){
                    validMonth = true;
                //Months 1, 3, 5, 7, 8, 10 and 12 can have 31 days at max
                } else if (flightDay == 31 && (flightMonth == 1 || flightMonth == 3 || flightMonth == 5 || flightMonth == 7 || flightMonth == 8 || flightMonth == 10 || flightMonth == 12)) {
                    validMonth = true;
                //Month value must be between 0 and 13
                } else if (flightMonth > 0 || flightMonth < 13) {
                    validMonth = true;
                } else {
                    System.out.println("\nInvalid month");
                }
            }
        }

        //Year
        int flightYear = 0;
        boolean validYear = false;
        while(!validYear){
            System.out.print("Enter year of flight: ");
            flightYear = input.nextInt();
            
            //If the year is not divisible by 4, February cannot have 29 days
            if (flightYear % 4 != 0 && (flightMonth == 2 && flightDay == 29)) {
                System.out.println("\nIf the year is not divisible by 4, February cannot have 29 days.");
            } else {
                validYear = true;
            }   
        }
        

        ////TIME OF FLIGHT\\\\ (hour and minute)
        //Hour
        int flightHour = 0;
        boolean validHour = false;
        while(!validHour){
            System.out.print("\nEnter hour of flight: ");
            flightHour = input.nextInt();
            
            if (flightHour < 0 || flightHour > 23){
                System.out.println("Hour cannot be lower than 0 or greater than 23");
            } else {
                validHour = true;
            }
        }
        
        //Minute
        int flightMinute = 0;
        boolean validMinute = false;
        while(!validMinute){
            System.out.print("Enter minute of flight: ");
            flightMinute = input.nextInt();
            
            if (flightMinute < 0 || flightMinute > 59){
                System.out.println("Minute cannot be lower than 0 or greater than 59");
            } else {
                validMinute = true;
            }
        }
        
        //PRINT DATE
        //Print day
        if (flightDay > 0 && flightDay < 10){
            System.out.print("\nFlight will be on 0" + flightDay);
        } else {
            System.out.print("\nFlight will be on " + flightDay);
        }
        
        //Print month
        if (flightMonth > 0 && flightMonth < 10){
            System.out.print(".0"+flightMonth);
        } else {
            System.out.print("."+flightMonth);
        }
        
        //Print year
        if (flightYear > 0 && flightYear < 10){
            System.out.print(".0"+flightYear);
        } else {
            System.out.print("."+flightYear);
        }
        
        
        //PRINT TIME
        //Print hour
        if (flightHour > 0 && flightHour < 10){
            System.out.print(" at 0"+flightHour);
        } else {
            System.out.print(" at "+flightHour);
        }
        
        //Print minute
        if (flightMinute > 0 && flightMinute < 10){
            System.out.println(".0"+flightMinute+" o'clock.");
        } else {
            System.out.println("."+flightMinute+" o'clock.");
        }
        
        
        //Flight Departure (from)
        System.out.print("\nEnter flight departure (from): ");
        String flightFrom = input.next();
        
        //Flight Destination (to)
        System.out.print("Enter flight destination (to): ");
        String flightTo = input.next();

        //Flight Carrier
        System.out.print("Enter flight carrier: ");
        String flightCarrier = input.next();

        //Flight Price
        System.out.print("Enter flight price: ");
        double flightPrice = input.nextDouble();
        System.out.println("");
        
        //Create a new flight
        //flightID++;
        Flight newFlight = new Flight(flightID, flightDay, flightMonth, flightYear, flightHour, flightMinute, flightFrom, flightTo, flightCarrier, flightPrice);
        
        //Add the flight to "allFlights" TreeMap
        allFlights.put(flightID++, newFlight);
        
        System.out.println(newFlight);
    }
    
    public static void removeFlight(Map <Integer,Flight> allFlights){
        Scanner input = new Scanner(System.in);
        System.out.print("To remove a flight, type the ID of the flight you'd like to remove. ");
        displayAllFlights(allFlights);
        System.out.print("Enter the ID number of the flight you would like to remove: ");
        //Remove kodu
        int removeID = input.nextInt();
        if (allFlights.containsKey(removeID)){
            allFlights.remove(removeID);
            System.out.println("\nThe flight with the ID number " + removeID + " was removed successfully.\n");
        } else {
            System.out.println("\nEnter a valid ID.");
        }
    }
    
    //3) Search for flights by date, however if the given date does not exist in the table, show the closest before and aer dates which have flight
    public static void searchByDate(Map <Integer,Flight> allFlights, GregorianCalendar flightDate){
        
    }
    
    //4) Search for flights from city
    public static void searchFromCity(Map <Integer,Flight> allFlights, String flightFrom){
        Map<String, Flight> fromInput = new TreeMap<>();
        for (Map.Entry<Integer, Flight> entry : allFlights.entrySet()) {
            fromInput.put(entry.getValue().flightFrom, entry.getValue());
        }
        if (fromInput.containsKey(flightFrom)) {
            System.out.println(fromInput.get(flightFrom));
        } else {
            System.out.println("There's no flight to "+flightFrom+".\n");
        }
    }
    
    //5) Search for flights with both from city and date
    public static void searchFromCityAndDate(Map <Integer,Flight> allFlights){
    }
    
    //6) Search for flights between two dates
    public static void searchBetweenTwoDates(Map <Integer,Flight> allFlights){
    }
    
    //7) Search for flights less than a given price in a given date
    public static void searchLessThanGivenPrice(Map <Integer,Flight> allFlights, double flightPrice){
        
        System.out.print("Enter a price to list all flights with less price: ");
        
        Map <Double,Flight> lessThanGivenPrice = new TreeMap<>();
        for (Map.Entry<Integer,Flight> entry : allFlights.entrySet()){
            lessThanGivenPrice.put(entry.getValue().flightPrice, entry.getValue());
        }
        //Yapamadım
        //System.out.println(lessThanGivenPrice.floorKey());
    }
    
    //8) Save changes to "Flights.txt" file
    public static void save(Map <Integer,Flight> allFlights){
        File file = new File("Flights.txt");        
        BufferedWriter bf = null;
       
        try{
            //Create a new BufferedWriter for the output file
            bf = new BufferedWriter(new FileWriter(file) );
 
            //Iterated map entries
            for (Map.Entry<Integer,Flight> entry : allFlights.entrySet()){
                
                //Put value
                bf.write(""+entry.getValue());
                
                //Seperated value lines
                bf.newLine();
            }
            bf.flush();
            System.out.println("All changes are saved to \"Flights.txt\" file.\n");
        } catch (IOException exception) {
            System.out.println("An error occured when writing to the file.");
        } finally {
            try {
                //Closed the writer
                bf.close();
            } catch (Exception exception) {
            System.out.println("An error occured when closing the file.");
            }
        }
    }

    //9) Exit the program
    public static void exit(){
        System.out.println("Bye! 👋\n");
        System.exit(0);
    }
}