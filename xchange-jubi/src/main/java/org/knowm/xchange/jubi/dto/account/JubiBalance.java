package org.knowm.xchange.jubi.dto.account;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

import java.math.BigDecimal;

/**
 * Created by Dzf on 2017/7/7.
 */
@JsonIgnoreProperties(ignoreUnknown = true)
public class JubiBalance {
  private final BigDecimal uid;
  private final BigDecimal asset;
  private final BigDecimal cnyBalance;
  private final BigDecimal btcBalance;
  private final BigDecimal cnyLock;
  private final BigDecimal btcLock;
  private final boolean result;
  private final String code;

  public JubiBalance(@JsonProperty("uid") BigDecimal uid,
                     @JsonProperty("asset") BigDecimal asset,
                     @JsonProperty("cny_balance") BigDecimal cnyBalance, @JsonProperty("btc_balance") BigDecimal btcBalance,
                     @JsonProperty("cny_lock") BigDecimal cnyLock, @JsonProperty("btc_lock") BigDecimal btcLock,
                     @JsonProperty("result") boolean result, @JsonProperty("code") String code) {
    this.uid = uid;
    this.asset = asset;
    this.cnyBalance = cnyBalance;
    this.btcBalance = btcBalance;
    this.cnyLock = cnyLock;
    this.btcLock = btcLock;
    this.result = result;
    this.code = code;
  }

  public BigDecimal getUid() { return uid; }

  public BigDecimal getAsset() { return asset; }

  public BigDecimal getCnyBalance() { return cnyBalance; }

  public BigDecimal getBtcBalance() { return btcBalance; }

  public BigDecimal getCnyLock() { return cnyLock; }

  public BigDecimal getBtcLock() { return btcLock; }

  public boolean isResult() { return result; }

  public String getCode() { return code; }

  @Override
  public String toString() {
    return String.format("Balance{uid=%s, asset=%s, cnyBalance=%s, btcBalance=%s, cnyLock=%s, btcLock=%s, result=%b, code=%s}",
            uid, asset, cnyBalance, btcBalance, cnyLock, btcLock, result, code);
  }
}
