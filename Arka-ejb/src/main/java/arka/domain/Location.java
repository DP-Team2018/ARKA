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
	
	int row ;
	
	int driveway;
	
	boolean empty;
	@OneToOne
    private Carton carton;
	
	@ManyToOne
	private Site site;


	public Location(int line, int row, int driveway, boolean empty, Carton carton) {
		super();
		this.line = line;
		this.row = row;
		this.driveway = driveway;
		this.empty = empty;
		this.carton = carton;
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


	public int getRow() {
		return row;
	}


	public void setRow(int row) {
		this.row = row;
	}


	public int getDriveway() {
		return driveway;
	}


	public void setDriveway(int driveway) {
		this.driveway = driveway;
	}

	
	
	
   
}
