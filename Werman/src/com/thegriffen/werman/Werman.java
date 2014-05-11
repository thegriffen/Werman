package com.thegriffen.werman;

import java.util.Scanner;

public class Werman {
	
	private static String[][] key = new String[][] {
			{"kkk", "robotics"},
			{"robotics", "nazi people", "nazi", "people"},
			{"griffen", "the master", "the", "master"},
			{"shawn", "jackson"},
			{"girl", "curvy"},
			{"girls", "Bjerg"},
			{"food", "McLovin\'"},
			{"drink", "Pepsi"},
			{"harrison", "dirty casual", "dirty", "casual"},
			{"seth", "flaminaFace"},
			{"connie", "ConMan"}, //TODO: make random
			{"logan", "lady killer", "lady", "killer"},
			{"lydia", "lydiot <3", "lydiot", "<3"},
			{"jackson", "Shawnish"},
			{"dance_mode", "Boom Boom dance dance!", "Boom", "Boom", "dance", "dance!"},
			{"system.exit", "I think not! (never ending recursive loop goes here)", "I", "think", "not!", "(never", "ending", "recursive", "loop", "goes", "here)"},
			{"carly", "Carlo"},
			{"carlo", "Carlos"},
			{"is", "isn\'t"},
			{"er", "ei"},
			{"g", "W"},
			{"b", "Vladimir"},
			{"m", "gurl please", "gurl", "please"},
			{"s", "Lanaster"},
			{"v", "FLAIRBROTHER"},
			{"1", "nullpointerexception42 (there were 41 other ones);", "nullpointerexception42", "(there", "were", "41", "other", "ones);"},
			{"2", "3"},
			{"3", "2"},
			{"5", "80"},
			{"6", "42"},
			{"7", "11"},
			{"69", "439"}
	};

	public static String TranslateToWerman(String s) {
		Scanner scan = new Scanner(s);
		String result = "";
		while(scan.hasNext()) {
			String nextWord = scan.next();
			boolean match = false;
			for(String[] pair : key){
				if(nextWord.equalsIgnoreCase(pair[0])) {
					result += pair[1] + " ";
					match = true;
					break;
				}
				
			}
			if(!match) {
				result += nextWord + " ";
			}
		}
		scan.close();
		return result;
	}
	
	public static String TranslateFromWerman(String s) {
		for(int i = 0; i < key.length / 2; i++) {
		    String[] temp = key[i];
		    key[i] = key[key.length - i - 1];
		    key[key.length - i - 1] = temp;
		}
		Scanner scan2 = new Scanner(s);
		String translation = "";
		boolean hasSpace = false;
		boolean done = false;
		while(scan2.hasNext()) {
			String nextWord = scan2.next();
			boolean match = false;
			boolean failed = false;
			done = false;
			for(String[] pair : key) {
				if(pair.length > 2) {
					String lastWord = "";
					for(int i = 2; i < pair.length; i++) {
//						System.out.println(nextWord + "|" + pair[i]);
						if(nextWord.equalsIgnoreCase(pair[i])) {
							lastWord = nextWord;
							if(scan2.hasNext() && i < pair.length - 1) {
								nextWord = scan2.next();
							}
							else {
								done = true;
							}
							hasSpace = true;
						}
						else {
							if(hasSpace) {
								translation += lastWord + " " + nextWord + " ";
//								System.out.println("ADDED1: " + lastWord + nextWord);
								failed = true;
							}
							hasSpace = false;
							match = false;
							break;
						}
					}
					if(hasSpace) {
						translation += pair[0] + " ";
//						System.out.println("Translation: " + translation);
						match = true;
						hasSpace = false;
					}
					
					if(done || failed) {
						break;
					}
					
				}
				else if(nextWord.equalsIgnoreCase(pair[1])) {
					translation += pair[0] + " ";
//					System.out.println("Translation2: " + translation);
					match = true;
					break;
				}
			}
			if(!match && !failed) {
				translation += nextWord + " ";
//				System.out.println("ADDED2: " + nextWord);
			}
		}
		scan2.close();
		return translation;
	}
}
