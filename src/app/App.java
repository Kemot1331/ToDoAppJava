package app;

import repository.DatabaseConnection;
import repository.JdbcRepository;
import repository.TaskRepository;
import service.TaskManager;
import ui.ConsoleUI;

import java.util.Scanner;

public class App {
    void main() throws Exception {
        if(!DatabaseConnection.isConnected()) {
            System.out.println("The server is off or other problem corrupted");
            return;
        }
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
                    taskManager.showTasks();
                    taskManager.updateTask(
                            ui.getTaskIndex(scanner),
                            ui.getTaskName(scanner),
                            ui.getStatusFromUser(scanner)
                    );
                    break;
                case "5":
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
