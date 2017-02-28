import java.io.*;
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
	
	private BufferedReader in;
		
	private String stopWordFile = "C:\\Users\\Tejan\\Dropbox\\workspace\\Microblog information retrieval system\\src\\StopWords.txt";
	
	private ArrayList<String> stopWordList;
	
	private ArrayList<String> documentList;
	
	private ArrayList<String> indexTerms;
	
	private StringTokenizer tokenizer;
	
	
	
	public Preprocessing(String file) { // file is a list of tweet IDs and tweet messages
		
		// Populate stop word list
		stopWordList = new ArrayList<String>();
		openFile(stopWordFile);
		populateStopWordList();
		closeFile();
		
		// Populate documentList
		documentList = new ArrayList<String>();		
		try {
			in = new BufferedReader(new FileReader(file));
			String document;
			while((document = in.readLine()) != null) {
				documentList.add(document);
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		// Remove stop words, numbers, punctuation tokens
		// Builds the initial index terms list
		indexTerms = new ArrayList<String>();
		for (int i = 0; i < documentList.size(); i++) {
			String document = documentList.get(i);
			for (int j = 0; j < stopWordList.size(); j++) {
				String stopWord = stopWordList.get(j);
				if (document.contains(stopWord)) {
					document = document.replaceAll("\\s+"+stopWord+"\\s+"," ");
				}
			}
			String delimiters = "…1234567890\t!\"#$%&'()*+,-./:;<=>?@[\\]^_`{|}~ ";
			tokenizer = new StringTokenizer(document,delimiters);
			while (tokenizer.hasMoreTokens()) {
				String token = tokenizer.nextToken();
				indexTerms.add(token);	
			}
		}
		
		// Second pass... Build the final index terms list
		for (int i = 0; i < indexTerms.size(); i++) {
			for(int j = 0; j < stopWordList.size(); j++) {
				String stopWord = stopWordList.get(j);
				if (indexTerms.get(i).toLowerCase().equals(stopWord)) {
					indexTerms.remove(i);
					i--; // moves ArrayList index back by one since we removed an element.
				}
			}
		}
		
	}
	
	public ArrayList<String> getIndexTermsList() {
		return this.indexTerms;
	}
	
	public ArrayList<String> getDocumentList() {
		return this.documentList;
	}

	
	private boolean isNumeric(String str) {
		return str.matches("-?\\d+(\\.\\d+)?"); // matches a number with optional '-' and decimal.
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
