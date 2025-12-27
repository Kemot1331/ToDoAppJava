import java.util.Scanner;

public class ConsoleUI {
    private final Scanner scanner;


    public ConsoleUI(Scanner scanner) {
        this.scanner = scanner;
    }
    public String showMenuAndGetChoice(Scanner scanner){
        System.out.println("TODO app java");
        System.out.println("1.Add task");
        System.out.println("2.List of tasks");
        System.out.println("3.Delete task");
        System.out.println("4.Exit the program");
        return scanner.nextLine();

    }
    public String getTaskName(Scanner scanner){
        System.out.println("Type the task name: ");
        return scanner.nextLine();
    }
    public int getTaskIndex(Scanner scanner){
        int choice;
        System.out.println("Type the task's number to delete");
        choice = scanner.nextInt();
        scanner.nextLine();
        return choice;
    }
    public Status getStatusFromUser(Scanner scanner){
        Status[] status = Status.values();
        int choice;

        do {
            System.out.println("Select the task status");
            for (int i = 0; i < status.length; i++) {
                System.out.println((i + 1) + ". " + status[i]);
            }
            choice = scanner.nextInt();
            scanner.nextLine();
        } while (choice < 1 || choice > status.length);
        return status[choice - 1];
    }
}
