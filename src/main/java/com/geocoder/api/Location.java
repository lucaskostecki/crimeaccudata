package com.geocoder.api;

import java.util.List;
import com.fasterxml.jackson.annotation.JsonProperty;
import javax.annotation.Generated;

@Generated("com.robohorse.robopojogenerator")
public class Location{

	@JsonProperty("DisplayPosition")
	private DisplayPosition displayPosition;

	@JsonProperty("Address")
	private Address address;

	@JsonProperty("LocationId")
	private String locationId;

	@JsonProperty("NavigationPosition")
	private List<NavigationPositionItem> navigationPosition;

	@JsonProperty("MapView")
	private MapView mapView;

	@JsonProperty("LocationType")
	private String locationType;

	public void setDisplayPosition(DisplayPosition displayPosition){
		this.displayPosition = displayPosition;
	}

	public DisplayPosition getDisplayPosition(){
		return displayPosition;
	}

	public void setAddress(Address address){
		this.address = address;
	}

	public Address getAddress(){
		return address;
	}

	public void setLocationId(String locationId){
		this.locationId = locationId;
	}

	public String getLocationId(){
		return locationId;
	}

	public void setNavigationPosition(List<NavigationPositionItem> navigationPosition){
		this.navigationPosition = navigationPosition;
	}

	public List<NavigationPositionItem> getNavigationPosition(){
		return navigationPosition;
	}

	public void setMapView(MapView mapView){
		this.mapView = mapView;
	}

	public MapView getMapView(){
		return mapView;
	}

	public void setLocationType(String locationType){
		this.locationType = locationType;
	}

	public String getLocationType(){
		return locationType;
	}

	@Override
 	public String toString(){
		return 
			"Location{" + 
			"displayPosition = '" + displayPosition + '\'' + 
			",address = '" + address + '\'' + 
			",locationId = '" + locationId + '\'' + 
			",navigationPosition = '" + navigationPosition + '\'' + 
			",mapView = '" + mapView + '\'' + 
			",locationType = '" + locationType + '\'' + 
			"}";
		}
}