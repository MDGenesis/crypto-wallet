package global.genesis.crypto.utils;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

public class CoinCapAPI {

	public static StringBuffer coinAssets() {
		URL url;
		HttpURLConnection con = null;
		StringBuffer content = new StringBuffer();

		try {
			url = new URL("https://api.coincap.io/v2/assets?limit=5");
			con = (HttpURLConnection) url.openConnection();
			con.setRequestMethod("GET");

			BufferedReader in = new BufferedReader(new InputStreamReader(con.getInputStream()));
			String inputLine;

			while ((inputLine = in.readLine()) != null) {
				content.append(inputLine);
			}
			in.close();

		} catch (Exception e) {
			content.append("Error on CoinCap API");
		} finally {
			assert con != null;
			con.disconnect();
		}

		return content;
	}

}
