import java.sql.*;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

import org.sqlite.SQLiteException;

public class PreparedStatementQuery {
	Connection connection;
	PreparedStatement preparedStatement;
	Statement statement;
	ResultSet rs;
	ResultSetMetaData rsmd;	
	public PreparedStatementQuery(){
		try {
			connection = DriverManager.getConnection("jdbc:sqlite:javabook.db");
			connection.setAutoCommit(false);
		//	preparedStatement = connection.prepareStatement( "select * from Student where lastName = ?");		
			preparedStatement = connection.prepareStatement("select firstName, mi, lastName from Student where lastName = ?");
			preparedStatement.setString(1, "Smith");
			rs = preparedStatement.executeQuery();
			rsmd = rs.getMetaData();			
			Set<String> columns = new HashSet<String>();
			for (int i=1;i<=rsmd.getColumnCount();i++) {
				System.out.println("column " + i + ": " +rsmd.getColumnName(i));
				columns.add(rsmd.getColumnName(i));
			}			
			System.out.println("Results:");
			while (rs.next() ) {
				String result = "";
				for (String col : columns) {
					result += rs.getString(col) +"\t";
				}
				System.out.println(result);
			}
			statement= connection.createStatement();			
			try { 
				statement.execute("UPDATE Student SET LastName = 'Smith' WHERE lastName = 'xiaobinggan'");
			} catch (SQLiteException e) {
				connection.rollback();
			}
			connection.commit();
		} catch (SQLException e) {
			e.printStackTrace();
			System.exit(0);
		}
	}	
	public static void main(String[] args) {
		new PreparedStatementQuery();
	}
}