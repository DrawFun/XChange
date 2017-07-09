package org.knowm.xchange.jubi.service;

import org.knowm.xchange.service.BaseParamsDigest;
import si.mazi.rescu.RestInvocation;

/**
 * Created by Dzf on 2017/7/8.
 */
public class JubiPostBodyDigest extends BaseParamsDigest {
  private JubiPostBodyDigest(String secretKeyBase64) {
    super(secretKeyBase64, HMAC_SHA_256);
  }

  public static JubiPostBodyDigest createInstance(String secretKeyBase64) {
    return null == secretKeyBase64 ? null : new JubiPostBodyDigest(secretKeyBase64);
  }

  @Override
  public String digestParams(RestInvocation restInvocation) {
    return null;
  }
}
