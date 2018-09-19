import java.io.BufferedInputStream;
import java.util.Scanner;
import java.util.Arrays;

/**
 * Class for set.
 */
public class Set {
    //your code goes here...
    //Good luck :-)

    //properties

    /**
     * set declaration.
     */
    private int[] array;

    /**
     * size of the set.
     */
    private int size;

    //constructor

    /**
     * Constructs the object.
     */
    public Set() {
        final int defaultsize = 10;
        array = new int[defaultsize];
        size = 0;
    }

    //methods

    /**
     * getter for the set element.
     *
     * @param      index  The index
     *
     * @return     value at the index.
     */
    public int get(int index) {
        if (index >= 0 && index < this.size()) {
            return this.array[index];
        }
        return -1;
    }


    public void sizeinc(){
        this.size++;
    }



    /**
     * getter for size.
     *
     * @return   size of the set.
     */
    public int size() {
        return this.size;
    }

    /**
     * checks if element in set or not.
     *
     * @param      item  The item to be checked.
     *
     * @return     true if present else false.
     */
    public boolean contains(final int item) {
        for (int i = 0; i < size; i++) {
            if (this.array[i] == item) {
                return true;
            }
        }
        return false;
    }

    /**
     * Returns a string representation of the object.
     *
     * @return     String representation of the object.
     */
    public String toString() {
        int[] tmparray = new int[size];
        for (int i = 0; i < size; i++) {
            tmparray[i] = this.get(i);
        }
        return Arrays.toString(tmparray).replace("[", "{").replace("]", "}");
    }

    /**
     * resizes the set or increse the memory of set.
     */
    public void resize() {
        final int factor = 2;
        int[] newarray = new int[factor * size];
        for (int i = 0; i < size; i++) {
            newarray[i] = this.array[i];
        }

        array = newarray;
    }

    /**
     * add element to the set.
     *
     * @param      item  The item to be added.
     */
    public void add(final int item) {
        if (size == this.array.length) {
            resize();
        }
        if (!contains(item)) {
            array[size++] = item;
        }
    }

    /**
     * add elements to set if not present.
     *
     * @param      items  The items of int array.
     */
    public void add(final int[] items) {
        for (int i : items) {
            if (!contains(i)) {
                add(i);
            }
        }
    }

    public void arraysetter(int item,int index) {
        this.array[index] = item;
    }

    
    public int getarraylength() {
        return this.array.length;
    }

    public int[] getArray() {
        return Arrays.copyOf(this.array,this.size);
    }





    /**
     * intersection of to sets.
     *
     * @param      other  The Set other
     *
     * @return     intersection of two set elements
     * in an another set.
     */
    public Set intersection(final Set other) {
        Set result = new Set();

        for (int i : this.array) {
            if (other.contains(i)) {
                result.add(i);
            }
        }

        return result;
    }

    /**
     * retain all from the items given.
     *
     * @param items int type elements array.
     *
     * @return Set with retained elements.
     */
    public Set retainAll(final int[] items) {
        Set result = new Set();

        for (int i : this.array) {
            for (int j : items) {
                if (i == j) {
                    result.add(i);
                }
            }
        }

        return result;
    }

    /**
     * cartesian product.
     *
     * @param      obj   The Set object
     *
     * @return     cartesian product of two sets.
     */
    public int[][] cartesianProduct(final Set obj) {
        int estimatedrows = this.size() * obj.size();
        int n = 0;
        int[][] result = new int[estimatedrows][2];
        int k = 0;
        for (int i = 0; i < estimatedrows; i++) {
            result[i][0] = this.array[n];
            result[i][1] = obj.array[k++];
            if (k == obj.size()) {
                k = 0;
                n++;
            }
        }

        return result;
    }

}


