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
	
	
	public static String convToString (Scanner input) {
		String allLines = "";
		while (input.hasNextLine()) {
			String line = input.nextLine();
			allLines += line + "\n";
			}
		return allLines;
	}
	
	public static String checkBraces(String file) {
		
		int numOpened = 0;

		for (int i = 0; i < file.length(); i++) {
			if (file.charAt(i) == '{') 
				numOpened++;

			if (file.charAt(i) == '}') 
				numOpened--;
			
			if (numOpened < 0) 				
				break;	
		}
		
		if (numOpened == 0)
			return "Braces Balanced";
		else
			return "Braces not Balanced";
		
	}
	
	public static String isEqual(Path file1, Path file2) throws IOException {
		
		byte[] f1 = Files.readAllBytes(file1);
		byte[] f2 = Files.readAllBytes(file2);
		if (Arrays.equals(f1, f2))
			return "Files are identical";
		else
			return "Files are not identical";
	}
	
	public static ArrayList<String> pullPoS(String f) {
		
		ArrayList<String> pos = new ArrayList<String>();
		
		for (int i = 0; i < f.length(); i++) {
			if (f.charAt(i) == '<') {
				String a = f.substring(i, (f.indexOf(">", i) + 1));
				pos.add(a);
			}	
		}
		
		return pos;	
	}
	
	public static ArrayList<String> getArray (ArrayList<String> partsOfSpeech) {
		
		ArrayList<String> words = new ArrayList<String>();
		Scanner input = new Scanner(System.in);
		for (int i = 0; i < partsOfSpeech.size(); i++ ) {
			
			System.out.println("Please provide a(n)" + partsOfSpeech.get(i));
			words.add(input.nextLine());
			
		}
		
		return words;
	}

	
	public static String fillStory (ArrayList<String> words, String story) {
		
		String filledStory = "";
		ArrayList<String> storySections = new ArrayList<String>();
		int a = 0;
		for (int i = 0; i < story.length(); i++) {
			
			if (story.charAt(i) == '<') {
				storySections.add(story.substring(a, i));
				a = story.indexOf(">", i) + 1;
			}
			else if (i == story.length() - 1) 
				storySections.add(story.substring(a, i));
			
		}
		
		if (storySections.size() > words.size()) {
			for (int j = 0; j < storySections.size() - 1; j++) {
				if (words.get(j) != null && words.get(j) != "")
					filledStory += storySections.get(j) + words.get(j);
				else
					filledStory += storySections.get(j) + "<missing word>";
			}
			filledStory += storySections.get(storySections.size() - 1);
		}
		else if (storySections.size() < words.size()) {
			for (int j = 0; j < words.size() - 1; j++) {
				if (words.get(j) != null)
					filledStory += storySections.get(j) + words.get(j);
				else
					filledStory += storySections.get(j) + "<missing word>";
			}
			filledStory += words.get(words.size() - 1);
		}
		
		return filledStory;
		
		
	} 
	
	public static void writeJava(PrintWriter output, String brace, String equal, String story) {
		
		output.println(brace);
		output.println("");
		output.println(equal);
		output.println("");
		output.println(story);
	}

	
 	public static void main(String args[]) throws IOException {
		
 		if (args.length < 2) {
			System.out.println("You did not provide enough files to use");
			System.exit(1);
		}
 			
		
		PrintWriter out = makeWriter("output.txt");
		
		Scanner in = openFile(args[2]);
		if (in == null) System.exit(1);
		String toOutputA = (checkBraces(convToString(in)));
		Path file1 = Paths.get(args[2]);
		Path file2 = Paths.get(args[3]);
		String toOutputB = (isEqual(file1, file2));
		
		Scanner in2 = openFile(args[3]);
		if (in2 == null) System.exit(1);
		String storyPos = convToString(in2);
		ArrayList<String> partsOfSpeech = pullPoS(storyPos);

		ArrayList<String> userWords = getArray(partsOfSpeech);

		String toOutputC = (fillStory(userWords, storyPos));
		
		writeJava(out, toOutputA, toOutputB, toOutputC);
		in.close();
		out.close();
	}
	
}
