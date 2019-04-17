package amisafe.persistence;

import com.cityofmadison.maps.arcgis.Features;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.geocoder.api.Results;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import javax.ws.rs.client.Client;
import javax.ws.rs.client.ClientBuilder;
import javax.ws.rs.client.WebTarget;
import javax.ws.rs.core.MediaType;
import java.util.*;

public class AmISafe {
    private final Logger logger = LogManager.getLogger(this.getClass());


    public Map crimeRadiusByAddress(String address, String distType, Double radius) {
        List<Double> addressLatLong = addressLatLong(address);
        Map<String, List<Double>> crimeAddressLatLong = crimeLatLong();
        Map<String, List<Double>> crimeNearBy = new HashMap<>();

        double crimeLat = 0;
        double crimeLng = 0;
        double distance = 0;

            for (Map.Entry<String, List<Double>> entry : crimeAddressLatLong.entrySet()) {
                entry.getKey();
                crimeLat = entry.getValue().get(0);
                crimeLng = entry.getValue().get(1);
                distance = distance(addressLatLong.get(0), addressLatLong.get(1),
                        crimeLat, crimeLng, distType);
                if (distance <= radius) {
                    List<Double> crimeLatLng = new ArrayList<>();
                    crimeLatLng.add(crimeLat);
                    crimeLatLng.add(crimeLng);
                    crimeNearBy.put(entry.getKey(), crimeLatLng);
                }
            }
        return  crimeNearBy;
    }


    public List<Double> addressLatLong(String currentLoc) {
        double lat = 0;
        double lng = 0;
        List<Double> currentLatLong = new ArrayList<>();
        String address = currentLoc.trim();
        address = address.replaceAll("\\s", "%20");

        Client client = ClientBuilder.newClient();
        WebTarget target =
                client.target("https://geocoder.api.here.com/6.2/geocode.json?&street=" + address
                        + "&city=Madison&country=usa&gen=9&app_id=SSKgaMan68tV1A21Vc6Z&app_code=H7gTIYkTd3hR8QXOay9MeQ");
        String response = target.request(MediaType.APPLICATION_JSON).get(String.class);
        ObjectMapper mapper = new ObjectMapper();

        try {
            Results results = mapper.readValue(response, Results.class);
            lat = results.getResponse().getView().get(0).getResult().get(0).getLocation().getDisplayPosition().getLatitude();
            lng = results.getResponse().getView().get(0).getResult().get(0).getLocation().getDisplayPosition().getLongitude();
            currentLatLong.add(lat);
            currentLatLong.add(lng);

        } catch (Exception e) {
            logger.error("error mapping", e);
        }
        return  currentLatLong;
    }

    public Map crimeLatLong() {
        Client client = ClientBuilder.newClient();
        WebTarget target =
                client.target("https://maps.cityofmadison.com/arcgis/rest/services/Public/OPEN_DB_TABLES/MapServer/2/query?where=UPPER%28IncidentType%29+like+%27%25ROBBERY%25%27+OR+UPPER%28IncidentType%29+like+%27%25THEFT%25%27+OR+UPPER%28IncidentType%29+like+%27%25BURGLARY%25%27&text=&objectIds=&time=&geometry=&geometryType=esriGeometryEnvelope&inSR=&spatialRel=esriSpatialRelIntersects&relationParam=&outFields=IncidentType%2C+Address%2C+IncidentDate&returnGeometry=true&returnTrueCurves=false&maxAllowableOffset=&geometryPrecision=&outSR=&having=&returnIdsOnly=false&returnCountOnly=false&orderByFields=IncidentDate+desc&groupByFieldsForStatistics=&outStatistics=&returnZ=false&returnM=false&gdbVersion=&historicMoment=&returnDistinctValues=false&resultOffset=&resultRecordCount=50&queryByDistance=&returnExtentOnly=false&datumTransformation=&parameterValues=&rangeValues=&quantizationParameters=&f=pjson");
        String response = target.request(MediaType.APPLICATION_JSON_TYPE).get(String.class);
        ObjectMapper mapper = new ObjectMapper();
        Long daysAgo = System.currentTimeMillis()/1000 - 1300000;
        Map<String, List<Double>> addressLatLng = new HashMap<>();

        try {
            Features results = mapper.readValue(response, Features.class);

            for(int i =0; i < results.getFeatures().size(); i++) {
                if(results.getFeatures().get(i).getAttributes().getIncidentDate() >= daysAgo) {
                    String address = results.getFeatures().get(i).getAttributes().getAddress();
                    List<Double> latLngs;
                    latLngs = addressLatLong(address);
                    addressLatLng.put(address, latLngs);
                }
            }
        } catch (Exception e) {
            logger.error("Error with mapping", e);
        }
        return addressLatLng;
    }


    private double distance(double lat1, double lon1, double lat2, double lon2, String unit) {
        double theta = lon1 - lon2;
        double dist = Math.sin(deg2rad(lat1)) * Math.sin(deg2rad(lat2)) + Math.cos(deg2rad(lat1)) * Math.cos(deg2rad(lat2)) * Math.cos(deg2rad(theta));
        dist = Math.acos(dist);
        dist = rad2deg(dist);
        dist = dist * 60 * 1.1515;
        if (unit == "km") {
            dist = dist * 1.609344;
        }
        return (dist);
    }
    private double deg2rad(double deg) {
        return (deg * Math.PI / 180.0);
    }
    private double rad2deg(double rad) {
        return (rad * 180.0 / Math.PI);
    }



}
