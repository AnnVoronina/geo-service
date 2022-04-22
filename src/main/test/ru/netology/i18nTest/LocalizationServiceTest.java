package ru.netology.i18nTest;


import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import org.mockito.Mock;
import org.mockito.Mockito;
import ru.netology.entity.Country;
import ru.netology.i18n.LocalizationService;
import ru.netology.i18n.LocalizationServiceImpl;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.*;
import static ru.netology.TestConstants.welcomeR;
import static ru.netology.TestConstants.welcomeU;


public class LocalizationServiceTest {


    @Mock
    LocalizationService mockLS = Mockito.mock(LocalizationServiceImpl.class);


    @Test
    public void localizationServiceTestRussia() {


        when(mockLS.locale(Country.RUSSIA)).thenReturn(welcomeR);
        assertEquals(welcomeR, mockLS.locale(Country.RUSSIA));

    }
    @BeforeAll
    public static void startSuite() {
        System.out.println("Tests for Localization Service tests start.");
    }
    @AfterAll
    public static void completeSuite() {
        System.out.println("All  Localization Service tests complete.");
    }

    @Test
    public void localizationServiceTestUSA() {
        when(mockLS.locale(Country.USA)).thenReturn(welcomeU);
        assertEquals(welcomeU, mockLS.locale(Country.USA));
    }
}
