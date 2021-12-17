package global.genesis.crypto.utils;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

public class CoinCapAPI {

    public StringBuffer coinAssets() throws IOException {
        HttpURLConnection con = httpConnection();
        StringBuffer content = new StringBuffer();

        try {
            BufferedReader in = new BufferedReader(new InputStreamReader(con.getInputStream()));
            String inputLine;

            while ((inputLine = in.readLine()) != null) {
                content.append(inputLine);
            }
            in.close();

        } catch (Exception e) {
            content.append("Error on CoinCap API");
        } finally {
            con.disconnect();
        }

        return content;
    }

    public HttpURLConnection httpConnection() throws IOException {
        URL url = new URL("https://api.coincap.io/v2/assets?limit=5");
        HttpURLConnection con = (HttpURLConnection) url.openConnection();
        con.setRequestMethod("GET");
        return con;
    }

}
