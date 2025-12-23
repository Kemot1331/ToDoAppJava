import java.util.Scanner;

public class App {
    public static void main(String[] args) throws Exception {
        TaskManager taskManager = new TaskManager();
        // ArrayList<String> tasks = new ArrayList<String>();
        Scanner scanner = new Scanner(System.in);
   
        String choice;
        String tempName;
        boolean isRunning = true;

        while(isRunning){
            System.out.println("TODO app java");
            System.out.println("1.Add task");
            System.out.println("2.List of tasks");
            System.out.println("3.Delete task");
            System.out.println("4.Exit the program");

            choice = scanner.nextLine();
            switch (choice) {
                case "1":
                    System.out.println("Type the task name: ");
                    tempName = scanner.nextLine();

                    taskManager.addTask(tempName);
                    tempName = "";
                    break;
                case "2":
                    taskManager.showTasks();
                    break;
                case "3":
                    taskManager.showTasks();

                    System.out.println("Type the task's number to delete");
                    int index = scanner.nextInt();
                    scanner.nextLine();

                    taskManager.removeTask(index);
                    break;
                case "4":
                    isRunning = false;
                    break;
                default:
                    System.out.println("Incorrect number, try again!");
                    break;
            }
        }
        scanner.close();
    }
}
