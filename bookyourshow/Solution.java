import java.util.Scanner;
import java.util.Arrays;

/**
 * Class for solution.
 * @author : MurthyVemuri.
 */
public final class Solution {
    /**
     * Constructs the object.
     */
    private Solution() {

    }
    /**
     * main method to drive program.
     *
     * @param      args  The arguments
     */
    public static void main(final String[] args) {
        BookYourShow bys = new BookYourShow();
        Scanner scan = new Scanner(System.in);
        int testCases = Integer.parseInt(scan.nextLine());
        for (int i = 0; i < testCases; i++) {
            String[] tokens = scan.nextLine().
                replace("[", "").replace("]", "").split(",");
            String[] check = tokens[0].split(" ");
            switch (check[0]) {
                case "add":
                    int k = 2;
                    String[] seats = new String[tokens.length - 2];
                    for (int j = 0; j < seats.length; j++) {
                        seats[j] = tokens[k++];
                    }
                    bys.addAShow(new Show(check[1], tokens[1], seats));
                break;

                case "book":
                    k = 2 + 2;
                    seats = new String[tokens.length - 2 - 2];
                    for (int j = 0; j < seats.length; j++) {
                        seats[j] = tokens[k++];
                    }
                    bys.bookAShow(check[1], tokens[1],
                        new Patron(tokens[2], tokens[2 + 1], seats));
                break;

                case "get":
                    Show show = bys.getAShow(check[1], tokens[1]);
                    if (show != null) {
                       System.out.println(show.printExceptTickets());
                    } else {
                        System.out.println("No show");
                    }
                break;

                case "print":
                    bys.printTicket(check[1], tokens[1], tokens[2]);
                break;

                case "showAll":
                    bys.showAll();
                break;

                default:
                break;
            }
        }
    }
}

/**
 * Class for show.
 */
class Show {
    /**
     * shows's movie name.
     */
    private String movieName;
    /**
     * show's dat and time.
     */
    private String dateTime;
    /**
     * seats available in the show.
     */
    private String[] seats;

    /**
     * Constructs the object.
     */
    Show() {
    }

    /**
     * Constructs the object.
     *
     * @param      name      The name
     * @param      datetime  The datetime
     * @param      seatsavailable     The seatsavailable
     */
    Show(final String name, final String datetime,
        final String[] seatsavailable) {
        this.movieName = name;
        this.dateTime = datetime;
        this.seats = seatsavailable;
    }

    /**
     * Gets the movie name.
     *
     * @return     The movie name.
     */
    public String getMovieName() {
        return this.movieName;
    }
    /**
     * Gets the date time.
     *
     * @return     The date time.
     */
    public String getDateTime() {
        return this.dateTime;
    }
    /**
     * Gets the seats.
     *
     * @return     The seats.
     */
    public String[] getSeats() {
        return this.seats;
    }

    /**
     * print ticket for customer.
     *
     * @return     { description_of_the_return_value }
     */
    public String printExceptTickets() {
        String s = "";
        s += movieName + "," + dateTime;
        return s;
    }

    /**
     * Returns a string representation of the object.
     *
     * @return     String representation of the object.
     */
    public String toString() {
        String s = "";
        s += movieName + "," + dateTime + ",";
        s += Arrays.toString(seats).replace(", ", ",");
        return s;
    }

}

/**
 * Class for patron.
 */
class Patron {
    /**
     * Storing the customer name .
     */
    private String customerName;
    /**
     * Storing the customer mobile number.
     */
    private String customerNumber;
    /**
     * storing booked seats bu customer.
     */
    private String[] bookedSeats;

    /**
     * Constructs the object.
     *
     * @param      name    The name
     * @param      number  The number
     * @param      seats   The seats
     */
    Patron(final String name, final String number, final String[] seats) {
        this.customerNumber = number;
        this.customerName = name;
        this.bookedSeats = seats;
    }

    /**
     * Gets the customer name.
     *
     * @return     The customer name.
     */
    public String getCustomerName() {
        return this.customerName;
    }
    /**
     * Gets the customer number.
     *
     * @return     The customer number.
     */
    public String getCustomerNumber() {
        return this.customerNumber;
    }
    /**
     * Gets the booked seats.
     *
     * @return     The booked seats.
     */
    public String[] getBookedSeats() {
        return this.bookedSeats;
    }

    /**
     * Returns a string representation of the object.
     *
     * @return     String representation of the object.
     */
    public String toString() {
        String s = "";
        return s;
    }

}

/**
 * Class for book your show.
 */
class BookYourShow {
    /**
     * To create showa array object.
     */
    private Show[] shows;
    /**
     * TO create patrons array object.
     */
    private Patron[] patrons;
    /**
     * to maintain length of the shows size.
     */
    private int showSize;
    /**
     * to maintain length of the patrons size.
     */
    private int patronSize;

    /**
     * Constructs the object.
     */
    BookYourShow() {
        shows = new Show[2];
        patrons = new Patron[2];
        patronSize = 0;
        showSize = 0;
    }

    /**
     * Adds a show to shows array.
     *
     * @param      newShow  The new show
     */
    public void addAShow(final Show newShow) {
        if (showSize == shows.length) {
            resize();
        }
        shows[showSize++] = newShow;
    }

    /**
     * Adds a patron to patrons array.
     *
     * @param      patron  The patron
     */
    public void addAPatron(final Patron patron) {
        if (patronSize == patrons.length) {
            resize();
        }
        patrons[patronSize++] = patron;
    }

    /**
     * resizing the patrons and shows array.
     */
    private void resize() {
        shows = Arrays.copyOf(shows, 2 * showSize);
        patrons = Arrays.copyOf(patrons, 2 * patronSize);
    }

    /**
     * Gets a show by passing movie name and date and time.
     *
     * @param      moviename  The moviename
     * @param      datetime   The datetime
     *
     * @return     A show.
     */
    public Show getAShow(final String moviename, final String datetime) {
        for (int i = 0; i < showSize; i++) {
            if (shows[i].getMovieName().equals(moviename)
                && shows[i].getDateTime().equals(datetime)) {
                return shows[i];
            }
        }
        return null;
    }

    /**
     * book a show which is requested by the Patron.
     *
     * @param      moviename  The moviename
     * @param      datetime   The datetime
     * @param      p          { parameter_description }
     */
    public void bookAShow(final String moviename,
        final String datetime, final Patron p) {
        addAPatron(p);
        Show avaiableShow = getAShow(moviename, datetime);
        if (avaiableShow != null) {
            String[] seats = avaiableShow.getSeats();
            String[] bookedSeats = p.getBookedSeats();
            for (int i = 0; i < seats.length; i++) {
                for (int j = 0; j < bookedSeats.length; j++) {
                    if (seats[i].equals(bookedSeats[j])
                        && !seats[i].equals("N/A")) {
                        seats[i] = "N/A";
                    }
                }
            }
        } else {
            System.out.println("No show");
        }
    }

    /**
     * Shows all the available tickets.
     */
    public void showAll() {
        for (int i = 0; i < showSize; i++) {
            System.out.println(shows[i]);
        }
    }

    /**
     * print tickets booked by Patron.
     *
     * @param      moviename     The moviename
     * @param      datetime      The datetime
     * @param      mobileNumber  The mobile number
     */
    public void printTicket(final String moviename,
        final String datetime, final String mobileNumber) {
        Show show = getAShow(moviename, datetime);
        if (show != null) {
            for (int j = 0; j < patronSize; j++) {
                if (patrons[j].getCustomerNumber().equals(mobileNumber)) {
                    System.out.println(mobileNumber + " " + moviename
                     + " " + datetime);
                    return;
                }
            }
            System.out.println("Invalid");
        } else {
            System.out.println("Invalid");
        }

    }
}
