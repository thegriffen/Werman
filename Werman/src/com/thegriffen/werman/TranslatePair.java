package com.thegriffen.werman;

public class TranslatePair {
	private String from, to;
	private String[] pair;
	
	public TranslatePair(String _from, String _to) {
		from = _from;
		to = _to;
		String[] spaces = to.split("\\s+");
		if(spaces.length > 1) {
			pair = new String[spaces.length + 2];
			pair[0] = from;
			pair[1] = to;
			for(int i = 2; i < pair.length; i++) {
				pair[i] = spaces[i - 2];
			}
		}
		else {
			pair = new String[] {from, to};
		}
	}
	
	public String[] getPair() {
		return pair;
	}
}
