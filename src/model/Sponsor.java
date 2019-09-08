package model;

import java.util.ArrayList;

public class Sponsor {

	public static final String ARCHIVO_PLANO = "C:\\Users\\KD35\\Documents\\ws\\LaboratoryClubs\\archivo1.csv";
	public static final String ARCHIVO_SERIALIZABLE = "C:\\Users\\KD35\\Documents\\ws\\Club\\Owners.txt";
	
	private ArrayList<Club> clubs;
	
	public Sponsor() {
		clubs = new ArrayList<>();
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
}
