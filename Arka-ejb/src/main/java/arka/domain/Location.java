package arka.domain;

import java.io.Serializable;
import javax.persistence.*;

/**
 * Entity implementation class for Entity: Location
 *
 */
@Entity

public class Location implements Serializable {

	
	private static final long serialVersionUID = 1L;
    
	@Id
	int idLocation;
	
	int line;
	
	int column;
	
	boolean empty;
	@OneToOne(mappedBy="locale")
    private Carton carton;
	@ManyToOne
	private Cabinet cabinet;
	
	public Location(int idLocation, int line, int column, boolean empty) {
		super();
		this.idLocation = idLocation;
		this.line = line;
		this.column = column;
		this.empty = empty;
	}


	public Location() {
		super();
	}


	public int getIdLocation() {
		return idLocation;
	}


	public void setIdLocation(int idLocation) {
		this.idLocation = idLocation;
	}


	public int getLine() {
		return line;
	}


	public void setLine(int line) {
		this.line = line;
	}


	public int getColumn() {
		return column;
	}


	public void setColumn(int column) {
		this.column = column;
	}


	public boolean isEmpty() {
		return empty;
	}


	public void setEmpty(boolean empty) {
		this.empty = empty;
	}


	public Carton getCarton() {
		return carton;
	}


	public void setCarton(Carton carton) {
		this.carton = carton;
	}


	public Cabinet getCabinet() {
		return cabinet;
	}


	public void setCabinet(Cabinet cabinet) {
		this.cabinet = cabinet;
	}
	
   
}
