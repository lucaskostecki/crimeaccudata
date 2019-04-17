package com.geocoder.api;

import java.util.List;
import com.fasterxml.jackson.annotation.JsonProperty;
import javax.annotation.Generated;

@Generated("com.robohorse.robopojogenerator")
public class ViewItem{

	@JsonProperty("_type")
	private String type;

	@JsonProperty("ViewId")
	private int viewId;

	@JsonProperty("Result")
	private List<ResultItem> result;

	public void setType(String type){
		this.type = type;
	}

	public String getType(){
		return type;
	}

	public void setViewId(int viewId){
		this.viewId = viewId;
	}

	public int getViewId(){
		return viewId;
	}

	public void setResult(List<ResultItem> result){
		this.result = result;
	}

	public List<ResultItem> getResult(){
		return result;
	}

	@Override
 	public String toString(){
		return 
			"ViewItem{" + 
			"_type = '" + type + '\'' + 
			",viewId = '" + viewId + '\'' + 
			",result = '" + result + '\'' + 
			"}";
		}
}