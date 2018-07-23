package arka.domain;

import java.io.Serializable;
import java.util.List;

import javax.persistence.*;

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
	
		String nom;
		String password ;
		String email;
		String adress;
	    String numTel;
	    @OneToMany (mappedBy="admin",fetch=FetchType.EAGER,cascade=CascadeType.ALL)
		private List<Demand> demands;
	     
	public Admin() {
		super();
	}

	

	public Admin(int idUser, String nom, String password, String email, String adress, String numTel) {
		super();
		this.idAdmin = idUser;
		this.nom = nom;
		this.password = password;
		this.email = email;
		this.adress = adress;
		this.numTel = numTel;
	}


     


	public int getIdAdmin() {
		return idAdmin;
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
	
	
	
	 
   
}
