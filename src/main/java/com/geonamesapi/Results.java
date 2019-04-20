package com.geonamesapi;

import java.util.List;
import com.fasterxml.jackson.annotation.JsonProperty;
import javax.annotation.Generated;

/**
 * The type Results.
 */
@Generated("com.robohorse.robopojogenerator")
public class Results{

	@JsonProperty("postalCodes")
	private List<PostalCodesItem> postalCodes;

	/**
	 * Set postal codes.
	 *
	 * @param postalCodes the postal codes
	 */
	public void setPostalCodes(List<PostalCodesItem> postalCodes){
		this.postalCodes = postalCodes;
	}

	/**
	 * Get postal codes list.
	 *
	 * @return the list
	 */
	public List<PostalCodesItem> getPostalCodes(){
		return postalCodes;
	}

	@Override
 	public String toString(){
		return 
			"Results{" + 
			"postalCodes = '" + postalCodes + '\'' + 
			"}";
		}
}