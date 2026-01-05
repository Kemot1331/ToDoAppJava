package domain;

public class Task {
    private Long id;
    private String name;
    private Status status;

    public Task(Long id, String name, Status status){
        this.id = id;
        this.name = name;
        this.status = status;
    }
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
    public String toString(){
        return "[" + status + "] " + name;
    }
    public Long getId() {
        return id;
    }
}
