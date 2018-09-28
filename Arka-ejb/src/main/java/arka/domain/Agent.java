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
     int idAgent;
	 
	



	String matricule;
	String nom;
	String password ;
	String email;
	String prenom;
    String numTel;
    
    
   
    
	public Agent() {
		super();
	}
	public int getIdAgent() {
		return idAgent;
	}



	public void setIdAgent(int idAgent) {
		this.idAgent = idAgent;
	}
	
	
	public Agent(String matricule, String nom, String password, String email, String prenom, String numTel,
			Date recretingDate, float salaire) {
		super();
		this.matricule = matricule;
		this.nom = nom;
		this.password = password;
		this.email = email;
		this.prenom = prenom;
		this.numTel = numTel;
		
	}




	
	public String getMatricule() {
		return matricule;
	}



	public void setMatricule(String matricule) {
		this.matricule = matricule;
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
	public String getPrenom() {
		return prenom;
	}
	public void setPrenom(String adress) {
		this.prenom = adress;
	}
	public String getNumTel() {
		return numTel;
	}
	public void setNumTel(String numTel) {
		this.numTel = numTel;
	}



	@Override
	public String toString() {
		return this.matricule  +" nom= " + nom ;
	}
	
	
	




   
	
}


