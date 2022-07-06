/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package project2;

/**
 *
 * @author barisgirismen
 */

public class Flight {
    
    int flightID;
    int flightDay;
    int flightMonth;
    int flightYear;
    int flightHour;
    int flightMinute;
    String flightFrom;
    String flightTo;
    String flightCarrier;
    double flightPrice;
    
    public Flight(int flightID, int flightDay, int flightMonth, int flightYear, int flightHour, int flightMinute, String flightFrom, String flightTo, String flightCarrier, double flightPrice) {
        this.flightID = flightID;
        this.flightDay = flightDay;
        this.flightMonth = flightMonth;
        this.flightYear = flightYear;
        this.flightHour = flightHour;
        this.flightMinute = flightMinute;
        this.flightFrom = flightFrom;
        this.flightTo = flightTo;
        this.flightCarrier = flightCarrier;
        this.flightPrice = flightPrice;
    }
    
    @Override
    public String toString() {
        return "Flight with the ID number "+flightID+" will be on "+flightDay+"."+flightMonth+"."+flightYear+" at "+flightHour+"."+flightMinute+" from "+flightFrom+" to "+flightTo+" via "+flightCarrier+". Ticket price is "+flightPrice+" TL.\n";
    }
}