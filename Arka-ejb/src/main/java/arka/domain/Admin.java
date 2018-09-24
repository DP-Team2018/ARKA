package arka.domain;

import java.io.Serializable;
import java.util.List;

import javax.persistence.*;

import com.fasterxml.jackson.annotation.JsonIgnore;

/**
 * Entity implementation class for Entity: Admin
 *
 */
@Entity

public class Admin  implements Serializable {

	
	private static final long serialVersionUID = 1L;
	 
	      @Id
	      @GeneratedValue(strategy = GenerationType.AUTO)
	
	      int idAdmin;
	      
	      
	    String matricule;
	    String nom;
		String password ;
		String email;
		String prenon;
	    String numTel;

	     
	public Admin() {
		super();
	}

	

	public Admin(String matricule, String nom, String password, String email, String adress, String numTel) {
		super();
		
		this.matricule = matricule;
		this.nom = nom;
		this.password = password;
		this.email = email;
		this.prenon = adress;
		this.numTel = numTel;
	}


     


	public int getIdAdmin() {
		return idAdmin;
	}

	
	public String getMatricule() {
		return matricule;
	}



	public void setMatricule(String matricule) {
		this.matricule = matricule;
	}


	public void setIdAdmin(int idAdmin) {
		this.idAdmin = idAdmin;
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


	public String getPrenon() {
		return prenon;
	}


	public void setAdress(String adress) {
		this.prenon = adress;
	}


	public String getNumTel() {
		return numTel;
	}


	public void setNumTel(String numTel) {
		this.numTel = numTel;
	}



	
	
	
	
	 
   
}
