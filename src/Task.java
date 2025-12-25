public class Task {
    private String name;
    private Status status;

    public Task(String name, Status status){
        this.name = name;
        this.status = status;
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
        return "[" + status + "] " + name;
    }
}
