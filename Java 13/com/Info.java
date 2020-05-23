package com;

import java.text.*;
import java.time.LocalDateTime;
import java.time.format.*;
import java.util.*;

public class Info {
	
	static void printDate(Locale locale){  
		DateFormat formatter=DateFormat.getDateInstance(DateFormat.DEFAULT,locale);  
		Date currentDate=new Date(); 
		String date=formatter.format(currentDate);  
		System.out.println(date);  
		}  
	
	static void printCurrency(Locale locale){  
		 double dbl=10500.3245;  
		 NumberFormat formatter=NumberFormat.getCurrencyInstance(locale);  
		 String currency=formatter.format(dbl);  
		 System.out.println(currency+" for the locale "+locale);  
		} 
	
	public static void diplayInfo(Locale locale)
	{
		//Locale locale= new Locale("ro","ro");  
		//Locale locale=new Locale("fr","fr");//for the specific locale  
		
		Locale.setDefault(locale);
		  
		System.out.println(locale.getDisplayCountry());  
		System.out.println(locale.getDisplayLanguage());  
		System.out.println(locale.getDisplayName());  
		
		String baseName;
		
		if(locale.equals(new Locale("en","US")))
		{
			baseName = "res.week_months";
		}
		else  baseName = "res.week_months_ro";
		
		ResourceBundle messages = ResourceBundle.getBundle(baseName, locale);
		System.out.println(messages.getString("week"));
		System.out.println(messages.getString("months"));
		
		
		 double salary = 1_000_000;
		 Locale enLocale = Locale.forLanguageTag("en-US");
		 System.out.print(NumberFormat.getCurrencyInstance(locale).format(salary) + " ");
		 Currency currency = Currency.getInstance(locale);
		 System.out.println(currency.getDisplayName());
		 
		
		 //locale=Locale.getDefault();
		 
		 LocalDateTime today = LocalDateTime.now();
		 DateTimeFormatter formatter = DateTimeFormatter.ofLocalizedDate(FormatStyle.FULL).withLocale(locale);
		 System.out.print("Today: " + today.format(formatter) + " (");
		 formatter = DateTimeFormatter.ofLocalizedDate(FormatStyle.FULL).withLocale(enLocale);
		 System.out.print(" " + today.format(formatter) + ")");
	}
}
