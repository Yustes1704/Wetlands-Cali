package model;
import java.time.LocalDate;
public class Dagma {
	public static final int WETS = 80;
	public static final int SPECIES = 80;
	//atributes
	private String name;

	//relations
	private Wetland[] wetlandArray;

	//methods
	
	/**
	 * Crea el objeto controlador. <br>
	 * @param name
	 */
	public Dagma(String name) {
		wetlandArray = new Wetland[WETS];
		this.name = name;
	}

	/**
	 * Registra el humedal. <br>
	 * @param name
	 * @param typ
	 * @param ubi
	 * @param url
	 * @param protecte
	 * @param km
	 * @return Retorna mensaje confirmando el registro.
	 */
	public String addWetland(String name, int typ, int ubi, String url, int protecte, double km) {
		int confirmation = difference(name);
		String message = "Humedal registrado.";
		if (confirmation == 0) {
			boolean cont = true;
			for(int i = 0; i < WETS && cont != false; i++) {
				if(wetlandArray[i] == null) {
					wetlandArray[i] = new Wetland(name, typ, ubi, url, protecte, km);
				}
			}
		} else {
			message = "Humedal ya existe";
		}
		return message;
	}

	/**
	 * Analiza si hay un humedal con el mismo nombre. <br>
	 * @param name
	 * @return Retorna un entero para saber si hay un humedal con el mismo nombre.
	 */
	public int difference(String name){
		int same = 0;
		boolean cont = true;
		for(int i = 0;i<WETS && cont != false && wetlandArray[i]!=null;i++){
			if(wetlandArray[i].getName().equalsIgnoreCase(name)){
				same = 1;
				cont = false;
			}
		}
		return same;
	}

	/**
	 * Validamos si el humedal ingresado por el usuario existe. <br>
	 * @param name
	 * @return Retorna mensaje confirmando la existencia.
	 */
	public String wetlandExist(String name) {
		boolean flag = true;
		String message = "";
		for(int i = 0; i < WETS && wetlandArray[i] != null && flag != false; i++) {
			if (wetlandArray[i].getName().equalsIgnoreCase(name)) {
				message = "Se ha encontrado el humedal";
				flag =  false;
			} else {
				message = "No existe el humedal.";
			}
		}
		return message;
	}
	
	/**
	 * Se valida un espacio para la especie y se envia a la clase Wetland para que sea registrada. <br>
	 * @param species
	 * @param sciName
	 * @param migrat
	 * @param sType
	 * @return Retorna mensaje confirmando el registro.
	 */
	public String addSpecie(String species, String sciName, int migrat, int sType) {
		String message = "";
		boolean cont = true;
		for(int i = 0; i < WETS && wetlandArray[i] != null && cont != false; i++) {
		message = wetlandArray[i].addSpecie(species, sciName, migrat, sType);
		}
		return message;
	}
	
	/**
	 * Se valida un espacio para el evento y se envia a la clase Wetland para que sea registrado. <br>
	 * @param person
	 * @param eType
	 * @param price
	 * @param descrip
	 * @param fecha
	 * @return Retorna mensaje confirmando el registro.
	 */
	public String addEvent(String person, int eType, double price, String descrip, LocalDate fecha) {
		String message = "";
		boolean cont = true;
		for(int i = 0; i < WETS && wetlandArray[i] != null && cont != false; i++) {
		message = wetlandArray[i].addEvent(person, eType, price, descrip, fecha);
		}
		return message;
	}
	
	/**
	 * Recorre el arreglo de humedales para luego enviar a la clase Wetland y calcule el total de mantenimientos. <br>
	 * @param mYear
	 * @return Retorna mensaje con el numero de mantenimientos total.
	 */
	public String maintenancee(int mYear) {
		int cont = 0;
		String message = "";
		int maxValue = 0;
		for(int i = 0; i < WETS; i++) {
			cont = wetlandArray[i].maintenance(mYear);
			if (cont > maxValue) {
				maxValue = cont;
				message = ("El numero de mantenimientos en el anio es de " + maxValue);
			}
		}
		return message;
	}
	
	/**
	 * Busca el nombre del humedal. <br>
	 * @param wet
	 * @return Retorna toda la informacion respecto al humedal.
	 */
	public String wetlandInfo(String wet) {
		boolean cont = true;
		String message = "";
		for(int i = 0; i < WETS && wetlandArray[i] != null && cont != false; i++) {
			if(wetlandArray[i].getName().equalsIgnoreCase(wet)) {
				message = ("El nombre del humedal es " +wetlandArray[i].getName() +". Tiene " +wetlandArray[i].getKm() +"km2. " +"Siendo una ubicacion " +wetlandArray[i].getUbication() +". De tipo " +wetlandArray[i].getType() +". Y un URL " +wetlandArray[i].getUrl());
			}
		}
		return message;	
	}
	
	/**
	 * Calcula el humedal con mas animales. <br>
	 * @return Retorna mensaje con el humedal con mas animales.
	 */
	public String mostSpecies() {
		String message = "";
		int cont = 0;
		Wetland maxWetland = null;
		int maxValue = 0;
		for(int i = 0; i < WETS; i++) {
			cont = wetlandArray[i].mostSpecies();
			if (cont > maxValue) {
				maxValue = cont;
				maxWetland = wetlandArray[i];
				message = ("El humedal con mas animales es " + maxWetland);
			}
		}
		return message;
	}
	
	/**
	 * Calcula el humedal con mas animales. <br>
	 * @return Retorna mensaje con el humedal con mas animales.
	 */
	public String lessSpecies() {
		String message = "";
		int cont = 0;
		Wetland minWetland = null;
		int minValue = 99;
		for(int i = 0; i < WETS; i++) {
			cont = wetlandArray[i].lessSpecies();
			if (cont < minValue) {
				minValue = cont;
				minWetland = wetlandArray[i];
				message = ("El humedal con menos animales es " + minWetland);
			}
		}
		return message;
	}
	
	/**
	 * Recorre el arreglo de humedales y envia informacion a la clase Wetland, y esta le devuelve el numero total. <br>
	 * @param specie
	 * @return Retorna mensaje con el total de humedales.
	 */
	public String specieWetland(String specie) {
		String message = "";
		int cont = 0;
		for(int i = 0; i < WETS; i++) {
			cont = wetlandArray[i].specieWetland(specie);
				message = ("La cantidad de humedales con la especie son: " +cont);
			}
		return message;
	}
}