package global.genesis.crypto;

import global.genesis.crypto.utils.CoinCapAPI;
import global.genesis.crypto.utils.CsvParser;

import java.util.List;

public class Main {

	public static void main(String[] args) {

		List<String> csv = CsvParser.parseCsv();
		csv.forEach(System.out::println);

		System.out.println(CoinCapAPI.coinAssets());

	}

}
