// Collects sequences of integers representing Morse Code strokes...
// ...and decodes them into English.
// Created by CB Fay on 11.27.2017

import java.util.*;

class MorseListener {
	private Deque<Integer> stream; // A data-structure that will be filled with input from the user...
	// ...and emptied when the input is finished.
	private HashMap<String, String> table = new HashMap<>();
	private boolean listening = false;
	
	// constructor
	// When an object of this class is created, this code block will be executed.
	// It adds key-value pairs to a Hash Table... 
	// ...which relates sequences of morse to the letters they represent
	MorseListener() {
		table.put("12", 	"a");
		table.put("2111", 	"b");
		table.put("2121", 	"c");
		table.put("211", 	"d");
		table.put("1", 		"e");
		table.put("1121", 	"f");
		table.put("221", 	"g");
		table.put("1111",	"h");
		table.put("11", 	"i");
		table.put("1222", 	"j");
		table.put("212", 	"k");
		table.put("1211", 	"l");
		table.put("22",	 	"m");
		table.put("21",	 	"n");
		table.put("222",	"o");
		table.put("1221",	"p");
		table.put("2212",	"q");
		table.put("121",	"r");
		table.put("111-",	"s");
		table.put("2",		"t");
		table.put("112",	"u");
		table.put("1112",	"v");
		table.put("122",	"w");
		table.put("2112",	"x");
		table.put("2122",	"y");
		table.put("2211",	"z");
		table.put("12222",	"1");
		table.put("11222",	"2");
		table.put("11122",	"3");
		table.put("11112",	"4");
		table.put("11111",	"5");
		table.put("21111",	"6");
		table.put("22111",	"7");
		table.put("22211",	"8");
		table.put("22221",	"9");
		table.put("22222",	"0");
	}
	
	// 0 : Wait
	// 1 : Short
	// 2 : Long
	// 3 : Stop
	
	public boolean getListening() {
		return listening;
	}
	
	// enables getInput() and instantiates stream
	public void listen() {
		if (!listening) {
			stream = new LinkedList<>();
			listening = true;
		}
	}

	// call this method for each stroke or wait
	// acceptable values are 0, 1, 2.
	public void getInput(int value) {
		if (listening) {
			stream.add(value);
			System.out.println(value);
		}
	} 
	
	// Empties the stream Deque, and returns a String representation of the data it stored.
	private String toEnglish() {	
		String english = "";
		while (stream.peek() != 3) {
			english += readStreamBlock();
			// System.out.println("English = " + english);
		}
		stream.pop(); // remove the last element (3)
		english += "."; // add a stop
		return english;
	}
	
	// Helper function for toEnglish()
	private String readStreamBlock() {
		if (stream.peek() == 0) { // zero values (waits)
			int zeros = 0;
			
			do { // remove blocks of zeros
				stream.pop();
				zeros++;
			} while ((stream.peek() == 0) && (stream.size() != 0));
			
			if (zeros == 3) // the amount of wait units between letters
				return "";
			if (zeros == 7) // the amount of wait units between words 
				return " "; // insert a space
		}
		
		else { // non-zero values (strokes)
			String block = "";
			
			do {
				block += stream.pop();
			} while (stream.peek() == 1 || stream.peek() == 2);
			return table.get(block);
		}
		
		return ""; // this should never happen
	}
	
	// disables getInput() and decodes the Morse String
	public String stopListen() {
		// System.out.println("STOPLISTEN");
		if (listening)
			stream.add(3);
			stream.add(4);
			listening = false;
			return toEnglish();
	}
	
}
