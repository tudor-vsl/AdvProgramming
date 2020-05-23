package com;

import java.io.IOException;
import java.text.MessageFormat;
import java.time.LocalDate;
import java.util.Locale;
import java.util.ResourceBundle;
import java.util.Scanner;

public class SetLocale {
	
	public static void displayMessages(Locale locale) {
		
		String baseName;
		if(locale.equals(new Locale("en","US")) == true || locale.equals(new Locale("ro","ro")) == true){
			Locale aux = new Locale("ro","ro");
			if(aux.equals(locale))
			{
				baseName = "res.Messages_ro";
			}
			else  baseName = "res.Messages";
		
			ResourceBundle messages = ResourceBundle.getBundle(baseName, locale);
			System.out.println(messages.getString("prompt") + " " + locale);
			
			System.out.print(messages.getString("locales") + " ");
			
			DisplayLocales.displayLocales();
			
			String pattern = messages.getString("locale.set");
			Object[] argument = {locale};
			String localeSet = new MessageFormat(pattern).format(argument) + ".";
			System.out.println(localeSet);
			
			pattern = messages.getString("info");
			Object[] arguments = {locale};
			String info = new MessageFormat(pattern).format(arguments);
			System.out.println(info);
		
			Info.diplayInfo(locale);
		}
		else {
			ResourceBundle messages = ResourceBundle.getBundle("res.Messages", locale);
			System.out.print(messages.getString("invalid") + " ");
		}
			
	}
	
	public static void main(String args[]) throws IOException {
		System.out.println("Please enter the language and the country: ");
		Scanner scan = new Scanner(System.in);
		String lang = scan.nextLine();
		String country = scan.nextLine();
		Locale locale = new Locale(lang,country);
		displayMessages(locale);
	}
}
