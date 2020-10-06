import org.json.JSONObject;

import java.io.*;

import java.net.HttpURLConnection;
import java.net.URL;

public class RestClient {

    //referencing were the file is sitting
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

            /**
             * Write to file
             */
            BufferedWriter writer = new BufferedWriter(new FileWriter(fileName));
            StringBuilder builder  = new StringBuilder();
            String str;
            //while there is input stream data add to the string builder
            while ((str = in.readLine()) != null) {
                builder.append(str);
            }

            //create a JSON object that will take in the string of the string build and convert
            // it into a JSON Object
            JSONObject result = new JSONObject(builder.toString());
            //Then write it to the file
            writer.write(result.toString());

        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            //check if the connection is still open, if yes it disconnect
            if (conn != null) {
                conn.disconnect();
            }
        }
    }
}
