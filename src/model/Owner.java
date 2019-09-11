package model;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Comparator;

public class Owner implements Serializable, Comparable<Owner>, Comparator<Owner> {
	
	private String name;
	private String lastName;
	private String id;
	private String birth;
	private String petType;
	private ArrayList<Pet> pets;
	
	/**
	 * @param name
	 * @param lastName
	 * @param id
	 * @param birth
	 * @param petType
	 */
	public Owner(String name, String lastName, String id, String birth, String petType) {
		this.name = name;
		this.lastName = lastName;
		this.id = id;
		this.birth = birth;
		this.petType = petType;
		pets = new ArrayList<>();
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
	 * @return the lastName
	 */
	public String getLastName() {
		return lastName;
	}
	
	/**
	 * @param lastName the lastName to set
	 */
	public void setLastName(String lastName) {
		this.lastName = lastName;
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
	 * @return the birth
	 */
	public String getBirth() {
		return birth;
	}
	
	/**
	 * @param birth the birth to set
	 */
	public void setBirth(String birth) {
		this.birth = birth;
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
	 * @return the pets
	 */
	public ArrayList<Pet> getPets() {
		return pets;
	}

	/**
	 * @param pets the pets to set
	 */
	public void setPets(ArrayList<Pet> pets) {
		this.pets = pets;
	}

	@Override
	public int compareTo(Owner o) {
		return pets.size()-o.getPets().size();
	}
	
	/**
	 * @param p the pet to evalue
	 * @return the result of compare names
	 */
	public int compareName(Owner o) {
		return name.compareTo(o.getName());
	}
	
	/**
	 * @param p the pet to evalue
	 * @return the result of compare ids
	 */
	public int compareId(Owner o) {
		return id.compareTo(o.getId());
	}
	
	/**
	 * @param p the pet to evalue
	 * @return the result of compare lastnames
	 */
	public int compareLastName(Owner o) {
		return lastName.compareTo(o.getLastName());
	}
	
	/**
	 * @param p the pet to evalue
	 * @return the result of compare birth dates
	 */
	public int compareBirth(Owner o) {
		return birth.compareTo(o.getBirth());
	}
	
	/**
	 * @param p the pet to evalue
	 * @return the result of compare pet types
	 */
	public int comparePetType(Owner o) {
		return petType.compareTo(o.getPetType());
	}
	
	public void addPet(Pet p){
		boolean equal = false;
		for(int i=0; i<pets.size() && !equal; i++){
			if(!(pets.get(i).compareName(p)==0)){
				pets.add(p);
			}
		}
	}
	
	public void orderPetNames() {
		for (int i = 0; i < pets.size()-1; i++) {
			Pet menor = pets.get(i);
			int cual = i;
			for (int j = i+1; j < pets.size(); j++) {
				if(pets.get(j).compareName(menor)<0) {
					menor = pets.get(j);
					cual = j;
				}
				
			}
			Pet tmp = pets.get(i);
			pets.set(i, menor);
			pets.set(cual, tmp);
		}
	}
	
	@Override
	public String toString() {
		return "name= \t" + name + ",\t id= \t" + id + ",\t lastName= " + lastName + ",\t creationDate= \t" + birth + ",\t petType= \t" + petType
				+ ",\t pets= \t" + pets + "";
	}

	public void orderPetId() {
		for (int i = 1; i < pets.size(); i++) {
			for (int j = i; j > 0 && pets.get(j-1).compareId(pets.get(j))>0; j--) {
				Pet tmp = pets.get(j);
				pets.set(j, pets.get(j-1));
				pets.set(j-1, tmp);
			}
		}
	}
	
	public void orderPetSex() {
		for (int  i= 0;  i< pets.size()-1; i++) {
			for (int j = 0; j < pets.size()-1-i; j++) {
				if (pets.get(j).compareSex(pets.get(j+1))>0) {
					Pet tmp = pets.get(j);
					pets.set(j, pets.get(j+1));
					pets.set(j+1, tmp);
				}
			}
		}
	}
	
	public void orderPetType() {
		for (int i = 0; i < pets.size()-1; i++) {
			Pet menor = pets.get(i);
			int cual = i;
			for (int j = i+1; j < pets.size(); j++) {
				if(pets.get(j).compareType(menor)<0) {
					menor = pets.get(j);
					cual = j;
				}
				
			}
			Pet tmp = pets.get(i);
			pets.set(i, menor);
			pets.set(cual, tmp);
		}
	}
	
	public void orderPetBirth() {
		for (int i = 1; i < pets.size(); i++) {
			for (int j = i; j > 0 && pets.get(j-1).compareBirth(pets.get(j))>0; j--) {
				Pet tmp = pets.get(j);
				pets.set(j, pets.get(j-1));
				pets.set(j-1, tmp);
			}
		}
	}
	
	public boolean tradSearchName(String n) {
		boolean founded = false;
		for (int i = 0; i < pets.size() && !founded; i++) {
			if(pets.get(i).getName().equals(n)) {
				founded = true;
			}
		}
		return founded;
	}
	
	public boolean tradSearchId(String Id) {
		boolean founded = false;
		for (int i = 0; i < pets.size() && !founded; i++) {
			if(pets.get(i).getId().equals(Id)) {
				founded = true;
			}
		}
		return founded;
	}
	
	public boolean tradSearchSex(int sex) {
		boolean founded = false;
		for (int i = 0; i < pets.size() && !founded; i++) {
			if(pets.get(i).getSex()==sex) {
				founded = true;
			}
		}
		return founded;
	}
	
	public boolean tradSearchType(String type) {
		boolean founded = false;
		for (int i = 0; i < pets.size() && !founded; i++) {
			if(pets.get(i).getType().equals(type)) {
				founded = true;
			}
		}
		return founded;
	}
	
	public boolean tradSearchBirth(String birthDate) {
		boolean founded = false;
		for (int i = 0; i < pets.size() && !founded; i++) {
			if(pets.get(i).getBirth().equals(birthDate)) {
				founded = true;
			}
		}
		return founded;
	}
	
	public boolean binSearchName(String n) {
		boolean finded = false;
		int i = 0;
		int fin = pets.size()-1;
		while(i <= fin && !finded) {
			int mid = (i+fin)/2;
			if(pets.get(mid).getName().equals(n)) {
				finded = true;
			}
			else if(pets.get(mid).getName().compareTo(n)>0) {
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
		int fin = pets.size()-1;
		while(i <= fin && !finded) {
			int mid = (i+fin)/2;
			if(pets.get(mid).getId().equals(identification)) {
				finded = true;
			}
			else if(pets.get(mid).getId().compareTo(identification)>0) {
				fin = mid - 1;
			}
			else {
				i = mid + 1;
			}
		}
		return finded;
	}
	
	public boolean binSearchSex(int sex) {
		boolean finded = false;
		int i = 0;
		int fin = pets.size()-1;
		while(i <= fin && !finded) {
			int mid = (i+fin)/2;
			if(pets.get(mid).getSex() == sex) {
				finded = true;
			}
			else if(pets.get(mid).getSex()>sex) {
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
		int fin = pets.size()-1;
		while(i <= fin && !finded) {
			int mid = (i+fin)/2;
			if(pets.get(mid).getType().equals(type)) {
				finded = true;
			}
			else if(pets.get(mid).getType().compareTo(type)>0) {
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
		int fin = pets.size()-1;
		while(i <= fin && !finded) {
			int mid = (i+fin)/2;
			if(pets.get(mid).getBirth().equals(birthDate)) {
				finded = true;
			}
			else if(pets.get(mid).getBirth().compareTo(birthDate)>0) {
				fin = mid - 1;
			}
			else {
				i = mid + 1;
			}
		}
		return finded;
	}

	@Override
	public int compare(Owner o1, Owner o2) {
		
		return 0;
	}
	
	public void deletePet(String id) {
		for (int i = 0; i < pets.size(); i++) {
			if(pets.get(i).getId().equals(id)) {
				pets.remove(i);
			}
		}
	}
	
	
}
