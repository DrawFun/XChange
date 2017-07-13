package org.knowm.xchange.jubi.dto.account;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.Test;

import java.io.IOException;
import java.io.InputStream;

/**
 * Created by Dzf on 2017/7/13.
 */
public class JubiAccountJsonTest {
  @Test
  public void testBalanceAdapter() throws IOException {
    // Read in the JSON from the example resources
    InputStream is = JubiAdaptersTest.class.getResourceAsStream("/example-balance-data.json");
    //Use Jackson to parse it
    ObjectMapper mapper = new ObjectMapper();
    JubiBalance jubiBalance = mapper.readValue(is, JubiBalance.class);
    System.out.println(jubiBalance);
  }
}
