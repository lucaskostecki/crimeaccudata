package com.geocoder.api;

import com.fasterxml.jackson.annotation.JsonProperty;
import javax.annotation.Generated;

@Generated("com.robohorse.robopojogenerator")
public class MapView{

	@JsonProperty("BottomRight")
	private BottomRight bottomRight;

	@JsonProperty("TopLeft")
	private TopLeft topLeft;

	public void setBottomRight(BottomRight bottomRight){
		this.bottomRight = bottomRight;
	}

	public BottomRight getBottomRight(){
		return bottomRight;
	}

	public void setTopLeft(TopLeft topLeft){
		this.topLeft = topLeft;
	}

	public TopLeft getTopLeft(){
		return topLeft;
	}

	@Override
 	public String toString(){
		return 
			"MapView{" + 
			"bottomRight = '" + bottomRight + '\'' + 
			",topLeft = '" + topLeft + '\'' + 
			"}";
		}
}