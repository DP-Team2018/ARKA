package arka.service;

import java.sql.Date;
import java.util.List;

import javax.ejb.Local;

import arka.domain.Agent;
import arka.domain.Carton;
import arka.domain.Report;
import arka.domain.ReportType;



@Local
public interface ReportServiceLocal {
	  public Report findReportById(int id);
	     public List<Report> findAll();
	     public void deleteReportById(int id);
	     public void deleteReport(Report report);
	     public void addReport(Report r);
	     public List<Report> getReportByDate(Date date); 
	     public List<Report> getReportByCarton(int idCarton);
	     public List<Report> getReportByAgent(int idAgent);
	     public void addReport(int idCarton,int idAgent,int idDemand,ReportType reportType);
	    

}
