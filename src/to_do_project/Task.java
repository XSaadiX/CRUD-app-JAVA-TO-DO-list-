
package to_do_project;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Scanner;

import to_do_project.Date;

public class Task {
    private static int nextId = 1;
    private String title;
    private String description;
    private int id;
    private boolean status;

    Date dateClass = new Date();
    ArrayList<Task> tasksTitle = new ArrayList<Task>();

    public Task(String title, String description, Date date) {
        this.title = title;
        this.description = description;
        this.status = false;
        this.id = nextId++;
        this.dateClass = date;
    }

    public Task() {

    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setDate(Date date) {
        this.dateClass = date;
    }



    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public boolean getStatus() {
        return status;
    }

    public void setStatus(boolean status) {
        this.status = status;
    }

    public Date addDate() {
        Date date = new Date();
        Scanner in = new Scanner(System.in);
        System.out.println("Enter task day");
        int day = in.nextInt();
        date.setDay(day);

        System.out.println("Enter task month");
        int month = in.nextInt();
        date.setMonth(month);

        System.out.println("Enter task year");
        int year = in.nextInt();
        date.setYear(year);

        String dueDate = day + "/" + month + "/" + year;

        System.out.println(date.getMonth());
        return date;
    }

    public void addNewTask() {
        Scanner in = new Scanner(System.in);

        System.out.println("Add title");
        String title = in.next();

        System.out.println("Add description");
        String description = in.next();

        System.out.println("Add date");
        Date dt = addDate();

        Task newTask = new Task(title, description, dt);
        tasksTitle.add(newTask);
        System.out.println("Task added successfully");
    }

    public void readTheTasks() {
        for (Task tt : tasksTitle) {
            if (tt.getStatus() == false) {
                System.out.println("id  " + "    " + "title  " + "    " + "description " + "    " + "Date" + "         " + "Status");

                System.out.println(" " + (tasksTitle.indexOf(tt) + 1) + "       " + tt.getTitle() + "        " + tt.getDescription() + "           " + tt.dateClass.getDate() + "     " + "in progress");

                System.out.println("------------------------------");

            } else {
                System.out.println("id  " + "    " + "title  " + "    " + "description " + "    " + "Date" + "         " + "Status");

                System.out.println(" " + (tasksTitle.indexOf(tt) + 1) + "       " + tt.getTitle() + "        " + tt.getDescription() + "           " + tt.dateClass.getDate() + "     " + " Completed");
                System.out.println("------------------------------");
            }

        }
    }

    public Task findTask(int id) {
        for (Task task : tasksTitle) {
            if (task.getId() == id) {
                return task;
            }
        }
        return null;
    }

    public void edit() {
        Scanner input = new Scanner(System.in);
        System.out.println("Enter Task ID");
        int id = input.nextInt();
        Task task = findTask(id);
        if (task == null) {
            System.out.println("Task not found");
            return;
        }

        System.out.println("Enter Task name ");
        String title = input.next();
        task.setTitle(title);

        System.out.println("Enter Task description ");
        String description = input.next();
        task.setDescription(description);
        Date date = addDate();

        task.setDate(date);

        System.out.println("Task edited successfully");
    }

    public void markTaskAsCompleted() {
        Scanner input = new Scanner(System.in);
        System.out.println("Enter Task ID");
        int id = input.nextInt();
        Task task = findTask(id);
        if (task == null) {
            System.out.println("Task not found");
            return;
        }
        task.setStatus(true);
        System.out.println("Task completed");
    }

    public void removeTask() {
        Scanner input = new Scanner(System.in);
        System.out.println("Enter Task ID");
        int id = input.nextInt();
        Task task = findTask(id);
        if (task == null) {
            System.out.println("Task not found");
            return;
        }
        this.tasksTitle.remove(task);
        System.out.println("Removed successfully");

        for (int i = 0; i < tasksTitle.size(); i++) {
            Task remainingTask = tasksTitle.get(i);
            remainingTask.setId(i + 1);
        }
    }

    public void sortTasksByDate() {
        Collections.sort(tasksTitle, new Comparator<Task>() {
            public int compare(Task task1, Task task2) {
                return task1.dateClass.compareTo(task2.dateClass);
            }
        });
    }
}

