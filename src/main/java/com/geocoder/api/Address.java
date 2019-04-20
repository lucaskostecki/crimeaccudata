package com.geocoder.api;

import java.util.List;
import com.fasterxml.jackson.annotation.JsonProperty;
import javax.annotation.Generated;

@Generated("com.robohorse.robopojogenerator")
public class Address{

	@JsonProperty("AdditionalData")
	private List<AdditionalDataItem> additionalData;

	@JsonProperty("HouseNumber")
	private String houseNumber;

	@JsonProperty("State")
	private String state;

	@JsonProperty("Label")
	private String label;

	@JsonProperty("Country")
	private String country;

	@JsonProperty("Street")
	private String street;

	@JsonProperty("PostalCode")
	private String postalCode;

	@JsonProperty("City")
	private String city;

	@JsonProperty("County")
	private String county;

	@JsonProperty("District")
	private String district;

	public void setAdditionalData(List<AdditionalDataItem> additionalData){
		this.additionalData = additionalData;
	}

	public List<AdditionalDataItem> getAdditionalData(){
		return additionalData;
	}

	public void setHouseNumber(String houseNumber){
		this.houseNumber = houseNumber;
	}

	public String getHouseNumber(){
		return houseNumber;
	}

	public void setState(String state){
		this.state = state;
	}

	public String getState(){
		return state;
	}

	public void setLabel(String label){
		this.label = label;
	}

	public String getLabel(){
		return label;
	}

	public void setCountry(String country){
		this.country = country;
	}

	public String getCountry(){
		return country;
	}

	public void setStreet(String street){
		this.street = street;
	}

	public String getStreet(){
		return street;
	}

	public void setPostalCode(String postalCode){
		this.postalCode = postalCode;
	}

	public String getPostalCode(){
		return postalCode;
	}

	public void setCity(String city){
		this.city = city;
	}

	public String getCity(){
		return city;
	}

	public void setCounty(String county){
		this.county = county;
	}

	public String getCounty(){
		return county;
	}

	public void setDistrict(String district){
		this.district = district;
	}

	public String getDistrict(){
		return district;
	}

	@Override
 	public String toString(){
		return 
			"Address{" + 
			"additionalData = '" + additionalData + '\'' + 
			",houseNumber = '" + houseNumber + '\'' + 
			",state = '" + state + '\'' + 
			",label = '" + label + '\'' + 
			",country = '" + country + '\'' + 
			",street = '" + street + '\'' + 
			",postalCode = '" + postalCode + '\'' + 
			",city = '" + city + '\'' + 
			",county = '" + county + '\'' + 
			",district = '" + district + '\'' + 
			"}";
		}
}