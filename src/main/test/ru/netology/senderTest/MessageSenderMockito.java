package ru.netology.senderTest;


import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import ru.netology.geo.GeoService;

import ru.netology.geo.GeoServiceImpl;
import ru.netology.i18n.LocalizationService;
import ru.netology.i18n.LocalizationServiceImpl;
import ru.netology.sender.MessageSender;
import ru.netology.sender.MessageSenderImpl;

import java.util.HashMap;
import java.util.Map;


import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.*;
import static ru.netology.TestConstants.*;
import static ru.netology.entity.Country.RUSSIA;
import static ru.netology.entity.Country.USA;
import static ru.netology.geo.GeoServiceImpl.*;


public class MessageSenderMockito {
    static MessageSender messageSender;
    static GeoService geoService;
    static LocalizationService localizationService;


    @BeforeAll
    public static void prepare() {

        //Создаем заглушку для ИНТЕРФЕЙСА
        geoService = Mockito.mock(GeoServiceImpl.class);
        //Описываем поведение
        Mockito.when(geoService.byIp(MOSCOW_IP)).thenReturn(locationR);
        Mockito.when(geoService.byIp(NEW_YORK_IP)).thenReturn(locationU);

        localizationService = Mockito.mock(LocalizationServiceImpl.class);

        Mockito.when(localizationService.locale(RUSSIA)).thenReturn(welcomeR);
        Mockito.when(localizationService.locale(USA)).thenReturn(welcomeU);

        //
        messageSender = new MessageSenderImpl(geoService, localizationService);
    }

    @Test
    public void messageSenderTestRussia() {
        Map<String, String> headers = new HashMap<>();
        headers.put(MessageSenderImpl.IP_ADDRESS_HEADER, "172.0.32.11");
        assertEquals(welcomeR, messageSender.send(headers));
    }

//    @Test
//    public void messageSenderTestRussiaAny() {
//        Map<String, String> headers = new HashMap<>();
//        headers.put(MessageSenderImpl.IP_ADDRESS_HEADER, startsWith("172"));
//        assertEquals(welcomeR, messageSender.send(headers));
//    }

//    @Test
//    public void testMessageSenderRussiaVerify() {
//        //Проверим что выполнилось один раз
//        Mockito.verify(messageSender, Mockito.times(2)).send(Mockito.any());
//    }

    @Test
    public void messageSenderTestUSA() {

        Map<String, String> headers = new HashMap<>();
        headers.put(MessageSenderImpl.IP_ADDRESS_HEADER, "96.44.183.149");

        assertEquals(welcomeU, messageSender.send(headers));
    }

}
