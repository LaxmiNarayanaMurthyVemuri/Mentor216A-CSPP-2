import java.util.Arrays;
import java.util.Scanner;
import java.io.BufferedInputStream;

/**
 * Exception for signaling invalid subset selection errors.
 */
class InvalidSubsetSelectionException extends Exception {
    /**
     * Returns a string representation of the object.
     *
     * @return     String representation of the object.
     */
    public String toString() {
        return "Invalid Arguments to Subset Exception";
    }
}
/**
 * Exception for signaling set empty errors.
 */
class SetEmptyException extends Exception {
    /**
     * Returns a string representation of the object.
     *
     * @return     String representation of the object.
     */
    public String toString() {
        return "Set Empty Exception";
    }
}
/**
 * Class for sorted set.
 */
class SortedSet extends Set {


    /**
     * Constructs the object.
     */
    SortedSet() {
        /**
         * Refers the the Parent class constructor.
         */
        super();
    }
    /**
     * adds an element to the array.
     *
     * @param      item  The item
     */
    @Override
    public void add(final int item) {
        if (this.size() == this.getarraylength() - 1) {
            resize();
        }

        if (!contains(item)) {
            this.insert(item);
        }

    }
    /**
     * insert an item in the array.
     *
     * @param      item  The item
     */
    public void insert(final int item) {
        int reqindex = 0;
        for (int i = this.size() - 1; i >= 0; i--) {
            if (this.get(i) < item) {
                reqindex = i + 1;
                break;
            }
        }
        int temp = 0;
        if (size() == 0) {
            temp = 0;
        } else {
            temp = this.get(reqindex);
        }
        for (int i = reqindex; i < size() + 1; i++) {
            int tmp2 = this.get(i + 1);
            this.arraysetter(temp, i + 1);
            temp = tmp2;

        }

        this.arraysetter(item, reqindex);
        this.sizeinc();

    }
    /**
     * Adds all.
     *
     * @param      ele   The ele
     */
    public void addAll(final int[] ele) {
        for (int i : ele) {
            this.add(i);
        }
    }

    /**
     * Intersection method.
     *
     * @param      array  The array
     *
     * @return     { description_of_the_return_value }
     */
    /**
     * subSet method.
     *
     * @param      start                            The start
     * @param      end                              The end
     *
     * @return     int array.
     *
     * @throws     InvalidSubsetSelectionException  invalid subset.
     */
    public int[] subSet(final int start, final int end)
    throws InvalidSubsetSelectionException {
        if (start > end) {
            throw new InvalidSubsetSelectionException();
        }

        int i = 0;
        int j = 0;
        for (; i < size(); i++) {
            if (get(i) >= start) {
                break;
            }
        }

        for (j = i; j < size(); j++) {
            if (get(j) >= end) {
                break;
            }
        }

        int[] result = new int[j - i];
        for (int k = 0; i < j; i++, k++) {
            result[k] = get(i);
        }

        return result;
    }
    /**
     * headSet method.
     *
     * @param      element            The element
     *
     * @return     int array.
     *
     * @throws     SetEmptyException  set empty exception.
     */
    public int[] headSet(final int element) throws SetEmptyException {
        if (element <= get(0)) {
            throw new SetEmptyException();
        }

        int i = 0;
        for (; i < size(); i++) {
            if (get(i) >= element) {
                break;
            }
        }

        return Arrays.copyOf(getArray(), i);

    }
    /**
     * last integer.
     *
     * @return     int value.
     *
     * @throws     SetEmptyException  set empty exception.
     */
    public int last() throws SetEmptyException {
        if (this.size() == 0) {
            throw new SetEmptyException();
        }
        return get(this.size() - 1);


    }

}


/**
 * Solution class for code-eval.
 */
public final class Solution {
    /**
     * Constructs the object.
     */
    private Solution() {

    }
    /**
     * helper function to convert string input to int array.
     *
     * @param      s     { string input from test case file }
     *
     * @return     { int array from the given string }
     */
    public static int[] intArray(final String s) {
        String input = s;
        if (input.equals("[]")) {
            return new int[0];
        }
        if (s.contains("[")) {
            input = s.substring(1, s.length() - 1);
        }
        return Arrays.stream(input.split(","))
               .mapToInt(Integer::parseInt)
               .toArray();
    }
    /**
     * main function to execute test cases.
     *
     * @param      args  The arguments
     */
    public static void main(final String[] args) {
        // instantiate this set
        SortedSet s = new SortedSet();
        // code to read the test cases input file
        Scanner stdin = new Scanner(new BufferedInputStream(System.in));
        // check if there is one more line to process
        while (stdin.hasNext()) {
            // read the line
            String line = stdin.nextLine();
            // split the line using space
            String[] tokens = line.split(" ");
            // based on the list operation invoke the corresponding method
            switch (tokens[0]) {
            case "print":
                System.out.println(s);
                break;
            case "add":
                int[] intArray = intArray(tokens[1]);
                s.add(intArray[0]);
                break;
            case "addAll":
                intArray = intArray(tokens[1]);
                s.addAll(intArray);
                break;
            case "subSet":
                intArray = intArray(tokens[1]);
                try {
                    int[] t = s.subSet(intArray[0], intArray[1]);
                    if (t != null) {
                        System.out.println(Arrays.toString(t).
                                           replace("[", "{").replace("]", "}"));
                    }
                } catch (Exception e) {
                    System.out.println("Invalid Arguments to Subset Exception");
                }
                break;
            case "intersection":
                SortedSet s1 = new SortedSet();
                SortedSet t = new SortedSet();
                intArray = intArray(tokens[1]);
                s1.add(intArray);
                intArray = intArray(tokens[2]);
                t.add(intArray);
                System.out.println(s1.intersection(t));
                break;
            case "retainAll":
                SortedSet s2 = new SortedSet();
                intArray = intArray(tokens[1]);
                s2.add(intArray);
                intArray = intArray(tokens[2]);
                System.out.println(s2.retainAll(intArray));
                break;
            case "headSet":
                intArray = intArray(tokens[1]);
                try {
                    System.out.println(Arrays.toString(
                                           s.headSet(intArray[0])).replace(
                                           "[", "{").replace("]", "}"));
                } catch (Exception e) {
                    System.out.println("Set Empty Exception");
                }
                break;
            case "last":
                try {
                    System.out.println(s.last());
                } catch (Exception e) {
                    System.out.println("Set Empty Exception");
                }
            default:
                break;
            }
        }
    }
}
