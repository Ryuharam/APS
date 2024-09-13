package api;

public class MeetingPointCalculator {
    public static double[] calculateMidpoint(double[][] coordinates) {
        double latSum = 0, lonSum = 0;
        int count = coordinates.length;

        for (double[] coordinate : coordinates) {
            latSum += coordinate[0];
            lonSum += coordinate[1];
        }

        double midpointLat = latSum / count;
        double midpointLon = lonSum / count;

        return new double[] { midpointLat, midpointLon };
    }
}
