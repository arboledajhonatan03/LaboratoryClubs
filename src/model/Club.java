package model;

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
	 */
	public Club(String id, String name, String creationDate, String petType) {
		this.id = id;
		this.name = name;
		this.creationDate = creationDate;
		this.petType = petType;
		owners = new ArrayList<>();
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
	public int compareTo(Club c) {
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
		
	}
}

