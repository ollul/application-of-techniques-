import java.io.File;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class FlightList {
    private List<Flight> flights;

    public FlightList(){
        this.flights = new ArrayList<>();
        setFlights();
    }

    public List<Flight> getFlights() {
        return flights;
    }

    private void setFlights() {
        try (Scanner scan = new Scanner(new File("src/file.txt"))) {
            while (scan.hasNext()) {
                int flightNumber = Integer.parseInt(scan.next());
                String pointOfDeparture = scan.next();
                String destination = scan.next();
                int day = Integer.parseInt(scan.next());
                int month = Integer.parseInt(scan.next());
                int year = Integer.parseInt(scan.next());
                int hours = Integer.parseInt(scan.next());
                int minutes = Integer.parseInt(scan.next());
                String typeOfAircraft = scan.next();
                int ticketPrice = Integer.parseInt(scan.next());
                Flight flight = new Flight(flightNumber, pointOfDeparture, destination, day, month,
                        year, hours, minutes, typeOfAircraft, ticketPrice);
                flights.add(flight);
            }
        } catch (IllegalArgumentException ex) {
            System.out.println(ex);
        } catch (Exception ex) {
            System.out.println("ERROR! Какая-то иная ошибка!!!");
        }
    }
}