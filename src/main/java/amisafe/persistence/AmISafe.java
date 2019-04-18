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


    public Map crimeRadiusByAddress(String address, Double radius) {
        List<Double> currentLatLong = convertAddressToLatLong(address);
        Map<String, String> crimes = recentCrime();
        Map<String, String> crimeNearBy = new HashMap<>();
        double distance = 0;

            for(Map.Entry<String, String> entry : crimes.entrySet()) {
                List<Double> crimesLatLng = convertAddressToLatLong(entry.getKey());

                distance = distance(currentLatLong.get(0), currentLatLong.get(1), crimesLatLng.get(0), crimesLatLng.get(1));
                if (distance <= radius) {
                    crimeNearBy.put(entry.getKey(), entry.getValue());
                }
            }
        return  crimeNearBy;
    }


    public List<Double> convertAddressToLatLong(String currentLoc) {

        String address = currentLoc.trim();
        address = address.replaceAll("\\s", "%20");

        Client client = ClientBuilder.newClient();
        WebTarget target =
                client.target("https://geocoder.api.here.com/6.2/geocode.json?&street=" + address
                        + "&city=Madison&country=usa&gen=9&app_id=SSKgaMan68tV1A21Vc6Z&app_code=H7gTIYkTd3hR8QXOay9MeQ");
        String response = target.request(MediaType.APPLICATION_JSON).get(String.class);
        ObjectMapper mapper = new ObjectMapper();
        Results results;
        List<Double> latLngs = new ArrayList<>();
        try {
            results = mapper.readValue(response, Results.class);
            latLngs.add(results.getResponse().getView().get(0).getResult().get(0).getLocation().getDisplayPosition().getLatitude());
            latLngs.add(results.getResponse().getView().get(0).getResult().get(0).getLocation().getDisplayPosition().getLongitude());

        } catch (Exception e) {
            logger.error("error mapping", e);
        }
        return latLngs;
    }

    public Map<String, String> recentCrime() {
        Client client = ClientBuilder.newClient();
        WebTarget target =
                client.target("https://maps.cityofmadison.com/arcgis/rest/services/Public/OPEN_DB_TABLES/MapServer/2/query?where=UPPER%28IncidentType%29+like+%27%25ROBBERY%25%27+OR+UPPER%28IncidentType%29+like+%27%25THEFT%25%27+OR+UPPER%28IncidentType%29+like+%27%25BURGLARY%25%27&text=&objectIds=&time=&geometry=&geometryType=esriGeometryEnvelope&inSR=&spatialRel=esriSpatialRelIntersects&relationParam=&outFields=IncidentType%2C+Address%2C+IncidentDate&returnGeometry=true&returnTrueCurves=false&maxAllowableOffset=&geometryPrecision=&outSR=&having=&returnIdsOnly=false&returnCountOnly=false&orderByFields=IncidentDate+desc&groupByFieldsForStatistics=&outStatistics=&returnZ=false&returnM=false&gdbVersion=&historicMoment=&returnDistinctValues=false&resultOffset=&resultRecordCount=50&queryByDistance=&returnExtentOnly=false&datumTransformation=&parameterValues=&rangeValues=&quantizationParameters=&f=pjson");
        String response = target.request(MediaType.APPLICATION_JSON_TYPE).get(String.class);
        ObjectMapper mapper = new ObjectMapper();
        Long daysAgo = System.currentTimeMillis()/1000 - 1300000;
        Map<String, String> addressIncident = new HashMap<>();

        try {
            Features results = mapper.readValue(response, Features.class);

            for(int i =0; i < 25; i++) {
                if(results.getFeatures().get(i).getAttributes().getIncidentDate() >= daysAgo) {
                    String address = results.getFeatures().get(i).getAttributes().getAddress();
                    String incidentType = results.getFeatures().get(i).getAttributes().getIncidentType();
                    addressIncident.put(address, incidentType);

                }
            }
        } catch (Exception e) {
            logger.error("Error with mapping", e);
        }
        return addressIncident;
    }


    private double distance(double lat1, double lng1, double lat2, double lng2) {
        double earthRadius = 3958.75; // miles (or 6371.0 kilometers)
        double dLat = Math.toRadians(lat2-lat1);
        double dLng = Math.toRadians(lng2-lng1);
        double sindLat = Math.sin(dLat / 2);
        double sindLng = Math.sin(dLng / 2);
        double a = Math.pow(sindLat, 2) + Math.pow(sindLng, 2)
                * Math.cos(Math.toRadians(lat1)) * Math.cos(Math.toRadians(lat2));
        double c = 2 * Math.atan2(Math.sqrt(a), Math.sqrt(1-a));
        double dist = earthRadius * c;

        return dist;
    }



}
