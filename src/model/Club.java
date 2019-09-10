package model;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;

public class Club implements Comparable<Club> {
	
	private String id;
	private String name;
	private String creationDate;
	private String petType;
	private ArrayList<Owner> owners;
	/**
	 * @param id
	 * @param name
	 * @param creationDate
	 * @param petType
	 * @throws IOException 
	 */
	public Club(String id, String name, String creationDate, String petType) {
		this.id = id;
		this.name = name;
		this.creationDate = creationDate;
		this.petType = petType;
		owners = new ArrayList<>();
		if(!new File(id).exists()) {
			try {
				new File(id).createNewFile();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		loadData();
	}
	
	/**
	 * @return the name
	 */
	public String getName() {
		return name;
	}
	
	/**
	 * @param name the name to set
	 */
	public void setName(String name) {
		this.name = name;
	}
	
	/**
	 * @return the id
	 */
	public String getId() {
		return id;
	}
	
	/**
	 * @param id the id to set
	 */
	public void setId(String id) {
		this.id = id;
	}
	
	/**
	 * @return the creationDate
	 */
	public String getCreationDate() {
		return creationDate;
	}
	
	/**
	 * @param creationDate the creationDate to set
	 */
	public void setCreationDate(String creationDate) {
		this.creationDate = creationDate;
	}
	
	/**
	 * @return the petType
	 */
	public String getPetType() {
		return petType;
	}
	
	/**
	 * @param petType the petType to set
	 */
	public void setPetType(String petType) {
		this.petType = petType;
	}
	
	/**
	 * @return the owners
	 */
	public ArrayList<Owner> getOwners() {
		return owners;
	}
	
	/**
	 * @param owners the owners to set
	 */
	public void setOwners(ArrayList<Owner> owners) {
		this.owners = owners;
	}

	@Override
	public String toString() {
		return "Club [id=" + id + ", name=" + name + ", creationDate=" + creationDate + ", petType=" + petType
				+ ", owners=" + owners + "]";
	}

	@Override
	public int compareTo(Club c) {
		return owners.size()-c.getOwners().size();
	}
	
	public int compareId(Club c) {
		return id.compareTo(c.getId());
	}
	
	public int compareOwners(Club c) {
		return owners.size() - c.getOwners().size();
	}
	
	public int compareName(Club c) {
		return name.compareTo(c.getName());
	}
	
	public int compareCreacionDate(Club c) {
		return creationDate.compareTo(c.getCreationDate());
	}
	
	public int comparePetType(Club c) {
		return petType.compareTo(c.getPetType());
	}
	
	public boolean sameOwner(Owner o){
		boolean same = false;
		for(int i=0; i<owners.size() && !same; i++){
			if(owners.get(i).compareTo(o) == 0){
				same = true;
			}
		}
		return same;
	}
	
	public void addOwner(Owner o) {
		owners.add(o);
	}
	
	public void orderOwners() {
		for (int  i= 0;  i< owners.size()-1; i++) {
			for (int j = 0; j < owners.size()-1-i; j++) {
				if (owners.get(j).compareTo(owners.get(j+1))>0) {
					Owner tmp = owners.get(j);
					owners.set(j, owners.get(j+1));
					owners.set(j+1, tmp);
				}
			}
		}
	}
	
	public void orderOwnerNames() {
		for (int i = 0; i < owners.size()-1; i++) {
			Owner menor = owners.get(i);
			int cual = i;
			for (int j = i+1; j < owners.size(); j++) {
				if(owners.get(j).compareName(menor)<0) {
					menor = owners.get(j);
					cual = j;
				}
				
			}
			Owner tmp = owners.get(i);
			owners.set(i, menor);
			owners.set(cual, tmp);
		}
	}
	
	public void orderOwnerId() {
		for (int i = 1; i < owners.size(); i++) {
			for (int j = i; j > 0 && owners.get(j-1).compareId(owners.get(j))>0; j--) {
				Owner tmp = owners.get(j);
				owners.set(j, owners.get(j-1));
				owners.set(j-1, tmp);
			}
		}
	}
	
	public void orderOwnerBirth() {
		for (int i = 1; i < owners.size(); i++) {
			for (int j = i; j > 0 && owners.get(j-1).compareBirth(owners.get(j))>0; j--) {
				Owner tmp = owners.get(j);
				owners.set(j, owners.get(j-1));
				owners.set(j-1, tmp);
			}
		}
	}
	
	public void orderOwnerPetType() {
		for (int i = 0; i < owners.size()-1; i++) {
			Owner menor = owners.get(i);
			int cual = i;
			for (int j = i+1; j < owners.size(); j++) {
				if(owners.get(j).comparePetType(menor)<0) {
					menor = owners.get(j);
					cual = j;
				}
				
			}
			Owner tmp = owners.get(i);
			owners.set(i, menor);
			owners.set(cual, tmp);
		}
	}
	
	public void orderOwnerLastName() {
		for (int i = 1; i < owners.size(); i++) {
			for (int j = i; j > 0 && owners.get(j-1).compareLastName(owners.get(j))>0; j--) {
				Owner tmp = owners.get(j);
				owners.set(j, owners.get(j-1));
				owners.set(j-1, tmp);
			}
		}
	}
	
	public void saveData() throws FileNotFoundException, IOException {
		File file = new File(id);
		BufferedWriter writer = new BufferedWriter(new FileWriter(file));
		writer.write("");
		writer.close();
		ObjectOutputStream object = new ObjectOutputStream(new FileOutputStream(file));
		for (int i = 0; i < owners.size(); i++) {
			object.writeObject(owners.get(i));
		}
		object.close();
	}
	
	public void loadData() {
		File file = new File(id);
		try {
			ObjectInputStream object = new ObjectInputStream(new FileInputStream(file));
			owners = (ArrayList<Owner>)object.readObject();
		}catch(Exception exception){
			
		}
	}
	
	public String tradSearchName(String n) {
		String msg = "There is not owner with that name.";
		int count = 0;
		for (int i = 0; i < owners.size(); i++) {
			if(owners.get(i).getName().equals(n)) {
				count++;
			}
		}
		if(count == 1) {
			msg = "There is 1 owner with that same name.";
		}else if(count > 1) {
			msg = "There are " + count + " owners with that same name.";
		}
		
		return msg;
	}
	
	public String tradSearchLastName(String l) {
		String msg = "There is not owner with that last name.";
		int count = 0;
		for (int i = 0; i < owners.size(); i++) {
			if(owners.get(i).getLastName().equals(l)) {
				count++;
			}
		}
		if(count == 1) {
			msg = "There is 1 owner with that same last name.";
		}else if(count > 1) {
			msg = "There are " + count + " owners with that same last name.";
		}
		
		return msg;
	}
	
	public String tradSearchId(String identification) {
		String msg = "There is not owner with that identification.";
		int count = 0;
		for (int i = 0; i < owners.size(); i++) {
			if(owners.get(i).getId().equals(identification)) {
				count++;
			}
		}
		if(count == 1) {
			msg = "There is 1 owner with that same identification.";
		}else if(count > 1) {
			msg = "There are " + count + " owners with that same identification.";
		}
		
		return msg;
	}
	
	public String tradSearchBirth(String birthD) {
		String msg = "There is not owner with that birth date.";
		int count = 0;
		for (int i = 0; i < owners.size(); i++) {
			if(owners.get(i).getBirth().equals(birthD)) {
				count++;
			}
		}
		if(count == 1) {
			msg = "There is 1 owner with that same birth date.";
		}else if(count > 1) {
			msg = "There are " + count + " owners with that same birth date.";
		}
		
		return msg;
	}
	
	public String tradSearchType(String petType) {
		String msg = "There is not owner with that type.";
		int count = 0;
		for (int i = 0; i < owners.size(); i++) {
			if(owners.get(i).getPetType().equals(petType)) {
				count++;
			}
		}
		if(count == 1) {
			msg = "There is 1 owner with that same type.";
		}else if(count > 1) {
			msg = "There are " + count + " owners with that same type.";
		}
		
		return msg;
	}
	
	public boolean binSearchName(String n) {
		boolean finded = false;
		int i = 0;
		int fin = owners.size()-1;
		while(i <= fin && !finded) {
			int mid = (i+fin)/2;
			if(owners.get(mid).getName().equals(n)) {
				finded = true;
			}
			else if(owners.get(mid).getName().compareTo(n)>0) {
				fin = mid - 1;
			}
			else {
				i = mid + 1;
			}
		}
		return finded;
	}
	
	public boolean binSearchLastName(String l) {
		boolean finded = false;
		int i = 0;
		int fin = owners.size()-1;
		while(i <= fin && !finded) {
			int mid = (i+fin)/2;
			if(owners.get(mid).getLastName().equals(l)) {
				finded = true;
			}
			else if(owners.get(mid).getLastName().compareTo(l)>0) {
				fin = mid - 1;
			}
			else {
				i = mid + 1;
			}
		}
		return finded;
	}
	
	public boolean binSearchId(String identification) {
		boolean finded = false;
		int i = 0;
		int fin = owners.size()-1;
		while(i <= fin && !finded) {
			int mid = (i+fin)/2;
			if(owners.get(mid).getId().equals(identification)) {
				finded = true;
			}
			else if(owners.get(mid).getId().compareTo(identification)>0) {
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
		int fin = owners.size()-1;
		while(i <= fin && !finded) {
			int mid = (i+fin)/2;
			if(owners.get(mid).getBirth().equals(birthDate)) {
				finded = true;
			}
			else if(owners.get(mid).getBirth().compareTo(birthDate)>0) {
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
		int fin = owners.size()-1;
		while(i <= fin && !finded) {
			int mid = (i+fin)/2;
			if(owners.get(mid).getPetType().equals(type)) {
				finded = true;
			}
			else if(owners.get(mid).getPetType().compareTo(type)>0) {
				fin = mid - 1;
			}
			else {
				i = mid + 1;
			}
		}
		return finded;
	}
	
	public String tradSearchNamePet(String n) {
		String msg = "";
		for (int i = 0; i < owners.size(); i++) {
			msg = owners.get(i).tradSearchName(n);
		}
		return msg;
	}
	public String tradSearchIdPet(String n) {
		String msg = "";
		for (int i = 0; i < owners.size(); i++) {
			msg = owners.get(i).tradSearchId(n);
		}
		return msg;
	}
	public String tradSearchSexPet(int n) {
		String msg = "";
		for (int i = 0; i < owners.size(); i++) {
			msg = owners.get(i).tradSearchSex(n);
		}
		return msg;
	}
	public String tradSearchTypePet(String n) {
		String msg = "";
		for (int i = 0; i < owners.size(); i++) {
			msg = owners.get(i).tradSearchType(n);
		}
		return msg;
	}
	public String tradSearchBirthPet(String n) {
		String msg = "";
		for (int i = 0; i < owners.size(); i++) {
			msg = owners.get(i).tradSearchBirth(n);
		}
		return msg;
	}
}



