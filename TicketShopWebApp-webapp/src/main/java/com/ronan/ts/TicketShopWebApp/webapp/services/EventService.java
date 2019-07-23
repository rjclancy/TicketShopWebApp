package com.ronan.ts.TicketShopWebApp.webapp.services;

import com.ronan.ts.ticketshopeventpublisher.client.TicketShopEventClientApiUtils;
import com.ronan.ts.ticketshopeventpublisher.common.PurchaseTicketEvent;
import lombok.AllArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import retrofit2.Response;

import java.io.IOException;

@Service
@AllArgsConstructor
@Log4j2
public class EventService {

  @Autowired
  private TicketShopEventClientApiUtils ticketShopEventClientApiUtils;

  @Transactional
  private void sendPurchaseTicketEvent(final PurchaseTicketEvent purchaseTicketEvent) throws IOException {
    log.info("Sending Purchase ticket event...");
    Response<Void> response = ticketShopEventClientApiUtils.sendPurchaseTicketEvent(purchaseTicketEvent).execute();
    if (!response.isSuccessful()) {
      log.error("Something went wrong send event");
    }
    log.error("Successfully sent event");
  }
}
