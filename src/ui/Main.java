package ui;

import java.util.Scanner;

import model.*;

public class Main {
	
	private Sponsor sponsor;
	private Scanner reader;
	
	public Main() {
		sponsor = new Sponsor();
		reader = new Scanner(System.in);
	}
	
	public static void main(String[] args) {
		Main m = new Main();
		m.init();
	}
	
	public void welcome() {
		System.out.println("________________________________________________________________");
		System.out.println("|                                                              |");
		System.out.println("|                                                              |");
		System.out.println("|                    WELCOME TO OUR SYSTEM                     |");
		System.out.println("|                                                              |");
		System.out.println("|______________________________________________________________|");
	}
	
	public void showOptions() {
		System.out.println("Please type the option that you wanna do: ");
		System.out.println("1. Search a object.");
		System.out.println("2. Order objects");
		System.out.println("3. Add a object");
		System.out.println("4. Delete a object");
		System.out.println("5. Show a object");
		System.out.println("6. ");
		System.out.println("7. Salir");
	}
	
	public void showMenu() {
		welcome();
		int userInput = 0;
		while (userInput != 7){
			showOptions();
			System.out.println("________________________________________________________________");
			userInput = reader.nextInt();
			reader.nextLine();
			switch(userInput) {
			case 1:
				
			}
		}
	}
	
	public void search() throws InvalidOption {
		System.out.println("Please type a option you wish: ");
		System.out.println("1. Search a club.");
		System.out.println("2. Search a owner.");
		System.out.println("3. Search a pet.");
		int option = reader.nextInt();
		reader.nextLine();
		if(option == 1) {
			System.out.println("How do you wanna search a club? ");
			System.out.println("1. Name.");
			System.out.println("2. Id.");
			System.out.println("3. CreationDate.");
			System.out.println("4. PetType.");
			int option1 = reader.nextInt();
			reader.nextLine();
			if(option1 == 1) {
				System.out.println("Type the club's name: ");
				String name = reader.nextLine();
				System.out.println("1. Binary search");
				System.out.println("2. Traditional search");
				int s = reader.nextInt();
				reader.nextLine();
				if(s == 1) {
					sponsor.binSearchName(name);
				} else if(s ==2) {
					sponsor.tradSearchName(name);
				} else {
					String msg = "Type a valid option.";
					throw new InvalidOption(msg);
				}
			} else if(option1 == 2) {
				System.out.println("Type the club's id: ");
				String id = reader.nextLine();
				System.out.println("1. Binary search");
				System.out.println("2. Traditional search");
				int s = reader.nextInt();
				reader.nextLine();
				if(s == 1) {
					sponsor.binSearchId(id);
				} else if(s ==2) {
					sponsor.tradSearchId(id);
				} else {
					String msg = "Type a valid option.";
					throw new InvalidOption(msg);
				}
			} else if(option1 == 3) {
				System.out.println("Type the club's creationDate: ");
				String creationDate = reader.nextLine();
				System.out.println("1. Binary search");
				System.out.println("2. Traditional search");
				int s = reader.nextInt();
				reader.nextLine();
				if(s == 1) {
					sponsor.binSearchBirth(creationDate);
				} else if(s ==2) {
					sponsor.tradSearchCreationDate(creationDate);
				} else {
					String msg = "Type a valid option.";
					throw new InvalidOption(msg);
				}
			} else if(option1 == 4) {
				System.out.println("Type the club's petType: ");
				String petType = reader.nextLine();
				System.out.println("1. Binary search");
				System.out.println("2. Traditional search");
				int s = reader.nextInt();
				reader.nextLine();
				if(s == 1) {
					sponsor.binSearchType(petType);
				} else if(s ==2) {
					sponsor.tradSearchType(petType);
				} else {
					String msg = "Type a valid option.";
					throw new InvalidOption(msg);
				}
			} else {
				String msg = "Type a valid option.";
				throw new InvalidOption(msg);
			}
			
		}
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	public void init() {
		sponsor.init();
	}
}
