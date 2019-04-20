package persistence;

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
import java.util.List;

@Path("/canisteal")
public class CanISteal {
    private final Logger logger = LogManager.getLogger(this.getClass());
    private GenericDao businessDao = new persistence.GenericDao(Business.class);
    private GenericDao reviewDao = new persistence.GenericDao(Review.class);
    private CrunchifyJSON crunchify = new CrunchifyJSON();

    @GET
    @Path("/canisteal/address/{address}")
    @Produces("application/json")
    public Response getBusinessByAddress(@PathParam("address") String address) {
        List<Review> reviews;
        List<Business> businessesByID = businessDao.getByPropertyLike("businessID", address);

        for (Business business : businessesByID) {
            String businessID = Integer.toString(business.getBusinessID());
            reviews = reviewDao.getByPropertyLike("review", businessID);
        }

        String output = crunchify.listToJSON(resp);
        return Response.status(200).entity(output).build();
    }

    @GET
    @Path("/canisteal/name/{name}")
    @Produces("application/json")
    public Response getBusinessByName(@PathParam("name") String name) {
        List<Business> businessResp = businessDao.getByPropertyLike("businessID", name);
        List<Review> reviewResp = reviewDao.getByPropertyLike("businessID", address);

        String output = crunchify.listToJSON(resp);
        return Response.status(200).entity(output).build();
    }
}