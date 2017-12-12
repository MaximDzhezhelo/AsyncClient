import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;
import org.mockserver.client.server.MockServerClient;
import org.mockserver.integration.ClientAndServer;
import org.mockserver.verify.VerificationTimes;

import static org.mockserver.integration.ClientAndServer.startClientAndServer;
import static org.mockserver.model.HttpRequest.request;

public class MockServerTest {
    private static ClientAndServer mockServer;

    @BeforeClass
    public static void startServer() { mockServer = startClientAndServer(1080); }

    @Test
    public void whenPostRequestMockServer_thenServerReceived(){
        verifyGetRequest();
    }

    private void verifyGetRequest() {
        new MockServerClient("localhost", 1080).verify(
                request()
                        .withMethod("GET")
                        .withPath("/index.html"),
                VerificationTimes.exactly(1)
        );
    }

    @AfterClass
    public static void stopServer() { mockServer.stop(); }

}
