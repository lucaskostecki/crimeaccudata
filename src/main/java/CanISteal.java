import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Response;

@Path("/canisteal")
public class CanISteal {
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
        String output = "Hello";
        return Response.status(200).entity(output).build();
    }
}
