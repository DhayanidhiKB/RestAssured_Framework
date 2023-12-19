package org.restAssured.tests;

public final class RandomUtils {

    private RandomUtils() {
    }

    public static int getId() {
        return FakerUtils.getNumber(200, 300);
    }

    public static String getFirstName() {
        return FakerUtils.getFirstName();
    }

    public static String getLastName() {
        return FakerUtils.getLastName();
    }

    public static String getEmail() {
        return FakerUtils.getEmail();
    }
}
