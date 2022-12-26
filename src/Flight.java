import java.util.Date;

public class Flight {
    private int flightNumber; // номер рейса
    private String pointOfDeparture; // пункт отправления
    private String destination; // пункт назначения
    private int day;
    private int month;
    private int year;
    private int hours;
    private int minutes;
    private String typeOfAircraft; // тип самолета
    private int ticketPrice; // стоимость билета

    public Flight(int flightNumber, String pointOfDeparture, String destination, int day, int month, int year,
            int hours, int minutes, String typeOfAircraft, int ticketPrice) {
        this.flightNumber = flightNumber;
        this.pointOfDeparture = pointOfDeparture;
        this.destination = destination;
        this.day = day;
        this.month = month;
        this.year = year;
        this.hours = hours;
        this.minutes = minutes;
        this.typeOfAircraft = typeOfAircraft;
        this.ticketPrice = ticketPrice;
    }

    public int getFlightNumber() {
        return flightNumber;
    }

    public void setFlightNumber(int flightNumber) {
        this.flightNumber = flightNumber;
    }

    public String getPointOfDeparture() {
        return pointOfDeparture;
    }

    public void setPointOfDeparture(String pointOfDeparture) {
        this.pointOfDeparture = pointOfDeparture;
    }

    public String getDestination() {
        return destination;
    }

    public void setDestination(String destination) {
        this.destination = destination;
    }

    public String getTypeOfAircraft() {
        return typeOfAircraft;
    }

    public void setTypeOfAircraft(String typeOfAircraft) {
        this.typeOfAircraft = typeOfAircraft;
    }

    public int getTicketPrice() {
        return ticketPrice;
    }

    public void setTicketPrice(int ticketPrice) {
        this.ticketPrice = ticketPrice;
    }

    public int getDay() {
        return day;
    }

    public void setDay(int day) {
        this.day = day;
    }

    public int getMonth() {
        return month;
    }

    public void setMonth(int month) {
        this.month = month;
    }

    public int getYear() {
        return year;
    }

    public void setYear(int year) {
        this.year = year;
    }

    public int getHours() {
        return hours;
    }

    public void setHours(int hours) {
        this.hours = hours;
    }

    public int getMinutes() {
        return minutes;
    }

    public void setMinutes(int minutes) {
        this.minutes = minutes;
    }

    @Override
    public String toString() {
        return "\n" + "№ рейса: " + flightNumber + "\n" + "Пункт отправления: " + pointOfDeparture + "\n" +
                "Пункт назначения: " + destination + "\n" + "Дата: " + day + "." + month + "." + year + "\n" +
                "Время: " + hours + ":" + minutes + "\n" + "Тип самолета: " + typeOfAircraft +
                "\n" + "Стоимость билета: " + ticketPrice;
    }
}
