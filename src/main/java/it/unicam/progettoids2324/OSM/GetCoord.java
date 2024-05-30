package it.unicam.progettoids2324.OSM;

import it.unicam.progettoids2324.entities.Coordinates;
import it.unicam.progettoids2324.OSM.MunicipalityChecker;
import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.util.EntityUtils;
import org.json.JSONArray;
import org.json.JSONObject;

public class GetCoord {

    public static double[] getCoordinates(String country) throws Exception {
        String url = "https://nominatim.openstreetmap.org/search?q=" + country + "&format=json&limit=1";

        // Crea un client HTTP
        try (CloseableHttpClient httpClient = HttpClients.createDefault()) {
            HttpGet request = new HttpGet(url);
            request.setHeader("User-Agent", "Mozilla/5.0");

            // Esegui la richiesta HTTP
            HttpResponse response = httpClient.execute(request);
            HttpEntity entity = response.getEntity();

            if (entity != null) {
                // Converte la risposta in una stringa
                String result = EntityUtils.toString(entity);

                // Converte la stringa in un array JSON
                JSONArray jsonArray = new JSONArray(result);
                if (jsonArray.length() > 0) {
                    JSONObject jsonObject = jsonArray.getJSONObject(0);
                    double lat = jsonObject.getDouble("lat");
                    double lon = jsonObject.getDouble("lon");
                    return new double[] { lat, lon };
                }
            }
        }

        return null;
    }

    public static void main(String[] args) throws Exception {
        double[] coor = getCoordinates("Firenze");
        System.out.print(coor[0] + " ");
        System.out.print(coor[1]);
    }
}
