package arka.domain;

import java.io.Serializable;
import java.sql.Date;

import javax.persistence.*;

/**
 * Entity implementation class for Entity: Report
 *
 */
@Entity

public class Report implements Serializable {

	
	private static final long serialVersionUID = 1L;
	@Id
	int idReport;
	
	 String note;
	
	 Date date;
	 
	 ReportType reportType;
	 
	 @ManyToOne
      Carton carton;
	 
	 @ManyToOne
	   Agent agent;
	public Report(int idReport, String note, Date date, ReportType reportType) {
		super();
		this.idReport = idReport;
		this.note = note;
		this.date = date;
		this.reportType = reportType;
	}


	public Report() {
		super();
	}


	public int getIdReport() {
		return idReport;
	}


	public void setIdReport(int idReport) {
		this.idReport = idReport;
	}


	public String getNote() {
		return note;
	}


	public void setNote(String note) {
		this.note = note;
	}


	public Date getDate() {
		return date;
	}


	public void setDate(Date date) {
		this.date = date;
	}


	public ReportType getReportType() {
		return reportType;
	}


	public void setReportType(ReportType reportType) {
		this.reportType = reportType;
	}


	public Carton getCarton() {
		return carton;
	}


	public void setCarton(Carton carton) {
		this.carton = carton;
	}


	public Agent getAgent() {
		return agent;
	}


	public void setAgent(Agent agent) {
		this.agent = agent;
	}
   
	
	
}
