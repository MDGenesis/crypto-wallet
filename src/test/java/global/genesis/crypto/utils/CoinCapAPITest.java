package global.genesis.crypto.utils;

import org.junit.jupiter.api.Test;
import org.mockito.Mock;

import java.io.IOException;
import java.net.HttpURLConnection;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.mockito.Mockito.*;

public class CoinCapAPITest {

    @Mock
    CoinCapAPI coinCapAPI = new CoinCapAPI();

    @Test
    public void assetsApiTest() throws IOException {
        StringBuffer assets = coinCapAPI.coinAssets();
        assertNotNull(assets);
    }

    @Test
    public void apiExceptionTest() throws IOException {
        HttpURLConnection con = mock(HttpURLConnection.class);
        CoinCapAPI coinCapAPIMock = spy(coinCapAPI);
        when(coinCapAPIMock.httpConnection()).thenReturn(con);
        assertEquals("Error on CoinCap API", coinCapAPIMock.coinAssets().toString());
    }

}
