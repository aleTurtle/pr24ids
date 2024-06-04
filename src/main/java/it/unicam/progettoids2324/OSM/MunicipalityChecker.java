package it.unicam.progettoids2324.OSM;

import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.util.EntityUtils;
import org.json.JSONArray;
import org.json.JSONObject;
import org.locationtech.jts.geom.Coordinate;
import org.locationtech.jts.geom.Geometry;
import org.locationtech.jts.geom.GeometryFactory;
import org.locationtech.jts.geom.Point;
import org.locationtech.jts.io.ParseException;
import org.locationtech.jts.io.geojson.GeoJsonReader;

import java.io.IOException;

public class MunicipalityChecker {
    private final it.unicam.progettoids2324.entities.Coordinates coordinates;
    private final String comune;
    private Geometry boundary;

    public MunicipalityChecker(it.unicam.progettoids2324.entities.Coordinates coordinates, String comune) {
        this.coordinates = coordinates;
        this.comune = comune;
        this.fetchBoundary();
    }

    private void fetchBoundary() {
        String urlString = String.format("https://nominatim.openstreetmap.org/search?city=%s&format=json&polygon_geojson=1", comune);
        try (CloseableHttpClient httpClient = HttpClients.createDefault()) {
            HttpGet request = new HttpGet(urlString);
            try (CloseableHttpResponse response = httpClient.execute(request)) {
                if (response.getStatusLine().getStatusCode() != 200) {
                    throw new RuntimeException("HttpResponseCode: " + response.getStatusLine().getStatusCode());
                }

                String responseBody = EntityUtils.toString(response.getEntity());
                JSONArray jsonArray = new JSONArray(responseBody);
                if (jsonArray.length() > 0) {
                    JSONObject geoJson = jsonArray.getJSONObject(0).getJSONObject("geojson");
                    GeoJsonReader reader = new GeoJsonReader();
                    this.boundary = reader.read(geoJson.toString());
                }
            }
        } catch (IOException | ParseException e) {
            e.printStackTrace();
        }
    }

    public boolean isPointInComune() {
        if (boundary == null) {
            throw new IllegalStateException("Boundary is not available.");
        }

        GeometryFactory geometryFactory = new GeometryFactory();
        Point point = geometryFactory.createPoint(new Coordinate(coordinates.lat(), coordinates.longi()));
        return boundary.contains(point);
    }

    public static void main(String[] args) {
        it.unicam.progettoids2324.entities.Coordinates coordinates = new it.unicam.progettoids2324.entities.Coordinates(43.7228, 10.4017); // Example: Pisa
        MunicipalityChecker checker = new MunicipalityChecker(coordinates, "Roma");

        if (checker.isPointInComune()) {
            System.out.println("Il punto si trova all'interno del comune.");
        } else {
            System.out.println("Il punto non si trova all'interno del comune.");
        }
    }
}
