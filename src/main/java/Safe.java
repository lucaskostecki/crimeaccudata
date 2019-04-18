import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.core.Response;

@Path("/amisafe")
public class Safe {

    @GET
    @Path("{address}/{radius}")
    public Response getLocalCrimeData(
            @PathParam("address") String address,
            @PathParam("radius") double radius) {
        String params = address + "/" + radius;

        return Response.status(200)
                .entity("getLocalCrimeData is called : " + params)
                .build();
    }
}
