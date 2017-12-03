import org.asynchttpclient.Response;
import org.junit.Test;

import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;

import static org.junit.Assert.*;

public class LookUpTest {

    private static final String URL = "http://code.jsontest.com/";
    private static final String URL_FAILED = "http://www.fake12.com/";
    private LookUp lookUp = new LookUp();

    @Test
    public void testGet() throws ExecutionException, InterruptedException {
        CompletableFuture<Response> future = lookUp.get(URL);

        assertNotNull(future);

        Response response = future.get();
        System.out.println(response);
        assertEquals(200, response.getStatusCode());

        String responseBody = response.getResponseBody();
        System.out.println(responseBody);
        assertTrue(!responseBody.isEmpty());
    }

    @Test
    public void testExecuteRequest() throws ExecutionException, InterruptedException {

        LookUpResult lookUpResult = lookUp.executeRequest(URL);
        assertTrue(lookUpResult.isSuccess());
        assertFalse(lookUpResult.isHttpHasProblem());
        assertFalse(lookUpResult.isLookUpHasProblem());

        String bodyResponse = lookUpResult.getBodyResponse();
        System.out.println(bodyResponse);
        assertTrue(!bodyResponse.isEmpty());
    }

    @Test
    public void testExecuteRequest_Failed() throws ExecutionException, InterruptedException {
        LookUpResult lookUpResult = lookUp.executeRequest(URL_FAILED);
        assertTrue(lookUpResult.isSuccess());
        assertFalse(lookUpResult.isHttpHasProblem());
    }
}