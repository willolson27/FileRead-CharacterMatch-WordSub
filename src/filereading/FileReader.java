package filereading;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Scanner;

public class FileReader {
	
	
	public static Scanner openFile(String f) {
		
		File file = new File(f);
		Scanner input = null;
		
		try {
			input = new Scanner(file);
		} catch (FileNotFoundException ex ) {
			System.out.println("Part 1: unable to open file" + f);
			return null;
		}
		
		return input;
	}
	
	public static PrintWriter printToFile(String f) {
		
		File file = new File(f);
		PrintWriter out = null;
		
		try {
			out = new PrintWriter(file);
		} catch (FileNotFoundException ex ) {
			System.out.println("Part 2: Unable to open file " + f);
			return null;
		}
		
		return out;
	}
	
	public static String convToString (Scanner input) {
		String allLines = "";
		while (input.hasNextLine()) {
			String line = input.nextLine();
			allLines += line + "\n";
			}
		return allLines;
	}
	
	public boolean isEqual(String a, String b) {
		
		if (a == b)
			return true;
		else
			return false;
	}
	
	public ArrayList<String> getArray (String f) {
		
		ArrayList<String> words = new ArrayList<String>();
		
		
		return words;
	}
	
	public static void fillStory (ArrayList<String> words) {
		
		
	} 

	
 	public static void main(String args[]) {
		
		Scanner in = openFile(args[2]);
		String a = convToString(in);
		System.out.println(a);
		
	}
	
}
