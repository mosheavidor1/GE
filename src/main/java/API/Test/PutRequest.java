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



    public class PutRequest implements ApiConst {

        public static void main(String[] args) throws Exception {


            updateBooking("John", "Smith", 111, true, "2018-01-01", "2019-01-01", "Breakfast");
            getBooking();


        }

        public static void updateBooking(String firstname, String lastname, int totalprice, boolean depositpaid, String checkin, String checkout, String additionalneeds) throws Exception {


            HttpResponse<String> postResponse = PostRequest.post();
            BookingID.BookingId bookingId = new BookingID.BookingId(postResponse);

            // Create the JSON payload for the PUT request
            JSONObject json = new JSONObject();
            json.put("firstname", firstname);
            json.put("lastname", lastname);
            json.put("totalprice", totalprice);
            json.put("depositpaid", depositpaid);
            JSONObject bookingDates = new JSONObject();
            bookingDates.put("checkin", checkin);
            bookingDates.put("checkout", checkout);
            json.put("bookingdates", bookingDates);
            json.put("additionalneeds", additionalneeds);
            String jsonString = json.toString();

            // Create the PUT request
            HttpRequest request = HttpRequest.newBuilder()
                    .uri(new URI(ApiConst.url+EnumID.INSTANCE.getBookingId()))
                    .PUT(HttpRequest.BodyPublishers.ofString(jsonString))
                    .header("Content-Type", "application/json")
                   .header("Cookie", "token="+ApiConst.token)

                    .build();

            // Send the PUT request and get the response
            HttpClient client = HttpClient.newHttpClient();
            HttpResponse<String> response  = client.send(request, HttpResponse.BodyHandlers.ofString());

            // Print
            System.out.println("Status code: " + response.statusCode());
            System.out.println("Response body: " + response.body());



        }
            public static void getBooking() throws Exception {
                // Create the GET request
                HttpRequest request = HttpRequest.newBuilder()
                        .uri(new URI(ApiConst.url+EnumID.INSTANCE.getBookingId()))
                        .GET()
                        .header("Accept", "application/json")
                        .build();

                // Send the GET request and get the response
                HttpClient client = HttpClient.newHttpClient();
                HttpResponse<String> response = client.send(request, HttpResponse.BodyHandlers.ofString());

                // Print the response
                System.out.println("GET request status code: " + response.statusCode());
                System.out.println("GET request response body: " + response.body());
            }



    }



