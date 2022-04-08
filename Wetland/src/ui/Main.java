import java.util.Scanner;
import java.time.LocalDate;
import model.*;
/**
 * @author Juan Yustes <br>
 * @year 2022
 */

public class Main {
	public static final Scanner TECLADO = new Scanner(System.in);
	public static Dagma dagma = new Dagma("Dagma");
	
	public static void main(String []ar) {

		int menu;
		do {
		System.out.println("Hola! ¿Qué deseas hacer?:");
		System.out.println("1. Registrar un humedal.");
		System.out.println("2. Registrar una especie.");
		System.out.println("3. Registrar un evento.");
		System.out.println("4. Informar los mantenimientos en un anio.");
		System.out.println("5. Desplegar el humedal con menos especies.");
		System.out.println("6. En qué humedales se encuentra una especie.");
		System.out.println("7. Información los humedales.");
		System.out.println("8. Desplegar humedal con más especies.");
		menu=TECLADO.nextInt();
		TECLADO.nextLine();

			switch (menu){
			case 1:
				registerWetland();
				break;
			case 2:
				registerSpecie();
				break;
			case 3:
				registerEvent();
				break;
			case 4:
				maintenance();
				break;
			case 5:
				lessSpecies();
				break;
			case 6:
				specieWetland();
				break;
			case 7:
				wetlandInfo();
				break;
			case 8:
				mostSpecies();
			}
		} while(menu<9);
	}
	
	/**
	 * Se piden los datos para registrar un humedal. <br>
	 */
	public static void registerWetland() {
		System.out.println("Ingresa el nombre del humedal: ");
		String name = TECLADO.nextLine();
		System.out.println("Ingresa la zona (1. Rural  2. Urbana): ");
		int ubi = TECLADO.nextInt();
		System.out.println("Ingresa: 1. Publico.  2. Privado. ");
		int typ = TECLADO.nextInt();
		System.out.println("Ingresa la cantidad de km2: ");
		double km = TECLADO.nextDouble();
		TECLADO.nextLine();
		System.out.println("Ingresa el URL de la foto: ");
		String url = TECLADO.nextLine();
		System.out.println("Ingresa: 1. Si esta protegida.  2. Si no lo esta. ");
		int protecte = TECLADO.nextInt();
		String message = dagma.addWetland(name, typ, ubi, url, protecte, km);
		System.out.println(message);
	}
	
	/**
	 * Se piden los datos para registrar una especie. <br>
	 */
	public static void registerSpecie() {
		System.out.println("Ingresa el nombre del humedal al que le agregaras una especie: ");
		String name = TECLADO.nextLine();
		System.out.println("Ingresa el nombre de la especie: ");
		String species = TECLADO.nextLine();
		System.out.println("Ingresa el nombre cientifico de la especie: ");
		String sciName = TECLADO.nextLine();
		System.out.println("Ingresa: 1. Si es migratoria.  2. Si no es migratoria.");
		int migrat = TECLADO.nextInt();
		System.out.println("Ingresa: 1. Flora acuatica.  2. flora terrestre.  3. Ave.  4. Mamifero.  5. Acuatico");
		int sType = TECLADO.nextInt();
		String message = dagma.addSpecie(species, sciName, migrat, sType);
		System.out.println(message);
	}
	
	/**
	 * Se piden los datos para registrar un evento.
	 */
	public static void registerEvent() {
		System.out.println("Ingresa el nombre del humedal al que le agregaras un evento: ");
		String name = TECLADO.nextLine();
		System.out.println("Ingresa el nombre de la persona encargada: ");
		String person = TECLADO.nextLine();
		System.out.println("Ingresa: 1. Mantenimiento.  2. Colegio.  3. Mejoramiento.  4. Celebraciones.");
		int eType = TECLADO.nextInt();
		System.out.println("Ingresa el precio del evento: ");
		double price = TECLADO.nextDouble();
		TECLADO.nextLine();
		System.out.println("Ingresa la descripcion del evento: ");
		String descrip = TECLADO.nextLine();
		System.out.println("Ingresa el dia del evento (dd)");
		int day = TECLADO.nextInt();
		System.out.println("Ingresa el mes del evento (mm)");
		int month = TECLADO.nextInt();
		System.out.println("Ingresa el anio del evento (yy)");
		int year = TECLADO.nextInt();
		LocalDate fecha = LocalDate.of(year, month, day);
		String message = dagma.addEvent(person, eType, price, descrip, fecha);
		System.out.println(message);
	}
	
	/**
	 * Se pide el anio del cual quiere conocer los mantenimientos. <br>
	 */
	public static void maintenance() {
		System.out.println("Ingresa el anio que deseas conocer: ");
		int mYear = TECLADO.nextInt();
		String message = dagma.maintenancee(mYear);
		System.out.println(message);
	}
	
	/**
	 * Se pide el nombre del humedal el cual se desea saber la informacion. <br>
	 */
	public static void wetlandInfo() {
		System.out.println("Ingresa el humedal del que deseas conocer su informacion: ");
		String wet = TECLADO.nextLine();
		String mensaje = dagma.wetlandExist(wet);
		System.out.println(mensaje);
		String message = dagma.wetlandInfo(wet);
		System.out.println(message);
	}
	
	public static void mostSpecies() {
		String message = dagma.mostSpecies();
		System.out.println(message);
	}
	
	public static void lessSpecies() {
		String message = dagma.lessSpecies();
		System.out.println(message);
	}
	
	/**
	 * Se pide el nombre de la especie la cual se busca. <br>
	 */
	public static void specieWetland() {
		System.out.println("Ingresa el nombre de la especie que deseas buscar: ");
		String specie =TECLADO.nextLine();
		String message = dagma.specieWetland(specie);
		System.out.println(message);
	}
}