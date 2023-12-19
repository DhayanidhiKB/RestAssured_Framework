package org.restAssured.tests;

import com.github.javafaker.Faker;

public final class FakerUtils {

    private FakerUtils() {
    }

    private static final Faker faker = new Faker();

    public static int getNumber(int startValue, int endValue) {
        return faker.number().numberBetween(startValue, endValue);
    }

    public static String getFirstName() {
        return faker.name().firstName();
    }

    public static String getLastName() {
        return faker.name().lastName();
    }

    public static String getEmail() {
        return faker.internet().emailAddress();
    }
}
