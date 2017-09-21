package org.modul2.myhren.me;

import java.util.HashMap;
import java.util.Scanner;

public class Main {
	
	static int myMoney = 50; 
	
	//Scanner initialisation
	static Scanner scanner = new Scanner(System.in);
	
	//Initialises HashMap, where the item name is the key, and the cost is the value
	static HashMap<String, Integer> items = new HashMap<String, Integer>() {{
		put ("apple", 10);
		put ("newspaper", 20);
		put ("veganfood", 60);
		
	}};
	
	//Entry point
	public static void main(String[] args) {
		System.out.println("Welcome to the Happy Shop! Is there anything you would like to purchase?");
		System.out.println("Available commands are: list, money and exit.");
		
		//Loops while waiting for user input
		while(true) {
			
			String purchaseItem = scanner.next();
		
			//Prints a list
			if (purchaseItem.equalsIgnoreCase("list")) {
				printList();
				continue;
			}
			if (purchaseItem.equalsIgnoreCase("money")) {
				printMoney();
				continue;
			}
			//If exit is written, exits the loop
			if (purchaseItem.equalsIgnoreCase("exit")) {
				scanner.close();
				System.exit(0);
			}
			
			//Makes the input lowercase, so you can write item however you want
			purchaseItem = purchaseItem.toLowerCase();
			purchaseHandler(purchaseItem);
		}
		
	}
	
	public static void purchaseHandler(String purchaseItem) {
		
		//If the item asked for does not exist
		if (!items.containsKey(purchaseItem)) {
			
			System.out.println("I am sorry, but we do not posess that item.");
			System.out.println("Is there anything else you would like?");
			return;
		}
		
		boolean purchased = purchaseItem(purchaseItem);
		if (purchased) {
			System.out.println("Thank you for purchasing " + purchaseItem + " for " + items.get(purchaseItem).intValue() + "$");
			printMoney();
			
		} else
			System.out.println("You do not have enough money to purchase " + purchaseItem + ", it costs " + items.get(purchaseItem).intValue() + "$");
	}
	
	//Returns false if cannot purchase item, returns true if purchased
	public static boolean purchaseItem(String purchaseItem) {
		
		int price = items.get(purchaseItem).intValue();
		if (price > myMoney) 
			return false; 
		
		myMoney -= price; 
		return true; 
	}
	
	//Lists items available for purchase
	public static void printList() {
		//Makes a for loop that gets the key of all items in the hashmap, and refers each as item
		for (String item : items.keySet() ) {
			
			int price = items.get(item).intValue();
			System.out.println(makeUpperCase(item) + " costs " + price + "$");
					
		}
	}
	
	//Makes the first character of a string uppercase
	public static String makeUpperCase(String s) {
		
		return Character.toUpperCase(s.charAt(0)) + s.substring(1);
	}
	
	//Prints the money you have
	public static void printMoney() {
		
		System.out.println("You have " + myMoney + "$");
	}
}