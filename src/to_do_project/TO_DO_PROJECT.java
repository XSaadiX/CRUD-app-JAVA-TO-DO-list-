
package to_do_project;

import java.util.Scanner;

public class TO_DO_PROJECT {

    public static void main(String[] args) {
        Task taskClass = new Task();
        while (true) {
            Scanner input = new Scanner(System.in);
            System.out.print("Choose:\n1 - Add a new task\n2 - Remove an existing task\n3 - Edit a task\n4 - Mark a task as completed\n5 - List all tasks\n6 - Sort tasks by date\n7 - Exit\n");
            int x = input.nextInt();
            switch (x) {
                case 1:
                    taskClass.addNewTask();
                    break;
                case 2:
                    taskClass.removeTask();
                    break;
                case 3:
                    taskClass.edit();
                    break;
                case 4:
                    taskClass.markTaskAsCompleted();
                    break;
                case 5:
                    taskClass.readTheTasks();
                    break;
                case 6:
                    taskClass.sortTasksByDate();
                    break;
                case 7:
                    input.close();
                    System.exit(0);
                    break;
                default:
                    System.out.println("Invalid input");
            }
        }
    }
}
