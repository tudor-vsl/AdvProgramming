package com;

import java.util.Locale;

public class DisplayLocales {
	static public void displayLocales() {
		
	Locale available[] = Locale.getAvailableLocales();
	 
	for(Locale locale : available) {
		System.out.println("  " + locale.toString());
		}
	}
}
