package model;

import java.time.LocalDate;

public class Wetland {
	public static final int SPECIES = 100;
	public static final int EVENTS = 100;

	//atributes
	private String name;
	private String url;
	private double km;

	//relations
	private UbicationType ubication;
	private WetlandType type;
	private Protect protectedd;
	private Specie[] speciesArray;
	private Event[] eventsArray;

	//methods

	/**
	 * Crea un nuevo humedal. <br> 
	 * @param name
	 * @param typ
	 * @param ubi
	 * @param url
	 * @param protecte
	 * @param km
	 */
	public Wetland(String name, int typ, int ubi, String url, int protecte, double km) {
		speciesArray = new Specie[SPECIES];
		eventsArray = new Event[EVENTS];
		this.name = name;
		this.url = url;
		this.km = km;

		switch (ubi) {
		case 1:
			ubication = UbicationType.RURAL;
			break;
		case 2:
			ubication = UbicationType.URBAN;
		}

		switch (typ) {
		case 1:
			type = WetlandType.PRIVADO;
			break;
		case 2:
			type = WetlandType.PUBLICO;
		}

		switch (protecte) {
		case 1:
			protectedd = Protect.PROTECTED;
			break;
		case 2:
			protectedd = Protect.NONPROTECTED;
		}
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getUrl() {
		return url;
	}

	public void setUrl(String url) {
		this.url = url;
	}

	public double getKm() {
		return km;
	}

	public void setKm(double km) {
		this.km = km;
	}

	public UbicationType getUbication() {
		return ubication;
	}

	public void setUbication(UbicationType ubication) {
		this.ubication = ubication;
	}

	public WetlandType getType() {
		return type;
	}

	public void setType(WetlandType type) {
		this.type = type;
	}

	public Protect getProtectedd() {
		return protectedd;
	}

	public void setProtectedd(Protect protectedd) {
		this.protectedd = protectedd;
	}

	/**
	 * Agrega una nueva especie. <br>
	 * @param species
	 * @param sciName
	 * @param migrat
	 * @param sType
	 * @return Retorna mensaje confirmando el registro.
	 */
	public String addSpecie(String species, String sciName, int migrat, int sType) {
		int confirmation = difference(species);
		String message = "Especie registrada.";
		if (confirmation == 0) {
			boolean cont = true;
			for(int i = 0; i < SPECIES && cont != false; i++) {
				if(speciesArray[i] == null) {
					speciesArray[i] = new Specie(species, sciName, migrat, sType);
				}
			}
		}
		return message;
	}

	/**
	 * Aqui se valida que no haya una especie con el mismo nombre. <br>
	 * @param species
	 * @return Retorna un entero para saber si existe uno igual.
	 */
	public int difference(String species){
		int same = 0;
		boolean cont = true;
		for(int i = 0;i<SPECIES && cont != false &&speciesArray[i]!=null;i++){
			if(speciesArray[i].getSpecies().equalsIgnoreCase(species)){
				same = 1;
				cont = false;
			}
		}
		return same;
	}

	/**
	 * Agrega un nuevo evento. <br>
	 * @param person
	 * @param eType
	 * @param price
	 * @param descrip
	 * @param fecha
	 * @return Retorna mensaje confirmando el registro.
	 */
	public String addEvent(String person, int eType, double price, String descrip, LocalDate fecha) {
		String message = "Evento registrado.";
		boolean cont = true;
		for(int i = 0; i < EVENTS && cont != false; i++) {
			if(eventsArray[i] == null) {
				eventsArray[i] = new Event(person, eType, price, descrip, fecha);
			}
		}
		return message;
	}

	/**
	 * Se cuenta cuantos mantenimiento se hicieron en el anio. <br>
	 * @param mYear
	 * @return Retorna el numero de mantenimientos.
	 */
	public int maintenance(int mYear) {
		int cont = 0;
		for(int i = 0; i < EVENTS; i++) {
			if(eventsArray[i] != null && eventsArray[i].getType() == EventType.MANTENIMIENTO && eventsArray[i].getFecha().getYear() == mYear) {
				cont = cont+1;
			}
		}
		return cont;
	}

	/**
	 * Validamos cuantas especies hay. <br>
	 * @return Retorna el numero de especies.
	 */
	public int mostSpecies() {
		int cont = 0;
		for(int i = 0; i < SPECIES; i++) {
			if(speciesArray[i] != null) {
				cont = cont+1;
			}
		}
		return cont;
	}

	/**
	 * Validamos cuantas especies hay. <br>
	 * @return Retorna el numero de especies.
	 */
	public int lessSpecies() {
		int cont = 0;
		for(int i = 0; i < SPECIES; i++) {
			if(speciesArray[i] != null) {
				cont = cont+1;
			}
		}
		return cont;
	}

	/**
	 * Se recorre el arreglo de especies y cada vez que encuentra una especie con el mismo nombre a la buscada, suma al contador. <br>
	 * @param specie
	 * @return Retorna el numero total.
	 */
	public int specieWetland(String specie) {
		int cont = 0;
		for(int i = 0; i < SPECIES; i++) {
			if(speciesArray[i].getSpecies().equals(specie)) {
				cont = cont + 1;
			}
		}
		return cont;
	}
}