package student;
import java.io.*;
public class ReadStudentFile {
	File file;
	FileInputStream fromFile;
	ObjectInputStream objectFromFile;
	StudentAddress sa;
	public ReadStudentFile(){
		try {
			file = new File("student.dat");
			fromFile = new FileInputStream(file);
			objectFromFile = new ObjectInputStream(fromFile);
			sa = (StudentAddress) objectFromFile.readObject();
			System.out.println("got student address: " + sa.toString());
			while(fromFile.available()>0){
				sa = (StudentAddress) objectFromFile.readObject();
				System.out.println("got student address: " + sa.toString());
			}
		}catch(Exception e){
			System.err.println("Exception: "+e.getMessage());
			e.printStackTrace();
		}
	}
	public static void main(String[] args) {
		new ReadStudentFile();
	}
}