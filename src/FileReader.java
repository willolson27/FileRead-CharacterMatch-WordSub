import java.io.File;
import java.io.FileNotFoundException;
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
		
		Scanner in = openFile(args[0]);
		String a = convToString(in);
		System.out.println(a);
		
	}
	
}