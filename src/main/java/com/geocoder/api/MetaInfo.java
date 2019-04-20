package com.geocoder.api;

import com.fasterxml.jackson.annotation.JsonProperty;
import javax.annotation.Generated;

@Generated("com.robohorse.robopojogenerator")
public class MetaInfo{

	@JsonProperty("Timestamp")
	private String timestamp;

	public void setTimestamp(String timestamp){
		this.timestamp = timestamp;
	}

	public String getTimestamp(){
		return timestamp;
	}

	@Override
 	public String toString(){
		return 
			"MetaInfo{" + 
			"timestamp = '" + timestamp + '\'' + 
			"}";
		}
}