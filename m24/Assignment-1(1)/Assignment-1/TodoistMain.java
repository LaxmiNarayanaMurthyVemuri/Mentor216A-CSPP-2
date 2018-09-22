import java.util.Scanner;
import java.util.Arrays;


/**
 * Class for task.
 */
class Task {
    /**
     * { var_description }.
     */
    private String title;
    /**
     * { var_description }.
     */
    private String assignedTo;
    /**
     * { var_description }.
     */
    private int timeToComplete;
    /**
     * { var_description }.
     */
    private boolean important;
    /**
     * { var_description }.
     */
    private boolean urgent;
    /**
     * { var_description }.
     */
    private String status;

    /**
     * Constructs the object.
     */
    Task() {

    }

    /**
     * Constructs the object.
     *
     * @param      assign        The assign
     * @param      statusStatic  The status static
     */
    Task(final String assign, final String statusStatic) {
        this.assignedTo = assign;
        this.status = statusStatic;
    }

    /**
     * Gets the time.
     *
     * @return     The time.
     */
    public int getTime() {
        return this.timeToComplete;
    }

    /**
     * Gets the status.
     *
     * @return     The status.
     */
    public String getStatus() {
        return this.status;
    }

    /**
     * Determines if valid status.
     *
     * @param      s     { parameter_description }
     *
     * @return     True if valid status, False otherwise.
     */
    private boolean isValidStatus(final String s) {
        return (s.equals("todo") || s.equals("done"));
    }

    /**
     * Determines if valid time.
     *
     * @param      tt    { parameter_description }
     *
     * @return     True if valid time, False otherwise.
     */
    private boolean isValidTime(final int tt) {
        return tt >= 0;
    }

    /**
     * Determines if valid title.
     *
     * @param      t     { parameter_description }
     *
     * @return     True if valid title, False otherwise.
     */
    private boolean isValidTitle(final String t) {
        return t.equals("");
    }

    /**
     * Gets the important.
     *
     * @return     The important.
     */
    public boolean getImportant() {
        return this.important;
    }

    /**
     * Gets the urgent.
     *
     * @return     The urgent.
     */
    public boolean getUrgent() {
        return this.urgent;
    }


    /**
     * Constructs the object.
     *
     * @param      t     { parameter_description }
     * @param      a     { parameter_description }
     * @param      tt    { parameter_description }
     * @param      i     { parameter_description }
     * @param      u     { parameter_description }
     * @param      s     { parameter_description }
     * @throws     Exception  { exception_description }
     */
    Task(final String t, final String a, final int tt,
        final boolean i, final boolean u, final String s) throws Exception {
        if (!isValidStatus(s)) {
            throw new Exception("Invalid status " + s);
        } else if (!isValidTime(tt)) {
            throw new Exception("Invalid timeToComplete " + tt);
        } else if (isValidTitle(t)) {
            throw new Exception("Title not provided " + t);
        } else {
            this.title = t;
            this.assignedTo = a;
            this.timeToComplete = tt;
            this.important = i;
            this.urgent = u;
            this.status = s;
        }
    }

    /**
     * { function_description }.
     *
     * @param      object  The object
     *
     * @return     { description_of_the_return_value }
     */
    public boolean equals(final Object object) {
        Task that = (Task) object;
        return this.assignedTo.equals(that.assignedTo)
        && this.status.equals(that.status);
    }

    /**
     * { function_description }.
     *
     * @return     { description_of_the_return_value }
     */
    public int hashCode() {
        return -1;
    }

    /**
     * Returns a string representation of the object.
     *
     * @return     String representation of the object.
     */
    public String toString() {
        String s = "";
        String t = "";
        if (important) {
            s = "Important";
        } else {
            s = "Not Important";
        }
        if (urgent) {
            t = "Urgent";
        } else {
            t = "Not Urgent";
        }
        return this.title + ", " + this.assignedTo
        + ", " + this.timeToComplete + ", " + s
        + ", " + t + ", " + this.status;
    }

}


/**
 * Class for todoist.
 */
class Todoist {
    /**
     * { var_description }.
     */
    private List<Task> todoitems;
    /**
     * Constructs the object.
     */
    Todoist() {
        todoitems = new List<Task>();
    }

    /**
     * Adds a task.
     *
     * @param      task  The task
     */
    public void addTask(final Task task) {
        todoitems.add(task);
    }

    /**
     * Gets all tasks.
     *
     * @param      task  The task
     *
     * @return     All tasks.
     */
    public List<Task> getAllTasks(final Task task) {
        List<Task> tasks = new List<Task>();
        for (int i = 0; i < todoitems.size(); i++) {
            if (todoitems.get(i).equals(task)) {
                tasks.add(todoitems.get(i));
            }
        }
        return tasks;
    }

    /**
     * Gets the next task.
     *
     * @param      assignedTo  The assigned to
     *
     * @return     The next task.
     */
    public Task getNextTask(final String assignedTo) {
        Task task = new Task(assignedTo, "todo");
        List<Task> tasks = getAllTasks(task);

        for (int i = 0; i < tasks.size(); i++) {
            if (tasks.get(i).getImportant() && !tasks.get(i).getUrgent()) {
                return tasks.get(i);
            }
        }
        return null;
    }

    /**
     * { function_description }.
     *
     * @return     { description_of_the_return_value }
     */
    public int totalTime4Completion() {
        int totalTime = 0;
        for (int i = 0; i < todoitems.size(); i++) {
            if (todoitems.get(i).getStatus().equals("todo")) {
                totalTime += todoitems.get(i).getTime();
            }
        }
        return totalTime;
    }

    /**
     * Gets the next task.
     *
     * @param      assignedTo  The assigned to
     * @param      n           { parameter_description }
     *
     * @return     The next task.
     */
    public Task[] getNextTask(final String assignedTo, final int n) {
        Task[] tasksNext = new Task[n];
        List<Task> tasks = getAllTasks(new Task(assignedTo, "todo"));
        for (int i = 0; i < n; i++) {
            if (tasks.get(i) == null) {
                tasksNext[i] = null;
            } else {
                tasksNext[i] = tasks.get(i);
            }
        }
        return tasksNext;
    }

    /**
     * Returns a string representation of the object.
     *
     * @return     String representation of the object.
     */
    public String toString() {
        String s = "";
        int i = 0;
        for (i = 0; i < todoitems.size() - 1; i++) {
            s += todoitems.get(i) + "\n";
        }
        s += todoitems.get(i);
        return s;
    }

}


/**
 * Class for todoist main.
 */
public final class TodoistMain {

    /**
     * Constructs the object.
     */
    private TodoistMain() {

    }
    /**
     * Starts a test.
     */
    public static void startTest() {
        Todoist todo = new Todoist();
        Scanner s = new Scanner(System.in);
        while (s.hasNext()) {
            String[] tokens = s.nextLine().split(",");
            switch (tokens[0]) {
                case "task":
                    testTask(tokens);
                break;
                case "add-task":
                    testAddTask(todo, tokens);
                break;
                case "print-todoist":
                    System.out.println(todo);
                break;
                case "get-next":
                    System.out.println(todo.getNextTask(tokens[1]));
                break;
                case "get-next-n":
                    int n = Integer.parseInt(tokens[2]);
                    Task[] tasks = todo.getNextTask(tokens[1], n);
                    System.out.println(Arrays.deepToString(tasks));
                break;
                case "total-time":
                    System.out.println(todo.totalTime4Completion());
                break;
                default:
                break;
            }
        }
    }

    /**
     * method to test add task.
     *
     * @param      todo    The todo
     * @param      tokens  The tokens
     */
    public static void testAddTask(final Todoist todo, final String[] tokens) {
        try {
            todo.addTask(createTask(tokens));
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

    /**
     * method to test the creation of task object.
     *
     * @param      tokens  The tokens
     */
    public static void testTask(final String[] tokens) {
        try {
            System.out.println(createTask(tokens));
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

    /**
     * Creates a task object.
     *
     * @param      tokens     The tokens
     *
     * @return     Task object
     *
     * @throws     Exception  if task inputs are invalid
     */
    public static Task createTask(final String[] tokens) throws Exception {
        String title = tokens[1];
        String assignedTo = tokens[2];
        int timeToComplete = Integer.parseInt(tokens[2 + 1]);
        boolean important = tokens[2 + 2].equals("y");
        boolean urgent = tokens[2 + 2 + 1].equals("y");
        String status = tokens[2 + 2 + 2];
        return new Task(
            title, assignedTo, timeToComplete, important, urgent, status);
    }

    /**
     * main method.
     *
     * @param      args  The command line arguments
     */
    public static void main(final String[] args) {
        startTest();
    }
}
