package global.genesis.crypto.utils;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.List;

public class CsvParser {

	public static List<String> parseCsv() {
		List<String> csvLines = new ArrayList<>();

		try {
			InputStream inputStream = CsvParser.class.getClassLoader().getResourceAsStream("wallet.csv");
			InputStreamReader streamReader = new InputStreamReader(inputStream, StandardCharsets.UTF_8);
			BufferedReader reader = new BufferedReader(streamReader);

			String line;
			while ((line = reader.readLine()) != null) {
				csvLines.add(line);
			}
		} catch (IOException e) {
			e.printStackTrace();
		}

		return csvLines;
	}

}
