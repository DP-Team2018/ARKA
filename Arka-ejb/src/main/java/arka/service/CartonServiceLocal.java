package arka.service;

import java.util.List;

import javax.ejb.Local;

import arka.domain.Carton;
import arka.domain.Client;
import arka.domain.Location;

@Local
public interface CartonServiceLocal {
public boolean ajoutercarton(Carton carton,Client client);
public void mergecarton(Carton carton);
public boolean affectercarton_au_emplacement(Carton carton,Location location);
public boolean affectercarton_au_client(Carton carton,Client client);
public List<Carton> afficher_carton();
public Carton rechercher_carton_avec_id(int id);
public Carton rechercher_carton_avec_codecartonclient(int codecartonclient);
public List<Carton> rechercher_carton_avec_nomclient(String nomclient);
public Carton rechercher_carton_avec_codeetnom_client(int codecartonclient,String nomclient);
public Client rechercher_client_avec_id(int id);
public List<Client> afficher_client();
public boolean detruire_carton(Carton carton);

}
