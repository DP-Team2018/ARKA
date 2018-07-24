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
	 @GeneratedValue(strategy = GenerationType.AUTO)

	int idDemand;
	String note;	
	DemandType demandType;	
	Date date;	
	int idCartonClient;	
	Date assignmentDate;
	DemandState demandState;
	@ManyToOne(fetch=FetchType.LAZY)
	Client client;
	@ManyToOne
	Admin admin;
	@ManyToOne
	Agent agent;
	@ManyToOne
	Carton Carton;
	
	
	
	public Agent getAgent() {
		return agent;
	}

	public void setAgent(Agent agent) {
		this.agent = agent;
	}

	public Carton getCarton() {
		return Carton;
	}

	public void setCarton(Carton carton) {
		Carton = carton;
	}

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

	public Date getAssignmentDate() {
		return assignmentDate;
	}

	public void setAssignmentDate(Date assignmentDate) {
		this.assignmentDate = assignmentDate;
	}

	public DemandState getDemandState() {
		return demandState;
	}

	public void setDemandState(DemandState demandState) {
		this.demandState = demandState;
	}
	
	
   
}
