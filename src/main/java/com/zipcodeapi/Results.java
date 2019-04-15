package com.zipcodeapi;

import java.util.List;
import com.fasterxml.jackson.annotation.JsonProperty;
import javax.annotation.Generated;

@Generated("com.robohorse.robopojogenerator")
public class Results{

	@JsonProperty("zip_codes")
	private List<ZipCodesItem> zipCodes;

	public void setZipCodes(List<ZipCodesItem> zipCodes){
		this.zipCodes = zipCodes;
	}

	public List<ZipCodesItem> getZipCodes(){
		return zipCodes;
	}

	@Override
 	public String toString(){
		return 
			"Results{" + 
			"zip_codes = '" + zipCodes + '\'' + 
			"}";
		}
}