package org.knowm.xchange.jubi.dto.trade;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.Test;

import java.io.IOException;
import java.io.InputStream;
import java.math.BigDecimal;
import java.text.SimpleDateFormat;
import java.util.TimeZone;

import static org.fest.assertions.api.Assertions.assertThat;

/**
 * Created by Dzf on 2017/7/16.
 */
public class JubiOrderJsonTest {

  @Test
  public void testSuccessToFetchJubiOrderHistoryAdapter() throws IOException {
    // Read in the JSON from the example resources
    InputStream is = JubiOrderJsonTest.class.getResourceAsStream("/example-trade-list.json");
    // Use Jackson to parse it
    ObjectMapper mapper = new ObjectMapper();
    JubiOrderHistroy jubiOrderHistroy = mapper.readValue(is, JubiOrderHistroy.class);
    assertThat(jubiOrderHistroy.getResult().isSuccess()).isTrue();
    assertThat(jubiOrderHistroy.getOrderList().length).isEqualTo(8);
    assertThat(jubiOrderHistroy.getOrderList()[0].getAmountOriginal()).isEqualTo(new BigDecimal(2323));
    assertThat(jubiOrderHistroy.getOrderList()[0].getAmountOutstanding()).isEqualTo(new BigDecimal(223));
    SimpleDateFormat f = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
    f.setTimeZone(TimeZone.getTimeZone("GMT+8"));
    String dateString = f.format(jubiOrderHistroy.getOrderList()[0].getDatetime());
    assertThat(dateString).isEqualTo("2017-07-16 15:48:10");
    System.out.println(jubiOrderHistroy);
  }

  @Test
  public void testFailToFetchJubiOrderHistoryAdapter() throws IOException {
    // Read in the JSON from the example resources
    InputStream is = JubiOrderJsonTest.class.getResourceAsStream("/example-error-response.json");
    // Use Jackson to parse it
    ObjectMapper mapper = new ObjectMapper();
    JubiOrderHistroy jubiOrderHistroy = mapper.readValue(is, JubiOrderHistroy.class);
    assertThat(jubiOrderHistroy.getResult().isSuccess()).isFalse();
    assertThat(jubiOrderHistroy.getResult().getErrorCode()).isEqualTo(105);
    assertThat(jubiOrderHistroy.getOrderList()).isNull();
  }

  @Test
  public void testSuccessToFetchJubiOrderStatusAdapter() throws IOException {
    // Read in the JSON from the example resources
    InputStream is = JubiOrderJsonTest.class.getResourceAsStream("/example-order-status.json");
    // Use Jackson to parse it
    ObjectMapper mapper = new ObjectMapper();
    JubiOrderStatus jubiOrderStatus = mapper.readValue(is, JubiOrderStatus.class);
    //Check jubiOrderStatus
    SimpleDateFormat f = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
    assertThat(jubiOrderStatus.getResult().isSuccess()).isTrue();
    assertThat(jubiOrderStatus.getStatus()).isEqualTo("cancelled");
    assertThat(jubiOrderStatus.getAmountOriginal()).isEqualTo(new BigDecimal(10000));
    f.setTimeZone(TimeZone.getTimeZone("GMT+8"));
    String dateString = f.format(jubiOrderStatus.getDatetime());
    assertThat(dateString).isEqualTo("2017-07-09 18:23:42");
    System.out.println(jubiOrderStatus);
  }

  @Test
  public void testFailToFetchJubiOrderStatusAdapter() throws IOException {
    // Read in the JSON from the example resources
    InputStream is = JubiOrderJsonTest.class.getResourceAsStream("/example-error-response.json");
    // Use Jackson to parse it
    ObjectMapper mapper = new ObjectMapper();
    JubiOrderStatus jubiOrderStatus = mapper.readValue(is, JubiOrderStatus.class);
    //Check jubiOrderStatus
    assertThat(jubiOrderStatus.getResult().isSuccess()).isFalse();
    assertThat(jubiOrderStatus.getResult().getErrorCode()).isEqualTo(105);
  }
}
