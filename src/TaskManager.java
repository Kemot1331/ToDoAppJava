import java.util.ArrayList;
import java.util.Scanner;

public class TaskManager {
    private ArrayList<Task> tasks = new ArrayList<Task>();

    public void addTask(String name, Status status){
        tasks.add(new Task(name, status));
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
    public boolean isEmpty(){
        return tasks.isEmpty();
    }
    public int size(){
        return tasks.size();
    }
    public void showTasks(){
        if(isEmpty()){
            System.out.println("The list is empty");
        }
        int i = 1;
        for (Task task : tasks) {
            System.out.println(i + ". " + task.toString());
        }
    }
    public void removeTask(int index){
        if(index >= 1 && index <= size()){
            tasks.remove(index - 1);
        }
        else{
            System.out.println("Incorrect number!");
        }
    }
}
