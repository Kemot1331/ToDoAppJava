package service;

import domain.Status;
import domain.Task;
import repository.TaskRepository;

import java.sql.SQLException;
import java.util.List;

public class TaskManager {
//    private ArrayList<domain.Task> tasks = new ArrayList<domain.Task>();
    private final TaskRepository repository;

    public TaskManager(TaskRepository repository) {
        this.repository = repository;
    }

    public void addTask(String name, Status status) throws SQLException {
        repository.addTask(new Task(name, status));
    }
    public void showTasks() throws SQLException {
        List<Task> tasks = repository.findAll();

        if(tasks.isEmpty()){
            System.out.println("The list is empty");
        }
        int i = 1;
        for (Task task : tasks) {
            System.out.println(i++ + ". " + task);
        }
    }

    public void updateTask(int choice, String newName, Status newStatus) throws SQLException {
        List<Task> tasks = repository.findAll();

        if(choice < 1 || choice > tasks.size()) {
            System.out.println("Incorrect number");
            return;
        }
        Task selectedTask = tasks.get(choice - 1);

        Long id = selectedTask.getId();
        repository.updateTask(id, newName, newStatus);
        System.out.println("Task updated");
    }

    public void removeTask(int choice) throws SQLException {
        List<Task> tasks = repository.findAll();

        if(choice < 1 || choice > tasks.size()){
            System.out.println("Incorrect number");
            return;
        }
            Task selectedTask = tasks.get(choice - 1);
            Long id = selectedTask.getId();

            repository.deleteTaskById(id);
            System.out.println("domain.Task deleted");
    }
}
