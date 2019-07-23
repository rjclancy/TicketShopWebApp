package com.ronan.ts.TicketShopWebApp.webapp.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class HomeController {

  /**
   * Returns Home page
   *
   * @param model
   * @return
   */
  @PostMapping("/")
  public String home(final Model model) {
    return "index";
  }
}
