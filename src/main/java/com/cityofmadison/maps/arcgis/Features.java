package com.cityofmadison.maps.arcgis;

import java.util.List;
import com.fasterxml.jackson.annotation.JsonProperty;
import javax.annotation.Generated;

@Generated("com.robohorse.robopojogenerator")
public class Features{

	@JsonProperty("features")
	private List<FeaturesItem> features;

	@JsonProperty("exceededTransferLimit")
	private boolean exceededTransferLimit;

	@JsonProperty("displayFieldName")
	private String displayFieldName;

	@JsonProperty("fields")
	private List<FieldsItem> fields;

	@JsonProperty("fieldAliases")
	private FieldAliases fieldAliases;

	public void setFeatures(List<FeaturesItem> features){
		this.features = features;
	}

	public List<FeaturesItem> getFeatures(){
		return features;
	}

	public void setExceededTransferLimit(boolean exceededTransferLimit){
		this.exceededTransferLimit = exceededTransferLimit;
	}

	public boolean isExceededTransferLimit(){
		return exceededTransferLimit;
	}

	public void setDisplayFieldName(String displayFieldName){
		this.displayFieldName = displayFieldName;
	}

	public String getDisplayFieldName(){
		return displayFieldName;
	}

	public void setFields(List<FieldsItem> fields){
		this.fields = fields;
	}

	public List<FieldsItem> getFields(){
		return fields;
	}

	public void setFieldAliases(FieldAliases fieldAliases){
		this.fieldAliases = fieldAliases;
	}

	public FieldAliases getFieldAliases(){
		return fieldAliases;
	}

	@Override
 	public String toString(){
		return 
			"Features{" + 
			"features = '" + features + '\'' + 
			",exceededTransferLimit = '" + exceededTransferLimit + '\'' + 
			",displayFieldName = '" + displayFieldName + '\'' + 
			",fields = '" + fields + '\'' + 
			",fieldAliases = '" + fieldAliases + '\'' + 
			"}";
		}
}