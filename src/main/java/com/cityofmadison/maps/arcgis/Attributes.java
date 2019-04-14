package com.cityofmadison.maps.arcgis;

import com.fasterxml.jackson.annotation.JsonProperty;
import javax.annotation.Generated;

@Generated("com.robohorse.robopojogenerator")
public class Attributes{

	@JsonProperty("IncidentType")
	private String incidentType;

	@JsonProperty("Address")
	private String address;

	@JsonProperty("IncidentDate")
	private long incidentDate;

	@JsonProperty("IncidentID")
	private int incidentID;

	@JsonProperty("DateModified")
	private Object dateModified;

	public void setIncidentType(String incidentType){
		this.incidentType = incidentType;
	}

	public String getIncidentType(){
		return incidentType;
	}

	public void setAddress(String address){
		this.address = address;
	}

	public String getAddress(){
		return address;
	}

	public void setIncidentDate(long incidentDate){
		this.incidentDate = incidentDate;
	}

	public long getIncidentDate(){
		return incidentDate;
	}

	public void setIncidentID(int incidentID){
		this.incidentID = incidentID;
	}

	public int getIncidentID(){
		return incidentID;
	}

	public void setDateModified(Object dateModified){
		this.dateModified = dateModified;
	}

	public Object getDateModified(){
		return dateModified;
	}

	@Override
 	public String toString(){
		return 
			"Attributes{" + 
			"incidentType = '" + incidentType + '\'' + 
			",address = '" + address + '\'' + 
			",incidentDate = '" + incidentDate + '\'' + 
			",incidentID = '" + incidentID + '\'' + 
			",dateModified = '" + dateModified + '\'' + 
			"}";
		}
}