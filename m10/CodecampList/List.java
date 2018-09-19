import java.io.BufferedInputStream;
import java.util.Scanner;

/**
 * List of ListADT.
 */
public class List<T> {
    //Implement all the methods mentioned to build a ListADT.
    /**
    *@variable TEN
    */
    private static final int TEN = 10;

    /**
     * The goal for the list is to store items.
     * How are we going to store the items in the list?
     * An array would be good. Right?
     * So, assume we are only going to have ints in the list
     * We need to create an array of ints to store the items
     * added to the list.
     *
     * Create a variable of the type int[]
     * Use the private access specifier
     * Why private access specifier and why not public?
     * Well, we don't want the array to be manipulated by
     * methods that are outside the List class.
     * If you allow methods outside the List class to manipulate
     * the array then there is a possibility of having a corrupted
     * list i.e., a list with incorrect items.
     * This is not desirable and so having private access specifer
     * will protect the array such corruption.
     * This is a hard concept to understand. Discuss with your mentor.
     *
    */
    private T[] list;
    // declare a private int[]
    // don't create the array yet using new
    // that's the job of the List constructor

    /**
     * What are the other class variables needed for creating a list?
     * How about keeping track of the size of the list?
     * If you add 2 items to the list then the size should be 2.
     * Let's think about the size of the list by comparing it to the
     * length of the array. Do they mean the same?
     * No, Array length signifies the maximum number of items
     * you can store in the list. Whereas, the size of the list
     * denotes the number of items in the list. Makes sense?
     * Here is an example:
     * array = [1,2,3,0,0,0,0,0,0,0]
     * The length of the array is 10 and size is 3.
     * This means you can store 10 items in the list and
     * currently it has 3 items.
     * So, to keep track of the size we need a variable called size
     * Again, we use private as we don't want that size variable
     * to be accessed by the methods that are outside of the List class.
     */
    private int size;
    // declare a private int size
    // again, don't initialize it here
    // variable initialization should be done in the constructor

    /**
     * The purpose of the constructor is to initialize the class variables with
     * some default values.
     */
    public List() {

        // what are the two variables to be initialized here? think about the
        // private variables described above. What should be the default values?
        // In the case of the list, it should be empty but it should be
        // initialized with an array size like 10
        this.list = (T[])new Object[TEN];
        this.size = 0;
        // Think about the initial value for size.
        // How many items do we have in the list when you create it?
        // An empty list has how many items?
        // That is the initial value to use for size.

    }
    /**
     * The add method does what the name suggests. Add an int item to the list.
     * The assumption is to store the item at the end of the list What is the
     * end of the list? Is it the same as the end of the array? Think about how
     * you can use the size variable to add item to the list.
     *
     * The method returns void (nothing)
     *
     * @param      item  The item
     */
    public void add(final T item) {
        //Inserts the specified element at the end of the list.
        if (size < list.length) {
            list[size] = item;
            size++;
        }
    }

    /**
     * The size method returns the value of the size. The purpose of the method
     * is to announce the size of the list to the objects outside the list
     *
     * The method returns an int. Empty list should return 0.
     *
     * @return     { description_of_the_return_value }
     */
    public int size() {
        // replace the code below to implement the size method
        return size;
    }

    /**
     * The remove method does what the name suggests. Removes an int item,
     * specified by the index argument, from the list It also does an additional
     * step. Think about what happens when an item is removed from the middle of
     * the list It creates a hole in the list, right? This would mean, all the
     * items that are to the right side of the removed item should be moved to
     * the left by one position. Here is an example: array =
     * [1,2,3,0,0,0,0,0,0,0] remove(1) would remove the item 2 which is at index
     * position 1. But how do you remove the item from an array? Well, the way
     * to remove it is to move all the items, that are to the right of the
     * removed item, to the left So, the new array looks like this. array =
     * [1,3,0,0,0,0,0,0,0,0] The method returns void (nothing)
     *
     * @param      index  The index
     */
    public void remove(final int index) {
        // write the logic for remove here.
        // Think about what to do to the size variable.
        if (index >= 0 && index < size) {
            for (int i = index; i < size - 1; i++) {
                list[i] = list[i + 1];
            }
            size--;
        } else {
            System.out.println("Invalid Position Exception");
        }
    }

    /**
     * Get method has to return the items that is at the index position passed
     * as an argument to the method. If the item doesn't exist then return a -1
     * to indicate that there is no element at that index. How can an element
     * not be there at a given position? Well, if the position is greater than
     * the number of items in the list then that would mean the item doesn't
     * exist. How do we check if the position is greater than the number of
     * items in the list? Would size variable be useful?
     *
     * @param      index  The index
     *
     * @return     { description_of_the_return_value }
     */
    public T get(final int index) {
        // Replace the code below to write the code for get
        if (index >= 0 && index < size) {
            return list[index];
        }
        return null;
    }

    /**
     * What happens when you print an object using println? Java provides a
     * method named toString that is internally invoked when an object variable
     * is used in println. For example: List l = new List();
     * System.out.println(l); This statement is a shortcut for
     * System.out.println(l.toString());
     *
     * So, implement the toString method to display the items in the list in the
     * square brackets notation. i.e., if the list has numbers 1, 2, 3 return
     * the string [1,2,3] Caution: The array may be having other elements
     * Example: [1,2,3,0,0,0,0,0,0,0] toString should only return the items in
     * the list and not all the elements of the array.
     *
     * @return     String representation of the object.
     */
    public String toString() {
        // Replace the code below
        String s = "[";
        int i;
        for (i = 0; i < size - 1; i++) {
            s += list[i] + ",";
        }
        s += list[i] + "]";
        return s;
    }
    /**
     * Contains return true if the list has the item passed as an argument to
     * the method So, iterate through the list and return true if the item
     * exists and otherwise false.
     *
     * @param      item  The item
     *
     * @return     { description_of_the_return_value }
     */
    public boolean contains(final T item) {
        // Replace the code below
        return (indexOf(item) >= 0);
    }

    /**
     * Returns the index of the first occurrence of the specified element in
     * this list, or -1 if this list does not contain the element.
     *
     * @param      item  The item
     *
     * @return     { description_of_the_return_value }
     */
    public int indexOf(final T item) {
        // Replace the code below
        for (int index = 0; index < size; index++) {
            if (item.equals(list[index])) {
                return index;
            }
        }
        return -1;
    }
    /**
     * frequency count of given item in list.
     *
     * @param      item  The item
     *
     * @return     { description_of_the_return_value }
     */
    public int count(T item) {
        int count = 0;
        for (int i = 0; i < size ;i++) {
            if (item.equals(list[i])){
                count ++;
            }
        }
        return count;
    }

    public void add(int index, T item) {
        if (index >= 0 && size <= list.length) {
            for (int i = size - 1;i >= index  ;i--) {
                list[i + 1] = list[i];
            }
            size++;
            list[index] = item;
        } else if (index < 0){
            System.out.println("Negative Array Size Exception");
        } else {
            System.out.println("List is full");
        }
    }
}
