
import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.Scanner;
//will Olson
public class Console {

	
	//return a scanner
	public static Scanner openWords(String f) {
		
		File file = new File(f);
		Scanner input = null;
		
		try {
			input = new Scanner(file);
		} catch (FileNotFoundException ex ) {
			System.out.println("Cant open file" + f);
			return null;
		}
		
		return input;
	}
	
public static PrintWriter openDictionary(String f) {
		
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
	
	public static void writeJava(Scanner input, PrintWriter output) {
		
		while (input.hasNextLine()) {
			String word = input.nextLine();
			
			if (word.length() >= 1 && word.length() <=16) {
			output.println("\t\"" + word + "\",");
			}
		}
	}
	
	public static void writeJavaHeader(PrintWriter output) {
			output.println("public class RamblecsDictionary\n{");
			output.println("\tprivate String[] words = \n\t{");
	}
	
	public static void writeJavaFooter(PrintWriter output) {
			output.println("\t}");
			output.println("}");
	}
	
	public static void main(String[] args) {
		if (args.length < 2) {
			System.out.println("You did not provide a file to print");
			System.exit(1);
		}
		Scanner in = openWords(args[0]);
		if (in == null) System.exit(1);
		
		PrintWriter out = openDictionary(args[1]);
	//	writeJavaHeader(out);
		writeJava(in, out);
	//	writeJavaFooter(out);
		//out.println(in.nextLine());
		//System.out.println(in.nextLine());
		in.close();
		out.close();
	}
}
