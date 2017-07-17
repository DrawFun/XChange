package org.knowm.xchange.jubi.dto.trade;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;

/**
 * Created by Dzf on 2017/7/16.
 */
public class JubiTradeResult {
  private final boolean success;
  private final int errorCode;

  @JsonCreator
  public JubiTradeResult(@JsonProperty("result") final boolean result,
                         @JsonProperty("code") final int errorCode) {
    this.success = result;
    this.errorCode = errorCode;
  }

  public boolean isSuccess() {
    return success;
  }

  public int getErrorCode() {
    return errorCode;
  }

  @Override
  public String toString() {
    return String.format("JubiTradeResult{success=%s, errorCode=%s}", success, errorCode);
  }
}
