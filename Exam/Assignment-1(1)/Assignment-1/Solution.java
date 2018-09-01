import java.util.Scanner;
/**
* HelloWorld.java.
* @author MurthyVemuri
*/
public final class Solution {
    /**
    * Empty constructor.
    */
    private Solution() {
        //I am not using this constructor
    }
    /**
    * main method as driver program.
    * @param args is the parameter for this method
    */
    public static void main(final String[] args) {
        Scanner scan = new Scanner(System.in);
        int n = scan.nextInt();
        String temp = "";
        int  i;
        for (i = 2; i <= n; i++) {
            if (isOdd(i)) {
                if (isComposite(i)) {
                    System.out.println(i);
                }
            }
        }
    }
    /**
     * Determines if composite.
     *
     * @param      n     { parameter_description }
     *
     * @return     True if composite, False otherwise.
     */
    public static boolean isComposite(final int n) {
        if (n % 2 == 0) {
            return true;
        } else {
            for (int i = 1 + 2; i < n; i++) {
                if (n % i == 0) {
                    return true;
                }
            }
            return false;
        }
    }
    /**
     * Determines if odd.
     *
     * @param      n     { parameter_description }
     *
     * @return     True if odd, False otherwise.
     */
    public static boolean isOdd(final int n) {
        return ((n % 2) == 1);
    }
}
