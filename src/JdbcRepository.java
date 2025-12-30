import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class JdbcRepository implements TaskRepository{

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
    public List<Task> findAll() throws SQLException {
        String sql = "SELECT name, status FROM task";
        List<Task> tasks = new ArrayList<>();

        try(Connection conn = DatabaseConnection.getConnection();
            PreparedStatement stmt = conn.prepareStatement(sql);
            ResultSet rs = stmt.executeQuery()
        ){
            while(rs.next()){
                tasks.add(
                        new Task(
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
    public void updateStatus(Long id, Status status) {
        String sql = "UPDATE task SET status = ? WHERE id = ?";

        try(Connection conn = DatabaseConnection.getConnection();
            PreparedStatement stmt = conn.prepareStatement(sql)
        ){
            stmt.setString(1, status.name());
            stmt.setLong(2, id);
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
