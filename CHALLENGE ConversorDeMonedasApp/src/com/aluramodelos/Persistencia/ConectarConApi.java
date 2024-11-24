package com.aluramodelos.Persistencia;

import com.aluramodelos.Logica.Cotizacion;
import com.google.gson.Gson;
import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;

public class ConectarConApi {
        public static Cotizacion obtenerCotizacion(String base, String target)throws IOException, InterruptedException {

            String conversor = "https://v6.exchangerate-api.com/v6/bbc5a191530571772428a28e/pair/" + base + "/" + target;


            HttpClient client = HttpClient.newHttpClient();
            HttpRequest request = HttpRequest.newBuilder()
                    .uri(URI.create(conversor))
                    .build();

            HttpResponse<String> response = client
                    .send(request, HttpResponse.BodyHandlers.ofString());

            Gson gson = new Gson();
            ApiResponse apiResponse = gson.fromJson(response.body(), ApiResponse.class);

            double tasaConversion = apiResponse.getConversionRate();
            String fechaCotizacion = apiResponse.getTimeLastUpdateUtc();

            return new Cotizacion(tasaConversion, fechaCotizacion);
        }

            private static class ApiResponse {
                private double conversion_rate;
                private String time_last_update_utc;

                public double getConversionRate() {
                    return conversion_rate;
                }

                public String getTimeLastUpdateUtc() {
                    return time_last_update_utc;
                }
        }
}

