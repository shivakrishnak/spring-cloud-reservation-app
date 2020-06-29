//package com.shiva.guest;
//
//import org.junit.Test;
//import org.junit.runner.RunWith;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.boot.test.context.SpringBootTest;
//import org.springframework.boot.test.web.client.TestRestTemplate;
//import org.springframework.test.context.TestPropertySource;
//import org.springframework.test.context.junit4.SpringRunner;
//
//import static org.junit.Assert.assertEquals;
//import static org.junit.Assert.assertSame;
//import static org.junit.jupiter.api.Assertions.assertEquals;
//
//@RunWith(SpringRunner.class)
//@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT, properties = {"spring.cloud.config.enabled:false"})
//@TestPropertySource(locations = "classpath:test.properties")
//public class GuestsApplicationTests {
//
//	@Autowired
//	private TestRestTemplate rest;
//
//	@Test
//	public void contextLoads() {
//		String name = rest.getForObject("/home", String.class);
//		assertSame("home",name);
//	}
//
//}