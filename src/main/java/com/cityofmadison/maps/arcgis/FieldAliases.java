package com.cityofmadison.maps.arcgis;

import com.fasterxml.jackson.annotation.JsonProperty;
import javax.annotation.Generated;

@Generated("com.robohorse.robopojogenerator")
public class FieldAliases{

	@JsonProperty("IncidentType")
	private String incidentType;

	@JsonProperty("Address")
	private String address;

	@JsonProperty("IncidentDate")
	private String incidentDate;

	@JsonProperty("IncidentID")
	private String incidentID;

	@JsonProperty("DateModified")
	private String dateModified;

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

	public void setIncidentDate(String incidentDate){
		this.incidentDate = incidentDate;
	}

	public String getIncidentDate(){
		return incidentDate;
	}

	public void setIncidentID(String incidentID){
		this.incidentID = incidentID;
	}

	public String getIncidentID(){
		return incidentID;
	}

	public void setDateModified(String dateModified){
		this.dateModified = dateModified;
	}

	public String getDateModified(){
		return dateModified;
	}

	@Override
 	public String toString(){
		return 
			"FieldAliases{" + 
			"incidentType = '" + incidentType + '\'' + 
			",address = '" + address + '\'' + 
			",incidentDate = '" + incidentDate + '\'' + 
			",incidentID = '" + incidentID + '\'' + 
			",dateModified = '" + dateModified + '\'' + 
			"}";
		}
}