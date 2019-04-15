package com.cityofmadison.maps.arcgis;

import com.fasterxml.jackson.annotation.JsonProperty;
import javax.annotation.Generated;

@Generated("com.robohorse.robopojogenerator")
public class FeaturesItem{

	@JsonProperty("attributes")
	private Attributes attributes;

	public void setAttributes(Attributes attributes){
		this.attributes = attributes;
	}

	public Attributes getAttributes(){
		return attributes;
	}

	@Override
 	public String toString(){
		return 
			"FeaturesItem{" + 
			"attributes = '" + attributes + '\'' + 
			"}";
		}
}