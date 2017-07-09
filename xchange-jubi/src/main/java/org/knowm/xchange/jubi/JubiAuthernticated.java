package org.knowm.xchange.jubi;

import org.knowm.xchange.jubi.dto.account.JubiBalance;
import si.mazi.rescu.ParamsDigest;
import si.mazi.rescu.SynchronizedValueFactory;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import java.io.IOException;

/**
 * Created by Dzf on 2017/7/8.
 */
@Path("api/v1")
@Consumes(MediaType.APPLICATION_FORM_URLENCODED)
@Produces(MediaType.APPLICATION_JSON)
public interface JubiAuthernticated {
  @POST
  @Path("balance")
  JubiBalance getBalance(@FormParam("key") String apiKey, @FormParam("signature") ParamsDigest signature,
                         @FormParam("nonce")SynchronizedValueFactory<Long> nonce) throws IOException;
}
