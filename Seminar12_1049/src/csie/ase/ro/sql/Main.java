package csie.ase.ro.sql;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class Main {

	public static void main(String[] args) {

		Connection connection = null;

		try {
			// init JDBC class
			Class.forName("org.sqlite.JDBC");

			// open connection
			connection = DriverManager.getConnection("jdbc:sqlite:database.db");

			connection.setAutoCommit(false);

			createTable(connection);
			insertValues(connection);
			selectData(connection);

		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			if (connection != null) {
				try {
					connection.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
		}
	}

	public static void createTable(Connection connection) {
		String sqlDropCommand = "DROP TABLE IF EXISTS cars";
		String sqlCreateCommand = "CREATE TABLE cars(id INT PRIMARY KEY, model TEXT, capacity FLOAT, price LONG)";

		Statement statement;

		try {
			statement = connection.createStatement();
			statement.executeUpdate(sqlDropCommand);
			statement.executeUpdate(sqlCreateCommand);
			statement.close();
			connection.commit();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	public static void insertValues(Connection connection) {
		String sqlInsertCommand = "INSERT INTO cars VALUES(0, 'Skoda', 2.1, 150000)";

		try (Statement statement = connection.createStatement()) {
			statement.executeUpdate(sqlInsertCommand);
			statement.close();
			connection.commit();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	public static void selectData(Connection connection) {
		String sqlSelectCommand = "SELECT * from cars";

		try (Statement statement = connection.createStatement()) {
			ResultSet result = statement.executeQuery(sqlSelectCommand);

			while (result.next()) {
				int id = result.getInt("id");
				System.out.println("ID: " + id);
				String model = result.getString("model");
				System.out.println("Model: " + model);
				float capacity = result.getFloat("capacity");
				System.out.println("Capacity: " + capacity);
				long price = result.getLong("price");
				System.out.println("Price: " + price);
			}

			result.close();
			statement.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

}
