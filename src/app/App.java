package app;

import repository.JdbcRepository;
import repository.TaskRepository;
import service.TaskManager;
import ui.ConsoleUI;

import java.util.Scanner;

public class App {
    public static void main(String[] args) throws Exception {

        TaskRepository taskRepository = new JdbcRepository();
        TaskManager taskManager = new TaskManager(taskRepository);

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
                    System.out.println("domain.Task added");
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
