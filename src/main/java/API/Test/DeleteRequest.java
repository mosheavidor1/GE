package API.Test;

import API.Infra.Properties.ApiConst;
import API.Infra.Properties.BookingID;
import API.Infra.Properties.EnumID;
import API.Infra.Properties.PostAuth;
import org.json.JSONObject;

import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;



public class DeleteRequest implements ApiConst {


        public static void main(String[] args) throws Exception {

            deleteBooking();

        }

//Delete request
        public static void deleteBooking() throws Exception  {
            JSONObject json = new JSONObject();
            HttpResponse<String> postResponse = PostRequest.post();
            BookingID.BookingId bookingId = new BookingID.BookingId(postResponse);

            // Convert JSON object to String
            String jsonString = json.toString();

            // Create the request
            HttpRequest request = HttpRequest.newBuilder()
                    .uri(new URI(ApiConst.url+EnumID.INSTANCE.getBookingId()))
                    .PUT(HttpRequest.BodyPublishers.ofString(jsonString))
                    .header("Content-Type", "application/json")
                    .header("Cookie", "token="+ApiConst.token).DELETE()
                    .build();

            // Send the request and get the response
            HttpClient client = HttpClient.newHttpClient();
            HttpResponse<String> response = client.send(request, HttpResponse.BodyHandlers.ofString());

            // Print the status code and response body
            System.out.println("Status code: " + response.statusCode());
            System.out.println("Response body: " + response.body());


        }
    }




