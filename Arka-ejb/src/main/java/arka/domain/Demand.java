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
	
	private static final long serialVersionUID = 1L;

	public Demand() {
		super();
	}
   
}
