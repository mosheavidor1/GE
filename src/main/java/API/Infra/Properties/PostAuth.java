package API.Infra.Properties;


import org.json.JSONObject;

import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;

public class PostAuth implements ApiConst {


        public static void main(String[] args)throws Exception {


            // Create the JSON object
            JSONObject json = new JSONObject();
            json.put("username", ApiConst.AuthUser);
            json.put("password", ApiConst.AuthPass);


            // Convert JSON object to String
            String jsonString = json.toString();

            // Create the request
            HttpRequest request = HttpRequest.newBuilder()
                    .uri(new URI("https://restful-booker.herokuapp.com/auth"))
                    .POST(HttpRequest.BodyPublishers.ofString(jsonString))
                    .header("Content-Type", "application/json")
                    .header("Accept", "application/json")
                    .build();

            // Send the request and get the response
            HttpClient client = HttpClient.newHttpClient();
             HttpResponse<String> response = client.send(request, HttpResponse.BodyHandlers.ofString());


            // Print the status code and response body
              System.out.println("Status code: " + response.statusCode());
            System.out.println("Response body: " + response.body());


        }
    }
