package persistence;

import com.google.gson.Gson;
import controller.CrunchifyJSON;
import entity.Business;
import entity.Review;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Response;
import java.util.ArrayList;
import java.util.List;

@Path("/canisteal")
public class CanISteal {
    private final Logger logger = LogManager.getLogger(this.getClass());
    private GenericDao businessDao = new persistence.GenericDao(Business.class);
    private GenericDao reviewDao = new persistence.GenericDao(Review.class);
    private CrunchifyJSON crunchify = new CrunchifyJSON();

    @GET
    @Path("/address/{address}")
    @Produces("application/json")
    public Response getBusinessByAddress(@PathParam("address") String address) {
        address = address.replace('+', ' ');

        List<Review> reviewObjs = new ArrayList<>();
        List<Business> businessesByID = businessDao.getByPropertyLike("address", address);

        for (Business business : businessesByID) {
            int businessID = business.getBusinessID();
            reviewObjs = reviewDao.getByID("business", businessID);
        }

        String output = crunchify.listToJSONStrict(reviewObjs);
        return Response.status(200).entity(output).build();
    }

    @GET
    @Path("/name/{name}")
    @Produces("application/json")
    public Response getBusinessByName(@PathParam("name") String name) {
        name = name.replace('+', ' ');

        List<Review> reviewObjs = new ArrayList<>();
        List<Business> businessesByID = businessDao.getByPropertyLike("name", name);

        for (Business business : businessesByID) {
            int businessID = business.getBusinessID();
            reviewObjs = reviewDao.getByID("business", businessID);
        }

        String output = crunchify.listToJSONStrict(reviewObjs);
        return Response.status(200).entity(output).build();
    }
}