package arka.service;

import java.sql.Date;
import java.util.List;

import javax.ejb.LocalBean;
import javax.ejb.Stateless;

import arka.domain.Agent;
import arka.domain.Carton;
import arka.domain.Report;

/**
 * Session Bean implementation class ReportService
 */
@Stateless
@LocalBean
public class ReportService implements ReportServiceRemote, ReportServiceLocal {

    /**
     * Default constructor. 
     */
    public ReportService() {
        // TODO Auto-generated constructor stub
    }

	@Override
	public Report findReportById(int id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Report> findAll() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void deleteReportById(int id) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void addReport(Report r) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public List<Report> getReportByDate(Date date) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Report> getReportByCarton(Carton car) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Report> getReportByAgent(Agent agent) {
		// TODO Auto-generated method stub
		return null;
	}

}
