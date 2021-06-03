import java.sql.*;
public class TestDatabaseMetaData {
	Connection connection;
	DatabaseMetaData dbMetaData;	
	public TestDatabaseMetaData() {
		try {
			connection = DriverManager.getConnection("jdbc:sqlite:javabook.db");
			System.out.println("Database connected");
			dbMetaData = connection.getMetaData();
			System.out.println("database URL: " + dbMetaData.getURL());
			System.out.println("database username: " + dbMetaData.getUserName());
			System.out.println("database product name: " + dbMetaData.getDatabaseProductName());
			System.out.println("database product version: " + dbMetaData.getDatabaseProductVersion());
			System.out.println("JDBC driver name: " + dbMetaData.getDriverName());
			System.out.println("JDBC driver version: " + dbMetaData.getDriverVersion());
			System.out.println("JDBC driver major version: " + dbMetaData.getDriverMajorVersion());
			System.out.println("JDBC driver minor version: " + dbMetaData.getDriverMinorVersion());
			System.out.println("Max number of connections: " + dbMetaData.getMaxConnections());
			System.out.println("MaxTableNameLength: " + dbMetaData.getMaxTableNameLength());
			System.out.println("MaxColumnsInTable: " + dbMetaData.getMaxColumnsInTable());
			connection.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}	
	public static void main(String[] args) {
		new TestDatabaseMetaData();
	}
}