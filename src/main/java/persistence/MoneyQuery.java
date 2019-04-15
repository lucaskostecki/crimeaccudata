package persistence;


import com.zipcodeapi.ZipCodesItem;
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
    @Produces("text/json")
    @Path("/{zipCode}")
    public Response getMoneyAverages(@PathParam("zipCode") String zipCode) throws Exception {
        List<String> nearZipCodes;
        String output = "";

        NearZipCode zipCodeRequest = new NearZipCode();
        nearZipCodes = zipCodeRequest.getNearZipCodes(zipCode);

        GenericDao moneyDao = new persistence.GenericDao(Money.class);
        List<Money> returnedMoneyInformation;

        for (String zip : nearZipCodes) {
            returnedMoneyInformation = moneyDao.getByPropertyLike("zip", zip);

            for (Money money : returnedMoneyInformation) {
                output += money.getZip() + " " + money.getAverage()+ "\n";
            }

        }




        return Response.status(200).entity(output).build();
    }


}
