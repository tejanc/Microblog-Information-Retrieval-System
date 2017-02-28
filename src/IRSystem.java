public class IRSystem{

	public static void main(String[] args) {
		
		String file = "C:\\Users\\Tejan\\Dropbox\\workspace\\Microblog information retrieval system\\src\\Trec_microblog11.txt";
		
		drawTitle();
		                                                            
		System.out.println();
	
		long start,end;
		double result;
		
		
		
		// Test Preprocessing
		
		start = System.currentTimeMillis();
		
		Preprocessing p = new Preprocessing(file);
			
		end = System.currentTimeMillis();
		
		result = (double)(end-start)/1000;
		
		System.out.printf("Results preprocessing: \t%.2fs\n", result);
		
		
		
		// Test Indexing
		
		start = System.currentTimeMillis();
		
		Indexing i = new Indexing(p.getIndexTermsList(), p.getDocumentList());
		
		end = System.currentTimeMillis();
		
		result = (double)(end-start)/1000;
		
		System.out.printf("Results indexing: \t%.2fs\n", result);
		
		
	}
	
	private static void drawTitle() {
		
		System.out.println("  _____ _____     _______     _______ _______ ______ __  __ ");
		System.out.println(" |_   _|  __ \\   / ____\\ \\   / / ____|__   __|  ____|  \\/  |");
		System.out.println("   | | | |__) | | (___  \\ \\_/ / (___    | |  | |__  | \\  / |");
		System.out.println("   | | |  _  /   \\___ \\  \\   / \\___ \\   | |  |  __| | |\\/| |");
		System.out.println("  _| |_| | \\ \\   ____) |  | |  ____) |  | |  | |____| |  | |");
		System.out.println(" |_____|_|  \\_\\ |_____/   |_| |_____/   |_|  |______|_|  |_|");
		
	}
	
}


