package com.ronan.ts.TicketShopWebApp.webapp.controllers.view;

import com.ronan.ts.TicketShopWebApp.webapp.services.EventService;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.io.IOException;

/**
 * The type Home controller.
 */
@Controller
@AllArgsConstructor
public class HomeController {

  /**
   * The Event service.
   */
  @Autowired
  EventService eventService;

  /**
   * Returns Home page
   *
   * @param model the model
   * @return string
   * @throws IOException the io exception
   */
  @RequestMapping(value = "/", method = RequestMethod.GET)
  public String home(final Model model) throws IOException {
    model.addAttribute("events", eventService.getEvents());
    return "index";
  }

  /**
   * Returns Home page
   *
   * @param model the model
   * @return string
   * @throws IOException the io exception
   */
  @RequestMapping(value = "/event/{id}", method = RequestMethod.GET)
  public String event(final Model model, @PathVariable Long id) throws IOException {
    model.addAttribute("event", eventService.getEvent(id));
    return "event";
  }
}
