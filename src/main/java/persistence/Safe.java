package persistence;

import amisafe.persistence.AmISafe;

import com.google.gson.JsonArray;
import com.google.gson.JsonObject;
import controller.CrunchifyJSON;



import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Response;
import java.util.List;
import java.util.Map;

/**
 * The type persistence.Safe.
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
        JsonArray crime = safe.crimeRadiusByAddress(address, radius);
        CrunchifyJSON crunch = new CrunchifyJSON();


        if(crime.size() > 0) {
            List jsonList = crunch.JSONArrayToList(crime);
            json = crunch.listToJSON(jsonList);

        } else {
            json = "No Crime activity near " + address + " at " + radius + " distance.";
        }

        return Response.status(200)
                .entity(json)
                .build();
    }
}
