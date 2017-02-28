import java.util.ArrayList;
import java.util.Hashtable;

/**
* <h1>Indexing</h1>
* Builds an inverted index, with an entry for each word in the 
* vocabulary. Implemented using a hash table.
* 
* Weighting uses the tf-idf weighting scheme where
* w_ij = tf_ij x idf_i.
* Each query will be used to produce a ranked list of documents,
* starting with the most similar to the query with the least similar.
* For the query terms, we can use a modified tf-idf weighting scheme.
* w_iq = (0.5 + 0.5 tf_iq)*idf_i
* 
* <h1>Input/output</h1>
* Inputs: Tokens obtained from the preprocessing module.
* Outputs: An inverted index for fast access.
* 
* @author	Tejan Chinnakonda
* @version	0.1
* @since 	2017-02-27
*/ 

/* 
* 	 ===========================	
* 	|   Index Terms   	|   df  | 
* 	 ===========================         -----------------------
* 	|		game		|	3	|	---> |D_7,4| D_i,tfi |     |
* 	 ---------------------------		 -----------------------
* 	|		great		| 	2	|  	---> |D_1,3|         |
* 	 ---------------------------         -----------------
* 	|  	   ........  	|		|
* 	|      ........  	|		|
* 	|      ........  	|		|
* 	 ---------------------------		 ------------------------------
* 	|		storm		|	4	|	---> |D_2,4|		 |	 	|	  |
* 	 ---------------------------		 ------------------------------
* 	|		system		|	1	|	---> |D_5,2|
* 	 ---------------------------		 -------
*/

public class Indexing {
	
	private Hashtable				invertedIndexList;
	
	private ArrayList<String>		documentList;

	public Indexing(ArrayList<String> termList, ArrayList<String> documentList) {
		
		this.documentList = documentList;
		
		invertedIndexList = new Hashtable<>(termList.size());
		
		
		
		//invertedIndexList.put(key, value);
		
	}
	
}
