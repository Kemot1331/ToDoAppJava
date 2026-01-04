package repository;

import domain.Status;
import domain.Task;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class JdbcRepository implements TaskRepository {

    @Override
    public void addTask(Task task) throws SQLException {
        String sql = "INSERT INTO task(name, status) VALUES (?, ?)";

        try(Connection conn = DatabaseConnection.getConnection();
            PreparedStatement stmt = conn.prepareStatement(sql)
        ){
            stmt.setString(1, task.getName());
            stmt.setString(2, task.getStatus().name());
            stmt.executeUpdate();
        }
    }

    @Override
    public List<Task> findAll(){
        String sql = "SELECT * FROM task";
        List<Task> tasks = new ArrayList<>();

        try(Connection conn = DatabaseConnection.getConnection();
            PreparedStatement stmt = conn.prepareStatement(sql);
            ResultSet rs = stmt.executeQuery()
        ){
            while(rs.next()){
                tasks.add(
                    new Task(
                            rs.getLong("id"),
                            rs.getString("name"),
                            Status.valueOf(rs.getString("status"))
                    )
                );
            }
        } catch (Exception e) {
            throw new RuntimeException("DB error", e);
        }
        return tasks;
    }

    @Override
    public void updateTask(Long id, String newName, Status newStatus) {

        String sql = "UPDATE task SET name = ?, status = ? WHERE id = ?";

        try(Connection conn = DatabaseConnection.getConnection();
            PreparedStatement stmt = conn.prepareStatement(sql)
        ){
            stmt.setString(1, newName);
            stmt.setString(2, newStatus.name());
            stmt.setLong(3, id);

            stmt.executeUpdate();
        } catch (SQLException e) {
            throw new RuntimeException("DB error", e);
        }
    }

    @Override
    public void deleteTaskById(Long id) {
        String sql = "DELETE FROM task WHERE id = ?";

        try(Connection conn = DatabaseConnection.getConnection();
            PreparedStatement stmt = conn.prepareStatement(sql)
        ) {
            stmt.setLong(1, id);
            stmt.executeUpdate();
        } catch (SQLException e) {
            throw new RuntimeException("DB error", e);
        }
    }
}
