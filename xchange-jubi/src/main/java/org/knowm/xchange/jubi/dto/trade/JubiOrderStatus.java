package org.knowm.xchange.jubi.dto.trade;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.math.BigDecimal;
import java.util.Date;

/**
 * Created by Dzf on 2017/7/16.
 */
public class JubiOrderStatus {
  @JsonProperty("status")
  private final String status;
  @JsonProperty("avg_price")
  private final BigDecimal avgPrice;
  private final JubiTradeResult result;
  private final JubiOrder order;
  private final static ObjectMapper mapper = new ObjectMapper();

  @JsonCreator
  public JubiOrderStatus(JsonNode jsonNode) {
    if (jsonNode.has("result")) {
      this.result = mapper.convertValue(jsonNode, JubiTradeResult.class);
      this.status = null;
      this.avgPrice = null;
      this.order = null;
    } else {
      this.result = new JubiTradeResult(true, 0, null);
      this.status = jsonNode.get("status").asText();
      this.avgPrice = new BigDecimal(jsonNode.get("avg_price").asDouble());
      this.order = mapper.convertValue(jsonNode, JubiOrder.class);
    }
  }

  public JubiTradeResult getResult() {
    return result;
  }

  public String getStatus() {
    return status;
  }

  public BigDecimal getAvgPrice() {
    return avgPrice;
  }

  public String getId() {
    return this.order != null ? this.order.getId() : null;
  }

  public Date getDatetime() {
    return this.order != null ? this.order.getDatetime() : null;
  }

  public int getType() {
    return this.order != null ? this.order.getType() : -1;
  }

  public BigDecimal getPrice() {
    return this.order != null ? this.order.getPrice() : null;
  }

  public BigDecimal getAmountOriginal() {
    return this.order != null ? this.order.getAmountOriginal() : null;
  }

  public BigDecimal getAmountOutstanding() {
    return this.order != null ? this.order.getAmountOutstanding() : null;
  }
  @Override
  public String toString() {
    return String.format("JubiOrderStatus{status=%s, avg_price=%s, %s}",
            status, avgPrice, super.toString());
  }
}
