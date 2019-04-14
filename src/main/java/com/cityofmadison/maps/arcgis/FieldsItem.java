package com.cityofmadison.maps.arcgis;

import com.fasterxml.jackson.annotation.JsonProperty;
import javax.annotation.Generated;

@Generated("com.robohorse.robopojogenerator")
public class FieldsItem{

	@JsonProperty("name")
	private String name;

	@JsonProperty("length")
	private int length;

	@JsonProperty("alias")
	private String alias;

	@JsonProperty("type")
	private String type;

	public void setName(String name){
		this.name = name;
	}

	public String getName(){
		return name;
	}

	public void setLength(int length){
		this.length = length;
	}

	public int getLength(){
		return length;
	}

	public void setAlias(String alias){
		this.alias = alias;
	}

	public String getAlias(){
		return alias;
	}

	public void setType(String type){
		this.type = type;
	}

	public String getType(){
		return type;
	}

	@Override
 	public String toString(){
		return 
			"FieldsItem{" + 
			"name = '" + name + '\'' + 
			",length = '" + length + '\'' + 
			",alias = '" + alias + '\'' + 
			",type = '" + type + '\'' + 
			"}";
		}
}