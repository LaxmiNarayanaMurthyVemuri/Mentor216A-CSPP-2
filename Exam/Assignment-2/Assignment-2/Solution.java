import java.util.Scanner;
/**
 * HelloWorld.java.
 * @author     MurthyVemuri
 */
public final class Solution {
    /**
     * @variable integer variable HUNDRED.
     */
    private static final int HUNDRED = 100;
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
        int[][] matrix = takingInput(scan);
        int i, j;
        for (i = 0; i < matrix.length; i++) {
            for (j = 0; j < matrix[0].length - 1; j++) {
                System.out.print(matrix[i][j] + " ");
            }
            System.out.println(matrix[i][j]);
        }
    }
    /**
     * { function_description }.
     *
     * @param      scan  The scan
     *
     * @return     { description_of_the_return_value }
     */
    public static int[][] takingInput(final Scanner scan) {
        int a = scan.nextInt();
        int b = scan.nextInt();
        int[][] matrix = new int[a][b];
        for (int i = 0; i < a; i++) {
            for (int j = 0; j < b; j++) {
                matrix[i][j] = round(scan.nextInt());
            }
        }
        return matrix;
    }

    /**
     * { function_description }.
     *
     * @param      n     { parameter_description }
     *
     * @return     { description_of_the_return_value }
     */
    public static int round(final int n) {
        int a = (n / HUNDRED) * HUNDRED;
        int b = a + HUNDRED;
        if ((2 * n) >= (b + a)) {
            return b;
        }
        return a;
    }
}
