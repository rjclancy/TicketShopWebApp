package com.ronan.ts.TicketShopWebApp.webapp.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class HomeController {

  /**
   *  Returns Home page
   * @param model
   * @return
   */
  @PostMapping("/home")
  public String home(Model model) {
    return "index";
  }
}
