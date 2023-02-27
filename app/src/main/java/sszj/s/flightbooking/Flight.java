package sszj.s.flightbooking;

import android.net.Uri;
//Model for flight
public class Flight {
    private String flight;
    private String departureDate;
    private String returnDate;
    private int image;
    private String description;
    int price;


    public Flight(String flight, String departureDate, String returnDate, int image, String description, double price) {

       this.flight = flight;
//        this.from = from;
//        this.to = to;
        this.departureDate = departureDate;
        this.returnDate = returnDate;
        this.image = image;
        this.description = description;
        this.price = (int) price;

    }
    public String getFlight() {
        return flight;
    }

    public void setFlight(String flight) {
        this.flight = flight;
    }
//
//    public String getFrom() {
//        return from;
//    }
//
//    public void setFrom(String from) {
//        this.from = from;
//    }
//
//    public String getTo() {
//        return to;
//    }
//
//    public void setTo(String to) {
//        this.to = to;
//    }

    public String getDepartureDate() {
        return departureDate;
    }

    public void setDepartureDate(String departureDate) {
        this.departureDate = departureDate;
    }

    public String getReturnDate() {
        return returnDate;
    }

    public void setReturnDate(String returnDate) {
        this.returnDate = returnDate;
    }

    public int getImage() {
        return image;
    }

    public void setImage(int image) {
        this.image = image;
    }


    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }


    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }


}
