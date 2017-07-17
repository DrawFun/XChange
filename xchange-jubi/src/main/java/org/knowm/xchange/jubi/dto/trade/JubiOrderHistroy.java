package org.knowm.xchange.jubi.dto.trade;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.knowm.xchange.exceptions.NotAvailableFromExchangeException;

/**
 * Created by Dzf on 2017/7/17.
 */
public class JubiOrderHistroy {
  private final JubiTradeResult result;
  private final JubiOrder[] orderList;
  private final static ObjectMapper mapper = new ObjectMapper();

  @JsonCreator
  public JubiOrderHistroy(JsonNode jsonNode) {
    if (jsonNode.isObject()) {
      this.orderList = null;
      this.result = mapper.convertValue(jsonNode, JubiTradeResult.class);
    } else if (jsonNode.isArray()){
      this.orderList = mapper.convertValue(jsonNode, JubiOrder[].class);
      this.result = new JubiTradeResult(true, 0, null);
    } else {
      throw new NotAvailableFromExchangeException();
    }
  }

  public JubiTradeResult getResult() {
    return result;
  }

  public JubiOrder[] getOrderList() {
    return orderList;
  }

  @Override
  public String toString() {
    String res = String.format("JubiOrderHistroy{result=%s}", result);
    for (JubiOrder jubiOrder : orderList) {
      System.out.println(jubiOrder);
    }
    return res;
  }
}
