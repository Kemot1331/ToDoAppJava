package repository;

import domain.Status;
import domain.Task;

import java.sql.SQLException;
import java.util.List;

public interface TaskRepository {
    void addTask(Task task) throws SQLException;
    List<Task> findAll() throws SQLException;
    void updateTask(Long id, String newName, Status newStatus);
    void deleteTaskById(Long id);
}
