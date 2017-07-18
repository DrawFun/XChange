package org.knowm.xchange.jubi.service;

import org.knowm.xchange.Exchange;
import org.knowm.xchange.currency.CurrencyPair;
import org.knowm.xchange.dto.Order;
import org.knowm.xchange.dto.trade.LimitOrder;
import org.knowm.xchange.dto.trade.MarketOrder;
import org.knowm.xchange.dto.trade.OpenOrders;
import org.knowm.xchange.dto.trade.UserTrades;
import org.knowm.xchange.exceptions.ExchangeException;
import org.knowm.xchange.exceptions.NotAvailableFromExchangeException;
import org.knowm.xchange.exceptions.NotYetImplementedForExchangeException;
import org.knowm.xchange.jubi.JubiAdapters;
import org.knowm.xchange.jubi.dto.trade.JubiOrderHistory;
import org.knowm.xchange.service.trade.TradeService;
import org.knowm.xchange.service.trade.params.TradeHistoryParamCurrencyPair;
import org.knowm.xchange.service.trade.params.TradeHistoryParamPaging;
import org.knowm.xchange.service.trade.params.TradeHistoryParams;
import org.knowm.xchange.service.trade.params.TradeHistoryParamsTimeSpan;
import org.knowm.xchange.service.trade.params.orders.OpenOrdersParams;

import java.io.IOException;
import java.util.Collection;
import java.util.Date;

/**
 * Created by Dzf on 2017/7/16.
 */
public class JubiTradeService extends JubiTradeServiceRaw implements TradeService {

  public JubiTradeService(Exchange exchange) {
    super(exchange);
  }

  @Override
  public OpenOrders getOpenOrders() throws IOException {
    throw new NotYetImplementedForExchangeException();
  }

  @Override
  public OpenOrders getOpenOrders(OpenOrdersParams params) throws ExchangeException, IOException {
    throw new NotYetImplementedForExchangeException();
  }

  @Override
  public String placeMarketOrder(MarketOrder marketOrder) throws IOException {
    throw new NotYetImplementedForExchangeException();
  }

  @Override
  public String placeLimitOrder(LimitOrder order) throws IOException {
    throw new NotYetImplementedForExchangeException();
  }

  @Override
  public boolean cancelOrder(String orderId) throws IOException {
    throw new NotYetImplementedForExchangeException();
  }

  /**
   * Required parameter types: {@link TradeHistoryParamPaging#getPageLength()}
   */
  @Override
  public UserTrades getTradeHistory(TradeHistoryParams params) throws IOException {
    CurrencyPair currencyPair = null;
    Date startTime = null;
    if (params instanceof TradeHistoryParamCurrencyPair) {
      currencyPair = ((TradeHistoryParamCurrencyPair) params).getCurrencyPair();
    }
    if (params instanceof TradeHistoryParamsTimeSpan) {
      startTime = ((TradeHistoryParamsTimeSpan) params).getStartTime();
    }
    JubiOrderHistory jubiOrderHistroys = getJubiOrderHistory(currencyPair, startTime, "all");
    return JubiAdapters.adaptUserTrades(jubiOrderHistroys, new CurrencyPair("doge", "cny"));
  }

  @Override
  public TradeHistoryParams createTradeHistoryParams() {
    return new JubiTradeHistoryParams(null, new Date(0));
  }

  @Override
  public OpenOrdersParams createOpenOrdersParams() {
    throw new NotYetImplementedForExchangeException();
  }

  @Override
  public Collection<Order> getOrder(
          String... orderIds) throws ExchangeException, NotAvailableFromExchangeException, NotYetImplementedForExchangeException, IOException {
    throw new NotYetImplementedForExchangeException();
  }

}
