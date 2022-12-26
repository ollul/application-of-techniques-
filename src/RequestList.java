import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class RequestList {
    private List<Request> requests;

    public RequestList() {
        requests = new ArrayList<>();
        setRequests();
    }

    public List<Request> getRequests() {
        return requests;
    }

    private void setRequests() {
        try (Scanner scan = new Scanner(new File("src/file2.txt"))) {
            while (scan.hasNext()) {
                String reqPointOfDeparture = scan.next();
                String reqDestination = scan.next();
                int reqDay = Integer.parseInt(scan.next());
                int reqMonth = Integer.parseInt(scan.next());
                int reqYear = Integer.parseInt(scan.next());
                int reqHours = Integer.parseInt(scan.next());
                int reqMinutes = Integer.parseInt(scan.next());
                String passengerName = scan.next();
                String passengerSurname = scan.next();
                Request request = new Request(reqPointOfDeparture, reqDestination, reqDay, reqMonth, reqYear, reqHours,
                        reqMinutes, passengerName, passengerSurname);
                requests.add(request);
            }
        } catch (IllegalArgumentException ex) {
            System.out.println(ex);
        } catch (Exception ex) {
            System.out.println("ERROR! Какая-то иная ошибка!!!");
        }
    }
}
