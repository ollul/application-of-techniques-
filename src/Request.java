public class Request {
    private String reqPointOfDeparture;
    private String reqDestination;
    private int reqDay;
    private int reqMonth;
    private int reqYear;
    private int reqHours;
    private int reqMinutes;
    private String passengerName;
    private String passengerSurname;

    public Request(String reqPointOfDeparture, String reqDestination, int reqDay, int reqMonth, int reqYear,
                   int reqHours, int reqMinutes, String passengerName, String passengerSurname){
        this.reqPointOfDeparture = reqPointOfDeparture;
        this.reqDestination = reqDestination;
        this.reqDay = reqDay;
        this.reqMonth = reqMonth;
        this.reqYear = reqYear;
        this.reqHours = reqHours;
        this.reqMinutes = reqMinutes;
        this.passengerName = passengerName;
        this.passengerSurname = passengerSurname;
    }

    public String getReqPointOfDeparture(){
        return reqPointOfDeparture;
    }

    public void setReqPointOfDeparture (String reqPointOfDeparture){
        this.reqPointOfDeparture = reqPointOfDeparture;
    }

    public String getReqDestination() {
        return reqDestination;
    }

    public void setReqDestination(String reqDestination) {
        this.reqDestination = reqDestination;
    }

    public int getReqDay() {
        return reqDay;
    }

    public void setReqDay(int reqDay) {
        this.reqDay = reqDay;
    }

    public int getReqMonth() {
        return reqMonth;
    }

    public void setReqMonth(int reqMonth) {
        this.reqMonth = reqMonth;
    }

    public int getReqYear() {
        return reqYear;
    }

    public void setReqYear(int reqYear) {
        this.reqYear = reqYear;
    }

    public int getReqHours() {
        return reqHours;
    }

    public void setReqHours(int reqHours) {
        this.reqHours = reqHours;
    }

    public int getReqMinutes() {
        return reqMinutes;
    }

    public void setReqMinutes(int reqMinutes) {
        this.reqMinutes = reqMinutes;
    }

    public String getPassengerName() {
        return passengerName;
    }

    public void setPassengerName(String passengerName) {
        this.passengerName = passengerName;
    }

    public String getPassengerSurname() {
        return passengerSurname;
    }

    public void setPassengerSurname(String passengerSurname) {
        this.passengerSurname = passengerSurname;
    }

    @Override
    public String toString(){
        return "\n" + "Пункт отправления: " + reqPointOfDeparture + "\n" + "Пункт назначения: " + reqDestination + "\n"
                + "Дата: " + reqDay + "." + reqMonth + "." + reqYear + "\n" + "Время: " + reqHours + ":" + reqMinutes +
                "\n" + "Имя: " + passengerName + "\n" + "Фамилия: " + passengerSurname + "\n";
    }
}
