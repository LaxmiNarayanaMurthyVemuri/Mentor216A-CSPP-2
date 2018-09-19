import java.util.Scanner;
import java.util.ArrayList;

/**
 * Class for solution.
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
                        new Patron(tokens[2], tokens[2 + 1]), seats);
                break;

                case "get":
                    Show show = bys.getAShow(check[1], tokens[1]);
                    if (show != null) {
                       System.out.println(show);
                    } else {
                        System.out.println("No show");
                    }
                break;

                case "print":
                    bys.printAllShows(check[1], tokens[1], tokens[2]);
                break;

                case "showAll":
                    bys.printAllShows();
                break;

                default:
                break;
            }
        }
    }
}


class Show {
    private String nameOfMovie;
    private String date;
    private String[] seats;

    Show(String nameOfMovie , String date , String[] seats) {
        this.nameOfMovie = nameOfMovie;
        this.date = date;
        this.seats = seats;
    }

    public String getMovie() {
        return nameOfMovie;
    }

    public String getDate() {
        return date;
    }

    public String[] getSeatNumbers() {
        return seats;
    }

    public void printComplete() {
        String s = "";
        s += nameOfMovie + "," + date + ","  + "[";

        int i = 0;
        for (i = 0; i < seats.length - 1; i++) {
            s += seats[i] + ",";
        }
        System.out.println(s + seats[i] + "]");
    }
    public String toString() {
        String s = "";
        s += nameOfMovie + "," + date;
        return s;
    }
}

class Patron {
    private String customerName;
    private String mobileNumber;

    Patron(String customerName , String mobileNumber) {
        this.customerName = customerName;
        this.mobileNumber = mobileNumber;
    }

    public String getCustomerName() {
        return customerName;
    }
    
    public String getMobileNumber() {
        return mobileNumber;
    }

    public String toString() {
        return this.customerName + " " + this.mobileNumber;
    }

}

class BookYourShow {
    
    private ArrayList<Show> arrList;
    private ArrayList<Patron> arrPatron;

    BookYourShow(){
        arrList = new ArrayList<Show>();
        arrPatron = new ArrayList<Patron>();
    }

    public void addAShow(Show s) {
        arrList.add(s);
    }

    public Show getAShow(String movie, String date) {
        int i;
        for (i = 0 ;i < arrList.size(); i++) {
            if (movie.equals(arrList.get(i).getMovie())) {
                if (date.equals(arrList.get(i).getDate())) {
                return arrList.get(i);
                }
            }
        }
        return null;
    }

    public void bookAShow(String mname , String date, Patron p, String[] noOfTickets) {
        arrPatron.add(p);
        Show show = getAShow(mname, date);
        if (show != null) {
            for (int i = 0; i < noOfTickets.length; i++) {
                String[] seats = show.getSeatNumbers();
                for (int j = 0; j < seats.length; j++) {
                    if (noOfTickets[i].equals(seats[j]) && (!seats[i].equals("N/A"))) {
                        seats[j] = "N/A";
                    }
                }
            }
        } else {
            System.out.println("No show");
        }

    }

    public void printAllShows(String movie, String date, String phone){
        Show show = getAShow(movie, date);
        if (show != null) {
            for (Patron p : arrPatron) {
                if(p.getMobileNumber().equals(phone)) {
                    System.out.println(phone + " " + movie + " " + date);
                    return;
                }
            }
            System.out.println("Invalid");
        } else {
            System.out.println("Invalid");
        }
    }

    public void printAllShows(){
        for(int i = 0; i< arrList.size(); i++)
            arrList.get(i).printComplete();
    }

}
