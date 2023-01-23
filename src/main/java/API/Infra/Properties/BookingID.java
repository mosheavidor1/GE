package API.Infra.Properties;

import org.json.JSONObject;

import java.net.http.HttpResponse;

public class BookingID {


    public static class BookingId {
        private String bookingId;

        //Booking ID to use in URL string

        public BookingId(HttpResponse<String> response) {
            JSONObject jsonResponse = new JSONObject(response.body());
            int id = jsonResponse.getInt("bookingid");
            EnumID.INSTANCE.setBookingId(Integer.toString(id));


        }



        public String getBookingId() {
            return bookingId;
        }
    }



}
