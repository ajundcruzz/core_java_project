package in.arulajun.fitness.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.HashSet;
import java.util.Set;

import in.arulajun.fitness.interfaces.TaskInterface;
import in.arulajun.fitness.model.Task;
import in.arulajun.fitness.model.User;
import in.arulajun.fitness.util.ConnectionUtil;

public class TaskDAO implements TaskInterface{

	@Override
	public Set<Task> findAll() throws RuntimeException {

		Connection con = null;
		PreparedStatement ps = null;
		ResultSet rs = null;

		Set<Task> taskList = new HashSet<>();

		try {
			String query = "SELECT * FROM tasks WHERE is_active = 1";
			con = ConnectionUtil.getConnection();
			ps = con.prepareStatement(query);
			rs = ps.executeQuery();

			while (rs.next()) {
				Task task = new Task();
				task.setId(rs.getInt("id"));
				task.setName("name");
				SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
				String dueDateStr = dateFormat.format(rs.getTimestamp("due_date"));
				task.setDueDate(dueDateStr);
				task.setActive(rs.getBoolean("is_active"));
				taskList.add(task);
			}

		} catch (SQLException e) {
			System.out.print(e.getMessage());
			throw new RuntimeException();
		} finally {
			ConnectionUtil.close(con, ps, rs);
		}
		return taskList;
	}
	
	@Override
	public Task findById(int taskId) {
		Connection conn = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		Task task = null;
		try {
			String query = "SELECT * FROM tasks WHERE is_active = 1 AND id = ?";
			conn = ConnectionUtil.getConnection();
			ps = conn.prepareStatement(query);
			ps.setInt(1, taskId);
			rs = ps.executeQuery();
			if (rs.next()) {
				task = new Task();
				task.setId(rs.getInt("id"));
				task.setName(rs.getString("name"));
				SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
				String dueDateStr = dateFormat.format(rs.getTimestamp("due_date"));
				task.setDueDate(dueDateStr);
				task.setActive(rs.getBoolean("is_active"));
			}
		} catch (SQLException e) {
			e.printStackTrace();
			System.out.println(e.getMessage());
			throw new RuntimeException();
		} finally {
			ConnectionUtil.close(conn, ps, rs);
		}
		return task;
	}
	
	@Override
	public void create(Task newTask) {
		    Connection conn = null;
		    PreparedStatement ps = null;
		    try {
		        String query = "INSERT INTO tasks (name, due_date) VALUES (?,?)";
		        conn = ConnectionUtil.getConnection();
		        ps = conn.prepareStatement(query);
		        ps.setString(1, newTask.getName());
		        ps.setString(2, newTask.getDueDate());
		        ps.executeUpdate();
		        System.out.println("User has been created successfully");
		      
		    } catch (SQLException e) {
		        e.printStackTrace();
		        System.out.println(e.getMessage());
		        throw new RuntimeException(e);
		    } finally {
		        ConnectionUtil.close(conn, ps);
		    }
	}
	
	@Override
	public void update(int id, Task updateTask) {
		 Connection conn = null;
		    PreparedStatement ps = null;
		    try {
		        String query = "UPDATE tasks SET name = ?, due_date = ? WHERE is_active = 1 AND id = ?" ;
		        conn = ConnectionUtil.getConnection();
		        ps = conn.prepareStatement(query);
		        ps.setString(1, updateTask.getName());
		        ps.setString(2, updateTask.getDueDate());
		        ps.setInt(3, id);
		        ps.executeUpdate();
		        System.out.println("Task has been updated successfully");
		    } catch (SQLException e) {
		        e.printStackTrace();
		        System.out.println(e.getMessage());
		        throw new RuntimeException(e);
		    } finally {
		        ConnectionUtil.close(conn, ps, null);
		    }
	}

	public void delete(int TaskId) {
		Connection con = null;
		PreparedStatement ps = null;
		try {
			String query = "UPDATE tasks SET is_active = false WHERE is_active = 1 AND id = ?";
			
			con = ConnectionUtil.getConnection();
			ps = con.prepareStatement(query);
			ps.setInt(1, TaskId);
			
			ps.executeUpdate();
			System.out.println("Task has been successfullly deleted.");
		}catch(SQLException e) {
			e.printStackTrace();
			System.out.println(e.getMessage());
			throw new RuntimeException(e);
		}finally {
			ConnectionUtil.close(con, ps);
		}
	}

}
