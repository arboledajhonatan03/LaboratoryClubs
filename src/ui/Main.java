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
		m.showMenu();
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
		System.out.println("6. Salir");
	}
	
	public void showMenu() {
		welcome();
		int userInput = 0;
		while (userInput != 6){
			showOptions();
			System.out.println("________________________________________________________________");
			userInput = reader.nextInt();
			reader.nextLine();
			try {
				switch(userInput) {
				case 1:
					search();
					System.out.println("");
					break;
				case 2:
					order();
					break;
				case 3:
					addObject();
					break;
				case 4:
					deleteObject();
					break;
				case 5:
					showObjects();
					break;
				}
			} catch (InvalidOption e) {
				e.getMessage();
			}
		}
	}
	

	public void search() throws InvalidOption {
		System.out.println("Please type a option you wish: ");
		System.out.println("1. Search a club.");
		System.out.println("2. Search a owner.");
		System.out.println("3. Search a pet.");
		String msg = "The object exist? : \n";
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
				long t1 = System.currentTimeMillis();
				System.out.println(msg+sponsor.binSearchName(name));
				long t2 = System.currentTimeMillis();
				long bin = t2-t1;
				long t3 = System.currentTimeMillis();
				System.out.println(msg+sponsor.tradSearchName(name));
				long t4 = System.currentTimeMillis();
				long trad = t4-t3;
				System.out.println("The time that the binary search it took is: " + bin);
				System.out.println("The time that the traditional search it took is: " + trad);
				
			} else if(option1 == 2) {
				System.out.println("Type the club's id: ");
				String id = reader.nextLine();
				long t1 = System.currentTimeMillis();
				System.out.println(msg+sponsor.binSearchId(id));
				long t2 = System.currentTimeMillis();
				long bin = t2-t1;
				long t3 = System.currentTimeMillis();
				System.out.println(msg+sponsor.tradSearchId(id));
				long t4 = System.currentTimeMillis();
				long trad = t4-t3;
				System.out.println("The time that the binary search it took is: " + bin);
				System.out.println("The time that the traditional search it took is: " + trad);
				
			} else if(option1 == 3) {
				System.out.println("Type the club's creationDate: ");
				String creationDate = reader.nextLine();
				long t1 = System.currentTimeMillis();
				System.out.println(msg+sponsor.binSearchBirth(creationDate));
				long t2 = System.currentTimeMillis();
				long bin = t2-t1;
				long t3 = System.currentTimeMillis();
				System.out.println(msg+sponsor.tradSearchCreationDate(creationDate));
				long t4 = System.currentTimeMillis();
				long trad = t4-t3;
				System.out.println("The time that the binary search it took is: " + bin);
				System.out.println("The time that the traditional search it took is: " + trad);
				
			} else if(option1 == 4) {
				System.out.println("Type the club's petType: ");
				String petType = reader.nextLine();
				long t1 = System.currentTimeMillis();
				System.out.println(msg+sponsor.binSearchType(petType));
				long t2 = System.currentTimeMillis();
				long bin = t2-t1;
				long t3 = System.currentTimeMillis();
				System.out.println(msg+sponsor.tradSearchType(petType));
				long t4 = System.currentTimeMillis();
				long trad = t4-t3;
				System.out.println("The time that the binary search it took is: " + bin);
				System.out.println("The time that the traditional search it took is: " + trad);	
				
			} else {
				String msj = "Type a valid option.";
				throw new InvalidOption(msj);
			}
			
		} else if(option == 2) {
			System.out.println("How do you wanna search a owner? ");
			System.out.println("1. Name.");
			System.out.println("2. LastName");
			System.out.println("3. Id.");
			System.out.println("4. BirthDate.");
			System.out.println("5. PetType.");
			int option1 = reader.nextInt();
			reader.nextLine();
			if(option1 == 1) {
				System.out.println("Type the owner's name: ");
				String name = reader.nextLine();
				long t1 = System.currentTimeMillis();
				System.out.println(msg+sponsor.binSearchNameOwner(name));
				long t2 = System.currentTimeMillis();
				long bin = t2-t1;
				long t3 = System.currentTimeMillis();
				System.out.println(msg+sponsor.tradSearchNameOwner(name));
				long t4 = System.currentTimeMillis();
				long trad = t4-t3;
				System.out.println("The time that the binary search it took is: " + bin);
				System.out.println("The time that the traditional search it took is: " + trad);	
			}
			else if(option1 == 2) {
				System.out.println("Type the owner's lastName: ");
				String name = reader.nextLine();
				long t1 = System.currentTimeMillis();
				System.out.println(msg+sponsor.binSearchLastName(name));
				long t2 = System.currentTimeMillis();
				long bin = t2-t1;
				long t3 = System.currentTimeMillis();
				System.out.println(msg+sponsor.tradSearchLastName(name));
				long t4 = System.currentTimeMillis();
				long trad = t4-t3;
				System.out.println("The time that the binary search it took is: " + bin);
				System.out.println("The time that the traditional search it took is: " + trad);	
				
			}
			else if(option1 == 3) {
				System.out.println("Type the owner's id: ");
				String id = reader.nextLine();
				long t1 = System.currentTimeMillis();
				System.out.println(msg+sponsor.binSearchIdOwner(id));
				long t2 = System.currentTimeMillis();
				long bin = t2-t1;
				long t3 = System.currentTimeMillis();
				System.out.println(msg+sponsor.tradSearchIdOwner(id));
				long t4 = System.currentTimeMillis();
				long trad = t4-t3;
				System.out.println("The time that the binary search it took is: " + bin);
				System.out.println("The time that the traditional search it took is: " + trad);	
				
			}
			else if(option1 == 4) {
				System.out.println("Type the owner's birthDate: ");
				String birth = reader.nextLine();
				long t1 = System.currentTimeMillis();
				System.out.println(msg+sponsor.binSearchBirthOwner(birth));
				long t2 = System.currentTimeMillis();
				long bin = t2-t1;
				long t3 = System.currentTimeMillis();
				System.out.println(msg+sponsor.tradSearchBirthOwner(birth));
				long t4 = System.currentTimeMillis();
				long trad = t4-t3;
				System.out.println("The time that the binary search it took is: " + bin);
				System.out.println("The time that the traditional search it took is: " + trad);	
				
			}
			else if(option1 == 5) {
				System.out.println("Type the owner's petType: ");
				String petType = reader.nextLine();
				long t1 = System.currentTimeMillis();
				System.out.println(msg+sponsor.binSearchPetTypeOwner(petType));
				long t2 = System.currentTimeMillis();
				long bin = t2-t1;
				long t3 = System.currentTimeMillis();
				System.out.println(msg+sponsor.tradSearchPetTypeOwner(petType));
				long t4 = System.currentTimeMillis();
				long trad = t4-t3;
				System.out.println("The time that the binary search it took is: " + bin);
				System.out.println("The time that the traditional search it took is: " + trad);	
				
			}
			else {
				String msj = "Type a valid option.";
				throw new InvalidOption(msj);
			}
		}else if(option == 3) {
			System.out.println("How do you wanna search a pet? ");
			System.out.println("1. Name.");
			System.out.println("2. Id.");
			System.out.println("3. Sex.");
			System.out.println("4. BirthDate.");
			System.out.println("5. Type.");
			int option1 = reader.nextInt();
			reader.nextLine();
			if(option1 == 1) {
				System.out.println("Type the pet's name: ");
				String name = reader.nextLine();
				long t1 = System.currentTimeMillis();
				System.out.println(msg+sponsor.binSearchNamePet(name));
				long t2 = System.currentTimeMillis();
				long bin = t2-t1;
				long t3 = System.currentTimeMillis();
				System.out.println(msg+sponsor.tradSearchNamePet(name));
				long t4 = System.currentTimeMillis();
				long trad = t4-t3;
				System.out.println("The time that the binary search it took is: " + bin);
				System.out.println("The time that the traditional search it took is: " + trad);	
				
			}
			else if(option1 == 2) {
				System.out.println("Type the pet's id: ");
				String id = reader.nextLine();
				long t1 = System.currentTimeMillis();
				System.out.println(msg+sponsor.binSearchIdPet(id));
				long t2 = System.currentTimeMillis();
				long bin = t2-t1;
				long t3 = System.currentTimeMillis();
				System.out.println(msg+sponsor.tradSearchIdPet(id));
				long t4 = System.currentTimeMillis();
				long trad = t4-t3;
				System.out.println("The time that the binary search it took is: " + bin);
				System.out.println("The time that the traditional search it took is: " + trad);	
				
			}
			else if(option1 == 3) {
				System.out.println("Type the pet's sex like a number(1 for male, 2 for female): ");
				int sex = reader.nextInt();
				reader.nextLine();
				long t1 = System.currentTimeMillis();
				System.out.println(msg+sponsor.binSearchSexPet(sex));
				long t2 = System.currentTimeMillis();
				long bin = t2-t1;
				long t3 = System.currentTimeMillis();
				System.out.println(msg+sponsor.tradSearchSexPet(sex));
				long t4 = System.currentTimeMillis();
				long trad = t4-t3;
				System.out.println("The time that the binary search it took is: " + bin);
				System.out.println("The time that the traditional search it took is: " + trad);	
				
			}
			else if(option1 == 4) {
				System.out.println("Type the pet's birthDate: ");
				String birth = reader.nextLine();
				long t1 = System.currentTimeMillis();
				System.out.println(msg+sponsor.binSearchBirthPet(birth));
				long t2 = System.currentTimeMillis();
				long bin = t2-t1;
				long t3 = System.currentTimeMillis();
				System.out.println(msg+sponsor.tradSearchBirthPet(birth));
				long t4 = System.currentTimeMillis();
				long trad = t4-t3;
				System.out.println("The time that the binary search it took is: " + bin);
				System.out.println("The time that the traditional search it took is: " + trad);	
				
			}
			else if(option1 == 5) {
				System.out.println("Type the pet's type: ");
				String type = reader.nextLine();
				long t1 = System.currentTimeMillis();
				System.out.println(msg+sponsor.binSearchTypePet(type));
				long t2 = System.currentTimeMillis();
				long bin = t2-t1;
				long t3 = System.currentTimeMillis();
				System.out.println(msg+sponsor.tradSearchTypePet(type));
				long t4 = System.currentTimeMillis();
				long trad = t4-t3;
				System.out.println("The time that the binary search it took is: " + bin);
				System.out.println("The time that the traditional search it took is: " + trad);	
				
			}
			else {
				String msj = "Type a valid option.";
				throw new InvalidOption(msj);
			}
		}
		
	}
	
	private void order() throws InvalidOption {
		System.out.println("Please type the option you wish: ");
		System.out.println("1. Order clubs.");
		System.out.println("2. Order owners.");
		System.out.println("3. Order pets.");
		int option = reader.nextInt();
		reader.nextLine();
		if(option == 1) {
			System.out.println("How do you wanna order the clubs? ");
			System.out.println("1. Name.");
			System.out.println("2. Id.");
			System.out.println("3. CreationDate.");
			System.out.println("4. PetType.");
			int option1 = reader.nextInt();
			reader.nextLine();
			if(option1 == 1) {
				sponsor.orderClubNames();
				for (int i = 0; i < sponsor.getClubs().size(); i++) {
					System.out.println(sponsor.getClubs().get(i).toString());
				}
			}
			else if(option1 == 2) {
				sponsor.orderClubId();
				for (int i = 0; i < sponsor.getClubs().size(); i++) {
					System.out.println(sponsor.getClubs().get(i).toString());
				}
			}
			else if(option1 == 3) {
				sponsor.orderClubCreationDate();
				for (int i = 0; i < sponsor.getClubs().size(); i++) {
					System.out.println(sponsor.getClubs().get(i).toString());
				}
			}
			else if(option1 == 4) {
				sponsor.orderClubPetType();
				for (int i = 0; i < sponsor.getClubs().size(); i++) {
					System.out.println(sponsor.getClubs().get(i).toString());
				}
			}
			else {
				String msj = "Type a valid option.";
				throw new InvalidOption(msj);
			}
		}
		else if(option == 2) {
			System.out.println("How do you wanna order the owners? ");
			System.out.println("1. Name.");
			System.out.println("2. LastName.");
			System.out.println("3. Id.");
			System.out.println("4. BirthDate.");
			System.out.println("5. PetType.");
			int option1 = reader.nextInt();
			reader.nextLine();
			if(option1 == 1) {
				sponsor.orderOwnerNames();
				for (int i = 0; i < sponsor.getClubs().size(); i++) {
					System.out.println(sponsor.getClubs().get(i).getOwners().toString());
				}
			}
			else if(option1 == 2) {
				sponsor.orderOwnerLastName();
				for (int i = 0; i < sponsor.getClubs().size(); i++) {
					System.out.println(sponsor.getClubs().get(i).getOwners().toString());
				}
			}
			else if(option1 == 3) {
				sponsor.orderOwnerId();
				for (int i = 0; i < sponsor.getClubs().size(); i++) {
					System.out.println(sponsor.getClubs().get(i).getOwners().toString());
				}
			}
			else if(option1 == 4) {
				sponsor.orderOwnerBirth();
				for (int i = 0; i < sponsor.getClubs().size(); i++) {
					System.out.println(sponsor.getClubs().get(i).getOwners().toString());
				}
			}
			else if(option1 == 5) {
				sponsor.orderOwnerPetType();
				for (int i = 0; i < sponsor.getClubs().size(); i++) {
					System.out.println(sponsor.getClubs().get(i).getOwners().toString());
				}
			}
		}
		else if(option == 3) {
			System.out.println("How do you wanna order the pets? ");
			System.out.println("1. Name.");
			System.out.println("2. Id.");
			System.out.println("3. Sex.");
			System.out.println("4. BirthDate.");
			System.out.println("5. PetType.");
			int option1 = reader.nextInt();
			reader.nextLine();
			if(option1 == 1) {
				sponsor.orderPetNames();
				for (int i = 0; i < sponsor.getClubs().size(); i++) {
					System.out.println(sponsor.getClubs().get(i).getOwners().get(i).getPets());
				}
			}
			else if(option1 == 2) {
				sponsor.orderPetId();
				for (int i = 0; i < sponsor.getClubs().size(); i++) {
					System.out.println(sponsor.getClubs().get(i).getOwners().get(i).getPets());
				}
			}
			else if(option1 == 3) {
				sponsor.orderPetSex();
				for (int i = 0; i < sponsor.getClubs().size(); i++) {
					System.out.println(sponsor.getClubs().get(i).getOwners().get(i).getPets());
				}
			}
			else if(option1 == 4) {
				sponsor.orderPetBirth();
				for (int i = 0; i < sponsor.getClubs().size(); i++) {
					System.out.println(sponsor.getClubs().get(i).getOwners().get(i).getPets());
				}
			}
			else if(option1 == 5) {
				sponsor.orderPetType();
				for (int i = 0; i < sponsor.getClubs().size(); i++) {
					System.out.println(sponsor.getClubs().get(i).getOwners().get(i).getPets());
				}
			}
		}
	}
	
	private void addObject() {
		System.out.println("Please type the option you wish: ");
		System.out.println("1. Add club.");
		System.out.println("2. Add owner.");
		System.out.println("3. Add pet.");
		int option = reader.nextInt();
		reader.nextLine();
		if(option == 1) {
			System.out.println("Type the name of the club: ");
			String name = reader.nextLine();
			System.out.println("Type the id of the club: ");
			String id = reader.nextLine();
			System.out.println("Type the creationDate of the club: ");
			String creationDate = reader.nextLine();
			System.out.println("Type the kind of pet of the club: ");
			String type = reader.nextLine();
			Club c = new Club(name, id, creationDate, type);
			sponsor.addClub(c);
		}
		else if(option == 2) {
			System.out.println("Type the name of the owner: ");
			String name = reader.nextLine();
			System.out.println("Type the last name of the owner: ");
			String lastName = reader.nextLine();
			System.out.println("Type the id of the owner: ");
			String id = reader.nextLine();
			System.out.println("Type the birth date of the owner: ");
			String birth = reader.nextLine();
			System.out.println("Type the kind of pet of the owner: ");
			String type = reader.nextLine();
			Owner o = new Owner(name, lastName, id, birth, type);
			System.out.println("Type the club's id to add this owner: ");
			String idClub = reader.nextLine();
			try {
				sponsor.addOwner(o, idClub);
			} catch (SameObject e) {
				e.getMessage();
			}
		}
		else if(option == 3) {
			System.out.println("Type the name of the pet: ");
			String name = reader.nextLine();
			System.out.println("Type the id of the pet: ");
			String id = reader.nextLine();
			System.out.println("Type the sex of the pet: ");
			int sex = reader.nextInt();
			reader.nextLine();
			System.out.println("Type the birth date of the pet: ");
			String birth = reader.nextLine();
			System.out.println("Type the kind of pet of the pet: ");
			String type = reader.nextLine();
			Pet p = new Pet(name, id, sex, birth, type);
			System.out.println("Type the owner's id to add this pet: ");
			String idOwner = reader.nextLine();
			sponsor.addPet(p, idOwner);
		}
		
	}

	private void deleteObject() {
		System.out.println("Please type the option you wish: ");
		System.out.println("1. Delete a club.");
		System.out.println("2. Delete a owner.");
		System.out.println("3. Delete a pet.");
		int option = reader.nextInt();
		reader.nextLine();
		if(option == 1) {
			System.out.println("Type the club's id that you wanna delete: ");
			String id = reader.nextLine();
			sponsor.deleteClub(id);
			System.out.println("The club has been deleted!");
		}
		else if(option == 2) {
			System.out.println("Type the owner's id that you wanna delete: ");
			String id = reader.nextLine();
			sponsor.deleteOwner(id);
			System.out.println("The owner has been deleted!");
		}
		else if(option == 3) {
			System.out.println("Type the pet's id that you wanna delete: ");
			String id = reader.nextLine();
			sponsor.deletePet(id);
			System.out.println("The pet has been deleted!");
		}
	}
	
	private void showObjects() {
		
		
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	public void init() {
		sponsor.init();
	}
}
