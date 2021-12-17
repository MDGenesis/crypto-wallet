package global.genesis.crypto.utils;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.spy;
import static org.mockito.Mockito.when;

public class CsvParserTest {

    static List<String> csv;

    @BeforeAll
    static void loadCsv() throws Exception {
        CsvParser csvParser = new CsvParser();
        csv = csvParser.parseCsv();
    }

    @Test
    public void parseTest() {
        csv.forEach(Assertions::assertNotNull);
    }

    @Test
    public void validateNumberOfLinesTest() {
        assertEquals(3, csv.size());
    }

    @Test
    public void checkForCryptosTest() {
        Set<String> cryptos = new HashSet<>();
        csv.forEach(item -> cryptos.add(item.split(",")[0]));

        assertTrue(cryptos.contains("BTC"));
        assertTrue(cryptos.contains("ETH"));
    }

    @Test
    public void checkForExceptionTest() {
        CsvParser csvParser = new CsvParser();
        CsvParser csvParser1 = spy(csvParser);
        when(csvParser1.getCsvFile()).thenReturn(this.getClass().getClassLoader().getResourceAsStream("wallet1.csv"));
        assertThrows(Exception.class, csvParser1::parseCsv);
    }

}
