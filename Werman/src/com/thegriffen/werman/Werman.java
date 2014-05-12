package com.thegriffen.werman;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Werman {
	
	private static List<TranslatePair> pairs = new ArrayList<TranslatePair>();
	
	public static void init() {
		pairs.add(new TranslatePair("kkk", "robotics"));
		pairs.add(new TranslatePair("robotics", "nazi people"));
		pairs.add(new TranslatePair("griffen", "the master"));
		pairs.add(new TranslatePair("shawn", "jackson"));
		pairs.add(new TranslatePair("girl", "curvy"));
		pairs.add(new TranslatePair("girls", "Bjerg"));
		pairs.add(new TranslatePair("food", "McLovin\'"));
		pairs.add(new TranslatePair("drink", "Pepsi"));
		pairs.add(new TranslatePair("harrison", "dirty casual"));
		pairs.add(new TranslatePair("seth", "flaminaFace"));
		pairs.add(new TranslatePair("connie", "ConMan")); //TODO make random
		pairs.add(new TranslatePair("logan", "lady killer"));
		pairs.add(new TranslatePair("lydia", "lydiot <3"));
		pairs.add(new TranslatePair("jackson", "Shawnish"));
		pairs.add(new TranslatePair("dance_mode", "Boom Boom dance dance!"));
		pairs.add(new TranslatePair("system.exit", "I think not! (never ending recursive loop goes here)"));
		pairs.add(new TranslatePair("carly", "Carlo"));
		pairs.add(new TranslatePair("carlo", "Carlos"));
		pairs.add(new TranslatePair("is", "isn\'t"));
		pairs.add(new TranslatePair("con", "pro"));
		pairs.add(new TranslatePair("pro", "con"));
		pairs.add(new TranslatePair("er", "ei"));
		pairs.add(new TranslatePair("g", "W"));
		pairs.add(new TranslatePair("b", "Vladimir"));
		pairs.add(new TranslatePair("m", "gurl please"));
		pairs.add(new TranslatePair("s", "Lanaster"));
		pairs.add(new TranslatePair("v", "FLAIRBROTHER"));
		pairs.add(new TranslatePair("1", "nullpointerexception42 (there were 41 other ones);"));
		pairs.add(new TranslatePair("2", "3"));
		pairs.add(new TranslatePair("3", "2"));
		pairs.add(new TranslatePair("5", "80"));
		pairs.add(new TranslatePair("6", "42"));
		pairs.add(new TranslatePair("7", "11"));
		pairs.add(new TranslatePair("69", "439"));
	}

	public static String TranslateToWerman(String s) {
		Scanner scan = new Scanner(s);
		String result = "";
		while(scan.hasNext()) {
			String nextWord = scan.next();
			boolean match = false;
			for(TranslatePair pair : pairs){
				if(nextWord.equalsIgnoreCase(pair.getPair()[0])) {
					result += pair.getPair()[1] + " ";
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
		Scanner scan2 = new Scanner(s);
		String translation = "";
		boolean hasSpace = false;
		boolean done = false;
		while(scan2.hasNext()) {
			String nextWord = scan2.next();
			boolean match = false;
			boolean failed = false;
			done = false;
			for(TranslatePair pair : pairs) {
				if(pair.getPair().length > 2) {
					String lastWord = "";
					for(int k = 2; k < pair.getPair().length; k++) {
//						System.out.println(nextWord + "|" + pair[i]);
						if(nextWord.equalsIgnoreCase(pair.getPair()[k])) {
							lastWord = nextWord;
							if(scan2.hasNext() && k < pair.getPair().length - 1) {
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
						translation += pair.getPair()[0] + " ";
//						System.out.println("Translation: " + translation);
						match = true;
						hasSpace = false;
					}
					
					if(done || failed) {
						break;
					}
					
				}
				else if(nextWord.equalsIgnoreCase(pair.getPair()[1])) {
					translation += pair.getPair()[0] + " ";
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
