package arka.domain;

import java.io.Serializable;
import java.sql.Date;
import java.util.List;

import javax.persistence.*;

/**
 * Entity implementation class for Entity: Agent
 *
 */
@Entity

public class Agent  implements Serializable {

	
	private static final long serialVersionUID = 1L;
	@Id
	 @GeneratedValue(strategy = GenerationType.AUTO)

	 String matricule;
	
	String nom;
	String password ;
	String email;
	String adress;
    String numTel;
    
    
    @OneToMany (mappedBy="agent")
	private List<Demand> demandes;
    
	public Agent() {
		super();
	}
	
	
	
	public Agent(String matricule, String nom, String password, String email, String adress, String numTel,
			Date recretingDate, float salaire) {
		super();
		this.matricule = matricule;
		this.nom = nom;
		this.password = password;
		this.email = email;
		this.adress = adress;
		this.numTel = numTel;
		
	}



	public String getidAgent() {
		return matricule;
	}
	public void setidAgent(String idAgent) {
		this.matricule = idAgent;
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
	



	public List<Demand> getDemandes() {
		return demandes;
	}



	public void setDemandes(List<Demand> demandes) {
		this.demandes = demandes;
	}
	
	
   
	
}
