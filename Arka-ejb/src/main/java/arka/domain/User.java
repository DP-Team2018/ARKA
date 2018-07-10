package arka.domain;

import java.io.Serializable;
import javax.persistence.*;

/**
 * Entity implementation class for Entity: User
 *
 */
@Entity

public class User implements Serializable {

	
	private static final long serialVersionUID = 1L;
    
	@Id
	 int idUser;
	
	String nom;
	
	public User() {
		super();
	}
   
}
