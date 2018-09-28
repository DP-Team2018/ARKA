package arka.service;

import javax.ejb.Local;

import arka.domain.Admin;
import arka.domain.Agent;

@Local
public interface AuthServiceLocal {
	public Agent  verifAgent(String e,String a);
	public Admin verifAdmin(String e,String a);
	 public String verif (String e , String a);
	 public int getiduser(String email,String password);
}
