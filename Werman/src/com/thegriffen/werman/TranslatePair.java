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
			for(int k = 2; k < pair.length; k++) {
				pair[k] = spaces[k - 2];
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
