package com.ronan.ts.TicketShopWebApp.webapp.config;

import com.ronan.ts.ticketshopeventpublisher.client.TicketShopEventClientApiUtils;
import com.ronan.ts.ticketshopservice.client.TicketShopServiceClientApiUtils;
import org.modelmapper.ModelMapper;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.mongodb.repository.config.EnableReactiveMongoRepositories;

@Configuration
@EnableReactiveMongoRepositories
public class ApplicationConfig {

  @Bean
  public TicketShopEventClientApiUtils ticketShopEventClientApiUtils(){
    return new TicketShopEventClientApiUtils("http://localhost:8086");
  }

  @Bean
  public TicketShopServiceClientApiUtils ticketShopServiceClientApiUtils(){
    return new TicketShopServiceClientApiUtils("http://localhost:8085");
  }

  @Bean
  public ModelMapper modelMapper() {
    return new ModelMapper();
  }
}
