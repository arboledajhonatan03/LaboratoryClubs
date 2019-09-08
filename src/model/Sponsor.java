package model;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

public class Sponsor {

	public static final String ARCHIVE_PLANE = "C:\\Users\\KD35\\Documents\\ws\\LaboratoryClubs\\archivo1.csv";
	public static final String ARCHIVE_SERIALIZABLE = "C:\\Users\\KD35\\Documents\\ws\\Club\\Owners.txt";
	
	private ArrayList<Club> clubs;
	
	public Sponsor() throws ClassNotFoundException, IOException {
		clubs = new ArrayList<>();
		loadData();
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
			throw new SameObject();
		}
	}
	
	public void addClub(Club c) {
		clubs.add(c);
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
	
	public void orderOwnerPetType() {
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
}
