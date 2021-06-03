import java.io.*;
import java.sql.Blob;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.sql.rowset.serial.SerialBlob;

public class StoreObject {
	Connection connection;
	PreparedStatement preparedStatement;
	ByteArrayOutputStream bos;
	ObjectOutputStream out;
	ObjectInputStream in;
	ResultSet rs;
	TestSerializableObject sentObject;
	TestSerializableObject receivedObject;
	public StoreObject() {
		sentObject = new TestSerializableObject("Dean", 1234567);
		try {
			connection = DriverManager.getConnection("jdbc:sqlite:javabook.db");
			bos = new ByteArrayOutputStream();
			System.out.println(bos);//blank pointer
			out = new ObjectOutputStream(bos);   
			System.out.println(out+  "   " + bos);			
			out.writeObject(sentObject);
			System.out.println(out+  "   " + bos);
			out.flush();			
			preparedStatement = connection.prepareStatement("INSERT INTO objectstore VALUES (?, ?, ?)");
			preparedStatement.setInt(1, 125);
			preparedStatement.setBytes(2, bos.toByteArray());
			preparedStatement.setLong(3, TestSerializableObject.serialVersionUID);
			preparedStatement.execute();		  
			preparedStatement = connection.prepareStatement("SELECT objectdata FROM objectstore WHERE id = ?");
			preparedStatement.setInt(1, 125);			
			rs = preparedStatement.executeQuery();
		//	rs.next();
			if (rs.getBytes(1) != null) {
				in = new ObjectInputStream(new ByteArrayInputStream(rs.getBytes(1)));
			}
			receivedObject = (TestSerializableObject) in.readObject();
			System.out.println("receivedObject is: " + receivedObject);
			preparedStatement.close();
			rs.close();	
		} catch (IOException | SQLException | ClassNotFoundException ex) {
			ex.printStackTrace();
		}
	}
	public static void main(String[] args) {
		new StoreObject();
	}
}