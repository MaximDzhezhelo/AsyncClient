import org.asynchttpclient.AsyncHttpClient;
import org.asynchttpclient.Response;

import java.util.concurrent.CompletableFuture;

import static org.asynchttpclient.Dsl.*;

public class LookUp {

    private final AsyncHttpClient asyncHttpClient;

    public LookUp() { asyncHttpClient = asyncHttpClient(); }

    public CompletableFuture<Response> get(final String url) {
        return asyncHttpClient
                .prepareGet(url)
                .execute()
                .toCompletableFuture();
    }

    public LookUpResult executeRequest(final String url) {
        return asyncHttpClient
                .prepareGet(url)
                .execute()
                .toCompletableFuture()
                .thenApply(this::retrieveResponse)
                .join();
    }

    private LookUpResult retrieveResponse(final Response response) {
        final LookUpResult lookUpResult = new LookUpResult();

        String responseBody = response.getResponseBody();
        lookUpResult.setBodyResponse(responseBody);
        if (responseBody.isEmpty()) lookUpResult.setLookUpHasProblem(true);
        return lookUpResult;
    }
}
