package br.coordinates.util;

import br.coordinates.model.Geolocation;

public class CoordinateUtil {
    private static final Integer TOTAL_RADIUS_EARTH = 6371; // 6371KM

    public static Double haversine(Geolocation geoCol, Geolocation geoSt) {

        double dLat = deg2rad((geoSt.getLatitude().doubleValue() - geoCol.getLatitude().doubleValue()));
        double dLong = deg2rad((geoSt.getLongitude().doubleValue() - geoCol.getLongitude().doubleValue()));

        double calcule = Math.sin(dLat / 2) * Math.sin(dLat / 2) + Math.cos(deg2rad(geoCol.getLatitude().doubleValue())) * Math.cos(deg2rad(geoSt.getLatitude().doubleValue())) * Math.sin(dLong / 2) * Math.sin(dLong / 2);
        double c = 2 * Math.atan2(Math.sqrt(calcule), Math.sqrt(1 - calcule));

        return (TOTAL_RADIUS_EARTH * c);
    }

    private static double deg2rad(double deg) {
        return deg * (Math.PI/180);
    }
}
