package arka.domain;

import java.io.Serializable;
import java.util.List;

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
    @OneToMany(mappedBy="cabinet",cascade=CascadeType.MERGE,fetch=FetchType.EAGER)
	private List<Location> listlocation;
    @ManyToOne
	private Site site;
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



	public List<Location> getListlocation() {
		return listlocation;
	}



	public void setListlocation(List<Location> listlocation) {
		this.listlocation = listlocation;
	}



	public Site getSite() {
		return site;
	}



	public void setSite(Site site) {
		this.site = site;
	}
	
	
   
}
