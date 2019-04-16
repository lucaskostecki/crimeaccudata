package persistence;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.geonamesapi.PostalCodesItem;
import com.geonamesapi.Results;

import javax.ws.rs.client.Client;
import javax.ws.rs.client.ClientBuilder;
import javax.ws.rs.client.WebTarget;
import javax.ws.rs.core.MediaType;
import java.util.ArrayList;
import java.util.List;

public class NearZipCode {

    public List<String> getNearZipCodes(String zipCode) throws Exception {
        List<String> nearZipCodes = new ArrayList<>();

        Client client = ClientBuilder.newClient();
        WebTarget target =
                client.target("http://api.geonames.org/findNearbyPostalCodesJSON?formatted=true&postalcode=" + zipCode +"&radius=10&username=gbitzer&style=full");
        String response = target.request(MediaType.APPLICATION_JSON).get(String.class);

        ObjectMapper mapper = new ObjectMapper();
        Results results = mapper.readValue(response, Results.class);
        List<PostalCodesItem> zipCodeitems = results.getPostalCodes();

        for (PostalCodesItem zip : zipCodeitems){
            nearZipCodes.add(zip.getPostalCode());
        }


        return nearZipCodes;
    }
}
