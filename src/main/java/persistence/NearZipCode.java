package persistence;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.zipcodeapi.Results;
import com.zipcodeapi.ZipCodesItem;

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
                client.target("https://www.zipcodeapi.com/rest/VrTX2UdOP5Hpi4B86BAJbGcF7FLuBs3bUJzGa9Js2wyjpQ4Cq6n4G2vLDIIIgKvv/radius.json/"+zipCode+"/5/mile");
        String response = target.request(MediaType.APPLICATION_JSON).get(String.class);

        ObjectMapper mapper = new ObjectMapper();
        Results results = mapper.readValue(response, Results.class);
        List<ZipCodesItem> zipCodeitems = results.getZipCodes();

        for (ZipCodesItem zip : zipCodeitems){
            nearZipCodes.add(zip.getZipCode());
        }


        return nearZipCodes;
    }
}
