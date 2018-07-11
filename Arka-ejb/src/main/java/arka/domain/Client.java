package arka.domain;

import java.io.Serializable;
import java.util.List;

import javax.persistence.*;

/**
 * Entity implementation class for Entity: Client
 *
 */
@Entity

public class Client implements Serializable {

	 
	@Id
	int idClient;
	
    String nom;
	
	String password ;
	String email;
	String adress;
    String numTel;
	
    @OneToMany (mappedBy="client")
	private List<Demand> demands;
    
	
    @OneToMany (mappedBy="client")
	private List<Carton> cartons;
    
	private static final long serialVersionUID = 1L;

	public Client() {
		super();
	}
	
	public Client(int idClient, String nom, String password, String email, String adress, String numTel) {
		super();
		this.idClient = idClient;
		this.nom = nom;
		this.password = password;
		this.email = email;
		this.adress = adress;
		this.numTel = numTel;
	}

	public int getIdClient() {
		return idClient;
	}

	public void setIdClient(int idClient) {
		this.idClient = idClient;
	}

	public String getNom() {
		return nom;
	}

	public void setNom(String nom) {
		this.nom = nom;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getAdress() {
		return adress;
	}

	public void setAdress(String adress) {
		this.adress = adress;
	}

	public String getNumTel() {
		return numTel;
	}

	public void setNumTel(String numTel) {
		this.numTel = numTel;
	}

	public List<Demand> getDemands() {
		return demands;
	}

	public void setDemands(List<Demand> demands) {
		this.demands = demands;
	}

	public List<Carton> getCartons() {
		return cartons;
	}

	public void setCartons(List<Carton> cartons) {
		this.cartons = cartons;
	}
   
	
	
}
