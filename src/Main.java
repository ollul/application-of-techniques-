/*
  Написать программу, моделирующую учет заявок на авиабилеты.
  - Сведения о каждом рейсе содержат:
    номер, пункт отправления, пункт назначения, дату и время вылета, тип самолета, стоимость билета.
  - Сведения о каждой заявке содержат:
    пункт отправления, пункт назначения, дату и время вылета, фамилию и имя пассажира.
  Программа должна создавать список рейсов, список заявок.
  Начальное формирование данных осуществляется из файла (или файлов).
  С помощью меню необходимо обеспечить следующие функции:
    a) добавление рейса;
    b) удаление рейса;
    c) добавление заявки;
    d) для каждой заявки подбор подходящего рейса;
    e) вывод всех заявок по заданным дате и времени вылета;
    f) вывод всех рейсов по заданным пунктам отправления и назначения;
    g) удаление всех заявок по заданной дате.
*/

import java.io.*;
import java.util.ArrayList;
import java.util.Scanner;

public class Main {
    public static void setFlights(ArrayList<Flight> flights, Scanner scan) {
        try {
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

    public static void setRequests(ArrayList<Request> requests, Scanner scan2) {
        try {
            while (scan2.hasNext()) {
                String reqPointOfDeparture = scan2.next();
                String reqDestination = scan2.next();
                int reqDay = Integer.parseInt(scan2.next());
                int reqMonth = Integer.parseInt(scan2.next());
                int reqYear = Integer.parseInt(scan2.next());
                int reqHours = Integer.parseInt(scan2.next());
                int reqMinutes = Integer.parseInt(scan2.next());
                String passengerName = scan2.next();
                String passengerSurname = scan2.next();
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

    public static void printMenu() {
        System.out.println("\nМеню:");
        System.out.println("1. Добавить рейс");
        System.out.println("2. Удалить рейс");
        System.out.println("3. Добавить заявку");
        System.out.println("4. Удалить заявку (по заданной дате)");
        System.out.println("5. Подбор рейса для заявки");
        System.out.println("6. Заявки по выбранной дате и времени вылета");
        System.out.println("7. Рейсы по заданным пунктам отправления и назначения");
        System.out.println("8. Вывести список рейсов");
        System.out.println("9. Вывести список заявок");
        System.out.println("10. Выход из приложения");
    }

    public static void startMenu(ArrayList<Flight> flights, ArrayList<Request> requests) {
        try {
            Scanner scan = new Scanner(System.in);
            Scanner scan2 = new Scanner(System.in);
            if (scan != null) {
                int key;
                do {
                    printMenu();
                    System.out.println("Введите число -> ");
                    key = scan.nextInt();
                    switch (key) {
                        case 1:
                            System.out.println("*****Добавление рейса*****");
                            System.out.println("Введите номер рейса: ");
                            int flightNumber = Integer.parseInt(scan.next());
                            if (flightNumber <= 0) throw new NegativeNumberException("ERROR! Номер рейса не может " +
                                    "быть равным нулю или отрицательным!!!");
                            System.out.println("Введите пункт отправления: ");
                            String pointOfDeparture = scan.next();
                            System.out.println("Введите пункт назначения: ");
                            String destination = scan.next();
                            System.out.println("Введите дату отправления: ");
                            int day = Integer.parseInt(scan.next());
                            int month = Integer.parseInt(scan.next());
                            int year = Integer.parseInt(scan.next());
                            if (day <= 0 || month <= 0 || year <=0) throw new NegativeNumberException("ERROR! " +
                                    "Дата не может быть равной нулю или отрицательной!!!");
                            System.out.println("Введите время отправления: ");
                            int hours = Integer.parseInt(scan.next());
                            int minutes = Integer.parseInt(scan.next());
                            if (hours < 0 || minutes < 0) throw new NegativeNumberException("ERROR! " +
                                    "Время не может быть отрицательным!!!");
                            System.out.println("Введите тип самолёта: ");
                            String typeOfAircraft = scan.next();
                            System.out.println("Введите стоимость билета: ");
                            int ticketPrice = Integer.parseInt(scan.next());
                            if (ticketPrice < 0) throw new NegativeNumberException("ERROR! Стоимость билета не может" +
                                    "быть отрицательной!!!");

                            Flight flight = new Flight(flightNumber, pointOfDeparture, destination, day, month, year,
                                    hours, minutes, typeOfAircraft, ticketPrice);
                            flights.add(flight);

                            System.out.println("\nРейс добавлен!!!");
                            break;
                        case 2:
                            System.out.println("*****Удаление рейса*****");
                            System.out.println(flights);
                            System.out.println("Выберите номер рейса, который нужно удалить: ");
                            int number = Integer.parseInt(scan.next());
                            if (number <= 0) throw new NegativeNumberException("ERROR! Номер рейса не может " +
                                    "быть равным нулю или отрицательным!!!");
                            flights.remove(number - 1);
                            System.out.println("Рейс с номером " + number + " был удалён!!!");
                            break;
                        case 3:
                            System.out.println("*****Добавление заявки*****");
                            System.out.println("Введите пункт отправления: ");
                            String reqPointOfDeparture = scan2.next();
                            System.out.println("Введите пункт назначения: ");
                            String reqDestination = scan2.next();
                            System.out.println("Введите дату: ");
                            int reqDay = Integer.parseInt(scan2.next());
                            int reqMonth = Integer.parseInt(scan2.next());
                            int reqYear = Integer.parseInt(scan2.next());
                            if (reqDay <= 0 || reqMonth <= 0 || reqYear <=0) throw new NegativeNumberException("ERROR! " +
                                    "Дата не может быть равной нулю или отрицательной!!!");
                            System.out.println("Введите время: ");
                            int reqHours = Integer.parseInt(scan2.next());
                            int reqMinutes = Integer.parseInt(scan2.next());
                            if (reqHours < 0 || reqMinutes < 0) throw new NegativeNumberException("ERROR! " +
                                    "Время не может быть отрицательным!!!");
                            System.out.println("Введите имя: ");
                            String passengerName = scan2.next();
                            System.out.println("Введите фамилию: ");
                            String passengerSurname = scan2.next();

                            Request request = new Request(reqPointOfDeparture, reqDestination, reqDay, reqMonth,
                                    reqYear, reqHours, reqMinutes, passengerName, passengerSurname);
                            requests.add(request);

                            System.out.println("\nЗаявка добавлена!!!");
                            break;
                        case 4:
                            System.out.println("*****Удаление заявки (по заданной дате)*****");
                            System.out.println(requests);
                            System.out.println("Выберите дату: ");
                            reqDay = Integer.parseInt(scan2.next());
                            reqMonth = Integer.parseInt(scan2.next());
                            reqYear = Integer.parseInt(scan2.next());
                            if (reqDay <= 0 || reqMonth <= 0 || reqYear <=0) throw new NegativeNumberException("ERROR! " +
                                    "Дата не может быть равной нулю или отрицательной!!!");

                            for (int i = 0; i < requests.size(); i++) {
                                if (requests.get(i).getReqDay() == reqDay && requests.get(i).getReqMonth() == reqMonth &&
                                        requests.get(i).getReqYear() == reqYear) {
                                    requests.remove(i);
                                    break;
                                }
                            }
                            System.out.println("Заявка с датой " + reqDay + "." + reqMonth + "." + reqYear +
                                    " была удалена!!!");
                            break;
                        case 5:
                            System.out.println("*****Подбор рейса для заявки*****");
                            System.out.println("Введите номер заявки: ");
                            flightNumber = Integer.parseInt(scan2.next());//
                            if (flightNumber <= 0) throw new NegativeNumberException("ERROR! Номер рейса не может " +
                                    "быть равным нулю или отрицательным!!!");

                            Request r = requests.get(flightNumber - 1);

                            for (int i = 0; i < flights.size(); i++) {
                                if ((flights.get(i).getPointOfDeparture()).equals(r.getReqPointOfDeparture())&&
                                        (flights.get(i).getDestination()).equals(r.getReqDestination()) &&
                                        flights.get(i).getDay() == r.getReqDay() &&
                                        flights.get(i).getMonth() == r.getReqMonth() &&
                                        flights.get(i).getYear() == r.getReqYear() &&
                                        flights.get(i).getHours() == r.getReqHours() &&
                                        flights.get(i).getMinutes() == r.getReqMinutes())
                                    System.out.println(flights.get(i));
                            }
                            break;
                        case 6:
                            System.out.println("*****Список заявок (по заданным дате и времени вылета)*****");
                            System.out.println("Выберите дату вылета: ");
                            reqDay = Integer.parseInt(scan2.next());
                            reqMonth = Integer.parseInt(scan2.next());
                            reqYear = Integer.parseInt(scan2.next());
                            if (reqDay <= 0 || reqMonth <= 0 || reqYear <=0) throw new NegativeNumberException("ERROR! " +
                                    "Дата не может быть равной нулю или отрицательной!!!");

                            System.out.println("Выберите время вылета: ");
                            reqHours = Integer.parseInt(scan2.next());
                            reqMinutes = Integer.parseInt(scan2.next());
                            if (reqHours < 0 || reqMinutes < 0) throw new NegativeNumberException("ERROR! " +
                                    "Время не может быть отрицательным!!!");

                            for (int i = 0; i < requests.size(); i++) {
                                if (requests.get(i).getReqDay() == reqDay && requests.get(i).getReqMonth() == reqMonth &&
                                        requests.get(i).getReqYear() == reqYear && requests.get(i).getReqHours() == reqHours &&
                                        requests.get(i).getReqMinutes() == reqMinutes) {
                                    System.out.println(requests.get(i));
                                }
                            }
                            break;
                        case 7:
                            System.out.println("*****Список рейсов (по заданным пунктам отправления и назначения)*****");
                            System.out.println("Выберите пункт отправления: ");
                            pointOfDeparture = scan.next();
                            System.out.println("Выберите пункт назначения: ");
                            destination = scan.next();

                            for (int i = 0; i < flights.size(); i++) {
                                if ((flights.get(i).getPointOfDeparture()).equals(pointOfDeparture)&&
                                        (flights.get(i).getDestination()).equals(destination)){
                                    System.out.println(flights.get(i));
                                }
                            }
                            break;
                        case 8:
                            System.out.println("*****Список всех рейсов*****");
                            for (int i = 0; i < flights.size(); i++) {
                                System.out.println("\nРейс " + (i + 1) + flights.get(i));
                            }
                            break;
                        case 9:
                            System.out.println("*****Список всех заявок*****");
                            for (int i = 0; i < requests.size(); i++) {
                                System.out.println("\nЗаявка " + (i + 1) + requests.get(i));
                            }
                            break;
                    }
                } while (key != 10);
            }
        }catch (IllegalArgumentException ex) {
            System.out.println("ERROR! Неправильный ввод!!!");
        } catch (NullPointerException ex) {
            System.out.println("ERROR! Нулевой указатель!!!");
        } catch (IndexOutOfBoundsException ex){
            System.out.println("ERROR! Выход индекса за границы!!!");
        } catch (Exception ex) {
            System.out.println("ERROR! Какая-то иная ошибка!!!");
        }
    }


    public static void main(String[] args) throws FileNotFoundException {
        try {
            Scanner scan = new Scanner(new File("src/file.txt"));
            Scanner scan2 = new Scanner(new File("src/file2.txt"));

            ArrayList<Flight> flights = new ArrayList<Flight>();
            ArrayList<Request> requests = new ArrayList<Request>();

            setFlights(flights, scan);
            setRequests(requests, scan2);
            startMenu(flights, requests);
        } catch (FileNotFoundException ex) {
            System.out.println("ERROR! Файл не найден!!!");
        } catch (Exception ex) {
            System.out.println("ERROR! Какая-то иная ошибка!!!");
        }
    }
}
