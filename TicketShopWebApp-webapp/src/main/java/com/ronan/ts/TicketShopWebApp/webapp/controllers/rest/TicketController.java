package com.ronan.ts.TicketShopWebApp.webapp.controllers.rest;

import com.ronan.ts.TicketShopWebApp.webapp.services.EventService;
import com.ronan.ts.ticketshopeventpublisher.common.PurchaseTicketEvent;
import lombok.AllArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.io.IOException;

@Log4j2
@AllArgsConstructor
@RestController
@RequestMapping("/ticketshop")
public class TicketController {

  @Autowired
  EventService eventService;

  @PostMapping(value = "/purchase", consumes = {MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_JSON_VALUE})
  ResponseEntity<HttpStatus> createEvent(@RequestBody final PurchaseTicketEvent purchaseTicketEvent) throws IOException {
    eventService.sendPurchaseTicketEvent(purchaseTicketEvent);
    return new ResponseEntity<>(HttpStatus.CREATED);
  }
}
