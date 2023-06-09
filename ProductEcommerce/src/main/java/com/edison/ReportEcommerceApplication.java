package com.edison;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.openfeign.EnableFeignClients;

@SpringBootApplication
@EnableFeignClients
public class ReportEcommerceApplication {

	public static void main(String[] args) {
		SpringApplication.run(ReportEcommerceApplication.class, args);
	}

}
