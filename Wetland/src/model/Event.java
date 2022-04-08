package model;
import java.time.LocalDate;
public class Event {

	//atributes
	private String person;
	private double price;
	private String descrip;
	
	//relations
	private LocalDate fecha;
	private EventType type;
	
	//methods
	
	/**
	 * Crea un evento. <br>
	 * @param person
	 * @param eType
	 * @param price
	 * @param descrip
	 * @param fecha
	 */
	public Event(String person, int eType, double price, String descrip, LocalDate fecha) {
		this.person = person;
		this.price = price;
		this.descrip = descrip;
		this.fecha = fecha;
		
		switch (eType) {
		case 1:
			type = EventType.MANTENIMIENTO;
			break;
		case 2:
			type = EventType.COLEGIO;
			break;
		case 3:
			type = EventType.MEJORAMIENTO;
			break;
		case 4:
			type = EventType.CELEBRACIONES;
			break;
		}
	}

	public String getPerson() {
		return person;
	}

	public void setPerson(String person) {
		this.person = person;
	}

	public double getPrice() {
		return price;
	}

	public void setPrice(double price) {
		this.price = price;
	}

	public String getDescrip() {
		return descrip;
	}

	public void setDescrip(String descrip) {
		this.descrip = descrip;
	}

	public LocalDate getFecha() {
		return fecha;
	}

	public void setFecha(LocalDate fecha) {
		this.fecha = fecha;
	}

	public EventType getType() {
		return type;
	}

	public void setType(EventType type) {
		this.type = type;
	}	
}