import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.junit.MockitoJUnitRunner;

import java.io.IOException;

@RunWith(MockitoJUnitRunner.class)
public class RestClientTest {

    RestClient restClient;

    //entry point
    @Test
    public void getPlaceDetails() throws IOException {
        getRestClient().getAddress();
    }


    RestClient getRestClient() {
        if (restClient == null) {
            restClient = new RestClient();
        }

        return restClient;
    }

}
