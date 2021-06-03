import java.io.*;
import java.util.List;
import java.util.ArrayList;
public class ListOfNumbers {	
    private List<Integer> list;
    private String inFile;
    private FileReader fr = null;
    private BufferedReader br = null;
    private String linea; 
    public ListOfNumbers () {
        list = new ArrayList<Integer>();
    }
    public ListOfNumbers (String inFile) {
    	this();
    	this.inFile = inFile;	
    }    
    public void readList() {
    	try {
    		fr = new FileReader(this.inFile);  		
    	}catch(FileNotFoundException e) {
    		System.err.println("file not found: " + e.getMessage());
    		System.exit(1);   		
    	}
    	br = new BufferedReader(fr);
    	try {
    		linea = this.br.readLine();
    		while(linea != null){
    			list.add(Integer.parseInt(linea));
    			linea = br.readLine();
    		}
    	}catch(IOException ioe) {
    		System.err.println("IO error closing file: " + ioe.getMessage());
    	}catch(NumberFormatException nfe) {
    		System.err.println("problem parsing data: " + nfe.getMessage());
    	}finally {
    		try {
    			fr.close();
    		}catch(IOException ioe) {
    			System.err.println("IO error closing file: " + ioe.getMessage());
    		}
    	}
    	System.out.println("ArrayList is:" + list.toString());
    	System.out.println("continuing on .....");    	  	
    }    
    public void writeList() {
        PrintWriter out = null;
        try {
            System.out.println("Entering try statement");
            out = new PrintWriter(new FileWriter("outFile.txt"));
            for (int i = 0; i < list.size(); i++)
                out.println("Value at: " + i + " = " + list.get(i));
        } catch (IndexOutOfBoundsException e) {
            System.err.println("Caught IndexOutOfBoundsException: " +
                                 e.getMessage());
        } catch (IOException e) {
            System.err.println("Caught IOException: " + e.getMessage());
        } finally {
            if (out != null) {
                System.out.println("Closing PrintWriter");
                out.close();
            } else {
                System.out.println("PrintWriter not open");
            }
        }
    }    
    public static void cat(String fileName) {
        RandomAccessFile input = null;
        String line = null;
        File file = new File(fileName);
        try {
            input = new RandomAccessFile(file, "r");
            while ((line = input.readLine()) != null) {
                System.out.println(line);
            }
            return;
        }catch(IOException ioe) {
        		System.err.println("IO error reading file: " + ioe.getMessage());
        }finally {
            try{
            	if (input != null) {
                input.close();
            	}
            }catch (IOException ioe) {
            	System.err.println("error writing to file: " + ioe.getMessage());
            	ioe.printStackTrace();
            	System.exit(1);
            }
        }
    }    
    public static void main(String[] args) {
    	ListOfNumbers listOfNumbers = new ListOfNumbers("numberfile.txt");
    	ListOfNumbers.cat("numberfile.txt");
    	listOfNumbers.readList();
    	listOfNumbers.writeList();
    }
}