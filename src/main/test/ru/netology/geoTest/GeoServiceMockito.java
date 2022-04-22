package ru.netology.geoTest;


import org.junit.jupiter.api.Test;
import org.mockito.Mock;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.*;
import static ru.netology.TestConstants.locationR;
import static ru.netology.TestConstants.locationU;

import org.mockito.Mockito;
import ru.netology.geo.GeoService;
import ru.netology.geo.GeoServiceImpl;


public class GeoServiceMockito {

    @Mock
    GeoService mockGS = Mockito.mock(GeoServiceImpl.class);
    // используем аанотацию @InjectMocks для создания mock объекта

    @Test
    public void testByIpTestRussia() {
        when(mockGS.byIp("172.0.32.11")).thenReturn(locationR);
        assertEquals(locationR,mockGS.byIp("172.0.32.11"));

    }

    @Test
    public void testByIpTestUSA() {
        when(mockGS.byIp("96.44.183.149")).thenReturn(locationU);
        assertEquals(locationU, mockGS.byIp("96.44.183.149"));

    }
//    @Test
//    public void testByIpTestUSAVerify() {
//        //Проверим что выполнилось один раз
//        Mockito.verify(mockGS, Mockito.times(1)).byIp("96.44.183.149");
//    }


}
