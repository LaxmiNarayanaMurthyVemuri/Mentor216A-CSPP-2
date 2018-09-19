/**
 * List of Integers.
 * @author : MurthyVemuri
 */
import java.io.BufferedInputStream;
import java.io.PrintStream;
import java.util.Arrays;
import java.util.Scanner;
/**
 * List of Generic Objects.
 *
 * @param      <Matrix>   { parameter_description }
 */
public class List<Matrix> {
    private Matrix[] list;
    private int size;
    /**
     * Constructs the object.
     */
    public List() {
        list = (Matrix[])new Object[10];
        size = 0;
    }
    /**
     * Constructs the object.
     *
     * @param      paramInt  The parameter int
     */
    public List(int paramInt) {
        list = ((Matrix[])new Object[paramInt]);
        size = 0;
    }
    /**
     * adds element at last.
     *
     * @param      paramE  The parameter e
     */
    public void add(Matrix paramE) {
        if (size == list.length) {
            resize();
        }
        list[(size++)] = paramE;
    }
    /**
     * resize list by double.
     */
    private void resize() {
        list = Arrays.copyOf(list, size * 2);
    }
    /**
     * Adds all items.
     *
     * @param      paramArrayOfE  The parameter array of e
     */
    public void addAll(Matrix[] paramArrayOfE) {
        for (int i = 0; i < paramArrayOfE.length; i++) {
           add(paramArrayOfE[i]);
        }
    }
    /**
     * adds elemenet at particular index.
     *
     * @param      paramInt  The parameter int
     * @param      paramE    The parameter e
     */
    public void add(int paramInt, Matrix paramE) {
        if (paramInt < 0) {
            System.out.println("Negative Index Exception");
            return;
        }
        if (size == list.length - 1)
            resize();
        for (int i = size; i > paramInt; i--)
            list[i] = list[(i - 1)];
        list[paramInt] = paramE;
        size += 1;
    }
    /**
     * returns frequency of given element in the list.
     *
     * @param      paramE  The parameter e
     *
     * @return     { description_of_the_return_value }
     */
    public int count(Matrix paramE) {
        int count = 0;
        for (int j = 0; j < size; j++) {
            if (list[j].equals(paramE)) {
               count++;
            }
        }
        return count;
    }
    /**
     * returns current size of elements in list.
     *
     * @return     { description_of_the_return_value }
     */
    public int size() {
        return size;
    }
    /**
     * removes element at given index.
     *
     * @param      paramInt  The parameter int
     */
    public void remove(int paramInt) {
        if ((paramInt >= 0) && (paramInt < size)) {
            for (int i = paramInt; i < size - 1; i++) {
                list[i] = list[(i + 1)];
            }
            size -= 1;
        } else {
            System.out.println("Invalid Position Exception");
        }
    }
    /**
     * returns Object at the given index.
     *
     * @param      paramInt  The parameter int
     *
     * @return     { description_of_the_return_value }
     */
    public Matrix get(int paramInt) {
        if ((paramInt < 0) || (paramInt >= size)) {
           return null;
        }
        return list[paramInt];
    }
    /**
     * Returns a string representation of the object.
     *
     * @return     String representation of the object.
     */
    public String toString() {
        if (size == 0)
            return "[]";
        StringBuffer localStringBuffer = new StringBuffer("[");
        int i = 0;
        for (i = 0; i < size - 1; i++) {
            localStringBuffer.append(list[i] + ",");
        }
        localStringBuffer.append(list[i] + "]");
        return localStringBuffer.toString();
    }
    /**
     * returns true if paramE is in the list.
     *
     * @param      paramE  The parameter e
     *
     * @return     { description_of_the_return_value }
     */
    public boolean contains(Matrix paramE) {
        return indexOf(paramE) > -1;
    }
    /**
     * Searches for the first match.
     *
     * @param      paramE  The parameter e
     *
     * @return     { description_of_the_return_value }
     */
    public int indexOf(Matrix paramE) {
        for (int i = 0; i < size; i++) {
        if (list[i].equals(paramE))
            return i;
        }
        return -1;
    }

        /* Removes all of its elements that
     * are contained in the specified int array.
     */
    public void removeAll(Matrix[] arr) {
        for(int i = 0; i < arr.length; i++) {
            for(int j = 0; j < size; j++) {
                if(arr[i].equals(list[j])) {
                    remove(j);
                }
            }
        }
    }

    /*Returns a list containing elements, including
     startIndex and excluding endIndex. The first parameter
     indicates the startIndex and the second parameter
     indicates the endIndex.
     */
    public List subList(int start, int end) {
        if (start >= 0 && end >= 0) {
            if (start == end) {
            	return new List();
            } else if (end > start){
                List subList = new List(end-start);
                int j = 0;
                for (int i = start; i < end; i++ ) {
                    subList.add(list[i]);
                }
                return subList;
            } else {
                System.out.println("Index Out of Bounds Exception");
                return null;
            }
        } else {
            System.out.println("Index Out of Bounds Exception");
            return null;
        }
    }
    /*Returns a boolean indicating whether the parameter
      i.e a List object is exactly matching with the given list or not.
     */
    public boolean equals(List<Matrix> other) {
        for (int i = 0; i < this.size() ;i++ ) {
            if (!other.contains(this.get(i))) {
                return false;
            }
        }
        return true;
    }
    /*Removes all the elements from list*/
    public void clear() {
        size = 0;
    }
}
