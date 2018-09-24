package arka.service;

import java.util.List;

import javax.ejb.Local;

import arka.domain.Admin;

@Local
public interface AdminServiceLocal {
	public List<Admin> getAllAdmin();
	public Admin getAdminById(int id);
	public void addAdmin(Admin a);
	public void updateAdmin(int id,String matricule,String nom,String email,String prenom,String numTel);
	public void deleteAdmin(int id);
}
