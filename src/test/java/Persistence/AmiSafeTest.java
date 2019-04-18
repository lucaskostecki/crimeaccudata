package Persistence;

import amisafe.persistence.AmISafe;
import com.cityofmadison.maps.arcgis.Features;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.geocoder.api.Results;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import sun.security.pkcs11.Secmod;

import javax.enterprise.inject.New;
import javax.ws.rs.client.Client;
import javax.ws.rs.client.ClientBuilder;
import javax.ws.rs.client.WebTarget;
import javax.ws.rs.core.MediaType;

import java.util.*;

import static org.junit.jupiter.api.Assertions.assertEquals;


public class AmiSafeTest {


    private final Logger logger = LogManager.getLogger(this.getClass());

    @Test
    public void testLocationToLatLngApi() {
        AmISafe safe = new AmISafe();

        List<Double> test = new ArrayList<>();
        test.add(43.12183);
        test.add(-89.32792);
        List<Double>  latLng = safe.convertAddressToLatLong("1701 Wright St");
        assertEquals(test, latLng);
    }


}
