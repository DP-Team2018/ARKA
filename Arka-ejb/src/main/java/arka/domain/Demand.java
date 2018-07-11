package arka.domain;

import java.io.Serializable;
import java.sql.Date;

import javax.persistence.*;

/**
 * Entity implementation class for Entity: Demand
 *
 */
@Entity

public class Demand implements Serializable {

	
	@Id
	int idDemand;
	
	String note;
	
	DemandType demandType;
	
	boolean etat;
	
	Date date;
	
	int idCartonClient;
	
	@ManyToOne
	Client client;
	
	
	@ManyToOne
	Admin admin;
	
	
	
	private static final long serialVersionUID = 1L;

	public Demand() {
		super();
	}

	public int getIdDemand() {
		return idDemand;
	}

	public void setIdDemand(int idDemand) {
		this.idDemand = idDemand;
	}

	public String getNote() {
		return note;
	}

	public void setNote(String note) {
		this.note = note;
	}

	public DemandType getDemandType() {
		return demandType;
	}

	public void setDemandType(DemandType demandType) {
		this.demandType = demandType;
	}

	public boolean isEtat() {
		return etat;
	}

	public void setEtat(boolean etat) {
		this.etat = etat;
	}

	public Date getDate() {
		return date;
	}

	public void setDate(Date date) {
		this.date = date;
	}

	public int getIdCartonClient() {
		return idCartonClient;
	}

	public void setIdCartonClient(int idCartonClient) {
		this.idCartonClient = idCartonClient;
	}

	public Client getClient() {
		return client;
	}

	public void setClient(Client client) {
		this.client = client;
	}

	public Admin getAdmin() {
		return admin;
	}

	public void setAdmin(Admin admin) {
		this.admin = admin;
	}
	
   
}
