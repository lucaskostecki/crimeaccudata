package persistence;

import org.junit.jupiter.api.Test;

import javax.ws.rs.core.Response;


import static javax.ws.rs.core.Response.Status.OK;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class MoneyQueryTest {
    @Test
    void getMoneyAverages() throws Exception {
        Response.StatusType st = OK;
        MoneyQuery averages = new MoneyQuery();
        Response result = averages.getMoneyAverages("90210");
        assertEquals(st, result.getStatusInfo());
    }


}
