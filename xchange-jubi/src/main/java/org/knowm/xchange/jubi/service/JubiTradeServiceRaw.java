package org.knowm.xchange.jubi.service;

import org.knowm.xchange.Exchange;
import org.knowm.xchange.currency.CurrencyPair;
import org.knowm.xchange.jubi.JubiAuthernticated;
import org.knowm.xchange.jubi.dto.trade.JubiOrderHistory;
import si.mazi.rescu.ParamsDigest;
import si.mazi.rescu.RestProxyFactory;

import java.io.IOException;
import java.util.Date;

/**
 * Created by Dzf on 2017/7/16.
 */
public class JubiTradeServiceRaw extends JubiBaseService {
  private final JubiAuthernticated jubiAuthernticated;
  private final ParamsDigest signatureCreator;

  public JubiTradeServiceRaw(Exchange exchange) {
    super(exchange);
    this.jubiAuthernticated = RestProxyFactory.createProxy(JubiAuthernticated.class, exchange.getExchangeSpecification().getSslUri());
    this.signatureCreator = JubiPostBodyDigest.createInstance(exchange.getExchangeSpecification().getSecretKey());
  }

  public JubiOrderHistory getJubiOrderHistory(CurrencyPair currencyPair, Date startTime, String type) throws IOException {
    String coinType = currencyPair != null ? currencyPair.base.getCurrencyCode().toLowerCase() : "";
    long since = startTime != null ? startTime.getTime() : 0;
    return jubiAuthernticated.getOrderHistory(coinType, exchange.getExchangeSpecification().getApiKey(),
            exchange.getNonceFactory(), since, type, signatureCreator);
  }

  public JubiTradeHistoryParams createJubiTradeHistoryParams(CurrencyPair currencyPair) {
    return new JubiTradeHistoryParams(currencyPair, null);
  }

  public JubiTradeHistoryParams createJubiTradeHistoryParams(CurrencyPair currencyPair, Date date) {
    return new JubiTradeHistoryParams(currencyPair, date);
  }
}
