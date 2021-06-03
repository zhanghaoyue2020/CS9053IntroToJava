import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.sql.Statement;
public class JDBCExample {
	Connection connect;
	Statement statement;
	ResultSet rs;
	ResultSetMetaData rsmd;
	public JDBCExample(){
		try {
			connect = DriverManager.getConnection("jdbc:sqlite:assignment.db");
			statement = connect.createStatement();
			rs = statement.executeQuery("SELECT * FROM People");
			rsmd = rs.getMetaData(); 
			System.out.println(rsmd.getColumnName(1)+"\t"+ rsmd.getColumnName(2)+"\t"+rsmd.getColumnName(3));
			while (rs.next()){
				System.out.println(rs.getString(1)+"\t"+rs.getString(2)+"\t"+rs.getString(3));
			}
			statement.close();
			connect.close(); 
		}catch (SQLException e) { 
			System.out.println(e); 
			e.printStackTrace();
		}
	}
	public static void main(String args[]){
		new JDBCExample ();
	}
}