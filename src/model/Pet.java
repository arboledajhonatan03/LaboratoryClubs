package model;

import java.io.Serializable;

public class Pet implements Serializable {
	
	public static final int MALE = 1;
	public static final int FEMALE = 2;
	
	private String name;
	private String id;
	private int sex;
	private String type;
	private String birth;
	
	
	
	/**
	 * @param name
	 * @param id
	 * @param sex
	 * @param type
	 * @param birth
	 */
	public Pet(String name, String id, int sex, String type, String birth) {
		this.name = name;
		this.id = id;
		this.sex = sex;
		this.type = type;
		this.birth = birth;
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
	 * @return the sex
	 */
	public int getSex() {
		return sex;
	}

	/**
	 * @param sex the sex to set
	 */
	public void setSex(int sex) {
		this.sex = sex;
	}

	/**
	 * @return the type
	 */
	public String getType() {
		return type;
	}

	/**
	 * @param type the type to set
	 */
	public void setType(String type) {
		this.type = type;
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
	 * @param p the pet to evalue
	 * @return the result of compare names
	 */
	public int compareName(Pet p) {
		return name.compareTo(p.getName());
	}
	
	/**
	 * @param p the pet to evalue
	 * @return the result of compare ids
	 */
	public int compareId(Pet p) {
		return id.compareTo(p.getId());
	}
	
	/**
	 * @param p the pet to evalue
	 * @return the result of compare types
	 */
	public int compareType(Pet p) {
		return type.compareTo(p.getType());
	}
	
	/**
	 * @param p the pet to evalue
	 * @return the result of compare birth dates
	 */
	public int compareBirth(Pet p) {
		return birth.compareTo(p.getBirth());
	}
	
	/**
	 * @param p the pet to evalue
	 * @return the result of compare the sex
	 */
	public int compareSex(Pet p) {
		return sex-p.getSex();
	}
}