package com.conversor.conversor_moneda.servicio;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;



@Service
public class ConversorService {

    private final String apiKey;
    private final String apiUrl;

    // Constructor que inyecta las propiedades desde AppConfig
    @Autowired
    public ConversorService(AppConfig appConfig) {
        this.apiKey = String.valueOf(appConfig.getApiKey());
        this.apiUrl = appConfig.getApiUrl();
    }

    public String convertir(String desde, String hacia, double monto) {
        try {


            String url = apiUrl + "/" + apiKey + "/pair/" + desde + "/" + hacia + "/" + monto;

            HttpClient client = HttpClient.newHttpClient();
            HttpRequest request = HttpRequest.newBuilder()
                    .uri(URI.create(url))
                    .build();

            HttpResponse<String> response = client.send(request, HttpResponse.BodyHandlers.ofString());
            String responseBody = response.body();

            JsonObject json = JsonParser.parseString(responseBody).getAsJsonObject();

            if (json.has("result") && json.get("result").getAsString().equals("error")) {
                String errorType = json.has("error-type") ? json.get("error-type").getAsString() : "Desconocido";
                return "Error de la API: " + errorType;
            }


            if (!json.has("conversion_result") || json.get("conversion_result").isJsonNull()) {
                return "Error: No se encontró 'conversion_result' en la respuesta de la API.";
            }

            double resultado = json.get("conversion_result").getAsDouble();

            return "Monto convertido: " + resultado + " " + hacia;
        } catch (Exception e) {
            return "Error en la conversión: " + e.getMessage();
        }
    }

}

