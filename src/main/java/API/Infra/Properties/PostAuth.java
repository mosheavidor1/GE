package API.Infra.Properties;


import org.json.JSONObject;

import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;

public class PostAuth implements ApiConst {


    public static void main(String[] args) throws Exception {

        String token=GetAuthKey();
        System.out.println(token);

    }
public static String GetAuthKey() throws Exception{
        // Create the JSON object
        JSONObject json = new JSONObject();
        json.put("username", ApiConst.AuthUser);
        json.put("password", ApiConst.AuthPass);


        // Convert JSON object to String
        String jsonString = json.toString();

        // Create the request
        HttpRequest request = HttpRequest.newBuilder()
                .uri(new URI(ApiConst.AuthURL))
                .POST(HttpRequest.BodyPublishers.ofString(jsonString))
                .header("Content-Type", "application/json")
                .header("Accept", "application/json")
                .build();

        // Send the request and get the response
        HttpClient client = HttpClient.newHttpClient();
        HttpResponse<String> response = client.send(request, HttpResponse.BodyHandlers.ofString());


        // prints the key value;
//              System.out.println("Status code: "+response.statusCode());
//            System.out.println("Response body: "+response.body());
        JSONObject jsonObject = new JSONObject(response.body());
        String token = jsonObject.getString("token");


return token;
    }

    }
