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
	
	public static PrintWriter makeWriter(String f) {
		
		File file = new File(f);
		PrintWriter out = null;
		
		try {
			out = new PrintWriter(file);
		} catch (FileNotFoundException ex ) {
			System.out.println("Cant open file " + f);
			return null;
		}
		
		return out;
	}
	
	public static void printToFile(Scanner input, PrintWriter output) {
		
		while (input.hasNextLine()) {
			String word = input.nextLine();
			
			if (word.length() >= 1 && word.length() <=16) {
			output.println("\t\"" + word + "\",");
			}
		}
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
		
 		if (args.length < 2) {
			System.out.println("You did not provide a file to print");
			System.exit(1);
		}
		Scanner in = openFile(args[2]);
		if (in == null) System.exit(1);
	
	//	String a = convToString(in);
	//	System.out.println(a);
		PrintWriter out = makeWriter(args[3]);
		printToFile(in, out);
		in.close();
		out.close();
	}
	
}
