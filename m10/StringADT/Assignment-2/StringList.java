// An interface for ListADT of strings
import java.util.Arrays;

/**
 * Interface for string list interface.
 */
interface StringListInterface {
	 public void add(String item);
	 public void addAll(String items[]);
	 public String get(int index);
	 public int size();
	 public void remove(int index);
	 public boolean contains(String item);
	 public int indexOf(String item);
}
//Write a StringList class which implements StringListInterface 

/**
 * List of strings.
 */
public class StringList implements StringListInterface {
    //Implement all the methods mentioned to build a ListADT
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
    private String[] list;
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
     *
     */
    private int size;
    /**
     * The purpose of the constructor is to initialize the class variables with
     * some default values.
     */
    public StringList() {
        // what are the two variables to be initialized here? think about the
        // private variables described above. What should be the default values?
        // In the case of the list, it should be empty but it should be
        // initialized with an array size like 10
        list = new String[2 + 2 + 2 + 2 + 2];
        // Think about the initial value for size.
        // How many items do we have in the list when you create it?
        // An empty list has how many items?
        // That is the initial value to use for size.
        size = 0;
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
    public void add(final String item) {
        //Inserts the specified element at the end of the zelist.
        if (size == list.length) {
            resize();
        }
        list[size++] = item;
    }
    /**
     * Resizes the array by the double.
     */
    public void resize() {
        list = Arrays.copyOf(list, 2 * size);
    }
    /**
     * Resize the list Sometimes the clients of the ADT won't know the expected
     * list capacity To solve this the list has to grow dynamically when the
     * maximum capacity is reached and there is no room to add items. So, how do
     * we dynamically resize the list? Java doesn't support resize of array.
     * Here are some options.
     *
     * Option 1 Create a new array of the desired size, and copy the contents
     * from the original array to the new array, using
     * java.lang.System.arraycopy(...);
     *
     * Option 2 Use java.util.Arrays.copyOf(...) methods which returns a bigger
     * array, with the contents of the original array.
     *
     * TODO Create a method called resize(). Resize should create an new array
     * that is double the size of the old array. Then copy the contents of the
     * old array to the new one.
     *
     * When should the resize method be invoked and from where? Will the client
     * invoke resize or is it internal to List class? Should the resize be
     * public method or private? Should the resize method return any values? You
     * know enough of Object Oriented Programming to answer these questions :-)
     *
     * @param      capacity  The capacity
     */
    public StringList(final int capacity) {
        list = new String[capacity];
        size = 0;
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
    public String get(final int index) {
        if (index < 0 || index >= size) {
            return null;
        } else {
            return list[index];
        }
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
        if (size == 0) {
            return "[]";
        }
        String str = "[";
        int i = 0;
        for (i = 0; i < size - 1; i++) {
            str = str + list[i] + ",";
        }
        str = str + list[i] + "]";
        return str;
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
    public boolean contains(final String item) {
        return indexOf(item) == -1;
    }
    /**
     * Returns the index of the first occurrence of the specified element in
     * this list, or -1 if this list does not contain the element.
     *
     * @param      item  The item
     *
     * @return     { description_of_the_return_value }
     */
    public int indexOf(final String item) {
        for (int i = 0; i < size; i++) {
            if (item.equals(list[i])) {
                return i;
            }
        }
        return -1;
    }
    /**
     * Gets the frequency of the given item.
     *
     * @param      item  The item
     *
     * @return     { description_of_the_return_value }
     */
    public int count(final String item) {
        int count = 0;
        for (int i = 0; i < size; i++) {
            if (item.equals(list[i])) {
                count++;
            }
        }
        return count;
    }
    /**
     * adds the item in the given index.
     *
     * @param      index  The index
     * @param      item   The item
     */
    public void add(final int index, final String item) {
        if (index >= 0) {
            for (int i = size; i > index; i--) {
                list[i] = list[i - 1];
            }
            list[index] = item;
            size++;
        } else if (list.length == size) {
            resize();
        } else {
            System.out.println("Negative Index Exception");
        }
    }
    /**
     * Adds all items in list.
     *
     * @param      items  The items
     */
    public void addAll(final String[] items) {
        for (int i = 0; i < items.length; i++) {
            add(items[i]);
        }
    }
}