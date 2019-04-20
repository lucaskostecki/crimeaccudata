package com.geocoder.api;

import java.util.List;
import com.fasterxml.jackson.annotation.JsonProperty;
import javax.annotation.Generated;

@Generated("com.robohorse.robopojogenerator")
public class MatchQuality{

	@JsonProperty("HouseNumber")
	private double houseNumber;

	@JsonProperty("Country")
	private double country;

	@JsonProperty("Street")
	private List<Double> street;

	@JsonProperty("City")
	private double city;

	public void setHouseNumber(double houseNumber){
		this.houseNumber = houseNumber;
	}

	public double getHouseNumber(){
		return houseNumber;
	}

	public void setCountry(double country){
		this.country = country;
	}

	public double getCountry(){
		return country;
	}

	public void setStreet(List<Double> street){
		this.street = street;
	}

	public List<Double> getStreet(){
		return street;
	}

	public void setCity(double city){
		this.city = city;
	}

	public double getCity(){
		return city;
	}

	@Override
 	public String toString(){
		return 
			"MatchQuality{" + 
			"houseNumber = '" + houseNumber + '\'' + 
			",country = '" + country + '\'' + 
			",street = '" + street + '\'' + 
			",city = '" + city + '\'' + 
			"}";
		}
}