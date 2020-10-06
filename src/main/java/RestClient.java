import org.json.JSONObject;

import java.io.*;

import java.net.HttpURLConnection;
import java.net.URL;

public class RestClient {

    private String fileName = "src/main/resources/places.json";

    public void getAddress() throws UnsupportedEncodingException {

        String requestParams = RequestParams.getParams();
        String address = "https://maps.googleapis.com/maps/api/place/details";

        HttpURLConnection conn = null;
        try{

            /**
             * Open Connection
             */
            URL url = new URL(address + requestParams);
            conn = (HttpURLConnection) url.openConnection();

            /**
             * Read input
             */
            BufferedReader in = new BufferedReader(new InputStreamReader(conn.getInputStream()));
            BufferedWriter writer = new BufferedWriter(new FileWriter(fileName));
            /**
             * Write to file
             */
            StringBuilder builder  = new StringBuilder();
            String str;
            while ((str = in.readLine()) != null) {
                builder.append(str);
            }

            JSONObject result = new JSONObject(builder.toString());
            writer.write(result.toString());

        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (conn != null) {
                conn.disconnect();
            }
        }
    }
}
