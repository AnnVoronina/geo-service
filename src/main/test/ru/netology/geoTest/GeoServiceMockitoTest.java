package ru.netology.geoTest;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static ru.netology.TestConstants.locationR;
import static ru.netology.TestConstants.locationU;
import ru.netology.entity.Location;
import ru.netology.geo.GeoService;
import ru.netology.geo.GeoServiceImpl;


public class GeoServiceMockitoTest {



    GeoService geoService = new GeoServiceImpl();

    @Test
    public void testByIpTestRussia() {
        Location location = geoService.byIp("172.0.32.11");

        assertEquals(locationR,location);

    }

    @Test
    public void testByIpTestUSA() {
        Location location = geoService.byIp("96.44.183.149");
        assertEquals(locationU, location);

    }


}
