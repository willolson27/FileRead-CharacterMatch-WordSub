package filereading;
import java.io.*;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Arrays;
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
	
	public static String isEqual(Path file1, Path file2) throws IOException {
		
		byte[] f1 = Files.readAllBytes(file1);
		byte[] f2 = Files.readAllBytes(file2);
		if (Arrays.equals(f1, f2))
			return "Files are identical";
		else
			return "Files are not identical";
	}
	
	public ArrayList<String> getArray (String f) {
		
		ArrayList<String> words = new ArrayList<String>();
		
		
		return words;
	}
	
	public static void writeJava(PrintWriter output, String a) {
		
		output.println(a);
	}
	
	public static void fillStory (ArrayList<String> words) {
		
		
	} 

	
 	public static void main(String args[]) throws IOException {
		
 		if (args.length < 2) {
			System.out.println("You did not provide a file to print");
			System.exit(1);
		}
		Scanner in = openFile(args[2]);
		if (in == null) System.exit(1);
	//	Scanner file = openFile(args[3]);
	//	String a = convToString(in);
	//	System.out.println(a);
		PrintWriter out = makeWriter(args[3]);
		//printToFile(in, out);
		Path file1 = Paths.get(args[2]);
		Path file2 = Paths.get(args[4]);
		String toOutputB = (isEqual(file1, file2));
		writeJava(out, toOutputB);
		in.close();
		out.close();
	}
	
}
