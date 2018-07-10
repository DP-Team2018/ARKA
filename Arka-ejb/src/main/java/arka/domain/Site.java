package arka.domain;

import java.io.Serializable;
import javax.persistence.*;

/**
 * Entity implementation class for Entity: Site
 *
 */
@Entity

public class Site implements Serializable {

	
	private static final long serialVersionUID = 1L;
     @Id
     int idSite;
     
     String name;
     String address;
     float area;
     
     
	public Site() {
		super();
	}


	public Site(int idSite, String name, String address, float area) {
		super();
		this.idSite = idSite;
		this.name = name;
		this.address = address;
		this.area = area;
	}


	public int getIdSite() {
		return idSite;
	}

	
	

	public void setIdSite(int idSite) {
		this.idSite = idSite;
	}


	public String getName() {
		return name;
	}


	public void setName(String name) {
		this.name = name;
	}


	public String getAddress() {
		return address;
	}


	public void setAddress(String address) {
		this.address = address;
	}


	public float getArea() {
		return area;
	}


	public void setArea(float area) {
		this.area = area;
	}
	
	
   
}
