package com.geocoder.api;

import com.fasterxml.jackson.annotation.JsonProperty;
import javax.annotation.Generated;

@Generated("com.robohorse.robopojogenerator")
public class ResultItem{

	@JsonProperty("Relevance")
	private double relevance;

	@JsonProperty("MatchLevel")
	private String matchLevel;

	@JsonProperty("MatchQuality")
	private MatchQuality matchQuality;

	@JsonProperty("MatchType")
	private String matchType;

	@JsonProperty("Location")
	private Location location;

	public void setRelevance(double relevance){
		this.relevance = relevance;
	}

	public double getRelevance(){
		return relevance;
	}

	public void setMatchLevel(String matchLevel){
		this.matchLevel = matchLevel;
	}

	public String getMatchLevel(){
		return matchLevel;
	}

	public void setMatchQuality(MatchQuality matchQuality){
		this.matchQuality = matchQuality;
	}

	public MatchQuality getMatchQuality(){
		return matchQuality;
	}

	public void setMatchType(String matchType){
		this.matchType = matchType;
	}

	public String getMatchType(){
		return matchType;
	}

	public void setLocation(Location location){
		this.location = location;
	}

	public Location getLocation(){
		return location;
	}

	@Override
 	public String toString(){
		return 
			"ResultItem{" + 
			"relevance = '" + relevance + '\'' + 
			",matchLevel = '" + matchLevel + '\'' + 
			",matchQuality = '" + matchQuality + '\'' + 
			",matchType = '" + matchType + '\'' + 
			",location = '" + location + '\'' + 
			"}";
		}
}