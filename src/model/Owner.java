package model;

import java.io.Serializable;
import java.util.ArrayList;

public class Owner implements Serializable, Comparable<Owner> {
	
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
			if(pets.get(i).compareName(p)==0){
				
			}else{
				pets.add(p);
			}
		}
	}
}
