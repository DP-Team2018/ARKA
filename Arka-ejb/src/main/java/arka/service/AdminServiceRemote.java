package arka.service;

import java.util.List;

import javax.ejb.Remote;

import arka.domain.Admin;

@Remote
public interface AdminServiceRemote {
	public List<Admin> getAllAdmin();
	public Admin getAdminById(int id);
	public void addAdmin(Admin a);
	public void updateAdmin(Admin a) ;
	public void deleteAdmin(int id);
}
