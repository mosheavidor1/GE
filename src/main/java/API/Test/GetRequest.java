package API.Test;

import API.Infra.Properties.ApiConst;
import API.Infra.Properties.BookingID;
import API.Infra.Properties.EnumID;

import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;

public class GetRequest implements ApiConst {

    public static void main(String[] args) throws Exception {

        //Send the POST request and get the response
        HttpResponse<String> postResponse = PostRequest.post();

        // Create a BookingId object from the POST response
        BookingID.BookingId bookingId = new BookingID.BookingId(postResponse);


        // Create the GET request with the bookingId from the POST response
        HttpRequest request = HttpRequest.newBuilder()
               .uri(URI.create(ApiConst.url + EnumID.INSTANCE.getBookingId()))


                .GET()
                .header("Accept", "application/json")
                .build();

        // Send the GET request and get the response
        HttpClient client = HttpClient.newHttpClient();
        HttpResponse<String> response = client.send(request, HttpResponse.BodyHandlers.ofString());

        // Print the status code and response body
        System.out.println("Status code: " + response.statusCode());
        System.out.println("Response body: " + response.body());

    }
}


