import java.sql.*;
public class SimpleJdbc {
	Connection connection;
	Statement statement;
	ResultSet resultSet;
	ResultSetMetaData resultSetMetaData;	
	public SimpleJdbc() {
		try {
			connection = DriverManager.getConnection("jdbc:sqlite:javabook.db");
			System.out.println("Database connected");
			statement = connection.createStatement();
			resultSet = statement.executeQuery("select * from Student where lastName = 'Smith'");
			resultSetMetaData = resultSet.getMetaData();
			System.out.println(resultSetMetaData.getColumnName(1) + "\t" + resultSetMetaData.getColumnName(2) + "\t" + resultSetMetaData.getColumnName(3) +'\t' + resultSetMetaData.getColumnName(4));
			while (resultSet.next()) {
				System.out.println(resultSet.getString(1) + "\t" + resultSet.getString(2) + "\t" + resultSet.getString(3) +'\t' + resultSet.getString(4));
			}connection.close();
		} catch (SQLException e) {
			e.printStackTrace();
			System.exit(0);
		}
	}
	public static void main(String[] args){
		//Load the JDBC driver
		//Class.forName("com.mysql.jdbc.Driver");
		//System.out.println("Driver loaded");
		new SimpleJdbc();
	}
}