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
        List<Double> latLng;
        latLng = safe.addressLatLong("1701 Wright St");
        assertEquals(43.12183, latLng.get(0));
        assertEquals(-89.32792, latLng.get(1));
    }

}
