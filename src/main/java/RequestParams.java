

import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;

public class RequestParams {

    private static final String MEDIA_TYPE_JSON = "/json?";
    private static final String API_KEY = "AIzaSyDnEyrXPMs-WiW7wSlDNqZ38LtsQsAoic0";
    private static final String INPUT = "ChIJrTLr-GyuEmsRBfy61i59si0";

    public static String getParams() throws UnsupportedEncodingException {
       StringBuilder sb = new StringBuilder();
       sb.append(MEDIA_TYPE_JSON);
       sb.append("place_id=" + URLEncoder.encode(INPUT,"utf8"));
       sb.append("&key=" + API_KEY);

       return sb.toString();
    }

}
