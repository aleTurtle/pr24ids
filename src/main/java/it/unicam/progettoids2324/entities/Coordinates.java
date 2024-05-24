package it.unicam.progettoids2324.entities;


/**
 * Check if the latidute and the longitude is in the range
 * @param lat
 * @param longi
 * @throw IllegalArgumentException if the coordinate are out of range
 */
public record Coordinates(double lat, double longi) {
    public Coordinates{
        if(lat < -90 || lat > 90){
            throw new IllegalArgumentException("Latitude is out of range");
        }
        if(longi < -180 || longi > 180){
            throw new IllegalArgumentException("Longitude out of range");
        }
    }
}
