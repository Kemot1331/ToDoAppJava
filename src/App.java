import java.util.Scanner;

public class App {
    public static void main(String[] args) throws Exception {
        TaskManager taskManager = new TaskManager();
        Scanner scanner = new Scanner(System.in);
        ConsoleUI ui = new ConsoleUI(scanner);

        boolean isRunning = true;
        while(isRunning){
            switch (ui.showMenuAndGetChoice(scanner)) {
                case "1":
                    taskManager.addTask(
                            ui.getTaskName(scanner),
                            ui.getStatusFromUser(scanner)
                    );
                    System.out.println("Task added");
                    break;
                case "2":
                    taskManager.showTasks();
                    break;
                case "3":
                    taskManager.showTasks();
                    taskManager.removeTask(ui.getTaskIndex(scanner));
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
