/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.practica6_poo;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.util.HashMap;
import java.util.Map;
/**
 *
 * @author jolin
 */
public class ChuckNorrisJokeApiClient {
     public static void main(String[] args) {
        String apiUrl = "https://api.chucknorris.io/jokes/random";

        
        Map<String, String> chuckNorrisJoke = getChuckNorrisJoke(apiUrl);

      
        if (chuckNorrisJoke != null) { // Mostrar el chiste obtenido
            System.out.println("Chiste de Chuck Norris:");
            chuckNorrisJoke.forEach((key, value) -> System.out.println(key + ": " + value));
        } else {
            System.out.println("No se pudo obtener el chiste de Chuck Norris.");
        }
    }

   // Método para realizar la solicitud HTTP y obtener el chiste en un HashMap
    private static Map<String, String> getChuckNorrisJoke(String apiUrl) {
        // Crear un cliente HTTP
        HttpClient httpClient = HttpClient.newHttpClient();

        // Crear una solicitud HTTP GET
        HttpRequest request = HttpRequest.newBuilder()
                .uri(URI.create(apiUrl))
                .GET()
                .build();

        try {
            // Enviar la solicitud y obtener la respuesta
            HttpResponse<String> response = httpClient.send(request, HttpResponse.BodyHandlers.ofString());

            // Verificar el código de estado de la respuesta
            if (response.statusCode() == 200) {
                // Parsear el JSON y extraer el chiste en un HashMap
                // Dependiendo de tu proyecto, podrías utilizar una biblioteca como Gson para parsear JSON
                // Aquí, simplificaremos asumiendo que la respuesta contiene el chiste como texto plano
                Map<String, String> chuckNorrisJoke = new HashMap<>();
                chuckNorrisJoke.put("Chiste", response.body());
                return chuckNorrisJoke;
            } else {
                System.out.println("Error al obtener el chiste. Código de estado: " + response.statusCode());
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

        return null;
    }
    
}
