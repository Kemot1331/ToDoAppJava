public class Task {
    private String name;
    private Status status;

    public Task(String name){
        this.name = name;
        this.status = Status.TODO;
    }
    public String getName(){
        return name;
    }
    public Status getStatus(){
        return status;
    }
    public void setStatus(Status status){
        this.status = status;
    }

    public String toString(){
        return "[" + status + "] " + name;1
    }
}
