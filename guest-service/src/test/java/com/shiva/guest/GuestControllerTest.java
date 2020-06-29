package com.shiva.guest;

import org.junit.jupiter.api.Test;
import org.springframework.web.client.RestTemplate;

import static org.mockito.Mockito.doReturn;
import static org.mockito.Mockito.mock;

public class GuestControllerTest {

    @Test
    public void getGuests(){
        RestTemplate restTemplate = mock(RestTemplate.class);
        doReturn().when(restTemplate).getForObject(eq("http://localhost:8800/guests"), resp))
    }
}
