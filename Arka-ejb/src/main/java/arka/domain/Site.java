package arka.domain;

import java.io.Serializable;
import java.util.List;

import javax.persistence.*;

import com.fasterxml.jackson.annotation.JsonIgnore;

/**
 * Entity implementation class for Entity: Site
 *
 */
@Entity

public class Site implements Serializable {

	
	private static final long serialVersionUID = 1L;
     @Id
     @GeneratedValue(strategy = GenerationType.AUTO)

     int idSite;
     
     String name;
     String address;
     float area;
     @JsonIgnore
     @OneToMany(mappedBy="site",cascade=CascadeType.ALL,fetch=FetchType.EAGER)
 	private List<Location> locations;
     
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


	public List<Location> getLocations() {
		return locations;
	}


	public void setLocations(List<Location> locations) {
		this.locations = locations;
	}


	@Override
	public String toString() {
		return "Site [idSite=" + idSite + ", name=" + name + ", address=" + address + ", area=" + area + ", locations="
				+ locations + "]";
	}


	
	
	
   
}
