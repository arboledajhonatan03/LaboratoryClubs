package model;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileReader;
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
				e.printStackTrace();
			}
		}
		try {
			loadData();
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
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
		return id + "," + name + "," + creationDate + "," + petType;
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
			if(owners.get(i).compareId(o) == 0){
				same = true;
			}
		}
		return same;
	}
	
	public boolean sameOwnerId(String idOwner){
		boolean same = false;
		for(int i=0; i<owners.size() && !same; i++){
			if(owners.get(i).getId().equals(idOwner)){
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
	
	public void loadData() throws FileNotFoundException, IOException, ClassNotFoundException {
		File file = new File(id);
		ObjectInputStream object = new ObjectInputStream(new FileInputStream(file));
		Owner aux = (Owner)object.readObject();
		try {
			while(aux != null) {
				owners.add(aux);
				aux = (Owner)object.readObject();
			}
		} catch(Exception e) {
			
		}
		object.close();
	}
	
//	public void loadData() throws FileNotFoundException, IOException, ClassNotFoundException {
//		File file = new File(id + ".csv");
//		BufferedReader breader = new BufferedReader(new FileReader(file));
//		String line;
//		File f1 = new File(id);
//		ObjectOutputStream object = new ObjectOutputStream(new FileOutputStream(f1));
//		try {
//			while((line = breader.readLine()) != null) {
//				if(!line.equals("name,lastName,id,birth,typePet,namePet,idPet,sexPet,type,birthDate")) {
//					String[] s = line.split(",");
//					Owner o = new Owner(s[0], s[1], s[2], s[3], s[4]);
//					Pet p = new Pet(s[5], s[6], Integer.parseInt(s[7]), s[8], s[9]);
//					o.addPet(p);
//					owners.add(o);
//					object.writeObject(o);
//				}
//			}
//		} catch(IndexOutOfBoundsException e) {
//			
//		}
//		object.close();
//		breader.close();
//	}
	
	public boolean tradSearchName(String n) {
		boolean founded = false;
		for (int i = 0; i < owners.size() && !founded; i++) {
			if(owners.get(i).getName().equals(n)) {
				founded = true;
			}
		}
		return founded;
	}
	
	public boolean tradSearchLastName(String l) {
		boolean founded = false;
		for (int i = 0; i < owners.size() && !founded; i++) {
			if(owners.get(i).getLastName().equals(l)) {
				founded = true;
			}
		}
		return founded;
	}
	
	public boolean tradSearchId(String identification) {
		boolean founded = false;
		for (int i = 0; i < owners.size() && !founded; i++) {
			if(owners.get(i).getId().equals(identification)) {
				founded = true;
			}
		}
		return founded;
	}
	
	public boolean tradSearchBirth(String birthD) {
		boolean founded = false;
		for (int i = 0; i < owners.size() && !founded; i++) {
			if(owners.get(i).getBirth().equals(birthD)) {
				founded = true;
			}
		}
		return founded;
	}
	
	public boolean tradSearchType(String petType) {
		boolean founded = false;
		for (int i = 0; i < owners.size() && !founded; i++) {
			if(owners.get(i).getPetType().equals(petType)) {
				founded = true;
			}
		}
		return founded;
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
	
	public boolean tradSearchNamePet(String n) {
		boolean founded = false;
		for (int i = 0; i < owners.size() && !founded; i++) {
			founded = owners.get(i).tradSearchName(n);
		}
		return founded;
	}
	public boolean tradSearchIdPet(String n) {
		boolean founded = false;
		for (int i = 0; i < owners.size() && !founded; i++) {
			founded = owners.get(i).tradSearchId(n);
		}
		return founded;
	}
	public boolean tradSearchSexPet(int n) {
		boolean founded = false;
		for (int i = 0; i < owners.size() && !founded; i++) {
			founded = owners.get(i).tradSearchSex(n);
		}
		return founded;
	}
	public boolean tradSearchTypePet(String n) {
		boolean founded = false;
		for (int i = 0; i < owners.size() && !founded; i++) {
			founded = owners.get(i).tradSearchType(n);
		}
		return founded;
	}
	public boolean tradSearchBirthPet(String n) {
		boolean founded = false;
		for (int i = 0; i < owners.size() && !founded; i++) {
			founded = owners.get(i).tradSearchBirth(n);
		}
		return founded;
	}
	
	
	public boolean binSearchNamePet(String n) {
		boolean exist = false;
		for (int i = 0; i < owners.size() && !exist; i++) {
			exist = owners.get(i).binSearchName(n);
		}
		return exist;
	}
	public boolean binSearchIdPet(String n) {
		boolean exist = false;
		for (int i = 0; i < owners.size() && !exist; i++) {
			exist = owners.get(i).binSearchId(n);
		}
		return exist;
	}
	public boolean binSearchSexPet(int n) {
		boolean exist = false;
		for (int i = 0; i < owners.size() && !exist; i++) {
			exist = owners.get(i).binSearchSex(n);
		}
		return exist;
	}
	public boolean binSearchTypePet(String n) {
		boolean exist = false;
		for (int i = 0; i < owners.size() && !exist; i++) {
			exist = owners.get(i).binSearchType(n);
		}
		return exist;
	}
	public boolean binSearchBirthPet(String n) {
		boolean exist = false;
		for (int i = 0; i < owners.size() && !exist; i++) {
			exist = owners.get(i).binSearchBirth(n);
		}
		return exist;
	}
	
	public void deletePet(String id) {
		for (int i = 0; i < owners.size(); i++) {
			owners.get(i).deletePet(id);
		}
	}
	
	public void deleteOwner(String id) {
		for (int i = 0; i < owners.size(); i++) {
			if(owners.get(i).getId().equals(id)) {
				owners.remove(i);
			}
		}
	}
	
	public void orderPetNames() {
		for (int i = 0; i < owners.size(); i++) {
			owners.get(i).orderPetNames();
		}
	}
	public void orderPetId() {
		for (int i = 0; i < owners.size(); i++) {
			owners.get(i).orderPetId();;
		}
	}
	public void orderPetSex() {
		for (int i = 0; i < owners.size(); i++) {
			owners.get(i).orderPetSex();
		}
	}
	public void orderPetBirth() {
		for (int i = 0; i < owners.size(); i++) {
			owners.get(i).orderPetBirth();
		}
	}
	public void orderPetType() {
		for (int i = 0; i < owners.size(); i++) {
			owners.get(i).orderPetType();
		}
	}
	
	public void addPet(Pet p, String idOwner) {
		boolean founded = false;
		for(int i=0; i < owners.size() && !founded; i++) {
			if(owners.get(i).getId().equals(idOwner)) {
				founded = true;
				owners.get(i).addPet(p);
			}
		}
	}
	
	public String showOwners() {
		String msg = "";
		for (int i = 0; i < owners.size(); i++) {
			msg += owners.get(i).toString() + "\n";
		}
		return msg;
	}
	
	public String showAllPets() {
		String msg = "";
		for (int i = 0; i < owners.size(); i++) {
			msg += owners.get(i).showPets();
		}
		return msg;
	}
	
	public String showPet(String idOwner) {
		String msg = "";
		boolean finded = false;
		for (int i = 0; i < owners.size() && !finded; i++) {
			if(owners.get(i).getId().equals(idOwner)) {
				msg = owners.get(i).showPets();
				finded = true;
			}
		}
		return msg;
	}
}



