package arka.service;

import java.util.List;

import javax.ejb.Local;

import arka.domain.Location;
import arka.domain.Site;

@Local
public interface SiteServiceLocal {
public boolean addSite(Site s);
public void mergeSite(Site s);
public List<Site> getAllSite();
public void updateSite(Site s);
public Site Rechercher_site_avec_id(int id);
public List<Site> Rechercher_site_avec_nom(String nom);
public boolean supprimer_site(Site s);
public boolean Affecter_emplacement_ausite(Site s,Location location);
}
