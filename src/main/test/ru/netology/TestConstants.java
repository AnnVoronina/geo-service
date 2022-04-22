package ru.netology;

import ru.netology.entity.Country;
import ru.netology.entity.Location;

public interface TestConstants {

    Location locationR = new Location("Moscow", Country.RUSSIA, "Lenina", 15);
    Location locationU = new Location("New York", Country.USA, " 10th Avenue", 32);
    String welcomeR = "Добро пожаловать";
    String welcomeU = "Welcome";

}
