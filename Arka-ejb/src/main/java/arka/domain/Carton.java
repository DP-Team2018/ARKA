package arka.domain;

import java.io.Serializable;
import java.sql.Date;
import java.util.List;
import javax.persistence.*;

import com.fasterxml.jackson.annotation.JsonIgnore;

/**
 * Entity implementation class for Entity: Carton
 *
 */
@Entity

public class Carton implements Serializable {

	
	private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    int idCarton;
    int idCartonClient;   
    Date arrivalDate;
    long duration;
    @OneToOne(cascade=CascadeType.ALL,fetch=FetchType.EAGER)
    
    private Location locale;
    @ManyToOne
  
	Client client; 
    Date destructionDate;
@ManyToMany(cascade=CascadeType.ALL, fetch= FetchType.EAGER)
    @JsonIgnore
   	private List<Demand> demands ;
    
	public Carton() {
		super();
	}

	 
	public Carton(int idCarton, int idCartonClient, Date arrivalDate, long duration) {
		super();
		this.idCarton = idCarton;
		this.idCartonClient = idCartonClient;
		this.arrivalDate = arrivalDate;
		this.duration = duration;
	}


	public int getIdCarton() {
		return idCarton;
	}

	public void setIdCarton(int idCarton) {
		this.idCarton = idCarton;
	}

	public int getIdCartonClient() {
		return idCartonClient;
	}

	public void setIdCartonClient(int idCartonClient) {
		this.idCartonClient = idCartonClient;
	}

	public Date getArrivalDate() {
		return arrivalDate;
	}

	public void setArrivalDate(Date arrivalDate) {
		this.arrivalDate = arrivalDate;
	}

	public long getDuration() {
		return duration;
	}

	public void setDuration(long duration) {
		this.duration = duration;
	}


	public Location getLocale() {
		return locale;
	}


	public void setLocale(Location locale) {
		this.locale = locale;
	}
	public Client getClient() {
		return client;
	}


	public void setClient(Client client) {
		this.client = client;
	}


	public List<Demand> getDemands() {
		return demands;
	}


	public void setDemands(List<Demand> demands) {
		this.demands = demands;
	}


	public Date getDestructionDate() {
		return destructionDate;
	}


	public void setDestructionDate(Date destructionDate) {
		this.destructionDate = destructionDate;
	}


	@Override
	public String toString() {
		return "Carton [idCarton=" + idCarton + ", idCartonClient=" + idCartonClient + ", arrivalDate=" + arrivalDate
				+ ", duration=" + duration + ", locale=" + locale + ", client=" + client + ", destructionDate="
				+ destructionDate + ", demands=" + demands + "]";
	}
	
	
	
   
}
