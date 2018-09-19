public class ListTest {
    private int[] list;
    private int size;

    public ListTest() {
        list = new int[10];
        size = 0;
    }

    public void add(final int item) {
        //Inserts the specified element at the end of the list.
        if (size < list.length) {
            list[size] = item;
            size++;
        }
    }

    public void add(int index, int item) {
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

    public static void main(String[] args) {
        ListTest l = new ListTest();
        l.add(3);
        l.add(32);
        l.add(33);
        l.add(34);
        System.out.println(l);
        l.add(0, 234);
        System.out.println(l);
        l.add(2, 334);
        System.out.println(l);
        l.add(3, 434);
        System.out.println(l);
        l.add(4, 534);
        System.out.println(l);
        l.add(-9, 634);
        System.out.println(l);
        l.add(6, 734);
        System.out.println(l);


    }
}