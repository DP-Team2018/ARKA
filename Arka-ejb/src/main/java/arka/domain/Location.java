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
	 @GeneratedValue(strategy = GenerationType.AUTO)
     
	int idLocation;
	//allée
	int line;
	//etagére
	int row ;
	//
	int driveway;
	
	boolean empty;
	
	@ManyToOne
	private Site site;


	public Location(int line, int row, int driveway, boolean empty) {
		super();
		this.line = line;
		this.row = row;
		this.driveway = driveway;
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




	public boolean isEmpty() {
		return empty;
	}


	public void setEmpty(boolean empty) {
		this.empty = empty;
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
