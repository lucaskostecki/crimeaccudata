package persistence;

import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class NearZipCodeTest {
    @Test
    void getNearZipCodes() throws Exception {
        NearZipCode zipRequest = new NearZipCode();
        List<String> nearZipCodes;
        nearZipCodes = zipRequest.getNearZipCodes("90210");
        assertEquals(nearZipCodes.size(), 5);
        assertEquals(nearZipCodes.get(4), "90212");


    }




}
