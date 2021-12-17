package global.genesis.crypto.utils;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.List;

public class CsvParser {

    public List<String> parseCsv() throws Exception {
        List<String> csvLines = new ArrayList<>();

        try {
            InputStream inputStream = getCsvFile();
            InputStreamReader streamReader = new InputStreamReader(inputStream, StandardCharsets.UTF_8);
            BufferedReader reader = new BufferedReader(streamReader);

            String line;
            while ((line = reader.readLine()) != null) {
                csvLines.add(line);
            }
        } catch (Exception e) {
            throw new Exception("Error on processing CSV File");
        }

        return csvLines;
    }

    public InputStream getCsvFile() {
        return this.getClass().getClassLoader().getResourceAsStream("wallet.csv");
    }

}
