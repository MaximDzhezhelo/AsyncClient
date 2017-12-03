import org.asynchttpclient.Response;
import org.junit.Test;

import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;

import static org.junit.Assert.*;

public class LookUpTest {

    private static final String URL = "http://code.jsontest.com/";
    private LookUp lookUp = new LookUp();

    @Test
    public void get() throws ExecutionException, InterruptedException {
        CompletableFuture<Response> responseCompletableFuture = lookUp.get(URL);

        assertNotNull(responseCompletableFuture);

        Response response = responseCompletableFuture.get();
        System.out.println(response);
        assertEquals(200, response.getStatusCode());

        String responseBody = response.getResponseBody();
        System.out.println(responseBody);
        assertTrue(!responseBody.isEmpty());
    }
}