package API.Test;

import API.Infra.Properties.ApiConst;
import org.json.JSONObject;

import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;

public class PostRequest implements ApiConst {


    public static void main(String[] args) throws IOException, URISyntaxException, InterruptedException {
        post();

    }

    public static HttpResponse<String> post() throws IOException, InterruptedException, URISyntaxException {
        // Create the JSON object
        JSONObject json = new JSONObject();
        json.put("firstname", "Moshe");
        json.put("lastname", "Avidor");
        json.put("totalprice", 111);
        json.put("depositpaid", true);
        JSONObject bookingdates = new JSONObject();
        bookingdates.put("checkin", "2013-02-23");
        bookingdates.put("checkout", "2014-10-23");
        json.put("bookingdates", bookingdates);
        json.put("additionalneeds", "Breakfast");

        // Convert JSON object to String
        String jsonString = json.toString();

        // Create the request
        HttpRequest request = HttpRequest.newBuilder()
                .uri(new URI(ApiConst.url))
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

        return response;
    }
}




