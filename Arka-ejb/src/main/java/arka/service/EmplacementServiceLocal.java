package arka.service;

import java.util.Date;
import java.util.List;

import javax.ejb.Local;

import arka.domain.Agent;
import arka.domain.Carton;
import arka.domain.Location;
import arka.domain.Site;

@Local
public interface EmplacementServiceLocal {
public boolean ajouter_emplacement(Location location,Site s);
public void merge_emplacement(Location location);
public List<Location> afficher_emplacement();
public void remplir_emplacement(Location location);
public void vider_emplacement(Location location);
public List<Location> rechercher_emplacement_carton(int id,int codecarton,int id_client,Date date_entree);
public List<Location> rechercher_emplacement_carton_aveccodecarton(int id,int codecarton);
public List<Location> rechercher_emplacement_carton_avecidclient(int id,int id_client);
public List<Location> rechercher_emplacement_carton_avecdate(int id,Date date_entree);
public Location rechercher_emplacement_avec_id(int id);
public List<Location> rechercher_emplacement_vide();
public List<Location> rechercher_emplacement_avecsite(int id);
public List<Location> rechercher_emplacement_avecsite_allee(int id,int allee);
public boolean supprimer_emplacement(Location location);
}
