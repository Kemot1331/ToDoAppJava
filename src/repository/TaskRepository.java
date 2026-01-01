package repository;

import domain.Status;
import domain.Task;

import java.sql.SQLException;
import java.util.List;

public interface TaskRepository {
    void addTask(Task task) throws SQLException;
    List<Task> findAll() throws SQLException;
    void updateStatus(Long id, Status status);

    void deleteTaskById(Long id);
}
