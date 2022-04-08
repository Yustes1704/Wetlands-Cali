package model;
public class Specie {

	//atributes
	private String species;
	private String sciName;
	
	//relations
	private Migratory migra;
	private SpecieType type;
	
	//methods
	
	/**
	 * Crea una especie. <br>
	 * @param species
	 * @param sciName
	 * @param migrat
	 * @param sType
	 */
	public Specie(String species, String sciName, int migrat, int sType) {
		this.species = species;
		this.sciName = sciName;
		
		switch (migrat) {
		case 1:
			migra = Migratory.MIGRATOR;
			break;
		case 2:
			migra = Migratory.NONMIGRATORY;
			break;
		}
		
		switch (sType) {
		case 1:
			type = SpecieType.FLORAACUATICA;
			break;
		case 2:
			type = SpecieType.FLORATERRESTRE;
			break;
		case 3:
			type = SpecieType.AVE;
			break;
		case 4:
			type = SpecieType.MAMIFERO;
			break;
		case 5:
			type = SpecieType.ACUATICO;
			break;
		}
	}

	public String getSpecies() {
		return species;
	}

	public void setSpecies(String species) {
		this.species = species;
	}

	public String getSciName() {
		return sciName;
	}

	public void setSciName(String sciName) {
		this.sciName = sciName;
	}

	public Migratory getMigra() {
		return migra;
	}

	public void setMigra(Migratory migra) {
		this.migra = migra;
	}

	public SpecieType getType() {
		return type;
	}

	public void setType(SpecieType type) {
		this.type = type;
	}
}