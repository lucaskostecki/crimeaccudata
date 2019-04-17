package com.geocoder.api;

import java.util.List;
import com.fasterxml.jackson.annotation.JsonProperty;
import javax.annotation.Generated;

@Generated("com.robohorse.robopojogenerator")
public class Response{

	@JsonProperty("MetaInfo")
	private MetaInfo metaInfo;

	@JsonProperty("View")
	private List<ViewItem> view;

	public void setMetaInfo(MetaInfo metaInfo){
		this.metaInfo = metaInfo;
	}

	public MetaInfo getMetaInfo(){
		return metaInfo;
	}

	public void setView(List<ViewItem> view){
		this.view = view;
	}

	public List<ViewItem> getView(){
		return view;
	}

	@Override
 	public String toString(){
		return 
			"Response{" + 
			"metaInfo = '" + metaInfo + '\'' + 
			",view = '" + view + '\'' + 
			"}";
		}
}