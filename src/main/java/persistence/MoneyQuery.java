package persistence;


//import com.zipcodeapi.ZipCodesItem;
import controller.CrunchifyJSON;
import entity.Money;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;

import javax.ws.rs.core.Response;
import java.util.ArrayList;
import java.util.List;

@Path("/money")
public class MoneyQuery {
    @GET
    @Produces("application/json")
    @Path("/{zipCode}")
    public Response getMoneyAverages(@PathParam("zipCode") String zipCode) throws Exception {
        List<String> nearZipCodes;
        String json = "";



        NearZipCode zipCodeRequest = new NearZipCode();
        nearZipCodes = zipCodeRequest.getNearZipCodes(zipCode);

        GenericDao moneyDao = new persistence.GenericDao(Money.class);

        CrunchifyJSON crunch = new CrunchifyJSON();

        List<Money> jsonObjs = new ArrayList<>();

        for (String zip : nearZipCodes) {
            List<Money> data = moneyDao.getByPropertyLike("zip", zip);

            if (data.size() > 0) {
                jsonObjs.add(data.get(0));
            }
        }


        json = crunch.listToJSON(jsonObjs);



        return Response.status(200).entity(json).build();
    }


}
