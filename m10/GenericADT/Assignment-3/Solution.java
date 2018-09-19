/**
 * List of Generics.
 * @author : MurthyVemuri
 */
import java.io.BufferedInputStream;
import java.util.Scanner;
/**
 * Class for student.
 */
final class Student {
    /**
     * variable String.
     */
    private String name;
    /**
     * Constructs the object.
     *
     * @param      nameObject  The name
     */
    Student(final String nameObject) {
    //A constructor used to initialize the instance variables
        this.name = nameObject;
    }

    /**
     * Gets the name.
     *
     * @return     The name.
     */
    public String getName() {
    //Getter method which returns the value of instance variable
        return this.name;
    }

    /**
     * equals.
     *
     * @param      other  The other
     *
     * @return     { description_of_the_return_value }
     */
    @Override
    public boolean equals(final Object other) {
    //This method is to check if two students names are equal or not
        if (!(other instanceof Student)) {
            return false;
        }

        Student that = (Student) other;
        return this.getName().equals(that.getName());
    }

    /**
     * return hashcode for checkstyle errors.
     *
     * @return     { description_of_the_return_value }
     */
    public int hashCode() {
        return 0;
    }

    /**
     * Returns a string representation of the object.
     *
     * @return     String representation of the object.
     */
    public String toString() {
        return this.name;
    }
}

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
     * Constructs the object.
     *
     * @param      stdin  The stdin
     */
    public static void executeListString(final Scanner stdin) {
        List<String> listString = new List();
        while (stdin.hasNext()) {
            // read the line
            String line = stdin.nextLine();
            // split the line using space
            String[] tokens = line.split(" ");
            // based on the list operation
            //invoke the corresponding method
            switch (tokens[0]) {
                case "add":
                    listString.add(tokens[1]);
                break;
                case "addAll":
                if (tokens.length == 2) {
                String[] t1 = tokens[1].split(",");
                listString.addAll(t1);
                }
                break;
                case "size":
                System.out.println(listString.size());
                break;
                case "print":
                System.out.println(listString);
                break;
                case "remove":
                listString.remove(Integer.parseInt(tokens[1]));
                break;
                case "indexOf":
                System.out.println(listString.indexOf(tokens[1]));
                break;
                case "get":
                System.out.println(listString.get(
                    Integer.parseInt(tokens[1])));
                break;
                case "contains":
                System.out.println(listString.contains(
                    tokens[1]));
                break;
                default:break;
            }
        }
    }
    /**
     * main method.
     *
     * @param      args  The arguments
     */
    public static void main(final String[] args) {
        Scanner stdin = new Scanner(new BufferedInputStream(System.in));
        String objectType = stdin.nextLine();
        switch (objectType) {
            case "S"://This case will be executed for String type list
            case "I"://This case will be executed for Integer type list
            case "F"://This case will be executed for Float type list
            case "C"://This case will be executed for Character type list
            case "D"://This case will be executed for Double type list
            executeListString(stdin);
            break;
            case "O":
                List<Student> listStudent = new List();
                while (stdin.hasNext()) {
                    // read the line
                    String line = stdin.nextLine();
                    // split the line using space
                    String[] tokens = line.split(" ");
                    // based on the list operation
                    //invoke the corresponding method
                    switch (tokens[0]) {
                        case "add":
                            Student pvsTeja = new Student(tokens[1]);
                            listStudent.add(pvsTeja);
                        break;
                        case "addAll":
                        if (tokens.length == 2) {
                        String[] t1 = tokens[1].split(",");
                        Student[] temp = new Student[t1.length];
                        for (int i = 0; i < t1.length; i++) {
                            temp[i] = new Student(t1[i]);
                        }
                        listStudent.addAll(temp);
                        }
                        break;
                        case "size":
                        System.out.println(listStudent.size());
                        break;
                        case "print":

                        System.out.println(listStudent);
                        break;
                        case "remove":
                        listStudent.remove(Integer.parseInt(tokens[1]));
                        break;
                        case "indexOf":
                        System.out.println(listStudent.indexOf(
                                new Student(tokens[1])));
                        break;
                        case "get":
                        System.out.println(listStudent.get(
                                Integer.parseInt(tokens[1])));
                        break;
                        case "contains":
                        System.out.println(listStudent.contains(
                                new Student(tokens[1])));
                        break;
                        default:break;
                    }
                }
                break;
            default:
            break;
        }
    }
}
