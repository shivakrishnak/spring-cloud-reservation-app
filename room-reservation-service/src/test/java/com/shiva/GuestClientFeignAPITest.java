package com.shiva;

import com.netflix.loadbalancer.Server;
import com.netflix.loadbalancer.ServerList;
import com.shiva.model.Guest;
import com.shiva.service.GuestClient;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.web.server.LocalServerPort;
import org.springframework.cloud.netflix.ribbon.RibbonClient;
import org.springframework.cloud.netflix.ribbon.StaticServerList;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import static org.assertj.core.api.Assertions.assertThat;

@Disabled
@SpringBootTest(classes = GuestClientFeignAPITest.FeignConfig.class, webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
public class GuestClientFeignAPITest {

    @Autowired
    GuestClient guestClientFeignAPI;


    @Test
    public void testFeign() {
        Guest guest = new Guest(1l, "shiva", "krishna", "test@test.com", "Smile Nagar", "India", "Happylore", "1234567890");
        assertThat(this.guestClientFeignAPI.getAllGuests()).contains(guest);
    }

    @EnableFeignClients(clients = GuestClient.class)
    @RestController
    @Configuration
    @EnableAutoConfiguration
    @RibbonClient(name = "test", configuration = GuestClientFeignAPITest.RibbonConfig.class)
    static class FeignConfig {

        @RequestMapping(value = "hello")
        public String testFeign() {
            return "success";
        }

    }

    @Configuration
    static class RibbonConfig {

        @LocalServerPort
        int port;

        @Bean
        public ServerList<Server> serverList() {
            return new StaticServerList<>(new Server("127.0.0.1", port), new Server("127.0.0.1", port));
        }
    }
}