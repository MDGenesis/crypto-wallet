package global.genesis.crypto;

import global.genesis.crypto.utils.CoinCapAPI;
import global.genesis.crypto.utils.CsvParser;

import java.util.List;

public class Main {

    public static void main(String[] args) throws Exception {

        CsvParser csvParser = new CsvParser();
        CoinCapAPI coinCapAPI = new CoinCapAPI();

        List<String> csv = csvParser.parseCsv();
        csv.forEach(System.out::println);

        System.out.println(coinCapAPI.coinAssets());

    }

}
