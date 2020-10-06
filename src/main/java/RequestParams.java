

import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;

public class RequestParams {
    //building the parameters
    private static final String MEDIA_TYPE_JSON = "/json?";
    private static final String API_KEY = "AIzaSyDnEyrXPMs-WiW7wSlDNqZ38LtsQsAoic0";
    private static final String INPUT = "ChIJrTLr-GyuEmsRBfy61i59si0";

    //Static Method to be called from a client
    public static String getParams() throws UnsupportedEncodingException {
       StringBuilder sb = new StringBuilder(); //String builder takes all separate parameters and combine them.
       sb.append(MEDIA_TYPE_JSON);
       sb.append("place_id=" + URLEncoder.encode(INPUT,"utf8"));
       sb.append("&key=" + API_KEY);

       //we then join strings using the "append"

       return sb.toString();
    }

}
