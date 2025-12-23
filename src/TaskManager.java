import java.util.ArrayList;

public class TaskManager {
    private ArrayList<Task> tasks = new ArrayList<Task>();

    public void addTask(String name){
        tasks.add(new Task(name));
    }
    public boolean isEmpty(){
        return tasks.isEmpty();
    }
    public int size(){
        return tasks.size();
    }
    public void showTasks(){
        if(isEmpty()){
            System.out.println("");
        }
        int i = 1;
        for (Task task : tasks) {
            System.out.println(i + ". "+ task.getName());
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
