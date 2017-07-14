package org.knowm.xchange.jubi.dto.account;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.Test;

import java.io.IOException;
import java.io.InputStream;
import java.math.BigDecimal;
import java.util.Map;

import static org.fest.assertions.api.Assertions.assertThat;

/**
 * Created by Dzf on 2017/7/13.
 */

public class JubiAccountJsonTest {
  @Test
  public void testBalanceAdapter() throws IOException {
    // Read in the JSON from the example resources
    InputStream is = JubiAccountJsonTest.class.getResourceAsStream("/example-balance-data.json");
    //Use Jackson to parse it
    ObjectMapper mapper = new ObjectMapper();
    JubiBalance jubiBalance = mapper.readValue(is, JubiBalance.class);
    System.out.println(jubiBalance);
    assertThat(jubiBalance.getUid()).isEqualTo(new BigDecimal("7"));
    assertThat(jubiBalance.isResult()).isFalse();

    Map<String, BigDecimal> availableFunds = jubiBalance.getAvailableFunds();
    assertThat(availableFunds).hasSize(49);
    assertThat(availableFunds.get("cny")).isEqualTo(new BigDecimal("54.32"));

    Map<String, BigDecimal> lockedFunds = jubiBalance.getLockedFunds();
    assertThat(lockedFunds).hasSize(49);
    assertThat(lockedFunds.get("doge")).isEqualTo(new BigDecimal("65.2213212"));
  }

  @Test
  public void testErrorBalanceAdapter() throws IOException {
    // Read in the JSON from the example resources
    InputStream is = JubiAccountJsonTest.class.getResourceAsStream("/example-balance-data_error.json");
    //Use Jackson to parse it
    ObjectMapper mapper = new ObjectMapper();
    JubiBalance jubiBalance = mapper.readValue(is, JubiBalance.class);
    System.out.println(jubiBalance);
    assertThat(jubiBalance.getCode()).isEqualTo("100");
    assertThat(jubiBalance.isResult()).isFalse();

    assertThat(jubiBalance.getUid()).isNull();

    Map<String, BigDecimal> availableFunds = jubiBalance.getAvailableFunds();
    assertThat(availableFunds).hasSize(0);

    Map<String, BigDecimal> lockedFunds = jubiBalance.getLockedFunds();
    assertThat(lockedFunds).hasSize(0);
  }
}
