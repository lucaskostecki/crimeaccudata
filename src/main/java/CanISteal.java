import com.cityofmadison.maps.arcgis.Attributes;
import com.cityofmadison.maps.arcgis.Features;
import com.cityofmadison.maps.arcgis.FeaturesItem;
import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.client.Client;
import javax.ws.rs.client.ClientBuilder;
import javax.ws.rs.client.WebTarget;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

@Path("/canisteal")
public class CanISteal {
    private final Logger logger = LogManager.getLogger(this.getClass());

    /*
    @GET
    @Path("/{param}")
    @Produces("application/json")
    public Response getMessageJSON(@PathParam("param") String msg) {
        String output = "Hello " + msg;
        return Response.status(200).entity(output).build();
    }
    */

    @GET
    @Produces("application/json")
    public Response getMessageJSON() {
        String output = null;

        Client client = ClientBuilder.newClient();
        WebTarget target =
                client.target("https://maps.cityofmadison.com/arcgis/rest/services/Public/OPEN_DB_TABLES/MapServer/2/query?where=UPPER(IncidentType)%20like%20%27%25ROBBERY%25%27%20OR%20UPPER(IncidentType)%20like%20%27%25THEFT%25%27%20OR%20UPPER(IncidentType)%20like%20%27%25BURGLARY%25%27&outFields=IncidentID,IncidentType,IncidentDate,Address,DateModified&outSR=4326&f=json");

        String response = target.request(MediaType.APPLICATION_JSON_TYPE).get(String.class);

        ObjectMapper mapper = new ObjectMapper().configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);

        try {
            Features results = mapper.readValue(response, Features.class);
            output = results.getFeatures().get(0).getAttributes().getIncidentType();
        } catch (Exception e) {
            logger.error("Issue mapping response", e);
        }

        logger.debug(response);
        logger.debug(output);

        return Response.status(200).entity(output).build();
    }
}
