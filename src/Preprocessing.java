import java.io.*;
import java.util.Scanner;
import java.util.*;

/** 
* @author Tejan Chinnakonda
* 
* @description
* Functions for tokenization and stopword removal.
* The index terms will be all the words left after filtering
* punctuation tokens, numbers, stopwords, etc. 
* 
* @input/output
* Inputs: Documents that are read on by one from the collection.
* Outputs: Tokens to be added to the index (vocabulary).
*/
public class Preprocessing {
	
	private Scanner scanner;
	
	private String stopWordFile = "C:\\Users\\Tejan\\Dropbox\\workspace\\Microblog information retrieval system\\src\\StopWords.txt";
	private ArrayList<String> stopWordList;
	
	private String documents; // input
	
	private String indexList; // output
	
	
	public Preprocessing(String file) {
		
		this.documents = file;
		
		// Populate stop word list
		stopWordList = new ArrayList<String>();
		openFile(stopWordFile);
		populateStopWordList();
		closeFile();
		
		// Tokenize the documents that are read
		
		
	}
	
	private void openFile(String file) {
		try {
			scanner = new Scanner(new File(file));
		} 
		catch (Exception e) {
			System.out.println("Could not find file");
		}
	}
	
	private void populateStopWordList() {
		
		while (scanner.hasNext()) {
			String str = scanner.next();
			if (str != null)
				stopWordList.add(str);
		}
		
	}
	
	private void closeFile() {
		scanner.close();
	}
		
	
	
}
