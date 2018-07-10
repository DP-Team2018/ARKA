package arka.domain;

import java.io.Serializable;
import javax.persistence.*;

/**
 * Entity implementation class for Entity: Cabinet
 *
 */
@Entity

public class Cabinet implements Serializable {

	
	private static final long serialVersionUID = 1L;
    @Id
    int idCabinet;
    
    String wording;
    int nbLine;
    int nbColumn;
    
	public Cabinet() {
		super();
	}
	
	

	public Cabinet(int idCabinet, String wording, int nbLine, int nbColumn) {
		super();
		this.idCabinet = idCabinet;
		this.wording = wording;
		this.nbLine = nbLine;
		this.nbColumn = nbColumn;
	}



	public int getIdCabinet() {
		return idCabinet;
	}

	public void setIdCabinet(int idCabinet) {
		this.idCabinet = idCabinet;
	}

	public String getWording() {
		return wording;
	}

	public void setWording(String wording) {
		this.wording = wording;
	}

	public int getNbLine() {
		return nbLine;
	}

	public void setNbLine(int nbLine) {
		this.nbLine = nbLine;
	}

	public int getNbColumn() {
		return nbColumn;
	}

	public void setNbColumn(int nbColumn) {
		this.nbColumn = nbColumn;
	}
	
	
   
}
