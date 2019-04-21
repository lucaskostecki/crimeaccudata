import amisafe.persistence.AmISafe;
import controller.CrunchifyJSON;

import javax.json.JsonArray;
import javax.json.JsonObject;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Response;
import java.util.Map;

/**
 * The type Safe.
 */
@Path("/amisafe")
public class Safe {

    /**
     * Gets local crime data.
     *
     * @param address the address
     * @param radius  the radius
     * @return the local crime data
     */
    @GET
    @Path("/{address}/{radius}")
    @Produces("application/json")
    public Response getLocalCrimeData(
            @PathParam("address") String address,
            @PathParam("radius") double radius) {
        AmISafe safe = new AmISafe();
        String json = "";
        Map<String, String> crime = safe.crimeRadiusByAddress(address, radius);
        CrunchifyJSON crunch = new CrunchifyJSON();



        if(crime.size() > 0) {
            json = crunch.mapToJson(crime);
        } else {
            json = "No Crime activity near " + radius + " distance.";
        }

        return Response.status(200)
                .entity(json)
                .build();
    }
}
