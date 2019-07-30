package com.ronan.ts.TicketShopWebApp.webapp.services;

import com.ronan.ts.ticketshopeventpublisher.client.TicketShopEventClientApiUtils;
import com.ronan.ts.ticketshopeventpublisher.common.PurchaseTicketEvent;
import com.ronan.ts.ticketshopservice.client.TicketShopServiceClientApiUtils;
import com.ronan.ts.ticketshopservice.web.common.dtos.EventDto;
import lombok.AllArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import retrofit2.Response;

import java.io.IOException;
import java.util.List;

@Service
@AllArgsConstructor
@Log4j2
public class EventService {

  @Autowired
  private TicketShopEventClientApiUtils ticketShopEventClientApiUtils;

  @Autowired
  private TicketShopServiceClientApiUtils ticketShopServiceClientApiUtils;

  @Transactional
  public void sendPurchaseTicketEvent(final PurchaseTicketEvent purchaseTicketEvent) throws IOException {
    log.info("Sending Purchase ticket event...");
    Response<Void> response = ticketShopEventClientApiUtils.sendPurchaseTicketEvent(purchaseTicketEvent).execute();
    if (!response.isSuccessful()) {
      log.error("Something went wrong send event");
    }
    log.info("Successfully sent event");
  }

  public List<EventDto> getEvents() throws IOException {
    log.info("Getting ticket events...");
    Response<List<EventDto>> response = ticketShopServiceClientApiUtils.getEvents().execute();
    if (!response.isSuccessful()) {
      log.error("Something went wrong getting events");
    }
    log.info("Successfully retrieved event");
    return response.body();
  }
}