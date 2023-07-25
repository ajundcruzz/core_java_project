package in.arulajun.fitness.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.HashSet;
import java.util.Set;

import in.arulajun.fitness.interfaces.UserInterface;
import in.arulajun.fitness.model.User;
import util.ConnectionUtil;

public class UserDAO implements UserInterface {
	@Override
	public Set<User> findAll() throws RuntimeException {

		Connection con = null;
		PreparedStatement ps = null;
		ResultSet rs = null;

		Set<User> userList = new HashSet<>();

		try {
			String query = "SELECT * FROM users WHERE is_active = 1";
			con = ConnectionUtil.getConnection();
			ps = con.prepareStatement(query);
			rs = ps.executeQuery();

			while (rs.next()) {
				User user = new User();
				user.setId(rs.getInt("id"));
				user.setFirstName(rs.getString("first_name"));
				user.setLastName(rs.getString("last_name"));
				user.setEmail(rs.getString("email"));
				user.setActive(rs.getBoolean("is_active"));
				user.setEmail(rs.getString("password"));

				userList.add(user);
			}

		} catch (SQLException e) {
			System.out.print(e.getMessage());
			throw new RuntimeException();
		} finally {
			ConnectionUtil.close(con, ps, rs);
		}
		return userList;
	}

	@Override
	public User findById(int userId) {
		Connection con = null;
		PreparedStatement ps = null;
		User user = null;
		ResultSet rs = null;

		try {
			String query = "SELECT * FROM users WHERE is_active = 1 AND id = ?";
			con = ConnectionUtil.getConnection();
			ps = con.prepareStatement(query);

			ps.setInt(1, userId);

			rs = ps.executeQuery();

			if (rs.next()) {
				user = new User();
				user.setId(rs.getInt("id"));
				user.setFirstName(rs.getString("first_name"));
				user.setLastName(rs.getString("last_name"));
				user.setEmail(rs.getString("email"));
				user.setActive(rs.getBoolean("is_active"));
				user.setEmail(rs.getString("password"));
			}

		} catch (SQLException e) {
			System.out.print(e.getMessage());
			throw new RuntimeException();
		} finally {
			ConnectionUtil.close(con, ps, rs);
		}
		return user;
	}

	@Override
	public void update(User updatedUser) {
		Set<User> userList = UserList.listOfUsers;
		for (User user : userList) {
			if (user.getId() == updatedUser.getId()) {
				user.setFirstName(updatedUser.getFirstName());
				user.setLastName(updatedUser.getLastName());
				user.setPassword(updatedUser.getPassword());

				break;
			}
		}

	}

	@Override
	public void delete(int userId) {
		Set<User> userList = UserList.listOfUsers;
		for (User user : userList) {
			if (user == null) {
				continue;
			}
			if (user.getId() == userId) {
				user.setActive(false);
				break;
			}
		}
	}

	@Override
	public void create(User newUser) throws RuntimeException {
		Connection con = null;
		PreparedStatement ps = null;
		User user = null;
		ResultSet rs = null;

		try {
			String query = "INSERT INTO users (first_name, last_name, email, password) VALUES (?,?,?,?)";
			con = ConnectionUtil.getConnection();
			ps = con.prepareStatement(query);

				ps.setString(1, newUser.getFirstName());
				ps.setString(2, newUser.getLastName());
				ps.setString(3, newUser.getEmail());
				ps.setString(4, newUser.getPassword());
				ps.executeUpdate();
				
				System.out.print("User has been successfully created");

		}catch(SQLException e)
	{
		System.out.print(e.getMessage());
		throw new RuntimeException();
	}finally
	{
		ConnectionUtil.close(con, ps);
	}
}

}