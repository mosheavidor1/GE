package API.Infra.Properties;

public enum EnumID {
//ID enum using for the URL string.
    INSTANCE;

    private String bookingId;

    public void setBookingId(String bookingId) {
        this.bookingId = bookingId;
    }

    public String getBookingId() {
        return bookingId;
    }
}


