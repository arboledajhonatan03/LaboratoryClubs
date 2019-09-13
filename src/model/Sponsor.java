package model;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;

public class Sponsor {

	public static final String ARCHIVE_PLANE = "clubs.txt";
	
	private ArrayList<Club> clubs;
	
	public Sponsor() {
		clubs = new ArrayList<>();
		try {
			loadData();
		} catch (ClassNotFoundException | IOException e) {
			e.printStackTrace();
		}
	}
	
	
	/**
	 * @return the clubs
	 */
	public ArrayList<Club> getClubs() {
		return clubs;
	}


	/**
	 * @param clubs the clubs to set
	 */
	public void setClubs(ArrayList<Club> clubs) {
		this.clubs = clubs;
	}


	public void addOwner(Owner o, String idClub) throws SameObject{
		boolean equal = false;
		for(int i=0; i<clubs.size() && !equal; i++){
			if(clubs.get(i).sameOwner(o)){
				equal = true;
			}
		}
		if(!equal){
			boolean finded = false;
			for(int j=0; j<clubs.size() && !finded; j++){
				if(clubs.get(j).getId().equals(idClub)){
					clubs.get(j).getOwners().add(o);
					finded = true;
				}
			}
		} else {
			String msg = "already exists a owner with that same information!";
			throw new SameObject(msg);
		}
	}
	
	public void addClub(Club c) throws IOException {
		clubs.add(c);
		File file = new File(ARCHIVE_PLANE);
		FileWriter writer = new FileWriter(file.getAbsoluteFile(), true);
		BufferedWriter bwriter = new BufferedWriter(writer);
		bwriter.write(c.toString() + "\n");
		bwriter.close();
	}
	
	public void loadData() throws IOException, ClassNotFoundException{
		File file = new File(ARCHIVE_PLANE);
		BufferedReader reader = new BufferedReader(new FileReader(file));
		String line;
		while ((line = reader.readLine()) != null) {
			if(!line.equals("id,first_name,creationDate,typePet\r\n")) {
				String[] split = line.split(",");
				Club c = new Club(split[0], split[1], split[2], split[3]);
				clubs.add(c);
			}
		}
		reader.close();
	}
	
	public void saveData() throws FileNotFoundException, IOException{
		
	}
	
	public void orderClubs() {
		for (int  i= 0;  i< clubs.size()-1; i++) {
			for (int j = 0; j < clubs.size()-1-i; j++) {
				if (clubs.get(j).compareTo(clubs.get(j+1))>0) {
					Club tmp = clubs.get(j);
					clubs.set(j, clubs.get(j+1));
					clubs.set(j+1, tmp);
				}
			}
		}
	}
	
	public void orderClubId() {
		for (int i = 1; i < clubs.size(); i++) {
			for (int j = i; j > 0 && clubs.get(j-1).compareId(clubs.get(j))>0; j--) {
				Club tmp = clubs.get(j);
				clubs.set(j, clubs.get(j-1));
				clubs.set(j-1, tmp);
			}
		}
	}
	
	public void orderClubNames() {
		for (int i = 0; i < clubs.size()-1; i++) {
			Club menor = clubs.get(i);
			int cual = i;
			for (int j = i+1; j < clubs.size(); j++) {
				if(clubs.get(j).compareName(menor)<0) {
					menor = clubs.get(j);
					cual = j;
				}
				
			}
			Club tmp = clubs.get(i);
			clubs.set(i, menor);
			clubs.set(cual, tmp);
		}
	}
	
	public void orderClubCreationDate() {
		for (int i = 1; i < clubs.size(); i++) {
			for (int j = i; j > 0 && clubs.get(j-1).compareCreacionDate(clubs.get(j))>0; j--) {
				Club tmp = clubs.get(j);
				clubs.set(j, clubs.get(j-1));
				clubs.set(j-1, tmp);
			}
		}
	}
	
	public void orderClubPetType() {
		for (int i = 0; i < clubs.size()-1; i++) {
			Club menor = clubs.get(i);
			int cual = i;
			for (int j = i+1; j < clubs.size(); j++) {
				if(clubs.get(j).comparePetType(menor)<0) {
					menor = clubs.get(j);
					cual = j;
				}
				
			}
			Club tmp = clubs.get(i);
			clubs.set(i, menor);
			clubs.set(cual, tmp);
		}
	}
	
	public String tradSearchId(String identification) {
		String msg = "There is not club with that identification.";
		int count = 0;
		for (int i = 0; i < clubs.size(); i++) {
			if(clubs.get(i).getId().equals(identification)) {
				count++;
			}
		}
		if(count == 1) {
			msg = "There is 1 club with that same identification.";
		}else if(count > 1) {
			msg = "There are " + count + " clubs with that same identification.";
		}
		
		return msg;
	}
	
	public String tradSearchName(String n) {
		String msg = "There is not club with that name.";
		int count = 0;
		for (int i = 0; i < clubs.size(); i++) {
			if(clubs.get(i).getName().equals(n)) {
				count++;
			}
		}
		if(count == 1) {
			msg = "There is 1 club with that same name.";
		}else if(count > 1) {
			msg = "There are " + count + " club with that same name.";
		}
		
		return msg;
	}
	
	public String tradSearchCreationDate(String date) {
		String msg = "There is not club with that creation date.";
		int count = 0;
		for (int i = 0; i < clubs.size(); i++) {
			if(clubs.get(i).getCreationDate().equals(date)) {
				count++;
			}
		}
		if(count == 1) {
			msg = "There is 1 club with that same creation date.";
		}else if(count > 1) {
			msg = "There are " + count + " clubs with that same creation date.";
		}
		
		return msg;
	}
	
	public String tradSearchType(String petType) {
		String msg = "There is not club with that type.";
		int count = 0;
		for (int i = 0; i < clubs.size(); i++) {
			if(clubs.get(i).getPetType().equals(petType)) {
				count++;
			}
		}
		if(count == 1) {
			msg = "There is 1 club with that same type.";
		}else if(count > 1) {
			msg = "There are " + count + " clubs with that same type.";
		}
		
		return msg;
	}
	
	public boolean binSearchId(String identification) {
		boolean finded = false;
		int i = 0;
		int fin = clubs.size()-1;
		while(i <= fin && !finded) {
			int mid = (i+fin)/2;
			if(clubs.get(mid).getId().equals(identification)) {
				finded = true;
			}
			else if(clubs.get(mid).getId().compareTo(identification)>0) {
				fin = mid - 1;
			}
			else {
				i = mid + 1;
			}
		}
		return finded;
	}
	
	public boolean binSearchName(String n) {
		boolean finded = false;
		int i = 0;
		int fin = clubs.size()-1;
		while(i <= fin && !finded) {
			int mid = (i+fin)/2;
			if(clubs.get(mid).getName().equals(n)) {
				finded = true;
			}
			else if(clubs.get(mid).getName().compareTo(n)>0) {
				fin = mid - 1;
			}
			else {
				i = mid + 1;
			}
		}
		return finded;
	}
	
	public boolean binSearchBirth(String birthDate) {
		boolean finded = false;
		int i = 0;
		int fin = clubs.size()-1;
		while(i <= fin && !finded) {
			int mid = (i+fin)/2;
			if(clubs.get(mid).getCreationDate().equals(birthDate)) {
				finded = true;
			}
			else if(clubs.get(mid).getCreationDate().compareTo(birthDate)>0) {
				fin = mid - 1;
			}
			else {
				i = mid + 1;
			}
		}
		return finded;
	}
	
	public boolean binSearchType(String type) {
		boolean finded = false;
		int i = 0;
		int fin = clubs.size()-1;
		while(i <= fin && !finded) {
			int mid = (i+fin)/2;
			if(clubs.get(mid).getPetType().equals(type)) {
				finded = true;
			}
			else if(clubs.get(mid).getPetType().compareTo(type)>0) {
				fin = mid - 1;
			}
			else {
				i = mid + 1;
			}
		}
		return finded;
	}
	
	public boolean tradSearchNameOwner(String n) {
		boolean founded = false;
		for (int i = 0; i < clubs.size() && !founded; i++) {
			founded = clubs.get(i).tradSearchName(n);
		}
		return founded;
	}
	public boolean tradSearchLastName(String n) {
		boolean founded = false;
		for (int i = 0; i < clubs.size() && !founded; i++) {
			founded = clubs.get(i).tradSearchLastName(n);
		}
		return founded;
	}
	public boolean tradSearchIdOwner(String n) {
		boolean founded = false;
		for (int i = 0; i < clubs.size() && !founded; i++) {
			founded = clubs.get(i).tradSearchId(n);
		}
		return founded;
	}
	public boolean tradSearchBirthOwner(String n) {
		boolean founded = false;
		for (int i = 0; i < clubs.size() && !founded; i++) {
			founded = clubs.get(i).tradSearchBirth(n);
		}
		return founded;
	}
	public boolean tradSearchPetTypeOwner(String n) {
		boolean founded = false;
		for (int i = 0; i < clubs.size() && !founded; i++) {
			founded = clubs.get(i).tradSearchType(n);
		}
		return founded;
	}
	
	public boolean binSearchNameOwner(String n) {
		boolean founded = false;
		for (int i = 0; i < clubs.size() && !founded; i++) {
			founded = clubs.get(i).binSearchName(n);
		}
		return founded;
	}
	public boolean binSearchLastName(String n) {
		boolean founded = false;
		for (int i = 0; i < clubs.size() && !founded; i++) {
			founded = clubs.get(i).binSearchLastName(n);
		}
		return founded;
	}
	public boolean binSearchIdOwner(String n) {
		boolean founded = false;
		for (int i = 0; i < clubs.size() && !founded; i++) {
			founded = clubs.get(i).binSearchId(n);
		}
		return founded;
	}
	public boolean binSearchBirthOwner(String n) {
		boolean founded = false;
		for (int i = 0; i < clubs.size() && !founded; i++) {
			founded = clubs.get(i).binSearchBirth(n);
		}
		return founded;
	}
	public boolean binSearchPetTypeOwner(String n) {
		boolean founded = false;
		for (int i = 0; i < clubs.size() && !founded; i++) {
			founded = clubs.get(i).binSearchType(n);
		}
		return founded;
	}
	
	
	
	public boolean tradSearchNamePet(String n) {
		boolean founded = false;
		for (int i = 0; i < clubs.size() && !founded; i++) {
			founded = clubs.get(i).tradSearchNamePet(n);
		}
		return founded;
	}
	public boolean tradSearchIdPet(String n) {
		boolean founded = false;
		for (int i = 0; i < clubs.size() && !founded; i++) {
			founded = clubs.get(i).tradSearchIdPet(n);
		}
		return founded;
	}
	public boolean tradSearchSexPet(int n) {
		boolean founded = false;
		for (int i = 0; i < clubs.size() && !founded; i++) {
			founded = clubs.get(i).tradSearchSexPet(n);
		}
		return founded;
	}
	public boolean tradSearchTypePet(String n) {
		boolean founded = false;
		for (int i = 0; i < clubs.size() && !founded; i++) {
			founded = clubs.get(i).tradSearchTypePet(n);
		}
		return founded;
	}
	public boolean tradSearchBirthPet(String n) {
		boolean founded = false;
		for (int i = 0; i < clubs.size() && !founded; i++) {
			founded = clubs.get(i).tradSearchBirthPet(n);
		}
		return founded;
	}
	
	public boolean binSearchNamePet(String n) {
		boolean exist = false;
		for (int i = 0; i < clubs.size() && !exist; i++) {
			exist = clubs.get(i).binSearchNamePet(n);
		}
		return exist;
	}
	public boolean binSearchIdPet(String n) {
		boolean exist = false;
		for (int i = 0; i < clubs.size() && !exist; i++) {
			exist = clubs.get(i).binSearchIdPet(n);
		}
		return exist;
	}
	public boolean binSearchSexPet(int n) {
		boolean exist = false;
		for (int i = 0; i < clubs.size() && !exist; i++) {
			exist = clubs.get(i).binSearchSexPet(n);
		}
		return exist;
	}
	public boolean binSearchTypePet(String n) {
		boolean exist = false;
		for (int i = 0; i < clubs.size() && !exist; i++) {
			exist = clubs.get(i).binSearchTypePet(n);
		}
		return exist;
	}
	public boolean binSearchBirthPet(String n) {
		boolean exist = false;
		for (int i = 0; i < clubs.size() && !exist; i++) {
			exist = clubs.get(i).binSearchBirthPet(n);
		}
		return exist;
	}
	
	public void deletePet(String id) {
		for (int i = 0; i < clubs.size(); i++) {
			clubs.get(i).deletePet(id);
		}
	}
	
	public void deleteOwner(String id) {
		for (int i = 0; i < clubs.size(); i++) {
			clubs.get(i).deleteOwner(id);
		}
	}
	
	public void deleteClub(String id) {
		for (int i = 0; i < clubs.size(); i++) {
			if(clubs.get(i).getId().equals(id)) {
				clubs.remove(i);
			}
		}
	}
	
	public void orderPetNames() {
		for (int i = 0; i < clubs.size(); i++) {
			clubs.get(i).orderPetNames();
		}
	}
	public void orderPetId() {
		for (int i = 0; i < clubs.size(); i++) {
			clubs.get(i).orderPetId();;
		}
	}
	public void orderPetSex() {
		for (int i = 0; i < clubs.size(); i++) {
			clubs.get(i).orderPetSex();
		}
	}
	public void orderPetBirth() {
		for (int i = 0; i < clubs.size(); i++) {
			clubs.get(i).orderPetBirth();
		}
	}
	public void orderPetType() {
		for (int i = 0; i < clubs.size(); i++) {
			clubs.get(i).orderPetType();
		}
	}
	
	public void orderOwnerNames() {
		for (int i = 0; i < clubs.size(); i++) {
			clubs.get(i).orderOwnerNames();
		}
	}
	public void orderOwnerLastName() {
		for (int i = 0; i < clubs.size(); i++) {
			clubs.get(i).orderOwnerLastName();
		}
	}
	public void orderOwnerId() {
		for (int i = 0; i < clubs.size(); i++) {
			clubs.get(i).orderOwnerId();
		}
	}
	public void orderOwnerBirth() {
		for (int i = 0; i < clubs.size(); i++) {
			clubs.get(i).orderOwnerBirth();
		}
	}
	public void orderOwnerPetType() {
		for (int i = 0; i < clubs.size(); i++) {
			clubs.get(i).orderOwnerPetType();
		}
	}
	
	public void addPet(Pet p, String idOwner) {
		for(int i=0; i<clubs.size(); i++) {
			if(clubs.get(i).sameOwnerId(idOwner)) {
				clubs.get(i).addPet(p, idOwner);
			}
		}
	}
	
	public String showClubs() {
		String msg = "";
		for (int i = 0; i < clubs.size(); i++) {
			msg += clubs.get(i).toString() + "\n";
		}
		return msg;
	}
	
	public String showAllOwners() {
		String msg = "";
		for (int i = 0; i < clubs.size(); i++) {
			msg += clubs.get(i).showOwners();
		}
		return msg;
	}
	
	public String showOwners(String idClub) {
		String msg = "";
		boolean finded = false;
		for (int i = 0; i < clubs.size() && !finded; i++) {
			if(clubs.get(i).getId().equals(idClub)) {
				msg = clubs.get(i).showOwners();
				finded = true;
			}
		}
		return msg;
	}
	
	public String showAllPets() {
		String msg = "";
		for(int i=0; i < clubs.size(); i++) {
			msg = clubs.get(i).showAllPets();
		}
		return msg;
	}
	
	public String showPet(String idOwner) {
		String msg = "";
		boolean finded = false;
		for (int i = 0; i <clubs.size() && !finded; i++) {
			if(!clubs.get(i).showPet(idOwner).equals("There are not pets")) {
				msg = clubs.get(i).showPet(idOwner);
				finded = true;
			}
		}
		return msg;
	}
}
