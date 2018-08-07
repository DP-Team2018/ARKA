package arka.service;

import javax.ejb.Remote;

import arka.domain.Admin;
import arka.domain.Agent;

@Remote
public interface AuthServiceRemote {

public Agent  verifAgent(String e,String a);
public Admin verifAdmin(String e,String a);
public String verif (String e , String a);
}