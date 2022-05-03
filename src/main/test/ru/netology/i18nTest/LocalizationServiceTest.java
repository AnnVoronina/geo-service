package ru.netology.i18nTest;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import ru.netology.entity.Country;
import ru.netology.i18n.LocalizationService;
import ru.netology.i18n.LocalizationServiceImpl;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static ru.netology.TestConstants.welcomeR;
import static ru.netology.TestConstants.welcomeU;


public class LocalizationServiceTest {


    @Test
    public void localizationServiceTestRussia() {
        LocalizationService localizationService = new LocalizationServiceImpl();
        assertEquals(welcomeR, localizationService.locale(Country.RUSSIA));
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
        LocalizationService localizationService = new LocalizationServiceImpl();
        assertEquals(welcomeU, localizationService.locale(Country.USA));
    }
}
