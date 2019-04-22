package persistence;

import org.junit.jupiter.api.Test;

import javax.ws.rs.core.Response;

import static javax.ws.rs.core.Response.Status.OK;
import static org.junit.jupiter.api.Assertions.*;

class CanIStealTest {

    @Test
    void getBusinessByAddress() {
        CanISteal cis = new CanISteal();
        Response.StatusType statusCode = OK;

        Response resp = cis.getBusinessByAddress("1430 N Stoughton Rd");

        assertEquals(statusCode, resp.getStatusInfo());
    }

    @Test
    void getBusinessByName() {
        CanISteal cis = new CanISteal();
        Response.StatusType statusCode = OK;

        Response resp = cis.getBusinessByAddress("Zimbrick Volkswagen of Madison");

        assertEquals(statusCode, resp.getStatusInfo());
    }
}