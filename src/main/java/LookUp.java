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
}
